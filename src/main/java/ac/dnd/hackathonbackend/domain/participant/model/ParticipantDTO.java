package ac.dnd.hackathonbackend.domain.participant.model;

import lombok.Getter;

@Getter
public class ParticipantDTO {
    private Long userId;
    private Long partyId;

    public ParticipantDTO(Long userId, Long partyId) {
        this.userId = userId;
        this.partyId = partyId;
    }
}
