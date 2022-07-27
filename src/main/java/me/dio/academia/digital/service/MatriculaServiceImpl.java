package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    private final MatriculaRepository repository;
    private final AlunoRepository alunoRepository;

    public MatriculaServiceImpl(MatriculaRepository repository, AlunoRepository alunoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Matricula create(MatriculaForm form) throws Exception {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository
                .findById(
                        form.getAlunoId())
                .orElseThrow(Exception::new);
        matricula.setAluno(aluno);
        return repository.save(matricula);
    }

    @Override
    public Matricula get(Long id) throws Exception {
        return repository
                .findById(id)
                .orElseThrow(Exception::new);
    }

    @Override
    public List<Matricula> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    public List<Matricula> getMatriculaPorBairro(String bairro) {
        if (bairro == null) {
            return repository.findAll();
        } else {
            return repository.findByAlunoBairro(bairro);
        }
    }
}

