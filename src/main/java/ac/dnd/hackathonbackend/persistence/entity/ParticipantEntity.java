package ac.dnd.hackathonbackend.persistence.entity;

import ac.dnd.hackathonbackend.domain.user.model.UserRole;
import ac.dnd.hackathonbackend.persistence.BaseEntity;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_participant")
@AttributeOverride(name = "id", column = @Column(name = "participant_id"))
@Entity
public class ParticipantEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private PartyEntity party;

    @Builder
    public ParticipantEntity(UserRole role, UserEntity user, PartyEntity party) {
        this.role = role;
        this.user = user;
        this.party = party;
    }
}
