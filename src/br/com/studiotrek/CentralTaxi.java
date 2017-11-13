package br.com.studiotrek;

import java.util.ArrayList;
import java.util.List;

public class CentralTaxi {

	private List<Taxi> taxistaLivre = new ArrayList<Taxi>();
	private List<Passageiro> passageiroEspera = new ArrayList<Passageiro>();

	public synchronized void acionarTaxiDisponivel(Taxi taxi) {
		System.out.println("Taxi " + taxi.getId() + " voltou a fila");
		taxistaLivre.add(taxi);
		this.notifyAll();
	}

	public void pedeTaxi(Passageiro passageiro) {
		Taxi taxi = this.esperaTaxi(passageiro);
		System.out.println("Taxi " + taxi.getId() + " levando " + passageiro.getNome());
		taxi.atende();
	}

	private Taxi esperaTaxi(Passageiro passageiro) {
		this.passageiroEspera.add(passageiro);
		
		synchronized (this) {
			while(this.taxistaLivre.isEmpty()
					|| !this.passageiroEspera.get(0).equals(passageiro)) {
				try {
					this.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			this.passageiroEspera.remove(0);
			return this.taxistaLivre.remove(0);
		}
	}

}
