package org.mindsteps.jogl;

/**
 * Copyright 2014 mindsteps BV
 * <p/>
 * User: Hans Speijer
 * Date: 31/01/15
 * Time: 00:27
 */



import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.*;

/**
 * This is a basic JOGL app. Feel free to
 * reuse this code or modify it.
 */
public class JoglApp extends JFrame {
    public static void main(String[] args) {
        final JoglApp app = new JoglApp();
        // show what we've done
        SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        app.setVisible(true);
                    }
                }
        );
    }
    public JoglApp() {
        //set the JFrame title
        super("Simple JOGL Application");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //only three JOGL lines of code ... and here they are
        GLProfile.initSingleton();
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities glcapabilities = new GLCapabilities(glp);
        final GLCanvas glcanvas = new GLCanvas( glcapabilities );

        glcanvas.addGLEventListener( new GLEventListener() {

            @Override
            public void reshape( GLAutoDrawable glautodrawable, int x, int y, int width, int height ) {
                OneTriangle.setup( glautodrawable.getGL().getGL2(), width, height );
            }

            @Override
            public void init( GLAutoDrawable glautodrawable ) {
            }

            @Override
            public void dispose( GLAutoDrawable glautodrawable ) {
            }

            @Override
            public void display( GLAutoDrawable glautodrawable ) {
                OneTriangle.render( glautodrawable.getGL().getGL2(), glautodrawable.getWidth(), glautodrawable.getHeight() );
            }
        });

        final Frame frame = new Frame( "One Triangle AWT" );
        frame.add(glcanvas);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowevent) {
                frame.remove(glcanvas);
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setSize( 640, 480 );
        frame.setVisible(true);
    }
    public void centerWindow(Component frame) {
        Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width )
            frameSize.width = screenSize.width;
        if (frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        frame.setLocation (
                (screenSize.width - frameSize.width ) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}