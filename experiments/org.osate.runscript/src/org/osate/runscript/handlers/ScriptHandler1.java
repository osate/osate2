package org.osate.runscript.handlers;

import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ease.IScriptEngine;
import org.eclipse.ease.ScriptResult;
import org.eclipse.ease.service.EngineDescription;
import org.eclipse.ease.service.IScriptService;
import org.eclipse.ease.tools.ResourceTools;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ScriptHandler1 extends AbstractHandler {
	public static final String COMMAND_ID = "org.eclipse.ease.commands.script.run";
	public static final String PARAMETER_NAME = COMMAND_ID + ".name";

	@Override
	public final Object execute(final ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		String scriptURL = "platform:/plugin/org.osate.runscript/scripts/modelstatistics1.py";
		try {
			// execute script
			// script gets instance model from current selection in the AADL Navigator
			// returns an integer as the result
			Object result = runPythonScript(scriptURL);
			String message = "Statistics for instance model\n\n";
			message += "Component Instances: " + result;

			MessageDialog.openInformation(window.getShell(), "Model Statistics", message);
		} catch (ExecutionException e) {
			MessageDialog.openInformation(window.getShell(), "Model Statistics", "Exception during script execution");
			throw e;
		}
		return null;
	}

	Object runPythonScript(String scriptURL) throws ExecutionException {
		try {
			final URL url = new URL(scriptURL);
			// find script engine
			EngineDescription engineDescription = null;

			// locate engine by ID
			final IScriptService scriptService = PlatformUI.getWorkbench().getService(IScriptService.class);
			engineDescription = scriptService.getEngineByID("org.eclipse.ease.lang.python.py4j.engine");

			if (engineDescription != null) {
				// create engine
				final IScriptEngine engine = engineDescription.createEngine();
				// we can pass an array of strings to python
				String[] argv = new String[] { "modelstatistics.py" };
				engine.setVariable("argv", argv);

				// url can have many forms, e.g. remote, workspace, project, file, plugin, string
				Object scriptObject = ResourceTools.resolve(url);
				if (scriptObject == null) {
					// not sure what exactly this would do
					// no file available, try to include to resolve URIs
					scriptObject = "include(\"" + url + "\")";
				}

				// we want to get a result back so it must be sync (internally async and waits until done)
				final ScriptResult scriptResult = engine.executeSync(scriptObject);

				if (scriptResult.hasException()) {
					scriptResult.getException().printStackTrace(System.err);
					return -1;
				}

				final Object result = scriptResult.getResult();

				if (result != null) {
					if (ScriptResult.VOID.equals(result)) {
						return 0;
					}

					try {
						return Integer.parseInt(result.toString());
					} catch (final Exception e) {
						// no integer
					}

					try {
						return new Double(Double.parseDouble(result.toString())).intValue();
					} catch (final Exception e) {
						// no double
					}

					try {
						return Boolean.parseBoolean(result.toString()) ? 0 : -1;
					} catch (final Exception e) {
						// no boolean
					}

					// we do not know the return type, but typically parseBoolean() will deal with anything you throw at it
				} else {
					return 0;
				}
			}
		} catch (Exception e) {
			throw new ExecutionException("exception during script execution", e);
		}
		return null;
	}

}
