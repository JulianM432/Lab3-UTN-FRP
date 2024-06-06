package repasoParcial;

import java.util.*;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alumno> listAlumnos = CargarLista();
		String opcion = " ";
		do {
			opcion = JOptionPane.showInputDialog(null,Menu());
			switch (opcion) {
			case "1": {
				String nombreString = JOptionPane.showInputDialog(null, "Nombre del alumno");
				String apellidoString = JOptionPane.showInputDialog(null, "Apellido del alumno");
				String dniString = JOptionPane.showInputDialog(null, "DNI del alumno");
				String legajoString = JOptionPane.showInputDialog(null, "Legajo del alumno");
				Alumno unAlumno = new Alumno(nombreString, apellidoString, Integer.parseInt(dniString),
						Integer.parseInt(legajoString));

				listAlumnos.add(unAlumno);
				break;
			}
			case "2": {
				BorrarAlumno(listAlumnos);
				break;
			}
			case "3": {
				//Collections.sort(listAlumnos);
				Collections.sort(listAlumnos,Comparator.comparing(Alumno::getNombre).thenComparing(Alumno::getApellido).thenComparing(Alumno::getDni));
				MostrarLista(listAlumnos);
				break;
			}
			case "4": {
				Collections.sort(listAlumnos, new OrdenApellido());
				MostrarLista(listAlumnos);
				break;
			}
			case "5": {
				Collections.sort(listAlumnos, new OrdenDNI());
				MostrarLista(listAlumnos);
				break;
			}
			case "6": {
				MostrarLista(listAlumnos);
				break;
			}
			case "0":
				JOptionPane.showMessageDialog(null, "Usted ingreso " + opcion + " para salir...");
				System.exit(0);
				break;
			default:
				break;
			}
		} while (opcion != "0");
		System.exit(0);
	}

	private static void BorrarAlumno(List<Alumno> listAlumnos) {
		Collections.sort(listAlumnos);
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno a borrar.");
		int i = Collections.binarySearch(listAlumnos, new Alumno(nombre, "", 0, 0));
		if (i > -1) {
			listAlumnos.remove(i);
			JOptionPane.showMessageDialog(null,"Se elimino a " + nombre);
		} else {
			JOptionPane.showMessageDialog(null, "No se encontro el alumno");
		}
	}

	private static List<Alumno> CargarLista() {
		// TODO Auto-generated method stub
		Random unRandom = new Random();
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		String[] nombres = { "Carlos", "Juan", "Alejandro", "Daniel", "Pablo" };
		String[] apellidos = { "Corleone", "Soprano", "Targaryen", "Lannister", "Miller" };
		for (int i = 0; i< nombres.length;i++) {
			Alumno unAlumno = new Alumno(nombres[i], apellidos[i], unRandom.nextInt(5000000, 50000000),
					unRandom.nextInt(10000, 99999));
			listaAlumnos.add(unAlumno);
		}
		return listaAlumnos;
	}

	private static void MostrarLista(List<Alumno> unaLista) {
		String datoString = "";
		for (Alumno alumno : unaLista)
			datoString += alumno.toString();
			JOptionPane.showMessageDialog(null, datoString);
	}

	private static String Menu() {
		// TODO Auto-generated method stub
		return "1 - Agregar alumno\n" + "2 - Borrar alumno\n" + "3 - Ordenar por nombre\n"
				+ "4 - Ordenar por apellido\n" + "5 - Ordenar por DNI\n" + "6 - Mostrar lista\n" + "0 - Salir\n";
	}

}
