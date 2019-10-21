package com.hcl.helathcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.helathcare.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Long> {
	
	@Query(value="select policy_id from claim  where user_id=?",nativeQuery=true)
	public List<Long> getClaimsByUserId(Long userId);
	
	List<Claim> findByUserId(Long userId);
	
}
