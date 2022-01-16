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
import com.example.finances.model.Despesas;
import com.example.finances.repository.RepositorioDespesas;

@RestController
@RequestMapping("/api/v1")
public class ControladorDespesas {

	@Autowired
	private RepositorioDespesas repositorioDespesas;

	// Listar Despesas
	@GetMapping("/despesas")
	public List<Despesas> obterDespesas() {
		return repositorioDespesas.findAll();
	}

	// Listar despesa por ID
	@GetMapping("/despesas/{id}")
	public ResponseEntity<Despesas> obterDespesaPorId(@PathVariable Long id) {
		Despesas despesa = repositorioDespesas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A despesa não existe:" + id));
		return ResponseEntity.ok(despesa);
	}

	// Cadastrar despesas
	@PostMapping("/despesas")
	public Despesas criarDespesas(@RequestBody Despesas despesas) {
		return repositorioDespesas.save(despesas);
	}

	// Editar Despesas
	@PutMapping("/despesas/{id}")
	public ResponseEntity<Despesas> atualizarDespesas(@PathVariable Long id, @RequestBody Despesas detalhesDespesa) {
		Despesas despesa = repositorioDespesas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A despesa não existe: " + id));
		despesa.setValor(detalhesDespesa.getValor());
		despesa.setDataPagamento(detalhesDespesa.getDataPagamento());
		despesa.setDataPagamentoEsperado(detalhesDespesa.getDataPagamentoEsperado());
		despesa.setTipoDespesas(detalhesDespesa.getTipoDespesas());
		Despesas despesaAtualizada = repositorioDespesas.save(despesa);
		return ResponseEntity.ok(despesaAtualizada);
	}

	// Deletar Despesas
	@DeleteMapping("/despesas/{id}")
	public ResponseEntity<Map<String, Boolean>> deletarDespesa(@PathVariable Long id) {
		Despesas despesa = repositorioDespesas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A despesa não existe:" + id));
		repositorioDespesas.delete(despesa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Excluido", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}