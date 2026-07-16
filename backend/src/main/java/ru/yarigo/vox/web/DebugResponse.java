package ru.yarigo.vox.web;

import java.util.Collection;

public record DebugResponse(
        String name,
        Collection<AuthorityResponse> authorities
) {
}