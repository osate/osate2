package org.osate.ge.internal.util;

public class ImageHelper {
	protected static final String PREFIX = "org.osate.ge.";
    /**
     * Returns the full image id of an image registered by the org.osate.ge plugin. 
     */
    public static String getImage(final String imageId) {
    	return PREFIX + imageId;
    }
}