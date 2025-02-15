package net.physiqueForge.ems.controller;

import lombok.AllArgsConstructor;
import net.physiqueForge.ems.dto.client.ClientRequestDTO;
import net.physiqueForge.ems.dto.client.ClientResponseDTO;
import net.physiqueForge.ems.dto.client.MasterClientDTO;
import net.physiqueForge.ems.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    // Build Add Client REST API
    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO savedClient = (ClientResponseDTO) clientService.createClient(clientRequestDTO);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    // Build Get Client By ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable("id") Long id) {
        ClientResponseDTO clientResponseDTO = (ClientResponseDTO) clientService.getClientById(id);
        return ResponseEntity.ok(clientResponseDTO);
    }

    // Build Get All Clients REST API
    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> clients = clientService.getAllClients();  // Make sure service returns ClientResponseDTO
        return ResponseEntity.ok(clients);
    }

    // Build Update Client REST API
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable("id") Long clientId,
                                                          @RequestBody ClientRequestDTO updatedClient) {
        ClientResponseDTO updatedClientDto = (ClientResponseDTO) clientService.updateClient(clientId, updatedClient);
        return ResponseEntity.ok(updatedClientDto);
    }

    // Build Delete Client REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok("Client deleted successfully");
    }
}