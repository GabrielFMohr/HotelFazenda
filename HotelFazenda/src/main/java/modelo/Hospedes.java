package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Hospedes {
	
	private int HospedeId;
	private String Nome, CPF,  Sobrenome, Nacionalidade, Pronome, Email;
	private Date DataNasc;
	private Usuarios IdUsuario;


	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public int getHospedeId() {
		return HospedeId;
	}
	public void setHospedeId(int hospedeId) {
		HospedeId = hospedeId;
	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public Usuarios getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(Usuarios idUsuario) {
		this.IdUsuario = idUsuario;
	}
	public String getCPF() {
		return CPF;
	}
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}
	public String getNacionalidade() {
		return Nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		Nacionalidade = nacionalidade;
	}
	public String getPronome() {
		return Pronome;
	}
	public void setPronome(String pronome) {
		Pronome = pronome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getDataNasc() {
		return DataNasc;
	}
	public void setDataNasc(Date data_nasc) {
		DataNasc = data_nasc;
	}

	
	
	
	

}