package ru.practicum.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

interface ItemRepository extends JpaRepository<Item,Long>, ItemRepositoryCustom, QuerydslPredicateExecutor<Item> {

    List<Item> findByUserId(Long userId);

    void deleteItemByUserIdAndId(Long userId, Long itemId);

    List<ItemInfo> findAllByUserId(Long userId);
}