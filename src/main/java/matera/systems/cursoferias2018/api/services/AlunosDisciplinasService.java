package matera.systems.cursoferias2018.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.repository.AlunosDisciplinasRepository;

@Service
public class AlunosDisciplinasService {

	@Autowired
	private AlunosDisciplinasRepository repository;

	private Function<UsuarioEntity, UsuarioResponse> toResponse = (entity) -> {
		UsuarioResponse response = new UsuarioResponse();
		
		response.setUuid(entity.getUuid());
		response.setNome(entity.getNome());
		response.setEmail(entity.getEmail());
		response.setLogin(entity.getLogin());
		response.setPerfil(entity.getPerfil());
		response.setUrlPhoto(entity.getUrlPhoto());
		return response;
	};

	public Optional<List<UsuarioResponse>> findAlunosByDisciplina(UUID id) {
		return Optional.ofNullable(repository.findAlunosByDisciplina(id)
					.get()
					.stream()
						.map(toResponse)
						.collect(Collectors.toList()));
	}

}
