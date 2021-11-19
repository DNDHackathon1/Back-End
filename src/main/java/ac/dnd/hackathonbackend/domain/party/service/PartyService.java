package ac.dnd.hackathonbackend.domain.party.service;

import ac.dnd.hackathonbackend.domain.party.model.PartiesByNotActiveDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartiesByActiveDTO;

public interface PartyService {
    PartySaveDTO save(PartyDTO party);
    PartiesByActiveDTO getListByActive();
    PartiesByNotActiveDTO getListByNotActive();
}
