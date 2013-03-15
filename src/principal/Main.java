package principal;


import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



/**
 * Ceci est le Main de l'application.
 * 
 * @author Valentin DOULCIER
 * @version 0.0.1
 */
public class Main {

	/**
	 * Fonction Main.
	 * Cette classe lance un thread initialisant la fenêtre.
	 * 
	 * @param args
	 * @throws DatabaseOffException
	 */
	public static void main(String[] args){

		useScreenMenuBar();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Application();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void useScreenMenuBar() {
		try {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Application L.L.L.");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(ClassNotFoundException e) {
			// TODO;
		}
		catch(InstantiationException e) {
			// TODO;
		}
		catch(IllegalAccessException e) {
			// TODO;
		}
		catch(UnsupportedLookAndFeelException e) {
			// TODO;
		}
	}


}
