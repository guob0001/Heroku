package com.example.heroku.controllers;

import com.example.heroku.models.Programmer;
import com.example.heroku.repositories.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Programmers {
    @Autowired
    ProgrammerRepository programmers;

    @PostMapping("/programmers")
    public Programmer addProgrammer(@RequestBody Programmer newProgrammer){
        return programmers.save(newProgrammer);

    }
    @GetMapping("/programmers")
    public Iterable<Programmer> getProgrammers(){
        return programmers.findAll();
    }
    @GetMapping("/programmers/{id}")
    public Programmer getProgrammerById(@PathVariable Long id){
        return programmers.findById(id).get();
    }
    @PutMapping("/programmers/{id}")
    public String updateGalleryById(@PathVariable Long id, @RequestBody Programmer programmersToBeUpdatedWith){
        return programmers.findById(id).map(foundProgrammer -> {
            foundProgrammer.setName(programmersToBeUpdatedWith.getName());
            foundProgrammer.setAge(programmersToBeUpdatedWith.getAge());
            foundProgrammer.setWorkplace(programmersToBeUpdatedWith.getWorkplace());
            foundProgrammer.setHobby(programmersToBeUpdatedWith.getHobby());
            programmers.save(foundProgrammer);
            return "Found programmer";
        }).orElse("programmer not found");
    }
    @DeleteMapping("/programmers/{id}")
    public void deleteProgrammerById(@PathVariable Long id){
        programmers.deleteById(id);
    }


}

