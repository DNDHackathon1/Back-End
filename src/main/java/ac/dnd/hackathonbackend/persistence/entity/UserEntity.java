package ac.dnd.hackathonbackend.persistence.entity;

import ac.dnd.hackathonbackend.persistence.BaseEntity;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
    name = "tbl_user",
    uniqueConstraints = @UniqueConstraint(name = "user_identity_unique", columnNames = "identity")
)
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@Entity
public class UserEntity extends BaseEntity {

    @NotNull
    private String identity;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    @NotNull
    @Column(name = "goal_time")
    private Integer goalTime;

    @NotBlank
    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Builder
    public UserEntity(String identity, String password, String nickname, Integer goalTime, String profileImageUrl) {
        this.identity = identity;
        this.password = password;
        this.nickname = nickname;
        this.goalTime = goalTime;
        this.profileImageUrl = profileImageUrl;
    }
}
