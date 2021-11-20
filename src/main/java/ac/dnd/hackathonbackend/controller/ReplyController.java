package ac.dnd.hackathonbackend.controller;

import ac.dnd.hackathonbackend.domain.party.model.PartyIdDto;
import ac.dnd.hackathonbackend.domain.reply.model.ReplyDto;
import ac.dnd.hackathonbackend.domain.reply.service.ReplyService;
import ac.dnd.hackathonbackend.util.Message;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/reply")
@RestController
public class ReplyController {

    private final ReplyService replyService;

    @ApiOperation("댓글 등록")
    @PostMapping
    public ResponseEntity createReply(@RequestBody @Valid ReplyDto dto) {
        try {
            return new ResponseEntity(new Message(replyService.create(dto), "댓글 등록 성공"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Message(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("댓글 조회")
    @GetMapping
    public ResponseEntity readReply(@RequestBody @Valid PartyIdDto dto) {
        try {
            return new ResponseEntity(new Message(replyService.get(dto), "댓글 조회 성공"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Message(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
