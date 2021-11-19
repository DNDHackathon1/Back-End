package ac.dnd.hackathonbackend.domain.user.model;

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
public class SignUpDto {

    @ApiModelProperty(value = "아이디(중복안됨)", example = "jinseong")
    String identity;

    @ApiModelProperty(value = "비밀번호", example = "password")
    String password;

    @ApiModelProperty(value = "닉네임", example = "핫식스더킹")
    String nickname;

    @ApiModelProperty(value = "목표시간", example = "1")
    Integer goalTime;

    @ApiModelProperty(value = "프로필 이미지 URL", example = "https://xxx.png")
    String profileImageUrl;

    public UserEntity toEntity() {
        return UserEntity.builder()
            .identity(this.identity)
            .password(this.password)
            .nickname(this.nickname)
            .goalTime(this.goalTime)
            .profileImageUrl(this.profileImageUrl)
            .build();
    }
}
