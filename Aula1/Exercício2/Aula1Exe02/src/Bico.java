
public class Bico {
	private Combustivel combustivel;	
	private int qtdCombustivel;
	
	public Combustivel getCombustivel() {
		return combustivel;
	}
	
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public int getQtdCombustivel() {
		return qtdCombustivel;
	}

	public void setQtdCombustivel(int qtdCombustivel) {
		this.qtdCombustivel = qtdCombustivel;
	}

	public float calcularValor() {
		
        float valorTotal = 0f;
        
        if(qtdCombustivel < 10)
        {
        	valorTotal = qtdCombustivel * combustivel.getPreco();
        }
        else
        {
        	valorTotal = qtdCombustivel * combustivel.getPrecoDesconto();
        }
        
        return valorTotal;
	}
}
