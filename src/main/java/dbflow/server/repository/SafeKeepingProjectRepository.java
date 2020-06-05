package dbflow.server.repository;

import dbflow.server.domain.SafeKeepingProject;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SafeKeepingProject entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SafeKeepingProjectRepository extends JpaRepository<SafeKeepingProject, Long> {
}
