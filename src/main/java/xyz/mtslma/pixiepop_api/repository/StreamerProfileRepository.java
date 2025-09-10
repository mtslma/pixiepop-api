package xyz.mtslma.pixiepop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.mtslma.pixiepop_api.model.StreamerProfile;

import java.util.Optional;

@Repository
public interface StreamerProfileRepository extends JpaRepository<StreamerProfile, Long> {

    // Busca um perfil de streamer pelo "slug"
    Optional<StreamerProfile> findByCustomPageSlug(String customPageSlug);

}
