package ru.yarigo.vox.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.type.PostgreSQLEnumJdbcType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable=false)
    private UUID keycloakId;

    @Column(nullable=false, length=100)
    private String displayName;

    @Column(length=1000)
    private String bio;

    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<ConversationMember> conversations;

    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(nullable = false)
    private UserRole role;

    @Column(nullable=false)
    private Instant lastSeenAt;

    @Column(nullable=false)
    private Instant createdAt;

    private Instant updatedAt;
}
