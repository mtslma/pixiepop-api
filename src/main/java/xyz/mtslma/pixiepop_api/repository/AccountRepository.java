package xyz.mtslma.pixiepop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mtslma.pixiepop_api.model.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // Busca uma conta pelo ID da Twitch
    Optional<Account> findByTwitchUserId(String twitchUserId);

}
