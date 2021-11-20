package ac.dnd.hackathonbackend.domain.participant.model;

import ac.dnd.hackathonbackend.persistence.entity.ParticipantEntity;
import lombok.Getter;

@Getter
public class ParticipantReadDTO {
    Long userId;
    String profileImageUrl;

    public ParticipantReadDTO(Long userId, String profileImageUrl) {
        this.userId = userId;
        this.profileImageUrl = profileImageUrl;
    }

    public static ParticipantReadDTO fromEntity(ParticipantEntity participantEntity) {
        return new ParticipantReadDTO(
                participantEntity.getId(),
                participantEntity.getUser().getProfileImageUrl()
        );
    }
}
