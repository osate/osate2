package org.osate.ui.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

/**
 * AaxlModifyHandler defines an action framework for processing Aadl object model
 * with modifications.
 */
public abstract class AbstractInstanceOrDeclarativeModelModifyHandler
		extends AbstractInstanceOrDeclarativeModelReadOnlyHandler {
	/**
	 * Override to wrap the execution of the action so that changes to the
	 * resource are tracked and the resource is saved afterwards if it has
	 * been changed.
	 */
	/*
	 * This is identical to what we do in AaxlModifyActionAsJob. The
	 * extension hierarchy is getting a big out of control, but that is the
	 * price we pay for not break existing code.
	 */
	@Override
	final void processAaxlAction(final IProgressMonitor monitor, final Resource resource, final Element root) {
		boolean prev = resource.isTrackingModification();
		// turn on modification tracking since we may make changes
		resource.setTrackingModification(true);
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
		// We execute this command on the command stack because otherwise, we will not
		// have write permissions on the editing domain.
		Command cmd = new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doAaxlAction(monitor, root);
				if (resource.isModified()) {
					OsateResourceUtil.save(resource);
				}
			}

		};

		try {
			((TransactionalCommandStack) domain.getCommandStack()).execute(cmd, null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resource.setTrackingModification(prev);
	}
}