package co.edu.unbosque.view;

import javax.swing.JOptionPane;

/**
 * 
 * @author David Lopez, Daniel Mejia y Juan Perez
 *
 */


public class View {

	
	/**
	 * Metodo encargado de mostrar ventanas con mensajaes
	 * @param a mensaje para la ventana
	 */
	public void mostrarMensaje(String a) {
		JOptionPane.showMessageDialog(null, a);
	}
	
	/**
	 *  Metodo encargado de mostrar ventanas con errores
	 * @param m mensaje de error
	 */
	
	public void mostrarError(String m) {
		JOptionPane.showMessageDialog(null,m,"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * Metodo encargado de capturar los strings
	 * @param titulo String
	 * @return dato capturado
	 */

	public String capturarString(String titulo) {
		String a = JOptionPane.showInputDialog(titulo);
		return a;
	}

	
	/**
	 * Mentodo encargado de capturar enteros
	 * @param titulo Encabezado del mensaje
	 * @return Entero capturado
	 */
	public int capturarInt(String titulo) {
		String a = JOptionPane.showInputDialog(titulo);
		int num = 0;
		while (!esNumeroInt(a)) {


			System.out.println("ERROR.. NO ES ENTERO.");
			a = JOptionPane.showInputDialog(titulo);
			num = 0;

		}
		num = Integer.parseInt(a);
		System.out.println("DATO INGRESADO CON EXITO.");

		return num;
	}

	
	/**
	 * Metodo que valida si un string es entero o no
	 * @param mensaje string a validar
	 * @return booleano
	 */

	public boolean esNumeroInt(String mensaje) {
		try {
			Integer.parseInt(mensaje);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	/**
	 * Metodo encargado de mostrar el menu de opciones
	 * @return opcion seleccionada 
	 */

	public String menuPrincipal() {
		Object[] opciones = { "1. Nutricionista - Backtracking", "2. Backtracking-2", "3. Rama y poda", "4. Salir" };
		Object opcion = JOptionPane.showInputDialog(null,
				"      ..: Bienvenido señor usuario :..                "
						+ "\n\n\nSelecciona un operacion a realizar:    ",
				"Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == null) {
			mostrarMensaje("Hasta Pronto");
		}
		return opcion.toString();
	}
}
