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
package org.osate.ge.internal.ui.navigator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.eclipse.ui.navigator.IExtensionStateModel;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.DiagramService.DiagramReference;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class DiagramNavigatorContentProvider extends WorkbenchContentProvider implements ICommonContentProvider {
	private DiagramService diagramService;
	private IExtensionStateModel stateModel;

	@Override
	public void init(ICommonContentExtensionSite aConfig) {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		diagramService = Objects.requireNonNull(context.get(DiagramService.class), "Unable to get diagram service");

		stateModel = aConfig.getExtensionStateModel();
	}

	@Override
	public void restoreState(IMemento aMemento) {
	}

	@Override
	public void saveState(IMemento aMemento) {
	}

	@Override
	public Object[] getElements(final Object inputElement) {
		return super.getElements(inputElement);
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof IProject) {
			final IProject project = (IProject) parentElement;
			final List<DiagramReference> projectDiagrams = diagramService
					.findDiagrams(Collections.singleton(project)).stream().filter(dr -> dr.isValid())
					.collect(Collectors.toList());

			final DiagramGroup projectGroup = DiagramGroup.builder(projectDiagrams, project).build();
			return getChildren(projectGroup);
		} else if (parentElement instanceof DiagramGroup) {
			final DiagramGroup parentGroup = (DiagramGroup) parentElement;

			if (isGroupByDiagramTypeEnabled() && parentGroup.getDiagramTypeId() == null) {
				return parentGroup.findMatchingDiagramReferences().map(d -> d.getDiagramTypeId()).distinct()
						.map(diagramTypeId -> DiagramGroup.builder(parentGroup).diagramType(diagramTypeId).build())
						.toArray();
			} else if (isGroupByContextEnabled() && !parentGroup.isContextReferenceValid()) {
				return parentGroup.findMatchingDiagramReferences().map(d -> d.getContextReference()).distinct()
						.map(contextRef -> DiagramGroup.builder(parentGroup).contextReference(contextRef).build())
						.toArray();
			} else {
				return parentGroup.findMatchingDiagramReferences().map(dr -> dr.getFile()).toArray();
			}
		}

		return super.getChildren(parentElement);
	}

	@Override
	public Object getParent(final Object element) {
		if (element instanceof IFile) {
			final IProject project = ((IFile) element).getProject();
			if (project == null) {
				return null;
			}

			// Determine the group which contains the diagram.
			if (isGroupByContextEnabled() || isGroupByDiagramTypeEnabled()) {
				final List<DiagramReference> projectDiagrams = diagramService
						.findDiagrams(Collections.singleton(project)).stream().filter(dr -> dr.isValid())
						.collect(Collectors.toList());
				final DiagramReference referenceDiagram = projectDiagrams.stream()
						.filter(dr -> element.equals(dr.getFile())).findAny().orElse(null);
				if (referenceDiagram == null) {
					return null;
				}


				final DiagramGroup.Builder diagramGroupBuilder = DiagramGroup.builder(projectDiagrams, project);

				if (isGroupByContextEnabled()) {
					diagramGroupBuilder.contextReference(referenceDiagram.getContextReference());
				}

				if (isGroupByDiagramTypeEnabled()) {
					diagramGroupBuilder.diagramType(referenceDiagram.getDiagramTypeId());
				}

				return diagramGroupBuilder.build();
			} else {
				return project;
			}
		} else if (element instanceof DiagramGroup) {
			final DiagramGroup dg = (DiagramGroup) element;
			if (isGroupByContextEnabled() && dg.isContextReferenceValid() && isGroupByDiagramTypeEnabled()) {
				return DiagramGroup.builder(dg).resetContextReference().build();
			} else {
				return dg.getProject();
			}
		}

		return super.getParent(element);
	}

	@Override
	public boolean hasChildren(final Object element) {
		if (element instanceof IProject) {
			final IProject project = (IProject) element;
			// Find all diagrams. Include invalid diagrams so that the diagram metadata doesn't need to be loaded. Otherwise, all diagrams in the workspace
			// would be loaded to indicate which projects have diagrams.
			return diagramService.findDiagrams(Collections.singleton(project)).size() > 0;
		}

		return getChildren(element).length > 0;
	}

	private final boolean isGroupByDiagramTypeEnabled() {
		return DiagramNavigatorProperties.getGroupByDiagramType(stateModel);
	}

	private final boolean isGroupByContextEnabled() {
		return DiagramNavigatorProperties.getGroupByDiagramContext(stateModel);
	}
}
