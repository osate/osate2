package org.osate.ge.internal.util;

import java.util.Collection;

import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

public class DiagamElementUtil {
	public static boolean allHaveSameParent(final Collection<DiagramElement> diagramElements) {
		if (diagramElements.size() == 0) {
			return true;
		}

		final DiagramNode parent = diagramElements.iterator().next().getParent();
		return diagramElements.stream().allMatch(de -> de.getParent() == parent);
	}
}
