package org.osate.aadl2.errormodel.analysis.fta;

public enum EventType {
	AND, OR, XOR, EVENT, NORMAL;

	public static String toString(EventType t) {
		switch (t) {
		case EVENT: {
			return "event";
		}

		case AND: {
			return "and";
		}

		case OR: {
			return "or";
		}

		case XOR: {
			return "xor";
		}
		default:
			return "";
		}
	}
}