package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RamaPoda {

	public int[][] campo;
	public int columnas;
	public int filas;
	public List<List<Posicion>> recorridos;
	public int posx;
	public int posy;

	public RamaPoda(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		posy = 0;
		posx = 0;
		campo = new int[filas][columnas];
		recorridos = new ArrayList<List<Posicion>>();
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

	public void recorridos(int destinox, int destinoy, int iteracion, int cont) {
		String res = "";
	
		if (posx == destinox && posy == destinoy) {
			res = "El destino es igual a la posicion del conejo";

		} else if (iteracion == 0) {
			if (recorridos.isEmpty()) {

				recorridos.add(new ArrayList<Posicion>());
				recorridos(destinox, destinoy, iteracion, cont);

			} else {
				if (recorridos.get(iteracion).isEmpty()) {
					
					System.out.println("entro");
					List temp = new ArrayList<>();
					recorridos.add(temp);
					recorridos.get(iteracion).add(new Posicion(posx, posy + 1));
					recorridos(destinox, destinoy, iteracion, cont);

				} else {

					if (recorridos.get(iteracion).get(cont).getX() != destinox
							&& recorridos.get(iteracion).get(cont).getY() != destinoy) {
						// si aun no encuentra la pos final
						
						
						if ( cont % 2 == 0) {
							
							recorridos.get(iteracion).add(new Posicion(posx + 1, posy));
							recorridos(destinox, destinoy, iteracion, cont++);
							System.out.println(cont);
							
						} else if (cont % 2 == 1) {
							
							recorridos.get(iteracion).add(new Posicion(posx, posy + 1));
							recorridos(destinox, destinoy, iteracion, cont++);
							System.out.println(cont);
						}
					}else {
						System.out.println("no entro :c");
					}

				}
			}

		}

	}

	public String mostrarLista() {

		String res = "";
		for (int i = 0; i < recorridos.size(); i++) {
			for (int j = 0; j < recorridos.get(i).size(); j++) {
				res += recorridos.get(i).get(j).toString() + " ";
			}
		}

		return res;

	}

}
