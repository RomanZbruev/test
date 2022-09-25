package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public User saveUser(UserCreationDto user) {
        return repository.save(userMapper.toUser(user));
    }
}