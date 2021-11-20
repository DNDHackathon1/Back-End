package ac.dnd.hackathonbackend.domain.party.service;

import ac.dnd.hackathonbackend.domain.party.model.PartiesDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveReqDTO;
import ac.dnd.hackathonbackend.domain.party.model.PartySaveResDTO;

public interface PartyService {
    PartySaveResDTO save(PartySaveReqDTO party);
    PartiesDTO getListByActive(Integer goalTime);
    PartiesDTO getListByNotActive();
}
