package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.task.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByTeamId(Long teamId);

	List<Task> findByProjectId(Long projectId);

	List<Task> findByUserId(Long userId);
	
	List<Task> findByAssignedto(Long assignedto);

	List<Task> findByUserIdAndProjectId(Long userId, Long projectId);

	List<Task> findByAssignedtoAndProjectId(Long userId, Long projectId);

	boolean existsByAssignedtoAndTeamId(Long removerId, Long teamId);

	void deleteAllByAssignedtoAndTeamId(Long removerId, Long teamId);

	void deleteAllByTeamId(Long teamId);

	boolean existsByIdAndTeamIdAndProjectId(Long taskId, Long teamId, Long projectId);
	
	@Modifying
	@Query("UPDATE Task t SET t.status = :status WHERE t.id = :taskId AND t.team.id = :teamId AND t.project.id = :projectId")
	void updateStatus(@Param("status") String status,@Param("taskId") Long taskId,@Param("teamId") Long teamId,@Param("projectId") Long projectId);

}
