package org.osate.ge.internal.ui.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.model.Tag;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.util.BusinessObjectContextHelper;
import org.osate.ge.internal.util.DiagamElementUtil;
import org.osate.ge.internal.util.StringUtil;

public class UiUtil {
	public static void openPropertiesView() {
		final IWorkbench wb = PlatformUI.getWorkbench();
		if (wb == null) {
			return;
		}

		final IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
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

		final AgeDiagram firstDiagram = DiagamElementUtil.getDiagram(elements.get(0));
		if (!elements.stream().allMatch(e -> DiagamElementUtil.getDiagram(e) == firstDiagram)) {
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
	public static String getDescription(final BusinessObjectContext boc, final ExtensionService extService,
			final BusinessObjectContextHelper bocHelper) {
		// Build a prefix based on the business object type
		final Object bo = boc.getBusinessObject();
		final String prefix;
		if (bo instanceof EObject) {
			prefix = StringUtil.camelCaseToUser(((EObject) bo).eClass().getName()) + " ";
		} else if (bo instanceof Tag) {
			prefix = "Misc ";
		} else {
			prefix = "";
		}

		// Call the business object handler's GetName method
		final Object boh = extService.getApplicableBusinessObjectHandler(bo);

		String baseName = boh == null ? null : bocHelper.getName(boc, boh);
		if (baseName == null) {
			if (bo instanceof NamedElement) {
				baseName = ((NamedElement) bo).getName();
			}

			if (baseName == null) {
				final String typeName = StringUtil.camelCaseToUser(
						bo instanceof EObject ? ((EObject) bo).eClass().getName() : bo.getClass().getName());
				return "<Unnamed " + typeName + ">";
			} else {
				return baseName;
			}
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
			final String name = ((DiagramElement) dn).getName();
			if (name.isEmpty()) {
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
}
