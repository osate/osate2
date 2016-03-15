package org.osate.ge.internal.services;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;

/**
 * Internal service for accessing graphiti objects. Ideally would transition towards exposing all needed
 * capabilities via generic services. The purpose of this is to avoid adding graphiti objects to the context and thus exposing them
 * to extensions.
 */
public interface GraphitiService {
	Diagram getDiagram();
	IDiagramTypeProvider getDiagramTypeProvider();
	IFeatureProvider getFeatureProvider();
}
