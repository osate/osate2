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
package org.osate.ge.internal.ui.dialogs;

import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.types.CustomDiagramType;
import org.osate.ge.internal.diagram.runtime.types.DiagramTypeProvider;
import org.osate.ge.internal.diagram.runtime.types.PackageDiagramType;
import org.osate.ge.internal.diagram.runtime.types.StructureDiagramType;

import com.google.common.collect.ImmutableCollection;

public class DefaultCreateDiagramModel implements CreateDiagramDialog.Model<DiagramType> {
	private final DiagramTypeProvider diagramTypeProvider;
	private final IProject project;
	private final Object contextBo;

	public DefaultCreateDiagramModel(final DiagramTypeProvider diagramTypeProvider, final IProject project,
			final Object contextBo) {
		this.diagramTypeProvider = Objects.requireNonNull(diagramTypeProvider, "diagramTypeProvider must nto be null");
		this.project = project;
		this.contextBo = contextBo;
	}

	@Override
	public ImmutableCollection<DiagramType> getDiagramTypes() {
		return diagramTypeProvider.getApplicableDiagramTypes(contextBo);
	}

	@Override
	public String getDiagramTypeName(DiagramType diagramType) {
		return diagramType.getName();
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public String getDefaultName() {
		if (contextBo instanceof NamedElement) {
			return ((NamedElement) contextBo).getQualifiedName().replaceAll("::|:|\\.", "_");
		} else {
			return null;
		}
	}

	@Override
	public DiagramType getDefaultDiagramType() {
		if (contextBo == null) {
			return diagramTypeProvider.getDiagramTypeById(CustomDiagramType.ID).orElse(null);
		} else if (contextBo instanceof AadlPackage) {
			return diagramTypeProvider.getDiagramTypeById(PackageDiagramType.ID).orElse(null);
		} else if (contextBo instanceof Classifier || contextBo instanceof SystemInstance) {
			return diagramTypeProvider.getDiagramTypeById(StructureDiagramType.ID).orElse(null);
		} else {
			return null;
		}
	}
}
