package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.RecruitingRequest;

@Repository
public interface RecruitingRequestRepository extends JpaRepository<RecruitingRequest, Long> {
	boolean existsByUserIdAndTeamId(Long userId,Long teamId);
	RecruitingRequest findByUserIdAndTeamId(Long userId,Long teamId);
	List<RecruitingRequest> findByUserId(Long userId);
	void deleteAllByTeamId(Long teamId);
}
