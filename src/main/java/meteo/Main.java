package meteo;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		DanePogodowe danePogodowe = new DanePogodowe();
		
		Meteo meteo = new Meteo(danePogodowe);
		Statystyki statystyki = new Statystyki(danePogodowe);		
		
		danePogodowe.ustawPomiary(30, 200, 10);
	}

}
