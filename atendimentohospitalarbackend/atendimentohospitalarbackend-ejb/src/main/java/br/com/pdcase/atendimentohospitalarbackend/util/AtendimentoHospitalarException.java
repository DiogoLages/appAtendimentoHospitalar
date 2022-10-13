package br.com.pdcase.atendimentohospitalarbackend.util;

public class AtendimentoHospitalarException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String[] parametros;

	public AtendimentoHospitalarException(String chave, String... parametros) {
		super(chave);
		this.parametros = parametros;
	}
	
	public String[] getParametros() {
		return parametros;
	}

	public void setParametros(String[] parametros) {
		this.parametros = parametros;
	}

}
