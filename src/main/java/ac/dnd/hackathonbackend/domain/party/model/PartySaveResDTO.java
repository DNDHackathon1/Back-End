package ac.dnd.hackathonbackend.domain.party.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PartySaveResDTO {
    private Long id;

    public PartySaveResDTO(Long id) {
        this.id = id;
    }
}
