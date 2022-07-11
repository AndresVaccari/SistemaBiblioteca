package finalLibros;

public class Libro {

	private int numeroLibro;
	private String titulo;
	private String autor;
	private boolean estado;
	private String reservadoPor;
	
	public Libro(int numeroLibro, String titulo, String autor, boolean estado, String reservadoPor) {
		this.numeroLibro = numeroLibro;
		this.autor = autor;
		this.titulo = titulo;
		this.estado = estado;
		this.reservadoPor = reservadoPor;
	}

	public int getNumeroLibro() {
		return numeroLibro;
	}
	
	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}

	public boolean isEstado() {
		return estado;
	}

	public String getReservadoPor() {
		return reservadoPor;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setReservadoPor(String reservadoPor) {
		this.reservadoPor =  reservadoPor;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
