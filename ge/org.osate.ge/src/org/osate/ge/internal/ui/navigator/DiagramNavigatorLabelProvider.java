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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.ui.navigator.IExtensionStateModel;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.types.DiagramTypeProvider;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.DiagramService.DiagramReference;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ReferenceLabelService;
import org.osate.ge.internal.services.ReferenceService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.io.Files;

public class DiagramNavigatorLabelProvider extends DecoratingLabelProvider
implements org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider,
ICommonLabelProvider {
	private final DiagramService diagramService;
	private final DiagramTypeProvider dtProvider;
	private final ReferenceLabelService referenceLabelService;
	private IExtensionStateModel stateModel;
	private final Styler annotationStyler = new Styler() {
		@Override
		public void applyStyles(TextStyle textStyle) {
			textStyle.foreground = Display.getDefault().getSystemColor(SWT.COLOR_DARK_YELLOW);
		}
	};

	public DiagramNavigatorLabelProvider() {
		super(new WorkbenchLabelProvider(), null);

		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		diagramService = Objects.requireNonNull(context.get(DiagramService.class), "Unable to get diagram service");
		dtProvider = Objects.requireNonNull(context.get(ExtensionRegistryService.class),
				"Unable to get extension registry");
		referenceLabelService = Objects.requireNonNull(context.get(ReferenceService.class),
				"Unable to get reference service");
	}

	@Override
	public void init(ICommonContentExtensionSite aConfig) {
		stateModel = aConfig.getExtensionStateModel();
	}

	@Override
	public void restoreState(IMemento aMemento) {
	}

	@Override
	public void saveState(IMemento aMemento) {
	}

	@Override
	public String getDescription(Object anElement) {
		return null;
	}

	@Override
	public String getText(final Object element) {
		if (element instanceof DiagramGroup) {
			final DiagramGroup dg = (DiagramGroup) element;
			if (dg.isContextReferenceValid()) {
				if (dg.getContextReference() == null) {
					return "<No Context>";
				} else {
					final String contextLabel = referenceLabelService.getLabel(dg.getContextReference(),
							dg.getProject());
					return contextLabel == null ? "Unrecognized Context: " + dg.getContextReference() : contextLabel;
				}
			} else if (dg.getDiagramTypeId() != null) {
				final Optional<DiagramType> dtOpt = dtProvider.getDiagramTypeById(dg.getDiagramTypeId());
				return dtOpt.map(dt -> dt.getPluralName())
						.orElseGet(() -> "Unrecognized Diagram Type : " + dg.getDiagramTypeId());
			} else {
				throw new RuntimeException("Unexpected case. Diagram type and context reference are both null");
			}
		} else if (element instanceof IFile) {
			return Files.getNameWithoutExtension(diagramService.getName(((IFile) element)));
		}

		return super.getText(element);
	}

	@Override
	public StyledString getStyledText(Object element) {
		if (element instanceof DiagramGroup) {
			return new StyledString(getText(element));
		} else if (element instanceof IFile) {
			final IFile file = (IFile) element;

			final IProject project = file.getProject();
			if (project != null) {
				final Optional<DiagramReference> optDiagramRef = diagramService
						.findDiagrams(Collections.singleton(project)).stream()
						.filter(dr -> dr.isValid() && file.equals(dr.getFile())).findAny();
				if (optDiagramRef.isPresent()) {
					final DiagramReference diagramRef = optDiagramRef.get();
					final StyledString diagramLabel = new StyledString(getText(diagramRef.getFile()));

					// Handle diagram type and context annotations
					if (DiagramNavigatorProperties.getShowAnnotations(stateModel)) {
						// Context
						List<String> annotations = new ArrayList<>();
						if (!DiagramNavigatorProperties.getGroupByDiagramContext(stateModel)) {
							final String contextLabel;

							// Don't use the label from the label service if the reference is null.
							if (diagramRef.getContextReference() == null) {
								contextLabel = "<No Context>";
							} else {
								contextLabel = referenceLabelService.getLabel(diagramRef.getContextReference(),
										project);
							}
							if (contextLabel != null) {
								annotations.add(contextLabel);
							}
						}

						// Diagram Type
						if (!DiagramNavigatorProperties.getGroupByDiagramType(stateModel)) {
							dtProvider.getDiagramTypeById(diagramRef.getDiagramTypeId())
							.ifPresent(dt -> annotations.add(dt.getName()));
						}

						// Build label based on annotations
						if (annotations.size() > 0) {
							diagramLabel.append(" [" + annotations.stream().collect(Collectors.joining("; ")) + "]",
									annotationStyler);
						}

					}

					return diagramLabel;
				}
			}
		}

		return ((WorkbenchLabelProvider) getLabelProvider()).getStyledText(element);
	}

	@Override
	public Image getImage(final Object element) {
		final ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		if (element instanceof DiagramGroup) {
			return images.getImage(ISharedImages.IMG_OBJ_FOLDER);
		}
		return super.getImage(element);
	}
}
