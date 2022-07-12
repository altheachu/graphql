package Resolver;

import Entity.Location;
import Repository.LocationRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private LocationRepository locationRepository;

    public Query(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations(){
        return locationRepository.findAll();
    }

}
