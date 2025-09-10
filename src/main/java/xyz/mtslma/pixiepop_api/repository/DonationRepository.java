package xyz.mtslma.pixiepop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.mtslma.pixiepop_api.model.Account;
import xyz.mtslma.pixiepop_api.model.Donation;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    // Busca todas as doações recebidas por um determinado streamer
    List<Donation> findAllByStreamer(Account streamer);

}
