package org.jetbrains.assignment.controller;

import org.jetbrains.assignment.model.Mov;
import org.jetbrains.assignment.model.MovRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movements")

public class MovControl{
    private final MovRepo movRepo;

    @Autowired
    public MovControl(MovRepo movRepo){
        this.movRepo = movRepo;
    }

    @PostMapping
    public void addMov(@RequestBody Mov movement){
        movRepo.save(movement);
    }

    @GetMapping
    public Iterable<Mov> getAllMovements(){
        return movRepo.findAll();
    }
}