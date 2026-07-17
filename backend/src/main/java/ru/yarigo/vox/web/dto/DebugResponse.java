package ru.yarigo.vox.web.dto;

import java.util.Collection;

public record DebugResponse(
        String name,
        Collection<AuthorityResponse> authorities
) {
}