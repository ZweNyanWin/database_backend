package net.physiqueForge.ems.controller;

import lombok.AllArgsConstructor;
import net.physiqueForge.ems.dto.trainer.MasterTrainerDTO;
import net.physiqueForge.ems.dto.trainer.TrainerRequestDTO;
import net.physiqueForge.ems.dto.trainer.TrainerResponseDTO;
import net.physiqueForge.ems.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/trainers")
public class TrainerController {
    private TrainerService trainerService;

    //Build Add Trainer Rest API
    @PostMapping
    public ResponseEntity<TrainerResponseDTO> createTrainer(@RequestBody TrainerRequestDTO trainerDto){
        TrainerResponseDTO savedTrainer = (TrainerResponseDTO) trainerService.createTrainer(trainerDto);
        return new ResponseEntity<>(savedTrainer, HttpStatus.CREATED);
    }

    //Build Get Trainer Rest API
    @GetMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> getTrainerById(@PathVariable("id") Long id){
        TrainerResponseDTO trainerDto =(TrainerResponseDTO) trainerService.getTrainerById(id);
        return ResponseEntity.ok(trainerDto);
    }

    //Build Get all Trainers Rest API
    @GetMapping
    public ResponseEntity<List<MasterTrainerDTO>> getAllTrainers(){
        List<MasterTrainerDTO> trainers = trainerService.getAllTrainers();
        return ResponseEntity.ok(trainers);
    }

    //Build  update trainer Rest API
    @PutMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> updateTrainer(@PathVariable("id") Long trainerId,
                                                            @RequestBody TrainerRequestDTO updatedTrainer){
        TrainerResponseDTO updatedTrainerDto =(TrainerResponseDTO) trainerService.updateTrainer(trainerId, updatedTrainer);
        return ResponseEntity.ok(updatedTrainerDto);
    }

    //Build Delete Trainer REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable("id") Long trainerId){
        trainerService.deleteTrainer(trainerId);
        return ResponseEntity.ok("Trainer deleted successfully");
    }



}
