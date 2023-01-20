package work.appdeploys.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import work.appdeploys.veterinaria.models.Colaborador;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    List<Colaborador> findAllByDocumentoIdentificacion(Integer id);
    Optional<Colaborador> findByDocumentoIdentificacion(Integer id);
}