/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
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
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.businessobjecthandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.internal.util.DiagramElementUtil;

import com.google.common.base.Strings;

/**
 * Utility class containing miscellaneous function to assist in implementing the user interface.
 *
 */
public final class UiUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private UiUtil() {
	}

	/**
	 * Returns the active workbench window
	 * @return the active workbench window. Returns null if the window could not be retrieved.
	 */
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		final IWorkbench wb = PlatformUI.getWorkbench();
		if (wb == null) {
			return null;
		}

		return wb.getActiveWorkbenchWindow();
	}

	/**
	 * Returns the active diagram editor.
	 * @return the active diagram editor. Returns null if the editor could not be retrieved or the active editor is not a diagram editor.
	 */
	public static InternalDiagramEditor getActiveDiagramEditor() {
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWindow != null) {
			final IWorkbenchPage activePage = activeWindow.getActivePage();
			if (activePage != null) {
				final IEditorPart editor = activePage.getActiveEditor();
				if (editor instanceof InternalDiagramEditor) {
					return (InternalDiagramEditor) editor;
				}
			}
		}
		return null;
	}

	/**
	 * Opens the Eclipse Properties view.
	 */
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

	/**
	 * Returns the diagram which contains all of the specified elements.
	 * @param elements the diagram elements for which to retrieve the diagram.
	 * @return the diagram which contains all of the specified elements. Returns null if the specified list is empty or the
	 * diagram elements are not all contained in the same diagram.
	 */
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
	 * Returns a user friendly description for a business object context. This method determines the appropriate business object handler
	 * and uses it to to retrieve the name.
	 * This method adds descriptive prefixes in some cases.
	 * It is advised to use other methods when working with diagram elements in order to avoid calling the business object handlers.
	 * @param boc the business object context for which to retrieve the description
	 * @param extService the extension registry
	 * @return the description of the business object context
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
			return typeName;
		}

		return prefix + baseName;
	}

	/**
	 * Returns a string which consists of the names contained in the hierarchy of the specified diagram node separated by "::"
	 * @param dn the diagram node for which to return the path label
	 * @return the path label
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

	/**
	 * Returns the icon for a business object
	 * @param bohProvider the business object handler provider for determining the business object handler to use to retrieve the icon ID
	 * @param bo the business object for which to retrieve the icon
	 * @return the business object's icon
	 */
	public static Optional<Image> getImage(final BusinessObjectHandlerProvider bohProvider, final Object bo) {
		return getImage(bohProvider.getApplicableBusinessObjectHandler(bo), bo);
	}

	/**
	 * Returns the icon for a business object
	 * @param boh the business object handler to use to retrieve the icon ID
	 * @param bo the business object for which to retrieve the icon
	 * @return the business object's icon
	 */
	public static Optional<Image> getImage(final BusinessObjectHandler boh, final Object bo) {
		if (boh == null) {
			return Optional.empty();
		}

		return boh.getIconId(new GetIconIdContext(bo)).map(Activator.getDefault().getImageRegistry()::get);
	}

	/**
	 * Calculates the offset point relative to the top left of a specified rectangle.
	 * @param rect to be offset
	 * @param xOffset the amount to offset the x coordinate
	 * @param yOffset the amount to offset the y coordinate
	 * @return the new point to place the rectangle
	 */
	public static Point getOffsetRectangleLocation(final Rectangle rect, final int xOffset, final int yOffset) {
		return new Point(rect.x + xOffset, rect.y + yOffset);
	}
}
