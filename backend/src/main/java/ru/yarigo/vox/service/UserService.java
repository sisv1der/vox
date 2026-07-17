package ru.yarigo.vox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yarigo.vox.model.User;
import ru.yarigo.vox.model.UserRepository;
import ru.yarigo.vox.model.UserRole;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUserByKeycloakId(UUID keycloakId) {
        if (keycloakId == null)
            return Optional.empty();
        return userRepository.findByKeycloakId(keycloakId);
    }

    @Transactional
    public User createUser(UUID keycloakId, String displayName, UserRole role) {
        Instant createdAt = Instant.now();
        var u = new User();
        u.setKeycloakId(keycloakId);
        u.setDisplayName(displayName);
        u.setCreatedAt(createdAt);
        u.setLastSeenAt(createdAt);
        u.setRole(role);
        userRepository.save(u);

        return u;
    }
}
