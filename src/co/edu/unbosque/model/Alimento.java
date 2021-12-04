package co.edu.unbosque.model;

import java.util.Objects;

public class Alimento {
	
	private String nom_alimento;
	private int calorias;
	
	public Alimento(String pAlimento, int PCalorias) {
		nom_alimento = pAlimento;
		calorias = PCalorias;
	}

	/**
	 * @return the alimento
	 */
	public String getAlimento() {
		return nom_alimento;
	}

	/**
	 * @param alimento the alimento to set
	 */
	public void setAlimento(String alimento) {
		this.nom_alimento = alimento;
	}

	/**
	 * @return the calorias
	 */
	public int getCalorias() {
		return calorias;
	}

	/**
	 * @param calorias the calorias to set
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	@Override
	public String toString() {
		return "Alimento: " + nom_alimento + " - Calorias: " + calorias +"";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if(calorias != other.calorias)
			return false;
		return true;
	}
	
	
}
