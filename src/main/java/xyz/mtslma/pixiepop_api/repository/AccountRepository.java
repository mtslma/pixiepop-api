package xyz.mtslma.pixiepop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.mtslma.pixiepop_api.model.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Busca uma conta pelo ID da Twitch
    Optional<Account> findByTwitchUserId(String twitchUserId);

}
