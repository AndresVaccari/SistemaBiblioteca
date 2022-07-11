package finalLibros;

public class FinalMain {
	
	private static LoginFrame login;
	private static Libro libros[];
	private static int cantidad;
	
	public static void main(String[] args) {
		
		libros = new Libro[20];
		libros[0] = new Libro(0,"El principito", "Antoine de Saint-Exup�ry", true, "");
		libros[1] = new Libro(1,"La metamorfosis", "Franz Kafka", true, "");
		libros[2] = new Libro(2,"Orgullo y prejuicio", "Jane Austen", true, "");
		libros[3] = new Libro(3,"Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", true, "");
		libros[4] = new Libro(4,"Romeo y Julieta", "William Shakespeare", true, "");
		libros[5] = new Libro(5,"Cumbres borrascosas", "Emily Bronte", true, "");
		libros[6] = new Libro(6,"El retrato de Dorian Gray", "Oscar Wilde", true, "");
		libros[7] = new Libro(7,"El Lazarillo de Tormes", "An�nimo", true, "");
		libros[8] = new Libro(8,"Dr�cula", "Bram Stoker", true, "");
		libros[9] = new Libro(9,"Crimen y castigo", "Fi�dor Dostoyevski", true, "");
		cantidad = 10;
		
		login = new LoginFrame();
		
	}
	
	public static Libro[] getLibros() {
		return libros;
	}
	
	public static int getCantidad() {
		return cantidad;
	}
	
	public static void calcularCantidad() {
		int i;
		for (i = 0; i < libros.length; i++) {
			if (libros[i] == null) {
				break;
			}
		cantidad = i + 1;
		}
	}
	
	
	public static void loginSetVisible() {
		login.setVisible(true);
	}
	
}
