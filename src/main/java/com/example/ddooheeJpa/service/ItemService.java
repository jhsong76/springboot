package com.example.ddooheeJpa.service;

import com.example.ddooheeJpa.domain.item.Book;
import com.example.ddooheeJpa.domain.item.Item;
import com.example.ddooheeJpa.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity ) {
        Item findItem = itemRepository.findOne(itemId); // 영속 상태
        // findItem.change(price, name, stockQuantity);
        // set 보다 change처럼 의미 있는 메서드로 생성해야 함.
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);

    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
