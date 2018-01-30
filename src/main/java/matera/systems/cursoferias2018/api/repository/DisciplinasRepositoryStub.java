package matera.systems.cursoferias2018.api.repository;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("stub")
public class DisciplinasRepositoryStub implements DisciplinasRepository {

	public static final UUID DISCIPLINA_1 = UUID.fromString("bc51c8bb-bad3-47e4-af0c-7f467148f23d");
	public static final UUID DISCIPLINA_2 = UUID.fromString("4a8975d1-9e37-4872-bd35-1050707484f8");
	public static final UUID DISCIPLINA_3 = UUID.fromString("3480ed0e-2c8d-4a69-a8ed-7a2f136c4c20");

	private static final Map<UUID, DisciplinaEntity> data = new HashMap<>();

	static {
		{
			DisciplinaEntity disciplina = new DisciplinaEntity();
			disciplina.setId(DISCIPLINA_1);
			disciplina.setDescricao("Rest Java");
			disciplina.getInstrutores().add(new UsuarioEntity());
			disciplina.setDataInicio("23-01-2018");
			disciplina.setDataTermino("02-02-2018");
			disciplina.setSegmento("backend");
			disciplina.setUrlLogo("java.jpg");
			
			data.put(DISCIPLINA_1, disciplina);
		}
		{
			DisciplinaEntity entity = new DisciplinaEntity();
			entity.setId(DISCIPLINA_2);
			entity.setDescricao("AngularJS");
			entity.getInstrutores().add(new UsuarioEntity());
			entity.setDataInicio("23-01-2018");
			entity.setDataTermino("02-02-2018");
			entity.setSegmento("frontend");
			entity.setUrlLogo("Angular.jpg");
			data.put(DISCIPLINA_2, entity);
		}
		{
			DisciplinaEntity entity = new DisciplinaEntity();
			entity.setId(DISCIPLINA_3);
			entity.setDescricao("Rest Java");
			entity.getInstrutores().add(new UsuarioEntity());
			entity.setDataInicio("23-01-2018");
			entity.setDataTermino("02-02-2018");
			entity.setSegmento("mobile");
			entity.setUrlLogo("java.jpg");
			data.put(DISCIPLINA_3, entity);
		}
	}

	@Override
	public UUID criar(DisciplinaEntity usuario) {
		UUID uuid = UUID.randomUUID();
		data.put(uuid, usuario);
		return uuid;
	}

	@Override
	public void deletar(UUID uuid) {
		data.remove(uuid);
	}

	@Override
	public List<DisciplinaEntity> listar() {
		return new ArrayList<>(data.values());
	}

	@Override
	public Optional<DisciplinaEntity> findByID(UUID uuid) {
		return Optional.ofNullable(data.getOrDefault(uuid, null));
	}

	@Override
	public void atualizar(DisciplinaEntity update) {
		data.put(update.getId(), update);
	}

}
