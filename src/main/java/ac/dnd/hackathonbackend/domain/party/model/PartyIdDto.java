package ac.dnd.hackathonbackend.domain.party.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartyIdDto {

    @ApiModelProperty(value = "방(파티) PK")
    private Long partyId;
}
