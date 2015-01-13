package org.osate.alisa.workbench.ui.handlers;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.alisa.workbench.ui.internal.AlisaActivator;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class AlisaTestHandler extends AadlHandler {
	private static final String RERUN_ID = "org.osate.ilca.commands.rerunIlca";
	private IHandlerActivation rerunActivation;

	@Override
	protected String getJobName() {
		return "Incremental Assurance";
	}

//
//	@Inject
//	private CompilationTestHelper.Result res;// = new CompilationTestHelper.Result();

	@Override
	protected IStatus runJob(Element root, IProgressMonitor monitor) {

		long start = System.currentTimeMillis();

		SystemInstance si;
		if (root instanceof ComponentImplementation) {
			ComponentImplementation compImpl = (ComponentImplementation) root;
			try {
				si = InstantiateModel.buildInstanceModelFile(compImpl);
			} catch (Exception e) {
				Dialog.showError("Model Instantiate", "Error while re-instantiating the model: " + e.getMessage());
				return Status.CANCEL_STATUS;
			}
		} else {
			Dialog.showError("Model Instantiate", "You must select a Component Implementation to instantiate");
			return Status.CANCEL_STATUS;
		}

		// TODO: reflectively call method

//		InstantiateCase mycase = new InstantiateCase();
//		String result = mycase.generate(si);
//		System.out.println(result);
		String className = "testresourcebudget.BudgetTest";
		String methodName = "testme";
		try {
			// see
// http://stackoverflow.com/questions/12714368/load-a-class-to-java-classpath-dynamically-using-eclipse-and-osgi

			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			String cp = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
			cp = cp + "/testresourcebudget/bin/";
			System.out.println("test=" + cp);
			ClassLoader cl2 = ClassLoader.getSystemClassLoader();

			URL[] urls = ((URLClassLoader) cl2).getURLs();

//			for (URL url : urls) {
//				System.out.println("url=" + url.getFile());
//			}

			URL mainURL = urls[0];
			File mainFile = new File(mainURL.getFile());
			File parent = new File(mainFile.getParent());
			List<String> toadd = new ArrayList<String>();
			toadd.add(cp);

			for (File f : parent.listFiles()) {
				toadd.add(f.getAbsolutePath());
				System.out.println("file=" + f.getAbsolutePath());
			}
			BundleContext ctx = AlisaActivator.getInstance().getBundle().getBundleContext();
			Bundle[] bundles = ctx.getBundles();
			for (Bundle b : bundles) {
				String loc = b.getLocation();
				if (loc.endsWith("jar")) {
					continue;
				}
				loc = loc.replaceAll("reference:file:/", "");
//				System.out.println("loc1=" + loc);
				if (loc.contains("/")) {
					loc = loc.replace('/', '\\');
				}
				loc = loc + "bin\\";
				System.out.println("loc2=" + loc);
				toadd.add(loc);

			}
			URL[] urllist = new URL[toadd.size()];
			for (int i = 0; i < toadd.size(); i++) {
				urllist[i] = new File(toadd.get(i)).toURL();
			}
			URLClassLoader urlClassLoader = new URLClassLoader(urllist, cl);
			Thread.currentThread().setContextClassLoader(urlClassLoader);
			Class c = Class.forName(className, true, urlClassLoader);
			Object o = c.newInstance();
			Method m = c.getMethod(methodName, null);
			m.invoke(o, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long stop = System.currentTimeMillis();
		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");
		System.out.println(EcoreUtil2.getURI(root));

		return Status.OK_STATUS;
	}
}
