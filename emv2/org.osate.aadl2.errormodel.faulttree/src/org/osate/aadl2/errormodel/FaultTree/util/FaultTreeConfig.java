package org.osate.aadl2.errormodel.FaultTree.util;

import java.util.HashMap;
import java.util.Map;

public class FaultTreeConfig {
	public static final String DECIMAL_FORMAT = "Decimal";
	public static final String SCIENTIFIC_NOTATION_FORMAT = "Scientific Notation";

	private static final String ASSIGNED_PROBABILITY_KEY = "probability.format.key";
	private static final String DEFAULT_ASSIGNED_PROBABILITY_FORMAT = ".1e";

	private Map<String, String> config = new HashMap<>();
	private static final FaultTreeConfig INSTANCE = new FaultTreeConfig();

	private FaultTreeConfig() {
	}

	public static FaultTreeConfig getInstance() {
		return INSTANCE;
	}

	public String getProbabilityFormat() {
		String value = config.get(ASSIGNED_PROBABILITY_KEY);
		return value != null ? value : DEFAULT_ASSIGNED_PROBABILITY_FORMAT;
	}

	public void setProbabilityFormat(String format, String precision) {
		String result = ".";
		switch (format) {
		case DECIMAL_FORMAT:
			result += precision + "f";
			break;
		case SCIENTIFIC_NOTATION_FORMAT:
			result += precision + "e";
			break;
		}
		config.put(ASSIGNED_PROBABILITY_KEY, result);
	}

	public void resetProbabilityFormat() {
		config.put(ASSIGNED_PROBABILITY_KEY, DEFAULT_ASSIGNED_PROBABILITY_FORMAT);
	}
}
