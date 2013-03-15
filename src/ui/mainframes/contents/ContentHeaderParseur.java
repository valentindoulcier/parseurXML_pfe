/**
 * 
 */
package ui.mainframes.contents;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import principal.Application;

/**
 * @author Valentin
 *
 */
public class ContentHeaderParseur extends JPanel {

	private static final long serialVersionUID = 5428423567932680960L;

	//private static Logger logger = Logger.getLogger(ContentHeaderParseur.class);

	private static boolean ouvert = false;

	/**
	 * Create the panel.
	 */
	public ContentHeaderParseur(final Application application) {
		setBackground(Color.GRAY);		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		Box horizontalBox = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox = new GridBagConstraints();
		gbc_horizontalBox.fill = GridBagConstraints.BOTH;
		gbc_horizontalBox.gridx = 0;
		gbc_horizontalBox.gridy = 0;
		add(horizontalBox, gbc_horizontalBox);

		JButton btnHome = new JButton("HOME");
		horizontalBox.add(btnHome);

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
				application.getContentPanel().show(application.getcPanel(), "ContentHome");
				application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");

				application.FermerVolet();

				application.getcFooter().remove(application.getContentHome().getContentFooterParseur());
				application.getvFooter().remove(application.getContentHome().getVoletFooterParseur());


				if(application.getContentHome().getVoletFooterParseur().getJeViensDe() == -1) {
					application.getvHeader().remove(application.getContentHome().getVoletHeaderParseur());
					application.getvPanel().remove(application.getContentHome().getVoletParseur());

					application.getcHeader().remove(application.getContentHome().getContentHeaderParseur());
					application.getcPanel().remove(application.getContentHome().getContentParseur());
				}
				else if(application.getContentHome().getVoletFooterParseur().getJeViensDe() == 1) {
					application.getvHeader().remove(application.getContentHome().getVoletFooterParseur().getVoletHeaderParseur());
					application.getvPanel().remove(application.getContentHome().getVoletFooterParseur().getVoletParseur());

					application.getcHeader().remove(application.getContentHome().getVoletFooterParseur().getContentHeaderParseur());
					application.getcPanel().remove(application.getContentHome().getVoletFooterParseur().getContentParseur());
				}
				else {
					//logger.error("Problème ligne 80 ContentHeaderParseur");
				}
			}
		});

		final JButton btnNewButton = new JButton("FERMER");
		horizontalBox.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ouvert) {
					application.OuvrirVolet();
					btnNewButton.setText("FERMER");
					ouvert = false;
				}
				else {
					application.FermerVolet();
					btnNewButton.setText("OUVRIR");
					ouvert = true;
				}
			}
		});
	}

}
