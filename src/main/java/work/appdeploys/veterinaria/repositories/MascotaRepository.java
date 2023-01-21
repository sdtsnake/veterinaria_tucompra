package work.appdeploys.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import work.appdeploys.veterinaria.models.Mascota;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {
    List<Mascota> findAllByUsuarioId_Id(Long id);

    @Query(value = "SELECT m from Mascota m where m.id not in (SELECT h.mascota.id FROM HistoriaClinica h)")
    List<Mascota> findAllByMascotasSinHistoria();
}
