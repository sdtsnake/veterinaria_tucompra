package work.appdeploys.veterinaria.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.veterinaria.models.dtos.UsuarioDto;
import work.appdeploys.veterinaria.services.UsuarioService;

import javax.validation.Valid;

@Tag(name="Usuario")
@RequiredArgsConstructor
@RequestMapping(value = "/api/veterinaria/")
@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioDto> save(@RequestBody @Valid UsuarioDto usuarioDto){
        try{
            return ResponseEntity.ok(usuarioService.save(usuarioDto));
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
