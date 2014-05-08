package com.synel.synergy.synergy2416.presentation.view;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Robot;
import java.awt.SplashScreen;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.synel.synergy.synergy2416.presentation.controller.SynergyAudioPool;
import com.synel.synergy.synergy2416.presentation.controller.SynergyEventController;
import com.synel.synergy.synergy2416.presentation.controller.SynergyEventDispatcher;
import com.synel.synergy.synergy2416.presentation.controller.SynergyEventDispatcher.SYNERGY_STATUS;

public class MainWindow extends JFrame {

	/**
	 *  This is the main entrance of the Application follow MVC pattern
	 */
	private static SynergyEventController m_sec;
	private static SynergyEventDispatcher m_sed;
	private static SynergyAudioPool m_sap;
	private static final SplashScreen m_splash = SplashScreen.getSplashScreen();

	public static SplashScreen getmSplash() {
		return m_splash;
	}

	public static void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = {"database", "fingerprintreader","event controller"};
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120,140,200,40);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("Loading "+comps[(frame)%3]+"...", 120, 150);
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					try {
						startMainThread();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InterruptedException e) {
			// Ignore: If this exception occurs, we return too early, which
            // makes the splash window go away too early.
            // Nothing to worry about. Maybe we should write a log message.
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// Error: Startup has failed badly. 
            // We can not continue running our application.
            InternalError error = new InternalError();
            error.initCause(e);
            throw error;
		}
	}

	public SynergyEventController get_Sec() {
		return m_sec;
	}

	public SynergyEventDispatcher get_Sed() {
		return m_sed;
	}

	public static SynergyAudioPool get_Sap() {
		return m_sap;
	}

	/**
	 * Create the frame.
	 */
	public MainWindow(String name) {
		super(name);
		if (m_splash == null){
			System.out.println("getSplashScreen() returned null");
			return;
		}
//		Graphics2D g = m_splash.createGraphics();
//		if (g == null){
//			System.out.println("g is null");
//			return;
//		}
//		for(int i=0; i<3; i++) {
//			renderSplashFrame(g,i);
//			m_splash.update();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//m_splash.close(); //do not close it until the main screen is ready to show.
	}
	
	
	private static void startMainThread() {
		//Create and set up the main window.
		MainWindow m_frame = new MainWindow("Synergy2416MainWindow");
		m_sap = new SynergyAudioPool();
		m_sap.reloadAudioSounds();
		m_sed = new SynergyEventDispatcher();
		m_sec = new SynergyEventController(m_frame);
		m_sec.initialize();
		m_sed.initialize();
		
		
//		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
//        manager.addKeyEventDispatcher(m_ced);
        m_frame.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                System.out.println("Focus GAINED:"+e);
            }
            public void focusLost(FocusEvent e){
                System.out.println("Focus LOST:"+e);

                // FIX FOR GNOME/XWIN FOCUS BUG
                e.getComponent().requestFocus();
            }
        });
        
        //#IF DEBUG
        Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener(){
            public void eventDispatched(AWTEvent e) {
            		if (e.toString().contains("JButton")) {
            			System.out.println("JButton:"+e.getSource().toString());
            			//MainWindow.simulateMouseClick((Component) e.getSource());
            			//MainWindow.simulateKeyPadClick(KeyEvent.VK_ESCAPE);	
            		}
                    System.out.println("AWT:"+e);
                    System.out.flush();
            }
        }, FocusEvent.FOCUS_EVENT_MASK | WindowEvent.WINDOW_FOCUS_EVENT_MASK | WindowEvent.WINDOW_EVENT_MASK);
	}

	public void returnToMain() {
		if (m_sed != null){
		m_sed.diffAndEmit(SYNERGY_STATUS.SYNERGYSTATUS_MENU);
		}
	}
	
public static void simulateMouseClick(Component source) {
    // create a simulated mouse event
     Point p = source.getLocationOnScreen();
    MouseEvent click = new MouseEvent(source, MouseEvent.BUTTON1, System.currentTimeMillis(),
            0, p.x, p.y, 1, false);
 
    // broadcast the mouse click to all registered mouse listeners
    MouseListener[] listeners = (MouseListener[]) source.getListeners(MouseListener.class);
    for (int i=0; i<listeners.length; i++) {
        listeners[i].mouseClicked(click);
    }
}

public static void simulateKeyPadClick(int keycode){
	Robot r = null;
	try {
		r = new Robot();
	} catch (AWTException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	if (r != null){
		System.out.println("simulate press key!"+keycode);
		try{Thread.sleep(50);}catch(InterruptedException e1){}
		r.keyPress(keycode);
		try{Thread.sleep(50);}catch(InterruptedException e1){}
		r.keyRelease(keycode);
	}
  }	

}
