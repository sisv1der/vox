package ru.yarigo.vox.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;
import ru.yarigo.vox.config.properties.JwtProperties;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class KeycloakJwtAuthoritiesConverter
        implements Converter<Jwt, Collection<GrantedAuthority>> {

    private final JwtGrantedAuthoritiesConverter defaultConverter =
            new JwtGrantedAuthoritiesConverter();

    private final JwtProperties jwtProperties;

    public KeycloakJwtAuthoritiesConverter(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {

        Collection<GrantedAuthority> authorities =
                new HashSet<>(defaultConverter.convert(jwt));

        authorities.addAll(extractKeycloakRoles(jwt));

        return authorities;
    }

    private Collection<GrantedAuthority> extractKeycloakRoles(Jwt jwt) {

        Map<String, Object> resourceAccess =
                jwt.getClaim("resource_access");

        if (resourceAccess == null) {
            return Set.of();
        }

        Map<String, Object> client =
                (Map<String, Object>) resourceAccess.get(jwtProperties.clientId());

        if (client == null) {
            return Set.of();
        }

        Collection<String> roles =
                (Collection<String>) client.get("roles");

        if (roles == null) {
            return Set.of();
        }

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toSet());
    }
}
