package ac.dnd.hackathonbackend.persistence.repository;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyRepository extends JpaRepository<PartyEntity, Long> {
    List<PartyEntity> findAllByActive(Boolean active);
}
