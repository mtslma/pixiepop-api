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
 * Representa uma única transação de doação confirmada na plataforma.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com a conta que recebeu a doação (o streamer)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "streamer_account_id", nullable = false)
    private Account streamer;

    // Relacionamento com a conta que fez a doação (o viewer), se estiver logada
    // Pode ser nulo para doações anônimas.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viewer_account_id")
    private Account viewer;

    @Column(columnDefinition = "TEXT")
    private String message;

    // ID da transação vindo do gateway de pagamento
    @Column(unique = true, nullable = false)
    private String paymentId;

    // Nome que o doador insere no formulário. Pode ser diferente do twitchDisplayName
    @Column(nullable = false)
    private String donatorName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    // Status da transação, ex: APROVADO, PENDENTE, RECUSADO, REEMBOLSADO, CANCELADO.
    @Column(nullable = false)
    private String status;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}