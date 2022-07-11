package finalLibros;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelListaAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel [] libroPanel;
	private Libro [] listaLibros;
	
	public PanelListaAdmin() {
		
		listaLibros = FinalMain.getLibros();
		setLayout(new GridLayout(21,1));
		libroPanel = new JPanel[20];
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new GridLayout(1,4));
		panelTitulo.add(new JLabel("Numero"));
		panelTitulo.add(new JLabel("Titulo"));
		panelTitulo.add(new JLabel("Autor"));
		panelTitulo.add(new JLabel("Reservado"));
		add(panelTitulo);
		
		int colores = 0;
		
		for (int i = 0; i < FinalMain.getCantidad(); i++) {
			if (!listaLibros[i].getTitulo().equals("")) {
				JLabel numero = new JLabel(Integer.toString(listaLibros[i].getNumeroLibro()));
				JLabel titulo = new JLabel(listaLibros[i].getTitulo());
				JLabel autor = new JLabel(listaLibros[i].getAutor());
				JLabel reservado = new JLabel(listaLibros[i].getReservadoPor());
				libroPanel[i] = new JPanel();
				libroPanel[i].setLayout(new GridLayout(1, 4));
				libroPanel[i].add(numero);
				libroPanel[i].add(titulo);
				libroPanel[i].add(autor);
				libroPanel[i].add(reservado);
				libroPanel[i].setBackground(setColor(colores));
				colores++;
				add(libroPanel[i]);
			}
			else {
				continue;
			}
		}	
	}
	
	private Color setColor(int nColor) {
		if (nColor % 2 == 0) {
			return Color.LIGHT_GRAY;
		} else {
			return Color.gray;
		}
	}
	
}