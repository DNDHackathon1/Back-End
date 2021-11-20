package ac.dnd.hackathonbackend.domain.participant.model;

import ac.dnd.hackathonbackend.persistence.entity.ParticipantEntity;
import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ParticipantSaveDTO {
    private List<ParticipantReadDTO> participantReadDTOS;
    private Long partyId;

    public ParticipantSaveDTO(List<ParticipantEntity> participantEntities, PartyEntity partyEntity) {
        this.participantReadDTOS = participantEntities.stream().map(ParticipantReadDTO::fromEntity).collect(Collectors.toList());
        this.partyId = partyEntity.getId();
    }
}
