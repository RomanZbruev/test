package ru.practicum.item;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface ItemService {

    List<ItemDto> getItems(Long userId);

    Item addNewItem(Long userId, ItemCreationDto item);

    void deleteItem(Long userId, Long itemId);

    List<ItemInfoWithUrlState> getUserItemStates(long userId);
    @Transactional(readOnly = true)
    List<ItemDto> getItems(long userId, Set<String> tags);
}
