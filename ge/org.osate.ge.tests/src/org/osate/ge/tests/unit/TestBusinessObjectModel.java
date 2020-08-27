/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.tests.unit;

import java.util.UUID;

import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.botree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.botree.Completeness;
import org.osate.ge.internal.diagram.runtime.botree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.updating.DiagramElementInformationProvider;
import org.osate.ge.services.ReferenceBuilderService;
import org.osate.ge.services.ReferenceResolutionService;

public class TestBusinessObjectModel
		implements DiagramElementInformationProvider, TreeUpdater, ReferenceResolutionService, ReferenceBuilderService {
	private TestBusinessObject model;

	@Override
	public BusinessObjectNode expandTree(DiagramConfiguration configuration, BusinessObjectNode tree) {
		final BusinessObjectNode newTree = new BusinessObjectNode(null, UUID.randomUUID(), null, null,
				Completeness.UNKNOWN, true);
		createNodes(newTree, getModel().children);
		return newTree;
	}

	private void createNodes(final BusinessObjectNode parent, final TestBusinessObject[] bos) {
		for(final TestBusinessObject bo : bos) {
			final BusinessObjectNode newNode = new BusinessObjectNode(parent, UUID.randomUUID(),
					bo.getRelativeReference(),
					bo, Completeness.UNKNOWN, true);
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
	public GraphicalConfiguration getGraphicalConfiguration(final DiagramElement element) {
		return GraphicalConfigurationBuilder.create()
				.
			graphic(getGraphic(element)).
			defaultDockingPosition(getDefaultDockingPosition(element)).
			source(getConnectionStart(element)).
			destination(getConnectionEnd(element)).
			build();
	}

	private Graphic getGraphic(final DiagramElement element) {
		final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
		if(testBo.isConnection()) {
			return ConnectionBuilder.create().build();
		} else {
			return RectangleBuilder.create().build();
		}
	}

	private DockingPosition getDefaultDockingPosition(final DiagramElement element) {
		final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
		return testBo.getDefaultDockingPosition();
	}

	private DiagramElement getConnectionStart(final DiagramElement e) {
		final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
		return bo.getConnectionStartReference() == null ? null : e.getContainer().getByRelativeReference(bo.getConnectionStartReference());
	}

	private DiagramElement getConnectionEnd(final DiagramElement e) {
		final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
		return bo.getConnectionEndReference() == null ? null : e.getContainer().getByRelativeReference(bo.getConnectionEndReference());
	}

	@Override
	public BusinessObjectHandler getApplicableBusinessObjectHandler(final Object bo) {
		return new StubBusinessObjectHandler();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final Object bo) {
		return ((TestBusinessObject) bo).getCanonicalReference();
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final Object bo) {
		return ((TestBusinessObject) bo).getRelativeReference();
	}

	@Override
	public Object resolve(final CanonicalBusinessObjectReference reference) {
		return getModel().find(reference);
	}

	public TestBusinessObject getModel() {
		return model;
	}

	public void setModel(TestBusinessObject model) {
		this.model = model;
	}
}
