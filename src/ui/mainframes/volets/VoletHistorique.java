/**
 * 
 */
package ui.mainframes.volets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JPanel;

import principal.Application;
import principal.Fichier;
import renderers.HistoriqueRenderer;
import ui.objects.HistoriqueCell;


/**
 * @author Valentin
 *
 */
public class VoletHistorique extends JPanel {

	private static final long serialVersionUID = 9200931919131551743L;

	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_panel;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletHistorique(Application application) {

		initComponents(application);

	}

	public void initComponents(Application application) {
		setPreferredSize(new Dimension(300, 540));
		//setBackground(Color.GRAY);

		GridBagLayout gridBagLayout_1 = new GridBagLayout();
		gridBagLayout_1.columnWidths = new int[]{0, 0};
		gridBagLayout_1.rowHeights = new int[]{0, 0};
		gridBagLayout_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout_1);

		gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
	}

	public void chargerHistorique(Application application) {

		Vector<HistoriqueCell> listeFichiers = new Vector<HistoriqueCell>();

		HistoriqueCell historiqueCell;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy ~ HH:mm:ss");

		for(Object fichier : application.getMesFichiers()) {
			historiqueCell = new HistoriqueCell(application);
			historiqueCell.setNumRecherche(((Fichier) fichier).getNumero());
			historiqueCell.getLblFichier().setText(((Fichier) fichier).getNom());
			historiqueCell.getLblDate().setText(simpleDateFormat.format(((Fichier) fichier).getDateParsing()));
			listeFichiers.add(0, historiqueCell);//addElement(historiqueCell);
		}		

		JPanel historiqueRenderer = new HistoriqueRenderer(application, listeFichiers);
		historiqueRenderer.setBackground(Color.GRAY);
		add(historiqueRenderer, gbc_panel);

		revalidate();
	}

	public GridBagLayout getGridBagLayout() {
		return gridBagLayout;
	}

	public void setGridBagLayout(GridBagLayout gridBagLayout) {
		this.gridBagLayout = gridBagLayout;
	}

	public GridBagConstraints getGbc_panel() {
		return gbc_panel;
	}

	public void setGbc_panel(GridBagConstraints gbc_panel) {
		this.gbc_panel = gbc_panel;
	}
}
