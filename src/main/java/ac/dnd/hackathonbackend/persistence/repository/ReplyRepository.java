package ac.dnd.hackathonbackend.persistence.repository;

import ac.dnd.hackathonbackend.persistence.entity.PartyEntity;
import ac.dnd.hackathonbackend.persistence.entity.ReplyEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

    List<ReplyEntity> findAllByParty(PartyEntity party);
}
