package ru.yarigo.vox.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yarigo.vox.model.UserRole;
import ru.yarigo.vox.service.MeService;
import ru.yarigo.vox.service.dto.AuthenticatedUser;
import ru.yarigo.vox.util.JwtUtil;
import ru.yarigo.vox.web.dto.UserInfo;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/me")
public class MeController {

    private final MeService meService;

    public MeController(MeService meService) {
        this.meService = meService;
    }

    @GetMapping
    public UserInfo me(@AuthenticationPrincipal Jwt jwt) {
        UUID keycloakId = JwtUtil.getKeycloakId(jwt);
        String preferredUsername = JwtUtil.getPreferredUsername(jwt);
        Set<UserRole> roles = JwtUtil.getUserRoles(jwt);

        return meService.getUserByKeycloakId(
                new AuthenticatedUser(
                        keycloakId,
                        preferredUsername,
                        roles
                )
        );
    }
}
