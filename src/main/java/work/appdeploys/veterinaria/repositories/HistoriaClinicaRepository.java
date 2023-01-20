package work.appdeploys.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.appdeploys.veterinaria.models.HistoriaClinica;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica,Long> {
    Optional<HistoriaClinica> findByMascota_Id(Long id);
    List<HistoriaClinica> findAllByMascota_Id(Long id);
}
