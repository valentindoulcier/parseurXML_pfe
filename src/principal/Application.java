/**
 * 
 */
package principal;

import java.awt.Window;

import javax.swing.JFrame;
import java.lang.reflect.Method;

/**
 * @author Valentin DOULCIER
 *
 */
public class Application extends JFrame {

	private static final long serialVersionUID = -5463882792147179527L;

	/**
	 * Create the frame.
	 */
	public Application() {

		if (isMacOSX()) {
			enableFullScreenMode(this);
		}

		initComponents();		
	}

	public void initComponents() {
		this.setTitle("Parseur XML");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1000, 600);
		this.setMinimumSize(getSize());

		this.setVisible(true);
	}
	
	/**
	 * Cette méthode regarde l'OS de l'utilisateur.
	 * 
	 * @return Un booleen qui indique si l'OS est Max OS X ou non.
	 */
	private static boolean isMacOSX() {
		return System.getProperty("os.name").indexOf("Mac OS X") >= 0;
	}

	/**
	 * Cette fonction permet à un utilisateur sous Mac OS X (Mountain Lion ou ultérieur) de passer en plein écran.
	 * 
	 * @param window
	 */
	public static void enableFullScreenMode(Window window) {
		String className = "com.apple.eawt.FullScreenUtilities";
		String methodName = "setWindowCanFullScreen";

		try {
			Class<?> clazz = Class.forName(className);

			Method method = clazz.getMethod(methodName, new Class<?>[] {
					Window.class, boolean.class 
			}
					);

			method.invoke(null, window, true);
		} catch (Throwable t) {
			System.err.println("Full screen mode is not supported");
			t.printStackTrace();
		}
	}
}
