package com.gulshanje.items.controllers;

import com.gulshanje.items.models.Items;
import com.gulshanje.items.models.Responses;
import com.gulshanje.items.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor

public class ItemController {

    @Autowired
    private final ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<Responses> getAllItems(){
        return  ResponseEntity.ok(
                Responses.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("All Items Received")
                        .data(Map.of("items", this.itemService))
                        .build()

        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Responses> getItem(@PathVariable("id") Long id){
        return  ResponseEntity.ok(
                Responses.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("All Items Received")
                        .data(Map.of("items", this.itemService.getById(id)))
                        .build()

        );
    }

    @PostMapping("/create")
    public ResponseEntity<Responses> createItem(@RequestBody Items items){
        return  ResponseEntity.ok(
                Responses.builder()
                        .timeStamp(now())
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .message("Item Created")
                        .data(Map.of("items", this.itemService.create(items)))
                        .build()

        );
    }

    @PatchMapping("/update/{itemId}")
    public ResponseEntity<Responses> updateItem(@RequestBody Items items, @PathVariable("itemId") Long id){
        items.setId(id);
        return  ResponseEntity.ok(
                Responses.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Item Updated")
                        .data(Map.of("items", this.itemService.update(items)))
                        .build()

        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Responses> deleteItem(@PathVariable("itemId") Long id){
        this.itemService.delete(id);
        return  ResponseEntity.ok(
                Responses.builder()
                        .timeStamp(now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Item Deleted")
                        .data(Map.of("IsItemDeleted", true))
                        .build()

        );
    }

}
