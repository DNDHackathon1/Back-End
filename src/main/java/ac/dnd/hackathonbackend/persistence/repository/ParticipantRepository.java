package ac.dnd.hackathonbackend.persistence.repository;

import ac.dnd.hackathonbackend.persistence.entity.ParticipantEntity;
import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import ac.dnd.hackathonbackend.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Long> {
    List<ParticipantEntity> findAllByParty(PartyEntity partyEntity);
    void removeByUserIdAndPartyId(Long userId, Long partyId);
    void deleteByUserIdAndPartyId(Long userId, Long partyId);
}
