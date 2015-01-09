package org.osate.alisa.common.ui.handlers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.junit.runner.JUnitCore;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.ui.dialogs.Dialog;
import org.osate.units.test.TestMe;
import org.osate.units.test.Watchpersontest;

import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.analysis.views.AssuranceCaseView;

public class AlisaHandler extends AadlHandler {
	private static final String RERUN_ID = "org.osate.alisa.common.analysis.commands.rerunTestjunit";
	private IHandlerActivation rerunActivation;

	@Override
	protected String getJobName() {
		return "Alisa Analysis";
	}

	@Override
	protected IStatus runJob(Element root, IProgressMonitor monitor) {
		clearProofs();
		String theorem;

		theorem = this.getExecutionEvent().getParameter("com.rockwellcollins.atc.resolute.analysis.theorem");

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
		long stop = System.currentTimeMillis();
		System.out.println("Instantiation time: " + (stop - start) / 1000.0 + "s");

		JUnitCore jUnitCore = new JUnitCore();
		jUnitCore.run(Watchpersontest.class);

		start = System.currentTimeMillis();
		Class clazz = TestMe.class;
		Method method;
		try {
			Method[] ml = clazz.getDeclaredMethods();
			for (Method method2 : ml) {
				System.out.println(method2.getName());
			}
			method = clazz.getMethod("printme");
			TestMe t = new TestMe();
			Object o = method.invoke(t);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompilationTestHelper.Result res = new CompilationTestHelper.Result();
		Object cll = res.getCompiledClasses();
		Object cl = res.getCompiledClass("BudgetTest");
		stop = System.currentTimeMillis();
		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");
		System.out.println(EcoreUtil2.getURI(root));

		return Status.OK_STATUS;
	}

	private IHandlerService getHandlerService() {
		return (IHandlerService) getWindow().getService(IHandlerService.class);
	}

	private void enableRerunHandler(final Element root) {
		getWindow().getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				IHandlerService handlerService = getHandlerService();
				rerunActivation = handlerService.activateHandler(RERUN_ID, new AlisaRerunHandler(root,
						AlisaHandler.this));
			}
		});
	}

	private void disableRerunHandler() {
		if (rerunActivation != null) {
			getWindow().getShell().getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					IHandlerService handlerService = getHandlerService();
					handlerService.deactivateHandler(rerunActivation);
					rerunActivation = null;
				}
			});
		}
	}

	private void drawProofs(final List<ResoluteResult> proofTrees) {
		final IWorkbenchPage page = getWindow().getActivePage();

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				displayView(proofTrees, page);
			}
		});
	}

	private void displayView(final List<ResoluteResult> proofTrees, final IWorkbenchPage page) {
		try {
//			AlisaView view = (AlisaView) page.showView(AlisaView.ID);
			AssuranceCaseView view = (AssuranceCaseView) page.showView(AssuranceCaseView.ID);
			view.setProofs(proofTrees);
			view.setFocus();
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	protected void clearProofs() {
		drawProofs(Collections.<ResoluteResult> emptyList());
	}
}
