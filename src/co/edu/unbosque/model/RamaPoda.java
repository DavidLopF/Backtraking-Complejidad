package co.edu.unbosque.model;

public class RamaPoda {
	
	public int[][] campo;
	public int columnas;
	public int filas;
	
	
	public RamaPoda(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		campo = new int[filas][columnas];
	}
	
	public String mostrarMatriz() {
		String a = "";
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				a += campo[i][j] + "    ";
			}
			a += "\n";
		}

		return a;
	}

}
