package xyz.mtslma.pixiepop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.mtslma.pixiepop_api.model.ViewerProfile;

@Repository
public interface ViewerProfileRepository extends JpaRepository<ViewerProfile, Long> {
}
