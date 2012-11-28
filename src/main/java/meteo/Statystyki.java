package meteo;

public class Statystyki implements Wyswietlanie {
	
	private double temperatura;
	private double wilgotnosc;
	private double cisnienie;
	private DanePogodowe danePogodowe;
	
	public Statystyki(DanePogodowe danePogodowe) {
		this.danePogodowe = danePogodowe;
		danePogodowe.dodajWyswietlacz(this);
	}

	public void aktualizacja(double temp, double wilg, double cis) {
		this.temperatura = temp;
		this.wilgotnosc = wilg;
		this.cisnienie = cis;
		wyswietlanie();
	}

	public void wyswietlanie() {
		System.out.println("Statystyki: ");	
		System.out.println("Temperatura = " + temperatura);
		System.out.println("Wilgotnosc = " + wilgotnosc);
		System.out.println("Cisnienie = " + cisnienie);
	}
}
