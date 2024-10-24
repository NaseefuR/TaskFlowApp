package com.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.JoiningRequest;

@Repository
public interface JoiningRequestRepository extends JpaRepository<JoiningRequest, Long> {
	
	List<JoiningRequest> findByCreatedby(Long userId);
	Optional<JoiningRequest> findByUserIdAndTeamId(Long userId,Long teamId);
	int countByCreatedby(Long userId);
	boolean existsByUserId(Long userId);
	void deleteAllByTeamId(Long teamId);

}
