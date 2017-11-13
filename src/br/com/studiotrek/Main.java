package br.com.studiotrek;

public class Main {

	public static void main(String[] args) {
		
		CentralTaxi central = new CentralTaxi();
		
		Passageiro passageiro1 = new Passageiro(central, "Alfredo");
		Passageiro passageiro2 = new Passageiro(central, "Olavo");
		Passageiro passageiro3 = new Passageiro(central, "Carmen");
		Passageiro passageiro4 = new Passageiro(central, "Ofelia");
		Passageiro passageiro5 = new Passageiro(central, "Luiz");
		
		Taxi taxi1 = new Taxi(central);
		central.acionarTaxiDisponivel(taxi1);
		
		Taxi taxi2 = new Taxi(central);
		central.acionarTaxiDisponivel(taxi2);
		
		new Thread(passageiro1).start();
		new Thread(passageiro2).start();
		new Thread(passageiro3).start();
		new Thread(passageiro4).start();
		new Thread(passageiro5).start();
	}
	
}
