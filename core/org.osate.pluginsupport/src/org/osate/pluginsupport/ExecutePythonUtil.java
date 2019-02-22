package org.osate.pluginsupport;

import org.osate.result.util.ResultUtil;

public class ExecutePythonUtil {

	public Object runPythonScript(String scriptPath, Object[] argv) {
		return ResultUtil.createErrorResult("Python script '" + scriptPath + "' execution not supported", null);
//		try {
//			scriptPath = scriptPath.replaceAll("\\.", "/") + ".py";
//			final URL scriptUrl = new URL(scriptPath);
//			// find script engine
//			EngineDescription engineDescription = null;
//
//			// locate engine by ID
//			final IScriptService scriptService = PlatformUI.getWorkbench().getService(IScriptService.class);
//			engineDescription = scriptService.getEngineByID("org.eclipse.ease.lang.python.py4j.engine");
//
//			if (engineDescription != null) {
//				// create engine
//				final IScriptEngine engine = engineDescription.createEngine();
//				// we can pass an array of objects to python
//				engine.setVariable("argv", argv);
//
//				// url can have many forms, e.g. remote, workspace, project, file, plugin, string
//				Object scriptObject = ResourceTools.resolve(scriptUrl);
//				if (scriptObject == null) {
//					// not sure what exactly this would do
//					// no file available, try to include to resolve URIs
//					scriptObject = "include(\"" + scriptUrl + "\")";
//				}
//
//				// we want to get a result back so it must be sync (internally async and waits until done)
//				final ScriptResult scriptResult = engine.executeSync(scriptObject);
//
//				if (scriptResult.hasException()) {
//					Throwable e = scriptResult.getException();
//					return ResultUtil.createErrorResult(
//							"Python script '" + scriptPath + "' result exception: " + e.getMessage(),
//							null);
//				}
//
//				final Object result = scriptResult.getResult();
//				return result;
//			}
//		} catch (Exception e) {
//			return ResultUtil.createErrorResult(
//					"Python script '" + scriptPath + "' execution exception: " + e.getMessage(),
//					null);
//		}
//		return null;
	}

}
