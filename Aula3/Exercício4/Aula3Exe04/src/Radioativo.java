
public class Radioativo {
	private double massaInicial;
    private double massaFinal;
    private int tempoGasto;
    
    public Radioativo(double massaInicial){
    	this.massaInicial = massaInicial;
    	this.massaFinal = massaInicial;
    	this.tempoGasto = 0;
    }
    
    public double getMassaInicial() {
		return massaInicial;
	}
    
    public double verificaMassa(){
    	while (massaFinal >= 0.5) {
            tempoGasto = tempoGasto + 50;
            massaFinal = massaFinal/2;
        }
    	return massaFinal;
    }
    
    public String calculaTempo(){
    	int segundos;
        int minutos;
        int horas;
        
    	horas = (tempoGasto / 3600);
        tempoGasto -= (tempoGasto / 3600) * 3600;
        minutos = (tempoGasto / 60);
        tempoGasto -= (tempoGasto / 60) * 60;
        segundos = tempoGasto;
        
        return horas + ":" + minutos + ":" + segundos;
    }
    
    
}
