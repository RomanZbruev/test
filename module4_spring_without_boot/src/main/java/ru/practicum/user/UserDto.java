package ru.practicum.user;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDto {

    private String firstName;

    private String lastName;

}
