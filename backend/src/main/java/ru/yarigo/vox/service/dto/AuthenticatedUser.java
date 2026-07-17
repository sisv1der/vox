package ru.yarigo.vox.service.dto;

import ru.yarigo.vox.model.UserRole;

import java.util.Set;
import java.util.UUID;

public record AuthenticatedUser(
        UUID keycloakId,
        String preferredUsername,
        Set<UserRole> roles
) {
}
