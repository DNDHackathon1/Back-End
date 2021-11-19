package ac.dnd.hackathonbackend.domain.participant.model;

import ac.dnd.hackathonbackend.domain.user.model.UserRole;
import lombok.Getter;

@Getter
public class ParticipantDTO {
    private UserRole role;
    private Long userId;
    private Long partyId;

    public ParticipantDTO(UserRole role, Long userId, Long partyId) {
        this.role = role;
        this.userId = userId;
        this.partyId = partyId;
    }
}
