package matera.systems.cursoferias2018.api.repository;

import matera.systems.cursoferias2018.api.domain.entity.AlunosDisciplinasEntity;
import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("stub")
public class AlunosDisciplinasRepositoryStub implements AlunosDisciplinasRepository {

	public static final UUID ALUNO_1 = UUID.fromString("bc51c8bb-bad3-47e4-af0c-7f467148f23d");
	public static final UUID ALUNO_2 = UUID.fromString("4a8975d1-9e37-4872-bd35-1050707484f8");
	public static final UUID ALUNO_3 = UUID.fromString("3480ed0e-2c8d-4a69-a8ed-7a2f136c4c20");

	public static final UUID DISCIPLINA_1 = UUID.fromString("bc51c8bb-bad3-47e4-af0c-7f467148f23d");
	public static final UUID DISCIPLINA_2 = UUID.fromString("4a8975d1-9e37-4872-bd35-1050707484f8");
	public static final UUID DISCIPLINA_3 = UUID.fromString("3480ed0e-2c8d-4a69-a8ed-7a2f136c4c20");

	private static final Map<UUID, AlunosDisciplinasEntity> data = new HashMap<>();

	static {
		{
			DisciplinaEntity rest = new DisciplinaEntity();
			rest.setId(DISCIPLINA_1);
			rest.setDescricao("Rest Java");
			rest.getInstrutores().add(new UsuarioEntity());
			rest.setDataInicio("23-01-2018");
			rest.setDataTermino("02-02-2018");
			rest.setSegmento("backend");
			rest.setUrlLogo("java.jpg");
			
			UsuarioEntity aluno1 = new UsuarioEntity();
			aluno1.setUuid(ALUNO_1);
			aluno1.setEmail("usuario_1@domain.com");
			aluno1.setLogin("usuario_1");
			aluno1.setNome("Usuario Um");
			aluno1.setPerfil("USUARIO");
			aluno1.setSenha("senha");
			aluno1.setUrlPhoto("http://bucket/usuario/1/perfil.png");

			UsuarioEntity aluno2 = new UsuarioEntity();
			aluno2.setUuid(ALUNO_2);
			aluno2.setEmail("usuario_2@domain.com");
			aluno2.setLogin("usuario_2");
			aluno2.setNome("Usuario Dois");
			aluno2.setPerfil("ADMINISTRADOR");
			aluno2.setSenha("senha");
			aluno2.setUrlPhoto("http://bucket/usuario/2/perfil.png");

			UsuarioEntity aluno3 = new UsuarioEntity();
			aluno3.setUuid(ALUNO_3);
			aluno3.setEmail("usuario_3@domain.com");
			aluno3.setLogin("usuario_3");
			aluno3.setNome("Usuario Tres");
			aluno3.setPerfil("USUARIO");
			aluno3.setSenha("senha");
			aluno3.setUrlPhoto("http://bucket/usuario/3/perfil.png");
			
			AlunosDisciplinasEntity ad = new AlunosDisciplinasEntity();
			ad.setDiscilina(rest);
			ad.getAlunos().add(aluno1);
			ad.getAlunos().add(aluno2);
			ad.getAlunos().add(aluno3);
			data.put(rest.getId(), ad);
		}
		{
			DisciplinaEntity angular = new DisciplinaEntity();
			angular.setId(DISCIPLINA_2);
			angular.setDescricao("Angular");
			angular.getInstrutores().add(new UsuarioEntity());
			angular.setDataInicio("23-01-2018");
			angular.setDataTermino("02-02-2018");
			angular.setSegmento("Frontand");
			angular.setUrlLogo("angular.jpg");
			
			UsuarioEntity aluno1 = new UsuarioEntity();
			aluno1.setUuid(ALUNO_1);
			aluno1.setEmail("usuario_1@domain.com");
			aluno1.setLogin("usuario_1");
			aluno1.setNome("Usuario Um");
			aluno1.setPerfil("USUARIO");
			aluno1.setSenha("senha");
			aluno1.setUrlPhoto("http://bucket/usuario/1/perfil.png");

			UsuarioEntity aluno2 = new UsuarioEntity();
			aluno2.setUuid(ALUNO_2);
			aluno2.setEmail("usuario_2@domain.com");
			aluno2.setLogin("usuario_2");
			aluno2.setNome("Usuario Dois");
			aluno2.setPerfil("ADMINISTRADOR");
			aluno2.setSenha("senha");
			aluno2.setUrlPhoto("http://bucket/usuario/2/perfil.png");

			AlunosDisciplinasEntity ad = new AlunosDisciplinasEntity();
			ad.setDiscilina(angular);
			ad.getAlunos().add(aluno1);
			ad.getAlunos().add(aluno2);
			data.put(angular.getId(), ad);
		}
		{
			DisciplinaEntity ionic = new DisciplinaEntity();
			ionic.setId(DISCIPLINA_3);
			ionic.setDescricao("Ionic");
			ionic.getInstrutores().add(new UsuarioEntity());
			ionic.setDataInicio("23-01-2018");
			ionic.setDataTermino("02-02-2018");
			ionic.setSegmento("mobile");
			ionic.setUrlLogo("Ionic.jpg");
			
			UsuarioEntity aluno1 = new UsuarioEntity();
			aluno1.setUuid(ALUNO_1);
			aluno1.setEmail("usuario_1@domain.com");
			aluno1.setLogin("usuario_1");
			aluno1.setNome("Usuario Um");
			aluno1.setPerfil("USUARIO");
			aluno1.setSenha("senha");
			aluno1.setUrlPhoto("http://bucket/usuario/1/perfil.png");
			
			AlunosDisciplinasEntity ad = new AlunosDisciplinasEntity();
			ad.setDiscilina(ionic);
			ad.getAlunos().add(aluno1);
			data.put(ionic.getId(), ad);
		}
	}

	@Override
	public Optional<List<UsuarioEntity>> findAlunosByDisciplina(UUID disciplinaId) {
		return Optional.ofNullable(data.getOrDefault(disciplinaId, null).getAlunos());
	}

}
