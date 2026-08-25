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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

/**
 * Expands the provisional flow specification instances of one instance model root into the final set. A
 * flow specification whose in or out end is a feature array stands for one flow specification instance
 * per pair of elements that {@code Connection_Pattern}, {@code Connection_Set} or the default pattern
 * pairs up, so a flow that goes through such a component goes through one element of it.
 * <p>
 * Both properties apply to a flow specification (AS5506D section 10.1) with the meaning they have on a
 * connection: they say which source array element has a flow to which destination array element. The
 * arithmetic is therefore the same, and is {@link ArrayPatternExpansion}; this class decides what a pair
 * of indices becomes. When the property is not set, {@code One_To_One} applies, which is why a model that
 * declares nothing still gets one flow specification instance per element.
 * <p>
 * Only an end that is a feature array itself is expanded. An end reached through a feature group that is
 * an array keeps the first element of that group, as it always did.
 * <p>
 * {@code Connection_Pattern} and {@code Connection_Set} have to be cached on the provisional flow
 * specification instances before the expansion runs, the same window the connection expansion needs, see
 * {@link StructuralProperty}. Both associations are removed from the instance they were read from, so
 * they do not survive into the final set.
 * <p>
 * The expansion replaces the provisional instances that {@code InstantiateModel.instantiateFlowSpecs}
 * produced, so it has to run before the end to end flows are built over them. A flow specification that
 * cannot be paired up is reported and left alone, so it is still there to be referred to.
 * <p>
 * One expander expands one root once.
 */
public final class FlowSpecArrayExpander {
	private final AnalysisErrorReporterManager errManager;
	private final IProgressMonitor monitor;

	/**
	 * @param monitor the progress monitor
	 * @param errManager the error manager to report to
	 */
	public FlowSpecArrayExpander(IProgressMonitor monitor, AnalysisErrorReporterManager errManager) {
		this.monitor = monitor;
		this.errManager = errManager;
	}

	/**
	 * Expand the provisional flow specification instances below a root into the final set.
	 *
	 * @param root the instance model root to expand the flow specification instances of
	 * @throws InterruptedException if instantiation is canceled
	 */
	public void processFlowSpecifications(ComponentInstance root) throws InterruptedException {
		checkCanceled();
		for (var provisional : List.copyOf(root.getFlowSpecifications())) {
			expand(root, provisional);
			checkCanceled();
		}
		for (var child : root.getComponentInstances()) {
			processFlowSpecifications(child);
		}
	}

	/**
	 * Replace one provisional flow specification instance with the instances its paired-up array elements
	 * call for. Does nothing when neither end is an array element and no property says otherwise, and
	 * leaves the provisional instance in place when the pairing could not be produced.
	 *
	 * @param ci the component instance that owns the flow specification instance
	 * @param provisional the flow specification instance to expand
	 */
	private void expand(ComponentInstance ci, FlowSpecificationInstance provisional) {
		var setPA = StructuralProperty.CONNECTION_SET.cachedOn(provisional);
		var patternPA = StructuralProperty.CONNECTION_PATTERN.cachedOn(provisional);
		var srcSizes = arraySizes(provisional.getSource());
		var dstSizes = arraySizes(provisional.getDestination());
		var overArrays = !srcSizes.isEmpty() || !dstSizes.isEmpty();

		if (setPA == null && patternPA == null && !overArrays) {
			return;
		}

		var variants = new ArrayList<FlowSpecificationInstance>();
		if (setPA == null && patternPA == null) {
			expandPattern(ci, provisional, null, srcSizes, dstSizes, variants);
		} else if (patternPA != null) {
			EcoreUtil.remove(patternPA);
			for (var pattern : StructuralProperty.alternativesOf(patternPA)) {
				if (overArrays) {
					expandPattern(ci, provisional, pattern, srcSizes, dstSizes, variants);
				} else {
					errManager.warning(provisional,
							"Connection pattern specified for flow specification that does not connect array elements.");
				}
			}
		}
		// no else as we want both the pattern and the connection set evaluated
		if (setPA != null) {
			EcoreUtil.remove(setPA);
			for (var pair : StructuralProperty.pairsOf(setPA)) {
				createVariant(provisional, pair.source(), pair.destination(), variants);
			}
		}

		if (variants.isEmpty()) {
			/*
			 * Either nothing was paired up, or every pairing was rejected and reported. Keep the provisional
			 * instance: dropping it would leave the flow specification without an instance for a flow to
			 * refer to, which is also what the connection expansion does with a connection it rejected.
			 */
			return;
		}
		name(provisional, variants);
		replace(ci, provisional, variants);
	}

	/**
	 * Pair up the array elements of the two ends and create one flow specification instance per pair.
	 *
	 * @param ci the component instance that owns the flow specification instance
	 * @param provisional the flow specification instance being expanded
	 * @param pattern one literal per array dimension, or {@code null} to use the default pattern
	 * @param srcSizes the sizes of the array dimensions of the source end, empty if it is not an array
	 * @param dstSizes the sizes of the array dimensions of the destination end, empty if it is not an
	 *            array
	 * @param variants collects the instances created for the pairs
	 */
	private void expandPattern(ComponentInstance ci, FlowSpecificationInstance provisional,
			List<PropertyExpression> pattern, List<Integer> srcSizes, List<Integer> dstSizes,
			List<FlowSpecificationInstance> variants) {
		var subject = new ArrayPatternExpansion.Subject(provisional, "flow specification", provisional.getName(), ci,
				ci.getInstanceObjectPath());
		new ArrayPatternExpansion(errManager, subject, false, pattern, srcSizes, dstSizes,
				(srcIndices, dstIndices) -> createVariant(provisional, srcIndices, dstIndices, variants)).expand();
	}

	/**
	 * Create the flow specification instance for one pair of paired-up element indices. The two ends are
	 * set explicitly rather than copied, because both have an eOpposite on {@code FeatureInstance} and
	 * {@code EcoreUtil.copy} does not carry a reference that has one.
	 *
	 * @param provisional the flow specification instance being expanded
	 * @param srcIndices the index of the source element, empty if the source end is not an array
	 * @param dstIndices the index of the destination element, empty if the destination end is not an array
	 * @param variants collects the created instance
	 */
	private void createVariant(FlowSpecificationInstance provisional, List<Long> srcIndices, List<Long> dstIndices,
			List<FlowSpecificationInstance> variants) {
		var variant = EcoreUtil.copy(provisional);
		variant.setSource(elementAt(provisional.getSource(), srcIndices));
		variant.setDestination(elementAt(provisional.getDestination(), dstIndices));
		variants.add(variant);
	}

	/**
	 * The sizes of the array dimensions of a flow specification end. A feature array has at most one
	 * dimension, so this is one size or none at all. The size is the number of feature instances the
	 * feature was instantiated into, which is what the array bound evaluated to.
	 *
	 * @param end the source or destination of a flow specification instance, {@code null} for the end a
	 *            flow source or a flow sink does not have
	 * @return the size of the dimension of the end, or an empty list if the end is not an array element
	 */
	private List<Integer> arraySizes(FeatureInstance end) {
		if (end == null || end.getIndex() == 0) {
			return List.of();
		}
		var elements = siblings(end).stream().filter(sibling -> sibling.getFeature() == end.getFeature()).count();
		return List.of((int) elements);
	}

	/**
	 * The feature instance of one element of a flow specification end.
	 *
	 * @param end the end the provisional instance was created with, which is the first element of the
	 *            array when the end is one
	 * @param indices the index of the element, empty if the end is not an array
	 * @return the feature instance of that element, or {@code end} itself if the end is not an array
	 */
	private FeatureInstance elementAt(FeatureInstance end, List<Long> indices) {
		if (end == null || indices.isEmpty()) {
			return end;
		}
		var index = indices.getFirst();
		return siblings(end).stream()
				.filter(sibling -> sibling.getFeature() == end.getFeature() && sibling.getIndex() == index)
				.findFirst()
				.orElse(end);
	}

	/**
	 * The feature instances the elements of a feature array are among: those of the component instance for
	 * a feature of a component type, and those of the enclosing feature group instance for a feature of a
	 * feature group type.
	 */
	private List<FeatureInstance> siblings(FeatureInstance end) {
		EObject owner = end.eContainer();
		if (owner instanceof FeatureInstance featureGroup) {
			return featureGroup.getFeatureInstances();
		}
		return ((ComponentInstance) owner).getFeatureInstances();
	}

	/**
	 * Name the instances of a flow specification. One instance keeps the name of the declaration, so a
	 * flow specification that pairs up nothing reads as it always did; several are numbered from one in
	 * pairing order, the way the several instances of one end to end flow declaration are.
	 *
	 * @param provisional the flow specification instance being expanded
	 * @param variants the instances created for its pairs
	 */
	private void name(FlowSpecificationInstance provisional, List<FlowSpecificationInstance> variants) {
		if (variants.size() == 1) {
			return;
		}
		var number = 1;
		for (var variant : variants) {
			variant.setName(provisional.getName() + "_" + number++);
		}
	}

	/**
	 * Put the instances of a flow specification where its provisional instance was, so that the flow
	 * specifications of a component instance stay in declaration order, and detach the provisional one.
	 * Its two ends are cleared first, because a feature instance keeps the flow specification instances
	 * that start or end at it.
	 *
	 * @param ci the component instance that owns the flow specification instances
	 * @param provisional the flow specification instance being replaced
	 * @param variants the instances that replace it
	 */
	private void replace(ComponentInstance ci, FlowSpecificationInstance provisional,
			List<FlowSpecificationInstance> variants) {
		var flowSpecifications = ci.getFlowSpecifications();
		flowSpecifications.addAll(flowSpecifications.indexOf(provisional), variants);
		provisional.setSource(null);
		provisional.setDestination(null);
		EcoreUtil.remove(provisional);
	}

	private void checkCanceled() throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
	}
}
