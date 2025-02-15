package net.physiqueForge.ems.repository;

import net.physiqueForge.ems.model.ClientNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientNoteRepository extends JpaRepository<ClientNote, Long> {
    List<ClientNote> findByCreatedById(Long createdById);
}