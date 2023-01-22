package work.appdeploys.veterinaria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DetalleHistoriaClinicaExeptionBadRequest extends  RuntimeException {

    public DetalleHistoriaClinicaExeptionBadRequest(String message) {
        super(message);
    }
}
