package ie.atu.week5_githubactions.service;

import ie.atu.week5_githubactions.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassengerServiceTest {
    private PassengerService service;

    @BeforeEach
    void setUp() {service = new PassengerService();}

    @Test
    void createThenFindById(){
        Passenger p = new Passenger("id1","Adam", "adam@atu.ie");

        service.create(p);

        Optional<Passenger> found = service.findById("id1");
        assertTrue(found.isPresent());
        assertEquals("Adam", found.get().getName());
    }
}
