package org.revature.springboot.dao;


import org.revature.springboot.model.Task;
import org.revature.springboot.model.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EntityScan(basePackages = "org.revature.springboot.model")
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAssigneeId(Long assigneeId);

    List<Task> findByProjectId(Long projectId);

    List<Task> findByTeamMember(User teamMember);
}

