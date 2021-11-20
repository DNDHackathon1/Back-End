package ac.dnd.hackathonbackend.domain.party.service;

import ac.dnd.hackathonbackend.domain.party.model.PartiesDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveDTO;
import ac.dnd.hackathonbackend.domain.user.model.UserGoalDto;

public interface PartyService {
    PartySaveDTO save(PartyDTO party);
    PartiesDTO getListByActive(UserGoalDto dto);
    PartiesDTO getListByNotActive();
}
