/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.properties.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.contrib.aadlproject.SupportedDispatchProtocols;
import org.osate.aadl2.contrib.communication.CommunicationProperties;
import org.osate.aadl2.contrib.communication.Timing;
import org.osate.aadl2.contrib.deployment.DeploymentProperties;
import org.osate.aadl2.contrib.thread.ThreadProperties;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;

public class InstanceModelUtil {

	/* XXX: Where to put this? */
	private static final <V> boolean propertyEquals(final Function<NamedElement, Optional<V>> f, final NamedElement ne,
			final V value) {
		return f.apply(ne).map(x -> x == value).orElse(false);
	}

	/* XXX: WHere to put this? */
	private static final List<ComponentInstance> getListAsComponentInstance(
			final Function<NamedElement, Optional<List<InstanceObject>>> f, final NamedElement ne) {
		return f.apply(ne).map(v -> {
			final List<ComponentInstance> list = new ArrayList<>(v.size());
			v.forEach(x -> list.add((ComponentInstance) x));
			return list;
		}).orElse(Collections.emptyList());
	}

	/**
	 * true if connection is delayed connection (Timing property on connection)
	 * @param conn
	 * @return
	 */
	public static boolean isDelayedPortConnection(final ConnectionInstance conn) {
		if ((conn == null) ? false : conn.getKind() == ConnectionKind.PORT_CONNECTION) {
			return propertyEquals(CommunicationProperties::getTiming, conn, Timing.DELAYED);
		}
		return false;
	}

	/**
	 * true if a sampled connection (Timing property set no no Timing value (default Sampled)
	 * @param conn
	 */
	public static boolean isSampledPortConnection(final ConnectionInstance conn) {
		if ((conn == null) ? false : conn.getKind() == ConnectionKind.PORT_CONNECTION) {
			return propertyEquals(CommunicationProperties::getTiming, conn, Timing.SAMPLED);
		}
		return false;
	}

	/**
	 * true if connection is immediate connection (Timing property on connection)
	 * @param conn
	 */
	public static boolean isImmediatePortConnection(final ConnectionInstance conn) {
		if ((conn == null) ? false : conn.getKind() == ConnectionKind.PORT_CONNECTION) {
			return propertyEquals(CommunicationProperties::getTiming, conn, Timing.IMMEDIATE);
		}
		return false;
	}

	/**
	 * true if the connection is a port connection
	 * @param conn
	 * @return
	 */
	public static boolean isPortConnection(final ConnectionInstance conn) {
		return (conn == null) ? false : conn.getKind() == ConnectionKind.PORT_CONNECTION;
	}

	/**
	 * true is event data port connection. Determined by destination feature
	 * @param conn
	 * @return
	 */
	public static boolean isEventDataConnection(final ConnectionInstance conn) {
		if (conn == null) {
			return false;
		}
		ConnectionInstanceEnd cie = conn.getDestination();
		if (cie instanceof FeatureInstance) {
			return ((FeatureInstance) cie).getCategory() == FeatureCategory.EVENT_DATA_PORT;
		}
		return false;
	}

	/**
	 * true is event port connection. Determined by destination feature
	 * @param conn
	 * @return
	 */
	public static boolean isEventConnection(final ConnectionInstance conn) {
		if (conn == null) {
			return false;
		}
		ConnectionInstanceEnd cie = conn.getDestination();
		if (cie instanceof FeatureInstance) {
			return ((FeatureInstance) cie).getCategory() == FeatureCategory.EVENT_PORT;
		}
		return false;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category thread or a ThreadSubcomponent
	 * @param thread
	 * @return
	 */
	public static boolean isThread(final NamedElement thread) {
		return ((thread instanceof ComponentInstance)
				&& (((ComponentInstance) thread).getCategory() == ComponentCategory.THREAD))
				|| thread instanceof ThreadSubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category device or a DeviceSubcomponent
	 * @param device
	 * @return
	 */
	public static boolean isDevice(final NamedElement device) {
		return ((device instanceof ComponentInstance)
				&& (((ComponentInstance) device).getCategory() == ComponentCategory.DEVICE))
				|| device instanceof DeviceSubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category bus or a BusSubcomponent
	 * @param bus
	 * @return
	 */
	public static boolean isBus(final NamedElement bus) {
		return ((bus instanceof ComponentInstance)
				&& (((ComponentInstance) bus).getCategory() == ComponentCategory.BUS))
				|| bus instanceof BusSubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category bus or a BusSubcomponent
	 * @param bus
	 * @return
	 */
	public static boolean isBusAccessConnection(final ConnectionInstance conni) {
		return ((conni.getSource() instanceof FeatureInstance
				&& ((FeatureInstance) conni.getSource()).getFeature() instanceof BusAccess)
				|| (conni.getDestination() instanceof FeatureInstance
						&& ((FeatureInstance) conni.getDestination()).getFeature() instanceof BusAccess));

	}

	/**
	 * true of NamedElement is a ComponentInstance of category virtual bus or a VirtualBusSubcomponent
	 * @param vbus
	 * @return
	 */
	public static boolean isVirtualBus(final NamedElement vbus) {
		return ((vbus instanceof ComponentInstance)
				&& (((ComponentInstance) vbus).getCategory() == ComponentCategory.VIRTUAL_BUS))
				|| vbus instanceof VirtualBusSubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category processor or a ProcessorSubcomponent
	 * @param vprocessor
	 * @return
	 */
	public static boolean isVirtualProcessor(final NamedElement vprocessor) {
		return ((vprocessor instanceof ComponentInstance)
				&& (((ComponentInstance) vprocessor).getCategory() == ComponentCategory.VIRTUAL_PROCESSOR))
				|| vprocessor instanceof VirtualProcessorSubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category virtual processor or a VirtualProcessorSubcomponent
	 * @param processor
	 * @return
	 */
	public static boolean isProcessor(final NamedElement processor) {
		return ((processor instanceof ComponentInstance)
				&& (((ComponentInstance) processor).getCategory() == ComponentCategory.PROCESSOR))
				|| processor instanceof ProcessorSubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category memory or a MemorySubcomponent
	 * @param memory
	 * @return
	 */
	public static boolean isMemory(final NamedElement memory) {
		return ((memory instanceof ComponentInstance)
				&& (((ComponentInstance) memory).getCategory() == ComponentCategory.MEMORY))
				|| memory instanceof MemorySubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category system or a SystemSubcomponent
	 * @param system
	 * @return
	 */
	public static boolean isSystem(final NamedElement system) {
		return ((system instanceof ComponentInstance)
				&& (((ComponentInstance) system).getCategory() == ComponentCategory.SYSTEM))
				|| system instanceof SystemSubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category system or a SystemSubcomponent
	 * @param system
	 * @return
	 */
	public static boolean isAbstract(final NamedElement system) {
		return ((system instanceof ComponentInstance)
				&& (((ComponentInstance) system).getCategory() == ComponentCategory.ABSTRACT))
				|| system instanceof AbstractSubcomponent;
	}

	/**
	 * true of NamedElement is a ComponentInstance of category process or a ProcessSubcomponent
	 * @param process
	 * @return
	 */
	public static boolean isProcess(final NamedElement process) {
		return ((process instanceof ComponentInstance)
				&& (((ComponentInstance) process).getCategory() == ComponentCategory.PROCESS))
				|| process instanceof ProcessSubcomponent;
	}

	/**
	 * true if component (thread or device) is periodic
	 * @param subcomponent
	 * @return
	 */
	public static boolean isPeriodicComponent(final NamedElement subcomponent) {
		return propertyEquals(ThreadProperties::getDispatchProtocol, subcomponent, SupportedDispatchProtocols.PERIODIC);
	}

	/**
	 * true if component (thread or device) is aperiodic
	 * @param subcomponent
	 * @return
	 */
	public static boolean isAperiodicComponent(final NamedElement subcomponent) {
		return propertyEquals(ThreadProperties::getDispatchProtocol, subcomponent,
				SupportedDispatchProtocols.APERIODIC);
	}

	/**
	 * true if component (thread or device) is sporadic
	 * @param subcomponent
	 * @return
	 */
	public static boolean isSporadicComponent(final NamedElement subcomponent) {
		return propertyEquals(ThreadProperties::getDispatchProtocol, subcomponent, SupportedDispatchProtocols.SPORADIC);
	}

	/**
	 * true if component (thread or device) is timed
	 * @param subcomponent
	 * @return
	 */
	public static boolean isTimedComponent(final NamedElement subcomponent) {
		return propertyEquals(ThreadProperties::getDispatchProtocol, subcomponent, SupportedDispatchProtocols.TIMED);
	}

	/**
	 * true if component (thread or device) is hybrid
	 * @param subcomponent
	 * @return
	 */
	public static boolean isHybridComponent(final NamedElement subcomponent) {
		return propertyEquals(ThreadProperties::getDispatchProtocol, subcomponent, SupportedDispatchProtocols.HYBRID);
	}

	/**
	 * true if component (thread or device) is background
	 * @param subcomponent
	 * @return
	 */
	public static boolean isBackgroundComponent(final NamedElement subcomponent) {
		return propertyEquals(ThreadProperties::getDispatchProtocol, subcomponent,
				SupportedDispatchProtocols.BACKGROUND);
	}

	/**
	 * true thread is periodic
	 * @param subcomponent
	 * @return
	 */
	public static boolean isPeriodicThread(final NamedElement thread) {
		return isThread(thread) && isPeriodicComponent(thread);
	}

	/**
	 * true if device is periodic
	 * @param subcomponent
	 * @return
	 */
	public static boolean isPeriodicDevice(final NamedElement device) {
		return (device instanceof ComponentInstance
				&& ((ComponentInstance) device).getCategory().equals(ComponentCategory.DEVICE))
				&& isPeriodicComponent(device);
	}

	/**
	 * true if component instance is directly or indirectly bound to the processor
	 * It could be bound to a virtual processor which in turn is bound to a processor
	 * the component instance can be a thread, process, or a virtual processor instance
	 * @param componentInstance component or VP
	 * @param processor or VP
	 * @return
	 */
	public static boolean isBoundToProcessor(ComponentInstance componentInstance, ComponentInstance processor) {
		/**
		 * We consider that a virtual processor is bound to a processor
		 * if the virtual processor is contained as a subcomponent.
		 */
		if ((componentInstance.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
				&& (getEnclosingProcessor(componentInstance) == processor)) {
			return true;
		}

		List<InstanceObject> bindinglist = canHaveActualProcessorBinding(componentInstance)
				? getProcessorBindings(componentInstance)
				: Collections.emptyList();
		for (final InstanceObject boundCompInstance : bindinglist) {
			if (boundCompInstance == processor) {
				return true;
			} else if (isVirtualProcessor(boundCompInstance)) {
				// it is bound to or contained in
				if (isBoundToProcessor((ComponentInstance) boundCompInstance, processor)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * return the list of system that the functional component is directly bound to.
	 *
	 * <p>This method copies a list internally for the sole purpose of changing the type
	 * from {@code List<InstanceObject>} to {@code List<ComponentInstance>}.  Please use
	 * {@link #getFunctionBindings} and change the call site to handle {@code InstanceObject}
	 * to avoid this.
	 *
	 * @param io
	 * @return list of system component instances
	 * @deprecated To be removed in 2.10.0.  Please use {@link #getFunctionBindings}.
	 */
	@Deprecated
	public static List<ComponentInstance> getFunctionBinding(final ComponentInstance io) {
		return getListAsComponentInstance(DeploymentProperties::getActualFunctionBinding, io);
	}

	/**
	 * return the list of system that the functional component is directly bound to.
	 * @param io
	 * @return list of system component instances
	 * @since 3.1
	 */
	public static List<InstanceObject> getFunctionBindings(final ComponentInstance io) {
		return DeploymentProperties.getActualFunctionBinding(io).orElse(Collections.emptyList());
	}

	/**
	 * return the processor or virtual processor that the component is directly bound to
	 *
	 * <p>This method recopies a list internally for the sole purpose of changing the type
	 * from {@code List<InstanceObject>} to {@code List<ComponentInstance>}.  Please use
	 * {@link #getFunctionBindings} and change the call site to handle {@code InstanceObject}
	 * to avoid this.
	 *
	 * @param io
	 * @return
	 * @deprecated To be removed in 2.10.0.  Please use {@link #getMemoryBindings}.
	 */
	@Deprecated
	public static List<ComponentInstance> getMemoryBinding(final ComponentInstance io) {
		return getListAsComponentInstance(DeploymentProperties::getActualMemoryBinding, io);
	}

	/**
	 * return the processor or virtual processor that the component is directly bound to
	 *
	 * @param io
	 * @return
	 * @since 3.1
	 */
	public static List<InstanceObject> getMemoryBindings(final ComponentInstance io) {
		return DeploymentProperties.getActualMemoryBinding(io).orElse(Collections.emptyList());
	}

	/**
	 * return the processor or virtual processor that the component is directly bound to
	 *
	 * <p>This method recopies a list internally for the sole purpose of changing the type
	 * from {@code List<InstanceObject>} to {@code List<ComponentInstance>}.  Please use
	 * {@link #getFunctionBindings} and change the call site to handle {@code InstanceObject}
	 * to avoid this.
	 *
	 * @param io
	 * @return
	 * @deprecated To be removed in 2.10.0.  Please use {@link #getProcessorBindings}.
	 */
	@Deprecated
	public static List<ComponentInstance> getProcessorBinding(final ComponentInstance io) {
		return getListAsComponentInstance(DeploymentProperties::getActualProcessorBinding, io);
	}

	/**
	 * return the processor or virtual processor that the component is directly bound to
	 *
	 * @param io
	 * @return
	 * @since 3.1
	 */
	public static List<InstanceObject> getProcessorBindings(final ComponentInstance io) {
		return DeploymentProperties.getActualProcessorBinding(io).orElse(Collections.emptyList());
	}

	/**
	 * return the hardware component of the connection instance end.
	 * If it is a hardware component or device return it.
	 * If it is a software component, return the processor it is bound to.
	 * If it is a component instance (BUS), return the bus
	 * If it is a DATA, SUBPROGRAM, or SUBPROGRAM GROUP component instance, then return the memory it is bound to.
	 * @param cie
	 * @return hw component instance
	 */
	public static ComponentInstance getHardwareComponent(ConnectionInstanceEnd cie) {
		ComponentInstance swci = null;
		if (cie instanceof FeatureInstance) {
			FeatureInstance fi = (FeatureInstance) cie;
			swci = fi.getContainingComponentInstance();
		} else if (cie instanceof ComponentInstance) {
			swci = (ComponentInstance) cie;
		}
		if (isDevice(swci) || isProcessor(swci) || isBus(swci) || isMemory(swci)) {
			return swci;
		}
		return getBoundPhysicalProcessor(swci);
	}

	private static boolean canHaveActualProcessorBinding(final ComponentInstance ci) {
		switch (ci.getCategory()) {
		case ABSTRACT:
		case THREAD:
		case THREAD_GROUP:
		case PROCESS:
		case SYSTEM:
		case VIRTUAL_PROCESSOR:
		case DEVICE:
			return true;
		default:
			return false;

		}
	}

	/**
	 * processor instance is directly or indirectly bound to the processor
	 * It could be bound to a virtual processor which in turn is bound to a processor
	 * the component instance can be a thread, process, or a virtual processor instance
	 * @param componentInstance
	 * @return processor instance
	 */
	public static ComponentInstance getBoundPhysicalProcessor(ComponentInstance componentInstance) {
		final List<InstanceObject> cil = canHaveActualProcessorBinding(componentInstance)
				? getProcessorBindings(componentInstance)
				: Collections.emptyList();
		if (cil.isEmpty()) {
			return null;
		}
		for (final InstanceObject ci : cil) {
			if (isProcessor(ci) || isSystem(ci) || isAbstract(ci)) {
				return (ComponentInstance) ci;
			}
		}
		for (final InstanceObject io : cil) {
			final ComponentInstance boundCompInstance = (ComponentInstance) io;
			if (isVirtualProcessor(boundCompInstance)) {
				// it is bound to or contained in
				ComponentInstance res = getBoundPhysicalProcessor(boundCompInstance);
				if (res == null) {
					// check whether VP is a subcomponent of a processor
					res = getEnclosingProcessor(boundCompInstance);
				}
				return res;
			}
		}
		return null;
	}

	public static ComponentInstance getEnclosingProcessor(ComponentInstance vpi) {
		ComponentInstance ci = vpi.getContainingComponentInstance();
		while (ci != null) {
			if (ci.getCategory().equals(ComponentCategory.PROCESSOR)) {
				return ci;
			}
			ci = ci.getContainingComponentInstance();
		}
		return null;
	}

	/**
	 * processor instance is directly or indirectly bound to the processor
	 * It could be bound to a virtual processor which in turn is bound to a processor
	 * the component instance can be a thread, process, or a virtual processor instance
	 * @param componentInstance
	 * @return processor instance
	 */
	public static Collection<ComponentInstance> getBoundPhysicalProcessors(ComponentInstance componentInstance) {
		final Collection<ComponentInstance> actualProcs = new HashSet<ComponentInstance>();
		if (canHaveActualProcessorBinding(componentInstance)) {
			addBoundProcessors(componentInstance, actualProcs);
		}
		return actualProcs;
	}

	protected static void addBoundProcessors(ComponentInstance componentInstance,
			Collection<ComponentInstance> result) {
		final List<InstanceObject> bindinglist = getProcessorBindings(componentInstance);
		for (InstanceObject io : bindinglist) {
			final ComponentInstance boundCompInstance = (ComponentInstance) io;
			if (isVirtualProcessor(boundCompInstance)) {
				// it is bound to or contained in
				addBoundProcessors(boundCompInstance, result);
			} else if (isProcessor(boundCompInstance) || isSystem(boundCompInstance) || isAbstract(boundCompInstance)) {
				result.add(boundCompInstance);
			}
			// we should not have another else
		}
		if (isVirtualProcessor(componentInstance)) {
			// check whether VP is a subcomponent of a processor
			ComponentInstance res = getEnclosingProcessor(componentInstance);
			if (res != null) {
				result.add(res);
			}

		}
	}

	/**
	 * virtual processor instances directly bound to by component
	 * @param componentInstance
	 * @return virtual processor instance
	 */
	public static Collection<ComponentInstance> getBoundVirtualProcessors(ComponentInstance componentInstance) {
		final Collection<ComponentInstance> actualProcs = new HashSet<ComponentInstance>();
		if (canHaveActualProcessorBinding(componentInstance)) {
			addBoundVirtualProcessors(componentInstance, actualProcs, false);
		}
		return actualProcs;
	}

	/**
	 * virtual processor instances directly or indirectly bound to by component
	 * @param componentInstance
	 * @return virtual processor instance
	 */
	public static Collection<ComponentInstance> getAllBoundVirtualProcessors(ComponentInstance componentInstance) {
		final Collection<ComponentInstance> actualProcs = new ArrayList<ComponentInstance>();
		if (canHaveActualProcessorBinding(componentInstance)) {
			addBoundVirtualProcessors(componentInstance, actualProcs, true);
		}
		return actualProcs;
	}

	protected static void addBoundVirtualProcessors(ComponentInstance componentInstance,
			Collection<ComponentInstance> result, boolean doAll) {
		final Collection<InstanceObject> bindinglist = getProcessorBindings(componentInstance);
		for (final InstanceObject io : bindinglist) {
			final ComponentInstance boundCompInstance = (ComponentInstance) io;
			if (isVirtualProcessor(boundCompInstance)) {
				result.add(boundCompInstance);
				if (doAll) {
					addBoundVirtualProcessors(boundCompInstance, result, doAll);
				}
			}
		}
	}

	/**
	 * @deprecated
	 */
	@Deprecated(since = "3.2.1")
	public static void clearCache() {
		// cache has been removed
	}

	/**
	 * get all top level SW components bound to the given processor or VP component
	 * The list contains only the top component if a component and its children are bound
	 * to the same processor.
	 * @param procorVP
	 * @return
	 */
	public static EList<ComponentInstance> getBoundSWComponents(final ComponentInstance associatedObject) {
		EList<Element> boundComponents = null;
		SystemInstance root = associatedObject.getSystemInstance();

		if ((associatedObject.getCategory() == ComponentCategory.PROCESSOR)
				|| (associatedObject.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)) {
			boundComponents = new ForAllElement() {
				@Override
				protected boolean suchThat(Element obj) {
					ComponentInstance ci = (ComponentInstance) obj;
					ComponentCategory cat = ci.getCategory();
					return ((cat == ComponentCategory.THREAD || cat == ComponentCategory.THREAD_GROUP
							|| cat == ComponentCategory.PROCESS || cat == ComponentCategory.SYSTEM)
							&& InstanceModelUtil.isBoundToProcessor((ComponentInstance) obj, associatedObject));
				}
			}.processPreOrderComponentInstance(root);
		}

		if (associatedObject.getCategory() == ComponentCategory.MEMORY) {
			boundComponents = new ForAllElement() {
				@Override
				protected boolean suchThat(Element obj) {
					return DeploymentProperties.getActualMemoryBinding((ComponentInstance) obj)
							.map(boundMemoryList -> !boundMemoryList.isEmpty()
									&& boundMemoryList.get(0) == associatedObject)
							.orElse(false);
				}
				// process bottom up so we can check whether children had budgets
			}.processPostOrderComponentInstance(root);
		}

		EList<ComponentInstance> topobjects = new BasicEList<ComponentInstance>();
		for (Object componentInstance : boundComponents) {
			addAsRoot(topobjects, (ComponentInstance) componentInstance);
		}
		return topobjects;
	}

	/**
	 * get all SW components bound to the given processor or VP component
	 * This includes the children of a component that is bound as the binding property is inherited.
	 * @param procorVP
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static EList<ComponentInstance> getAllBoundSWComponents(final ComponentInstance procorVP) {
		SystemInstance root = procorVP.getSystemInstance();
		EList boundComponents = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				ComponentInstance ci = (ComponentInstance) obj;
				ComponentCategory cat = ci.getCategory();
				return ((cat == ComponentCategory.THREAD || cat == ComponentCategory.THREAD_GROUP
						|| cat == ComponentCategory.PROCESS || cat == ComponentCategory.SYSTEM)
						&& InstanceModelUtil.isBoundToProcessor((ComponentInstance) obj, procorVP));
			}
		}.processPreOrderComponentInstance(root);
		return boundComponents;
	}

	/**
	 * get all threads bound to the given component
	 * @param procorVP
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static EList<ComponentInstance> getBoundThreads(final ComponentInstance procorVP) {
		SystemInstance root = procorVP.getSystemInstance();
		EList boundComponents = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				ComponentInstance ci = (ComponentInstance) obj;
				ComponentCategory cat = ci.getCategory();
				return ((cat == ComponentCategory.THREAD)
						&& InstanceModelUtil.isBoundToProcessor((ComponentInstance) obj, procorVP));
			}
		}.processPreOrderComponentInstance(root);
		return boundComponents;
	}

	/**
	 * get all processes bound to the given component
	 * @param procorVP
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static EList<ComponentInstance> getBoundProcesses(final ComponentInstance procorVP) {
		SystemInstance root = procorVP.getSystemInstance();
		EList boundComponents = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				ComponentInstance ci = (ComponentInstance) obj;
				ComponentCategory cat = ci.getCategory();
				return ((cat == ComponentCategory.PROCESS)
						&& InstanceModelUtil.isBoundToProcessor((ComponentInstance) obj, procorVP));
			}
		}.processPreOrderComponentInstance(root);
		return boundComponents;
	}

	public static void addAsRoot(EList<ComponentInstance> blist, ComponentInstance ci) {
		BasicEList<ComponentInstance> removeme = new BasicEList<ComponentInstance>();
		for (ComponentInstance bi : blist) {
			if (AadlUtil.containedIn(ci, bi)) {
				return;
			}
			if (AadlUtil.containedIn(bi, ci)) {
				removeme.add(bi);
			}
		}
		if (!removeme.isEmpty()) {
			blist.removeAll(removeme);
		}
		blist.add(ci);
	}

	/**
	 * true if connection or virtual bus instance is directly or indirectly bound to the bus
	 * It could be bound to a virtual bus which in turn is bound to a bus
	 * the connectionInstance can be a connection or a virtual bus instance
	 * @param boundObject
	 * @param bus
	 * @return
	 */
	public static boolean isBoundToBus(InstanceObject boundObject, ComponentInstance bus) {
		List<InstanceObject> bindinglist = getConnectionBindings(boundObject);
		for (InstanceObject boundCompInstance : bindinglist) {
			if (isVirtualProcessor(boundCompInstance)) {
				// it is bound to or contained in
				if (isBoundToBus(boundCompInstance, bus)) {
					return true;
				}
			} else if (boundCompInstance == bus) {
				return true;
			}
		}
		return false;
	}

	/**
	 * true if connection or virtual bus instance has connection binding
	 * @param boundObject
	 * @return
	 */
	public static boolean hasBusBinding(InstanceObject boundObject) {
		return !getConnectionBindings(boundObject).isEmpty();
	}

	/**
	 * return set of components the specified instance object (connection or virtual bus) is bound to.
	 * Takes into account virtual buses contained in buses or virtual buses
	 *
	 * <p>This method copies a list internally for the sole purpose of changing the type
	 * from {@code List<InstanceObject>} to {@code List<ComponentInstance>}.  Please use
	 * {@link #getConnectionBindings} and change the call site to handle {@code InstanceObject}
	 * to avoid this.
	 *
	 * @param io
	 * @return
	 *
	 * @deprecated To be removed in 2.10.0.  Use {@link #getConnectionBindings(InstanceObject)
	 */
	@Deprecated
	public static List<ComponentInstance> getConnectionBinding(final InstanceObject io) {
		final List<ComponentInstance> bindinglist = getListAsComponentInstance(
				DeploymentProperties::getActualConnectionBinding, io);
		/**
		 * If we have a virtual bus, we consider that it is bound to
		 * its containing bus. Semantically, we thus consider
		 * that all contained virtual bus are bound to the enclosing
		 * physical bus or VB. Then, we add it in the list.
		 */
		if (bindinglist.isEmpty() && io instanceof ComponentInstance
				&& ((ComponentInstance) io).getCategory() == ComponentCategory.VIRTUAL_BUS) {
			ComponentInstance parent = io.getContainingComponentInstance();
			if (parent.getCategory() == ComponentCategory.BUS
					|| parent.getCategory() == ComponentCategory.VIRTUAL_BUS) {
				return Collections.singletonList(parent);
			}
		}
		return bindinglist;
	}

	/**
	 * return set of components the specified instance object (connection or virtual bus) is bound to.
	 * Takes into account virtual buses contained in buses or virtual buses
	 * @param io
	 * @return
	 * @since 3.1
	 */
	public static List<InstanceObject> getConnectionBindings(final InstanceObject io) {
		final List<InstanceObject> bindinglist = DeploymentProperties.getActualConnectionBinding(io)
				.orElse(Collections.emptyList());
		/**
		 * If we have a virtual bus, we consider that it is bound to
		 * its containing bus. Semantically, we thus consider
		 * that all contained virtual bus are bound to the enclosing
		 * physical bus or VB. Then, we add it in the list.
		 */
		if (bindinglist.isEmpty() && io instanceof ComponentInstance
				&& ((ComponentInstance) io).getCategory() == ComponentCategory.VIRTUAL_BUS) {
			ComponentInstance parent = io.getContainingComponentInstance();
			if (parent.getCategory() == ComponentCategory.BUS
					|| parent.getCategory() == ComponentCategory.VIRTUAL_BUS) {
				return Collections.singletonList(parent);
			}
		}
		return bindinglist;
	}

	/**
	 * HW instances that connection instance is directly or indirectly bound to
	 * It could be bound to a virtual bus which in turn is bound to a bus
	 * or a device, processor, memory
	 * @param connectionInstance
	 * @return list of hardware components involved in connection binding
	 */
	public static List<ComponentInstance> getPhysicalConnectionBinding(ConnectionInstance connectionInstance) {
		final List<ComponentInstance> actualHW = new ArrayList<ComponentInstance>();
		addPhysicalConnectionBinding(connectionInstance, actualHW);
		return actualHW;
	}

	protected static void addPhysicalConnectionBinding(InstanceObject VBorConni, Collection<ComponentInstance> result) {
		List<InstanceObject> bindinglist = getConnectionBindings(VBorConni);
		for (InstanceObject boundCompInstance : bindinglist) {
			if (isVirtualBus(boundCompInstance)) {
				// it is bound to or contained in
				addPhysicalConnectionBinding(boundCompInstance, result);
			} else {
				result.add((ComponentInstance) boundCompInstance);
			}
		}
	}

	/**
	 * get all connections bound to the given bus or virtual bus
	 * @param busorVB
	 * @return
	 */
	public static EList<ConnectionInstance> getBoundConnections(final ComponentInstance busorVB) {
		EList<ConnectionInstance> result;
		EList<ConnectionInstance> connections;
		SystemInstance root;

		result = new BasicEList<ConnectionInstance>();
		root = busorVB.getSystemInstance();
		connections = root.getAllConnectionInstances();
		for (ConnectionInstance connectionInstance : connections) {

			if (InstanceModelUtil.isBoundToBus(connectionInstance, busorVB) ||
			// we derived a bus connection from the connection end bindings
					(!InstanceModelUtil.hasBusBinding(connectionInstance)
							&& InstanceModelUtil.connectedByBus(connectionInstance, busorVB))) {
				result.add(connectionInstance);
			}

		}
		return result;
	}

	/**
	 * get all virtual buses bound to the given bus or virtual bus
	 * @param busorVB
	 * @return
	 * @since 1.2
	 */
	public static EList<ComponentInstance> getBoundVirtualBuses(final ComponentInstance busorVB) {
		final SystemInstance root = busorVB.getSystemInstance();
		final EList<ComponentInstance> virtualBuses = root.getAllComponentInstances(ComponentCategory.VIRTUAL_BUS);
		final EList<ComponentInstance> result = new BasicEList<ComponentInstance>();
		for (ComponentInstance ci : virtualBuses) {
			if (InstanceModelUtil.isBoundToBus(ci, busorVB)) {
				result.add(ci);
			}
		}
		return result;
	}

	/**
	 * Get the component that is connected at the source side of the connection.
	 * @param connectionInstance - the connection to process
	 * @return - the component that is the source
	 */
	public static ComponentInstance getRelatedComponentSource(ConnectionInstance connectionInstance) {
		ConnectionInstanceEnd sourceEnd;
		ComponentInstance source;

		source = null;
		sourceEnd = connectionInstance.getSource();

		if (!(sourceEnd instanceof ComponentInstance)) {
			source = sourceEnd.getContainingComponentInstance();
		} else {
			source = (ComponentInstance) sourceEnd;
		}
		return source;
	}

	/**
	 * Get the component that is connected at the destination side of the connection.
	 * @param connectionInstance - the connection to be processed
	 * @return - the component that is the connection destination (and not its feature)
	 */
	public static ComponentInstance getRelatedComponentDestination(ConnectionInstance connectionInstance) {
		ConnectionInstanceEnd destinationEnd;
		ComponentInstance destination = null;
		destinationEnd = connectionInstance.getDestination();

		if (!(destinationEnd instanceof ComponentInstance)) {
			destination = destinationEnd.getContainingComponentInstance();
		} else {
			destination = (ComponentInstance) destinationEnd;
		}
		return destination;
	}

	/**
	 * true if the processor of the port connection source is connected to the
	 * specified bus
	 *
	 * @param pci
	 * @param curBus
	 * @return
	 */
	public static boolean connectedByBus(ConnectionInstance pci, ComponentInstance curBus) {
		ComponentInstance srcHW = getHardwareComponent(pci.getSource());
		ComponentInstance dstHW = getHardwareComponent(pci.getDestination());
		if (srcHW == null || dstHW == null || srcHW == dstHW) {
			return false;
		}

		return connectedToBus(srcHW, curBus) && connectedToBus(dstHW, curBus);
	}

	/**
	 * Get the bus for a connection. If the bus is not found, we try
	 * to get the bus by inspecting the component bound (processor)
	 * to each part of the connection (thread/process/device).
	 *
	 * If the connection is directly bound to a bus through the property
	 * mechanism, we automatically return it.
	 *
	 * @param connectionInstance - the connection instance
	 * @return the bus bound to the connection.
	 */
	public static List<ComponentInstance> deriveBoundBuses(ConnectionInstance connectionInstance) {
		ComponentInstance srcHW = getHardwareComponent(connectionInstance.getSource());
		ComponentInstance dstHW = getHardwareComponent(connectionInstance.getDestination());
		if (isBusAccessConnection(connectionInstance)) {
			return Collections.emptyList();
		}
		return connectedByBus(srcHW, dstHW);
	}

	/**
	 * returns list of buses connecting to HW components. Can be empty list (if
	 * same component), or null (no connection).
	 *
	 * @param source HW component
	 * @param destination HW component
	 * @return list of buses involved in the physical connection
	 */
	public static List<ComponentInstance> connectedByBus(ComponentInstance srcHW, ComponentInstance dstHW) {
		List<ComponentInstance> visitedBuses = new ArrayList<ComponentInstance>();
		return doConnectedByBus(srcHW, dstHW, visitedBuses);
	}

	/**
	 * returns list of buses connecting to HW components. Can be empty list (if
	 * same component), or null (no connection).
	 *
	 * @param source HW component
	 * @param destination HW component
	 * @return list of buses involved in the physical connection
	 */
	protected static List<ComponentInstance> doConnectedByBus(ComponentInstance srcHW, ComponentInstance dstHW,
			List<ComponentInstance> visitedBuses) {
		if (srcHW == null || dstHW == null || srcHW == dstHW) {
			return visitedBuses;
		}
		for (FeatureInstance fi : srcHW.getFeatureInstances()) {
			if (fi.getCategory() == FeatureCategory.BUS_ACCESS) {
				for (ConnectionInstance aci : fi.getDstConnectionInstances()) {
					ConnectionInstanceEnd src = aci.getSource();
					ComponentInstance curBus = src instanceof ComponentInstance ? (ComponentInstance) src
							: ((FeatureInstance) src).getComponentInstance();
					if (!visitedBuses.contains(curBus)) {
						if (connectedToBus(dstHW, curBus)) {
							List<ComponentInstance> res = new ArrayList<ComponentInstance>();
							res.add(curBus);
							return res;
						} else {
							// first check if there is a bus this bus is connected to
							visitedBuses.add(curBus);
							List<ComponentInstance> res = doConnectedByBus(curBus, dstHW, visitedBuses);
							if (res != null) {
								res.add(0, curBus);
								return res;
							} else {
								// check for buses that are connected to this bus
								for (ConnectionInstance srcaci : curBus.getSrcConnectionInstances()) {
									ComponentInstance bi = srcaci.getDestination().getContainingComponentInstance();
									if (bi.getCategory() == ComponentCategory.BUS) {
										if (connectedToBus(dstHW, bi)) {
											res = new BasicEList<ComponentInstance>();
											res.add(bi);
											return res;
										} else {
											visitedBuses.add(bi);
											res = doConnectedByBus(bi, dstHW, visitedBuses);
											if (res != null) {
												res.add(0, curBus);
												return res;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return visitedBuses;
	}

	/**
	 * list of buses the hardware component is directly connected to
	 *
	 * @param HWcomp ComponentInstance hardware component
	 * @return list of buses
	 */
	public static EList<ComponentInstance> getConnectedBuses(ComponentInstance HWcomp) {
		EList<ComponentInstance> result = new BasicEList<ComponentInstance>();
		EList<ConnectionInstance> acl = HWcomp.getSrcConnectionInstances();
		for (ConnectionInstance srcaci : acl) {
			ComponentInstance res = srcaci.getDestination().getComponentInstance();
			if (res.getCategory() == ComponentCategory.BUS) {
				result.add(res);
			}
		}
		// we have to check the connection the other way around. The bus be the source or destination
		acl = HWcomp.getDstConnectionInstances();
		for (ConnectionInstance dstaci : acl) {
			ComponentInstance res = dstaci.getSource().getComponentInstance();
			if (res.getCategory() == ComponentCategory.BUS) {
				result.add(res);
			}
		}
		return result;
	}

	/**
	* is hardware component connected (directly) to the given bus
	*
	* @param HWcomp ComponentInstance hardware component
	* @param bus ComponentInstance bus component
	* @return true if they are connected by bus access connection
	*/
	public static boolean connectedToBus(ComponentInstance HWcomp, ComponentInstance bus) {
		EList<ConnectionInstance> acl = bus.getSrcConnectionInstances();
		for (Iterator<ConnectionInstance> it = acl.iterator(); it.hasNext();) {
			ConnectionInstance srcaci = it.next();
			if (srcaci.getDestination().getContainingComponentInstance() == HWcomp) {
				return true;
			}
		}
		// we have to check the connection the other way around. The bus be the source or destination
		acl = bus.getDstConnectionInstances();
		for (Iterator<ConnectionInstance> it = acl.iterator(); it.hasNext();) {
			ConnectionInstance dstaci = it.next();
			if (dstaci.getSource().getContainingComponentInstance() == HWcomp) {
				return true;
			}
		}
		return false;
	}

	/**
	 * is hardware component connected (directly) to the given bus, incl. bus to
	 * bus
	 *
	 * @param HWcomp ComponentInstance hardware component
	 * @param bus ComponentInstance bus component
	 * @return access connection instance if they are connected by bus access
	 *         connection
	 */
	public static ConnectionInstance getBusAccessConnection(ComponentInstance HWcomp, ComponentInstance bus) {
		for (ConnectionInstance srcaci : bus.getSrcConnectionInstances()) {
			if (srcaci.getDestination().getContainingComponentInstance() == HWcomp) {
				return srcaci;
			}
		}
		// check the other way
		for (ConnectionInstance srcaci : HWcomp.getSrcConnectionInstances()) {
			if (srcaci.getDestination().getContainingComponentInstance() == bus) {
				return srcaci;
			}
		}
		return null;
	}

}
