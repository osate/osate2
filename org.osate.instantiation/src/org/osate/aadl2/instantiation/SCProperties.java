/* Created on Mar 17, 2005
 */
package org.osate.aadl2.instantiation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.Connection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemOperationMode;


/**
 * Very crude encapsulation of the multi-level map used to cache contained
 * property associations that apply to semantic connections. Multi-level hash
 * table ConnectionInstance -&gt; PropertyDefinition -&gt;
 * Connection -&gt; SystemOperationMode -&gt; List of PropertyValues.  The order of "currying" in this
 * map is determined by the order in which it is convienent to nest loops
 * in {@link org.osate.aadl2.instantiation.CheckInstanceSemanticsSwitch#checkPropertyConsistency(ConnectionInstance)}.
 * 
 * @author aarong
 */
final class SCProperties {
	private final Map<ConnectionInstance, Map<Property, Map<Connection, Map<SystemOperationMode, List<? extends PropertyExpression>>>>> scProps;
	
	public SCProperties() {
		scProps = new HashMap<ConnectionInstance, Map<Property, Map<Connection, Map<SystemOperationMode, List<? extends PropertyExpression>>>>>();
	}

	private static <KOuter, KInner, VInner> Map<KInner, VInner> get(final Map<KOuter, Map<KInner, VInner>> map, final KOuter key) {
		Map<KInner, VInner> val = map.get(key);
		if (val == null) {
			val = new HashMap<KInner, VInner>();
			map.put(key, val);
		}
		return val;
	}
	
	public void recordConnectionProperty(
			final ConnectionInstance sc, final Property prop,
			final Connection conn, final List<SystemOperationMode> modes, final List<? extends PropertyExpression> value) {
		final Map<SystemOperationMode, List<? extends PropertyExpression>> modesLayer = get(get(get(scProps, sc), prop), conn);
		final List<PropertyExpression> clonedValue = new ArrayList<PropertyExpression>(value);
		for(final Iterator<SystemOperationMode> i = modes.iterator(); i.hasNext();) {
			final SystemOperationMode mode = i.next();
			modesLayer.put(mode, clonedValue);
		}
	}

	public Map<Property, Map<Connection, Map<SystemOperationMode, List<? extends PropertyExpression>>>> get(final ConnectionInstance sc) {
		return scProps.get(sc);
	}
	
//	public List getConnectionProperty(
//			final ConnectionInstance sc, final PropertyDefinition prop,
//			final SystemOperationMode mode, final Connection conn) {
//		return (List) get(get(get(scProps, sc), prop), mode).get(conn);
//	}
//	
//	public Map getPropertyLayer(final ConnectionIntance)
}
