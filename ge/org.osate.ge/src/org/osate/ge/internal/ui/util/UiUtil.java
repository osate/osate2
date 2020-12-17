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
package org.osate.ge.internal.ui.util;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.StringUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.GetIconIdContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.internal.businessobjecthandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.DiagramElementUtil;

import com.google.common.base.Strings;

public class UiUtil {
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		final IWorkbench wb = PlatformUI.getWorkbench();
		if (wb == null) {
			return null;
		}

		return wb.getActiveWorkbenchWindow();
	}

	public static AgeDiagramEditor getActiveDiagramEditor() {
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWindow != null) {
			final IWorkbenchPage activePage = activeWindow.getActivePage();
			if (activePage != null) {
				final IEditorPart editor = activePage.getActiveEditor();
				if (editor instanceof AgeDiagramEditor) {
					return (AgeDiagramEditor) editor;
				}
			}
		}
		return null;
	}

	public static void openPropertiesView() {
		final IWorkbenchWindow win = getActiveWorkbenchWindow();
		if (win == null) {
			return;
		}

		final IWorkbenchPage page = win.getActivePage();
		if (page == null) {
			return;
		}

		try {
			page.showView(IPageLayout.ID_PROP_SHEET);
		} catch (final PartInitException e) {
			throw new RuntimeException(e);
		}
	}

	public static AgeDiagram getDiagram(final List<DiagramElement> elements) {
		if (elements.size() == 0) {
			return null;
		}

		final AgeDiagram firstDiagram = DiagramElementUtil.getDiagram(elements.get(0));
		if (!elements.stream().allMatch(e -> DiagramElementUtil.getDiagram(e) == firstDiagram)) {
			return null;
		}

		return firstDiagram;
	}

	/**
	 * Returns a label for a business object context. This method determines the appropriate business object handler and uses it to to retrieve the name.
	 * This method adds descriptive prefixes in some cases.
	 * It is advised to use other methods when working with DiagramElements in order to avoid calling the business object handlers.
	 * @param boc
	 * @param extService
	 * @param bocHelper
	 * @return
	 */
	public static String getDescription(final BusinessObjectContext boc, final ExtensionRegistryService extService) {
		// Build a prefix based on the business object type
		final Object bo = boc.getBusinessObject();
		final String prefix;
		if (bo instanceof EObject) {
			prefix = StringUtil.camelCaseToUser(((EObject) bo).eClass().getName()) + " ";
		} else {
			prefix = "";
		}

		// Call the business object handler's GetName method
		String baseName;
		if(bo instanceof BusinessObjectProxy) {
			baseName = ((BusinessObjectProxy) bo).getName();
		} else {
			final BusinessObjectHandler boh = extService.getApplicableBusinessObjectHandler(bo);
			if (boh == null) {
				baseName = null;
			} else {
				baseName = boh.getName(new GetNameContext(bo));
			}
		}

		if (Strings.isNullOrEmpty(baseName)) {
			final String typeName = StringUtil.camelCaseToUser(
					bo instanceof EObject ? ((EObject) bo).eClass().getName() : bo.getClass().getName());
			return "<Unnamed " + typeName + ">";
		}

		return prefix + baseName;
	}

	/**
	 * Returns a string which consists of the names contained in the hierarchy of the specified queryable separated by "::"
	 * @param q
	 * @return
	 */
	public static String getPathLabel(final DiagramNode dn) {
		if (dn instanceof DiagramElement) {
			final String parentPath = getPathLabel(dn.getParent());
			final String name = ((DiagramElement) dn).getLabelName();
			if (name == null || name.isEmpty()) {
				return parentPath;
			} else if (parentPath.isEmpty()) {
				return name;
			} else {
				return parentPath + "::" + name;
			}
		} else {
			return "";
		}
	}

	public static Optional<Image> getImage(final BusinessObjectHandlerProvider bohProvider, final Object bo) {
		return getImage(bohProvider.getApplicableBusinessObjectHandler(bo), bo);
	}

	public static Optional<Image> getImage(final BusinessObjectHandler boh, final Object bo) {
		if (boh == null) {
			return Optional.empty();
		}

		return boh.getIconId(new GetIconIdContext(bo)).map(imageId -> {
			return GraphitiUi.getImageService().getImageForId(AgeDiagramTypeProvider.id, imageId);
		}).filter(img -> {
			final ImageData imageData = img.getImageData();

			// If the icon is below a certain size, assume it is the default icon that is used when the image can't be loaded and ignore it.
			return imageData != null && imageData.width >= 10;
		});
	}
}
