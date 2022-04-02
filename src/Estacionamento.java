
public class Estacionamento {
	private String[] placas;
	
	public Estacionamento(int totalVagas) throws Exception{
		if (totalVagas <= 0) {
			throw new Exception("Número de vagas inválido.");
		}
		else {
			placas = new String[totalVagas];
		}
	}

	public boolean vagaExiste(int vaga) {
		vaga = vaga - 1;
		int totalDeVagas = this.placas.length;
		if (vaga < 0 || vaga >= totalDeVagas) {
			return false;
		}
		else {
			return true;	
		}
	}
	
	public void entrar(String placa, int vaga) throws Exception {
		int totalDeVagas = this.placas.length;
		if (this.vagaExiste(vaga) == false) {
			throw new Exception("Vaga inválida. Digite uma vaga entre 1 e "+totalDeVagas);
		}
		else {
			if (this.placas[vaga-1] != null) {
				throw new Exception("A vaga já está ocupada");
			}
			else {
				/* Add to historico.csv*/
				this.placas[vaga-1] = placa;
			}
		}
	}
	
	public void sair(int vaga) throws Exception{
		int totalDeVagas = this.placas.length;
		if (this.vagaExiste(vaga) == false) {
			throw new Exception("Vaga inválida. Digite uma vaga entre 1 e "+totalDeVagas);
		}
		else {
			if (this.placas[vaga-1] == null) {
				throw new Exception("A vaga já está vazia.");
			}
			else {
				/*Add exit to historico.csv*/
				this.placas[vaga-1] = null;
			}
		}
	}
	
	public int consultarPlaca(String placa) {
		for (int i = 0; i < this.placas.length; i++) {
			if (this.placas[i] == placa) {
				System.out.println(i+1);
				return i+1;
			}
		}
		System.out.println(-1);	
		return -1;
	}
	
	public String consultarVaga(int vaga) throws Exception {
		int totalDeVagas = this.placas.length;
		if (this.vagaExiste(vaga) == false) {
			throw new Exception("Vaga inválida. Digite uma vaga entre 1 e "+totalDeVagas);
		}
		else {
			System.out.println(this.placas[vaga-1]);
			return this.placas[vaga-1];
			}
	}
	
	public void transferir(int vaga1,int vaga2) throws Exception{
		/*Desenvolver*/
	}
	
	public String[] consultarGeral() {
		/*Desenvolver*/
		String[] situação = new String[1];
		return situação;
	}
	
	public int[] consultarLivre() {
		/*Desenvolver*/
		int [] livres = new int[1];
		return livres;
	}
	
	public void lerDados() {
		/*Desenvolver*/
	}
	
	public void gravarDados() {
		/*Desenvolver*/
	}
	
	public String[] getPlacas() {
		return placas;
	}

	public void setPlacas(String[] placas) {
		this.placas = placas;
	}
}
