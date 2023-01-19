package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.domain.Location;
import mangopot_backend.mangopot_backend.repository.JpaLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final JpaLocationRepository locationRepository;

    public boolean createLocation(String name){
        Location location = new Location(name);
        locationRepository.save(location);
        return true;
    }

    public Optional<Location> findLocation(String name){
        Optional<Location> location = locationRepository.findByName(name);
        return location;
    }

    public List<Location> findAllLocation(){
        List<Location> list = locationRepository.findAll();
        return list;
    }

    public void clearRepo(){
        locationRepository.deleteAll();
    }

    public long RepoCount() {
        return locationRepository.count();
    }
}