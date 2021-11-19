package ac.dnd.hackathonbackend.domain.participant.service;

import ac.dnd.hackathonbackend.domain.participant.model.ParticipantDTO;
import ac.dnd.hackathonbackend.domain.participant.model.ParticipantReadDTO;
import ac.dnd.hackathonbackend.domain.participant.model.ParticipantSaveDTO;
import ac.dnd.hackathonbackend.persistence.entity.ParticipantEntity;
import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import ac.dnd.hackathonbackend.persistence.entity.UserEntity;
import ac.dnd.hackathonbackend.persistence.repository.ParticipantRepository;
import ac.dnd.hackathonbackend.persistence.repository.PartyRepository;
import ac.dnd.hackathonbackend.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final UserRepository userRepository;
    private final PartyRepository partyRepository;

    @Override
    public ParticipantSaveDTO save(ParticipantDTO participantDTO) {
        Optional<UserEntity> user = userRepository.findById(participantDTO.getUserId());
        Optional<PartyEntity> partyEntity = partyRepository.findById(participantDTO.getPartyId());

        if(user.isEmpty() || partyEntity.isEmpty()){
            throw new IllegalArgumentException();
        }

        ParticipantEntity participantEntity = ParticipantEntity.builder()
                .user(user.get())
                .party(partyEntity.get())
                .build();

        List<ParticipantEntity> participantEntities = participantRepository.findAllByParty(partyEntity.get());
        participantRepository.save(participantEntity);

        return new ParticipantSaveDTO(participantEntities, partyEntity.get());
    }
}
