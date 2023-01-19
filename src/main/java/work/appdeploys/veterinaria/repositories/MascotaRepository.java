package work.appdeploys.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.appdeploys.veterinaria.models.Mascota;
import work.appdeploys.veterinaria.models.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {
    //Optional<List<Usuario>> findAllByusurioId(Integer documentoId);
}
