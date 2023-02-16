package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.domain.Position;
import mangopot_backend.mangopot_backend.repository.JpaPositionRepository;
import mangopot_backend.mangopot_backend.repository.JpaProjectInterestRelationRepository;
import org.springframework.stereotype.Service;

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

    public void clearRepo(){
        positionRepository.deleteAll();
    }

    public long RepoCount() {
        return positionRepository.count();
    }
}
