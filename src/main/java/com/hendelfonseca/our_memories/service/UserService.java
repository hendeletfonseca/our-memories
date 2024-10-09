package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.exception.MemoryNotFoundException;
import com.hendelfonseca.our_memories.exception.UserNotFoundException;
import com.hendelfonseca.our_memories.model.Memory;
import com.hendelfonseca.our_memories.model.User;
import com.hendelfonseca.our_memories.repository.MemoryRepository;
import com.hendelfonseca.our_memories.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final MemoryRepository memoryRepository;

    public UserService(UserRepository userRepository, MemoryRepository memoryRepository) {
        this.userRepository = userRepository;
        this.memoryRepository = memoryRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User addMemoryToUser(UUID userId, long memoryId) {
        User user = read(userId);
        Memory memory = memoryRepository
                .findById(memoryId)
                .orElseThrow(() -> new MemoryNotFoundException("Memory not found with id " + memoryId));
        user.getMemories().add(memory);
        return userRepository.save(user);
    }
}
