package br.com.studiotrek;

public class Passageiro implements Runnable {

	private CentralTaxi central;
	private String nome;

	public Passageiro(CentralTaxi central, String nome) {
		this.central = central;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public void run() {
		this.central.pedeTaxi(this);
//		for (int i = 0; i < 5; i++) {
//			this.central.pedeTaxi(this);
//		}
	}

}
