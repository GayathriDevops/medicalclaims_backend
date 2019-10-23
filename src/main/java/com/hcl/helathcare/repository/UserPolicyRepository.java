package com.hcl.helathcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.helathcare.entity.UserPolicy;

/**
 * extends jpaRepository
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
@Repository
public interface UserPolicyRepository extends JpaRepository<UserPolicy, Long> {

	Optional<UserPolicy> findByPolicyIdAndUserId(Long policyId, Long userId);

}
