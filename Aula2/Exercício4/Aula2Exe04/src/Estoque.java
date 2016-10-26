
public class Estoque {
	private String nome;
	private int qtdAtual;
	private int qtdMinima;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdAtual() {
		return qtdAtual;
	}
	public void setQtdAtual(int qtdAtual) {
		if (qtdAtual < 0){
			this.qtdAtual = 0;
		}
		else{
			this.qtdAtual = qtdAtual;
		}
	}
	public int getQtdMinima() {
		return qtdMinima;
	}
	public void setQtdMinima(int qtdMinima) {
		if (qtdAtual < 0){
			this.qtdAtual = 0;
		}
		else{
			this.qtdMinima = qtdMinima;
		}
	}
	
	public void mudarNome(String nome){
		this.nome = nome;
	}
	
	public void mudarQtdMinima(int qtdMinima){
		this.qtdMinima = qtdMinima;
	}
	
	public void repor(int qtd){
		qtdAtual += qtd;
	}
	
	public void darBaixa(int qtd){
		qtdAtual -= qtd;
	}
	
	public String mostra(){
		return nome + " " + qtdAtual + " " + qtdMinima;
	}
	
	public boolean precisaRepor(){
		if (qtdAtual < qtdMinima){
			return true;
		}
		else{
			return false;
		}
	}
}
