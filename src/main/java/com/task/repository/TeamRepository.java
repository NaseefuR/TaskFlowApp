package com.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	
	List<Team> findByUserId(Long user_id);
	Optional<Team> findByTeamcode(String teamCode);
	boolean existsByIdAndUserId(Long teamId, Long userId);
	Optional<Team> findByIdAndUserId(Long teamId, Long sendBy);
	
}
