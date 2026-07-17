package ru.yarigo.vox.util;

import org.springframework.security.oauth2.jwt.Jwt;
import ru.yarigo.vox.model.UserRole;

import java.util.*;
import java.util.stream.Collectors;

public class JwtUtil {

    private JwtUtil() {}

    public static Set<UserRole> getUserRoles(Jwt jwt) {
        Map<String, Object> resourceAccess =
                Objects.requireNonNull(jwt.getClaim("resource_access"));

        Map<String, Object> client =
                Objects.requireNonNull((Map<String, Object>) resourceAccess.get("vox-api"));

        List<String> roles =
                Objects.requireNonNull((List<String>) client.get("roles"));

        return roles.stream()
                .map(UserRole::valueOf)
                .collect(Collectors.toSet());
    }

    public static String getPreferredUsername(Jwt jwt) {
        return jwt.getClaim("preferred_username");
    }

    public static UUID getKeycloakId(Jwt jwt) {
        return UUID.fromString(Objects.requireNonNull(jwt.getSubject()));
    }
}
