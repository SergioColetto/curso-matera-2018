package com.matera.cursoferias.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matera.cursoferias.response.Carro;

@RestController
public class CarroApi {

	private List<Carro> lojaCarros = new ArrayList<>();
	
	@GetMapping(path="/lojaCarros/{id}")
	private ResponseEntity<?> findById(@PathVariable String id){
		Optional<Carro> carro = lojaCarros.stream()
				.filter(c -> c.getId().equals(id))
				.findFirst();
		
		if (carro.isPresent())
			return ResponseEntity.ok(carro.get());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
	}
	
	@GetMapping(path = "/lojaCarros", produces = "application/json")
	public ResponseEntity<List<Carro>> findByParam(
			@RequestParam(required = false, defaultValue = "") String cor,
			@RequestParam(required = false, defaultValue = "") String ano ){
		
		Optional<List<Carro>> carrosFiltrados = Optional.empty();
		
		if(!cor.isEmpty()){
			carrosFiltrados = Optional.ofNullable(lojaCarros.stream()
					.filter(c -> c.getCor().equals(cor))
					.collect(Collectors.toList()));
		}
		
		if(!ano.isEmpty()){
			carrosFiltrados = Optional.ofNullable(lojaCarros.stream()
					.filter(c -> c.getAno().equals(ano))
					.collect(Collectors.toList()));
		}
		
		if (carrosFiltrados.isPresent()) 
			return ResponseEntity.ok(carrosFiltrados.get());
			
		return ResponseEntity.ok(lojaCarros);

	}
	
	@PostMapping(path = "/lojaCarros", produces = "application/json")
	public ResponseEntity<Carro> save(@RequestBody Carro carro){
		lojaCarros.add(carro);
		return ResponseEntity.ok(carro);
	}

	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Carro carro){
		
		if (lojaCarros.remove(carro))
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
