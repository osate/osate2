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
package org.osate.ge.errormodel.combined;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

import com.google.common.collect.Lists;

/**
 * Class represents the result of combining all error model subclauses for a given classifier. Handles classifier extension and
 * redefiniton of model elements.
 *
 */
public class CombinedErrorModelSubclause {
	/**
	 * Instance that doesn't contain any values. Useful to avoid needing to handle null values.
	 */
	public static final CombinedErrorModelSubclause EMPTY = new CombinedErrorModelSubclause(false,
			Collections.emptyMap(),
			Collections.emptyMap(), Collections.emptyMap(),
			new PropagationNode());

	private final boolean subclauseFound;
	private final Map<String, PropagationPoint> points;
	private final Map<String, PropagationPath> paths;
	private final Map<String, ErrorFlow> flows;
	private final ReadonlyPropagationNode propagations;

	public CombinedErrorModelSubclause(final boolean subclauseFound, final Map<String, PropagationPoint> points,
			final Map<String, PropagationPath> paths,
			final Map<String, ErrorFlow> flows, final ReadonlyPropagationNode propagations) {
		this.subclauseFound = subclauseFound;
		this.points = Collections.unmodifiableMap(points);
		this.paths = Collections.unmodifiableMap(paths);
		this.flows = Collections.unmodifiableMap(flows);
		this.propagations = propagations;
	}

	/**
	 * Returns whether at least one error model subclause was found.
	 * @return true if at least one applicable error model subclause was found
	 */
	public final boolean subclauseExists() {
		return subclauseFound;
	}

	public final Stream<PropagationPoint> getPoints() {
		return points.values().stream();
	}

	public final Stream<PropagationPath> getPaths() {
		return paths.values().stream();
	}

	public final Stream<ErrorFlow> getFlows() {
		return flows.values().stream();
	}

	public final ReadonlyPropagationNode getPropagations() {
		return propagations;
	}

	public static CombinedErrorModelSubclause create(final Classifier classifier) {
		final Map<String, PropagationPoint> points = new HashMap<>();
		final Map<String, PropagationPath> paths = new HashMap<>();
		final Map<String, ErrorFlow> flows = new HashMap<>();
		final PropagationNode propagations = new PropagationNode();

		final EList<Classifier> classifiers = classifier.getSelfPlusAllExtended();
		if (classifier instanceof ComponentImplementation) {
			final ComponentType ct = ((ComponentImplementation) classifier).getType();
			if (ct != null) {
				classifiers.addAll(ct.getSelfPlusAllExtended());
			}
		}

		final boolean subclauseFound[] = { false };
		for (final Classifier tmpClassifier : Lists.reverse(classifiers)) {
			ErrorModelGeUtil.getAllErrorModelSubclauses(tmpClassifier).forEachOrdered(subclause -> {
				subclauseFound[0] = true;
				addAllToMap(subclause.getPoints(), points);
				addAllToMap(subclause.getPaths(), paths);
				addAllToMap(subclause.getFlows(), flows);

				// Create a tree for error propagations
				for (final ErrorPropagation propagation : subclause.getPropagations()) {
					propagations.put(propagation);
				}
			});
		}


		return new CombinedErrorModelSubclause(subclauseFound[0], points, paths, flows, propagations);
	}

	/**
	 * Adds all the specified named elements to the specified map. Uses the lowercase name as the key.
	 * @param <T> the type of the named elements
	 * @param values the values to add
	 * @param map the map to add the values to
	 */
	private static <T extends NamedElement> void addAllToMap(final Collection<T> values, final Map<String, T> map) {
		for (final T value : values) {
			final String name = value.getName();
			if (name != null) {
				map.put(name.toLowerCase(), value);
			}
		}
	}
}