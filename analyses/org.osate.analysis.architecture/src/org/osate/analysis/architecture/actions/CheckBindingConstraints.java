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
 * of Defense under Contract FA8721-05-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.analysis.architecture.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
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

			SystemInstance si = ((ComponentInstance) root).getSystemInstance();
			if (si != null) {
				List<Issue> issues = runAnalysis(monitor, si);
				issues.forEach(issue -> error(issue.target, issue.message));
				if (issues.isEmpty()) {
					getShell().getDisplay().asyncExec(() -> MessageDialog.openInformation(getShell(),
							"Check Binding Constraints", "No problems found"));
				} else {
					getShell().getDisplay().asyncExec(() -> MessageDialog.openError(getShell(),
							"Check Binding Constraints", issues.size() + " problem(s) found"));
				}
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

	public static List<Issue> runAnalysis(IProgressMonitor monitor, SystemInstance si) {
		List<Issue> issuesList = new ArrayList<>();

		for (SOMIterator somIter = new SOMIterator(si); somIter.hasNext();) {
			SystemOperationMode som = somIter.next();

			// Processor binding
			List<ComponentInstance> processorBindingComponents = getComponents(monitor, si, ComponentCategory.THREAD,
					ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.DEVICE).collect(Collectors.toList());
			issuesList.addAll(checkBindingConstraints(processorBindingComponents.stream(), "processor",
					GetProperties::getActualProcessorBinding, GetProperties::getAllowedProcessorBinding,
					GetProperties::getAllowedProcessorBindingClass, som));

			// Dispatch Protocol
			issuesList.addAll(checkDispatchProtocol(processorBindingComponents.stream(), som));

			// Memory binding
			Stream<ComponentInstance> memoryBindingComponents = getComponents(monitor, si, ComponentCategory.THREAD,
					ComponentCategory.DEVICE, ComponentCategory.DATA, ComponentCategory.SUBPROGRAM,
					ComponentCategory.PROCESSOR, ComponentCategory.VIRTUAL_PROCESSOR);
			Stream<FeatureInstance> memoryBindingFeatures = getFeatures(monitor, si, FeatureCategory.DATA_PORT,
					FeatureCategory.EVENT_DATA_PORT);
			Stream<InstanceObject> memoryBindingElements = Stream.concat(memoryBindingComponents,
					memoryBindingFeatures);
			issuesList.addAll(
					checkBindingConstraints(memoryBindingElements, "memory", GetProperties::getActualMemoryBinding,
							GetProperties::getAllowedMemoryBinding, GetProperties::getAllowedMemoryBindingClass, som));

			// Connection binding (only handles connection and virtual bus)
			Stream<ComponentInstance> connectionBindingComponents = getComponents(monitor, si,
					ComponentCategory.VIRTUAL_BUS);
			Stream<ConnectionInstance> connectionBindingConnections = getConnections(monitor, si);
			List<InstanceObject> connectionBindingElements = Stream
					.concat(connectionBindingComponents, connectionBindingConnections).collect(Collectors.toList());
			issuesList.addAll(checkBindingConstraints(connectionBindingElements.stream(), "connection",
					GetProperties::getActualConnectionBinding, GetProperties::getAllowedConnectionBinding,
					GetProperties::getAllowedConnectionBindingClass, som));

			// Connection Quality of Service
			issuesList.addAll(checkRequiredAndProvided(connectionBindingElements.stream(),
					GetProperties::getRequiredConnectionQualityOfService, "Required_Connection_Quality_Of_Service",
					GetProperties::getProvidedConnectionQualityOfService, qos -> qos.getName(), som));

			// Virtual Bus Class
			Function<ComponentInstance, Collection<ComponentClassifier>> getProvidedVBClass = boundElement -> {
				Stream<ComponentClassifier> providedProperty = GetProperties.getProvidedVirtualBusClass(boundElement)
						.stream();
				Stream<ComponentClassifier> providedBySubcomponent = boundElement.getComponentInstances().stream()
						.map(subcomponent -> subcomponent.getClassifier());
				return Stream.concat(providedProperty, providedBySubcomponent).collect(Collectors.toSet());
			};
			issuesList.addAll(checkRequiredAndProvided(connectionBindingElements.stream(),
					GetProperties::getRequiredVirtualBusClass, "Required_Virtual_Bus_Class", getProvidedVBClass,
					vbClass -> vbClass.getName(), som));
		}

		return issuesList;
	}

	private static <T extends InstanceObject> List<Issue> checkBindingConstraints(Stream<T> bindingElements,
			String bindingType, Function<T, List<ComponentInstance>> getActualBinding,
			Function<T, List<ComponentInstance>> getAllowedBinding,
			Function<T, List<Classifier>> getAllowedBindingClass, SystemOperationMode som) {
		return bindingElements.flatMap(element -> {
			Set<ComponentInstance> actualBinding = Collections
					.unmodifiableSet(new HashSet<>(getActualBinding.apply(element)));
			Set<ComponentInstance> allowedBinding = Collections
					.unmodifiableSet(new HashSet<>(getAllowedBinding.apply(element)));
			Set<Classifier> allowedBindingClasses = Collections
					.unmodifiableSet(new HashSet<>(getAllowedBindingClass.apply(element)));

			Stream<Issue> issues = Stream.empty();

			if (!actualBinding.isEmpty() && !allowedBindingClasses.isEmpty()) {
				Set<ComponentInstance> modifiableActual = new HashSet<>(actualBinding);
				modifiableActual.removeIf(boundElement -> {
					ComponentClassifier boundElementClassifier = boundElement.getClassifier();
					return boundElementClassifier != null && allowedBindingClasses.stream()
							.anyMatch(allowedClass -> AadlUtil.isSameOrExtends(allowedClass, boundElementClassifier));
				});
				String propertyName = "Allowed_" + StringExtensions.toFirstUpper(bindingType) + "_Binding_Class";
				issues = Stream.concat(issues,
						createErrorsForBindings(modifiableActual, element, bindingType, som, propertyName));
			}

			if (!actualBinding.isEmpty() && !allowedBinding.isEmpty()) {
				Set<ComponentInstance> modifiableActual = new HashSet<>(actualBinding);
				modifiableActual.removeAll(allowedBinding);
				String propertyName = "Allowed_" + StringExtensions.toFirstUpper(bindingType) + "_Binding";
				issues = Stream.concat(issues,
						createErrorsForBindings(modifiableActual, element, bindingType, som, propertyName));
			}
			return issues;
		}).collect(Collectors.toList());
	}

	private static List<Issue> checkDispatchProtocol(Stream<ComponentInstance> bindingElements,
			SystemOperationMode som) {
		return bindingElements.flatMap(element -> {
			EnumerationLiteral dispatchProtocol = GetProperties.getDispatchProtocol(element);
			if (dispatchProtocol != null) {
				return GetProperties.getActualProcessorBinding(element).stream().map(boundElement -> {
					List<EnumerationLiteral> allowedDispatchProtocol = GetProperties
							.getAllowedDispatchProtocol(boundElement);
					if (!allowedDispatchProtocol.isEmpty() && !allowedDispatchProtocol.contains(dispatchProtocol)) {
						StringBuilder message = new StringBuilder(getTitle(element));
						message.append(" '");
						message.append(element.getName());
						message.append("' has a Dispatch_Protocol '");
						message.append(dispatchProtocol.getName());
						if (!Aadl2Util.isNoModes(som)) {
							message.append("' in mode '");
							message.append(som.getName());
						}
						message.append("' which is not allowed by '");
						message.append(boundElement.getName());
						message.append("'");
						return Optional.of(new Issue(element, message.toString()));
					} else {
						return Optional.<Issue> empty();
					}
				}).filter(issue -> issue.isPresent()).map(issue -> issue.get());
			} else {
				return Stream.empty();
			}
		}).collect(Collectors.toList());
	}

	private static <T> List<Issue> checkRequiredAndProvided(Stream<InstanceObject> bindingElements,
			Function<NamedElement, List<T>> getRequired, String requiredPropertyName,
			Function<ComponentInstance, Collection<T>> getProvided, Function<T, String> getName,
			SystemOperationMode som) {
		return bindingElements.flatMap(element -> {
			Set<T> required = Collections.unmodifiableSet(new HashSet<>(getRequired.apply(element)));
			if (!required.isEmpty()) {
				return GetProperties.getActualConnectionBinding(element).stream().flatMap(boundElement -> {
					Set<T> missingSet = new HashSet<>(required);
					missingSet.removeAll(getProvided.apply(boundElement));
					return missingSet.stream().map(missing -> {
						StringBuilder message = new StringBuilder(getTitle(element));
						message.append(" '");
						message.append(element.getName());
						message.append("' has a ");
						message.append(requiredPropertyName);
						message.append(" '");
						message.append(getName.apply(missing));
						if (!Aadl2Util.isNoModes(som)) {
							message.append("' in mode '");
							message.append(som.getName());
						}
						message.append("' which is not provided by '");
						message.append(boundElement.getName());
						message.append("'");
						return new Issue(element, message.toString());
					});
				});
			} else {
				return Stream.empty();
			}
		}).collect(Collectors.toList());
	}

	private static Stream<Issue> createErrorsForBindings(Set<ComponentInstance> actualBinding, InstanceObject element,
			String bindingType, SystemOperationMode som, String propertyName) {
		return actualBinding.stream().map(boundElement -> {
			StringBuilder message = new StringBuilder(getTitle(element));
			message.append(" '");
			message.append(element.getName());
			message.append("' has a ");
			message.append(bindingType);
			message.append(" binding to '");
			message.append(boundElement.getName());
			if (!Aadl2Util.isNoModes(som)) {
				message.append("' in mode '");
				message.append(som.getName());
			}
			message.append("' which is not allowed by the property ");
			message.append(propertyName);
			return new Issue(element, message.toString());
		});
	}

	private static String getTitle(InstanceObject element) {
		if (element instanceof ComponentInstance) {
			return StringExtensions.toFirstUpper(((ComponentInstance) element).getCategory().getName());
		} else if (element instanceof FeatureInstance) {
			return ((FeatureInstance) element).getCategory().getName();
		} else if (element instanceof ConnectionInstance) {
			return "Connection";
		} else {
			throw new AssertionError("Unhandled condition: " + element);
		}
	}

	private static Stream<ComponentInstance> getComponents(IProgressMonitor monitor, SystemInstance instance,
			ComponentCategory... categories) {
		Stream<EObject> stream = streamWhileNotCanceled(monitor, instance);
		Stream<ComponentInstance> components = filterByType(stream, ComponentInstance.class);
		if (categories.length == 0) {
			return components;
		} else {
			EnumSet<ComponentCategory> categoriesSet = EnumSet.copyOf(Arrays.asList(categories));
			return components.filter(element -> categoriesSet.contains(element.getCategory()));
		}
	}

	private static Stream<FeatureInstance> getFeatures(IProgressMonitor monitor, SystemInstance instance,
			FeatureCategory... categories) {
		Stream<EObject> stream = streamWhileNotCanceled(monitor, instance);
		Stream<FeatureInstance> features = filterByType(stream, FeatureInstance.class);
		if (categories.length == 0) {
			return features;
		} else {
			EnumSet<FeatureCategory> categoriesSet = EnumSet.copyOf(Arrays.asList(categories));
			return features.filter(element -> categoriesSet.contains(element.getCategory()));
		}
	}

	private static Stream<ConnectionInstance> getConnections(IProgressMonitor monitor, SystemInstance instance) {
		Stream<EObject> stream = streamWhileNotCanceled(monitor, instance);
		return filterByType(stream, ConnectionInstance.class);
	}

	private static Stream<EObject> streamWhileNotCanceled(IProgressMonitor monitor, SystemInstance instance) {
		return StreamSupport.stream(new Spliterators.AbstractSpliterator<EObject>(Long.MAX_VALUE, Spliterator.ORDERED) {
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
	}

	private static <T> Stream<T> filterByType(Stream<?> unfiltered, Class<T> type) {
		return unfiltered.filter(element -> type.isInstance(element)).map(element -> type.cast(element));
	}

	public static class Issue {
		public final InstanceObject target;
		public final String message;

		private Issue(InstanceObject target, String message) {
			this.target = target;
			this.message = message;
		}
	}
}