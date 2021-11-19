package ac.dnd.hackathonbackend.domain.user.service;

import ac.dnd.hackathonbackend.domain.user.model.SignInDto;
import ac.dnd.hackathonbackend.domain.user.model.SignUpDto;
import ac.dnd.hackathonbackend.domain.user.model.UserIdentityDto;
import ac.dnd.hackathonbackend.domain.user.model.UserReadDto;
import ac.dnd.hackathonbackend.persistence.entity.UserEntity;
import ac.dnd.hackathonbackend.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserReadDto signUp(SignUpDto dto) {
        // 중복된 identity 로 회원가입 요청이 들어온 경우
        if (userRepository.findByIdentity(dto.getIdentity()).isPresent()) {
            log.error("회원가입 실패 : {}", dto);
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        final UserEntity savedUserEntity = userRepository.save(dto.toEntity());
        log.info("회원가입 성공 : {}", dto);

        return UserReadDto.builder()
            .userId(savedUserEntity.getId())
            .identity(savedUserEntity.getIdentity())
            .nickname(savedUserEntity.getNickname())
            .goalTime(savedUserEntity.getGoalTime())
            .profileImageUrl(savedUserEntity.getProfileImageUrl())
            .build();
    }

    @Override
    public UserReadDto signIn(SignInDto dto) {
        final UserEntity userEntity = userRepository.findByIdentity(dto.getIdentity())
            .orElseThrow(() -> {
                log.error("아이디 존재하지 않음 : {}", dto);
                return new IllegalArgumentException("존재하지 않는 아이디입니다.");
            });
        if (Boolean.FALSE.equals(userEntity.getPassword().equals(dto.getPassword()))) {
            log.error("비밀번호 불일치 : {}", dto);
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
        log.info("로그인 성공 : {}", dto);

        return UserReadDto.builder()
            .userId(userEntity.getId())
            .identity(userEntity.getIdentity())
            .nickname(userEntity.getNickname())
            .goalTime(userEntity.getGoalTime())
            .profileImageUrl(userEntity.getProfileImageUrl())
            .build();
    }

    @Override
    public Boolean checkIdentity(UserIdentityDto dto) {
        return !userRepository.existsByIdentity(dto.getIdentity());
    }
}
