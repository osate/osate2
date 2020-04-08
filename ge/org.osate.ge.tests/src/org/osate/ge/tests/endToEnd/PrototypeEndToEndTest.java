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
package org.osate.ge.tests.endToEnd;

import static org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder.*;
import static org.osate.ge.tests.endToEnd.util.OsateGePrototypeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;

import org.junit.Test;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.tests.endToEnd.util.DiagramElementReference;
import org.osate.ge.tests.endToEnd.util.DiagramReference;

/**
 * This class is an end to end test focusing on prototypes.
 */
public class PrototypeEndToEndTest {
	private static final String PROTOTYPE_TEST = "prototype_test";

	@Test
	public void testPrototypes() {
		createAadlProject(PROTOTYPE_TEST);
		createNewPackageWithPackageDiagram(PROTOTYPE_TEST, PROTOTYPE_TEST);

		final DiagramReference diagram = defaultDiagram(PROTOTYPE_TEST, PROTOTYPE_TEST);
		final DiagramElementReference pkgElement = packageElement(PROTOTYPE_TEST);
		final RelativeBusinessObjectReference pkg = getPackageRelativeReference(PROTOTYPE_TEST);

		// Create system which will have prototypes
		createElementAndLayout(diagram, pkgElement, "System Type",
				getClassifierRelativeReference("new_classifier"), "top");
		final DiagramElementReference top = element(pkg, getClassifierRelativeReference("top"));

		// Create system which will extend the other one and will be used to test prototype refinement
		createElementAndLayout(diagram, pkgElement, "System Type", getClassifierRelativeReference("new_classifier"),
				"top_ext");
		final DiagramElementReference topExt = element(pkg, getClassifierRelativeReference("top_ext"));

		// Set Extension
		setClassifierFromPropertiesView(diagram, "prototype_test::top",
				element(pkg, getClassifierRelativeReference("top_ext")));

		//
		// Create a process prototype
		//
		createPrototype(diagram, "top_new_prototype",
				top);
		renamePrototype(diagram, "top_new_prototype", "process_pt", top);

		// Cycle through different types
		setPrototypeType(diagram, "process_pt", "Feature", top);
		setPrototypeType(diagram, "process_pt", "Feature Group", top);
		setPrototypeType(diagram, "process_pt", "Abstract", top);
		setPrototypeType(diagram, "process_pt", "Bus", top);
		setPrototypeType(diagram, "process_pt", "Data", top);
		setPrototypeType(diagram, "process_pt", "Device", top);
		setPrototypeType(diagram, "process_pt", "Feature Group", top);
		setPrototypeType(diagram, "process_pt", "Memory", top);
		setPrototypeType(diagram, "process_pt", "Processor", top);
		setPrototypeType(diagram, "process_pt", "Subprogram", top);
		setPrototypeType(diagram, "process_pt", "Subprogram Group", top);
		setPrototypeType(diagram, "process_pt", "System", top);
		setPrototypeType(diagram, "process_pt", "Thread", top);
		setPrototypeType(diagram, "process_pt", "Thread Group", top);
		setPrototypeType(diagram, "process_pt", "Virtual Bus", top);
		setPrototypeType(diagram, "process_pt", "Virtual Processor", top);
		setPrototypeType(diagram, "process_pt", "Process", top);

		setPrototypeArray(diagram, "process_pt", false, true, top);

		//
		// Create a feature group prototype
		//
		createPrototype(diagram, "top_new_prototype",
				element(pkg, getClassifierRelativeReference("top")));
		renamePrototype(diagram, "top_new_prototype", "feature_group_pt", top);
		setPrototypeType(diagram, "process_pt", "Feature Group", top);

		//
		// Create a feature prototype
		//
		createPrototype(diagram, "top_new_prototype",
				element(pkg, getClassifierRelativeReference("top")));
		renamePrototype(diagram, "top_new_prototype", "feature_pt", top);
		setPrototypeType(diagram, "feature_pt", "Feature", top);
		setPrototypeDirection(diagram, "feature_pt", "Output", top);
		setPrototypeDirection(diagram, "feature_pt", "Unspecified", top);
		setPrototypeDirection(diagram, "feature_pt", "Input", top);
		setPrototypeConstrainingClassifier(diagram, "feature_pt", "Base_Types::Boolean", top);

		//
		// Create a prototype and then remove it
		//
		createPrototype(diagram, "top_new_prototype", top);

		// Remove
		removePrototype(diagram, "top_new_prototype", top);

		//
		// Refinement
		//
		setPrototypeRefined(diagram, "feature_pt", "prototype_test::top", false, true, topExt);
		renamePrototype(diagram, "feature_pt", "feature_pt_renamed", topExt);
	}
}
