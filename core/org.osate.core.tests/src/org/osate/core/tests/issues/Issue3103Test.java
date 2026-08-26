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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * A modal appending association must keep the appended-to elements in every one of its modal values.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3103Test extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/issue3103/";
	private static final String MODEL = PATH + "Issue3103.aadl";
	private static final String PROPERTIES = PATH + "Issue3103Props.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * The thread type declares {@code Nums => (1, 2)} and the thread implementation appends a different
	 * single element in each of its two modes. Property lookup hands the appending association's modal
	 * values and the value it appends to to {@code CachePropertyAssociationsSwitch.fillPropertyValue},
	 * which must prepend the two inherited elements to each modal value, not only to the first.
	 */
	@Test
	public void everyModalValueOfAnAppendingAssociationKeepsTheAppendedToElements() throws Exception {
		var pkg = testHelper.parseFile(MODEL, PROPERTIES);
		validationHelper.assertNoIssues(pkg);
		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		var instance = InstantiateModel.instantiate(implementation, errorManager);

		assertEquals(Map.of("m1", List.of(1L, 2L, 10L), "m2", List.of(1L, 2L, 20L)),
				numsPerThreadMode(instance));
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		assertEquals(List.of(), reporter.getErrors());
	}

	/**
	 * The {@code Nums} value cached on the thread instance {@code p.s}, keyed by the name of the thread
	 * mode that the system operation mode holding it activates. Each system operation mode of this model
	 * activates exactly one mode of the thread.
	 */
	private static Map<String, List<Long>> numsPerThreadMode(SystemInstance instance) {
		var thread = component(component(instance, "p"), "s");
		var associations = thread.getOwnedPropertyAssociations()
				.stream()
				.filter(association -> association.getProperty().getName().equals("Nums"))
				.toList();
		assertEquals(1, associations.size());
		var values = new LinkedHashMap<String, List<Long>>();

		for (var som : instance.getSystemOperationModes()) {
			var value = (ListValue) associations.getFirst().valueInMode(som);

			assertEquals(1, som.getCurrentModes().size());
			values.put(som.getCurrentModes().getFirst().getMode().getName(), value.getOwnedListElements()
					.stream()
					.map(element -> (long) ((IntegerLiteral) element).getValue())
					.toList());
		}
		return values;
	}

	private static ComponentInstance component(ComponentInstance container, String name) {
		return container.getComponentInstances()
				.stream()
				.filter(component -> component.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}
}
