/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ui.propertyview;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;

class StatusColumnLabelProvider extends ColumnLabelProvider {
	private final AadlPropertyView propertyView;

	StatusColumnLabelProvider(AadlPropertyView propertyView) {
		this.propertyView = propertyView;
	}

	@Override
	public String getText(Object element) {
		var entry = (TreeEntry) element;
		if (!(entry.getTreeElement() instanceof URI propertyURI)) {
			return null;
		}
		return propertyView.safeRead(resourceSet -> {
			/*
			 * Property is matched before BasicProperty because Property is a subtype of it; a BasicProperty that is
			 * not a Property is a record field definition, which never carries a value of its own.
			 */
			PropertyStatus status = switch (resourceSet.getEObject(propertyURI, true)) {
			case Property property -> {
				var parentEntry = (TreeEntry) entry.getParent();
				yield propertyView.getPropertyStatus((URI) parentEntry.getTreeElement(), propertyURI);
			}
			case BasicPropertyAssociation basicPropertyAssociation -> propertyView.getPropertyStatusNeverUndefined(
					resourceSet, EcoreUtil2.getContainerOfType(basicPropertyAssociation, PropertyAssociation.class));
			case BasicProperty basicProperty -> PropertyStatus.UNDEFINED;
			case null, default -> null;
			};
			return status == null ? null : status.toString();
		});
	}

	@Override
	public Color getForeground(Object element) {
		var entry = (TreeEntry) element;
		if (!(entry.getTreeElement() instanceof URI propertyURI)) {
			return null;
		}
		return propertyView.safeRead(resourceSet -> {
			var treeElementEObject = resourceSet.getEObject(propertyURI, true);
			boolean undefined;
			if (treeElementEObject instanceof Property) {
				var parentEntry = (TreeEntry) entry.getParent();
				undefined = propertyView.getPropertyStatus((URI) parentEntry.getTreeElement(),
						propertyURI) == PropertyStatus.UNDEFINED;
			} else {
				/* Reaching here already implies the element is not a Property. */
				undefined = treeElementEObject instanceof BasicProperty;
			}
			return undefined ? propertyView.getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_RED) : null;
		});
	}
}
