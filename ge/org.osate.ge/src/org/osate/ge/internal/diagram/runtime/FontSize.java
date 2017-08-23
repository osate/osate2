package org.osate.ge.internal.diagram.runtime;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum FontSize {
	Small(8.0),
	Default(10.0),
	Large(12.0);

	private static final Map<Double, FontSize> valueToFontSize;
	static {
		final Map<Double, FontSize> modifiableMap = new HashMap<Double, FontSize>();
		for(final FontSize fontSize : FontSize.values()) {
			modifiableMap.put(fontSize.getValue(), fontSize);
		}
		valueToFontSize = Collections.unmodifiableMap(modifiableMap);
	}

	private FontSize(final double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public static FontSize getByValue(final Double fontSizeId) {
		return valueToFontSize.get(fontSizeId);
	}

	private final Double value;
}