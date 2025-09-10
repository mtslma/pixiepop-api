package xyz.mtslma.pixiepop_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Contém dados específicos de uma conta que atua como Streamer.
 * Usa o ID da Account associada como sua própria chave primária.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_streamer_profile")
public class StreamerProfile {

    @Id
    private Long id;

    // Estratégia de chave primária compartilhada
    // O @MapsId faz com que a chave primária seja a mesma que vem de Account
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    // Apelido para a URL pública de doação, ex: /pixiepop/gaules
    @Column(unique = true)
    private String customPageSlug;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}