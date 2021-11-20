package ac.dnd.hackathonbackend.domain.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGoalDto {

    @ApiModelProperty(value = "목표시간", example = "1")
    private Integer goalTime;
}
