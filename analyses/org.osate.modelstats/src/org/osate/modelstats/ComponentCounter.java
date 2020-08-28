package org.osate.modelstats;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;

public class ComponentCounter {
	public static ElementsCounts countComponents(SystemInstance si) {
		HashMap<ComponentCategory, Integer> categoryCounter = new HashMap<ComponentCategory, Integer>();
		int connectionCount = 0;
		int eteCount = 0;

		categoryCounter.put(si.getCategory(), 1); // places the top system in the HashMap because .eAllContents() returns all children

		for (Iterator<EObject> componentsTree = si.eAllContents(); componentsTree.hasNext();) {
			EObject curObject = componentsTree.next();
			if (curObject instanceof ComponentInstance) {
				ComponentCategory curCategory = ((ComponentInstance) curObject).getCategory();
				categoryCounter.put(curCategory, categoryCounter.getOrDefault(curCategory, 0) + 1);
			} else if (curObject instanceof EndToEndFlowInstance) {
				eteCount++;
			} else if (curObject instanceof ConnectionInstance) {
				connectionCount++;
			}
		}

		return new ElementsCounts(categoryCounter, connectionCount, eteCount);
	}
}
