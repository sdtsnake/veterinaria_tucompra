package work.appdeploys.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.appdeploys.veterinaria.models.DetalleHistoriaClinica;

import java.util.List;

@Repository
public interface DetalleHistoriaClinicaRepository extends JpaRepository<DetalleHistoriaClinica, Long> {
    List<DetalleHistoriaClinica> findAllByHistoriaClinica_IdOrderByFechaHoraDesc(Long idHistoriaClinica);
}