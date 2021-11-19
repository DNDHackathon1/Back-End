package ac.dnd.hackathonbackend.domain.party.service;

import ac.dnd.hackathonbackend.domain.party.model.PartiesDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveDTO;
import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import ac.dnd.hackathonbackend.persistence.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService{

    private final PartyRepository partyRepository;

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

        if(party.getEndTime().isBefore(party.getStartTime())) {
            throw new IllegalArgumentException("시작 시간이 종료 시간보다 뒤에 있을 때의 에러");
        }
        return new PartySaveDTO(partyRepository.save(partyEntity).getId());
    }

    @Override
    public PartiesDTO getListByActive() {
        List<PartyEntity> parties = partyRepository.findAllByActive(true);
        return new PartiesDTO(parties);
    }

    @Override
    public PartiesDTO getListByNotActive() {
        List<PartyEntity> parties = partyRepository.findAllByActive(false);
        return new PartiesDTO(parties);
    }
}
