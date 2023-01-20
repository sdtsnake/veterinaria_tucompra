package work.appdeploys.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.appdeploys.veterinaria.models.Usuario;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    List<Usuario> findAllByDocumentoId(Integer documentoId);
    Optional<Usuario> findByDocumentoId(Integer documentoId);
}
