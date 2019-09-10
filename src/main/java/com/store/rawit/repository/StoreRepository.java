package com.store.rawit.repository;

import com.store.rawit.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Drink, Long> {
}
