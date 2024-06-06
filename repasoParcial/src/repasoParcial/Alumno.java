package repasoParcial;

public class Alumno implements Comparable<Alumno> {
	String nombre;
	String apellido;
	int dni;
	int legajo;

	public Alumno(String nombre, String apellido, int dni, int legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getDni() {
		return dni;
	}

	public int getLegajo() {
		return legajo;
	}

	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		return nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return String.format("Nombre: %-20s | Apellido: %-20s | DNI: %-10d | Legajo: %5d\n",nombre,apellido,dni,legajo);
	}
}
