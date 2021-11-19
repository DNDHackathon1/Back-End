package ac.dnd.hackathonbackend.domain.party.service;

import ac.dnd.hackathonbackend.domain.party.model.PartyDTO;

public interface PartyService {
    Long save(PartyDTO party);
}
