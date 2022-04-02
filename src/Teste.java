import java.util.Arrays;

public class Teste {
	public static void main (String[] args) {
		try {
			Estacionamento t1 = new Estacionamento(5);
			t1.entrar("abc23", 1);
			t1.consultarPlaca("abc23");
			t1.consultarVaga(1);

			System.out.println(Arrays.toString(t1.getPlacas()));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
