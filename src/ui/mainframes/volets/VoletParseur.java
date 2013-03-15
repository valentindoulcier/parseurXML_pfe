/**
 * 
 */
package ui.mainframes.volets;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import principal.Application;


/**
 * @author Valentin
 *
 */
public class VoletParseur extends JPanel {

	private static final long serialVersionUID = -7929534743664074552L;

	//private static Logger logger = Logger.getLogger(VoletParseur.class);
	
	
	/**
	 * Create the panel.
	 * @param application 
	 */
	public VoletParseur(Application application) {

		initComponents(application);
	}

	public void initComponents(Application application) {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(300, 540));

	}

}
