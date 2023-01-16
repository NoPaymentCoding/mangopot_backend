package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.domain.Location;
import mangopot_backend.mangopot_backend.repository.JpaLocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final JpaLocationRepository locationRepository;

    public Optional<Location> findLocation(String name){
        Optional<Location> location = locationRepository.findByName(name);
        return location;
    }
}