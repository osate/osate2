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
/**
 * The internals of instance model creation: the across-first enumeration of connection instances,
 * the expansion of arrays, the enumeration of system operation modes, and the discovery of
 * end-to-end flow instances.
 *
 * <p>
 * {@link org.osate.aadl2.instantiation.internal.ConnectionArrayExpander} expands the connection
 * instances of one instance model root into the final connection set,
 * {@link org.osate.aadl2.instantiation.internal.FlowSpecArrayExpander} does the same for its flow
 * specification instances, and
 * {@link org.osate.aadl2.instantiation.internal.SystemOperationModeBuilder} enumerates the system
 * operation modes of a system instance. All three are phases of {@code InstantiateModel}, which is
 * the entry point that carries the compatibility promise for them. The two expanders read the same
 * two properties, identified by
 * {@link org.osate.aadl2.instantiation.internal.StructuralProperty}, and pair up array elements the
 * same way, which is
 * {@link org.osate.aadl2.instantiation.internal.ArrayPatternExpansion}. The rest of the package is
 * the connection instance traversal described below, and the end-to-end flow discovery described
 * after it.
 * </p>
 *
 * <p>
 * A connection instance is enumerated across-first.
 * </p>
 *
 * <p>
 * A connection instance has exactly one containment turning point: it travels up zero or more
 * containment levels, crosses between peers once, and travels down zero or more levels. This
 * package takes that shape as its structure. {@link org.osate.aadl2.instantiation.internal.SeedDiscovery}
 * finds the declaration at each turning point, the across seed, together with the boundary and
 * mode-transition-trigger seeds for connections that have no crossing of their own.
 * {@link org.osate.aadl2.instantiation.internal.LegResolver} resolves a source leg and a
 * destination leg downward from a seed, {@link org.osate.aadl2.instantiation.internal.PathAssembler}
 * joins compatible legs into whole paths, {@link org.osate.aadl2.instantiation.internal.LeafExpansion}
 * narrows a path's ends to the leaves that become connection instances, and
 * {@link org.osate.aadl2.instantiation.internal.PathMaterializer} builds each one. Nothing in EMF
 * is created until materialization, so a path can be explored and discarded without leaving
 * anything behind.
 * </p>
 *
 * <p>
 * An end-to-end flow instance is discovered detached and attached once.
 * </p>
 *
 * <p>
 * {@link org.osate.aadl2.instantiation.internal.EndToEndFlowSession} instantiates the end-to-end
 * flows declared by one component instance. A declaration resolves against the instance model one
 * segment at a time and can fork wherever several flow implementations, connection instances,
 * access targets, or nested flow variants match, so the session keeps a candidate per branch, none
 * of them in the instance model, and attaches the ones that completed in a single commit. It uses
 * {@link org.osate.aadl2.instantiation.internal.FlowIterator} as the branch-local cursor over a
 * declaration, {@link org.osate.aadl2.instantiation.internal.FlowConnectionMatcher} for the
 * stateless questions about which semantic connections carry a declarative connection path, and
 * {@link org.osate.aadl2.instantiation.internal.EndToEndFlowModes} for the mode arithmetic.
 * {@link org.osate.aadl2.instantiation.internal.ETEInfo} is the legacy view of a candidate, built
 * only for a caller that asks for it. {@code CreateEndToEndFlowsSwitch} is the entry point that
 * carries the compatibility promise, and it is also the only thing a session talks to:
 * {@link org.osate.aadl2.instantiation.internal.FlowInstantiationHost} is the switch's protected
 * extension points seen from inside, so an override still decides every step. Issue #3055 separated
 * these responsibilities; {@code doc/e2e_instantiation.md} describes the result.
 * </p>
 *
 * <p>
 * The package is not exported. Its types are the internal vocabulary of the phases above and carry
 * no compatibility promise; for the connection traversal, {@code CreateConnectionsSwitch} is the
 * entry point that does, and for end-to-end flows, {@code CreateEndToEndFlowsSwitch}.
 * </p>
 *
 * <p>
 * Issue #3037 introduced this traversal in 2.19.0, in place of one that grew partial paths
 * forward from each candidate source feature with two shared feature group stacks to remember
 * what it had to narrow on the way back down. Almost all of the observable behavior was required
 * to carry over unchanged; the eight differences that were reviewed and accepted are listed in
 * {@code doc/connection_instantiation.md}, section 9, and the tests refer to them by number.
 * A rule below that looks arbitrary is usually one of those carried-over behaviors, and says so.
 * </p>
 */
package org.osate.aadl2.instantiation.internal;
