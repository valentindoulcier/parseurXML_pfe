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
public class ContentHeaderOptions extends JPanel {

	private static final long serialVersionUID = 892303700119402290L;
	
	private static boolean ouvert = false;

	/**
	 * Create the panel.
	 * @param application 
	 */
	public ContentHeaderOptions(final Application application) {
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
				// TODO Auto-generated method stub
				application.getContentHeader().show(application.getcHeader(), "ContentHeaderHome");
				application.getContentPanel().show(application.getcPanel(), "ContentHome");
				application.getContentFooter().show(application.getcFooter(), "ContentFooterHome");
				
				application.FermerVolet();
				
				application.getcHeader().remove(application.getContentHome().getContentHeaderOptions());
				application.getcPanel().remove(application.getContentHome().getContentOptions());
				application.getcFooter().remove(application.getContentHome().getContentFooterOptions());
				
				application.getvHeader().remove(application.getContentHome().getVoletHeaderOptions());
				application.getvPanel().remove(application.getContentHome().getVoletOptions());
				application.getvFooter().remove(application.getContentHome().getVoletFooterOptions());
				
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
