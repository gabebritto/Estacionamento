
public class Estacionamento {
	private String[] placas;
	
	public Estacionamento(int totalVagas) {
		this.setPlacas(new String[totalVagas]);
	}

	public void entrar(String placa, int vaga) throws Exception {
		vaga = vaga - 1;
		int totalDeVagas = this.placas.length;
		if (vaga < totalDeVagas || vaga > totalDeVagas) {
			throw new Exception("Vaga inv�lida. Digite uma vaga entre 1 e "+totalDeVagas);
		}
		else {
			if (this.placas[vaga] != null) {
				throw new Exception("A vaga j� est� ocupada");
			}
			else {
				/* Add to historico.csv*/
				this.placas[vaga] = placa;
			}
		}
	}
	
	public String[] getPlacas() {
		return placas;
	}

	public void setPlacas(String[] placas) {
		this.placas = placas;
	}
}
