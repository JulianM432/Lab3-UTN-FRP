package repasoParcial;

import java.util.Comparator;

public class OrdenDNI implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		// TODO Auto-generated method stub
		return o1.dni - o2.dni;
	}

}
