/**
 * <copyright>
 * Copyright 2016 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text
import org.eclipse.xtend.lib.annotations.Accessors

import static org.osate.reqtrace.ReqTraceConfigDialog.*

import static extension org.eclipse.jface.dialogs.DialogSettings.getOrCreateSection

class ReqTraceConfigDialog extends TitleAreaDialog {
	val public static String G2S = "goal2stakeholders"
	val public static String R2G = "requirement2goals"
	val static OUTPUT_FILE_SETTING = "OUTPUT_FILE_SETTING"
	val static REPORT_TYPE_SETTING = "REPORT_TYPE_SETTING"
	val static OPEN_FILE_SETTING = "OPEN_FILE_SETTING"
	
	val dialogSettings = Activator.^default.dialogSettings.getOrCreateSection(class.name)
	val List<String> formats
	val List<String> formatDescriptions
	val String fileType
	Button g2sButton
	Button r2gButton
	Text outputFileText
	Button openFileButton
	
	@Accessors(PACKAGE_GETTER)
	String outputFile
	@Accessors(PACKAGE_GETTER)
	String reportType
	@Accessors(PACKAGE_GETTER)
	boolean openFileAutomatically
	
	new(Shell parent, List<String> formats, String fileType) {
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
			default: it
		}])
		this.fileType = fileType
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
		newShell.text = "Requirements Traceability Report"
	}
	
	override create() {
		super.create
		title = "Traceability Report"
		validateOutputFile
	}
	
	override protected createDialogArea(Composite parent) {
		super.createDialogArea(parent) as Composite => [
			initializeDialogUnits
			new Group(it, SWT.NONE) => [
				text = "Report Options"
				layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false)
				layout = new GridLayout
				g2sButton = new Button(it, SWT.RADIO) => [
					text = "Stakeholder Goal to Stakeholder"
					layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
				]
				r2gButton = new Button(it, SWT.RADIO) => [
					text = "System Requirement to Stakeholder Goal"
					layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
				]
				switch fileType {
					case "reqspec", case "reqdoc": {
						g2sButton.enabled = false
						r2gButton.selection = true
						r2gButton.enabled = false
					}
					case "goals", case "goaldoc": {
						g2sButton.selection = true
						g2sButton.enabled = false
						r2gButton.enabled = false
					}
					default: switch dialogSettings.get(REPORT_TYPE_SETTING) {
						case null,
						case G2S: g2sButton.selection = true
						case R2G: r2gButton.selection = true
					}
				}
			]
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
							if (selectedFileName != null) {
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
				selection = preference == null || Boolean.parseBoolean(preference)
			]
		]
	}
	
	override protected okPressed() {
		outputFile = outputFileText.text.trim
		reportType = if (g2sButton.selection) {
			G2S
		} else if (r2gButton.selection) {
			R2G
		}
		openFileAutomatically = openFileButton.selection
		dialogSettings.put(OUTPUT_FILE_SETTING, outputFile)
		dialogSettings.put(REPORT_TYPE_SETTING, reportType)
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
		getButton(IDialogConstants.OK_ID).enabled = errorMessage == null
	}
}