package net.physiqueForge.ems.service.impl;

import lombok.AllArgsConstructor;
import net.physiqueForge.ems.dto.trainer.MasterTrainerDTO;
import net.physiqueForge.ems.dto.trainer.TrainerRequestDTO;
import net.physiqueForge.ems.dto.trainer.TrainerResponseDTO;
import net.physiqueForge.ems.exception.ResourceNotFoundException;
import net.physiqueForge.ems.model.Trainer;
import net.physiqueForge.ems.mapper.TrainerMapper;
import net.physiqueForge.ems.repository.TrainerRepository;
import net.physiqueForge.ems.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainerServiceImpl  implements TrainerService {

    private TrainerRepository trainerRepository;

    private TrainerMapper trainerMapper;

    @Override
    public MasterTrainerDTO createTrainer(TrainerRequestDTO trainerDto) {

        Trainer trainer = trainerMapper.toEntity(trainerDto);
        Trainer savedTrainer = trainerRepository.save(trainer);
        return trainerMapper.toDto(savedTrainer);
    }

    @Override
    public MasterTrainerDTO getTrainerById(Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() ->
                        new RuntimeException("Trainer does not exist with given ID : ." + trainerId));


        return trainerMapper.toDto(trainer);
    }

    @Override
    public List<MasterTrainerDTO> getAllTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream().map((trainer) -> trainerMapper.toDto(trainer))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public MasterTrainerDTO updateTrainer(Long trainerId, TrainerRequestDTO updatedTrainer) {
       Trainer trainer = trainerRepository.findById(trainerId)
               .orElseThrow(
                       () -> new ResourceNotFoundException("Trainer does not exist with given ID :" + trainerId)
               );

       trainer.setName(updatedTrainer.getName());
       trainer.setExperience(updatedTrainer.getExperience());
       trainer.setSpecialization(updatedTrainer.getSpecialization());

       Trainer updatedTrainerObj =  trainerRepository.save(trainer);
       return trainerMapper.toDto(updatedTrainerObj);
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Trainer does not exist with given ID :" + trainerId)
                );
        trainerRepository.deleteById(trainerId);


    }
}
