package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Aluno;
import com.example.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public List<Aluno> buscaTodosAlunos(){
		return alunoRepository.findAll();
	}
	
	public List<Aluno> buscarAlunosPorCidade(String cidade) {
		return alunoRepository.findByCidade(cidade);
	}
	public List<Aluno> buscarAlunosPorRenda(Double renda) {
		return alunoRepository.findByRenda(renda);
	}
	public List<Aluno> buscarAlunosPorRa(String ra) {
		return alunoRepository.findByRa(ra);
	}
	//@query
	public List<Aluno> buscarAlunosPorCidadeERenda(String cidade, Double renda) {
		return alunoRepository.findByCidadeAndRenda(cidade, renda);
	}
	//@query
	public List<Aluno> findByNomeCompletoLike(String nomeCompleto) {
		return alunoRepository.findByNomeLike(nomeCompleto);
	}
	public List<Aluno> findByNome (String nome) {
		return alunoRepository.findByNome(nome);
	}
	//@query
	public List<Aluno> findByTurmaId(Long turmaId) {
		return alunoRepository.findByTurmaId(turmaId);
	}
	
	public Aluno buscaAlunoId(Long id) {
		Optional <Aluno> Aluno = alunoRepository.findById(id);
		return Aluno.orElse(null);
	}
	public Aluno salvaAluno (Aluno Aluno) {
		return alunoRepository.save(Aluno);
	}
	public Aluno alterarAluno(Long id, Aluno alterarA) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alterarA.setId(id);
			return alunoRepository.save(alterarA);
		}
		return null;
	}
	public boolean apagarAluno(Long id) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
