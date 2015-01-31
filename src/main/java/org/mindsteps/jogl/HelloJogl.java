package org.mindsteps.jogl;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;


/**
 * Copyright 2014 mindsteps BV
 * <p/>
 * User: Hans Speijer
 * Date: 31/01/15
 * Time: 00:05
 */

public class HelloJogl {
    public static void main (String args[]) {
        try {
//            System.loadLibrary("jogl-application-version");
            System.out.println(
                    "Hello World! (The native libraries are installed.)"
            );
            GLProfile.initSingleton();
            GLProfile glp = GLProfile.getDefault();
            GLCapabilities caps = new GLCapabilities(glp);
            System.out.println(
                    "Hello JOGL! (The jar appears to be available.)"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

