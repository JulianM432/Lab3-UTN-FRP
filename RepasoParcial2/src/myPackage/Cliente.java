package myPackage;

import java.util.Objects;

public class Cliente implements Comparable<Cliente>{
	String nombre;
	String apellido;
	Integer dni;

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public String[] getDataRow() {
		return new String[] { nombre, apellido, Integer.toString(dni) };
	}

	public Cliente(String nombre, String apellido, Integer dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(dni, other.dni)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Cliente o) {
		// TODO Auto-generated method stub
		return this.getNombre().compareTo(o.getNombre());
	}
}
