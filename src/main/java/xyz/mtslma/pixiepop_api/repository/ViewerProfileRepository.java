package xyz.mtslma.pixiepop_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mtslma.pixiepop_api.model.ViewerProfile;

public interface ViewerProfileRepository extends JpaRepository<ViewerProfile, Long> {
}
