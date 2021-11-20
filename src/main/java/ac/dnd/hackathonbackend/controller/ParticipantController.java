package ac.dnd.hackathonbackend.controller;

import ac.dnd.hackathonbackend.domain.participant.model.ParticipantDTO;
import ac.dnd.hackathonbackend.domain.participant.service.ParticipantService;
import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.util.Message;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/participant")
@RestController
public class ParticipantController {

    private final ParticipantService participantService;

    @ApiOperation("파티 참가")
    @PostMapping("/")
    public ResponseEntity save(@RequestBody ParticipantDTO participantDTO) {
        try{
            return new ResponseEntity(new Message(participantService.save(participantDTO), "party 생성 성공"), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("파티 나가기")
    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody ParticipantDTO participantDTO) {
        try{
            return new ResponseEntity(new Message(participantService.delete(participantDTO), "party 나가기 성공"), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
