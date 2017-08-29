package org.osate.ge.graphics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum LineWidth {
	Small(2), Medium(4), Large(6);

	private static final Map<Integer, LineWidth> valueToLineWidth;
	static {
		final Map<Integer, LineWidth> modifiableMap = new HashMap<Integer, LineWidth>();
		for(final LineWidth lineWidth : LineWidth.values()) {
			modifiableMap.put(lineWidth.getValue(), lineWidth);
		}
		valueToLineWidth = Collections.unmodifiableMap(modifiableMap);
	}

	private LineWidth(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static LineWidth getByValue(final int lineWidthId) {
		return valueToLineWidth.get(lineWidthId);
	}

	private final int value;
}