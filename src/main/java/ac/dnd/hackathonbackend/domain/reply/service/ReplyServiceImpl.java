package ac.dnd.hackathonbackend.domain.reply.service;

import ac.dnd.hackathonbackend.domain.party.model.PartyIdDto;
import ac.dnd.hackathonbackend.domain.reply.model.RepliesDto;
import ac.dnd.hackathonbackend.domain.reply.model.ReplyDto;
import ac.dnd.hackathonbackend.domain.reply.model.ReplyInPartyDto;
import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import ac.dnd.hackathonbackend.persistence.entity.ReplyEntity;
import ac.dnd.hackathonbackend.persistence.entity.UserEntity;
import ac.dnd.hackathonbackend.persistence.repository.PartyRepository;
import ac.dnd.hackathonbackend.persistence.repository.ReplyRepository;
import ac.dnd.hackathonbackend.persistence.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ReplyServiceImpl implements ReplyService {

    private final UserRepository userRepository;
    private final PartyRepository partyRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    @Override
    public ReplyDto create(ReplyDto dto) {
        final UserEntity userEntity = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("해당하는 사용자를 찾을 수 없습니다."));
        final PartyEntity partyEntity = partyRepository.findById(dto.getPartyId())
            .orElseThrow(() -> new IllegalArgumentException("해당하는 방(파티)을 찾을 수 없습니다."));
        replyRepository.save(
            dto.toEntity(userEntity, partyEntity, dto.getContents())
        );
        return dto;
    }

    @Override
    public RepliesDto get(PartyIdDto dto) {
        final PartyEntity partyEntity = partyRepository.findById(dto.getPartyId())
            .orElseThrow(() -> new IllegalArgumentException("해당하는 방(파티)을 찾을 수 없습니다."));
        final List<ReplyEntity> replies = replyRepository.findAllByParty(partyEntity);
        return RepliesDto.builder()
            .replyList(
                replies.stream()
                    .map(reply -> ReplyInPartyDto.builder()
                        .userId(reply.getUser().getId())
                        .contents(reply.getContents())
                        .build())
                    .collect(Collectors.toList())
            )
            .build();
    }
}
