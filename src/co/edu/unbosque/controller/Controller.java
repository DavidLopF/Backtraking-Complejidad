package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.Alimento;
import co.edu.unbosque.model.Menu;
import co.edu.unbosque.model.RamaPoda;
import co.edu.unbosque.view.View;

public class Controller {

	private View view;
	private RamaPoda poda;

	public Controller() {

		view = new View();
		funcionar();
	}

	private void funcionar() {
		String a = view.menuPrincipal();
		switch (a) {
		case "1. Nutricionista - Backtracking":
			int cal_max = view.capturarInt("Menu Disponible:\n\n"+mostrarMenu(retornarAlimentos())+"\nIngrese la cantidad de calorias a consumir:\n");
			Menu menu_bas = new Menu(cal_max, retornarAlimentos().length);
			Menu mejor_menu = new Menu(cal_max, retornarAlimentos().length);
			nutricionistaMenu(menu_bas, retornarAlimentos(), false, mejor_menu);
			view.mostrarMensaje("Aqui tienes el resultado de tus preferencias en calorias:\n\n" + mejor_menu.toString());
			if (mejor_menu.getCal() != cal_max) {
				nutricionistaMenu100(menu_bas, retornarAlimentos(), false, mejor_menu);
				view.mostrarMensaje("Tenemos esta opcion pero con mas calorias, si prefieres: \n\n" + mejor_menu.toString()
						+ "\nGracias por solicitar nuestro servicio:");	
			}
			break;

		case "2. Backtracking-2":
			view.mostrarMensaje("Juanma Care monda");
			break;

		case "3. Rama y poda":
			String dimenciones = view
					.capturarString("Ingrese cantidad dimenciones del campo separados por ; (punto y coma):  ");

			String[] datos = dimenciones.split(";");

			try {
				if (datos.length > 1) {
					poda = new RamaPoda(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
					view.capturarInt("Ahora se mostrara el campo creado:\n\n" + poda.mostrarMatriz());
				} else {
					view.mostrarMensaje("Datos invalidos, recuerde que los datos deben estar separados por ; (25;25)");
					datos = null;
					dimenciones = null;
					funcionar();

				}
			} catch (Exception e) {
				view.mostrarMensaje("Datos invalidos, recuerde que los datos deben estar separados por ; (25;25)");
				datos = null;
				dimenciones = null;
				funcionar();

			}

			break;

		case "4. Salir":

			break;

		}
	}

	public Alimento[] retornarAlimentos() {
		Alimento[] alimentos = { 
				new Alimento("Tamal", 900), 
				new Alimento("Jugo de mora", 300),
				new Alimento("Ensalda césar", 120), 
				new Alimento("Gaseosa", 450), 
				new Alimento("Lentejas", 250),
				new Alimento("Papa a la francesa", 220), 
				new Alimento("Pollo apanado", 350),
				new Alimento("Huevo cocinado", 100), 
				new Alimento("Queso campesino", 130),
				new Alimento("Chorizo", 600),
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
}
