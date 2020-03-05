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
package org.osate.xtext.aadl2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.aadl2.parsesupport.LocationReference;

public class Aadl2LocationInFile extends DefaultLocationInFileProvider {

	@Override
	protected ITextRegion getTextRegion(EObject obj, boolean isSignificant) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);

		/**
		 * This is an old code that was initially removed but
		 * added again to fix some bugs.
		 * See. https://github.com/osate/osate2-ba/issues/1
		 */
		if (node == null) {
			// it may be in annex
			if (obj instanceof AObject) {
				LocationReference locref = ((AObject) obj).getLocationReference();
				if (locref != null) {
					return new TextRegion(locref.getOffset(), locref.getLength());
				} else {
					// try AnnexSource adapter
				}
			}
			if (obj.eContainer() == null) {
				return ITextRegion.EMPTY_REGION;
			}
			return getTextRegion(obj.eContainer(), isSignificant);
		}
		/**
		 * end of handling error with the behavior annex
		 */

		List<INode> nodes = null;
		if (isSignificant) {
			nodes = getLocationNodes(obj);
		}
		if (nodes == null || nodes.isEmpty()) {
			nodes = Collections.<INode> singletonList(node);
		}
		return createRegion(nodes);
	}

	public ITextRegion getSecondaryTextRegion(EObject obj, boolean typeName) {
		if (obj instanceof ModelUnit || obj instanceof Classifier) {
			ICompositeNode node = NodeModelUtils.getNode(obj);
			INode endID = node.getLastChild().getPreviousSibling();
			List<INode> nodes = null;
			while (endID instanceof HiddenLeafNode) {
				endID = endID.getPreviousSibling();
			}
			nodes = Collections.<INode> singletonList(endID);
			if (endID instanceof ICompositeNode) {
				ICompositeNode fullName = (ICompositeNode) endID;
				if (obj instanceof AadlPackage) {
					nodes = new ArrayList<INode>();
					endID = fullName.getLastChild();
					while (endID instanceof HiddenLeafNode) {
						endID = endID.getPreviousSibling();
					}
					INode id = fullName.getFirstChild();
					while (id instanceof HiddenLeafNode) {
						id = id.getNextSibling();
					}
					if (id != null) {
						nodes.add(id);
						while (id != endID) {
							id = id.getNextSibling();
							nodes.add(id);
						}
					}
				} else if (typeName) {
					endID = fullName.getFirstChild();
					while (endID instanceof HiddenLeafNode) {
						endID = endID.getNextSibling();
					}
					nodes = Collections.<INode> singletonList(endID);
				} else {
					endID = fullName.getLastChild();
					while (endID instanceof HiddenLeafNode) {
						endID = endID.getPreviousSibling();
					}
					nodes = Collections.<INode> singletonList(endID);
				}
			}
			return createRegion(nodes);
		} else {
			return null;
		}
	}

}
