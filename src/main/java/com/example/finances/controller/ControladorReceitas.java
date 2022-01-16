package com.example.finances.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finances.exception.ExcecaoConteudoNaoEncontrado;
import com.example.finances.model.Receitas;
import com.example.finances.repository.RepositorioReceitas;

@RestController
@RequestMapping("/api/v1")
public class ControladorReceitas {

	@Autowired
	private RepositorioReceitas repositorioReceitas;

	// Listar Receitas
	@GetMapping("/receitas")
	public List<Receitas> obterDespesas() {
		return repositorioReceitas.findAll();
	}

	// Cadastrar Receitas
	@PostMapping("/receitas")
	public Receitas criarReceita(@RequestBody Receitas receitas) {
		return repositorioReceitas.save(receitas);
	}

	// Listar Receitas por ID
	@GetMapping("/receitas/{id}")
	public ResponseEntity<Receitas> obterReceitaPorId(@PathVariable Long id) {
		Receitas receita = repositorioReceitas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A receita não existe:" + id));
		return ResponseEntity.ok(receita);
	}

	// Editar Receitas
	@PutMapping("/receitas/{id}")
	public ResponseEntity<Receitas> atualizarReceitas(@PathVariable Long id, @RequestBody Receitas detalhesReceita) {
		Receitas receita = repositorioReceitas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A receita não existe: " + id));
		receita.setValor(detalhesReceita.getValor());
		receita.setDataRecebimento(detalhesReceita.getDataRecebimento());
		receita.setDataRecebimentoEsperado(detalhesReceita.getDataRecebimentoEsperado());
		receita.setDescricao(detalhesReceita.getDescricao());
		receita.setTipoReceita(detalhesReceita.getTipoReceita());
		Receitas receitaAtualizada = repositorioReceitas.save(receita);
		return ResponseEntity.ok(receitaAtualizada);
	}

	// Deletar Receitas
	@DeleteMapping("/receitas/{id}")
	public ResponseEntity<Map<String, Boolean>> deletarReceita(@PathVariable Long id) {
		Receitas receita = repositorioReceitas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A receita não existe:" + id));
		repositorioReceitas.delete(receita);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Excluido", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
