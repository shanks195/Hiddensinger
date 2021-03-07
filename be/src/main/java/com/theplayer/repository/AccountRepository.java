package com.theplayer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theplayer.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	Optional<AccountEntity> findByUsername(String username);
	AccountEntity findOneByUsername(String username);
	AccountEntity findOneById(Long id);
	Boolean existsByUsername(String username);
}
