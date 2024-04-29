package com.gulshanje.items.services;

import com.gulshanje.items.models.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    Items create(Items items);
    Items update(Items items);
    List<Items> getAll();
    Items getById(Long id);
    Items getByName(String name);
    void delete(Long id);
}
