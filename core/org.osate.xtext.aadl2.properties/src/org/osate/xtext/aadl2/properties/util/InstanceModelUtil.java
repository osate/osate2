package org.osate.xtext.aadl2.properties.util;

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

public class InstanceModelUtil {
	
	public static  boolean isPortConnection(final ConnectionInstance conn){
		return conn.getKind() == ConnectionKind.PORT_CONNECTION;
	}
	
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
	
	public static boolean isSampledPortConnection(final ConnectionInstance conn){
		if (isPortConnection(conn)) {
			EList<ConnectionReference> cl = conn.getConnectionReferences();
			for (ConnectionReference cr : cl){
				Connection c = cr.getConnection();
				if ( c instanceof PortConnection){
					PortConnection pc =(PortConnection)c;
					EnumerationLiteral el = GetProperties.getConnectionTiming(pc);
					return el == GetProperties.getSampledUnitLiteral(pc);
				}
			}
		}
		return false;
	}
	
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
	
	
	public  static  boolean isEventDataConnection(final ConnectionInstance conn){
			ConnectionInstanceEnd cie = conn.getSource();
			if (cie instanceof FeatureInstance){
				return   ((FeatureInstance)cie).getCategory() == FeatureCategory.EVENT_DATA_PORT;
			}
			return false;
		}
	
		public  static boolean isEventConnection(final ConnectionInstance conn){
			ConnectionInstanceEnd cie = conn.getSource();
			if (cie instanceof FeatureInstance){
				return   ((FeatureInstance)cie).getCategory() == FeatureCategory.EVENT_PORT;
			}
			return false;
		}
	

	public static  boolean isThread(final NamedElement thread){
	return (thread instanceof ThreadSubcomponent)
			|| ((thread instanceof ComponentInstance)
					&& (((ComponentInstance) thread).getCategory() == ComponentCategory.THREAD));
}

	public static  boolean isDevice(final NamedElement thread){
	return (thread instanceof DeviceSubcomponent)
			|| ((thread instanceof ComponentInstance)
					&& (((ComponentInstance) thread).getCategory() == ComponentCategory.DEVICE));
}

	public static  boolean isSystem(final NamedElement system)
{
	return (system instanceof SystemSubcomponent)
			|| ((system instanceof ComponentInstance)
					&& (((ComponentInstance)system).getCategory() == ComponentCategory.SYSTEM));
}

	public static  boolean isProcess(final NamedElement process)
{
	return (process instanceof ProcessSubcomponent)
			|| ((process instanceof ComponentInstance)
					&& (((ComponentInstance)process).getCategory() == ComponentCategory.PROCESS));
}

	public static  boolean isPeriodicComponent(final NamedElement subcomponent){
	return isPeriodicThread(subcomponent) || isPeriodicDevice(subcomponent);
}

	public static  boolean isPeriodicThread(final NamedElement thread){
	if (!isThread(thread)) return false;
	final EnumerationLiteral dp = GetProperties.getDispatchProtocol(thread);
	if (dp == null) return false;
	return  dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
}

	public static  boolean isPeriodicDevice(final NamedElement device){
	if (device instanceof ComponentInstance && ((ComponentInstance)device).getCategory().equals(ComponentCategory.DEVICE)){
	final EnumerationLiteral dp = GetProperties.getDispatchProtocol(device);
	if (dp == null) return false;
	return  dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
	}
	return false;
}


}
