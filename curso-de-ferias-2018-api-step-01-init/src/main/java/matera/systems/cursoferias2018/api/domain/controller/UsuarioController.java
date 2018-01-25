package matera.systems.cursoferias2018.api.domain.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matera.systems.cursoferias2018.api.domain.request.CriaUsuarioRequest;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.domain.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

	private final String URI_FACTORY = "/usuarios/";
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> criarUsuario( @RequestBody CriaUsuarioRequest usuario ){
		UUID uuid = service.criaUsuario(usuario);
		URI location = URI.create(URI_FACTORY + uuid.toString());		
		return ResponseEntity.created(location).build();
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<UsuarioResponse>> buscaTodosUsuarios(){
		return ResponseEntity.ok(service.buscaTodosUsuarios());
	}
	
}
