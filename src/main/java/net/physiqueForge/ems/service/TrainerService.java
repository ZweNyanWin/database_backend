package net.physiqueForge.ems.service;
import net.physiqueForge.ems.dto.trainer.MasterTrainerDTO;
import net.physiqueForge.ems.dto.trainer.TrainerRequestDTO;

import java.util.List;

public interface TrainerService {

    MasterTrainerDTO createTrainer(TrainerRequestDTO trainerDto);

    MasterTrainerDTO getTrainerById(Long id);

    List<MasterTrainerDTO> getAllTrainers();

    MasterTrainerDTO updateTrainer(Long trainerId, TrainerRequestDTO updatedTrainer);

    void deleteTrainer(Long id);



}

