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
public class SignInDto {

    @ApiModelProperty(value = "아이디(중복안됨)", example = "jinseong")
    String identity;

    @ApiModelProperty(value = "비밀번호", example = "password")
    String password;
}

