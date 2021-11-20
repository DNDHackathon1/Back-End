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
import java.util.Optional;
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
        Optional<UserEntity> user = userRepository.findById(participantDTO.getUserId());
        Optional<PartyEntity> partyEntity = partyRepository.findById(participantDTO.getPartyId());

        if(user.isEmpty() || partyEntity.isEmpty()){
            throw new IllegalArgumentException();
        }

        ParticipantEntity participantEntity = ParticipantEntity.builder()
                .role(participantDTO.getRole())
                .user(user.get())
                .party(partyEntity.get())
                .build();

        participantRepository.save(participantEntity);
        List<ParticipantEntity> participantEntities = participantRepository.findAllByParty(partyEntity.get());
        return new ParticipantSaveDTO(participantEntities, partyEntity.get());
    }

    @Override
    @Transactional
    public ParticipantDTO delete(ParticipantDTO participantDTO) {
        Optional<PartyEntity> party = partyRepository.findById(participantDTO.getPartyId());
        Optional<UserEntity> user = userRepository.findById(participantDTO.getUserId());

        if (user.isEmpty() || party.isEmpty()){
            throw new IllegalArgumentException("party 또는 user의 정보가 올바르지 않습니다.");
        }

        if (participantDTO.getRole() == UserRole.OWNER) {
            participantRepository.deleteAllByParty(party.get());
            partyRepository.delete(party.get());
        } else if (participantDTO.getRole() == UserRole.USER) {
            participantRepository.deleteByUserIdAndPartyId(user.get().getId(), party.get().getId());
        } else {
            throw new IllegalArgumentException("유효하지 않은 UserRole 입니다.");
        }
        return participantDTO;
    }
}
