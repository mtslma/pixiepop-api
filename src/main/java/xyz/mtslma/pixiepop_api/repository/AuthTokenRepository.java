package xyz.mtslma.pixiepop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mtslma.pixiepop_api.model.AuthToken;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
}
