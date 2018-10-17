package com.rockwellcollins.atc.resolute.analysis.results;

import org.eclipse.emf.ecore.EObject;

public interface ClaimResult extends ResoluteResult {

	String getText();

	EObject getLocation();

}
