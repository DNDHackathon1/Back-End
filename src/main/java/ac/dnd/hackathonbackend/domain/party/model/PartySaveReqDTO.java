package ac.dnd.hackathonbackend.domain.party.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PartySaveReqDTO {
    private Long userId;
    private String title;
    private String contents;
    private Integer goalTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Builder
    public PartySaveReqDTO(Long userId, String title, String contents, Integer goalTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.goalTime = goalTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
