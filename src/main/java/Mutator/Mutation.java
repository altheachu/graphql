package Mutator;

import Entity.Location;
import Repository.LocationRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import exception.LocationNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private LocationRepository locationRepository;

    public Mutation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location newLocation(String name, String address){
        Location location = new Location(name, address);
        locationRepository.save(location);
        return location;
    }

    public boolean deleteLocation(Long id){
        locationRepository.deleteById(id);
        return true;
    }

    public Location updateLocationName(String newName, Long id){
        Optional<Location> optionLocation = locationRepository.findById(id);

        if(optionLocation.isPresent()){
            Location location = optionLocation.get();
            location.setName(newName);
            locationRepository.save(location);
            return location;
        }else{
            throw new LocationNotFoundException("Location Not Found", id);
        }
    }


}
