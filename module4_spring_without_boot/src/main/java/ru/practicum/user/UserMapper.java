package ru.practicum.user;

import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto.UserDtoBuilder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public User toUser(UserCreationDto userCreationDto) {
        User user = new User();
        user.setFirstName(userCreationDto.getFirstName());
        user.setLastName(userCreationDto.getLastName());
        user.setEmail(userCreationDto.getEmail());
        user.setRegistrationDate(userCreationDto.getRegistrationDate());
        user.setState(userCreationDto.getState());
        return user;
    }
}
