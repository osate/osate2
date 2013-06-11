package org.osate.xtext.aadl2.properties.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
		 * @param componentInstance
		 * @param processor
		 * @return
		 */
		public static boolean isBoundToProcessor(ComponentInstance componentInstance, ComponentInstance processor){
				List<ComponentInstance> bindinglist = GetProperties.getActualProcessorBinding(componentInstance);
			for (ComponentInstance boundCompInstance : bindinglist) {
				if (isVirtualProcessor(boundCompInstance)){
					// it is bound to or contained in
					if (isBoundToProcessor(boundCompInstance,processor) || contains(processor,boundCompInstance)){
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
					return getContainingProcessor(boundCompInstance);
				} else {
					return boundCompInstance;
				}
			}
			return null;
		}

		/**
		 * returns true if container contains contained as instance.
		 * @param container InstanceObject
		 * @param contained InstanceObject
		 * @return boolean
		 */
		public static boolean contains(InstanceObject container, InstanceObject contained){
			while (contained != null ){
				if (contained == container){
					return true;
				}
				contained = (InstanceObject)contained.getOwner();
			}
			return false;
		}

		/**
		 * returns containing processor instance.
		 * @param vprocessor
		 * @return ComponentInstance processor
		 */
		public static ComponentInstance getContainingProcessor(ComponentInstance vprocessor){
			ComponentInstance res = vprocessor;
			while (res != null ){
				if (isProcessor(res)){
					return res;
				}
				res = res.getContainingComponentInstance();
			}
			return null;
		}
		
		/**
		 * get all components bound to the given component
		 * @param procorVP
		 * @return
		 */
		public static EList<ComponentInstance> getBoundComponents(final ComponentInstance procorVP){
			SystemInstance root = procorVP.getSystemInstance();
			EList boundComponents = new ForAllElement() {
				@Override
				protected boolean suchThat(Element obj) {
					return InstanceModelUtil.isBoundToProcessor((ComponentInstance) obj, procorVP);
				}
			}.processPreOrderComponentInstance(root,ComponentCategory.THREAD);
			return boundComponents;
		}


		/**
		 * true if component instance is directly bound to the processor
		 * the component instance can be a thread, process, or a virtual processor instance
		 * @param componentInstance
		 * @param processor
		 * @return
		 */
		public static boolean isDirectlyBoundToProcessor(ComponentInstance componentInstance, ComponentInstance processor){
			List<ComponentInstance> bindinglist= GetProperties.getActualProcessorBinding(componentInstance);
			for (ComponentInstance boundComponentInstance : bindinglist) {
				if (boundComponentInstance == processor){
					return true;
				}
			}
			return false;
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
		  	List<ComponentInstance> bindinglist= GetProperties.getActualConnectionBinding(boundObject);
		  	if (bindinglist.isEmpty()&& isVirtualBus(boundObject)){
		  		if (Aadl2InstanceUtil.containedIn(boundObject, bus)){
		  			return true;
		  		}
		  	}
		  	for (ComponentInstance boundComponentInstance : bindinglist) {
				if (isVirtualBus(boundComponentInstance)){
					if (isBoundToBus(boundComponentInstance,bus)){
						return true;
					}
				} else if (boundComponentInstance == bus){
					return true;
				}
			}
		  return false;
	}

		/**
		 * true if connection/virtual bus instance is directly or indirectly bound to a bus
		 * It could be bound to a virtual bus which in turn is bound to a bus
		 * the connectionInstance can be a connection or a virtual bus instance
		 * @param boundObject
		 * @return
		 */
	  public static boolean isBoundToBus(InstanceObject boundObject){
		  		List<ComponentInstance> bindinglist = GetProperties.getActualConnectionBinding(boundObject);
			  	if (bindinglist.isEmpty()&& isVirtualBus(boundObject)){
			  		if (containedInBus(boundObject)){
			  			return true;
			  		}
			  	}
		  	for (ComponentInstance boundComponentInstance : bindinglist) {
				if (isVirtualBus(boundComponentInstance)){
					if (isBoundToBus(boundComponentInstance)){
						return true;
					}
				} else if (isBus(boundComponentInstance)){
					return true;
				}
			}
		  return false;
	}

		public static boolean containedInBus(InstanceObject element) {
			while (element != null) {
				if (isBus(element))
					return true;
				element = (InstanceObject) element.getOwner();
			}
			return false;
		}
		
		public static ComponentInstance getContainingBus(InstanceObject element) {
			while (element != null) {
				if (isBus(element))
					return (ComponentInstance)element;
				element = (InstanceObject) element.getOwner();
			}
			return null;
		}
	  
		/**
		 * return list of component instances that the connection instance is bound to directly or indirectly
		 * the connectionInstance can be a connection or a virtual bus instance
		 * @param connectionInstance
		 * @return
		 */
	  public static EList<ComponentInstance> getRealConnectionBindings(InstanceObject connectionInstance){
		  EList<ComponentInstance> result = new BasicEList<ComponentInstance>();
		  return getRealConnectionBindings(connectionInstance, result);
	}
	  private static EList<ComponentInstance> getRealConnectionBindings(InstanceObject boundObject, EList<ComponentInstance> result){
		  List<ComponentInstance> bindinglist = GetProperties.getActualConnectionBinding(boundObject);
		  if (bindinglist.isEmpty()&& isVirtualBus(boundObject)){
			  ComponentInstance bindingTarget = getContainingBus(boundObject);
			  if (bindingTarget != null){
				  result.add(bindingTarget);
				  return result;
			  }
		  }
		  for (ComponentInstance boundComponentInstance : bindinglist) {
			  if (isVirtualBus(boundComponentInstance)){
				  getRealConnectionBindings(boundObject,result);
			  } else if (isBus(boundComponentInstance)){
				  result.add(boundComponentInstance);
			  }
		  }
		  return result;
	  }



	  /**
	   * true if component instance is directly bound to the bus
		 * the component instance can be a connection or a virtual bus instance
		 * @param boundObject
		 * @param processor
		 * @return
		 */
	  public static boolean isDirectlyBoundToBus(InstanceObject boundObject, ComponentInstance bus){
		  		List<ComponentInstance> bindinglist = GetProperties.getActualConnectionBinding(boundObject);
			  	if (bindinglist.isEmpty()&& isVirtualBus(boundObject)){
			  		if (containedInBus(boundObject)){
			  			return true;
			  		}
			  	}
		  	for (ComponentInstance componentInstance : bindinglist) {
				if (componentInstance == bus){
					return true;
				}
			}
		  return false;
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

}
