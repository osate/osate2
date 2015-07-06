package org.osate.aadl2.properties;

import java.util.List;

import org.osate.aadl2.PropertyAssociation;

public class PropertyEvaluationResult {

	private PropertyAssociation pa;
	
	private List<EvaluatedProperty> evaluated;

	public PropertyEvaluationResult(PropertyAssociation pa, List<EvaluatedProperty> evaluated) {
		this.pa = pa;
		this.evaluated = evaluated;
	}

	public PropertyAssociation getPa() {
		return pa;
	}

	public List<EvaluatedProperty> getEvaluated() {
		return evaluated;
	}
}
