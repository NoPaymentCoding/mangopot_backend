package mangopot_backend.mangopot_backend.interest;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.interest.Interest;
import mangopot_backend.mangopot_backend.interest.JpaInterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * name 1개만
     * @param name
     * @return Optional
     */
    public Optional<Interest> findInterestByName(String name) {
        Optional<Interest> interest = interestRepository.findByName(name);

        return interest;
    }

    /**
     * name list로 받아서 interest List return
     * @param names
     * @return List
     */
    public List<Interest> findInterestsByNames(List<String> names) {
        List<Interest> interestList = interestRepository.findByNames(names);
        return interestList;
    }

    public List<Interest> findInterestAll(){
        List<Interest> interestList = interestRepository.findAll();

        return interestList;
    }

    public void clearRepo() {
        interestRepository.deleteAll();
    }

    public Long count() {
        return interestRepository.count();
    }

    public List<Integer> findInterestIdByNames(List<String> interestNames) {
        return interestRepository.findInterestIdByNames(interestNames);
    }
}
