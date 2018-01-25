package matera.systems.cursoferias2018.api.domain.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import matera.systems.cursoferias2018.api.domain.request.CriaUsuarioRequest;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;

@Service
public class UsuarioService {

	private Map<UUID, UsuarioEntity> db = new HashMap<>();
	
	public UUID criaUsuario( CriaUsuarioRequest usuarioRequest ){
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setNome(usuarioRequest.getNome());
		usuario.setNome(usuarioRequest.getEmail());
		usuario.setNome(usuarioRequest.getLogin());
		usuario.setNome(usuarioRequest.getPerfil());
		usuario.setNome(usuarioRequest.getUrlPhoto());
		db.put(usuario.getUuid(), usuario);
		return usuario.getUuid();
	}

	public List<UsuarioResponse> buscaTodosUsuarios() {
		return db.values()
					.stream()
					.map(entity -> {
						UsuarioResponse ur = new UsuarioResponse();
						ur.setUuid(entity.getUuid());
						ur.setNome(entity.getNome());
						ur.setLogin(entity.getLogin());
						ur.setEmail(entity.getEmail());
						ur.setPerfil(entity.getPerfil());
						ur.setUrlPhoto(entity.getUrlPhoto());
						return ur;
					})
					.collect(Collectors.toList());
	}
	
}
