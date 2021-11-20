package ac.dnd.hackathonbackend.controller;

import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.service.PartyService;
import ac.dnd.hackathonbackend.domain.user.model.UserGoalDto;
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
@RequestMapping("/api/party")
@RestController
public class PartyController {

    private final PartyService partyService;

    @ApiOperation("파티 생성")
    @PostMapping("/")
    public ResponseEntity save(@RequestBody PartyDTO party) {
        try{
            return new ResponseEntity(new Message(partyService.save(party), "party 생성 성공"), HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("참여 가능 파티 리스트 가져오기")
    @GetMapping("/")
    public ResponseEntity getPartiesByActive(@RequestBody @Valid UserGoalDto dto) {
        try{
            return new ResponseEntity(new Message(partyService.getListByActive(dto), "참여 가능 party List 가져오기 성공"), HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("참여 불가능 가티 리스트 가져오기")
    @GetMapping("/not")
    public ResponseEntity getPartiesByNotActzive() {
        try{
            return new ResponseEntity(new Message(partyService.getListByNotActive(), "참여 불가능 party List 가져오기 성공"), HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity(new Message(null, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
