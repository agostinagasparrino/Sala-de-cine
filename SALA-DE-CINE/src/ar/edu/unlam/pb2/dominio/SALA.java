package ar.edu.unlam.pb2.dominio;

import java.util.Arrays;

public class SALA {
	private Integer butacasTotales;
	private Integer filas;
	private Integer columnas;
	private Boolean[][] butacas;


	public SALA(Integer cantidadFilas, Integer cantidadColumnas) {	
		this.butacasTotales=cantidadFilas*cantidadColumnas;
		this.filas=cantidadFilas;
		this.columnas=cantidadColumnas;
		this.butacas=new Boolean[cantidadFilas][cantidadColumnas];
		
	}
	public void liberarButacas() {	
	for(Integer i=0; i<this.filas;i++) {
		for(Integer j=0; j<this.columnas;j++) {
			if(butacas[i][j]==null||butacas[i][j]==true) {
				butacas[i][j]=false;
			}
			
			}
		}
	
	}
	
	public Boolean ocuparButaca(Integer fila, Integer columna) {
		if(butacas[fila][columna]==false) {
			butacas[fila][columna]=true;
			return true;
		}

		return false;
	}
	
	public Boolean consultarButaca(Integer fila, Integer columna) {
		if(butacas[fila][columna]==false) {
			return true;
		}

		return false;
	}
	
	public Integer consultarTotalOcupadas() {
	Integer ocupadas=0;
	
	for(Integer i=0; i<this.filas;i++) {
		for(Integer j=0; j<this.columnas;j++) {
			if(butacas[i][j]==true) {
			ocupadas++;
			}
			}
		}
	return ocupadas;
	}
	
	public Boolean comprobarButacasContiguas(Integer fila, Integer columna, Integer cantidad) {
		Boolean hayespacio=false;
		for(Integer i=0;i<=cantidad;i++) {
				if(butacas[fila][columna+i]==false) { 
					hayespacio=true;
				}else {
					return hayespacio=false;
				}
				}
						
		return hayespacio;
	}
	public void ocuparButacasContiguas(Integer fila, Integer columna, Integer cantidad) {
		if(comprobarButacasContiguas(fila, columna, cantidad)) {
			for(Integer i=0;i<=cantidad;i++) {
				butacas[fila][columna+i]=true;
				
				}
		}
	}

	public Integer getButacasTotales() {
		return butacasTotales;
	}

	public void setButacasTotales(Integer butacasTotales) {
		this.butacasTotales = butacasTotales;
	}

	public Integer getFilas() {
		return filas;
	}

	public void setFilas(Integer filas) {
		this.filas = filas;
	}

	public Integer getColumnas() {
		return columnas;
	}

	public void setColumnas(Integer columnas) {
		this.columnas = columnas;
	}

	public Boolean[][] getButacas() {
		return butacas;
	}

	public void setButacas(Boolean[][] butacas) {
		this.butacas = butacas;
	}
	@Override
	public String toString() {
		return "SALA [butacas=" + Arrays.toString(butacas) + "]";
	}


	
}