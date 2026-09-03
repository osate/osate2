/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, ANY WARRANTY OF FITNESS FOR PURPOSE
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
 * conditions contained in any such separate license file distributed with such Third Party Software. The parties who
 * own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries to this license with
 * respect to the terms applicable to such Third Party Software. Third Party Software licenses only apply to the Third
 * Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ide.refactoring;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.util.Aadl2LocationInFile;

import com.google.inject.Inject;

/**
 * Applies serializer-based renames to AADL named elements. AADL uses its own string data type for
 * names, and component implementation names also contain the realized component type name.
 */
public class Aadl2IdeRenameStrategy extends IRenameStrategy2.DefaultImpl {
	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Override
	protected EAttribute getNameEAttribute(EObject target) {
		if (target instanceof NamedElement) {
			return Aadl2Package.eINSTANCE.getNamedElement_Name();
		}
		return super.getNameEAttribute(target);
	}

	@Override
	protected void doRename(EObject target, RenameChange change, RenameContext context) {
		var effectiveChange = change;
		replaceSecondaryName(context, target, !(target instanceof ComponentImplementation), change.getNewName());
		if (target instanceof ComponentImplementation implementation && !change.getNewName().contains(".")) {
			var type = implementation.getType();
			if (type != null) {
				effectiveChange = new RenameChange(type.getName() + "." + change.getNewName(), change.getTargetURI());
			}
		} else if (target instanceof ComponentType type) {
			var pkg = EcoreUtil2.getContainerOfType(type, AadlPackage.class);
			if (pkg != null) {
				EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class)
						.stream()
						.filter(implementation -> implementation.getType() == type)
						.forEach(implementation -> {
							replaceSecondaryName(context, implementation, true, change.getNewName());
							implementation.setName(change.getNewName() + "." + implementation.getImplementationName());
						});
			}
		}
		super.doRename(target, effectiveChange, context);
	}

	private void replaceSecondaryName(RenameContext context, EObject target, boolean typeName, String newName) {
		var region = ((Aadl2LocationInFile) locationInFileProvider).getSecondaryTextRegion(target, typeName);
		if (region == null) {
			return;
		}
		var document = context.getChangeSerializer().getModifiableDocument(target.eResource());
		if (document == null) {
			return;
		}
		var objectRegion = document.getOriginalTextRegionAccess().regionForEObject(target);
		if (objectRegion == null) {
			return;
		}
		for (ISemanticRegion semanticRegion : objectRegion.getAllSemanticRegions()) {
			if (semanticRegion.getOffset() <= region.getOffset()
					&& semanticRegion.getEndOffset() >= region.getOffset() + region.getLength()) {
				var relativeOffset = region.getOffset() - semanticRegion.getOffset();
				var text = semanticRegion.getText();
				var replacement = text.substring(0, relativeOffset) + newName
						+ text.substring(relativeOffset + region.getLength());
				document.replace(semanticRegion, replacement);
				return;
			}
		}
	}
}
