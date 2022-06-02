package p01;
import java.util.Random;

public class Modelo {
	private int valor;
	private Random r ;
	public Modelo() {
		r = new Random();
		valor = r.nextInt(100);
	}
	
	public void setValor(int n) {
		valor = n;
	}
	public int getValor() {
		return valor;
	}
	public int incrementar() {
		valor++;
		return valor;
	}
	
	public int decrementar() {
		valor--;
		return valor;
	}
	
}
