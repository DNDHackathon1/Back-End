package ac.dnd.hackathonbackend.domain.party.model;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PartiesByNotActiveDTO {
    private List<PartyReadDTO> parties;

    public PartiesByNotActiveDTO(List<PartyEntity> parties) {
        this.parties = parties.stream().map(PartyReadDTO::fromEntity).collect(Collectors.toList());
    }
}
