package matera.systems.cursoferias2018.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.request.AtualizarDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.request.CriaDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.response.DisciplinaResponse;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.repository.DisciplinasRepository;

@Service
public class DisciplinasService {

	@Autowired
	private DisciplinasRepository repository;
	
	@Autowired
	private AlunosDisciplinasService alunosDisciplinasService;

	public UUID criar(CriaDisciplinaRequest request) {

		DisciplinaEntity entity = new DisciplinaEntity();

		entity.setId(UUID.randomUUID());
		entity.setDescricao(request.getDescricao());
		entity.setDataInicio(request.getDataInicio());
		entity.setDataTermino(request.getDataTermino());
		entity.setSegmento(request.getSegmento());
		entity.setUrlLogo(request.getUrlLogo());
		entity.getInstrutores().addAll(request.getInstrutores());

		return repository.criar(entity);
	}

	public void deletar(UUID usuarioID) {
		repository.deletar(usuarioID);
	}

	public void atualizar(UUID disciplinaId, AtualizarDisciplinaRequest request) {

		Optional<DisciplinaEntity> original = repository.findByID(disciplinaId);
		if (original.isPresent()) {

			final DisciplinaEntity update = original.get();

			if (request.getDescricao() != null) {
				update.setDescricao(request.getDescricao());
			}

			if (request.getDataInicio() != null) {
				update.setDataInicio(request.getDataInicio());
			}

			if (request.getDataTermino() != null) {
				update.setDataTermino(request.getDataTermino());
			}

			if (request.getSegmento() != null) {
				update.setSegmento(request.getSegmento());
			}

			if (request.getUrlLogo() != null) {
				update.setUrlLogo(request.getUrlLogo());
			}

			if (request.getInstrutores().size() > 0) {
				request.getInstrutores().forEach(e -> update.getInstrutores().add(e));
			}

			repository.atualizar(update);

		} else {
			throw new RuntimeException("Disciplina não encontrada");
		}
	}

	public List<DisciplinaResponse> getDisciplinas() {
		return repository.listar().parallelStream().map(toResponse).collect(Collectors.toList());
	}

	public Optional<DisciplinaResponse> findDisciplinaByID(UUID id) {
		return repository.findByID(id).map(toResponse);
	}

	private Function<DisciplinaEntity, DisciplinaResponse> toResponse = (entity) -> {
		DisciplinaResponse response = new DisciplinaResponse();
		
		response.setId(entity.getId());
		response.setDescricao(entity.getDescricao());
		response.setDataInicio(entity.getDataInicio());
		response.setDataTermino(entity.getDataTermino());
		response.setSegmento(entity.getSegmento());
		response.setUrlLogo(entity.getUrlLogo());
		return response;
	};

	public Optional<List<UsuarioResponse>> findAlunosByDisciplina(UUID disciplinaLogin) {
		return alunosDisciplinasService.findAlunosByDisciplina(disciplinaLogin);
	}

}
