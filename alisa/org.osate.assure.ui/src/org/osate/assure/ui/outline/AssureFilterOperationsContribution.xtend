package org.osate.assure.ui.outline

import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution
import com.google.inject.Inject
import org.eclipse.xtext.ui.PluginImageHelper
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.osate.assure.assure.AssurePackage
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.action.Action
import java.util.EventObject
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.ecore.EObject
import org.osate.assure.assure.ClaimResult

class AssureFilterOperationsContribution extends AbstractFilterOutlineContribution {

 val static String PREFERENCE_KEY =
"ui.outline.filterOperations";
 
@Inject
PluginImageHelper imageHelper;

EObject modelObject= null;
def void setModelObject(EObject eo)
{
    modelObject= eo;
}
def EObject getModelObject()
{
    return modelObject;
}

override boolean apply(IOutlineNode node) {
	val nn = node as EObjectNode
	val boolean result = false
	val res = nn.readOnly(
                        new IUnitOfWork<IStatus, EObject>() {
                            override IStatus exec(EObject eobj) throws Exception {
                                if (eobj instanceof ClaimResult) {
                                	modelObject = eobj
                                	return Status.OK_STATUS
//                                    return runJob((Element) eobj, monitor);
                                } else {
                                    return Status.CANCEL_STATUS;
                                }
                            }
                        });
return !(node instanceof EObjectNode)
|| !( (node as EObjectNode).getEClass()
.equals(AssurePackage.eINSTANCE.claimResult));
}
// XXX how to get the EObject to filter based on semantic object content
// EObject node gives us the URI or the EObject but only via a resource
// AadlHandler deals with resource 
override String getPreferenceKey() {
return PREFERENCE_KEY;
}
 
override void configureAction(Action action) {
action.setText("Hide TBDs");
action.setDescription("Hide TBDs");
action.setToolTipText("Hide TBDs");
action.setImageDescriptor(getImageDescriptor());
}
 
def ImageDescriptor getImageDescriptor() {
return ImageDescriptor.createFromImage(
imageHelper.getImage("Operation.gif"));
}
 
}