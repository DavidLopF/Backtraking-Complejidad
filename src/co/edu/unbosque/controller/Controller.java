package co.edu.unbosque.controller;

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
			int calorias = view.capturarInt("Ingrese el número de calorías máximas a consumir:");
			break;

		case "2. Backtracking-2.":

			break;

		case "3. Rama y poda":
			String dimenciones = view
					.capturarString("Ingrese cantidad dimenciones del campo separados por ; (punto y coma):  ");

			String[] datos = dimenciones.split(";");

			try {
				if (datos.length > 1) {

					int x = view.capturarInt("Ingrese posicion del conejo para el eje x: ");
					int y = view.capturarInt("Ingrese posicion del conejo para el eje y: ");
					
					

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

}
