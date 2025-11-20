package ie.atu.week5_githubactions.service;

import ie.atu.week5_githubactions.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // service layer
public class PassengerService {
    private final List<Passenger> store= new ArrayList<Passenger>(); //mock repository layer

    public List<Passenger> findAll() {
        return new ArrayList<>(store);
    }
    public Optional <Passenger> findById(String id) {
        for(Passenger p : store) {// loop through the array to check if id equal
            if(p.getPassengerId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p) { // create a passenger to add to arraylist
        if(findById(p.getPassengerId()).isPresent()) {
            throw new IllegalArgumentException("Passenger already exists");
        }
        store.add(p);
        return p;
    }

    public Passenger update(Passenger p) {
        if(findById(p.getPassengerId()).isPresent()) {

        }
    }
}
