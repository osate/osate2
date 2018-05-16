package org.osate.ge.internal.diagram.runtime.styling;

import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

public interface StyleProvider {
	public final StyleProvider EMPTY = de -> Style.EMPTY;

	Style getStyle(final DiagramElement de);
}
