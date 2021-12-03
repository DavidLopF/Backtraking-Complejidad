package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class RamaPoda {

	public int[][] campo;
	public int columnas;
	public int filas;
	public List<List<Integer>> recorridos;
	public int posx;
	public int posy;

	public RamaPoda(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		posy = 0;
		posx = 0;
		campo = new int[filas][columnas];
		recorridos = new ArrayList<>();
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

	public void inicializarConejo(int x, int y) {
		posx = x;
		posy = y;
		campo[x][y] = 1;
	}

	public String recorridos(int destinox, int destinoy, int iteracion) {
		String res = "";
		if (posx == destinox && posy == destinoy) {
				res = "El destino es igual a la posicion del conejo";
		}
		
		return res;
		
	}

}
