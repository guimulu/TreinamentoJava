/*
Um determinado material radioativo perde metade de sua massa a cada 50 segundos. Dada amassa inicial, em

gramas, fazer um programa que determine o tempo necessário para que essa massa se torne menor que 0,5

grama. Escreva a massa inicial, a massa final e o tempo calculado em horas, minutos e segundos.
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Radioativo radio = new Radioativo(0.5);
	    System.out.println("Massa inicial: " + radio.getMassaInicial());		
        System.out.println("Massa final: " + radio.verificaMassa());
        System.out.println("Tempo: " + radio.calculaTempo());
	}

}
