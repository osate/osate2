package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue;
import com.rockwellcollins.atc.resolute.resolute.util.ResoluteSwitch;

public class ResoluteProver extends ResoluteSwitch<ResoluteResult> {
	// Stack for function, claim, and quantifier arguments
	protected final Deque<Map<NamedElement, ResoluteValue>> varStack = new LinkedList<>();

	protected final EvaluationContext context;

	public ResoluteProver(EvaluationContext context) {
		this.context = context;
	}

	/* This will be overridden by children to instantiate modified evaluators */
	protected ResoluteEvaluator createResoluteEvaluator() {
		return null;
	}

	protected ResoluteValue eval(EObject e) {
		return null;
	}

}
