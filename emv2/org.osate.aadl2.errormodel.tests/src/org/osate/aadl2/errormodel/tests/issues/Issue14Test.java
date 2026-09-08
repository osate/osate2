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
package org.osate.aadl2.errormodel.tests.issues;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Preserves EMV2 regression coverage for OSATE issue #14 during the Xtend-to-Java migration.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue14Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void issue14() throws Exception {
		var issue14 = """
				package issue14
				public
				\tdevice battery
				\t\tfeatures
				\t\t\tsocket: requires bus access mybus;
				\t\t\tannex emv2 {**
				\t\t\t\tuse types ErrorLibrary;
				\t\t\t\terror propagations
				\t\t\t\tsocket: out propagation {ServiceOmission};
				\t\t\t\tsocket: in propagation {ItemOmission};
				\t\t\t\tend propagations;
				\t\t\t**};
				\tend battery;
				\tbus mybus
				\t
				\tend mybus;
				\tsystem power
				\t\tfeatures
				\t\t\tline1: requires bus access mybus;
				\t\t\tline2: requires bus access mybus;
				\t\t\tannex emv2 {**
				\t\t\t\tuse types ErrorLibrary;
				\t\t\t\terror propagations
				\t\t\t\tline1: out propagation {ValueError};
				\t\t\t\tline1: in propagation {TimingError};
				\t\t\t\tline2: out propagation {ValueError};
				\t\t\t\tend propagations;
				\t\t\t**};
				\tend power;
				\tsystem implementation power.generic
				\t\tsubcomponents
				\t\t\tbattery1: device battery;
				\t\t\tbattery2: device battery;
				\t\tconnections
				\t\t\tpwr1: bus access line1 <-> battery1.socket;
				\t\t\tpwr2: bus access  battery2.socket <-> line2;
				\tend power.generic;
				end issue14;
				""";
		final FluentIssueCollection testFileResult = this.issues = this.testHelper.testString(issue14);
		final FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (testFileResult.getResource().getContents()).getFirst());
		Assert.assertEquals("issue14", aadlPackage.getName());
		var componentImplementation = ((ComponentImplementation) aadlPackage.getPublicSection().getOwnedClassifiers()
				.get(3));
		Assert.assertEquals("power.generic", componentImplementation.getName());
		var connection = componentImplementation.getAllConnections().get(0);
		Assert.assertEquals("pwr1", connection.getName());
		AssertHelper.assertError(connection, testFileResult.getIssues(), issueCollection,
				"Reverse direction: Destination propagation  socket{ServiceOmission} has error types not handled by source propagation line1{ValueError}",
				"Source propagation  line1{TimingError} has error types not handled by destination propagation socket{ItemOmission}");
		var connection2 = componentImplementation.getAllConnections().get(1);
		Assert.assertEquals("pwr2", connection2.getName());
		AssertHelper.assertError(connection2, testFileResult.getIssues(), issueCollection,
				"Source propagation  socket{ServiceOmission} has error types not handled by destination propagation line2{ValueError}");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		this.assertConstraints(issueCollection);

	}

	@Test
	public void issue14_1() throws Exception {
		var issue14 = """
				package issue14_1
				public
				\tabstract sender
				\t\tfeatures
				\t\t\toutp: in out data port;
				\t\t\tannex emv2 {**
				\t\t\t\tuse types ErrorLibrary;
				\t\t\t\terror propagations
				\t\t\t\toutp: out propagation {ServiceOmission};
				\t\t\t\tend propagations;
				\t\t\t**};
				\tend sender;
				\tabstract receiver
				\t\tfeatures
				\t\t\tinp: in out data port;
				\t\t\tannex emv2 {**
				\t\t\t\tuse types ErrorLibrary;
				\t\t\t\terror propagations
				\t\t\t\tinp: in propagation {ValueError};
				\t\t\t\tinp: out propagation {ValueError};
				\t\t\t\tend propagations;
				\t\t\t**};
				\tend receiver;
				\tsystem processing
				\tend processing;
				\tsystem implementation processing.generic
				\t\tsubcomponents
				\t\t\tsend: abstract sender;
				\t\t\treceive: abstract receiver;
				\t\tconnections
				\t\t\tconn1: port send.outp <-> receive.inp;\s
				\tend processing.generic;
				end issue14_1;
				""";
		final FluentIssueCollection testFileResult = this.issues = this.testHelper.testString(issue14);
		final FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (testFileResult.getResource().getContents()).getFirst());
		Assert.assertEquals("issue14_1", aadlPackage.getName());
		var componentImplementation = ((ComponentImplementation) aadlPackage.getPublicSection().getOwnedClassifiers()
				.get(3));
		Assert.assertEquals("processing.generic", componentImplementation.getName());
		var connection = componentImplementation.getAllConnections().get(0);
		Assert.assertEquals("conn1", connection.getName());
		AssertHelper.assertError(connection, testFileResult.getIssues(), issueCollection,
				"Source propagation  outp{ServiceOmission} has error types not handled by destination propagation inp{ValueError}");
		AssertHelper.assertWarning(connection, testFileResult.getIssues(), issueCollection,
				"No incoming error propagation for outgoing propagation inp{ValueError}");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		this.assertConstraints(issueCollection);

	}
}
