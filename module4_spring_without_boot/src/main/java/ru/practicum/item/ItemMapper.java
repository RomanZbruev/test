package ru.practicum.item;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class ItemMapper {

        public ItemDto toDto(Item item) {
            String name = item.getUrl();
            Long id = item.getId();
            return new ItemDto(id,name);
        }

        public Item toItem(ItemCreationDto itemDto) {
            Item item = new Item();
            item.setUrl(itemDto.getUrl());
            item.setUserId(itemDto.getUserId());
            item.setTags(new HashSet<>());
            return item;
        }

        public List<ItemDto> mapToItemDto(Iterable<Item> items) {
        List<ItemDto> dtos = new ArrayList<>();
        for (Item item : items) {
            dtos.add(toDto(item));
        }
        return dtos;
    }

}
