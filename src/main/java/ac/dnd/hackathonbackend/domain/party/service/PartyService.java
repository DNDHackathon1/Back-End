package ac.dnd.hackathonbackend.domain.party.service;

import ac.dnd.hackathonbackend.domain.party.model.PartiesDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveDTO;

public interface PartyService {
    PartySaveDTO save(PartyDTO party);
    PartiesDTO getListByActive(Integer goalTime);
    PartiesDTO getListByNotActive();
}
