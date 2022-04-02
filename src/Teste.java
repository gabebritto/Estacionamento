import java.util.Arrays;

public class Teste {
	public static void main (String[] args) {
		Estacionamento t1 = new Estacionamento(2);
		try {
			t1.entrar("abc23", 1);
			t1.entrar("abc23", 3);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(Arrays.toString(t1.getPlacas()));
	}
}
