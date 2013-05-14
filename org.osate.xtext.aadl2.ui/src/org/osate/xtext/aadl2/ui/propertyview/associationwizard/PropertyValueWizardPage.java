package org.osate.xtext.aadl2.ui.propertyview.associationwizard;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.xtext.aadl2.parser.antlr.Aadl2Parser;
import org.osate.xtext.aadl2.ui.MyAadl2Activator;
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant.AbstractAssistant;
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant.AssistantFactory;
import org.osate.xtext.aadl2.ui.propertyview.associationwizard.assistant.AssistantValueChangedListener;

public class PropertyValueWizardPage extends AbstractPropertyValueWizardPage {
	private final IXtextDocument xtextDocument;
	private final LogInternalErrorReporter internalErrorLogger;
	private final NamedElement holder;
	private final ISerializer serializer;
	private final Aadl2Parser aadl2Parser;
	private final ILinker linker;
	private Property definition = null;
	private PropertyExpression propertyExpression = null;
	
	private Label typeLabel = null;
	private Button useAssistant = null;
	private Group assistantGroup = null;
	private Button enterTextualValue = null;
	private Group valueTextFieldGroup = null;
	private Label valueLabel = null;
	private Text value = null;
	private Button assign = null;
	private Button append = null;
	private Button constant = null;
	
	private AbstractAssistant assistant = null;
	
	public PropertyValueWizardPage(IXtextDocument xtextDocument, NamedElement holder, ISerializer serializer, Aadl2Parser aadl2Parser, ILinker linker) {
		super("Property Value Wizard Page");
		this.xtextDocument = xtextDocument;
		this.holder = holder;
		this.serializer = serializer;
		this.aadl2Parser = aadl2Parser;
		this.linker = linker;
		internalErrorLogger = new LogInternalErrorReporter(MyAadl2Activator.getInstance().getBundle());
		setPageComplete(false);
	}
	
	@Override
	public PropertyExpression getPropertyExpression() {
		return propertyExpression;
	}
	
	@Override
	public boolean isAppendSelected() {
		return append.getSelection();
	}
	
	@Override
	public boolean isConstantSelected() {
		return constant.getSelection();
	}
	
	@Override
	protected void setDefinitionImpl(Property definition) {
		this.definition = definition;
		typeLabel.setText("Enter value with the type " + AssociationWizardUtil.unparse(serializer, definition.getPropertyType()));
		if (definition.isList()) {
			assign.setEnabled(true);
			append.setEnabled(true);
		}
		else {
			assign.setSelection(true);
			append.setSelection(false);
			assign.setEnabled(false);
			append.setEnabled(false);
		}
		if (assistantGroup.getChildren().length == 1)
			assistantGroup.getChildren()[0].dispose();
		AssistantValueChangedListener listener = new AssistantValueChangedListener() {
			@Override
			public void assistantValueChanged() {
				updatePageComplete();
			}
		};
//		if (definition.isList())
//			assistant = new ListAssistant(assistantGroup, definition.getPropertyType(), holder, listener);
//		else
			assistant = AssistantFactory.getAssistantForType(assistantGroup, definition.getPropertyType(), serializer, holder, listener);
		if (assistant != null) {
			useAssistant.setEnabled(true);
			enterTextualValue.setEnabled(true);
			assistant.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			/* true - enterTextualValue
			 * false - useAssistant
			 * DialogSettings.getBoolean() returns false if no value has been set.  The default case is to use the assistant.
			 */
			if (MyAadl2Activator.getInstance().getDialogSettings().getBoolean(assistant.getClass().getName())) {
				enterTextualValue.setSelection(true);
				useAssistant.setSelection(false);
			}
			else {
				useAssistant.setSelection(true);
				enterTextualValue.setSelection(false);
			}
		}
		else {
			useAssistant.setSelection(false);
			enterTextualValue.setSelection(true);
			useAssistant.setEnabled(false);
			enterTextualValue.setEnabled(false);
		}
		updateAssistantAndValueFieldEnabled();
		updatePageComplete();
		getShell().layout(true, true);
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		typeLabel = new Label(composite, SWT.WRAP);
		typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		useAssistant = new Button(composite, SWT.RADIO);
		useAssistant.setText("Use Ass&istant");
		useAssistant.setSelection(true);
		useAssistant.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		assistantGroup = new Group(composite, SWT.NONE);
		assistantGroup.setText("Assistant");
		assistantGroup.setLayout(new GridLayout(1, false));
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		layoutData.horizontalIndent = 20;
		layoutData.widthHint = 900;
		layoutData.heightHint = 300;
		assistantGroup.setLayoutData(layoutData);
		
		enterTextualValue = new Button(composite, SWT.RADIO);
		enterTextualValue.setText("&Enter Value as Text (This behaves as if the property were being typed into a .aadl file)");
		enterTextualValue.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		valueTextFieldGroup = new Group(composite, SWT.NONE);
		valueTextFieldGroup.setText("Textual Entry");
		valueTextFieldGroup.setLayout(new GridLayout(2, false));
		layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		layoutData.horizontalIndent = 20;
		valueTextFieldGroup.setLayoutData(layoutData);
		
		valueLabel = new Label(valueTextFieldGroup, SWT.NONE);
		valueLabel.setText("&Value in AADL syntax:");
		valueLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		value = new Text(valueTextFieldGroup, SWT.BORDER);
		value.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Composite buttonComposite = new Composite(composite, SWT.NONE);
		buttonComposite.setLayout(new GridLayout(3, false));
		buttonComposite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		assign = new Button(buttonComposite, SWT.RADIO);
		assign.setText("A&ssign =>");
		assign.setSelection(true);
		assign.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		append = new Button(buttonComposite, SWT.RADIO);
		append.setText("A&ppend +=>");
		append.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		constant = new Button(buttonComposite, SWT.CHECK);
		constant.setText("&Constant");
		constant.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		addListeners();
		
		setControl(composite);
	}
	
	public void recordDialogSettings() {
		/* true - enterTextualValue
		 * false - useAssistant
		 */
		if (assistant != null)
			MyAadl2Activator.getInstance().getDialogSettings().put(assistant.getClass().getName(), enterTextualValue.getSelection());
	}
	
	private void addListeners() {
		value.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updatePageComplete();
			}
		});
		useAssistant.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateAssistantAndValueFieldEnabled();
				updatePageComplete();
			}
		});
		enterTextualValue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateAssistantAndValueFieldEnabled();
				updatePageComplete();
			}
		});
	}
	
	private void updatePageComplete() {
		if (useAssistant.getSelection()) {
			if (assistant.isComplete())
				attemptToParseValueText(assistant.getValueText());
			else {
				setErrorMessage(null);
				setPageComplete(false);
			}
		}
		else
			attemptToParseValueText(value.getText());
	}
	
	//TODO: Deal with instance model
	private void attemptToParseValueText(String valueText) {
		if (valueText == null || valueText.isEmpty()) {
			setErrorMessage(null);
			setPageComplete(false);
			return;
		}
		final IParseResult parseResult = aadl2Parser.parse(aadl2Parser.getGrammarAccess().getPropertyExpressionRule(), new StringReader(valueText));
		if (parseResult.hasSyntaxErrors()) {
			setErrorMessage(parseResult.getSyntaxErrors().iterator().next().getSyntaxErrorMessage().getMessage());
			setPageComplete(false);
		}
		else {
			if (xtextDocument != null) {
				xtextDocument.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						attachToModelAndRunLinker((PropertyExpression)parseResult.getRootASTElement());
					}
				});
			}
			else {
				attachToModelAndRunLinker((PropertyExpression)parseResult.getRootASTElement());
			}
		}
	}
	
	private void attachToModelAndRunLinker(PropertyExpression propertyExpression) {
		PropertyAssociation parsedAssociation = holder.createOwnedPropertyAssociation();
		parsedAssociation.setProperty(definition);
		parsedAssociation.createOwnedValue().setOwnedValue(propertyExpression);
		
		boolean addedWithClause = false;
		PropertySet propertySet = (PropertySet)definition.getElementRoot();
		EList<ModelUnit> importedUnits = null;
		if (!AadlUtil.isImportedPropertySet(propertySet, holder)) {
			addedWithClause = true;
			Namespace context = AadlUtil.getContainingTopLevelNamespace(holder);
			if (context instanceof PropertySet)
				importedUnits = ((PropertySet)context).getImportedUnits();
			else
				importedUnits = ((PackageSection)context).getImportedUnits();
			importedUnits.add(propertySet);
		}
		
		ListBasedDiagnosticConsumer diagnosticsConsumer = new ListBasedDiagnosticConsumer();
		linker.linkModel(propertyExpression, diagnosticsConsumer);
		List<Diagnostic> diagnostics = diagnosticsConsumer.getResult(Severity.ERROR);
		if (!diagnostics.isEmpty()) {
			setErrorMessage(diagnostics.get(0).getMessage());
			setPageComplete(false);
		}
		else {
			ArrayList<Resource.Diagnostic> errorsBeforeProxyResolution = new ArrayList<Resource.Diagnostic>(holder.eResource().getErrors());
			EcoreUtil.resolveAll(propertyExpression);
			ArrayList<Resource.Diagnostic> errorsAfterProxyResolution = new ArrayList<Resource.Diagnostic>(holder.eResource().getErrors());
			errorsAfterProxyResolution.removeAll(errorsBeforeProxyResolution);
			if (!errorsAfterProxyResolution.isEmpty()) {
				setErrorMessage(errorsAfterProxyResolution.get(0).getMessage());
				setPageComplete(false);
			}
			else {
				org.eclipse.emf.common.util.Diagnostic validatorDiagnostic = Diagnostician.INSTANCE.validate(parsedAssociation);
				if (validatorDiagnostic.getSeverity() == org.eclipse.emf.common.util.Diagnostic.ERROR) {
					setErrorMessage(validatorDiagnostic.getChildren().get(0).getMessage());
					setPageComplete(false);
				}
				else {
					this.propertyExpression = propertyExpression;
					setErrorMessage(null);
					setPageComplete(true);
				}
			}
		}
		if (addedWithClause)
			importedUnits.remove(propertySet);
		holder.getOwnedPropertyAssociations().remove(parsedAssociation);
	}
	
	private void updateAssistantAndValueFieldEnabled() {
		if (useAssistant.getSelection()) {
			assistantGroup.setEnabled(true);
			assistant.setAssistantEnabled(true);
			valueTextFieldGroup.setEnabled(false);
			valueLabel.setEnabled(false);
			value.setEnabled(false);
		}
		else {
			assistantGroup.setEnabled(false);
			if (assistant != null)
				assistant.setAssistantEnabled(false);
			valueTextFieldGroup.setEnabled(true);
			valueLabel.setEnabled(true);
			value.setEnabled(true);
		}
	}
}