import java.util.Arrays;

public class Teste {
	public static void main (String[] args) {
		try {
			Estacionamento t1 = new Estacionamento(5);
			t1.entrar("abc23", 1);
			t1.entrar("teste", 4);
			t1.consultarPlaca("abc23");
			t1.consultarVaga(1);
			t1.transferir(1, 5);
			
			System.out.println(Arrays.toString(t1.consultarGeral()));
			System.out.println(Arrays.toString(t1.consultarLivre()));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
