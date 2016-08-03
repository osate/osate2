package org.osate.codegen.checker.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.util.OsateDebug;
import org.osate.codegen.checker.checks.*;
import org.osate.codegen.checker.report.ErrorReport;
import org.osate.ui.utils.SelectionHelper;
import org.eclipse.jface.dialogs.MessageDialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;


class  CheckProcessor implements Consumer<ComponentInstance>
{

	@Override
	public void accept(ComponentInstance t) {
		OsateDebug.osateDebug("plop" + t);
		
	}
	
}

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CheckerHandler extends AbstractHandler {



	protected final String MARKER_TYPE = "org.osate.codegen.codegen.marker";
	
	public CheckerHandler() {
	}
	
	protected static IResource getIResource(Resource r) {
		final URI uri = r.getURI();
		final IPath path = new Path(uri.toPlatformString(true));
		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		if (resource == null) {
			throw new RuntimeException("Unable to get IResource for Resource: " + r);
		}
		return resource;
	}
	
	public static List<ErrorReport> executeCheck (SystemInstance si, Class<? extends AbstractCheck> myCheck, int kind)
	{
		
		try
		{
			AbstractCheck checkInstance = myCheck.newInstance();
			checkInstance.setKind (kind);
			checkInstance.perform(si);
			return (checkInstance.getErrors());
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window;
		int checkerkind;
		String checkKind;
		EObject selectedObject;
		SystemInstance selectedSystemInstance;
		List<ErrorReport> errors;
		
		checkerkind = AbstractCheck.CHECKER_KIND_UNKNOWN;
		checkKind = event.getParameter("org.osate.codegen.checker.kind");

		/**
		 * Get the type of check we will do. And then, pass it to the checker
		 * object.
		 */
		if (checkKind.equalsIgnoreCase("pok"))
		{
			checkerkind = AbstractCheck.CHECKER_KIND_POK;
		}
		if (checkKind.equalsIgnoreCase("vxworks"))
		{
			checkerkind = AbstractCheck.CHECKER_KIND_VXWORKS;
		}
		if (checkKind.equalsIgnoreCase("deos"))
		{
			checkerkind = AbstractCheck.CHECKER_KIND_DEOS;
		}
		
		window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		errors = new ArrayList<ErrorReport> ();
		selectedSystemInstance = null;
		
		selectedObject = SelectionHelper.getSelectedObjectinOutline();
		
		if (selectedObject instanceof SystemInstance)
		{
			selectedSystemInstance = (SystemInstance) selectedObject;
		}
		
		if (selectedObject instanceof SystemImplementation)
		{
			try {
				selectedSystemInstance = InstantiateModel.buildInstanceModelFile((SystemImplementation)selectedObject);
			} catch (Exception e) {
				e.printStackTrace();
				selectedSystemInstance = null;
			}
		}
		
		if (selectedSystemInstance == null)
		{
			MessageDialog.openError(window.getShell(), "Code Generation Checker", "Please select a system instance of system implementation");
			return null;
		}
		
		errors.addAll(executeCheck (selectedSystemInstance, MemoryCheck.class, checkerkind));
		errors.addAll(executeCheck (selectedSystemInstance, ProcessorCheck.class, checkerkind));
		errors.addAll(executeCheck (selectedSystemInstance, ProcessCheck.class, checkerkind));
		errors.addAll(executeCheck (selectedSystemInstance, ThreadCheck.class , checkerkind));
		errors.addAll(executeCheck (selectedSystemInstance, DataCheck.class, checkerkind));

		
		/**
		 * For now, we print the errors.
		 */
		for (ErrorReport e : errors)
		{
			OsateDebug.osateDebug("error " + e.getMessage() + " on " + e.getComponent().getName());
			try {
				IMarker marker = getIResource(e.getComponent().eResource()).createMarker(MARKER_TYPE);
				marker.setAttribute(IMarker.MESSAGE, e.getComponent().getName() + " - " + e.getMessage());
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
//				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}

		return null;
	}
	

}
