package co.edu.unbosque.model;

public class Menu {

	
	private int caloriasMax;
	private Alimento[] alimentos;
	
	private int cal;
	
	public Menu(int pCaloriasMax, int numAlimentos) {
		caloriasMax = pCaloriasMax;
		alimentos = new Alimento[numAlimentos];
		cal = 0;
	}

	/**
	 * @return the caloriasMax
	 */
	public int getCaloriasMax() {
		return caloriasMax;
	}

	/**
	 * @param caloriasMax the caloriasMax to set
	 */
	public void setCaloriasMax(int caloriasMax) {
		this.caloriasMax = caloriasMax;
	}

	/**
	 * @return the alimentos
	 */
	public Alimento[] getAlimentos() {
		return alimentos;
	}

	/**
	 * @param alimentos the alimentos to set
	 */
	public void setAlimentos(Alimento[] alimentos) {
		this.alimentos = alimentos;
	}

	/**
	 * @return the cal
	 */
	public int getCal() {
		return cal;
	}

	/**
	 * @param cal the cal to set
	 */
	public void setCal(int cal) {
		this.cal = cal;
	}
	
	public void addAlimento(Alimento a) {
		for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
            	alimentos[i] = a;
            	cal += a.getCalorias();
                break;
            }
        }
	}
	
	public void vaciar() {
		this.cal = 0;
		for (int i = 0; i < this.alimentos.length; i++) {
			this.alimentos[i] = null;
		}
	}
	
	public void quitarAlimento(Alimento a) {
		for (int i = 0; i < alimentos.length; i++) {
			try {
				if(alimentos[i].equals(a)) {
					alimentos[i] = null;
					cal -= a.getCalorias();
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			
		}
	}
	
	public boolean valAlimento(Alimento a) {
		for (int i = 0; i < this.alimentos.length; i++) {
			if(this.alimentos[i] != null && this.alimentos[i].equals(a)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String r  = "";
		for (int i = 0; i < this.alimentos.length; i++) {
			if(this.alimentos[i] != null) {
				r += alimentos[i] + "\n";	
			}
		}
		r += "Calorias total: " + getCal()+"\n";
		return r;
	}
}
