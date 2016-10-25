package org.osate.assure.ui.views

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jface.layout.TableColumnLayout
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.ColumnPixelData
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.TableViewerColumn
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.ui.part.ViewPart
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.categories.categories.CategoryFilter

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.osate.assure.util.AssureUtilExtension.getMethod
import static extension org.osate.assure.util.AssureUtilExtension.getName
import static extension org.osate.assure.util.AssureUtilExtension.isErrorTimeOut
import static extension org.osate.assure.util.AssureUtilExtension.isFail
import static extension org.osate.assure.util.AssureUtilExtension.isSuccessful
import static extension org.osate.assure.util.AssureUtilExtension.isZeroCount
import static extension org.osate.verify.util.VerifyUtilExtension.evaluateRequirementFilter
import static extension org.osate.verify.util.VerifyUtilExtension.evaluateVerificationActivityFilter
import static extension org.osate.verify.util.VerifyUtilExtension.evaluateVerificationMethodFilter

class AssureProgressView2 extends ViewPart {
	val package static String ID = "org.osate.assure.ui.views.assureProgressView2"
	
	ResourceSet resourceSet
	
	URI assuranceCaseResultURI
	URI filterURI
	
	TableViewer tableViewer
	
	override createPartControl(Composite parent) {
		new Composite(parent, SWT.NONE) => [
			val columnLayout = new TableColumnLayout
			layout = columnLayout
			tableViewer = new TableViewer(it, SWT.BORDER.bitwiseOr(SWT.H_SCROLL).bitwiseOr(SWT.V_SCROLL)) => [
				site.selectionProvider = it
				new TableViewerColumn(it, SWT.LEFT) => [
					columnLayout.setColumnData(column, new ColumnPixelData(200))
					column.text = "Name"
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							"Evidence " + (resourceSet.getEObject(element as URI, true) as VerificationActivityResult).name
						}
						
						override getImage(Object element) {
							val fileName = switch vaResult : resourceSet.getEObject(element as URI, true) as VerificationActivityResult {
								case vaResult.successful: "valid.png"
								case vaResult.fail: "invalid.png"
								case vaResult.errorTimeOut: "error.png"
								case vaResult.zeroCount: "info.png"
								default: "questionmark.png"
							}
							ImageDescriptor.createFromFile(class, "/icons/" + fileName).createImage
						}
					}
				]
				new TableViewerColumn(it, SWT.LEFT) => [
					columnLayout.setColumnData(column, new ColumnPixelData(120))
					column.text = "Exec. Status"
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							val vaResult = resourceSet.getEObject(element as URI, true) as VerificationActivityResult
							vaResult.executionState.literal
						}
					}
				]
				new TableViewerColumn(it, SWT.LEFT) => [
					columnLayout.setColumnData(column, new ColumnPixelData(120))
					column.text = "Result Status"
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							val vaResult = resourceSet.getEObject(element as URI, true) as VerificationActivityResult
							vaResult.resultState.literal
						}
					}
				]
				new TableViewerColumn(it, SWT.LEFT) => [
					columnLayout.setColumnData(column, new ColumnPixelData(100))
					column.text = "Time (msec)"
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							val vaResult = resourceSet.getEObject(element as URI, true) as VerificationActivityResult
							val metrics = vaResult.metrics
							if (metrics != null && metrics.executionTime > 0) {
								metrics.executionTime.toString
							}
						}
					}
				]
				new TableViewerColumn(it, SWT.LEFT) => [
					columnLayout.setColumnData(column, new ColumnPixelData(200))
					column.text = "Issue Msg"
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							val vaResult = resourceSet.getEObject(element as URI, true) as VerificationActivityResult
							vaResult.issues.join("", "\n", "\n", [message])
						}
					}
				]
				new TableViewerColumn(it, SWT.LEFT) => [
					columnLayout.setColumnData(column, new ColumnPixelData(120))
					column.text = "Type"
					labelProvider = new ColumnLabelProvider {
						override getText(Object element) {
							val vaResult = resourceSet.getEObject(element as URI, true) as VerificationActivityResult
							vaResult.method.methodKind.class.name
						}
					}
				]
				contentProvider = ArrayContentProvider.instance
				table.headerVisible = true
				table.linesVisible = true
			]
		]
	}
	
	override setFocus() {
		tableViewer.table.setFocus
	}
	
	def package void setAssuranceCaseResult(AssuranceCaseResult assuranceCaseResult, CategoryFilter categoryFilter) {
		assuranceCaseResultURI = assuranceCaseResult.URI
		filterURI = categoryFilter?.URI
		resourceSet = assuranceCaseResult.eResource.resourceSet
		
		val vaResults = assuranceCaseResult.eAllContents.filter(VerificationActivityResult)
		val filteredResults = vaResults.filter[
			targetReference.requirement.requirement.evaluateRequirementFilter(categoryFilter) &&
				targetReference.verificationActivity.evaluateVerificationActivityFilter(categoryFilter) &&
				targetReference.verificationActivity.evaluateVerificationMethodFilter(categoryFilter)
		]
		tableViewer.input = filteredResults.map[URI].toList
	}
	
	def package void update(URI verificationResultURI) {
		tableViewer.update(verificationResultURI, null)
	}
	
	def package void refresh() {
		tableViewer.refresh
	}
}