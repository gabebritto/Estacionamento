import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

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

	public int totalvagas() {
		int totalDeVagas = this.placas.length;
		return totalDeVagas;
	}
	
	public boolean vagaExiste(int vaga) {
		vaga = vaga - 1;
		int totalDeVagas = this.totalvagas();
		if (vaga < 0 || vaga >= totalDeVagas) {
			return false;
		}
		else {
			return true;	
		}
	}
	
	public void entrar(String placa, int vaga) throws Exception {
		int totalDeVagas = this.totalvagas();
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
				FileWriter entrada = new FileWriter( new File("historico.csv"), true);
				entrada.write(new Date().toString()+";" + placa);
			}
		}
	}
	
	public void sair(int vaga) throws Exception{
		int totalDeVagas = this.totalvagas();
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
				FileWriter saida = new FileWriter( new File("historico.csv"), true);
				saida.write(new Date().toString() + ";" + this.placas[vaga-1]);
			}
		}
	}
	
	public int consultarPlaca(String placa) throws Exception{
		for (int i = 0; i < this.placas.length; i++) {
			if (this.placas[i] == placa) {
				return i+1;
			}
		}
		throw new Exception("Placa não encontrada.");
	}
	
	public String consultarVaga(int vaga) throws Exception {
		int totalDeVagas = this.totalvagas();
		if (this.vagaExiste(vaga) == false) {
			throw new Exception("Vaga inválida. Digite uma vaga entre 1 e "+totalDeVagas);
		}
		else {
			return this.placas[vaga-1];
			}
	}
	
	public void transferir(int vaga1,int vaga2) throws Exception{
		int totalDeVagas = this.totalvagas();
		if (this.vagaExiste(vaga1) == false || this.vagaExiste(vaga2) == false) {
			throw new Exception("Vaga inválida. Digite uma vaga entre 1 e "+totalDeVagas);
		}
		else {
			if (this.placas[vaga1-1] != null) {
				if (this.placas[vaga2-1] == null) {
					this.placas[vaga2-1] = this.placas[vaga1-1];
					this.placas[vaga1-1] = null;
				}
				else {
					throw new Exception("A vaga destino está ocupada.");
				}
			}
			else {
				throw new Exception("A vaga de origem está vazia.");
			}
		}
	}
	
	public String[] consultarGeral() {
		int totalDeVagas = this.totalvagas();
		String[] situacao = new String[totalDeVagas];
		for (int i=0; i<totalDeVagas; i++) {
			if (this.placas[i] != null) {
				situacao[i] = "ocupada";
			}
			else {
				situacao[i] = "livre";
			}
		}
		return situacao;
	}
	
	public int[] consultarLivre() {
		int totalDeVagas = this.totalvagas();
		int [] livres = new int[0];
		for (int i=0; i < totalDeVagas; i++) {
			if (this.placas[i] == null) {
				int[] newLivre = Arrays.copyOf(livres, livres.length + 1); 
				livres = newLivre;
				livres[livres.length-1] = i + 1;
			}
		}
		return livres;
	}
	
	@SuppressWarnings("unused")
	public void lerDados() {
		try {
			String cabecalho, vagas, posicao, placa;
			String[] dividir;
			Scanner arquivo = new Scanner( new File("placas.csv"));
			cabecalho = arquivo.nextLine();
			
			while (arquivo.hasNextLine()) {
				vagas = arquivo.nextLine();
				dividir = vagas.split(";");
				posicao = dividir[0];
				placa = dividir[1];
				System.out.println("Vaga"+ posicao + " " + placa);
			}
		}
		catch (IOException e){
			System.out.println("Arquivo não encontrado.");
		}
	}
	
	public void gravarDados() {
		try {
			int totalDeVagas = this.totalvagas();
			FileWriter dados = new FileWriter( new File("placas.csv"), false);
			dados.write("vaga;placa"+"\n");
			for (int i=0; i < totalDeVagas; i++) {
				
				if (this.placas[i] != null) {
					dados.write((i+1)+";"+this.placas[i]+"\n");
				}
				else {
					dados.write((i+1)+";"+"Vazia"+"\n");
				}
			}
			dados.close();
		} catch (IOException e) {
			System.out.println("Caminho não encontrado.");
		}
	}
	
	public String[] getPlacas() {
		return placas;
	}

	public void setPlacas(String[] placas) {
		this.placas = placas;
	}
}
