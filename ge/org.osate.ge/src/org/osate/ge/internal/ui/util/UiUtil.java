package org.osate.ge.internal.ui.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorPart;
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
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.model.Tag;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.BusinessObjectContextHelper;
import org.osate.ge.internal.util.DiagramElementUtil;
import org.osate.ge.internal.util.StringUtil;

public class UiUtil {
	public static String AUTOMATED_SWTBOT_TESTING_KEY = "org.eclipse.swtbot.widget.key";

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
	public static String getDescription(final BusinessObjectContext boc, final ExtensionService extService,
			final BusinessObjectContextHelper bocHelper) {
		// Build a prefix based on the business object type
		final Object bo = boc.getBusinessObject();
		final String prefix;
		if (bo instanceof EObject) {
			prefix = StringUtil.camelCaseToUser(((EObject) bo).eClass().getName()) + " ";
		} else if (bo instanceof BusinessObjectProxy) {
			prefix = StringUtil.camelCaseToUser(((BusinessObjectProxy) bo).getEClass().getName()) + " ";
		} else if (bo instanceof Tag) {
			prefix = "Misc ";
		} else {
			prefix = "";
		}

		// Call the business object handler's GetName method
		String baseName;
		if(bo instanceof BusinessObjectProxy) {
			baseName = ((BusinessObjectProxy) bo).getName();
		} else {
			final Object boh = extService.getApplicableBusinessObjectHandler(bo);
			if (boh == null) {
				baseName = null;
			} else {
				baseName = bocHelper.getNameForUserInterface(boc, boh);
			}
		}

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
			final String name = ((DiagramElement) dn).getLabelName();
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

	/**
	 * Sets the ID used to reference the widgets during unit tests.
	 * @param w
	 * @param id
	 */
	public static void setTestingId(final Widget w, final String id) {
		w.setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY, id);
	}
}
