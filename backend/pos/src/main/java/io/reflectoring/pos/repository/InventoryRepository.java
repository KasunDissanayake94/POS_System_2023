package io.reflectoring.pos.repository;

import io.reflectoring.pos.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {

    List<Inventory> findByInventoryNameContaining(String title);
}
