package ac.dnd.hackathonbackend.controller;

import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveDTO;
import ac.dnd.hackathonbackend.domain.party.service.PartyService;
import ac.dnd.hackathonbackend.util.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/party")
@RestController
public class PartyController {

    private final PartyService partyService;

    @PostMapping("/")
    public ResponseEntity save(@RequestBody PartyDTO party) {
        try{
            PartySaveDTO partySaveDTO = new PartySaveDTO(partyService.save(party));
            return new ResponseEntity(new Message(partySaveDTO, "party 생성 성공"), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
