package edu.uah.rsesc.aadl.age.services.impl;

import java.text.MessageFormat;

import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMultiDeleteInfo;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.UserInputService;

public class DefaultUserInputService implements UserInputService {
	private final BusinessObjectResolutionService bor;
	
	public DefaultUserInputService(final BusinessObjectResolutionService bor) {
		this.bor = bor;
	}

	@Override
	public boolean confirmDelete(final IDeleteContext context) {
		final IMultiDeleteInfo multiDeleteInfo = context.getMultiDeleteInfo();
		if(multiDeleteInfo == null) {
			final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
			if(bo == null) {
				return false;
			}
			
			final String msg = bo instanceof NamedElement ? MessageFormat.format("Are you sure you want to delete {0}?", ((NamedElement)bo).getName()) : "Are you sure you want to delete this element?";
			if(!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm Delete", msg)) {
				return false;
			}
		} else {
			if(multiDeleteInfo.isDeleteCanceled()) {
				return false;
			}
			
			if(multiDeleteInfo.isShowDialog()) {
				final String msg = MessageFormat.format("Are you sure you want to delete {0} elements?", multiDeleteInfo.getNumber());
				if(!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm Delete", msg)) {
					multiDeleteInfo.setDeleteCanceled(true);
					return false;
				}
				multiDeleteInfo.setShowDialog(false);
			}		
		}
		
		return true;
	}
}
