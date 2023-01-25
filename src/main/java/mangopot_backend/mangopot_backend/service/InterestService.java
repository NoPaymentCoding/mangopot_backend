package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.domain.Interest;
import mangopot_backend.mangopot_backend.repository.JpaInterestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InterestService {

    private final JpaInterestRepository interestRepository;

    public boolean createInterest(String name) {
        Interest interest = new Interest(name, "/imgurl");
        if (!interestRepository.findByName(name).isEmpty()) { //이미 존재하는 interest 생성 못함
            return false;
        }
        interestRepository.save(interest);
        return true;
    }

    public Optional<Interest> findInterestByName(String name) {
        Optional<Interest> interest = interestRepository.findByName(name);

        return interest;
    }

    public void clearRepo() {
        interestRepository.deleteAll();
    }

    public Long count() {
        return interestRepository.count();
    }
}
