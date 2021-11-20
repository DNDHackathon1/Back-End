package ac.dnd.hackathonbackend.domain.party.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PartyDTO {
    private Long partyId;
    private Long userId;
    private String title;
    private String contents;
    private Integer goalTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public PartyDTO(Long partyId, Long userId, String title, String contents, Integer goalTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.partyId = partyId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.goalTime = goalTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
