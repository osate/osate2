package org.osate.xtext.aadl2.properties.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.Aadl2InstanceUtil;

public class InstanceModelUtil {
	
	/**
	 * true if the connection is a port connection
	 * @param conn
	 * @return
	 */
	public static  boolean isPortConnection(final ConnectionInstance conn){
		return conn.getKind() == ConnectionKind.PORT_CONNECTION;
	}
	
	/**
	 * true if connection is delayed connection (Timing property on connection)
	 * @param conn
	 * @return
	 */
	public static boolean isDelayedPortConnection(final ConnectionInstance conn){
		if (isPortConnection(conn)) {
			EList<ConnectionReference> cl = conn.getConnectionReferences();
			for (ConnectionReference cr : cl){
				Connection c = cr.getConnection();
				if ( c instanceof PortConnection){
					PortConnection pc =(PortConnection)c;
					EnumerationLiteral el = GetProperties.getConnectionTiming(pc);
					return el == GetProperties.getDelayedUnitLiteral(pc);
				}
			}
		}
		return false;
	}
	
	/**
	 * true if a sampled connection (Timing property set no no Timing value (default Sampled)
	 * @param conn
	 * @return
	 */
	public static boolean isSampledPortConnection(final ConnectionInstance conn){
		if (isPortConnection(conn)) {
			EList<ConnectionReference> cl = conn.getConnectionReferences();
			for (ConnectionReference cr : cl){
				Connection c = cr.getConnection();
				if ( c instanceof PortConnection){
					PortConnection pc =(PortConnection)c;
					EnumerationLiteral el = GetProperties.getConnectionTiming(pc);
					return el == null || el == GetProperties.getSampledUnitLiteral(pc);
				}
			}
		}
		return false;
	}
	
	/**
	 * true if connection is immediate connection (Timing property on connection)
	 * @param conn
	 * @return
	 */
	public static boolean isImmediatePortConnection(final ConnectionInstance conn){
		if (isPortConnection(conn)) {
			EList<ConnectionReference> cl = conn.getConnectionReferences();
			for (ConnectionReference cr : cl){
				Connection c = cr.getConnection();
				if ( c instanceof PortConnection){
					PortConnection pc =(PortConnection)c;
					EnumerationLiteral el = GetProperties.getConnectionTiming(pc);
					return el == GetProperties.getImmediateUnitLiteral(pc);
				}
			}
		}
		return false;
	}
	
	
	/**
	 * true is event data port connection. Determined by destination feature
	 * @param conn
	 * @return
	 */
	public  static  boolean isEventDataConnection(final ConnectionInstance conn){
			ConnectionInstanceEnd cie = conn.getDestination();
			if (cie instanceof FeatureInstance){
				return   ((FeatureInstance)cie).getCategory() == FeatureCategory.EVENT_DATA_PORT;
			}
			return false;
		}
	
	/**
	 * true is event port connection. Determined by destination feature
	 * @param conn
	 * @return
	 */
		public  static boolean isEventConnection(final ConnectionInstance conn){
			ConnectionInstanceEnd cie = conn.getDestination();
			if (cie instanceof FeatureInstance){
				return   ((FeatureInstance)cie).getCategory() == FeatureCategory.EVENT_PORT;
			}
			return false;
		}
	

		/**
		 * true of NamedElement is a ComponentInstance of category thread or a ThreadSubcomponent
		 * @param thread
		 * @return
		 */
			public static  boolean isThread(final NamedElement thread){
				return ((thread instanceof ComponentInstance)
						&& (((ComponentInstance) thread).getCategory() == ComponentCategory.THREAD))
						||thread instanceof ThreadSubcomponent;
			}

			/**
			 * true of NamedElement is a ComponentInstance of category device or a DeviceSubcomponent
			 * @param device
			 * @return
			 */
			public static  boolean isDevice(final NamedElement device){
				return ((device instanceof ComponentInstance)
						&& (((ComponentInstance) device).getCategory() == ComponentCategory.DEVICE))
						||device instanceof DeviceSubcomponent;
			}

			/**
			 * true of NamedElement is a ComponentInstance of category bus or a BusSubcomponent
			 * @param bus
			 * @return
			 */
			public static  boolean isBus(final NamedElement bus){
				return ((bus instanceof ComponentInstance)
						&& (((ComponentInstance) bus).getCategory() == ComponentCategory.BUS))
						||bus instanceof BusSubcomponent;
			}

			/**
			 * true of NamedElement is a ComponentInstance of category virtual bus or a VirtualBusSubcomponent
			 * @param vbus
			 * @return
			 */
			public static  boolean isVirtualBus(final NamedElement vbus){
				return ((vbus instanceof ComponentInstance)
						&& (((ComponentInstance) vbus).getCategory() == ComponentCategory.VIRTUAL_BUS))
						||vbus instanceof VirtualBusSubcomponent;
			}
			
			/**
			 * true of NamedElement is a ComponentInstance of category processor or a ProcessorSubcomponent
			 * @param vprocessor
			 * @return
			 */
			public static  boolean isVirtualProcessor(final NamedElement vprocessor){
				return ((vprocessor instanceof ComponentInstance)
						&& (((ComponentInstance) vprocessor).getCategory() == ComponentCategory.VIRTUAL_PROCESSOR))
						||vprocessor instanceof VirtualProcessorSubcomponent;
			}
			
			/**
			 * true of NamedElement is a ComponentInstance of category virtual processor or a VirtualProcessorSubcomponent
			 * @param processor
			 * @return
			 */
			public static  boolean isProcessor(final NamedElement processor){
				return ((processor instanceof ComponentInstance)
						&& (((ComponentInstance) processor).getCategory() == ComponentCategory.PROCESSOR))
						||processor instanceof ProcessorSubcomponent;
			}
			
			/**
			 * true of NamedElement is a ComponentInstance of category memory or a MemorySubcomponent
			 * @param memory
			 * @return
			 */
			public static  boolean isMemory(final NamedElement memory){
				return ((memory instanceof ComponentInstance)
						&& (((ComponentInstance) memory).getCategory() == ComponentCategory.MEMORY))
						||memory instanceof MemorySubcomponent;
			}
			
			/**
			 * true of NamedElement is a ComponentInstance of category system or a SystemSubcomponent
			 * @param system
			 * @return
			 */
			public static  boolean isSystem(final NamedElement system){
				return ((system instanceof ComponentInstance)
						&& (((ComponentInstance) system).getCategory() == ComponentCategory.SYSTEM))
						||system instanceof SystemSubcomponent;
			}
			
			/**
			 * true of NamedElement is a ComponentInstance of category process or a ProcessSubcomponent
			 * @param process
			 * @return
			 */
			public static  boolean isProcess(final NamedElement process){
				return ((process instanceof ComponentInstance)
						&& (((ComponentInstance) process).getCategory() == ComponentCategory.PROCESS))
						||process instanceof ProcessSubcomponent;
			}

		/**
		 * true if component (thread or device) is periodic
		 * @param subcomponent
		 * @return
		 */
		public static  boolean isPeriodicComponent(final NamedElement subcomponent){
			return isPeriodicThread(subcomponent) || isPeriodicDevice(subcomponent);
		}

		/**
		 * true thread is periodic
		 * @param subcomponent
		 * @return
		 */
		public static  boolean isPeriodicThread(final NamedElement thread){
			if (!isThread(thread)) return false;
			final EnumerationLiteral dp = GetProperties.getDispatchProtocol(thread);
			if (dp == null) return false;
			return  dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
		}

		/**
		 * true if device is periodic
		 * @param subcomponent
		 * @return
		 */
		public static  boolean isPeriodicDevice(final NamedElement device){
			if (device instanceof ComponentInstance && ((ComponentInstance)device).getCategory().equals(ComponentCategory.DEVICE)){
				final EnumerationLiteral dp = GetProperties.getDispatchProtocol(device);
				if (dp == null) return false;
				return  dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
			}
			return false;
		}


		/**
		 * true if component instance is directly or indirectly bound to the processor
		 * It could be bound to a virtual processor which in turn is bound to a processor
		 * the component instance can be a thread, process, or a virtual processor instance
		 * @param componentInstance component or VP
		 * @param processor or VP
		 * @return
		 */
		public static boolean isBoundToProcessor(ComponentInstance componentInstance, ComponentInstance processor){
			List<ComponentInstance> bindinglist = GetProperties.getActualProcessorBinding(componentInstance);
			for (ComponentInstance boundCompInstance : bindinglist) {
				if (isVirtualProcessor(boundCompInstance)){
					// it is bound to or contained in
					if (isBoundToProcessor(boundCompInstance,processor) ){
						return true;
					}
				} else if (boundCompInstance == processor){
					return true;
				}
			}
			return false;
		}


		/**
		 * processor instance is directly or indirectly bound to the processor
		 * It could be bound to a virtual processor which in turn is bound to a processor
		 * the component instance can be a thread, process, or a virtual processor instance
		 * @param componentInstance
		 * @return processor instance
		 */
		public static ComponentInstance getBoundProcessor(ComponentInstance componentInstance){
			List<ComponentInstance> bindinglist = GetProperties.getActualProcessorBinding(componentInstance);
			for (ComponentInstance boundCompInstance : bindinglist) {
				if (isVirtualProcessor(boundCompInstance)){
					// it is bound to or contained in
					ComponentInstance res = getBoundProcessor(boundCompInstance);
					if (res != null) return res;
				} else { // isProcessor
					return boundCompInstance;
				}
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
		public static Collection<ComponentInstance> getBoundProcessors(ComponentInstance componentInstance){
			final UniqueEList<ComponentInstance> actualProcs = new UniqueEList<ComponentInstance>();
			addBoundProcessors(componentInstance, actualProcs);
			return actualProcs;
		}
		
		protected static void addBoundProcessors(ComponentInstance componentInstance,UniqueEList<ComponentInstance> result){
			List<ComponentInstance> bindinglist = GetProperties.getActualProcessorBinding(componentInstance);
				for (ComponentInstance boundCompInstance : bindinglist) {
					if (isVirtualProcessor(boundCompInstance)){
						// it is bound to or contained in
						addBoundProcessors(boundCompInstance,result);
					} else if (isProcessor(boundCompInstance)){
							result.add(boundCompInstance);
					}
					// we should not have another else
				}
		}


		/**
		 * get all components bound to the given component
		 * @param procorVP
		 * @return
		 */
		public static EList<ComponentInstance> getBoundSWComponents(final ComponentInstance procorVP){
			SystemInstance root = procorVP.getSystemInstance();
			EList boundComponents = new ForAllElement() {
				@Override
				protected boolean suchThat(Element obj) {
					ComponentInstance ci = (ComponentInstance)obj;
					ComponentCategory cat = ci.getCategory();
					return ((cat == ComponentCategory.THREAD || cat == ComponentCategory.THREAD_GROUP || cat == ComponentCategory.PROCESS)
							&&InstanceModelUtil.isBoundToProcessor((ComponentInstance) obj, procorVP));
				}
			}.processPreOrderComponentInstance(root);//,ComponentCategory.THREAD);
			return boundComponents;
		}


		/**
		 * true if connection or virtual bus instance is directly or indirectly bound to the bus
		 * It could be bound to a virtual bus which in turn is bound to a bus
		 * the connectionInstance can be a connection or a virtual bus instance
		 * @param boundObject
		 * @param bus
		 * @return
		 */
	  public static boolean isBoundToBus(InstanceObject boundObject, ComponentInstance bus){
			List<ComponentInstance> bindinglist = GetProperties.getActualConnectionBinding(boundObject);
			for (ComponentInstance boundCompInstance : bindinglist) {
				if (isVirtualProcessor(boundCompInstance)){
					// it is bound to or contained in
					if (isBoundToBus(boundCompInstance,bus) ){
						return true;
					}
				} else if (boundCompInstance == bus){
					return true;
				}
			}
			return false;
	}

		/**
		 * HW instances that connection instnace is directly or indirectly bound to 
		 * It could be bound to a virtual bus which in turn is bound to a bus
		 * or a device, processor, memory
		 * @param connectionInstance
		 * @return list of hardware components involved in connection binding
		 */
		public static EList<ComponentInstance> getBoundConnectionHardware(ConnectionInstance connectionInstance){
			final UniqueEList<ComponentInstance> actualHW = new UniqueEList<ComponentInstance>();
			addBoundConnectionHardware(connectionInstance, actualHW);
			return actualHW;
		}
		
		protected static void addBoundConnectionHardware(InstanceObject VBorConni,UniqueEList<ComponentInstance> result){
			List<ComponentInstance> bindinglist = GetProperties.getActualConnectionBinding(VBorConni);
				for (ComponentInstance boundCompInstance : bindinglist) {
					if (isVirtualBus(boundCompInstance)){
						// it is bound to or contained in
						addBoundConnectionHardware(boundCompInstance,result);
					} else {
						result.add(boundCompInstance);
					}
				}
		}


		/**
		 * get all connections bound to the given bus or virtual bus
		 * @param busorVB
		 * @return
		 */
		public static EList<ConnectionInstance> getBoundConnections(final ComponentInstance busorVB){
			EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
			SystemInstance root = busorVB.getSystemInstance();
			EList<ConnectionInstance> connections = root.getAllConnectionInstances();
			for (ConnectionInstance connectionInstance : connections) {
				if (InstanceModelUtil.isBoundToBus(connectionInstance, busorVB)){
					result.add(connectionInstance);
				}
			}
			return result;
		}

	  
	  /**
	   * return the hardware component of the connection instance end.
	   * If its enclosing component is a hardware component or device return it. 
	   * If its enclosing component  is a software component, return the processor it is bound to.
	   * If its enclosing component is a software component, then look for the processor it is bound to.
	   * If it is a component instance (BUS), return the bus
	   * If it is a DATA, SUBPROGRAM, or SUBPROGRAM GROUP component instance, then return the memory it is bound to. 
	   * @param cie
	   * @return hw component instance
	   */
	  public static ComponentInstance getHardwareComponent(ConnectionInstanceEnd cie) {
			if (cie instanceof FeatureInstance) {
				FeatureInstance fi = (FeatureInstance) cie;
				ComponentInstance swci = fi.getContainingComponentInstance();
				if (isDevice(swci)||isBus(swci)||isProcessor(swci)||isMemory(swci)) {
					return swci;
				}
				return getBoundProcessor(swci);
			} else if (cie instanceof ComponentInstance){
				ComponentInstance ci = (ComponentInstance)cie;
				if (isBus(ci)){
					return ci;
				}
					List<ComponentInstance> ciList = GetProperties.getActualMemoryBinding(ci);
					return ciList.isEmpty() ? null : ciList.get(0);
			}
			return null;
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
			if (srcHW == null || dstHW == null || srcHW == dstHW)
				return false;

			return connectedToBus(srcHW, curBus) && connectedToBus(dstHW, curBus);
//			List<ComponentInstance> hwlist = connectedByBus(srcHW, dstHW);
//			return hwlist.contains(curBus);
		}


		/**
		 * figure out a hardware path from the endpoints without using connection binding information
		 * 
		 * @param conni
		 * @return
		 */
		public static List<ComponentInstance> connectedByHardware(ConnectionInstance conni) {
			ComponentInstance srcHW = getHardwareComponent(conni.getSource());
			ComponentInstance dstHW = getHardwareComponent(conni.getDestination());
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
			EList<ComponentInstance> visitedBuses = new UniqueEList<ComponentInstance>();
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
		protected static List<ComponentInstance> doConnectedByBus(ComponentInstance srcHW, ComponentInstance dstHW, EList<ComponentInstance> visitedBuses) {
			if (srcHW == null || dstHW == null)
				return visitedBuses;
			if (srcHW == dstHW)
				return visitedBuses;
			EList<FeatureInstance> busaccesslist = srcHW.getFeatureInstances();
			for (Iterator<FeatureInstance> it = busaccesslist.iterator(); it.hasNext();) {
				FeatureInstance fi = (FeatureInstance) it.next();
				if (fi.getCategory() == FeatureCategory.BUS_ACCESS) {
					for (ConnectionInstance aci : fi.getDstConnectionInstances()) {
						ComponentInstance curBus = (ComponentInstance) aci.getSource();
						if (!visitedBuses.contains(curBus)) {
							if (connectedToBus(dstHW, curBus)) {
								EList<ComponentInstance> res = new BasicEList<ComponentInstance>();
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
			return null;
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
