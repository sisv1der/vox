package ru.yarigo.vox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yarigo.vox.model.User;
import ru.yarigo.vox.model.UserRole;
import ru.yarigo.vox.service.dto.AuthenticatedUser;
import ru.yarigo.vox.web.dto.UserInfo;

@Service
@RequiredArgsConstructor
public class MeService {

    private final UserService userService;

    @Transactional
    public UserInfo getUserByKeycloakId(AuthenticatedUser auth) {
        return userService.getUserByKeycloakId(auth.keycloakId())
                .map(this::toUserInfo)
                .orElseGet(() -> {
                    if (auth.roles().size() != 1) {
                        throw new IllegalStateException("Expected exactly one role");
                    }

                    UserRole role = auth.roles().iterator().next();

                    User user = userService.createUser(
                            auth.keycloakId(),
                            auth.preferredUsername(),
                            role
                    );

                    return toUserInfo(user);
                });
    }

    private UserInfo toUserInfo(User user) {
        return new UserInfo(
                user.getDisplayName(),
                user.getBio(),
                user.getRole(),
                user.getLastSeenAt(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
