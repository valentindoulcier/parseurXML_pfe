/**
 * 
 */
package ui.mainframes.contents;

import javax.swing.JFrame;
import javax.swing.JPanel;

import principal.Application;
import principal.Fichier;
import ui.components.InformationsFichier;

import javax.swing.JButton;

import java.awt.FileDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * @author Valentin
 *
 */
public class ContentParseur extends JPanel {

	private static final long serialVersionUID = 848524817828466211L;

	private JButton btnJfilechooser;

	//private static Logger logger = Logger.getLogger(ContentParseur.class);
	
	private InformationsFichier informationsFichier;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentParseur(final Application application) {


		initComponents();

		btnJfilechooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileDialog d = new FileDialog(new JFrame(), "Charger un fichier XML", FileDialog.LOAD);
				d.setVisible(true);
				
				if(!"".equalsIgnoreCase(d.getFile())) {
					File file = new File(d.getDirectory() + d.getFile());
					
					//if(d.getFile().endsWith(".xml")) {
						Fichier monFichier = new Fichier(file);
					
						monFichier.setNumero(application.getMesFichiers().size() + 1);
						
						application.getMesFichiers().add(monFichier);

						afficherInfo(application, application.getMesFichiers().size() - 1);
					//}
					//else {
						//TODO
					//}
				}


			}

		});



	}

	public void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 117, 40, 117, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 29, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		btnJfilechooser = new JButton("JFileChooser");
		GridBagConstraints gbc_btnJfilechooser = new GridBagConstraints();
		gbc_btnJfilechooser.insets = new Insets(0, 0, 5, 5);
		gbc_btnJfilechooser.anchor = GridBagConstraints.NORTH;
		gbc_btnJfilechooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnJfilechooser.gridx = 1;
		gbc_btnJfilechooser.gridy = 1;
		add(btnJfilechooser, gbc_btnJfilechooser);

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
		
		informationsFichier.getLblDataNomFichier().setText(application.getMesFichiers().get(numeroFichier).getNom());
		
		informationsFichier.getLblDatapath().setText(application.getMesFichiers().get(numeroFichier).getPath());
		
		informationsFichier.getLblDataextension().setText(application.getMesFichiers().get(numeroFichier).getExtension());
		
		informationsFichier.getLblDatatype().setText(application.getMesFichiers().get(numeroFichier).getType());
		
		informationsFichier.getLblDatataille().setText(application.getMesFichiers().get(numeroFichier).getTaille());
		
		informationsFichier.getLblDataauteur().setText(application.getMesFichiers().get(numeroFichier).getAuteur());
		
		informationsFichier.getLblDatadatemodif().setText(String.valueOf(application.getMesFichiers().get(numeroFichier).getDateModification()));
		
		informationsFichier.getLblDatalisible().setText(application.getMesFichiers().get(numeroFichier).getCanRead());
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy ~ HH:mm:ss");
		informationsFichier.getLblDatadate().setText(simpleDateFormat.format(application.getMesFichiers().get(numeroFichier).getDateParsing()));
		
		this.revalidate();
	}
	
	
}