package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.Map;
import java.util.SortedSet;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;

public class EvaluationContext {

	public EvaluationContext(ComponentInstance targetComponent, Map<String, SortedSet<NamedElement>> sets,
			FeatureToConnectionsMap featToConnsMap) {
	}

	public NamedElement getThisInstance() {
		return null;
	}

}
