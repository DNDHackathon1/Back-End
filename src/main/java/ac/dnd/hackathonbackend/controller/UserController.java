package ac.dnd.hackathonbackend.controller;

import ac.dnd.hackathonbackend.domain.user.model.SignInDto;
import ac.dnd.hackathonbackend.domain.user.model.SignUpDto;
import ac.dnd.hackathonbackend.domain.user.model.UserIdentityDto;
import ac.dnd.hackathonbackend.domain.user.service.UserService;
import ac.dnd.hackathonbackend.util.Message;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation("회원가입")
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody @Valid SignUpDto dto) {
        try {
            return new ResponseEntity(new Message(userService.signUp(dto), "회원가입 성공"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Message(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("로그인")
    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody @Valid SignInDto dto) {
        try {
            return new ResponseEntity(new Message(userService.signIn(dto), "로그인 성공"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Message(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("아이디 중복 검사")
    @PostMapping("/check/identity")
    public ResponseEntity checkIdentity(@RequestBody @Valid UserIdentityDto dto) {
        final Boolean result = userService.checkIdentity(dto);
        try {
            if (result) {
                return new ResponseEntity(new Message(result, "사용 가능한 아이디"), HttpStatus.OK);
            }
            return new ResponseEntity(new Message(result, "이미 존재하는 아이디"), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(new Message(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
