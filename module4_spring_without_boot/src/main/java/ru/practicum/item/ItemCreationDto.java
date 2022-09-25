package ru.practicum.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemCreationDto {

    private Long userId;

    private String url;

}
