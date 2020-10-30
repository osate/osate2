package org.osate.aadl2.provider.Decorator;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.QualifiedName;

/**
 * Utility class to add, modify, get the persistent property of the
 * resource.
 *
 */
public class ResourcePropertiesManager {
	/**
	 * Constructor for DemoResourcePersistentProperty.
	 */
	public ResourcePropertiesManager() {
	}

	/**
	 * Get the Busy status of the resource
	 * 
	 * @param resource IResource
	 * 
	 * @return true if the resource is Busy
	 * @return false if the resource is not busy
	 * 
	 */
	private static boolean isBusy(IResource resource) {
		String busyValue;
		// Get the Busy Qualified Name
		QualifiedName busyQualifiedName = PersistentPropertyTypes.getInstance().getBusyQualifiedName();
		try {
			// Get the Busy Value
			busyValue = resource.getPersistentProperty(busyQualifiedName);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (busyValue != null && busyValue.equals("true")) {
			return true;
		}
		return false;
	}

	/**
	 * Get the Prefix for the label of the resource
	 * 
	 * @param resource IResource object
	 * 
	 * @return prefix for the resource
	 * 
	 */
	public static String getPrefix(IResource resource) {
		String prefixValue;
		// Get the Prefix Qualified Name
		QualifiedName prefixQualifiedName = PersistentPropertyTypes.getInstance().getPrefixQualifiedName();

		try {
			// Get the prefix value
			prefixValue = resource.getPersistentProperty(prefixQualifiedName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		if (prefixValue != null) {
			return prefixValue;
		}
		return null;
	}

	/**
	 * Get the Suffix for the label of the resource
	 * 
	 * @param resource IResource object
	 * 
	 * @return Suffix Label for the resource
	 * 
	 */
	public static String getSuffix(IResource resource) {
		String suffixValue;
		// Get the Suffix Qualified Name
		QualifiedName suffixQualifiedName = PersistentPropertyTypes.getInstance().getSuffixQualifiedName();

		try {
			// Get the Suffix label
			suffixValue = resource.getPersistentProperty(suffixQualifiedName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		if (suffixValue != null) {
			return suffixValue;
		}
		return null;
	}

	/**
	 * Generic method to add persistent properties for the resource
	 * 
	 * @param resource IResource object
	 * @param localName qualifier name of the persistent property
	 * @param value indicate the value of the property
	 * 
	 */
	public static void addPersistentProperty(IResource resource, String localName, String value) {
		// Get the correct Qualified Name
		QualifiedName qName = PersistentPropertyTypes.getInstance().getQualifiedName(localName);

		try {
			resource.setPersistentProperty(qName, value);
		}
		// Catch Exception
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Add persistent properties for a resource list
	 * 
	 * @param resourceList List of IResource objects
	 * @param localName qualifier name of the persistent property
	 * @param value  to indicate the value of the property
	 * 
	 */
	public static void addPersistentProperty(List resourceList, String localName, String value) {
		// Get the correct Qualified Name
		QualifiedName qName = PersistentPropertyTypes.getInstance().getQualifiedName(localName);

		IResource resource;
		Iterator i = resourceList.iterator();

		while (i.hasNext()) {
			resource = (IResource) i.next();
			try {
				resource.setPersistentProperty(qName, value);
			}
			// Catch Exception
			catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Find the decorator image for the resource.
	 * 
	 * @param resource IResource Object
	 * 
	 * @return the image decoration as List. For eg: If the file has a read
	 * only property set, it returns a list with Lock as the only element 
	 */
	public static Vector findDecorationImageForResource(IResource resource) {
		Vector qualifiedValue = new Vector();
		String value;
		if (isBusy(resource)) {
			value = "Lock";
			qualifiedValue.add(value);
		}
		return qualifiedValue;
	}

	/**
	 * Find the decorator text for the resource
	 * 
	 * @param res IResource Object
	 * 
	 * @return the decorator text 
	 */

	/*
	 * public static String findDecorationTextForResource(IResource resource)
	 * {
	 * String returnText = "";
	 * String prefixText = "";
	 * 
	 * try
	 * {
	 * prefixText = getPrefix(resource);
	 * if(prefixText != null && prefixText.length() != 0)
	 * {
	 * 
	 * 
	 * 
	 * }
	 * 
	 * if(getPrefix(resource) )
	 * {
	 * return getOwner(resource);
	 * }
	 * return null;
	 * }
	 * catch(Exception e)
	 * {
	 * System.out.println(e.getMessage());
	 * return null;
	 * }
	 * }
	 */

}
