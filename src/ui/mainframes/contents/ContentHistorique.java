/**
 * 
 */
package ui.mainframes.contents;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

import principal.Application;
import ui.components.InformationsFichier;

/**
 * @author Valentin
 *
 */
public class ContentHistorique extends JPanel {

	private static final long serialVersionUID = -3584920438752843211L;

	private InformationsFichier informationsFichier;
	
	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentHistorique(final Application application) {
		setLayout(null);

		initComponents();

	}

	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 117, 40, 117, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 29, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		informationsFichier = new InformationsFichier();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		add(informationsFichier, gbc_panel);
	}


	public void afficherInfo(Application application, int numeroFichier) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy ~ HH:mm:ss");

		informationsFichier.getLblDataNomFichier().setText(application.getMesFichiers().get(numeroFichier).getNom());

		informationsFichier.getLblDatapath().setText(application.getMesFichiers().get(numeroFichier).getPath());

		informationsFichier.getLblDataextension().setText(application.getMesFichiers().get(numeroFichier).getExtension());

		informationsFichier.getLblDatatype().setText(application.getMesFichiers().get(numeroFichier).getType());

		informationsFichier.getLblDatataille().setText(application.getMesFichiers().get(numeroFichier).getTaille());

		informationsFichier.getLblDataauteur().setText(application.getMesFichiers().get(numeroFichier).getAuteur());

		informationsFichier.getLblDatadatemodif().setText(simpleDateFormat.format(application.getMesFichiers().get(numeroFichier).getDateModification()));

		informationsFichier.getLblDatalisible().setText(application.getMesFichiers().get(numeroFichier).getCanRead());

		informationsFichier.getLblDatadate().setText(simpleDateFormat.format(application.getMesFichiers().get(numeroFichier).getDateParsing()));

		this.revalidate();
	}
}
