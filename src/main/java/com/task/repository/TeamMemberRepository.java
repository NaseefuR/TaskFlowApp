package com.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.TeamMembers;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMembers, Long>  {

	int countByTeamId(Long teamId);
	
	List<TeamMembers> findByUserId(Long userId);
	
	boolean existsByUserIdAndTeamId(Long userId, Long teamId);

	List<TeamMembers> findByTeamId(Long teamId);
	
	Optional<TeamMembers> findByTeamIdAndUserId(Long teamId,Long userId);

	void deleteByUserIdAndTeamId(Long removerId, Long teamId);

	void deleteAllByTeamId(Long teamId);
	
}
