package ac.dnd.hackathonbackend.persistence.entity;

import ac.dnd.hackathonbackend.persistence.BaseEntity;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_reply")
@AttributeOverride(name = "id", column = @Column(name = "reply_id"))
@Entity
public class ReplyEntity extends BaseEntity {

    @Column(length = 500)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private PartyEntity party;

    @Builder
    public ReplyEntity(String contents, UserEntity user, PartyEntity party) {
        this.contents = contents;
        this.user = user;
        this.party = party;
    }
}
