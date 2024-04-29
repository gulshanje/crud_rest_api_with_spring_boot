package com.gulshanje.items.services.implementation;

import com.gulshanje.items.models.Items;
import com.gulshanje.items.repos.ItemRepo;
import com.gulshanje.items.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService {

    private final ItemRepo itemRepo;

    @Override
    public Items create(Items items) {
        return this.itemRepo.save(items);
    }

    @Override
    public Items update(Items items) {
        return this.itemRepo.save(items);
    }

    @Override
    public List<Items> getAll() {
        return this.itemRepo.findAll();
    }

    @Override
    public Items getById(Long id) {
        return this.itemRepo.findById(id).get();
    }

    @Override
    public Items getByName(String name) {
        return this.itemRepo.findByName(name);
    }

    @Override
    public void delete(Long id) {
        this.itemRepo.deleteById(id);
    }
}
