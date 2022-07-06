package gerenciador.modelo;

import java.util.Date;

public class Empresa {
	
	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	

}
