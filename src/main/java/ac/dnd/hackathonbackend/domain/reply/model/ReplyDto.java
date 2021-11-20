package ac.dnd.hackathonbackend.domain.reply.model;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import ac.dnd.hackathonbackend.persistence.entity.ReplyEntity;
import ac.dnd.hackathonbackend.persistence.entity.UserEntity;
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
public class ReplyDto {

    @ApiModelProperty(value = "사용자 PK")
    private Long userId;

    @ApiModelProperty(value = "방(파티) PK")
    private Long partyId;

    @ApiModelProperty(value = "오늘도 열심히 운동해보자구요~ 파이팅~!")
    private String contents;

    public ReplyEntity toEntity(UserEntity user, PartyEntity party, String contents) {
        return ReplyEntity.builder()
            .user(user)
            .party(party)
            .contents(contents)
            .build();
    }
}
