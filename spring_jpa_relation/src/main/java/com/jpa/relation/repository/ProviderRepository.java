package com.jpa.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.relation.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
	
}
