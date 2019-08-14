package org.osate.ge.internal.util.classifiers;

public enum ClassifierOperationPartType {
	NONE, NEW_COMPONENT_TYPE, NEW_COMPONENT_IMPLEMENTATION, NEW_FEATURE_GROUP_TYPE, EXISTING;

	public static boolean isCreate(ClassifierOperationPartType op) {
		return isComponentClassifierCreate(op)
				|| op == ClassifierOperationPartType.NEW_FEATURE_GROUP_TYPE;
	}

	public static boolean isComponentClassifierCreate(ClassifierOperationPartType op) {
		return op == ClassifierOperationPartType.NEW_COMPONENT_TYPE
				|| op == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION;
	}
}