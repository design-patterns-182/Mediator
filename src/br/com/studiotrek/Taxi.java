package br.com.studiotrek;

public class Taxi {

	private CentralTaxi central;
	private Integer id;
	private static Integer contator = 0;

	public Taxi(CentralTaxi central) {
		this.central = central;
		this.id = Taxi.contator++;
	}

	public Integer getId() {
		return id;
	}

	public void atende() {
		try {
			Thread.sleep((long) (Math.random() * 3000.0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.central.acionarTaxiDisponivel(this);
	}

}
