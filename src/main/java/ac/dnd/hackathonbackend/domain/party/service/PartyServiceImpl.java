package ac.dnd.hackathonbackend.domain.party.service;

import ac.dnd.hackathonbackend.domain.participant.model.ParticipantDTO;
import ac.dnd.hackathonbackend.domain.participant.service.ParticipantService;
import ac.dnd.hackathonbackend.domain.party.model.PartiesDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveDTO;
import ac.dnd.hackathonbackend.domain.user.model.UserGoalDto;
import ac.dnd.hackathonbackend.domain.user.model.UserRole;
import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import ac.dnd.hackathonbackend.persistence.repository.PartyRepository;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;
    private final ParticipantService participantService;

    @Transactional
    @Override
    public PartySaveDTO save(PartyDTO party) {
        PartyEntity partyEntity = PartyEntity.builder()
                .title(party.getTitle())
                .contents(party.getContents())
                .goalTime(party.getGoalTime())
                .startTime(party.getStartTime())
                .endTime(party.getEndTime())
                .active(true)
                .build();

        if (party.getEndTime().isBefore(party.getStartTime())) {
            throw new IllegalArgumentException("시작 시간이 종료 시간보다 뒤에 있을 때의 에러");
        }

        ParticipantDTO participantDTO = new ParticipantDTO(
                UserRole.OWNER,
                party.getUserId(),
                party.getId()
        );
        participantService.save(participantDTO);
        return new PartySaveDTO(partyRepository.save(partyEntity).getId());
    }

    @Override
    public PartiesDTO getListByActive(UserGoalDto dto) {
        List<PartyEntity> parties = partyRepository.findAllByActive(true);
        // 1. 시작 시간 기준이 최우선
        // 2. 시작 시간 같다면 목표치 차이가 크지 않은 방이 우선 노출
        parties.sort((prev, next) -> {
            int prevDiff = Math.abs(dto.getGoalTime() - prev.getGoalTime());
            int nextDiff = Math.abs(dto.getGoalTime() - next.getGoalTime());
            if (prev.getStartTime().equals(next.getStartTime())) {
                return prevDiff < nextDiff ? -1 : 1;
            }
            return prev.getStartTime().isBefore(next.getStartTime()) ? -1 : 1;
        });
        // 현재 시간 이후에 참여할 수 있는 방만 필터링
        return new PartiesDTO(parties.stream()
                .filter(party -> party.getStartTime().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList()));
    }

    @Override
    public PartiesDTO getListByNotActive() {
        List<PartyEntity> parties = partyRepository.findAllByActive(false);
        Collections.reverse(parties);
        return new PartiesDTO(parties);
    }
}
