package ac.dnd.hackathonbackend.domain.reply.model;

import java.util.List;
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
public class RepliesDto {

    List<ReplyInPartyDto> replyList;
}
