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

package org.osate.reqtrace

import java.io.File
import java.util.ArrayList
import java.util.List
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text
import org.eclipse.xtend.lib.annotations.Accessors

import static extension org.eclipse.jface.dialogs.DialogSettings.getOrCreateSection

class RequirementsReportConfigDialog extends TitleAreaDialog {
	val static OUTPUT_FILE_SETTING = "OUTPUT_FILE_SETTING"
	val static OPEN_FILE_SETTING = "OPEN_FILE_SETTING"
	
	val dialogSettings = Activator.^default.dialogSettings.getOrCreateSection(class.name)
	val List<String> formats
	val List<String> formatDescriptions
	Text outputFileText
	Button openFileButton
	
	@Accessors(PACKAGE_GETTER)
	String outputFile
	@Accessors(PACKAGE_GETTER)
	boolean openFileAutomatically
	
	new(Shell parent, List<String> formats) {
		super(parent)
		this.formats = formats
		formatDescriptions = new ArrayList(formats.map[switch it {
			case "docx": "Word Document"
			case "pptx": "PowerPoint Presentation"
			case "xlsx": "Excel Workbook"
			case "odt": "ODF Text Document"
			case "odp": "ODF Presentation"
			case "ods": "ODF Spreadsheet"
			case "html": "Web Page"
			case "pdf": "PDF"
		}])
	}
	
	override protected isResizable() {
		true
	}
	
	override isHelpAvailable() {
		false
	}
	
	override protected getInitialSize() {
		new Point(convertHorizontalDLUsToPixels(300), super.initialSize.y)
	}
	
	override protected getDialogBoundsSettings() {
		dialogSettings
	}
	
	override protected configureShell(Shell newShell) {
		super.configureShell(newShell)
		newShell.text = "Requirements Report"
	}
	
	override create() {
		super.create
		title = "Requirements Report"
		validateOutputFile
	}
	
	override protected createDialogArea(Composite parent) {
		super.createDialogArea(parent) as Composite => [
			initializeDialogUnits
			new Composite(it, SWT.NONE) => [
				layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
				layout = new GridLayout(3, false)
				new Label(it, SWT.NONE) => [
					text = "Output File:"
					layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false)
				]
				outputFileText = new Text(it, SWT.SINGLE.bitwiseOr(SWT.LEFT).bitwiseOr(SWT.BORDER)) => [
					text = dialogSettings.get(OUTPUT_FILE_SETTING) ?: ""
					layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
					addModifyListener[validateOutputFile]
				]
				new Button(it, SWT.PUSH) => [
					text = "Browse..."
					layoutData = new GridData(SWT.RIGHT, SWT.CENTER, false, false)
					addSelectionListener(new SelectionAdapter {
						override widgetSelected(SelectionEvent e) {
							val dialog = new FileDialog(shell, SWT.SAVE.bitwiseOr(SWT.SHEET))
							dialog.filterExtensions = formats.map["*." + it]
							dialog.filterNames = formatDescriptions
							dialog.text = "Output File"
							val selectedFileName = dialog.open
							if (selectedFileName !== null) {
								outputFileText.text = selectedFileName
								validateOutputFile
							}
						}
					})
				]
			]
			openFileButton = new Button(it, SWT.CHECK) => [
				text = "Open Generated Report"
				layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false)
				val preference = dialogSettings.get(OPEN_FILE_SETTING)
				selection = preference === null || Boolean.parseBoolean(preference)
			]
		]
	}
	
	override protected okPressed() {
		outputFile = outputFileText.text.trim
		openFileAutomatically = openFileButton.selection
		dialogSettings.put(OUTPUT_FILE_SETTING, outputFile)
		dialogSettings.put(OPEN_FILE_SETTING, openFileAutomatically)
		super.okPressed
	}
	
	def private validateOutputFile() {
		errorMessage = switch outputFile : outputFileText.text.trim {
			case outputFile.empty: "Missing Output File"
			default: switch dotLocation : outputFile.lastIndexOf(".") {
				case -1,
				case outputFile.length - 1: "No Format in Specified Output File"
				default: switch fileExt : outputFile.substring(dotLocation + 1) {
					case fileExt.indexOf(File.separator) != -1: "No Format in Specified Output File"
					case !formats.contains(fileExt): '''Invalid Format: "«fileExt»"'''
				}
			}
		}
		getButton(IDialogConstants.OK_ID).enabled = errorMessage === null
	}
}