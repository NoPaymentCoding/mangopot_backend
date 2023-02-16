package mangopot_backend.mangopot_backend.repository;

import mangopot_backend.mangopot_backend.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByNickname(String nickName);
}
