/**
 * 
 */
package ui.mainframes.contents;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JButton;

import principal.Application;
import ui.mainframes.volets.*;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import java.awt.Font;

/**
 * @author Valentin
 *
 */
public class ContentHome extends JPanel {

	private static final long serialVersionUID = 8023381629976468353L;

	private JLabel lblApplication;
	private JLabel lblDescription;

	private JButton btnParseur;
	private JButton btnOptions;


	// Parseur

	private VoletHeaderParseur voletHeaderParseur;
	private VoletParseur voletParseur;
	private VoletFooterParseur voletFooterParseur;

	private ContentHeaderParseur contentHeaderParseur;
	private ContentParseur contentParseur;
	private ContentFooterParseur contentFooterParseur;


	// Options
	private VoletHeaderOptions voletHeaderOptions;
	private VoletOptions voletOptions;
	private VoletFooterOptions voletFooterOptions;

	private ContentHeaderOptions contentHeaderOptions;
	private ContentOptions contentOptions;
	private ContentFooterOptions contentFooterOptions;


	/**
	 * Create the panel.
	 */
	public ContentHome(final Application application) {

		setBackground(Color.LIGHT_GRAY);

		initComponents();


		btnParseur.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// VOLET
				voletHeaderParseur = new VoletHeaderParseur();
				voletParseur = new VoletParseur(application);
				voletFooterParseur = new VoletFooterParseur(application);
				
				application.getvHeader().add(voletHeaderParseur, "voletHeaderParseur");
				application.getvPanel().add(voletParseur, "voletParseur");
				application.getvFooter().add(voletFooterParseur, "voletFooterParseur");
				
				application.getVoletHeader().show(application.getvHeader(), "voletHeaderParseur");
				application.getVoletPanel().show(application.getvPanel(), "voletParseur");
				application.getVoletFooter().show(application.getvFooter(), "voletFooterParseur");

				// CONTENT
				contentHeaderParseur = new ContentHeaderParseur(application);
				contentParseur = new ContentParseur(application);
				contentFooterParseur = new ContentFooterParseur(application);
				
				application.getcHeader().add(contentHeaderParseur, "contentHeaderParseur");
				application.getcPanel().add(contentParseur, "contentParseur");
				application.getcFooter().add(contentFooterParseur, "contentFooterParseur");

				application.getContentHeader().show(application.getcHeader(), "contentHeaderParseur");
				application.getContentPanel().show(application.getcPanel(), "contentParseur");
				application.getContentFooter().show(application.getcFooter(), "contentFooterParseur");

				application.OuvrirVolet();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour parser un nouveau dictionnaire");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});


		btnOptions.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// VOLET
				voletHeaderOptions = new VoletHeaderOptions();
				voletOptions = new VoletOptions();
				voletFooterOptions = new VoletFooterOptions();

				application.getvHeader().add(voletHeaderOptions, "voletHeaderOptions");
				application.getvPanel().add(voletOptions, "voletOptions");
				application.getvFooter().add(voletFooterOptions, "voletFooterOptions");

				application.getVoletHeader().show(application.getvHeader(), "voletHeaderOptions");
				application.getVoletPanel().show(application.getvPanel(), "voletOptions");
				application.getVoletFooter().show(application.getvFooter(), "voletFooterOptions");

				// CONTENT
				contentHeaderOptions = new ContentHeaderOptions(application);
				contentOptions = new ContentOptions(application);
				contentFooterOptions = new ContentFooterOptions(application);

				application.getcHeader().add(contentHeaderOptions, "contentHeaderOptions");
				application.getcPanel().add(contentOptions, "contentOptions");
				application.getcFooter().add(contentFooterOptions, "contentFooterOptions");

				application.getContentHeader().show(application.getcHeader(), "contentHeaderOptions");
				application.getContentPanel().show(application.getcPanel(), "contentOptions");
				application.getContentFooter().show(application.getcFooter(), "contentFooterOptions");

				application.OuvrirVolet();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("Cliquez ici pour accéder aux options");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblDescription.setText("");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	public void initComponents() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 120, 120, 50, 120, 120, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 56, 45, 30, 10, 100, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblApplication = new JLabel("Laboratoire Ligérien de Linguistique");
		lblApplication.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		GridBagConstraints gbc_lblApplication = new GridBagConstraints();
		gbc_lblApplication.gridwidth = 5;
		gbc_lblApplication.insets = new Insets(0, 0, 5, 5);
		gbc_lblApplication.gridx = 2;
		gbc_lblApplication.gridy = 1;
		add(lblApplication, gbc_lblApplication);

		lblDescription = new JLabel("");
		lblDescription.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridwidth = 5;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 2;
		gbc_lblDescription.gridy = 3;
		add(lblDescription, gbc_lblDescription);

		btnParseur = new JButton("Parseur XML\n");
		btnParseur.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnParseur = new GridBagConstraints();
		gbc_btnParseur.fill = GridBagConstraints.BOTH;
		gbc_btnParseur.insets = new Insets(0, 0, 5, 5);
		gbc_btnParseur.gridx = 3;
		gbc_btnParseur.gridy = 5;
		add(btnParseur, gbc_btnParseur);

		btnOptions = new JButton("Options");
		btnOptions.setPreferredSize(new Dimension(120, 100));
		GridBagConstraints gbc_btnOptions = new GridBagConstraints();
		gbc_btnOptions.fill = GridBagConstraints.BOTH;
		gbc_btnOptions.insets = new Insets(0, 0, 5, 5);
		gbc_btnOptions.gridx = 5;
		gbc_btnOptions.gridy = 5;
		add(btnOptions, gbc_btnOptions);
	}

	
	/**
	 * @return the lblApplication
	 */
	public JLabel getLblApplication() {
		return lblApplication;
	}

	/**
	 * @param lblApplication the lblApplication to set
	 */
	public void setLblApplication(JLabel lblApplication) {
		this.lblApplication = lblApplication;
	}

	/**
	 * @return the lblDescription
	 */
	public JLabel getLblDescription() {
		return lblDescription;
	}

	/**
	 * @param lblDescription the lblDescription to set
	 */
	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}

	/**
	 * @return the btnParseur
	 */
	public JButton getBtnParseur() {
		return btnParseur;
	}

	/**
	 * @param btnParseur the btnParseur to set
	 */
	public void setBtnParseur(JButton btnParseur) {
		this.btnParseur = btnParseur;
	}

	/**
	 * @return the btnOptions
	 */
	public JButton getBtnOptions() {
		return btnOptions;
	}

	/**
	 * @param btnOptions the btnOptions to set
	 */
	public void setBtnOptions(JButton btnOptions) {
		this.btnOptions = btnOptions;
	}

	/**
	 * @return the voletHeaderParseur
	 */
	public VoletHeaderParseur getVoletHeaderParseur() {
		return voletHeaderParseur;
	}

	/**
	 * @param voletHeaderParseur the voletHeaderParseur to set
	 */
	public void setVoletHeaderParseur(VoletHeaderParseur voletHeaderParseur) {
		this.voletHeaderParseur = voletHeaderParseur;
	}

	/**
	 * @return the voletParseur
	 */
	public VoletParseur getVoletParseur() {
		return voletParseur;
	}

	/**
	 * @param voletParseur the voletParseur to set
	 */
	public void setVoletParseur(VoletParseur voletParseur) {
		this.voletParseur = voletParseur;
	}

	/**
	 * @return the voletFooterParseur
	 */
	public VoletFooterParseur getVoletFooterParseur() {
		return voletFooterParseur;
	}

	/**
	 * @param voletFooterParseur the voletFooterParseur to set
	 */
	public void setVoletFooterParseur(VoletFooterParseur voletFooterParseur) {
		this.voletFooterParseur = voletFooterParseur;
	}

	/**
	 * @return the contentHeaderParseur
	 */
	public ContentHeaderParseur getContentHeaderParseur() {
		return contentHeaderParseur;
	}

	/**
	 * @param contentHeaderParseur the contentHeaderParseur to set
	 */
	public void setContentHeaderParseur(ContentHeaderParseur contentHeaderParseur) {
		this.contentHeaderParseur = contentHeaderParseur;
	}

	/**
	 * @return the contentParseur
	 */
	public ContentParseur getContentParseur() {
		return contentParseur;
	}

	/**
	 * @param contentParseur the contentParseur to set
	 */
	public void setContentParseur(ContentParseur contentParseur) {
		this.contentParseur = contentParseur;
	}

	/**
	 * @return the contentFooterParseur
	 */
	public ContentFooterParseur getContentFooterParseur() {
		return contentFooterParseur;
	}

	/**
	 * @param contentFooterParseur the contentFooterParseur to set
	 */
	public void setContentFooterParseur(ContentFooterParseur contentFooterParseur) {
		this.contentFooterParseur = contentFooterParseur;
	}

	/**
	 * @return the voletHeaderOptions
	 */
	public VoletHeaderOptions getVoletHeaderOptions() {
		return voletHeaderOptions;
	}

	/**
	 * @param voletHeaderOptions the voletHeaderOptions to set
	 */
	public void setVoletHeaderOptions(VoletHeaderOptions voletHeaderOptions) {
		this.voletHeaderOptions = voletHeaderOptions;
	}

	/**
	 * @return the voletOptions
	 */
	public VoletOptions getVoletOptions() {
		return voletOptions;
	}

	/**
	 * @param voletOptions the voletOptions to set
	 */
	public void setVoletOptions(VoletOptions voletOptions) {
		this.voletOptions = voletOptions;
	}

	/**
	 * @return the voletFooterOptions
	 */
	public VoletFooterOptions getVoletFooterOptions() {
		return voletFooterOptions;
	}

	/**
	 * @param voletFooterOptions the voletFooterOptions to set
	 */
	public void setVoletFooterOptions(VoletFooterOptions voletFooterOptions) {
		this.voletFooterOptions = voletFooterOptions;
	}

	/**
	 * @return the contentHeaderOptions
	 */
	public ContentHeaderOptions getContentHeaderOptions() {
		return contentHeaderOptions;
	}

	/**
	 * @param contentHeaderOptions the contentHeaderOptions to set
	 */
	public void setContentHeaderOptions(ContentHeaderOptions contentHeaderOptions) {
		this.contentHeaderOptions = contentHeaderOptions;
	}

	/**
	 * @return the contentOptions
	 */
	public ContentOptions getContentOptions() {
		return contentOptions;
	}

	/**
	 * @param contentOptions the contentOptions to set
	 */
	public void setContentOptions(ContentOptions contentOptions) {
		this.contentOptions = contentOptions;
	}

	/**
	 * @return the contentFooterOptions
	 */
	public ContentFooterOptions getContentFooterOptions() {
		return contentFooterOptions;
	}

	/**
	 * @param contentFooterOptions the contentFooterOptions to set
	 */
	public void setContentFooterOptions(ContentFooterOptions contentFooterOptions) {
		this.contentFooterOptions = contentFooterOptions;
	}

}
