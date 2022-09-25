package ru.practicum.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ItemDto {

    private Long id;

    private String url;



}
