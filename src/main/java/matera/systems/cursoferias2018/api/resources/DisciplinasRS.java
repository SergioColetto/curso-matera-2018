package matera.systems.cursoferias2018.api.resources;

import matera.systems.cursoferias2018.api.domain.request.AtualizarDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.request.CriaDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.response.DisciplinaResponse;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.services.DisciplinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/disciplinas")
public class DisciplinasRS {

	@Autowired
	private DisciplinasService service;

	@PostMapping(consumes = { "application/json", "application/xml" })
	public ResponseEntity<String> create(@RequestBody CriaDisciplinaRequest request) {
		final UUID createdDisciplina = service.criar(request);
		return ResponseEntity.status(201).header("location", "/disciplinas/" + createdDisciplina).build();
	}

	@DeleteMapping(value = "{disciplinaID}")
	public ResponseEntity<Void> delete(@PathVariable String disciplinaID) {
		service.deletar(UUID.fromString(disciplinaID));
		return ResponseEntity.status(204).build();
	}

	@PutMapping(value = "{disciplinaID}", consumes = { "application/json", "application/xml" })
	public ResponseEntity<Void> update(@PathVariable String disciplinaID,
			@RequestBody AtualizarDisciplinaRequest request) {
		service.atualizar(UUID.fromString(disciplinaID), request);
		return ResponseEntity.status(200).build();
	}

	@GetMapping(produces = { "application/json", "application/xml" })
	public ResponseEntity<List<DisciplinaResponse>> all() {
		final List<DisciplinaResponse> usuarios = service.getDisciplinas();
		return ResponseEntity.status(200).body(usuarios);
	}

	@GetMapping(value = "{disciplinaID}", produces = { "application/json", "application/xml" })
	public ResponseEntity<DisciplinaResponse> findByID(@PathVariable String disciplinaID) {
		final Optional<DisciplinaResponse> disciplina = service.findDisciplinaByID(UUID.fromString(disciplinaID));

		if (disciplina.isPresent()) {
			return ResponseEntity.status(200).body(disciplina.get());
		} else {
			return ResponseEntity.status(404).build();
		}
	}

	@GetMapping(value = "{disciplinaID}/alunos", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<UsuarioResponse>> findAlunosByDisciplina(@PathVariable String disciplinaID) {
		final Optional<List<UsuarioResponse>> response = service
				.findAlunosByDisciplina(UUID.fromString(disciplinaID));

		if (response.isPresent()) {
			return ResponseEntity.status(200).body(response.get());
		} else {
			return ResponseEntity.status(404).build();
		}
	}

}
