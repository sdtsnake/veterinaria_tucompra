package work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.entity.HistoriaClinicaEntity;
import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoriaClinicaOutRepository extends JpaRepository<HistoriaClinicaEntity,Long> {
    Optional<HistoriaClinicaEntity> findByMascota_Id(Long id);
    List<HistoriaClinicaEntity> findAllByMascota_Id(Long id);
}
