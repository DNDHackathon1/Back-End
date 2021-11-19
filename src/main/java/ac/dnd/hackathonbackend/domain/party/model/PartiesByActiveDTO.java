package ac.dnd.hackathonbackend.domain.party.model;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PartiesByActiveDTO {
    private List<PartyReadDTO> parties;

    public PartiesByActiveDTO(List<PartyEntity> parties) {
        this.parties = parties.stream().map(PartyReadDTO::fromEntity).collect(Collectors.toList());
    }
}