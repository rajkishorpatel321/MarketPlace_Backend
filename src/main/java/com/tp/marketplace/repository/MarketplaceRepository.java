package com.tp.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.marketplace.entity.Marketplace;

@Repository
public interface MarketplaceRepository extends JpaRepository<Marketplace, Long> {


}
