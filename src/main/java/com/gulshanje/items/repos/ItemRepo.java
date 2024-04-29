package com.gulshanje.items.repos;

import com.gulshanje.items.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Items, Long>{
    Items findByName(String name);

}
