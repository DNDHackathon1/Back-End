package ac.dnd.hackathonbackend.persistence.repository;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<PartyEntity, Long> {
}
