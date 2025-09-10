package xyz.mtslma.pixiepop_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Contém dados específicos de uma conta que atua como Viewer,
 * como o total doado, para futuras funcionalidades de ranking.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_viewer_profile")
public class ViewerProfile {

    @Id
    private Long id;

    // Estratégia de chave primária compartilhada
    // O @MapsId faz com que a chave primária seja a mesma que vem de Account
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "total_donated", precision = 12, scale = 2, columnDefinition = "DECIMAL(12, 2) DEFAULT 0.00")
    private BigDecimal totalDonated;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}