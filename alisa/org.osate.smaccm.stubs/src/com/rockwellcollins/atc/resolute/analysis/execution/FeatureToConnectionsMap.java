package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;

import com.rockwellcollins.atc.resolute.analysis.values.NamedElementValue;

public class FeatureToConnectionsMap {
    private final Map<FeatureInstance, List<NamedElementValue>> map = new HashMap<>();

    public FeatureToConnectionsMap(SystemInstance sysInst) {
    	for(FeatureInstance featInst : sysInst.getAllFeatureInstances()){
    		for(ConnectionInstance connInst : featInst.getSrcConnectionInstances()){
    			add(featInst, connInst);
    		}
    		for(ConnectionInstance connInst : featInst.getDstConnectionInstances()){
    			add(featInst, connInst);
    		}
    	}
   	
        for (ConnectionInstance connInst : sysInst.getAllConnectionInstances()) {
            for (ConnectionReference conRef : connInst.getConnectionReferences()) {
                if (conRef.getSource() instanceof FeatureInstance) {
                    FeatureInstance fi = (FeatureInstance) conRef.getSource();
                    add(fi, connInst);
                    addForFeatureGroups(fi, connInst);
                }
                if (conRef.getDestination() instanceof FeatureInstance) {
                    FeatureInstance fi = (FeatureInstance) conRef.getDestination();
                    add(fi, connInst);
                    addForFeatureGroups(fi, connInst);
                }
            }
        }
    }

    private void addForFeatureGroups(FeatureInstance fi, ConnectionInstance connInst) {
        EObject parent = fi.eContainer();
        while (parent instanceof FeatureInstance) {
            add((FeatureInstance) parent, connInst);
            parent = parent.eContainer();
        }
    }

    private void add(FeatureInstance feat, ConnectionInstance conn) {
        if (map.containsKey(feat)) {
            map.get(feat).add(new NamedElementValue(conn));
        } else {
            List<NamedElementValue> list = new ArrayList<>();
            list.add(new NamedElementValue(conn));
            map.put(feat, list);
        }
    }

    public List<NamedElementValue> get(FeatureInstance feat) {
        if (map.containsKey(feat)) {
            return map.get(feat);
        } else {
            return Collections.emptyList();
        }
    }
}
