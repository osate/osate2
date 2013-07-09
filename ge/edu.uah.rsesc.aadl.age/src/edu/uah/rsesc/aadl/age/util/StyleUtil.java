package edu.uah.rsesc.aadl.age.util;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.ui.PlatformUI;

import edu.uah.rsesc.aadl.age.styles.StyleProvider;

// TODO: Consider removing class
public class StyleUtil {	
	private static Style getStyle(final Diagram diagram, final String styleId) {
		final StyleProvider styleProvider = (StyleProvider)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(StyleProvider.class);
		return styleProvider.getStyle(diagram, styleId);
	}
	private static Style getImplementationStyleConditionally(final Diagram diagram, final String styleId, final boolean getImplementation) {
		final String finalStyleId = getImplementation ? (styleId + "-implementation") : styleId;
		return getStyle(diagram, finalStyleId);
	}
	
	public static Style getSystemStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "system", isImplementation);
	}
	
	public static Style getProcessStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "process", isImplementation);
	}
	
	public static Style getThreadGroupStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "thread-group", isImplementation);
	}
	
	public static Style getThreadStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "thread", isImplementation);
	}
	
	public static Style getSubprogramStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "subprogram", isImplementation);
	}
	
	public static Style getSubprogramGroupStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "subprogram-group", isImplementation);
	}
	
	public static Style getDataStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "data", isImplementation);
	}
	
	public static Style getAbstractStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "abstract", isImplementation);
	}
	
	public static Style getVirtualBusStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "virtual-bus", isImplementation);
	}
	
	public static Style getVirtualProcessorStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "virtual-proessor", isImplementation);
	}
	
	public static Style getBusStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "bus", isImplementation);
	}
	
	public static Style getProcessorStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "processor", isImplementation);
	}
	
	public static Style getDeviceStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "device", isImplementation);
	}
	
	public static Style getMemoryStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "memory", isImplementation);
	}
	
	public static Style getFeatureGroupTypeStyle(final Diagram diagram) {
		return getImplementationStyleConditionally(diagram, "feature-group-type", false);
	}
	
	public static Style getShadedStyle(final Diagram diagram) {
		return getStyle(diagram, "shaded");
	}
	
	public static Style getImplementsStyle(final Diagram diagram) {
		return getStyle(diagram, "implements");
    }
	
	public static Style getExtendsStyle(final Diagram diagram) {
		return getStyle(diagram, "extends");
    }	
	
	public static Style getGeneralizationArrowHeadStyle(final Diagram diagram) {
		return getStyle(diagram, "generalization-arrowhead");
    }
	
	public static Style getClassifierLabelStyle(final Diagram diagram) {
		return getStyle(diagram, "classifier-label");
    }
}
