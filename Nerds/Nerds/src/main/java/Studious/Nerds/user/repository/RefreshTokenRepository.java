package Studious.Nerds.user.repository;

import Studious.Nerds.user.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
    boolean existsByEmail(String keyUserEmail);
    void deleteByEmail(String keyUserEmail);
}
