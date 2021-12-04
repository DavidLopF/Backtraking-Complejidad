/**
 * 
 */
package co.edu.unbosque.model;

/**
 * 
 * @author David Lopez, Daniel Mejia y Juan Perez
 *
 */
public class Posicion {

	private int x;
	private int y;

	/**
	 * Metodo constructor de la clase posicion
	 * 
	 * @param x entero
	 * @param y entero
	 */
	public Posicion(int x, int y) {

		this.x = x;
		this.y = y;
	}

	/**
	 * Metodo encargado de imprimir atributos de la clase posicion
	 */
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + "]";
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

}
