package ac.dnd.hackathonbackend.domain.party.model;

import lombok.Getter;

@Getter
public class PartySaveDTO {
    private Long id;

    public PartySaveDTO(Long id) {
        this.id = id;
    }
}
