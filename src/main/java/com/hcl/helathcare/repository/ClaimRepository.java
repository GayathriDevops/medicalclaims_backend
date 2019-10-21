package com.hcl.helathcare.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.helathcare.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
  
	Optional<List<Claim>> findAllByClaimStatus(String searchCriteria);

	Claim findByClaimId(Long id);

	Optional<List<Claim>> findAllByUserId(long userId);

}