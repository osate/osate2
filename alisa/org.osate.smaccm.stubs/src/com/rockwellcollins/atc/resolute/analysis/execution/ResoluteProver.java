package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import org.osate.aadl2.NamedElement;

import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;

public class ResoluteProver {

	protected final Deque<Map<NamedElement, ResoluteValue>> varStack = new LinkedList<>();

	public ResoluteProver(EvaluationContext context) {
	}

	protected ResoluteEvaluator createResoluteEvaluator() {
		return null;
	}

	public ResoluteResult doSwitch(FnCallExpr fcncall) {
		return null;
	}

}
