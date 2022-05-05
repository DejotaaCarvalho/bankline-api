package com.dio.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.dto.NovoCorrentistadto;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import com.dio.santander.bankline.api.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoRepository repository; //consegue buscar informacoes do banco relacionado aos correntistas
	
	@Autowired
	private MovimentacaoService service; //contem regra de negocio para salver o correntista com o numero da conta gerado e o saldo zerado
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();  	//traga os correntistas do banco
	}
	
	@PostMapping  
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
	}
	
}
