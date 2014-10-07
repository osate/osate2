package org.osate.xtext.aadl2.ui.propertyview;

import java.util.Collections
import java.util.List
import java.util.concurrent.atomic.AtomicReference
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jface.viewers.IColorProvider
import org.eclipse.jface.viewers.ITableLabelProvider
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.Viewer
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Color
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.ISerializer
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ListValue
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.Mode
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PackageSection
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertySet
import org.osate.aadl2.instance.InstanceReferenceValue
import org.osate.xtext.aadl2.ui.MyAadl2Activator

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.xtext.aadl2.ui.propertyview.PropertyViewModel.*

/**
 * Model for the AADL Property View.
 *
 * @author aarong
 */
class PropertyViewModel {
	// Constants

	val public static UNDEFINED = "undefined"
	val public static STATUS_LOCAL = "local"
	val public static STATUS_INHERITED = "inherited"
	val public static STATUS_DEFAULT = "default"

	// Locals

	/** Flag to indicate whether we should show undefined properties */
	var boolean showUndefined = false

	/** Model is a List of PropSet items */
	val List<PropertyViewModel.PropSet> input = Collections.synchronizedList(newArrayList)

	/** Immutable wrapped root list for external use */
	val Object inputLeaked = input.unmodifiableView

	val ISerializer serializer
	val IScopeProvider scopeProvider
	var PropertyViewModel.RebuildModelJob rebuildModelJob = null

	// Inner Classes

	private static class PropSet {
		val PropertySet ps
		val List<PropertyViewModel.AbstractModelProperty> properties

		new(PropertySet ps) {
			this.ps = ps;
			properties = newArrayList
		}
	}

	private static abstract class InMode {
		val String modeName
		val PropertyViewModel.AbstractModelProperty parent
		val String value
		val Color color

		new(PropertyViewModel.ModedProperty mp, List<Mode> modes, String value, Color color) {
			modeName = modes.map[name].join(", ")
			parent = mp
			this.value = value
			this.color = color
			mp.modes.add(this)
		}
	}

	private static class UndefinedMode extends PropertyViewModel.InMode {
		new(PropertyViewModel.ModedProperty mp, List<Mode> modes) {
			super(mp, modes, UNDEFINED, safeGetSystemColor(SWT.COLOR_RED))
		}
	}

	private static class ValuedMode extends PropertyViewModel.InMode {
		new(PropertyViewModel.ModedProperty prop, PropertyExpression expression, List<Mode> elementModes, ISerializer serializer) {
			super(prop, elementModes, getValueAsString(expression, serializer), null)
		}

		new(PropertyViewModel.ModedProperty prop, ModalPropertyValue mpv, ISerializer serializer) {
			this(prop, mpv.ownedValue, mpv.allInModes, serializer)
		}
	}

	private static class InheritedMode extends PropertyViewModel.InMode {
		new(PropertyViewModel.ModedProperty prop, PropertyExpression expression, List<Mode> elementModes, ISerializer serializer) {
			super(prop, elementModes, getValueAsString(expression, serializer), null)
		}

		new(PropertyViewModel.ModedProperty prop, ModalPropertyValue mpv, ISerializer serializer) {
			this(prop, mpv.ownedValue, mpv.allInModes, serializer)
		}
	}

	private static class DefaultMode extends PropertyViewModel.InMode {
		new(PropertyViewModel.ModedProperty prop, List<Mode> modes, ISerializer serializer) {
			super(prop, modes, getValueAsString(prop.definition.defaultValue, serializer), null)
		}
	}

	private static abstract class AbstractModelProperty {
		val String propertyName
		val boolean isList
		val PropertyViewModel.PropSet parent
		val public Property definition
		val String value
		val Color color

		new(PropertyViewModel.PropSet ps, Property pn, String value, Color color) {
			propertyName = pn.name
			isList = pn.list
			parent = ps
			definition = pn
			this.value = value
			this.color = color
			ps.properties.add(this)
		}
	}

	private static class ModedProperty extends PropertyViewModel.AbstractModelProperty {
		val List<PropertyViewModel.InMode> modes

		new(PropertyViewModel.PropSet ps, Property pn) {
			super(ps, pn, "", null)
			modes = newArrayList
		}
	}

	private static class UndefinedProperty extends PropertyViewModel.AbstractModelProperty {
		new(PropertyViewModel.PropSet ps, Property pn) {
			super(ps, pn, UNDEFINED, safeGetSystemColor(SWT.COLOR_RED))
		}
	}
	
	private static class ValuedProperty extends PropertyViewModel.AbstractModelProperty {
		new(PropertyViewModel.PropSet ps, Property pn, PropertyAssociation pa, ISerializer serializer) {
			super(ps, pn, pa.ownedValues.head.ownedValue.getValueAsString(serializer), null)
		}
	}

	private static class InheritedProperty extends PropertyViewModel.AbstractModelProperty {
		new(PropertyViewModel.PropSet ps, Property pn, PropertyAssociation pa, ISerializer serializer) {
			super(ps, pn, pa.ownedValues.head.ownedValue.getValueAsString(serializer), null)
		}
	}

	private static class DefaultProperty extends PropertyViewModel.AbstractModelProperty {
		new(PropertyViewModel.PropSet ps, Property pn, ISerializer serializer) {
			super(ps, pn, pn.defaultValue.getValueAsString(serializer), null)
		}
	}

	new(ISerializer serializer, IScopeProvider scopeProvider) {
		this.serializer = serializer
		this.scopeProvider = scopeProvider
		rebuildModelJob = new PropertyViewModel.RebuildModelJob(scopeProvider, serializer, input)
	}
	
	def private static safeGetSystemColor(int id) {
		val color = new AtomicReference
		Display.getDefault.syncExec[|color.set(Display.getDefault.getSystemColor(id))]
		color.get
	}

	def private static getValueAsString(PropertyExpression expression, ISerializer serializer) {
		switch expression {
			InstanceReferenceValue:
				expression.referencedInstanceObject?.instanceObjectPath ?: "null"
			ListValue case expression.hasInstanceReferenceValue:
				expression.serializeListWithInstanceReferenceValue(serializer)
			default: {
				synchronized (serializer) {
					serializer.serialize(expression)
				}.replaceAll("\n", "").replaceAll("\t", "")
				// TODO: Test this to see what cleanup is truly necessary.
			}
		}
	}

	def private static boolean hasInstanceReferenceValue(ListValue topList) {
		topList.ownedListElements.exists[it instanceof InstanceReferenceValue || (it instanceof ListValue && (it as ListValue).hasInstanceReferenceValue)]
	}

	def private static String serializeListWithInstanceReferenceValue(ListValue topList, ISerializer serializer) {
		topList.ownedListElements.join("(", ", ", ")", [
			switch it {
				InstanceReferenceValue:
					referencedInstanceObject?.instanceObjectPath ?: "null"
				ListValue:
					serializeListWithInstanceReferenceValue(serializer)
				default: {
					synchronized (serializer) {
						serializer.serialize(it)
					}.replaceAll("\n", "").replaceAll("\t", "")
				}
			}
		])
	}

	// model management

	def getInput() {
		inputLeaked
	}

	def setShowUndefined(boolean flag) {
		showUndefined = flag
	}

	def void toggleShowUndefined() {
		showUndefined = !showUndefined
	}

	def getShowUndefined() {
		showUndefined
	}

	/**
	 * Rebuild list of property values.
	 * @param element
	 *            The property holder whose property values are to be displayed
	 * @param uiUpdate
	 * 			  Runnable which refreshes the treeViewer.  uiUpdate is called in the UI thread after the model is rebuilt.
	 */
	def rebuildModel(NamedElement element, Runnable uiUpdate) {
		if (rebuildModelJob.getState() != Job.NONE) {
			rebuildModelJob.cancel()
			rebuildModelJob = new PropertyViewModel.RebuildModelJob(scopeProvider, serializer, input)
		}
		rebuildModelJob.element = element
		rebuildModelJob.uiUpdate = uiUpdate
		rebuildModelJob.showUndefined = showUndefined
		rebuildModelJob.schedule(200)
	}

	private static class RebuildModelJob extends Job {
		val extension IScopeProvider scopeProvider
		val ISerializer serializer
		val List<PropertyViewModel.PropSet> input
		
		var volatile NamedElement element
		var volatile Runnable uiUpdate
		var volatile boolean showUndefined

		new(IScopeProvider scopeProvider, ISerializer serializer, List<PropertyViewModel.PropSet> input) {
			super("Updating Property View")
			this.scopeProvider = scopeProvider
			this.serializer = serializer
			this.input = input
			setPriority(SHORT)
		}

		override run(IProgressMonitor monitor) {
			val localInput = newArrayList
			/*
			 * Walk through all the property sets, and query the component for
			 * each property.
			 */
			val scope = if (element instanceof AadlPackage) {
				(element.ownedPublicSection ?: element.ownedPrivateSection)?.getScope(Aadl2Package.eINSTANCE.packageSection_ImportedUnit)
			} else {
				element.getContainerOfType(PackageSection)?.getScope(Aadl2Package.eINSTANCE.packageSection_ImportedUnit) ?:
					element.getContainerOfType(PropertySet)?.getScope(Aadl2Package.eINSTANCE.propertySet_ImportedUnit)
			}
			scope?.allElements.map[
				if (EObjectOrProxy.eIsProxy) {
					EcoreUtil.resolve(EObjectOrProxy, element)
				} else {
					EObjectOrProxy
				}
			].filter[!eIsProxy].filter(PropertySet).sortBy[name.toUpperCase].forEach(monitor, [
				val propSet = new PropertyViewModel.PropSet(it)
				ownedProperties.filterNull.filter[element.acceptsProperty(it)].forEach(monitor, [
					// Don't worry about PropertyDoesNotApplyToHolderException,
					// we already check if property is acceptable
					val firstAssociation = element.getPropertyValue(it).first
					if (firstAssociation != null && !firstAssociation.ownedValues.empty) {
						//This check is for incomplete models which may occur while the user is typing a PropertyAssociation
						if (!firstAssociation.ownedValues.empty && firstAssociation.ownedValues.forall[ownedValue != null]) {
							switch element {
								ComponentClassifier case firstAssociation.modal: {
									val prop = new PropertyViewModel.ModedProperty(propSet, it)
									val elementModes = element.allModes
									firstAssociation.ownedValues.forEach(monitor, [
										if (allInModes.size == 0) {
											if (firstAssociation.owner == element) {
												new PropertyViewModel.ValuedMode(prop, ownedValue, elementModes, serializer)
											} else {
												new PropertyViewModel.InheritedMode(prop, ownedValue, elementModes, serializer)
											}
											elementModes.clear
										} else {
											if (firstAssociation.owner == element) {
												new PropertyViewModel.ValuedMode(prop, it, serializer)
											} else {
												new PropertyViewModel.InheritedMode(prop, it, serializer)
											}
											elementModes.removeAll(allInModes)
										}
									])
									if (!monitor.canceled) {
										/*
										 * If prop has no children (i.e., undefined
										 * in all modes, remove from the property
										 * set (don't show it)
										 */
										if (prop.modes.empty) {
											propSet.properties.remove(prop)
										} else if (!elementModes.empty) {
											if (defaultValue != null) {
												new PropertyViewModel.DefaultMode(prop, elementModes, serializer)
											} else if (showUndefined) {
												new PropertyViewModel.UndefinedMode(prop, elementModes)
											}
										}
									}
								}
								case firstAssociation.owner:
									new PropertyViewModel.ValuedProperty(propSet, it, firstAssociation, serializer)
								default:
									new PropertyViewModel.InheritedProperty(propSet, it, firstAssociation, serializer)
							}
						}
					} else {
						if (defaultValue != null) {
							new PropertyViewModel.DefaultProperty(propSet, it, serializer)
						} else if (showUndefined) {
							new PropertyViewModel.UndefinedProperty(propSet, it)
						}
					}
				])
				if (!monitor.canceled) {
					// Don't add property sets that have no children
					if (propSet.properties.size > 0) {
						localInput.add(propSet)
					}
				}
			])
			if (monitor.isCanceled()) {
				Status.CANCEL_STATUS;
			} else {
				input.clear
				input.addAll(localInput)
				Display.getDefault.syncExec(uiUpdate)
				Status.OK_STATUS
			}
		}
		
		def private static <T> forEach(Iterable<T> iterable, IProgressMonitor monitor, (T)=>void procedure) {
			val iterator = iterable.iterator
			while (iterator.hasNext && !monitor.canceled) {
				procedure.apply(iterator.next)
			}
		}
	}
	
	package static class PropertyViewContentProvider implements ITreeContentProvider {
		override getChildren(Object parentElement) {
			switch parentElement {
				PropertyViewModel.PropSet:
					parentElement.properties
				PropertyViewModel.ModedProperty:
					parentElement.modes
			}
		}
		
		override getElements(Object inputElement) {
			inputElement as List<PropertyViewModel.PropSet>
		}
		
		override getParent(Object element) {
			switch element {
				PropertyViewModel.AbstractModelProperty:
					element.parent
				PropertyViewModel.InMode:
					element.parent
			}
		}
		
		override hasChildren(Object element) {
			element instanceof PropertyViewModel.PropSet || element instanceof PropertyViewModel.ModedProperty
		}
		
		override dispose() {
		}
		
		override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	package static class PropertyViewLabelProvider extends LabelProvider implements ITableLabelProvider, IColorProvider {
		val static MODE_ICON = "icons/propertyview/mode.gif"
		val static SCALAR_ICON = "icons/propertyview/scalar.gif"
		val static LIST_ICON = "icons/propertyview/list.gif"
		val static PROPERTY_SET_ICON = "icons/propertyview/property_set.gif"
	
		/** Cached Icon for property set nodes */
		var Image propSetImage = null
		/** Cached Icon for list property value nodes */
		var Image listImage = null
		/** Cached Icon for scalar property value nodes */
		var Image scalarImage = null
		/** Cached Icon for modes */
		var Image modeImage = null
		
		override getImage(Object element) {
			switch element {
				PropertyViewModel.PropSet:
					propSetImage ?: (propSetImage = MyAadl2Activator.getImageDescriptor(PROPERTY_SET_ICON).createImage)
				PropertyViewModel.AbstractModelProperty: {
					if (element.isList) {
						listImage ?: (listImage = MyAadl2Activator.getImageDescriptor(LIST_ICON).createImage)
					} else {
						scalarImage ?: (scalarImage = MyAadl2Activator.getImageDescriptor(SCALAR_ICON).createImage)
					}
				}
				PropertyViewModel.InMode: {
					modeImage ?: (modeImage = MyAadl2Activator.getImageDescriptor(MODE_ICON).createImage)
				}
			}
		}
		
		override getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return getImage(element)
			}
		}
		
		override getText(Object element) {
			switch element {
				PropertyViewModel.PropSet:
					element.ps.name
				PropertyViewModel.AbstractModelProperty:
					element.propertyName
				PropertyViewModel.InMode:
					'''in modes («element.modeName»)'''
			}
		}
		
		override getColumnText(Object element, int columnIndex) {
			switch columnIndex {
				case 0:
					getText(element)
				case 1: {
					switch element {
						PropertyViewModel.ValuedProperty, PropertyViewModel.ValuedMode:
							STATUS_LOCAL
						PropertyViewModel.InheritedProperty, PropertyViewModel.InheritedMode:
							STATUS_INHERITED
						PropertyViewModel.DefaultProperty, PropertyViewModel.DefaultMode:
							STATUS_DEFAULT
						PropertyViewModel.UndefinedProperty, PropertyViewModel.UndefinedMode:
							UNDEFINED
					}
				}
				case 2: {
					switch element {
						AbstractModelProperty:
							element.value
						InMode:
							element.value
					}
				}
			}
		}
		
		/**
		 * Return <code>null</code>; always use the default color.
		 */
		override getBackground(Object element) {
			null
		}
		
		override getForeground(Object element) {
			switch element {
				PropertyViewModel.AbstractModelProperty:
					element.color
				PropertyViewModel.InMode:
					element.color
			}
		}
		
		override dispose() {
			propSetImage?.dispose
			propSetImage = null
			listImage?.dispose
			listImage = null
			scalarImage?.dispose
			scalarImage = null
			modeImage?.dispose
			modeImage = null
		}
	}
}