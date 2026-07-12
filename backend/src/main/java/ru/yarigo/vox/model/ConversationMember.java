package ru.yarigo.vox.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(
        name = "conversation_members",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "conversation_id",
                                "member_id"
                        }
                )
        }
)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConversationMember {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User member;
}
