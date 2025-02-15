package net.physiqueForge.ems.service.impl;

import net.physiqueForge.ems.dto.client.ClientRequestDTO;
import net.physiqueForge.ems.dto.client.ClientResponseDTO;
import net.physiqueForge.ems.mapper.ClientMapper;
import net.physiqueForge.ems.model.Client;
import net.physiqueForge.ems.repository.ClientRepository;
import net.physiqueForge.ems.service.ClientService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientResponseDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clientMapper.toDtoList(clients);
    }

    @Override
    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
        return clientMapper.toDto(client);
    }

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        Client client = clientMapper.toEntity(clientRequestDTO);
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));

        // Update properties from DTO
        existingClient.setName(clientRequestDTO.getName());
        existingClient.setEmail(clientRequestDTO.getEmail());
        existingClient.setPhoneNumber(clientRequestDTO.getPhoneNumber());
        existingClient.setDob(clientRequestDTO.getDob());
        existingClient.setHeight(clientRequestDTO.getHeight());
        existingClient.setWeight(clientRequestDTO.getWeight());
        existingClient.setGoal(clientRequestDTO.getGoal());
        existingClient.setClientStatus(clientRequestDTO.getClientStatus());
        existingClient.setUpdatedAt(LocalDateTime.now());

        existingClient = clientRepository.save(existingClient);
        return clientMapper.toDto(existingClient);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
        clientRepository.delete(client);
    }
}