
public class Letra {
	
	public String vogalConsoante(char letra){
		if (ehVogal(letra)){
			return "Vogal";
		}
		else{
			return "Consoante";
		}
	}
	
	public boolean ehVogal(char letra){
		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean ehConsoante(char letra){
		if (ehVogal(letra)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public String vogalConsoante(int asc){
		if (ehVogal(asc)){
			return "Vogal";
		}
		else{
			return "Consoante";
		}
	}
	
	public boolean ehVogal(int asc){	
		if (asc == 97 || asc == 101 || asc == 105 || asc == 111 || asc == 117){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean ehConsoante(int asc){
		if (ehVogal(asc)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean verificaAsc(int asc){
		if (asc > 96 && asc < 123)
			return true;
		else
			return false;
		
	}
	
}
