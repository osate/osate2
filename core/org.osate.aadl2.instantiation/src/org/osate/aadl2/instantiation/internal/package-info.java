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
 * Enumerates the semantic connections of an instance model, across-first.
 *
 * <p>
 * A semantic connection has exactly one containment turning point: it travels up zero or more
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
 * The package is not exported. Its types are the traversal's internal vocabulary and carry no
 * compatibility promise; {@code CreateConnectionsSwitch} is the entry point that does.
 * </p>
 *
 * <p>
 * Issue #3037 introduced this traversal in place of one that grew partial paths forward from each
 * candidate source feature, tracking whether it could currently go up, across or down, with two
 * shared feature group stacks to remember what it had to narrow on the way back down. Comments in
 * this package call that one <em>source-first</em> where the contrast explains why a rule exists.
 * It is gone, so those references are history rather than pointers: what they record is that the
 * rule reproduces a behavior the enhancement was required to preserve, and the issue holds the
 * evidence for each.
 * </p>
 */
package org.osate.aadl2.instantiation.internal;
