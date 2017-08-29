package org.osate.ge.internal.businessObjectHandlers;

import java.awt.Color;

import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;

public class Styles {
	private final static Color INHERITED_ELEMENT_COLOR = new Color(96, 96, 96); // An inherited element is one that is inherited from an extendd classifier and
	// which has not been refined

	public final static Style INHERITED_ELEMENT_STYLE = StyleBuilder.create().foregroundColor(INHERITED_ELEMENT_COLOR)
			.build();

}
