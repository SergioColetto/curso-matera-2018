package matera.systems.cursoferias2018.api.repository;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlunosDisciplinasRepository {

    Optional<List<UsuarioEntity>> findAlunosByDisciplina(UUID disciplinaId);

}
