package ac.dnd.hackathonbackend.domain.party.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PartySaveDTO {
    private Long id;

    public PartySaveDTO(Long id) {
        this.id = id;
    }
}
