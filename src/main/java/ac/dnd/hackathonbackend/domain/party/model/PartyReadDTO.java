package ac.dnd.hackathonbackend.domain.party.model;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PartyReadDTO {
    private Long id;
    private String title;
    private String contents;
    private Integer goalTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public PartyReadDTO(Long id, String title, String contents, Integer goalTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.goalTime = goalTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static PartyReadDTO fromEntity(PartyEntity partyEntity) {
        return new PartyReadDTO(
                partyEntity.getId(),
                partyEntity.getTitle(),
                partyEntity.getContents(),
                partyEntity.getGoalTime(),
                partyEntity.getStartTime(),
                partyEntity.getEndTime()
        );
    }
}
