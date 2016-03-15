package org.osate.ge.internal.services.impl;

import java.util.Objects;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.ge.internal.services.GraphitiService;

public class DefaultGraphitiService implements GraphitiService {
	private final IDiagramTypeProvider dtp;
	private final IFeatureProvider fp;
	
	public DefaultGraphitiService(final IDiagramTypeProvider dtp, final IFeatureProvider fp) {
		this.dtp = Objects.requireNonNull(dtp, "dtp must not be null");
		this.fp = Objects.requireNonNull(fp, "fp must not be null");
	}
	
	@Override
	public Diagram getDiagram() {
		return dtp.getDiagram();
	}
	
	@Override
	public IDiagramTypeProvider getDiagramTypeProvider() {
		return dtp;
	}
	
	@Override
	public IFeatureProvider getFeatureProvider() {
		return fp;
	}
}
