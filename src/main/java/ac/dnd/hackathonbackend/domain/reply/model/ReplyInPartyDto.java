package ac.dnd.hackathonbackend.domain.reply.model;

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
public class ReplyInPartyDto {

    @ApiModelProperty(value = "사용자 PK")
    private Long userId;

    @ApiModelProperty(value = "오늘도 열심히 운동해보자구요~ 파이팅~!")
    private String contents;
}
