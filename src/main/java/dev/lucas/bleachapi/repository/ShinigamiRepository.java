package dev.lucas.bleachapi.repository;

import dev.lucas.bleachapi.model.Shinigami;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShinigamiRepository  extends JpaRepository<Shinigami, Long> {

}
