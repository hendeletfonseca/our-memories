package com.hendelfonseca.our_memories.service;

import com.hendelfonseca.our_memories.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User create(User user);
    User read(UUID id);
    List<User> readAll();
    User update(User user);
    User addMemoryToUser(UUID userId, long memoryId);
    void delete(UUID id);
}
