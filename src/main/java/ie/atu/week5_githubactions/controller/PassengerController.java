package ie.atu.week5_githubactions.controller;

import ie.atu.week5_githubactions.model.Passenger;
import ie.atu.week5_githubactions.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private PassengerService service;
    public PassengerController(PassengerService service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<Passenger>> getAll(){return ResponseEntity.ok(service.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getbyId(@PathVariable String id){
        Optional<Passenger> maybe = service.findById(id);
        if(maybe.isPresent()){
            return ResponseEntity.ok(maybe.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Passenger> create(@RequestBody Passenger p){
        Passenger created = service.create(p);// calls the create method from the service layer and adds p to the array list
        return ResponseEntity
                .created(URI.create("api/passengers/" + created.getPassengerId()))
                .body(created);
    }
}
