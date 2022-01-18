package org.osate.slicer.tests;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.slicer.SlicerRepresentation;

public class SlicerTestUtil {
	public static ComponentInstance getInstance(String name, ComponentCategory category, SystemInstance si,
			SlicerRepresentation sr) {
		return si.getAllComponentInstances(category)
				.stream()
				.filter(ci -> name.equals(sr.getCompleteFeatureName(ci)))
				.findFirst()
				.get();
	}
}
