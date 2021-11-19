package ac.dnd.hackathonbackend.domain.participant.service;

import ac.dnd.hackathonbackend.domain.participant.model.ParticipantDTO;
import ac.dnd.hackathonbackend.domain.participant.model.ParticipantSaveDTO;

public interface ParticipantService {
     ParticipantSaveDTO save (ParticipantDTO participantDTO);
}
