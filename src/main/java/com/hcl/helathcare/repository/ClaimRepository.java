package com.hcl.helathcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.helathcare.entity.Claim;

/**
 * extends jpaRepository
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
