package br.com.meta.aula3exe10;

import java.util.Scanner;

import br.com.meta.aula3exe10.jogo.*;
import br.com.meta.aula3exe10.jogo.animais.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Jogo jogo = new Jogo();
		jogo.addAnimais(new Animal("Leão",     	true, 	true, 	true, 	false));
		jogo.addAnimais(new Animal("Cavalo",   	true,	true, 	false, 	true));
		jogo.addAnimais(new Animal("Homem", 	true, 	false, 	true, 	false));
		jogo.addAnimais(new Animal("Macaco",	true, 	false, 	false,	true));
		jogo.addAnimais(new Animal("Avestruz",	false, 	false, 	false, 	true));
		jogo.addAnimais(new Animal("Pinguim",	false, 	false, 	true, 	false));
		jogo.addAnimais(new Animal("Pato", 		false, 	false, 	false, 	true));
		jogo.addAnimais(new Animal("Águia", 	false, 	false, 	true, 	false));
		jogo.addAnimais(new Animal("Tartaruga",	false, 	true, 	true, 	true));
		jogo.addAnimais(new Animal("Crocodilo",	false, 	true, 	true, 	false));
		jogo.addAnimais(new Animal("Cobra", 	false, 	false, 	true, 	false));
		boolean mamifero;
		boolean quadrupede;
		boolean carnivoro;
		boolean herbivoro;
		
		System.out.println("É mamífero?");
		String aux = input.nextLine();
		if (aux.equals("sim"))  mamifero = true;
		else mamifero = false;
		
		System.out.println("É quadrúpede?");
		aux = input.nextLine();
		if (aux.equals("sim"))  quadrupede = true;
		else quadrupede = false;
		
		System.out.println("É carnívoro?");
		aux = input.nextLine();
		if (aux.equals("sim"))  carnivoro = true;
		else carnivoro = false;
		
		System.out.println("É herbívoro?");
		aux  = input.nextLine();
		if (aux.equals("sim"))  herbivoro = true;
		else herbivoro = false;
		
		System.out.println(jogo.processaAnimais(mamifero, quadrupede, carnivoro, herbivoro));
		
	}

}
