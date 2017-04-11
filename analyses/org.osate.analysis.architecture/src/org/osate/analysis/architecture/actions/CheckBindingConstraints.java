package org.osate.analysis.architecture.actions;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.architecture.ArchitecturePlugin;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osgi.framework.Bundle;

public class CheckBindingConstraints extends AaxlReadOnlyActionAsJob {
	@Override
	protected Bundle getBundle() {
		return ArchitecturePlugin.getDefault().getBundle();
	}
	
	@Override
	protected String getMarkerType() {
		return "org.osate.analysis.architecture.CheckBindingConstraintsObjectMarker";
	}
	
	@Override
	protected void doAaxlAction(IProgressMonitor monitor, Element root) {
		if (root instanceof ComponentInstance) {
			monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
			
			SystemInstance si = ((ComponentInstance)root).getSystemInstance();
			if (si != null) {
				Stream<ComponentInstance> processorBindingComponents = getComponents(monitor, si,
						ComponentCategory.THREAD, ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.DEVICE);
				processorBindingComponents.forEach(component -> {
					Set<ComponentInstance> actualProcessors = new HashSet<>(GetProperties.getActualProcessorBinding(component));
					Set<ComponentInstance> allowedProcessors = new HashSet<>(GetProperties.getAllowedProcessorBinding(component));
					if (!actualProcessors.isEmpty() && !allowedProcessors.isEmpty()) {
						actualProcessors.removeAll(allowedProcessors);
						actualProcessors.forEach(boundProcessor -> error(component,
								StringExtensions.toFirstUpper(component.getCategory().getName()) + " '"
										+ component.getName() + "' has a processor binding to '"
										+ boundProcessor.getName()
										+ "' which is not allowed by the property Allowed_Processor_Binding"));
					}
				});
				
				Stream<ComponentInstance> memoryBindingComponents = getComponents(monitor, si, ComponentCategory.THREAD,
						ComponentCategory.DEVICE, ComponentCategory.DATA, ComponentCategory.SUBPROGRAM,
						ComponentCategory.PROCESSOR, ComponentCategory.VIRTUAL_PROCESSOR);
				memoryBindingComponents.forEach(component -> {
					Set<ComponentInstance> actualMemory = new HashSet<>(GetProperties.getActualMemoryBinding(component));
					Set<ComponentInstance> allowedMemory = new HashSet<>(GetProperties.getAllowedMemoryBinding(component));
					if (!actualMemory.isEmpty() && !allowedMemory.isEmpty()) {
						actualMemory.removeAll(allowedMemory);
						actualMemory.forEach(boundMemory -> error(component,
								StringExtensions.toFirstUpper(component.getCategory().getName()) + " '"
										+ component.getName() + "' has a memory binding to '" + boundMemory.getName()
										+ "' which is not allowed by the property Allowed_Memory_Binding"));
					}
				});
				
				Stream<FeatureInstance> memoryBindingFeatures = getFeatures(monitor, si, FeatureCategory.DATA_PORT,
						FeatureCategory.EVENT_DATA_PORT);
				memoryBindingFeatures.forEach(feature -> {
					Set<ComponentInstance> actualMemory = new HashSet<>(GetProperties.getActualMemoryBinding(feature));
					Set<ComponentInstance> allowedMemory = new HashSet<>(GetProperties.getAllowedMemoryBinding(feature));
					if (!actualMemory.isEmpty() && !allowedMemory.isEmpty()) {
						actualMemory.removeAll(allowedMemory);
						actualMemory.forEach(boundMemory -> error(feature,
								StringExtensions.toFirstUpper(feature.getCategory().getName()) + " '"
										+ feature.getName() + "' has a memory binding to '" + boundMemory.getName()
										+ "' which is not allowed by the property Allowed_Memory_Binding"));
					}
				});
				
				Stream<ComponentInstance> connectionBindingComponents = getComponents(monitor, si,
						ComponentCategory.THREAD, ComponentCategory.SYSTEM, ComponentCategory.VIRTUAL_BUS);
				connectionBindingComponents.forEach(component -> {
					Set<ComponentInstance> actualConnection = new HashSet<>(GetProperties.getActualConnectionBinding(component));
					Set<ComponentInstance> allowedConnection = new HashSet<>(GetProperties.getAllowedConnectionBinding(component));
					if (!actualConnection.isEmpty() && !allowedConnection.isEmpty()) {
						actualConnection.removeAll(allowedConnection);
						actualConnection.forEach(boundConnection -> error(component,
								StringExtensions.toFirstUpper(component.getCategory().getName()) + " '"
										+ component.getName() + "' has a connection binding to '"
										+ boundConnection.getName()
										+ "' which is not allowed by the property Allowed_Connection_Binding"));
					}
				});
				
				Stream<FeatureInstance> connectionBindingFeatures = getFeatures(monitor, si);
				connectionBindingFeatures.forEach(feature -> {
					Set<ComponentInstance> actualConnection = new HashSet<>(GetProperties.getActualConnectionBinding(feature));
					Set<ComponentInstance> allowedConnection = new HashSet<>(GetProperties.getAllowedConnectionBinding(feature));
					if (!actualConnection.isEmpty() && !allowedConnection.isEmpty()) {
						actualConnection.removeAll(allowedConnection);
						actualConnection.forEach(boundConnection -> error(feature,
								StringExtensions.toFirstUpper(feature.getCategory().getName()) + " '"
										+ feature.getName() + "' has a connection binding to '"
										+ boundConnection.getName()
										+ "' which is not allowed by the property Allowed_Connection_Binding"));
					}
				});
				
				Stream<ConnectionInstance> connectionBindingConnections = getConnections(monitor, si);
				connectionBindingConnections.forEach(connection -> {
					Set<ComponentInstance> actualConnection = new HashSet<>(GetProperties.getActualConnectionBinding(connection));
					Set<ComponentInstance> allowedConnection = new HashSet<>(GetProperties.getAllowedConnectionBinding(connection));
					if (!actualConnection.isEmpty() && !allowedConnection.isEmpty()) {
						actualConnection.removeAll(allowedConnection);
						actualConnection.forEach(boundConnection -> error(connection, "Connection '"
								+ connection.getName() + "' has a connection binding to '" + boundConnection.getName()
								+ "' which is not allowed by the property Allowed_Connection_Binding"));
					}
				});
			}
			
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			} else {
				monitor.done();
			}
		} else {
			Dialog.showWarning(getActionName(), "Please invoke command on an instance model");
		}
	}
	
	@Override
	protected String getActionName() {
		return "Check binding constraints";
	}
	
	private static Stream<ComponentInstance> getComponents(IProgressMonitor monitor, SystemInstance instance, ComponentCategory... categories) {
		Stream<EObject> stream = StreamSupport.stream(new Spliterators.AbstractSpliterator<EObject>(Long.MAX_VALUE, Spliterator.ORDERED) {
			private final Iterator<EObject> allContentsIter = instance.eAllContents();
			
			@Override
			public boolean tryAdvance(Consumer<? super EObject> action) {
				if (!monitor.isCanceled() && allContentsIter.hasNext()) {
					action.accept(allContentsIter.next());
					return true;
				} else {
					return false;
				}
			}
		}, false);
		Stream<ComponentInstance> components = stream
				.filter(element -> element instanceof ComponentInstance)
				.map(element -> (ComponentInstance)element);
		if (categories.length == 0) {
			return components;
		} else {
			EnumSet<ComponentCategory> categoriesSet = EnumSet.copyOf(Arrays.asList(categories));
			return components.filter(element -> categoriesSet.contains(element.getCategory()));
		}
	}
	
	private static Stream<FeatureInstance> getFeatures(IProgressMonitor monitor, SystemInstance instance, FeatureCategory... categories) {
		Stream<EObject> stream = StreamSupport.stream(new Spliterators.AbstractSpliterator<EObject>(Long.MAX_VALUE, Spliterator.ORDERED) {
			private final Iterator<EObject> allContentsIter = instance.eAllContents();
			
			@Override
			public boolean tryAdvance(Consumer<? super EObject> action) {
				if (!monitor.isCanceled() && allContentsIter.hasNext()) {
					action.accept(allContentsIter.next());
					return true;
				} else {
					return false;
				}
			}
		}, false);
		Stream<FeatureInstance> features = stream
				.filter(element -> element instanceof FeatureInstance)
				.map(element -> (FeatureInstance)element);
		if (categories.length == 0) {
			return features;
		} else {
			EnumSet<FeatureCategory> categoriesSet = EnumSet.copyOf(Arrays.asList(categories));
			return features.filter(element -> categoriesSet.contains(element.getCategory()));
		}
	}
	
	private static Stream<ConnectionInstance> getConnections(IProgressMonitor monitor, SystemInstance instance) {
		Stream<EObject> stream = StreamSupport.stream(new Spliterators.AbstractSpliterator<EObject>(Long.MAX_VALUE, Spliterator.ORDERED) {
			private final Iterator<EObject> allContentsIter = instance.eAllContents();
			
			@Override
			public boolean tryAdvance(Consumer<? super EObject> action) {
				if (!monitor.isCanceled() && allContentsIter.hasNext()) {
					action.accept(allContentsIter.next());
					return true;
				} else {
					return false;
				}
			}
		}, false);
		return stream
				.filter(element -> element instanceof ConnectionInstance)
				.map(element -> (ConnectionInstance)element);
	}
}