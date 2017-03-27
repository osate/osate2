package org.osate.ge.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTree;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTreeFactory;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTreeNode;
import org.osate.ge.internal.diagram.DiagramUpdater.DiagramElementInfoProvider;

public class TestBusinessObjectModel implements BusinessObjectTreeFactory, DiagramElementInfoProvider {
	public TestBusinessObject model;
		
	// BusinessObjectTreeFactory
	@Override
	public BusinessObjectTree createBusinessObjectTree(DiagramConfiguration configuration) {
		final BusinessObjectTree tree = new BusinessObjectTree() {
			@Override
			public Collection<BusinessObjectTreeNode> getRootNodes() {
				return createNodeList(model);
			}
		};
		
		return tree;
	}
	
	private List<BusinessObjectTreeNode> createNodeList(final TestBusinessObject bo) {
		final List<BusinessObjectTreeNode> result = new ArrayList<>();
		for(final TestBusinessObject child : bo.children) {
			result.add(new BusinessObjectTreeNode() {
				@Override
				public Object getBusinessObject() {
					return child;
				}

				@Override
				public Collection<BusinessObjectTreeNode> getChildren() {
					return createNodeList(child);
				}

				@Override
				public RelativeBusinessObjectReference getRelativeReference() {
					return child.getRelativeReference();
				}
				
				@Override
				public CanonicalBusinessObjectReference getCanonicalReference() {
					return child.getCanonicalReference();
				}
				
				@Override
				public String getName() {
					return "BO: " + child.getRelativeReference().toString();
				}
			});
		}

		return result;
	}
	
	// DiagramElementInfoProvider
	@Override
	public Graphic getGraphic(final AgeDiagramElement element) {
		final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
		if(testBo.isConnection) {
			return ConnectionBuilder.create().build();
		} else {
			return RectangleBuilder.create().build();
		}
	}
	
	@Override
	public DockingPosition getDefaultDockingPosition(final AgeDiagramElement element) {
		final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
		return testBo.defaultDockingPosition;
	}
	
	@Override
	public AgeDiagramElement getConnectionStart(final AgeDiagramElement e) {
		final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
		return bo.connectionStartReference == null ? null : e.getContainer().getByRelativeReference(bo.connectionStartReference);
	}

	@Override
	public AgeDiagramElement getConnectionEnd(final AgeDiagramElement e) {
		final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
		return bo.connectionEndReference == null ? null : e.getContainer().getByRelativeReference(bo.connectionEndReference);
	}

	@Override
	public AgeLabelConfiguration getDefaultLabelConfiguration(AgeDiagramElement element) {
		return model.labelConfiguration;
	}
}
