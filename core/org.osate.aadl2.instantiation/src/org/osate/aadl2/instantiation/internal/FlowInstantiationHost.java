/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.ModeInstance;

/**
 * What an {@link EndToEndFlowSession} needs from the traversal adapter that drives it.
 * <p>
 * {@code CreateEndToEndFlowsSwitch} is that adapter. It owns the progress monitor, the error manager, the classifier
 * cache, and the clone counter, and it declares the protected methods a subclass may override. Every one of those
 * methods appears here, and the session reaches its own traversal only through this interface, so an overridden step
 * still takes effect no matter how deep in the traversal it is reached from.
 * <p>
 * The methods that mirror a protected step of the adapter are expected to come back into the session that called them.
 * The remaining ones — cancellation, classifier lookup, and error reporting — are services the session cannot provide
 * for itself.
 */
public interface FlowInstantiationHost {

	/** Whether the user has canceled instantiation. */
	boolean isCanceled();

	/** The implementation instantiated for a component instance, with prototypes resolved, or null if there is none. */
	ComponentImplementation componentImplementation(ComponentInstance ci);

	/** Report an error against an element of a resource, which excludes candidates that are still detached. */
	void reportError(Element target, String message);

	/** Expand a nested end-to-end flow declaration in the component context that declares it. */
	void expandNestedFlow(ComponentInstance ci, EndToEndFlow ete);

	void processETE(ComponentInstance ci, EndToEndFlowInstance etei, EndToEndFlow ete);

	void processETESegment(ComponentInstance ci, EndToEndFlowInstance etei, Element fs, FlowIterator iter,
			NamedElement errorElement);

	void processSubcomponentFlow(ComponentInstance ci, EndToEndFlowInstance etei, FlowSpecification fs,
			FlowIterator iter);

	boolean processFlowImpl(ComponentInstance ci, EndToEndFlowInstance etei, FlowImplementation flowImpl);

	void processFlowStep(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf, FlowIterator iter);

	void processFlowStep(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf, FlowImplementation nextFlowImpl,
			FlowIterator iter);

	/** Restart clone numbering before the variants of one declaration are named. */
	void resetCloneCount();

	/** Name one variant of a declaration that produced more than one flow instance. */
	void setCloneName(EndToEndFlowInstance etei);

	/** The mode instances a declarative element is constrained to in a component instance. */
	EList<ModeInstance> modeInstances(ComponentInstance ci, ModalElement element);

	/** Compute the system operation modes of a committed flow instance. */
	void fillInModes(EndToEndFlowInstance etei);
}
