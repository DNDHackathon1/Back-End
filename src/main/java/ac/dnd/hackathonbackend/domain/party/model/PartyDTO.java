package ac.dnd.hackathonbackend.domain.party.model;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PartyDTO {
    private Long id;
    private Long userId;
    private String title;
    private String contents;
    private Integer goalTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public PartyDTO(Long id, Long userId, String title, String contents, Integer goalTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.goalTime = goalTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
