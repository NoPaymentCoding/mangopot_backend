package mangopot_backend.mangopot_backend.position;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.position.Position;
import mangopot_backend.mangopot_backend.position.JpaPositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final JpaPositionRepository positionRepository;

    public boolean createPosition(String name) {
        Position position = new Position(name, "/img");
        positionRepository.save(position);
        return true;
    }

    public Optional<Position> findPositionByName(String name) {
        Optional<Position> position = positionRepository.findByName(name);

        return position;
    }

    /**
     * position name list로 position id list 반환
     */
    public List<Integer> findPositionIdsByNames(List<String> names){
        List<Integer> positionIdByNames = positionRepository.findPositionIdByNames(names);
        return positionIdByNames;
    }

    public void clearRepo(){
        positionRepository.deleteAll();
    }

    public long RepoCount() {
        return positionRepository.count();
    }
}
