/**
 * 
 */
package ui.mainframes.volets;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import principal.Application;
import ui.mainframes.contents.ContentHeaderHistorique;
import ui.mainframes.contents.ContentHeaderParseur;
import ui.mainframes.contents.ContentHistorique;
import ui.mainframes.contents.ContentParseur;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Valentin
 *
 */
public class VoletFooterParseur extends JPanel {

	private static final long serialVersionUID = 1129835814490832264L;
	
	//-1 - Home Page
	// 1 - Parseur
	// 2 - Historique
	private int jeViensDe = -1;
	
	private JButton btnParseur;
	private JButton btnHistorique;
	
	private VoletHeaderParseur voletHeaderParseur;
	private VoletParseur voletParseur;
	
	private VoletHeaderHistorique voletHeaderHistorique;
	private VoletHistorique voletHistorique;
	
	
	private ContentHeaderParseur contentHeaderParseur;
	private ContentParseur contentParseur;
	
	private ContentHeaderHistorique contentHeaderHistorique;
	private ContentHistorique contentHistorique;
	

	/**
	 * Create the panel.
	 */
	public VoletFooterParseur(final Application application) {
		
		initComponents();
		
		btnParseur.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(jeViensDe == -1) {
					voletHeaderParseur = application.getContentHome().getVoletHeaderParseur();
					voletParseur = application.getContentHome().getVoletParseur();
					
					application.getvHeader().remove(application.getContentHome().getVoletHeaderParseur());
					application.getvPanel().remove(application.getContentHome().getVoletParseur());
					
					application.getvHeader().add(voletHeaderParseur, "voletHeaderParseur");
					application.getvPanel().add(voletParseur, "voletParseur");

					contentHeaderParseur = application.getContentHome().getContentHeaderParseur();
					contentParseur = application.getContentHome().getContentParseur();
					
					application.getcHeader().remove(application.getContentHome().getContentHeaderParseur());
					application.getcPanel().remove(application.getContentHome().getContentParseur());

					application.getcHeader().add(contentHeaderParseur, "contentHeaderParseur");
					application.getcPanel().add(contentParseur, "contentParseur");
					
					jeViensDe = 1;
				}
				
				if(jeViensDe == 2) {
					voletHeaderParseur = new VoletHeaderParseur();
					voletParseur = new VoletParseur(application);
					
					application.getvHeader().add(voletHeaderParseur, "voletHeaderParseur");
					application.getvPanel().add(voletParseur, "voletParseur");
				
					contentHeaderParseur = new ContentHeaderParseur(application);
					contentParseur = new ContentParseur(application);
				
					application.getcHeader().add(contentHeaderParseur, "contentHeaderParseur");
					application.getcPanel().add(contentParseur, "contentParseur");
					
					application.getvHeader().remove(voletHeaderHistorique);
					application.getvPanel().remove(voletHistorique);
					
					application.getcHeader().remove(contentHeaderHistorique);
					application.getcPanel().remove(contentHistorique);					
				}
				
				application.getVoletHeader().show(application.getvHeader(), "voletHeaderParseur");
				application.getVoletPanel().show(application.getvPanel(), "voletParseur");
				
				application.getContentHeader().show(application.getcHeader(), "contentHeaderParseur");
				application.getContentPanel().show(application.getcPanel(), "contentParseur");
				
				jeViensDe = 1;
			}
			
		});
		
		btnHistorique.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(jeViensDe == -1) {
					voletHeaderParseur = application.getContentHome().getVoletHeaderParseur();
					voletParseur = application.getContentHome().getVoletParseur();
					
					application.getvHeader().remove(application.getContentHome().getVoletHeaderParseur());
					application.getvPanel().remove(application.getContentHome().getVoletParseur());
					
					application.getvHeader().add(voletHeaderParseur, "voletHeaderParseur");
					application.getvPanel().add(voletParseur, "voletParseur");

					contentHeaderParseur = application.getContentHome().getContentHeaderParseur();
					contentParseur = application.getContentHome().getContentParseur();
					
					application.getcHeader().remove(application.getContentHome().getContentHeaderParseur());
					application.getcPanel().remove(application.getContentHome().getContentParseur());

					application.getcHeader().add(contentHeaderParseur, "contentHeaderParseur");
					application.getcPanel().add(contentParseur, "contentParseur");
					
					jeViensDe = 1;
				}
				
				if(jeViensDe == 1) {
					voletHeaderHistorique = new VoletHeaderHistorique();
					voletHistorique = new VoletHistorique(application);
					
					application.getvHeader().add(voletHeaderHistorique, "voletHeaderHistorique");
					application.getvPanel().add(voletHistorique, "voletHistorique");
					
					contentHeaderHistorique = new ContentHeaderHistorique(application);
					contentHistorique = new ContentHistorique(application);
					
					application.getcHeader().add(contentHeaderHistorique, "contentHeaderHistorique");
					application.getcPanel().add(contentHistorique, "contentHistorique");
					
					application.getvHeader().remove(voletHeaderParseur);
					application.getvPanel().remove(voletParseur);
					
					application.getcHeader().remove(contentHeaderParseur);
					application.getcPanel().remove(contentParseur);	
				}
				
				//voletHistorique.chargerHistorique(application);
				
				application.getVoletHeader().show(application.getvHeader(), "voletHeaderHistorique");
				application.getVoletPanel().show(application.getvPanel(), "voletHistorique");
				
				application.getContentHeader().show(application.getcHeader(), "contentHeaderHistorique");
				application.getContentPanel().show(application.getcPanel(), "contentHistorique");
				
				jeViensDe = 2;
			}
			
		});
		
	}
	
	public void initComponents() {
		
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(300, 30));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 100, 100, 100, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnParseur = new JButton("Parseur");
		btnParseur.setSize(80, 25);
		GridBagConstraints gbc_btnParseur = new GridBagConstraints();
		gbc_btnParseur.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnParseur.insets = new Insets(0, 0, 0, 5);
		gbc_btnParseur.gridx = 1;
		gbc_btnParseur.gridy = 0;
		add(btnParseur, gbc_btnParseur);
		
		btnHistorique = new JButton("Histo");
		btnHistorique.setSize(80, 25);
		GridBagConstraints gbc_btnHistorique = new GridBagConstraints();
		gbc_btnHistorique.insets = new Insets(0, 0, 0, 5);
		gbc_btnHistorique.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHistorique.gridx = 2;
		gbc_btnHistorique.gridy = 0;
		add(btnHistorique, gbc_btnHistorique);
	}

	
	/**
	 * @return the jeViensDe
	 */
	public int getJeViensDe() {
		return jeViensDe;
	}

	/**
	 * @param jeViensDe the jeViensDe to set
	 */
	public void setJeViensDe(int jeViensDe) {
		this.jeViensDe = jeViensDe;
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
	 * @return the btnHistorique
	 */
	public JButton getBtnHistorique() {
		return btnHistorique;
	}

	/**
	 * @param btnHistorique the btnHistorique to set
	 */
	public void setBtnHistorique(JButton btnHistorique) {
		this.btnHistorique = btnHistorique;
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
	 * @return the voletHeaderHistorique
	 */
	public VoletHeaderHistorique getVoletHeaderHistorique() {
		return voletHeaderHistorique;
	}

	/**
	 * @param voletHeaderHistorique the voletHeaderHistorique to set
	 */
	public void setVoletHeaderHistorique(VoletHeaderHistorique voletHeaderHistorique) {
		this.voletHeaderHistorique = voletHeaderHistorique;
	}

	/**
	 * @return the voletHistorique
	 */
	public VoletHistorique getVoletHistorique() {
		return voletHistorique;
	}

	/**
	 * @param voletHistorique the voletHistorique to set
	 */
	public void setVoletHistorique(VoletHistorique voletHistorique) {
		this.voletHistorique = voletHistorique;
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
	 * @return the contentHeaderHistorique
	 */
	public ContentHeaderHistorique getContentHeaderHistorique() {
		return contentHeaderHistorique;
	}

	/**
	 * @param contentHeaderHistorique the contentHeaderHistorique to set
	 */
	public void setContentHeaderHistorique(
			ContentHeaderHistorique contentHeaderHistorique) {
		this.contentHeaderHistorique = contentHeaderHistorique;
	}

	/**
	 * @return the contentHistorique
	 */
	public ContentHistorique getContentHistorique() {
		return contentHistorique;
	}

	/**
	 * @param contentHistorique the contentHistorique to set
	 */
	public void setContentHistorique(ContentHistorique contentHistorique) {
		this.contentHistorique = contentHistorique;
	}

}
