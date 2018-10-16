package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.Map;

import org.osate.aadl2.NamedElement;

import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;

public class ResoluteEvaluator {

	public ResoluteEvaluator(EvaluationContext context, Map<NamedElement, ResoluteValue> env) {
	}

	public ResoluteValue caseThisExpr(ThisExpr object) {
		return null;
	}

}
