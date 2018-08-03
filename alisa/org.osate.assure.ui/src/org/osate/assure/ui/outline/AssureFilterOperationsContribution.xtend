/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.ui.outline

import com.google.inject.Inject
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.action.Action
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.xtext.ui.PluginImageHelper
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.osate.assure.assure.AssurePackage
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