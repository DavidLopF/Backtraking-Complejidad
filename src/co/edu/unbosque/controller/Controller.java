package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Random;

import co.edu.unbosque.model.Alimento;
import co.edu.unbosque.model.Menu;
import co.edu.unbosque.model.RamaPoda;
import co.edu.unbosque.view.View;

/**
 * 
 * @author David Lopez, Daniel Mejia y Juan Perez
 *
 */
public class Controller {

	private View view;
	private RamaPoda poda;

	public Controller() {

		view = new View();
		funcionar();
	}

	/**
	 * Metodo encargado de hacer funcionar el programa
	 */
	private void funcionar() {
		String a = view.menuPrincipal();
		switch (a) {
		case "1. Nutricionista - Backtracking":
			int cal_max = view.capturarInt("Menu Disponible:\n\n" + mostrarMenu(retornarAlimentos())
					+ "\nIngrese la cantidad de calorias a consumir:\n");
			Menu menu_bas = new Menu(cal_max, retornarAlimentos().length);
			Menu mejor_menu = new Menu(cal_max, retornarAlimentos().length);
			nutricionistaMenu(menu_bas, retornarAlimentos(), false, mejor_menu);
			view.mostrarMensaje(
					"Aqui tienes el resultado de tus preferencias en calorias:\n\n" + mejor_menu.toString());
			if (mejor_menu.getCal() != cal_max) {
				nutricionistaMenu100(menu_bas, retornarAlimentos(), false, mejor_menu);
				view.mostrarMensaje("Tenemos esta opcion pero con mas calorias, si prefieres: \n\n"
						+ mejor_menu.toString() + "\nGracias por solicitar nuestro servicio:");
			}
			break;

		case "2. Backtracking-2":
			int equipos = view.capturarInt("Ingrese la cantidad de equipos: ");
			int arbitros = view.capturarInt("Ingrese la cantidad de arbitros:");
			if(equipos % 2 != 0 || arbitros < equipos % 2) {
				view.mostrarError("Nota:\nEl numero de equipos debe ser par\nLa cantidad de arbitros debe ser mayor a la cantidad de equipos entre 2");
			}else {
				crearPuntuacion(equipos, arbitros);
			}
			default:
				view.mostrarMensaje("Cambiando de ejercicio...");

			break;

		case "3. Rama y poda":
			String dimensiones = view.capturarString("Ingrese cantidad dimensiones del campo separados por (,)\nPrimero las filas luego las columnas:  ");
			String[] datos = dimensiones.split("-");
			try {

				poda = new RamaPoda(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));

				int x = view.capturarInt("Ingrese posicion del conejo para el eje x: ");
				int y = view.capturarInt("Ingrese posicion del conejo para el eje y: ");

				poda.inicializarConejo(x, y);

				String posfin = view.capturarString("Conejo posicionado en " + x + " y " + y + "\n\n"
						+ poda.mostrarMatriz()
						+ "\nPor favor ingrese posicion a la cual quier que se mueva el conejo, separado por ( - )");

				datos = posfin.split("-");

				poda.recorridos(Integer.parseInt(datos[0]), Integer.parseInt(datos[0]), 0, 0);

				view.mostrarMensaje(poda.mostrarLista());

			} catch (Exception e) {
				view.mostrarMensaje("Datos invalidos, recuerde que los datos deben estar separados por ; (25;25)");
				dimensiones = null;
				datos = null;
				funcionar();

			}
			break;

		case "4. Salir":

			break;
		}
	}


	
	public Alimento[] retornarAlimentos() {
		Alimento[] alimentos = { new Alimento("Tamal", 900), new Alimento("Jugo de mora", 300),
				new Alimento("Ensalda césar", 120), new Alimento("Gaseosa", 450), new Alimento("Lentejas", 250),
				new Alimento("Papa a la francesa", 220), new Alimento("Pollo apanado", 350),
				new Alimento("Huevo cocinado", 100), new Alimento("Queso campesino", 130), new Alimento("Chorizo", 600),
				new Alimento("Hamburguesa ", 700) };
		return alimentos;
	}

	public String mostrarMenu(Alimento[] alimentos) {
		String r = "";
		for (int i = 0; i < alimentos.length; i++) {
			r += alimentos[i] + "\n";
		}
		return r;
	}

	public void nutricionistaMenu(Menu menu_bas, Alimento[] alimentos, boolean menu_completo, Menu mejor_menu) {

		if (menu_completo) {
			if (menu_bas.getCal() > mejor_menu.getCal()) {
				Alimento[] alimentosMenuBas = menu_bas.getAlimentos();
				mejor_menu.vaciar();
				for (Alimento e : alimentosMenuBas) {
					if (e != null) {
						mejor_menu.addAlimento(e);
					}
				}
			}
		} else {
			for (int i = 0; i < alimentos.length; i++) {
				if (!menu_bas.valAlimento(alimentos[i])) {
					if (menu_bas.getCaloriasMax() >= menu_bas.getCal() + alimentos[i].getCalorias()) {
						menu_bas.addAlimento(alimentos[i]);
						nutricionistaMenu(menu_bas, alimentos, false, mejor_menu);
						menu_bas.quitarAlimento(alimentos[i]);
					} else {
						nutricionistaMenu(menu_bas, alimentos, true, mejor_menu);
					}
				}
			}
		}
	}

	public void nutricionistaMenu100(Menu menu_bas, Alimento[] alimentos, boolean menu_completo, Menu mejor_menu) {

		if (menu_completo) {
			if (menu_bas.getCal() > mejor_menu.getCal()) {
				Alimento[] alimentosMenuBas = menu_bas.getAlimentos();
				mejor_menu.vaciar();
				for (Alimento e : alimentosMenuBas) {
					if (e != null) {
						mejor_menu.addAlimento(e);
					}
				}
			}
		} else {
			for (int i = 0; i < alimentos.length; i++) {
				if (!menu_bas.valAlimento(alimentos[i])) {
					if (menu_bas.getCaloriasMax() + 100 >= menu_bas.getCal() + alimentos[i].getCalorias()) {
						menu_bas.addAlimento(alimentos[i]);
						nutricionistaMenu(menu_bas, alimentos, false, mejor_menu);
						menu_bas.quitarAlimento(alimentos[i]);
					} else {
						nutricionistaMenu(menu_bas, alimentos, true, mejor_menu);
					}
				}
			}
		}
	}

	public int[][] crearPuntuacion(int f, int c) {
		int[][] puntos = new int[f][c];
		for (int i = 1; i <= f; i++) {
			for (int j = 1; j <= c; j++) {
				puntos[i][j] = view.capturarInt("Puntos equipo:" + i + " con arbitro: " + (j));
				while (puntos[i][j] < 0 || puntos[i][j] > 10) {
					view.mostrarError("Debe ingresar una puntuación entre 1 a 10");
					puntos[i][j] = view.capturarInt(
							"Puntos equipo:" + i + " con arbitro " + j);
				}
			}
		}
		return puntos;
	}
}
