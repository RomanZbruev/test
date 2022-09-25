package ru.practicum.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.stream.Collectors;

public class ItemRepositoryImpl implements ItemRepositoryCustom{

    private final ItemRepository itemRepository;
    private final ItemUrlStatusProvider itemUrlStatusProvider;

    public ItemRepositoryImpl(@Lazy ItemRepository itemRepository, @Lazy ItemUrlStatusProvider itemUrlStatusProvider){
        this.itemRepository = itemRepository;
        this.itemUrlStatusProvider = itemUrlStatusProvider;
    }
    @Override
    public List<ItemInfoWithUrlState> findAllByUserIdWithUrlState(Long userId) {
        List<ItemInfo> items = itemRepository.findAllByUserId(userId);
        return items.stream()
                .map(itemInfo -> {
                    HttpStatus httpStatus = itemUrlStatusProvider.getItemUrlStatus(itemInfo.getId());
                    return new ItemInfoWithUrlState(itemInfo,httpStatus);
                })
                .collect(Collectors.toList());
    }
}
