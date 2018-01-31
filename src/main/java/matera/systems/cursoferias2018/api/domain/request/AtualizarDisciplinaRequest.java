package matera.systems.cursoferias2018.api.domain.request;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

public class AtualizarDisciplinaRequest {

	private UUID id;
	private String descricao;
	private List<UsuarioEntity> instrutores = new ArrayList<>();
	private String dataInicio;
	private String dataTermino;
	private String segmento;
	private String urlLogo;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<UsuarioEntity> getInstrutores() {
		return instrutores;
	}

	public void setInstrutores(List<UsuarioEntity> instrutores) {
		this.instrutores = instrutores;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	
}