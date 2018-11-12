package org.osate.ge.tests;

import java.util.UUID;

import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.updating.DiagramElementInformationProvider;

import com.google.common.collect.ImmutableSet;

public class TestBusinessObjectModel implements DiagramElementInformationProvider, TreeUpdater {
	public TestBusinessObject model;

	@Override
	public BusinessObjectNode expandTree(DiagramConfiguration configuration, BusinessObjectNode tree) {
		final BusinessObjectNode newTree = new BusinessObjectNode(null, UUID.randomUUID(), null, null, false,
				ImmutableSet.of(), Completeness.UNKNOWN);
		createNodes(newTree, model.children);
		return newTree;
	}

	private void createNodes(final BusinessObjectNode parent, final TestBusinessObject[] bos) {
		for(final TestBusinessObject bo : bos) {
			final BusinessObjectNode newNode = new BusinessObjectNode(parent, UUID.randomUUID(),
					bo.getRelativeReference(),
					bo, true, ImmutableSet.of(), Completeness.UNKNOWN);
			createNodes(newNode, bo.children);
		}
	}

	// DiagramElementInfoProvider
	@Override
	public String getLabelName(final DiagramElement element) {
		return "ELEMENT: " + element.getRelativeReference().toString();
	}

	@Override
	public String getUserInterfaceName(final DiagramElement element) {
		return "ELEMENT-UI: " + element.getRelativeReference().toString();
	}

	@Override
	public AgeGraphicalConfiguration getGraphicalConfiguration(final DiagramElement element) {
		return (AgeGraphicalConfiguration)GraphicalConfigurationBuilder.create().
			graphic(getGraphic(element)).
			defaultDockingPosition(getDefaultDockingPosition(element)).
			source(getConnectionStart(element)).
			destination(getConnectionEnd(element)).
			build();
	}

	private Graphic getGraphic(final DiagramElement element) {
		final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
		if(testBo.isConnection) {
			return ConnectionBuilder.create().build();
		} else {
			return RectangleBuilder.create().build();
		}
	}

	private DockingPosition getDefaultDockingPosition(final DiagramElement element) {
		final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
		return testBo.defaultDockingPosition;
	}

	private DiagramElement getConnectionStart(final DiagramElement e) {
		final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
		return bo.connectionStartReference == null ? null : e.getContainer().getByRelativeReference(bo.connectionStartReference);
	}

	private DiagramElement getConnectionEnd(final DiagramElement e) {
		final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
		return bo.connectionEndReference == null ? null : e.getContainer().getByRelativeReference(bo.connectionEndReference);
	}

	@Override
	public Object getApplicableBusinessObjectHandler(final Object bo) {
		return new Object(); // Return a dummy object
	}
}
