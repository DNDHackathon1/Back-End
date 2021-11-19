package ac.dnd.hackathonbackend.persistence.entity;

import ac.dnd.hackathonbackend.persistence.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_party")
@AttributeOverride(name = "id", column = @Column(name = "party_id"))
@Entity
public class PartyEntity extends BaseEntity {

    @NotBlank
    private String title;

    @NotBlank
    @Column(length = 1_000)
    private String contents;

    @NotNull
    @Column(name = "goal_time")
    private Integer goalTime;

    @NotNull
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm", timezone = "Asia/Seoul")
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @NotNull
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm", timezone = "Asia/Seoul")
    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(columnDefinition = "boolean default true")
    @NotNull
    private Boolean active = true;

    @Builder
    public PartyEntity(String title, String contents, Integer goalTime, LocalDateTime startTime, LocalDateTime endTime, Boolean active) {
        this.title = title;
        this.contents = contents;
        this.goalTime = goalTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.active = active;
    }
}
