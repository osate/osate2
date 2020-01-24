/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.analysis.resource.management.handlers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.analysis.resource.management.ResourcemanagementPlugin;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * Command used by {@link Binpack} to set the properties in the instance model
 * to match the results of the binpacking/scheduling operation.  This command
 * is undoable/redoable.
 * 
 * @author aarong
 */
class SetInstanceModelBindings extends AbstractCommand {
	private final Map threadsToProc;
	private final Map oldThreadsToProc;

	public SetInstanceModelBindings(final Map bindings) {
		// Clone the input because we are going to modify the map
		threadsToProc = new HashMap(bindings);
		oldThreadsToProc = new HashMap();
	}

	public void execute() {
		for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext();) {
			final ComponentInstance thread = (ComponentInstance) iter.next();
			final InstanceReferenceValue val = (InstanceReferenceValue) threadsToProc.get(thread);
			thread.setPropertyValue(GetProperties.getActualProcessorBindingProperty(thread), val);
		}
	}

	public void redo() {
		// same as execute
		for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext();) {
			final ComponentInstance thread = (ComponentInstance) iter.next();
			final InstanceReferenceValue val = (InstanceReferenceValue) threadsToProc.get(thread);
			thread.setPropertyValue(GetProperties.getActualProcessorBindingProperty(thread), val);
		}
	}

	public boolean canUndo() {
		return true;
	}

	public void undo() {
		// reset to the old property values -- or remove entirely if the old val is null
		for (Iterator iter = oldThreadsToProc.keySet().iterator(); iter.hasNext();) {
			final ComponentInstance thread = (ComponentInstance) iter.next();
			final PropertyValue oldVal = (PropertyValue) oldThreadsToProc.get(thread);
			if (oldVal == null) {
				thread.removePropertyAssociations(GetProperties.getActualProcessorBindingProperty(thread));
			} else {
				thread.setPropertyValue(GetProperties.getActualProcessorBindingProperty(thread), oldVal);
			}
		}
	}

	public boolean prepare() {
		/*
		 * First get the old processor bindings so we can undo.
		 * We assume that the bindings are NOT modal!
		 */
		try {
			for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext();) {
				final ComponentInstance thread = (ComponentInstance) iter.next();
				// Get the old val, may not have been set
				PropertyValue oldVal;
				try {
					oldVal = (PropertyValue) thread
							.getSimplePropertyValue(GetProperties.getActualProcessorBindingProperty(thread));
				} catch (PropertyNotPresentException e) {
					oldVal = null;
				}
				oldThreadsToProc.put(thread, oldVal);
			}

			/*
			 * Next we go through the given thread->proc map and change it to be a
			 * map from theads to InstanceReferenceValues. This way we don't have
			 * to keep recreating reference values.
			 */
			for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext();) {
				final ComponentInstance thread = (ComponentInstance) iter.next();
				final ComponentInstance proc = (ComponentInstance) threadsToProc.get(thread);
				final InstanceReferenceValue val = InstanceFactory.eINSTANCE.createInstanceReferenceValue();
				val.setReferencedInstanceObject(proc);
				threadsToProc.put(thread, val);
			}

			// always ready to go
			return true;
		} catch (InvalidModelException e) {
			ResourcemanagementPlugin.logErrorMessage(e.getMessage());
			return false;
		}
	}

	public void dispose() {
		// clean up after ourselves
		oldThreadsToProc.clear();
		threadsToProc.clear();
	}

	public String getLabel() {
		return "Bind threads to processors";
	}

	public String getDescription() {
		return "Sets the Actual_Processor_Binding property of all the threads in the system based on a bin packing algorithm.";
	}
}
