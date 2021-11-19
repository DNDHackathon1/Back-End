package ac.dnd.hackathonbackend.domain.user.service;

import ac.dnd.hackathonbackend.domain.user.model.SignInDto;
import ac.dnd.hackathonbackend.domain.user.model.SignUpDto;
import ac.dnd.hackathonbackend.domain.user.model.UserIdentityDto;
import ac.dnd.hackathonbackend.domain.user.model.UserReadDto;

public interface UserService {

    UserReadDto signUp(SignUpDto dto);

    UserReadDto signIn(SignInDto dto);

    Boolean checkIdentity(UserIdentityDto dto);
}
