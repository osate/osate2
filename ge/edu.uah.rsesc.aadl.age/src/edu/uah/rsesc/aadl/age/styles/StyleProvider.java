package edu.uah.rsesc.aadl.age.styles;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public interface StyleProvider {
	Style getStyle(Diagram diagram, String id);
}
