package org.osate.pluginsupport;

import java.net.URL;

import org.eclipse.ease.IScriptEngine;
import org.eclipse.ease.ScriptResult;
import org.eclipse.ease.service.EngineDescription;
import org.eclipse.ease.service.IScriptService;
import org.eclipse.ease.tools.ResourceTools;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PlatformUI;
import org.osate.result.util.ResultUtil;

public class ExecutePythonUtil {

	public Object runPythonScript(String scriptURL, Object[] argv) {
		try {
			scriptURL = scriptURL.replaceAll("\\.", "/") + ".py";
			final URL url = new URL(scriptURL);
			// find script engine
			EngineDescription engineDescription = null;

			// locate engine by ID
			final IScriptService scriptService = PlatformUI.getWorkbench().getService(IScriptService.class);
			engineDescription = scriptService.getEngineByID("org.eclipse.ease.lang.python.py4j.engine");

			if (engineDescription != null) {
				// create engine
				final IScriptEngine engine = engineDescription.createEngine();
				// we can pass an array of objects to python
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
					Throwable e = scriptResult.getException();
					return ResultUtil.createErrorResult(
							"Python script '" + scriptURL + "' result exception: " + e.getMessage(),
							(EObject) argv[0]);
				}

				final Object result = scriptResult.getResult();
				return result;
			}
		} catch (Exception e) {
			return ResultUtil.createErrorResult(
					"Python script '" + scriptURL + "' execution exception: " + e.getMessage(),
					(EObject) argv[0]);
		}
		return null;
	}

}
