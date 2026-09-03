/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with this program. The
 * parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries to this
 * license with respect to the terms applicable to their Third Party Software. Third Party Software licenses only apply
 * to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.errormodel.ui.refactoring;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementHandler;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.ui.internal.ErrormodelActivator;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

/**
 * Routes propagation-point renames from the AADL editor to the EMV2 refactoring services.
 */
@SuppressWarnings("restriction")
public class EmbeddedErrorModelRenameElementHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		var aadlInjector = Aadl2Activator.getInstance()
				.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		IRenameElementHandler aadlHandler = aadlInjector.getInstance(IRenameElementHandler.class);
		XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
		if (editor == null) {
			return aadlHandler.execute(event);
		}

		try {
			RefactoringPreferences preferences = aadlInjector.getInstance(RefactoringPreferences.class);
			RenameRefactoringController aadlController = aadlInjector.getInstance(RenameRefactoringController.class);
			aadlInjector.getInstance(SyncUtil.class)
					.totalSync(preferences.isSaveAllBeforeRefactoring(), aadlController.getActiveLinkedMode() == null);
			ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
			IRenameElementContext context = editor.getDocument()
					.priorityReadOnly(new IUnitOfWork<IRenameElementContext, XtextResource>() {
						@Override
						public IRenameElementContext exec(XtextResource resource) {
							var target = aadlInjector.getInstance(EObjectAtOffsetHelper.class)
									.resolveElementAt(resource, selection.getOffset());
							if (!(target instanceof PropagationPoint)) {
								return null;
							}
							return aadlInjector.getInstance(IRenameContextFactory.class)
									.createRenameElementContext(target, editor, selection, resource);
						}
					});
			if (context == null) {
				return aadlHandler.execute(event);
			}

			var errorModelInjector = ErrormodelActivator.getInstance()
					.getInjector(ErrormodelActivator.ORG_OSATE_XTEXT_AADL2_ERRORMODEL_ERRORMODEL);
			errorModelInjector.getInstance(RenameRefactoringController.class).startRefactoring(context);
			return null;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return null;
		} catch (Exception e) {
			throw new ExecutionException("Error initializing EMV2 rename refactoring", e);
		}
	}
}
