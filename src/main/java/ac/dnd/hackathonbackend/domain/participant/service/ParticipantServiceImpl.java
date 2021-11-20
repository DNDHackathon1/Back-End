package ac.dnd.hackathonbackend.domain.participant.service;

import ac.dnd.hackathonbackend.domain.participant.model.ParticipantDTO;
import ac.dnd.hackathonbackend.domain.participant.model.ParticipantSaveDTO;
import ac.dnd.hackathonbackend.domain.user.model.UserRole;
import ac.dnd.hackathonbackend.persistence.entity.ParticipantEntity;
import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import ac.dnd.hackathonbackend.persistence.entity.UserEntity;
import ac.dnd.hackathonbackend.persistence.repository.ParticipantRepository;
import ac.dnd.hackathonbackend.persistence.repository.PartyRepository;
import ac.dnd.hackathonbackend.persistence.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final UserRepository userRepository;
    private final PartyRepository partyRepository;

    @Transactional
    @Override
    public ParticipantSaveDTO save(ParticipantDTO participantDTO) {
        final UserEntity userEntity = userRepository.findById(participantDTO.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        final PartyEntity partyEntity = partyRepository.findById(participantDTO.getPartyId())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 방입니다."));

        ParticipantEntity participantEntity = ParticipantEntity.builder()
                .role(participantDTO.getRole())
                .user(userEntity)
                .party(partyEntity)
                .build();

        participantRepository.save(participantEntity);
        List<ParticipantEntity> participantEntities = participantRepository.findAllByParty(partyEntity);
        return new ParticipantSaveDTO(participantEntities, partyEntity);
    }

    @Override
    @Transactional
    public ParticipantDTO delete(ParticipantDTO participantDTO) {
        final UserEntity userEntity = userRepository.findById(participantDTO.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        final PartyEntity partyEntity = partyRepository.findById(participantDTO.getPartyId())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 방입니다."));

        if (participantDTO.getRole() == UserRole.OWNER) {
            participantRepository.deleteAllByParty(partyEntity);
            partyRepository.delete(partyEntity);
        } else if (participantDTO.getRole() == UserRole.USER) {
            participantRepository.deleteByUserIdAndPartyId(userEntity.getId(), partyEntity.getId());
        } else {
            throw new IllegalArgumentException("유효하지 않은 UserRole 입니다.");
        }
        return participantDTO;
    }
}
