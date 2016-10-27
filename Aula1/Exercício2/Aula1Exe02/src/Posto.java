import java.util.ArrayList;

public class Posto {
	private ArrayList<Bico> bicos;

	public Posto()
	{
		bicos = new ArrayList<Bico>();
	}
	
	public void AddBicos(Bico bico) {
		
		this.bicos.add(bico);
	}
	
	public float CalcularTotal()
	{
		float valorTotal = 0;
		
		for(Bico bico : bicos)
		{
			valorTotal += bico.calcularValor();
		}
		
		if(valorTotal > 70)
			valorTotal *= 0.9;
		
		return valorTotal;
	}
}
