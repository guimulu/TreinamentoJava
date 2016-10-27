package br.com.meta.aula3exe10.jogo;
import java.util.ArrayList;

import br.com.meta.aula3exe10.jogo.animais.*;

public class Jogo {
	private ArrayList<Animal> animais;
	
	public Jogo(){
		animais = new ArrayList<Animal>();
	}
	
	public void addAnimais(Animal animal){
		this.animais.add(animal);		
	}
	
	public String processaAnimais(boolean mamifero, boolean quadrupede, boolean carnivoro, boolean herbivoro){
		String texto = "";
		for (Animal animal : animais){
			if (animal.isMamifero() == mamifero && animal.isQuadrupede() == quadrupede && animal.isCarnivoro() == carnivoro && animal.isHerbivoro() == herbivoro){
				texto += animal.getNome() + " ";
			}
		}
		return texto;
	}
}
