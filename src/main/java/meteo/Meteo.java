package meteo;

public class Meteo implements Wyswietlanie {
	
	double temperatura;
	double wilgotnosc;
	double cisnienie;
	private Podmiot danePogodowe;

	public Meteo(Podmiot DanePogodowe) {
		this.danePogodowe = danePogodowe;
		danePogodowe.dodajWyswietlacz(this);
	}
	
	public void aktualizacja(double temperatura, double wilgotnosc, double cisnienie) {
		this.temperatura = temperatura;
		this.wilgotnosc = wilgotnosc;
		this.cisnienie = cisnienie;
		wyswietlanie();
		
	}

	public void wyswietlanie() {
		System.out.println("Aktualne warunki pogodowe: " + temperatura 
				+ "C, wilgotnosc:  " + wilgotnosc + " cisnienie " + cisnienie);
		
	}

}
