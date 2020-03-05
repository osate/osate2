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
package org.osate.ge.gef.parts;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.fx.utils.NodeUtils;
import org.eclipse.gef.geometry.planar.Dimension;
import org.eclipse.gef.mvc.fx.parts.AbstractContentPart;
import org.eclipse.gef.mvc.fx.parts.IResizableContentPart;
import org.eclipse.gef.mvc.fx.parts.ITransformableContentPart;
import org.eclipse.gef.mvc.fx.parts.IVisualPart;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.osate.ge.gef.nodes.AgeShapeNode;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

import javafx.scene.Node;
import javafx.scene.transform.Affine;

public class AgeShapeContentPart extends AbstractContentPart<AgeShapeNode>
		implements IResizableContentPart<AgeShapeNode>, ITransformableContentPart<AgeShapeNode> {

	@Override
	protected SetMultimap<? extends Object, String> doGetContentAnchorages() {
		final SetMultimap<Object, String> anchorages = HashMultimap.create();
		return anchorages;
	}

	// TODO: When to clean this out?
	private final Set<Object> removedElements = new HashSet<>();

	@Override
	protected List<? extends Object> doGetContentChildren() {
		// TODO: Can this list be unmodifiable?
//		if (removedElements.size() > 0) {
//			// TODO: Better implementation that don't include removing from an array list
//			final List<Object> test = new ArrayList<>(getContent().children);
//			test.removeAll(removedElements);
//			return test;
//		}
//
//		return getContent().children;

		return Collections.emptyList();
	}

	// TODO: Part of hack to allow removing content elements without actually editing the elements collection.
	// TODO: Decide How to handle. Connections need this capability too, but need ability to switch between connection and shape <->
	@Override
	protected void doAddContentChild(Object contentChild, int index) {
		removedElements.remove(contentChild);
	}

	@Override
	protected void doRemoveContentChild(Object contentChild) {
		System.err.println("REMOVED CONTENT CHILD");
		removedElements.add(contentChild);
		// TODO: Need to remove from this eventually
	}

	@Override
	protected AgeShapeNode doCreateVisual() {
		return new AgeShapeNode();
	}

	@Override
	protected void doAddChildVisual(IVisualPart<? extends Node> child, int index) {
		// TODO
		// getVisual().addInnerChild(child.getVisual());
	}

	@Override
	protected void doRemoveChildVisual(IVisualPart<? extends Node> child, int index) {
		// TODO
		// getVisual().removeInnerChild(child.getVisual());
	}

	@Override
	protected void register(IViewer viewer) {
		// TODO Auto-generated method stub
		super.register(viewer);
	}

	@Override
	protected void doRefreshVisual(final AgeShapeNode visual) {
		setVisualTransform(getContentTransform());
		setVisualSize(getContentSize());
	}

	@Override
	public void setVisualSize(final Dimension totalSize) {
		getVisual().setPreferredShapeSize(totalSize.width, totalSize.height);
	}

	@Override
	public Dimension getContentSize() {
		// TODO: Have conversion functions
		final DiagramElement element = getContent();
		return new Dimension(element.getWidth(), element.getHeight());
	}

	@Override
	public void setContentSize(final Dimension totalSize) {
		final DiagramElement element = getContent();
		final AgeDiagram diagram = getDiagram(element);
		// TODO: Need conversion function for org.osate.ge.internal.diagram.runtime.Dimension
		diagram.modify("Resize",
				m -> m.setSize(element, new org.osate.ge.graphics.Dimension(totalSize.width, totalSize.height)));
	}

	@Override
	public DiagramElement getContent() {
		return (DiagramElement) super.getContent();
	}

	@Override
	public Affine getContentTransform() {
		// TODO: Conversion function
		final DiagramElement de = getContent();
		return new Affine(1, 0, de.getX(), 0.0, 1.0, de.getY());
	}

	@Override
	public void setContentTransform(final Affine totalTransform) {
		final DiagramElement element = getContent();
		final AgeDiagram diagram = getDiagram(element);
		// TODO: Only translation is supported via setContentTransform()
		// TODO: Need conversion function for org.osate.ge.internal.diagram.runtime.Dimension
		diagram.modify("Move", m -> m.setPosition(element, new Point(totalTransform.getTx(), totalTransform.getTy())));

		// TODO: Need to adjust more than just this transform. Need to adjust all affected positions.
	}

	@Override
	public void setVisualTransform(Affine totalTransform) {
		NodeUtils.setAffine(getAdapter(TRANSFORM_PROVIDER_KEY).get(), totalTransform);
		getVisual().requestLayout();
	}

	// TODO: Move/Rework. Need quicker way to get diagram or current modification...
	private static AgeDiagram getDiagram(final DiagramElement de) {
		for (DiagramNode dn = de; dn != null; dn = dn.getParent()) {
			if (dn instanceof AgeDiagram) {
				return (AgeDiagram) dn;
			}
		}
		return null;
	}
}
