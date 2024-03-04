package umc.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.Util.Uuid;

public interface UuidRepository extends JpaRepository<Uuid, Long> {
}
