package com.dio.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bankline.api.dto.NovoCorrentistadto;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	@Autowired
	private CorrentistaRepository repository; //consegue buscar informacoes do banco relacionado aos correntistas
	
	@Autowired
	private CorrentistaService service; //contem regra de negocio para salver o correntista com o numero da conta gerado e o saldo zerado
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();  	//traga os correntistas do banco
	}
	
	@PostMapping  
	public void save(@RequestBody NovoCorrentistadto correntista) {
		service.save(correntista);
	}
	
}
