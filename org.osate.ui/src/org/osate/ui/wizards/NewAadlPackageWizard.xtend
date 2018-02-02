package org.osate.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import java.util.Map
import org.eclipse.xtext.parser.IParser
import org.osate.ui.OsateUiPlugin
import org.osate.workspace.WorkspacePlugin
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button

class NewAadlPackageWizard extends AbstractNewFileWizard {
	val PACKAGE_LABEL = "AADL package name"
	
	@Inject IParser parser
	@Inject Aadl2GrammarAccess grammarAccess
	
	private Button textButton;
	private Button graphicalButton;
	
	new() {
		super("AADL Package", "AADL package", "aadl", 1, OsateUiPlugin.^default.log, OsateUiPlugin.PLUGIN_ID)
		MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this)
		addField(PACKAGE_LABEL, [fieldValue | fieldValue.matches("\\S+") &&
			!parser.parse(grammarAccess.PNAMERule, new StringReader(fieldValue)).hasSyntaxErrors
		])
	}
	
	override addLocalControls(Composite parent) {
		new Label(parent, SWT.NONE) => [label |
			label.text = "Open with"
			label.layoutData = new GridData(SWT.END, SWT.TOP, false, false)
		]
		
		new Composite(parent, SWT.NONE) => [radios |
			radios.layout = new GridLayout(1, false)
			
			textButton = new Button(radios, SWT.RADIO.bitwiseOr(SWT.LEFT)) => [button |
				button.layoutData = new GridData(SWT.BEGINNING, SWT.TOP, false, false)
				button.setText("Text Editor")
			]
			graphicalButton = new Button(radios, SWT.RADIO.bitwiseOr(SWT.LEFT)) => [button |
				button.layoutData = new GridData(SWT.BEGINNING, SWT.TOP, false, false)
				button.setText("Graphical Editor")
			]
			textButton.setSelection(true)
			graphicalButton.setSelection(false)
		]
	}
	
	override fileContents(Map<String, String> fieldValues) {
		val packageName = fieldValues.get(PACKAGE_LABEL)
		'''
			package «packageName»
			public
				
			end «packageName»;'''
	}
	
	override protected getFileName(String enteredName) {
		super.getFileName(enteredName).replaceAll(WorkspacePlugin.AADL_PACKAGE_SEPARATOR,
			WorkspacePlugin.FILE_PACKAGE_SEPARATOR
		)
	}
}