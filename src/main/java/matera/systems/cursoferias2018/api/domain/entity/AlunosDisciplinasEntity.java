package matera.systems.cursoferias2018.api.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class AlunosDisciplinasEntity {

	private DisciplinaEntity discilina;
	private List<UsuarioEntity> alunos = new ArrayList<>();

	public List<UsuarioEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<UsuarioEntity> alunos) {
		this.alunos = alunos;
	}

	public DisciplinaEntity getDiscilina() {
		return discilina;
	}

	public void setDiscilina(DisciplinaEntity discilina) {
		this.discilina = discilina;
	}

}
