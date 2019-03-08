package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;

import com.rockwellcollins.atc.resolute.analysis.values.NamedElementValue;

public class EvaluationContext {
	private final ComponentInstance thisInst;
	private final Map<String, SortedSet<NamedElement>> sets;
	private final FeatureToConnectionsMap featToConnsMap;

	public EvaluationContext(ComponentInstance thisInst, Map<String, SortedSet<NamedElement>> sets,
			FeatureToConnectionsMap featToConnsMap) {
		this.thisInst = thisInst;
		this.sets = sets;
		this.featToConnsMap = featToConnsMap;
	}

	public ComponentInstance getThisInstance() {
		return thisInst;
	}

	public Set<NamedElement> getSet(String name) {
		Set<NamedElement> set = sets.get(name);
		if (set == null) {
			return Collections.emptySet();
		} else {
			return set;
		}
	}

	public List<NamedElementValue> getConnectionsForFeature(FeatureInstance feat) {
		return featToConnsMap.get(feat);
	}
}
