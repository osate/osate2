package org.osate.xtext.aadl2.ui.propertyview.associationwizard;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.DefaultTextEditComposer;
import org.eclipse.xtext.ui.editor.model.edit.ReconcilingUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.parser.antlr.Aadl2Parser;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.commands.CreatePropertyAssociationCommand;

/**
 * Used by <code>AadlPropertyView</code> to allow the user to create or modify a
 * <code>PropertyAssociation</code>.  Passing a <code>PropertyAssociation</code> object
 * to a constructor will modify the association; all other constructors will create a
 * new <code>PropertyAssociation</code>.  All information used to create or modify the
 * association is gathered from the user using the widgets of this wizard's pages, but
 * the fields can be pre-selected for user convenience.  Use the different
 * constructors to pre-select the fields.
 * 
 * @author jseibel
 *
 */
public class PropertyAssociationWizard extends Wizard {
	private final URI holderuri;
	private final boolean shouldDisplayModeChooserWizardPage;
	private final IXtextDocument xtextDocument;
	private CommandStack commandStack;
	private final ISerializer serializer;
	private final Aadl2Parser aadl2Parser;
	private final ILinker linker;
	
	private PropertyDefinitionWizardPage propertyDefinitionWizardPage = null;
	private PropertyValueWizardPage propertyValueWizardPage = null;
//	private InstanceReferenceValueWizardPage instanceReferenceValueWizardPage = null;
//	private ListOfInstanceReferenceValueWizardPage listOfInstanceReferenceValueWizardPage = null;
	private ModeChooserWizardPage modeChooserWizardPage = null;
	
	/**
	 * Creates a new wizard without pre-selecting any fields.  This will create a new
	 * <code>PropertyAssociation</code>.
	 * 
	 * @param commandStack The command stack of the editor.
	 * @param holderURI The <code>NamedElement</code> that will contain the new
	 * 				<code>PropertyAssociation</code>.
	 */
	public PropertyAssociationWizard(IXtextDocument xtextDocument, CommandStack commandStack, URI holderURI, ISerializer serializer, Aadl2Parser aadl2Parser, ILinker linker) {
		this.xtextDocument = xtextDocument;
		this.commandStack = commandStack;
		this.holderuri = holderURI;
		this.serializer = serializer;
		this.aadl2Parser = aadl2Parser;
		this.linker = linker;
		setWindowTitle("New Property Association");
		EList<? extends Mode> modes = ModeChooserWizardPage.getModesForHolder(getHolder());
		shouldDisplayModeChooserWizardPage = modes != null && modes.size() > 0;
	}
	
	private class AddPropertyUnitOfWork extends IUnitOfWork.Void<XtextResource>
	{
		private final AbstractPropertyValueWizardPage activePropertyValueWizardPage;
		
		public AddPropertyUnitOfWork(AbstractPropertyValueWizardPage activePropertyValueWizardPage)
		{
			this.activePropertyValueWizardPage = activePropertyValueWizardPage;
		}
		
		@Override
		public void process(XtextResource state) throws Exception
		{
			final NamedElement holder = (NamedElement)state.getResourceSet().getEObject(holderuri, true);
			PropertyAssociation newAssociation = holder.createOwnedPropertyAssociation();
			newAssociation.setProperty(propertyDefinitionWizardPage.getSelectedDefinition());
			ModalPropertyValue mpv = newAssociation.createOwnedValue();
			mpv.setOwnedValue(activePropertyValueWizardPage.getPropertyExpression());
			if (modeChooserWizardPage.getSelectedModes() != null) {
				mpv.getInModes().addAll(modeChooserWizardPage.getSelectedModes());
			}
			newAssociation.setAppend(activePropertyValueWizardPage.isAppendSelected());
			newAssociation.setConstant(activePropertyValueWizardPage.isConstantSelected());
			PropertySet propertySet = (PropertySet)propertyDefinitionWizardPage.getSelectedDefinition().getElementRoot();
			if (!AadlUtil.isImportedPropertySet(propertySet, holder)) {
				Namespace context = AadlUtil.getContainingTopLevelNamespace(holder);
				if (context instanceof PropertySet)
					((PropertySet)context).getImportedUnits().add(propertySet);
				else
					((PackageSection)context).getImportedUnits().add(propertySet);
			}
		}
	}
	
	@Override
	public boolean performFinish() {
		AbstractPropertyValueWizardPage activePropertyValueWizardPage = getActivePropertyValueWizardPage();
		if (xtextDocument != null) {
			if (xtextDocument instanceof XtextDocument)
			{
				TextEditComposerWithoutValidationOnSave composer = new TextEditComposerWithoutValidationOnSave();
				OsateCorePlugin.getDefault().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(composer);
				ReconcilingUnitOfWork<Object> reconcilingUnitOfWork = new ReconcilingUnitOfWork<Object>(
						new AddPropertyUnitOfWork(activePropertyValueWizardPage), xtextDocument, composer);
				((XtextDocument) xtextDocument).internalModify(reconcilingUnitOfWork);
			}
			else
			{
				xtextDocument.modify(new AddPropertyUnitOfWork(activePropertyValueWizardPage));
			}
		}
		else {
			final NamedElement holder = getHolder();
			// If the command stack is null, a new temporary editing domain will be created to edit the resource
			TransactionalEditingDomain createdEditingDomain = null;
			if (commandStack == null) {
				createdEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
				commandStack = createdEditingDomain.getCommandStack();
			}
			
			CreatePropertyAssociationCommand command;
			if (shouldDisplayModeChooserWizardPage && modeChooserWizardPage.getSelectedModes().size() > 0) {
				command = new CreatePropertyAssociationCommand(holder, propertyDefinitionWizardPage.getSelectedDefinition(), activePropertyValueWizardPage.getPropertyExpression(),
						modeChooserWizardPage.getSelectedModes());
			}
			else
				command = new CreatePropertyAssociationCommand(holder, propertyDefinitionWizardPage.getSelectedDefinition(), activePropertyValueWizardPage.getPropertyExpression());
			commandStack.execute(command);
			PropertyAssociation newAssociation = command.getNewAssociation();
			newAssociation.setAppend(activePropertyValueWizardPage.isAppendSelected());
			newAssociation.setConstant(activePropertyValueWizardPage.isConstantSelected());
			
			// Dispose of the editing domain if it was created to execute this command
			if (createdEditingDomain != null) {
				createdEditingDomain.dispose();
				commandStack = null;
			}
			
			// Save the resource
			OsateResourceUtil.save(holder.eResource());
		}
		if (activePropertyValueWizardPage instanceof PropertyValueWizardPage)
			propertyValueWizardPage.recordDialogSettings();
		return true;
	}
	
	private NamedElement getHolder() {
		NamedElement aobj = null;
		if (holderuri != null) {
			aobj = (NamedElement)OsateResourceUtil.getResourceSet().getEObject(holderuri, true);
		}
		return aobj;
	}
	
	@Override
	public boolean canFinish() {
		if (propertyDefinitionWizardPage.isPageComplete())
			return getActivePropertyValueWizardPage().isPageComplete();
		else
			return false;
	}
	
	@Override
	public void addPages() {
		NamedElement holder = getHolder();
		propertyDefinitionWizardPage = new PropertyDefinitionWizardPage(holder, serializer, new PropertyDefinitionSelectionChangedListener() {
			@Override
			public void propertyDefinitionSelectionChanged() {
				getActivePropertyValueWizardPage().setDefinition(propertyDefinitionWizardPage.getSelectedDefinition());
				
				//This method might be called while the initial values are being set.  At that point, it doesn't make sense to call updateButtons().
				if (getContainer().getCurrentPage() != null)
					getContainer().updateButtons();
			}
		});
		addPage(propertyDefinitionWizardPage);
		propertyValueWizardPage = new PropertyValueWizardPage(xtextDocument, holder, serializer, aadl2Parser, linker);
		addPage(propertyValueWizardPage);
//		instanceReferenceValueWizardPage = new InstanceReferenceValueWizardPage(holder);
//		addPage(instanceReferenceValueWizardPage);
//		listOfInstanceReferenceValueWizardPage = new ListOfInstanceReferenceValueWizardPage(holder);
//		addPage(listOfInstanceReferenceValueWizardPage);
		modeChooserWizardPage = new ModeChooserWizardPage(holder);
		addPage(modeChooserWizardPage);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page.equals(propertyDefinitionWizardPage))
			return getActivePropertyValueWizardPage();
		else if (page instanceof AbstractPropertyValueWizardPage) {
			if (shouldDisplayModeChooserWizardPage)
				return modeChooserWizardPage;
			else
				return null;
		}
		else
			return null;
	}
	
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		if (page instanceof AbstractPropertyValueWizardPage)
			return propertyDefinitionWizardPage;
		else if (page.equals(modeChooserWizardPage))
			return getActivePropertyValueWizardPage();
		else
			return null;
	}
	
	//TODO: Consider nested lists.
	private AbstractPropertyValueWizardPage getActivePropertyValueWizardPage() {
		NamedElement holder = getHolder();
//		if (holder instanceof InstanceObject && propertyDefinitionWizardPage.getSelectedDefinition().getPropertyType() instanceof ReferenceType) {
//			if (propertyDefinitionWizardPage.getSelectedDefinition().isList())
//				return listOfInstanceReferenceValueWizardPage;
//			else
//				return instanceReferenceValueWizardPage;
//		}
//		else
			return propertyValueWizardPage;
	}
	
	private static class TextEditComposerWithoutValidationOnSave extends DefaultTextEditComposer
	{
		@Override
		protected SaveOptions getSaveOptions()
		{
			return SaveOptions.newBuilder().noValidation().getOptions();
		}
	}
}