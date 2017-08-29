package org.osate.ge.graphics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.osate.ge.internal.util.StringUtil;

public enum FontSize {
	Small(8.0), Medium(10.0), Large(16.0), ExtraLarge(20.0);

	private static final Map<Double, FontSize> valueToFontSize;
	static {
		final Map<Double, FontSize> modifiableMap = new HashMap<Double, FontSize>();
		for (final FontSize fontSize : FontSize.values()) {
			modifiableMap.put(fontSize.getValue(), fontSize);
		}
		valueToFontSize = Collections.unmodifiableMap(modifiableMap);
	}

	private FontSize(final double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return StringUtil.camelCaseToUser(super.toString());
	}

	public double getValue() {
		return value;
	}

	public static FontSize getByValue(final Double fontSizeId) {
		return valueToFontSize.get(fontSizeId);
	}

	private final Double value;
}