package kz.bitlab.portal.trello.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.portal.trello.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {

}
