package org.osate.ge.internal.graphiti.diagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;

public class GraphitiAgeDiagram {
	public final static String AADL_DIAGRAM_TYPE_ID = "AADL Diagram";
	
	private final AgeDiagram ageDiagram;
	private final Diagram graphitiDiagram;
	private final List<DiagramElement> elements;
	
	/**
	 * GraphitiAgeDiagram constructor. Keeps and internal copy of the specified AgeDiagram.
	 * @param ageDiagram
	 */
	public GraphitiAgeDiagram(final AgeDiagram ageDiagram) {
		this.ageDiagram = new AgeDiagram(Objects.requireNonNull(ageDiagram, "ageDiagram must not be null"));
		this.graphitiDiagram = Graphiti.getPeService().createDiagram(AADL_DIAGRAM_TYPE_ID, "Untitled Diagram", true); // TODO: Diagram title
		this.elements = new ArrayList<>();
		
		// TODO: Initialize the age graphiti elements based on the AgeDiagram. How are those kept in sync? 
		// Internal copy. Nothing touches the AgeDiagram without going through this class.
		
		// First Step... Initialize the graphiti elements based on the AgeDiagram elements? Or should it update based on the BO providers?
	}
}
