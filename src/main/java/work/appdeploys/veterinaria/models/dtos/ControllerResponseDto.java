package work.appdeploys.veterinaria.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerResponseDto<T> {
    private String error;
    private T data;


    public static <T> ControllerResponseDto<T> fromError(Exception e){
        return new ControllerResponseDto<>(e.getMessage(),null);
    }
    public static <T> ControllerResponseDto<T> fromError(String error){
        return new ControllerResponseDto<>(error,null);
    }

    public static <T> ControllerResponseDto<T> fromValid(T t){
        return new ControllerResponseDto<>(null,t);
    }

}
