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
import com.example.finances.model.Contas;
import com.example.finances.repository.RepositorioContas;

@RestController
@RequestMapping("/api/v1")
public class ControladorContas {

	@Autowired
	private RepositorioContas repositorioContas;

	// Listar Contas
	@GetMapping("/contas")
	public List<Contas> obterContas() {
		return repositorioContas.findAll();
	}

	// Listar por ID
	@GetMapping("/contas/{id}")
	public ResponseEntity<Contas> obterContaPorId(@PathVariable Long id) {
		Contas conta = repositorioContas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A conta não existe:" + id));
		return ResponseEntity.ok(conta);
	}

	// Cadastrar Contas
	@PostMapping("/contas")
	public Contas criarConta(@RequestBody Contas contas) {
		return repositorioContas.save(contas);
	}

	// Editar Conta
	@PutMapping("/contas/{id}")
	public ResponseEntity<Contas> atualizarConta(@PathVariable Long id, @RequestBody Contas detalhesConta) {
		Contas conta = repositorioContas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A conta não existe: " + id));
		conta.setSaldo(detalhesConta.getSaldo());
		conta.setTipoConta(detalhesConta.getTipoConta());
		conta.setInstituicaoFinanceira(detalhesConta.getInstituicaoFinanceira());
		Contas contaAtualizada = repositorioContas.save(conta);
		return ResponseEntity.ok(contaAtualizada);
	}

	// Deletar Conta
	@DeleteMapping("/contas/{id}")
	public ResponseEntity<Map<String, Boolean>> deletarConta(@PathVariable Long id) {
		Contas conta = repositorioContas.findById(id)
				.orElseThrow(() -> new ExcecaoConteudoNaoEncontrado("A conta não existe:" + id));
		repositorioContas.delete(conta);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Excluido", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}