package ac.dnd.hackathonbackend.domain.party.model;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PartiesDTO {
    private List<PartyReadDTO> parties;

    public PartiesDTO(List<PartyEntity> parties) {
        this.parties = parties.stream().map(PartyReadDTO::fromEntity).collect(Collectors.toList());
    }
}
