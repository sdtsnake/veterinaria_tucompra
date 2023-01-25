package work.appdeploys.veterinaria.services;

import java.util.List;

public interface CRUDService<S> {
    void delete(Long id);
    S update(S dto);
    List<S> findAll();
    S findById(Long id);
}
