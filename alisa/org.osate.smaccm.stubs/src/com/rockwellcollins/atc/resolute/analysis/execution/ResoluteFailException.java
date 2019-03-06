package com.rockwellcollins.atc.resolute.analysis.execution;

import org.eclipse.emf.ecore.EObject;

public class ResoluteFailException extends RuntimeException {
    private static final long serialVersionUID = 1268376776447468671L;
    private final EObject location;

    public ResoluteFailException(String str, EObject location) {
        super(str);
        this.location = location;
    }

    public EObject getLocation() {
        return location;
    }
}
