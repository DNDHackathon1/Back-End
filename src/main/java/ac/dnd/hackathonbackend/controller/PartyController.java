package ac.dnd.hackathonbackend.controller;

import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveDTO;
import ac.dnd.hackathonbackend.domain.party.service.PartyService;
import ac.dnd.hackathonbackend.util.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/party")
@RestController
public class PartyController {

    private final PartyService partyService;

    @PostMapping("/")
    public ResponseEntity save(@RequestBody PartyDTO party) {
        try{
            return new ResponseEntity(new Message(partyService.save(party), "party 생성 성공"), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity getPartiesByActive() {
        try{
            return new ResponseEntity(new Message(partyService.getListByActive(), "참여 가능 party List 가져오기 성공"), HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/not")
    public ResponseEntity getPartiesByNotActive() {
        try{
            return new ResponseEntity(new Message(partyService.getListByNotActive(), "참여 불가능 party List 가져오기 성공"), HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
