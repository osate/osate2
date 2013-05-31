package org.osate.xtext.aadl2.properties.util;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.properties.PropertyNotPresentException;

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
			List<ComponentInstance> bindinglist;
			//construct a new schedulable component, and put into the runTimeComponents only
			//when all the timing properties are not null ! except the ARC related properties.
			try
			{
				bindinglist = GetProperties.getActualProcessorBinding(componentInstance);
			}
			catch (PropertyNotPresentException e)
			{
				return false;
			}
			for (ComponentInstance boundCompInstance : bindinglist) {
				if (boundCompInstance.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR)){
					if (isBoundToProcessor(boundCompInstance,processor)){
						return true;
					}
				} else if (boundCompInstance == processor){
					return true;
				}
			}
			return false;
		}


		/**
		 * true if component instance is directly bound to the processor
		 * the component instance can be a thread, process, or a virtual processor instance
		 * @param componentInstance
		 * @param processor
		 * @return
		 */
		public static boolean isDirectlyBoundToProcessor(ComponentInstance componentInstance, ComponentInstance processor){
			List<ComponentInstance> bindinglist;
			//construct a new schedulable component, and put into the runTimeComponents only
			//when all the timing properties are not null ! except the ARC related properties.
			try
			{
				bindinglist = GetProperties.getActualProcessorBinding(componentInstance);
			}
			catch (PropertyNotPresentException e)
			{
				return false;
			}
			for (ComponentInstance boundComponentInstance : bindinglist) {
				if (boundComponentInstance == processor){
					return true;
				}
			}
			return false;
		}

		/**
		 * true if component instance is directly or indirectly bound to the bus
		 * It could be bound to a virtual bus which in turn is bound to a bus
		 * the connectionInstance can be a connection or a virtual bus instance
		 * @param connectionInstance
		 * @param bus
		 * @return
		 */
	  public static boolean isBoundToBus(InstanceObject connectionInstance, ComponentInstance bus){
		  	List<ComponentInstance> bindinglist;
		  	//construct a new schedulable component, and put into the runTimeComponents only
		  	//when all the timing properties are not null ! except the ARC related properties.
		  	try
		  	{
		  		bindinglist = GetProperties.getActualConnectionBinding((ConnectionInstance)connectionInstance);
		  	}
		  	catch (PropertyNotPresentException e)
		  	{
		  		return false;
		  	}
		  	for (ComponentInstance boundComponentInstance : bindinglist) {
				if (boundComponentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)){
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
		 * true if component instance is directly or indirectly bound to a bus
		 * It could be bound to a virtual bus which in turn is bound to a bus
		 * the connectionInstance can be a connection or a virtual bus instance
		 * @param connectionInstance
		 * @return
		 */
	  public static boolean isBoundToBus(InstanceObject connectionInstance){
		  	List<ComponentInstance> bindinglist;
		  	//construct a new schedulable component, and put into the runTimeComponents only
		  	//when all the timing properties are not null ! except the ARC related properties.
		  	try
		  	{
		  		bindinglist = GetProperties.getActualConnectionBinding((ConnectionInstance)connectionInstance);
		  	}
		  	catch (PropertyNotPresentException e)
		  	{
		  		return false;
		  	}
		  	for (ComponentInstance boundComponentInstance : bindinglist) {
				if (boundComponentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)){
					if (isBoundToBus(boundComponentInstance)){
						return true;
					}
				} else {
					return true;
				}
			}
		  return false;
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
	  private static EList<ComponentInstance> getRealConnectionBindings(InstanceObject connectionInstance, EList<ComponentInstance> result){
		  	List<ComponentInstance> bindinglist;
		  	//construct a new schedulable component, and put into the runTimeComponents only
		  	//when all the timing properties are not null ! except the ARC related properties.
		  	try
		  	{
		  		bindinglist = GetProperties.getActualConnectionBinding((ConnectionInstance)connectionInstance);
		  	}
		  	catch (PropertyNotPresentException e)
		  	{
		  		return result;
		  	}
		  	for (ComponentInstance boundComponentInstance : bindinglist) {
				if (boundComponentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)){
					getRealConnectionBindings(connectionInstance,result);
				} else {
					result.add(boundComponentInstance);
				}
			}
		  return result;
	}



		/**
		 * true if component instance is directly bound to the bus
		 * the component instance can be a connection or a virtual bus instance
		 * @param componentInstance
		 * @param processor
		 * @return
		 */
	  public static boolean isDirectlyBoundToBus(InstanceObject elt, ComponentInstance bus){
		  	List<ComponentInstance> bindinglist;
		  	//construct a new schedulable component, and put into the runTimeComponents only
		  	//when all the timing properties are not null ! except the ARC related properties.
		  	try
		  	{
		  		bindinglist = GetProperties.getActualConnectionBinding((ConnectionInstance)elt);
		  	}
		  	catch (PropertyNotPresentException e)
		  	{
		  		return false;
		  	}
		  	for (ComponentInstance componentInstance : bindinglist) {
				if (componentInstance == bus){
					return true;
				}
			}
		  return false;
	}


}
