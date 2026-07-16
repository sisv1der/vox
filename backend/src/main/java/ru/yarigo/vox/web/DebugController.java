package ru.yarigo.vox.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/debug")
public class DebugController {

    @GetMapping
    public DebugResponse debug(Authentication authentication) {
        return new DebugResponse(
                authentication.getName(),
                authentication.getAuthorities()
                        .stream()
                        .map(a -> new AuthorityResponse(a.getAuthority()))
                        .toList()
        );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "ok";
    }
}
