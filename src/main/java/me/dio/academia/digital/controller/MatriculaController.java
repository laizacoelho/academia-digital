package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.MatriculaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    private final MatriculaServiceImpl service;

    public MatriculaController(MatriculaServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Matricula> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Matricula save(@RequestBody MatriculaForm matriculaForm) throws Exception {
        return service.create(matriculaForm);
    }

    @GetMapping("/{id}")
    public Matricula getById(@PathVariable Long id) throws Exception {
        return service.get(id);
    }

    @GetMapping("/bairros")
    public List<Matricula> getMatriculaPorBairro(@RequestParam(value = "bairro", required = false)
                                                     String bairro) {
        return service.getMatriculaPorBairro(bairro);
    }

}
