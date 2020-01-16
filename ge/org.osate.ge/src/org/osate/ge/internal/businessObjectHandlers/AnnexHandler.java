/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.FolderGraphicBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class AnnexHandler {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestors().first());
	private static final GraphicalConfiguration graphicalConfig = GraphicalConfigurationBuilder.create().
			graphic(FolderGraphicBuilder.create().build())
			.style(StyleBuilder.create().labelsCenter().build()).
			build();

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) DefaultAnnexLibrary bo) {
		return true;
	}

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) DefaultAnnexSubclause bo) {
		return true;
	}

	@CanDelete
	public boolean canDelete(final @Named(Names.BUSINESS_OBJECT) DefaultAnnexSubclause bo,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		return bo.getContainingClassifier() == queryService.getFirstBusinessObject(parentQuery, boc);
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalRepresentation() {
		return graphicalConfig;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		if (!BusinessObjectHandlerUtil.diagramSupportsPackageOrClassifiers(diagramBo)) {
			return null;
		}

		final List<PaletteEntry> entries = new ArrayList<>();
		if(diagramBo == null || diagramBo instanceof AadlPackage) {
			entries.add(PaletteEntryBuilder.create().label("Annex Library").icon(ImageHelper.getImage(getDefaultAnnexLibrary().getName())).category(Categories.MISC).context(getDefaultAnnexLibrary()).build());
		}

		entries.add(PaletteEntryBuilder.create().label("Annex Subclause").icon(ImageHelper.getImage(getDefaultAnnexSubclause().getName())).category(Categories.MISC).context(getDefaultAnnexSubclause()).build());

		return entries.toArray(new PaletteEntry[entries.size()]);
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) EObject targetBo, final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass annexType) {
		return (annexType == getDefaultAnnexLibrary() && targetBo instanceof AadlPackage) || (annexType == getDefaultAnnexSubclause() && targetBo instanceof Classifier);
	}

	/**
	 * Determine which type of Annex to create then return the new Annex
	 * @param targetContainer the element the new AnnexLibrary or AnnexSubclause will be added to
	 * @param newAnnexName the name of the new AnnexLibrary or AnnexSubclause
	 */
	@Create
	public Object createAnnex(@Named(Names.MODIFY_BO) final NamedElement owner, final @Named(Names.PALETTE_ENTRY_CONTEXT) EClass annexType, final NamingService namingService) {
		final AnnexNameDialog annexNameDialog = new AnnexNameDialog(Display.getCurrent().getActiveShell(), owner, namingService, getDialogTitleAndMessage(annexType));
		if (annexNameDialog.open() == Window.CANCEL || annexNameDialog.getValue() == null) {
			return null;
		}

		final String newAnnexName = annexNameDialog.getValue();
		return annexType == getDefaultAnnexLibrary() ? createAnnexLibrary(owner, newAnnexName) : createAnnexSubclause(owner, newAnnexName);
	}

	/**
	 * Creating the new AnnexLibrary
	 * @param neContainer the element the new AnnexSubclause is being added to
	 * @param newAnnexLibraryName the name of the new AnnexLibrary
	 * @return
	 */
	private static AnnexLibrary createAnnexLibrary(final NamedElement neContainer, final String newAnnexLibraryName) {
		final DefaultAnnexLibrary annexLibrary = (DefaultAnnexLibrary)((AadlPackage)neContainer).getPublicSection().createOwnedAnnexLibrary(getDefaultAnnexLibrary());
		annexLibrary.setSourceText("{** **}");
		annexLibrary.setName(newAnnexLibraryName);

		return annexLibrary;
	}

	/**
	 * Creating the new AnnexSubclause
	 * @param neContainer the element the new AnnexSubclause is being added to
	 * @param newAnnexSubclauseName the name of the new AnnexSubclause
	 * @return
	 */
	private static AnnexSubclause createAnnexSubclause(final NamedElement neContainer, final String newAnnexSubclauseName) {
		final DefaultAnnexSubclause annexSubclause = (DefaultAnnexSubclause)((Classifier)neContainer).createOwnedAnnexSubclause(getDefaultAnnexSubclause());
		annexSubclause.setName(newAnnexSubclauseName);
		annexSubclause.setSourceText("{** **}");

		return annexSubclause;
	}

	/**
	 * Determine title and message for input dialog
	 * @param annexType AnnexLibrary or AnnexSubclause
	 * @return the title and message for the input dialog
	 */
	private static String[] getDialogTitleAndMessage(final EClass annexType) {
		final String[] dialogTitleAndMessage = new String[2];
		if(annexType == getDefaultAnnexLibrary()) {
			dialogTitleAndMessage[0] = "Create Annex Library";
			dialogTitleAndMessage[1] = "Enter a name for the new Annex Library.";
		} else if(annexType == getDefaultAnnexSubclause()) {
			dialogTitleAndMessage[0] = "Create Annex Subclause";
			dialogTitleAndMessage[1] = "Enter a name for the new Annex Subclause.";
		} else {
			throw throwUnhandledTypeRuntimeException();
		}

		return dialogTitleAndMessage;
	}

	private static RuntimeException throwUnhandledTypeRuntimeException() {
		return new RuntimeException("Unhandled case.  Must be DefaultAnnexLibrary or DefaultAnnexSubclause.");
	}

	private static EClass getDefaultAnnexLibrary() {
		return Aadl2Factory.eINSTANCE.getAadl2Package().getDefaultAnnexLibrary();
	}

	private static EClass getDefaultAnnexSubclause() {
		return Aadl2Factory.eINSTANCE.getAadl2Package().getDefaultAnnexSubclause();
	}

	/**
	 * The dialog for naming the new AnnexLibrary or AnnexSubclause
	 */
	private static class AnnexNameDialog extends InputDialog {
		public AnnexNameDialog(final Shell parentShell, final NamedElement targetContainer, final NamingService namingService, final String[] dialogTitleAndMessage) {
			super(parentShell, dialogTitleAndMessage[0], dialogTitleAndMessage[1], "", newName -> isValidAnnexName(newName, namingService) ? "The specified name is not valid." : null);
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setMinimumSize(225, 185);
		}


		/**
		 *
		 * @param newAnnexName
		 * @param namingService
		 * @return
		 */
		final static boolean isValidAnnexName(final String newAnnexName, final NamingService namingService) {
			boolean invalid = false;
			if(!namingService.isValidIdentifier(newAnnexName)) {
				invalid = true;
			}

			return invalid;
		}
	}

	/**
	 * Create the label text
	 * @param annexName the name of the AnnexLibrary or AnnexSubclause
	 * @return the label text
	 */
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) NamedElement annex) {
		return "{**" + annex.getName() + "**}";
	}
}
