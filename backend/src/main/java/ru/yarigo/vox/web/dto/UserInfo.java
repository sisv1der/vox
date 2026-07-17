package ru.yarigo.vox.web.dto;

import ru.yarigo.vox.model.UserRole;

import java.time.Instant;

public record UserInfo(
        String displayName,
        String bio,
        UserRole role,
        Instant lastSeenAt,
        Instant createdAt,
        Instant updatedAt
) {
}
