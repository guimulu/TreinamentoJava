package br.com.meta.aula3exe10.jogo.animais;

public class Animal {
	private String nome;
	private boolean mamifero;
	private boolean quadrupede;
	private boolean carnivoro;
	private boolean herbivoro;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isMamifero() {
		return mamifero;
	}

	public void setMamifero(boolean mamifero) {
		this.mamifero = mamifero;
	}

	public boolean isQuadrupede() {
		return quadrupede;
	}

	public void setQuadrupede(boolean quadrupede) {
		this.quadrupede = quadrupede;
	}

	public boolean isCarnivoro() {
		return carnivoro;
	}

	public void setCarnivoro(boolean carnivoro) {
		this.carnivoro = carnivoro;
	}

	public boolean isHerbivoro() {
		return herbivoro;
	}

	public void setHerbivoro(boolean herbivoro) {
		this.herbivoro = herbivoro;
	}

	public Animal(String nome, boolean mamifero, boolean quadrupede, boolean carnivoro, boolean herbivoro) {
		this.nome = nome;
		this.mamifero = mamifero;
		this.quadrupede = quadrupede;
		this.carnivoro = carnivoro;
		this.herbivoro = herbivoro;
	}
	
	
	
}
