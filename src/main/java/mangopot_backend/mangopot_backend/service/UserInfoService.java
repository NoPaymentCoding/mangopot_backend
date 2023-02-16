package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.domain.Location;
import mangopot_backend.mangopot_backend.domain.UserInfo;
import mangopot_backend.mangopot_backend.repository.JpaUserInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final JpaUserInfoRepository userInfoRepository;

    public void createUser(String nickname, String email, String userInfo, String sns) {
        UserInfo user = UserInfo.builder()
                .email(email)
                .nickname(nickname)
                .userInfo(userInfo)
                .sns(sns)
                .build();
        userInfoRepository.save(user);
    }

    public Optional<UserInfo> findUser(String name){
        Optional<UserInfo> user = userInfoRepository.findByNickname(name);

        return user;
    }

    public void clearRepo(){
        userInfoRepository.deleteAll();
    }

    public long RepoCount() {
        return userInfoRepository.count();
    }
}
