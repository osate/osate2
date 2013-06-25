package edu.uah.rsesc.aadl.age.util;

import org.eclipse.graphiti.mm.StyleContainer;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;

public class StyleUtil {
	public static void updateStyles(final Diagram diagram) {
		getClassifierStyle(diagram);
		getSystemStyle(diagram, false);
		getSystemStyle(diagram, true);
		getProcessStyle(diagram, false);
		getProcessStyle(diagram, true);
		getThreadGroupStyle(diagram, false);
		getThreadGroupStyle(diagram, true);
		getThreadStyle(diagram, false);
		getThreadStyle(diagram, true);
		getSubprogramStyle(diagram, false);
		getSubprogramStyle(diagram, true);
		getSubprogramGroupStyle(diagram, false);
		getSubprogramGroupStyle(diagram, true);
		getDataStyle(diagram, false);
		getDataStyle(diagram, true);
		getAbstractStyle(diagram, false);
		getAbstractStyle(diagram, true);
		getVirtualBusStyle(diagram, false);
		getVirtualBusStyle(diagram, true);
		getVirtualProcessorStyle(diagram, false);
		getVirtualProcessorStyle(diagram, true);
		getBusStyle(diagram, false);
		getBusStyle(diagram, true);
		getProcessorStyle(diagram, false);
		getProcessorStyle(diagram, true);
		getDeviceStyle(diagram, false);
		getDeviceStyle(diagram, true);
		getMemoryStyle(diagram, false);
		getMemoryStyle(diagram, true);
		getFeatureGroupStyle(diagram, false);
		getFeatureGroupStyle(diagram, true);
		getImplementsStyle(diagram);
		getExtendsStyle(diagram);
		getGeneralizationArrowHeadStyle(diagram);
	}
	
	// TODO: Probably want style for each type of shape
	// TODO: Any way to change only if the styles has been updated
	// TODO: Will need styles for private vs public?
	
	private static Style getClassifierStyle(final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
        final Style style = getStyle(diagram, "classifer");
        
        // Set the style
        style.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
        style.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
        style.setLineStyle(LineStyle.SOLID);
        style.setLineVisible(true);
        style.setLineWidth(1);
        style.setTransparency(0.0);

        return style;
    }

	private static Style getImplementationStyle(final Style baseStyle) {
		final Style style = getStyle(baseStyle, baseStyle.getId() + "-implementation");
		style.setLineWidth(2);
		return style;
	}
		
	private static Style getImplementationStyleConditionally(final Style baseStyle, final boolean getImplementation) {
		return getImplementation ? getImplementationStyle(baseStyle) : baseStyle;
	}
	
	public static Style getSystemStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "system");
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getProcessStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "process");
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getThreadGroupStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "thread-group");
		style.setLineStyle(LineStyle.DASH);
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getThreadStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "thread");
		style.setLineStyle(LineStyle.DASH);
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getSubprogramStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "subprogram");
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getSubprogramGroupStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "subprogram-group");
		style.setLineStyle(LineStyle.DASH);
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getDataStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "data");
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getAbstractStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "abstract");
		style.setLineStyle(LineStyle.DASH);
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getVirtualBusStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "virtual-bus");
		style.setLineStyle(LineStyle.DASH);
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getVirtualProcessorStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "virtual-processor");
		style.setLineStyle(LineStyle.DASH);
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getBusStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "bus");
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getProcessorStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "processor");
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getDeviceStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "device");
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getMemoryStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "memory");
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getFeatureGroupStyle(final Diagram diagram, final boolean isImplementation) {
		final Style style = getStyle(getClassifierStyle(diagram), "feature-group");
		style.setBackground(Graphiti.getGaService().manageColor(diagram, ColorConstant.BLACK));
		return getImplementationStyleConditionally(style, isImplementation);
	}
	
	public static Style getShadedStyle(final Diagram diagram) {
		final Style style = getStyle(diagram, "shaded");
		style.setBackground(Graphiti.getGaService().manageColor(diagram, ColorConstant.LIGHT_GRAY));
		return style;
	}
	
	public static Style getImplementsStyle(final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
        final Style style = getStyle(diagram, "implements");
        
        // Set the style
        style.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
        style.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
        style.setLineStyle(LineStyle.SOLID);
        style.setLineVisible(true);
        style.setLineWidth(2);

        return style;
    }
	
	public static Style getExtendsStyle(final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
        final Style style = getStyle(diagram, "extends");
        
        // Set the style
        style.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
        style.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
        style.setLineStyle(LineStyle.DASH);
        style.setLineVisible(true);
        style.setLineWidth(2);

        return style;
    }	
	
	public static Style getGeneralizationArrowHeadStyle(final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
        final Style style = getStyle(diagram, "generalization-arrowhead");
        
        // Set the style
        style.setForeground(gaService.manageColor(diagram, ColorConstant.BLACK));
        style.setBackground(gaService.manageColor(diagram, ColorConstant.WHITE));
        style.setLineStyle(LineStyle.SOLID);
        style.setLineVisible(true);
        style.setLineWidth(2);

        return style;
    }
	
	private static Style getStyle(final StyleContainer parentStyle, final String id) {
		// TODO: Ability to not recreate style each time.. While running this could be really inefficient. Cach in map that will store it in 
		// memory until program closes?
		final IGaService gaService = Graphiti.getGaService();

        // Check if the style already exists
        Style style = gaService.findStyle(parentStyle, id);

        // Reset it if it does
        if(style == null) {
        	style = gaService.createPlainStyle(parentStyle, id);
        } else {
        	gaService.resetAll(style);        	
        }
        
		return style;
        
	}
}
