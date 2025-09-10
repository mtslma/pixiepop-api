package xyz.mtslma.pixiepop_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade central que representa qualquer usuário logado via Twitch.
 * Pode ter perfis de Streamer e/ou Viewer associados.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ID numérico único vindo da API da Twitch,
    @Column(unique = true, nullable = false)
    private String twitchUserId;

    @Column(nullable = false)
    private String twitchDisplayName;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Relacionamentos

    // Lado inverso da relação. A FK está na tabela 'tb_streamer_profile'
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private StreamerProfile streamerProfile;

    // Lado inverso da relação. A FK está na tabela 'tb_viewer_profile'
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ViewerProfile viewerProfile;

    // Lado inverso da relação. A FK está na tabela 'tb_auth_token'
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AuthToken authToken;

    // Lista de doações que esta conta recebeu como streamer
    @OneToMany(mappedBy = "streamer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Donation> donationsReceived = new ArrayList<>();

    // Lista de doações que esta conta fez como viewer
    @OneToMany(mappedBy = "viewer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Donation> donationsMade = new ArrayList<>();


    // Métodos auxiliares

    // Garante a consistência do estado do objeto nos dois lados da relação.
    public void addDonationReceived(Donation donation) {
        this.donationsReceived.add(donation);
        donation.setStreamer(this);
    }

    public void addDonationMade(Donation donation) {
        this.donationsMade.add(donation);
        donation.setViewer(this);
    }
}
