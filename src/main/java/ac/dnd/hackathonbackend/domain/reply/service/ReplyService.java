package ac.dnd.hackathonbackend.domain.reply.service;

import ac.dnd.hackathonbackend.domain.party.model.PartyIdDto;
import ac.dnd.hackathonbackend.domain.reply.model.RepliesDto;
import ac.dnd.hackathonbackend.domain.reply.model.ReplyDto;

public interface ReplyService {

    ReplyDto create(ReplyDto dto);

    RepliesDto get(PartyIdDto dto);
}
