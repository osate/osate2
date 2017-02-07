package org.osate.reqspec.ui.handlers;

import com.google.inject.Inject
import java.util.List
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.jface.layout.TableColumnLayout
import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.TableViewerColumn
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.recspec.ui.spotlight.utils.SpotlightUtil
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.ui.handlers.SpotlightHandler.SpotlightResult
import org.osate.reqspec.ui.internal.ReqSpecActivator
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.ui.handlers.HandlerUtil.getActiveShell
import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.*

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see IHandler
 * @see AbstractHandler
 */
class SpotlightHandler extends AbstractHandler {
	@Inject IReqspecGlobalReferenceFinder reqSpecrefFinder

	new() {
		ReqSpecActivator.instance.getInjector(ReqSpecActivator.ORG_OSATE_REQSPEC_REQSPEC).injectMembers(this)
	}

	/**
	 * the command has been executed, so extract the needed information
	 * from the application context.
	 */
	override Object execute(ExecutionEvent event) throws ExecutionException {
		val window = HandlerUtil.getActiveWorkbenchWindowChecked(event)
		if (window !== null) {
			val selection = window.getSelectionService().getSelection() as IStructuredSelection
			val firstElement = selection.getFirstElement()

			if (firstElement instanceof IAdaptable) {
				val systemInstance = switch firstElement {
					SystemInstance: firstElement
					IFile case firstElement.name.endsWith(".aaxl2"): firstElement.resource.contents.head as SystemInstance
					InstanceObject: firstElement.getContainerOfType(SystemInstance)
				}
				if (systemInstance === null) {
					return null
				}

				val leafNodesIterator = systemInstance.getAllContents(true).filter(ComponentInstance).filter [
					componentInstances.empty
				]
				val leafNodesList = leafNodesIterator.toList

				val numleaves = leafNodesList.size
				val ASRTable = leafNodesList.map[leaf | leaf.analyze(numleaves)].sortBy[pur].reverseView
				new SpotlightDialog(event.activeShell, systemInstance.name, ASRTable).open
			}
		}
		null
	}

	def SpotlightResult analyze(ComponentInstance leafInstance, int numleaves) {
		val ASRsForLeafNode = reqSpecrefFinder.getAllRequirements(leafInstance).filter[req|req.ssp].toList
		val numASRs = ASRsForLeafNode.size

		val midMinusASRs = (numASRs / 2) - 1
		val midPlusASRs = midMinusASRs + 1

		val volSorted = ASRsForLeafNode.map[req|req.changeUncertainty.volatility].sort
		val precSorted = ASRsForLeafNode.map[req|req.changeUncertainty.precedence].sort
		val double maxVol = volSorted.max
		val double medianVol = if (numASRs % 2 == 0) {
				(volSorted.get(midMinusASRs) + volSorted.get(midPlusASRs)) / 2.0
			} else {
				volSorted.get(midPlusASRs)
			}
		val double medianPrec = if (numASRs % 2 == 0) {
				(precSorted.get(midMinusASRs) + precSorted.get(midPlusASRs)) / 2.0
			} else {
				precSorted.get(midPlusASRs)
			}
		// We use a nested lambda function to produce the list of category lists, one per ASR for the given leaf node
		// For example, for a component c15 that has 5 ASRs, two security-only ASR, two safety-and-security-only ASRs,
		// and one security-and-performance-only ASR,
		// we'd get a list of lists of strings that might look something like this: 
		// [[Security], [Safety, Security], [Safety, Security], [Security], [Security, Performance]]
		val ASRsForLeafNodeCategories = ASRsForLeafNode.map[req|req.category.map[cat|cat.name.toLowerCase]]

		val numSafety = ASRsForLeafNodeCategories.filter[contains("safety")].size
		val numSecurity = ASRsForLeafNodeCategories.filter[contains("security")].size
		val numPerformance = ASRsForLeafNodeCategories.filter[contains("performance")].size

		val PUR = SpotlightUtil.calculatePUR(numleaves, maxVol, medianVol, medianPrec, numSafety, numSecurity,
			numPerformance)
		return new SpotlightResult(leafInstance, numASRs, PUR as int)
	}

	def boolean isSsp(Requirement req) {
		val ssp = #{"safety", "security", "performance"}
		val categories = req.category
		val iterator = categories.iterator
		while (iterator.hasNext) {
			var nextCat = iterator.next
			if (ssp.contains(nextCat.name.toLowerCase)) {
				return true
			}
		}
		false
	}

	@FinalFieldsConstructor
	private static class SpotlightResult {
		val ComponentInstance instance
		val int numberOfASRs
		val int pur
	}
	
	private static class SpotlightDialog extends TitleAreaDialog {
		val String systemInstanceName
		val List<SpotlightResult> results
		
		new(Shell parentShell, String systemInstanceName, List<SpotlightResult> results) {
			super(parentShell)
			this.systemInstanceName = systemInstanceName
			this.results = results
		}
		
		override protected isResizable() {
			true
		}
		
		override isHelpAvailable() {
			false
		}
		
		override protected getInitialSize() {
			new Point(convertHorizontalDLUsToPixels(500), convertVerticalDLUsToPixels(300))
		}
		
		override protected configureShell(Shell newShell) {
			super.configureShell(newShell)
			newShell.text = "Spotlight Results"
		}
		
		override create() {
			super.create
			title = '''Spotlight Results for System Instance "«systemInstanceName»"'''
		}
		
		//Overriden so that the cancel button will not be created.
		override protected createButtonsForButtonBar(Composite parent) {
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		}
		
		override protected createDialogArea(Composite parent) {
			super.createDialogArea(parent) as Composite => [
				initializeDialogUnits
				new Composite(it, SWT.NONE) => [
					layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
					val tableColumnLayout = new TableColumnLayout
					layout = tableColumnLayout
					new TableViewer(it, SWT.BORDER.bitwiseOr(SWT.FULL_SELECTION)) => [tableViewer |
						new TableViewerColumn(tableViewer, SWT.LEFT) => [
							column.text = "Component Instance"
							tableColumnLayout.setColumnData(column, new ColumnPixelData(convertHorizontalDLUsToPixels(100), true, true))
							labelProvider = new ColumnLabelProvider {
								override getText(Object element) {
									(element as SpotlightResult).instance.name
								}
							}
						]
						new TableViewerColumn(tableViewer, SWT.LEFT) => [
							column.text = "Classifier"
							tableColumnLayout.setColumnData(column, new ColumnWeightData(1, true))
							labelProvider = new ColumnLabelProvider {
								override getText(Object element) {
									(element as SpotlightResult).instance.subcomponent.allClassifier?.getQualifiedName ?: ""
								}
							}
						]
						new TableViewerColumn(tableViewer, SWT.LEFT) => [
							column.text = "Number of ASRs"
							tableColumnLayout.setColumnData(column, new ColumnPixelData(convertHorizontalDLUsToPixels(50), true, true))
							labelProvider = new ColumnLabelProvider {
								override getText(Object element) {
									(element as SpotlightResult).numberOfASRs.toString
								}
							}
						]
						new TableViewerColumn(tableViewer, SWT.LEFT) => [
							column.text = "PUR"
							tableColumnLayout.setColumnData(column, new ColumnPixelData(convertHorizontalDLUsToPixels(100), true, true))
							labelProvider = new ColumnLabelProvider {
								override getText(Object element) {
									(element as SpotlightResult).pur.toString
								}
							}
						]
						
						tableViewer.contentProvider = ArrayContentProvider.instance
						tableViewer.input = results
						tableViewer.table.linesVisible = true
						tableViewer.table.headerVisible = true
					]
				]
			]
		}
	}
}