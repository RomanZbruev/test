package ru.practicum.user;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;

@Getter
@Setter
@Builder

public class UserCreationDto {

    private String firstName;

    private String lastName;

    private String email;

    @Builder.Default
    private Instant registrationDate = Instant.now();

    private UserState state;

}
