package ar.edu.unlam.pb2.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.dominio.SALA;

public class SalaDeCineMain {
	public static final Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		

	mensaje("Bienvenido a la sala de cine" +
			"\nRecuerde que L para libre, O para ocupada");
	mensaje("Ingrese la cantidad de filas de su cine");
	Integer filas= teclado.nextInt();
	mensaje("Ingrese la cantidad de columnas de su cine");
	Integer columnas= teclado.nextInt();
	SALA sala=new SALA(filas, columnas);
	sala.liberarButacas();
	menuPrincipal(sala);
	
	
	}
	
	public static void menuPrincipal(SALA sala) {
		
		Integer opcion;
		do {
			mostrarMenuPrincipal();
		switch(opcion=teclado.nextInt()) {
		case 1: imprimirSala(sala);
			break;
		case 2: ocuparButaca(sala);
			break;
		case 3: consultarOcupadas(sala);
			break;
		case 4: consultarContiguas(sala);
			break;
		case 0: mensaje("Gracias por consultar la Sala de Cine");
			break;
		default: mensaje("Seleccione una opcion valida");
				break;
		}
		}while (opcion!=0);
	}
	public static void mostrarMenuPrincipal() {
		mensaje("Bienvenido al Menu Principal"
				+ "\n1---------> Mostrar estado de las butacas"
				+ "\n2---------> Ocupar butaca"
				+ "\n3---------> Consultar cantidad TOTAL de butacas OCUPADAS"
				+ "\n4---------> Ocupar butacas contiguas"
				+ "\n0---------> SALIR");
	}
	
	public static void imprimirSala(SALA sala) {
		for(Integer i=0; i<sala.getFilas();i++) {
			for(Integer j=0; j<sala.getColumnas();j++) {
				if(sala.getButacas()[i][j]==null||sala.getButacas()[i][j]==false) {
					System.out.print("L ");
				}else {
					System.out.print("O ");
				}
					
				}
			mensaje("\n");
		}
	}
				
	public static void ocuparButaca(SALA sala) {
		Integer numerodefila;
		Integer numerodecolumna;
		do {
		mensaje("Elija el numero de la Fila de su butaca, entre 1 y "+sala.getFilas());
		
		numerodefila= teclado.nextInt()-1;
		}while(numerodefila>=sala.getFilas());
		
		do {
		mensaje("Elija el numero de la Columna de su butaca, entre 1 y " +sala.getColumnas());
		numerodecolumna= teclado.nextInt()-1;
		}while(numerodecolumna>=sala.getColumnas());
		
		
		if(sala.ocuparButaca(numerodefila, numerodecolumna)) {
			mensaje("Su butaca ha sido ocupada correctamente");
		}
			else {
				mensaje("BUTACA NO DISPONIBLE");
			}
		}
	public static void consultarOcupadas(SALA sala) {
		mensaje(" La cantidad total de butacas ocupadas es " + sala.consultarTotalOcupadas());
	}
	public static void consultarContiguas(SALA sala) {
		
		mensaje("Introduzca la fila de su butaca inicial");
		Integer fila= teclado.nextInt();
		mensaje("Introduzca la columna de su butaca inicial");
		Integer columna= teclado.nextInt();
		mensaje("Introduzca su cantidad de asientos deseada");
		Integer cantidad= teclado.nextInt();
		if(columna+cantidad>sala.getColumnas()) {
			mensaje("No puede ocupar mas butacas que la cantidad maxima de columnas");
			menuPrincipal(sala);
		}
		
		if(sala.comprobarButacasContiguas(fila-1,columna-1, cantidad-1)==true) {
			sala.ocuparButacasContiguas(fila-1, columna-1, cantidad-1);
			mensaje("Ocupadas correctamente");
		}else {
			mensaje("No hay dicha cantidad de butacas contiguas en esa fila y columna");
		}
	}

	public static void mensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
