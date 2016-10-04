package org.osate.ge.internal.graphics;

import org.osate.ge.internal.styles.StyleConstants;

public enum ConnectionStyle {
	SOLID(StyleConstants.SOLID_CONNECTION_STYLE),
	DASHED(StyleConstants.DASHED_CONNECTION_STYLE);
	
	private final String styleId;
	
	ConnectionStyle(final String styleId) {
		this.styleId = styleId;
	}
	
	public String getStyleId() {
		return styleId;
	}
}
