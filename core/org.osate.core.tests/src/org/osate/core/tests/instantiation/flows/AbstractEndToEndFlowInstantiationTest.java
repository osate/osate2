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
package org.osate.core.tests.instantiation.flows;

import java.util.List;

import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

abstract class AbstractEndToEndFlowInstantiationTest extends XtextTest {
	private static final String PROJECT = "org.osate.core.tests/models/endToEndFlowInstantiation/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	protected SystemInstance instantiate(String fileName, String implementationName) throws Exception {
		AadlPackage pkg = parse(fileName);
		validationHelper.assertNoIssues(pkg);
		return InstantiateModel.instantiate(findImplementation(pkg, implementationName));
	}

	protected InstantiationResult instantiateWithErrors(String fileName, String implementationName) throws Exception {
		AadlPackage pkg = parse(fileName);
		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate(findImplementation(pkg, implementationName),
				errorManager);
		List<Message> messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource()))
				.getErrors();
		return new InstantiationResult(instance, messages);
	}

	private AadlPackage parse(String fileName) throws Exception {
		return testHelper.parseFile(PROJECT + fileName);
	}

	private static ComponentImplementation findImplementation(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	protected static List<String> flowNames(ComponentInstance component) {
		return component.getEndToEndFlows().stream().map(EndToEndFlowInstance::getName).toList();
	}

	protected static List<EndToEndFlowInstance> flowsFor(ComponentInstance component, String declarationName) {
		return component.getEndToEndFlows()
				.stream()
				.filter(flow -> flow.getEndToEndFlow().getName().equals(declarationName))
				.toList();
	}

	protected static EndToEndFlowInstance flow(ComponentInstance component, String name) {
		return component.getEndToEndFlows()
				.stream()
				.filter(flow -> flow.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	protected static ComponentInstance component(ComponentInstance parent, String name) {
		return parent.getComponentInstances()
				.stream()
				.filter(component -> component.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	protected static FlowSpecificationInstance flowSpecification(EndToEndFlowInstance flow, int index) {
		return (FlowSpecificationInstance) flow.getFlowElements().get(index);
	}

	protected static ConnectionInstance connection(EndToEndFlowInstance flow, int index) {
		return (ConnectionInstance) flow.getFlowElements().get(index);
	}

	protected static ComponentInstance componentElement(EndToEndFlowInstance flow, int index) {
		return (ComponentInstance) flow.getFlowElements().get(index);
	}

	protected static EndToEndFlowInstance nestedFlow(EndToEndFlowInstance flow, int index) {
		return (EndToEndFlowInstance) flow.getFlowElements().get(index);
	}

	protected static List<String> connectionDeclarations(ConnectionInstance connection) {
		return connection.getConnectionReferences()
				.stream()
				.map(reference -> reference.getConnection().getName())
				.toList();
	}

	protected record InstantiationResult(SystemInstance instance, List<Message> messages) {
	}
}
