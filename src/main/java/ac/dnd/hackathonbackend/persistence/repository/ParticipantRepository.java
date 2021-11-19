package ac.dnd.hackathonbackend.persistence.repository;

import ac.dnd.hackathonbackend.persistence.entity.ParticipantEntity;
import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Long> {
    List<ParticipantEntity> findAllByParty(PartyEntity partyEntity);
}
