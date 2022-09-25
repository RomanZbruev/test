package ru.practicum.item;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDto> getItems(Long userId) {
        return itemRepository.findByUserId(userId).stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Item addNewItem(Long userId, ItemCreationDto item) {
        item.setUserId(userId);
        return itemRepository.save(itemMapper.toItem(item));
    }

    @Override
    public void deleteItem(Long userId, Long itemId) {
        itemRepository.deleteItemByUserIdAndId(userId,itemId);
    }

    @Override
    public List<ItemInfoWithUrlState> getUserItemStates(long userId) {
        return itemRepository.findAllByUserIdWithUrlState(userId);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> getItems(long userId, Set<String> tags) {
        BooleanExpression byUserId = QItem.item.userId.eq(userId);
        BooleanExpression byAnyTag = QItem.item.tags.any().in(tags);
        Iterable<Item> foundItems = itemRepository.findAll(byUserId.and(byAnyTag));
        return itemMapper.mapToItemDto(foundItems);
    }
}
