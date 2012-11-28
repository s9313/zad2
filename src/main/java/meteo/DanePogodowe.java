package meteo;

import java.util.*;

public class DanePogodowe implements Podmiot {
	private ArrayList wyswietlanie1;
	private double temperatura;
	private double wilgotnosc;
	private double cisnienie;
	
	public DanePogodowe() {
		wyswietlanie1 = new ArrayList();
	}
	
	public void dodajWyswietlacz(Wyswietlanie w) {
		wyswietlanie1.add(w);
	}
	
	public void usunWyswietlacz(Wyswietlanie w) {
		int i = wyswietlanie1.indexOf(w);
		if (i >= 0) {
			wyswietlanie1.remove(i);
		}
	}
	
	public void wyslijDaneDoWyswietlaczy() {
		for (int i = 0; i < wyswietlanie1.size(); i++) {
			Wyswietlanie wyswietlanie = (Wyswietlanie)wyswietlanie1.get(i);
			wyswietlanie.aktualizacja(temperatura, wilgotnosc, cisnienie);
		}
	}
	
	public void zmianaPomiarow() {
		wyslijDaneDoWyswietlaczy();
	}
	
	public void ustawPomiary(double temperatura, double wilgotnosc, double cisnienie) {
		this.temperatura = temperatura;
		this.wilgotnosc = wilgotnosc;
		this.cisnienie = cisnienie;
		zmianaPomiarow();
	}
	
	public double pobierzTemperature() {
		return temperatura;
	}
	
	public double pobierzWilgotnosc() {
		return wilgotnosc;
	}
	
	public double pobierzCisnienie() {
		return cisnienie;
	}

}
