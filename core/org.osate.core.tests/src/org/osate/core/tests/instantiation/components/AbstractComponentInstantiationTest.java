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
package org.osate.core.tests.instantiation.components;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Shared plumbing for the tests that characterize what {@code InstantiateModel} makes of the
 * component hierarchy: the fixture project, one instantiation per test, and readers that turn the
 * instance model into values a test can compare against.
 *
 * <p>
 * Diagnostics are collected with an in-memory queuing reporter instead of workspace markers, so a
 * test reads what a run reported without touching the workspace.
 * </p>
 */
abstract class AbstractComponentInstantiationTest extends XtextTest {
	private static final String PROJECT = "org.osate.core.tests/models/componentInstantiation/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * Parse {@code fileName}, insist that it has no AADL issues, and instantiate the named component
	 * implementation from it.
	 *
	 * @param fileName the fixture file, relative to the fixture project
	 * @param implementationName the component implementation to instantiate
	 * @param referenced further fixture files the fixture needs in the resource set
	 */
	protected InstantiationResult instantiate(String fileName, String implementationName, String... referenced)
			throws Exception {
		return instantiate(fileName, implementationName, true, referenced);
	}

	/**
	 * Parse {@code fileName} and instantiate the named component implementation from it without insisting
	 * that the model is valid.
	 *
	 * <p>
	 * Nothing keeps instantiation from running on a model the validator rejects, so the guards
	 * {@code InstantiateModel} has against ill-formed models are reachable and worth pinning. A test that
	 * uses this reads {@link InstantiationResult#aadlIssues()} as well, so that the fixture cannot drift
	 * into a different kind of invalid without the test noticing.
	 * </p>
	 */
	protected InstantiationResult instantiateIgnoringAadlIssues(String fileName, String implementationName,
			String... referenced) throws Exception {
		return instantiate(fileName, implementationName, false, referenced);
	}

	private InstantiationResult instantiate(String fileName, String implementationName, boolean requireValid,
			String... referenced) throws Exception {
		String[] referencedPaths = new String[referenced.length];
		for (int i = 0; i < referenced.length; i++) {
			referencedPaths[i] = PROJECT + referenced[i];
		}
		AadlPackage pkg = testHelper.parseFile(PROJECT + fileName, referencedPaths);
		List<String> aadlIssues = validationHelper.validate(pkg)
				.stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage())
				.toList();
		if (requireValid) {
			assertEquals(fileName + " must be a valid AADL model", List.of(), aadlIssues);
		}
		ComponentImplementation impl = findImplementation(pkg, implementationName);
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate(impl, errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		return new InstantiationResult(impl, instance, reporter.getErrors(), aadlIssues);
	}

	/**
	 * Parse {@code fileName} and hand back the named component implementation without instantiating it,
	 * for the few tests that drive instantiation themselves.
	 */
	protected ComponentImplementation implementation(String fileName, String implementationName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT + fileName);
		validationHelper.assertNoIssues(pkg);
		return findImplementation(pkg, implementationName);
	}

	private static ComponentImplementation findImplementation(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No component implementation named " + name));
	}

	/**
	 * One instantiation: what it was made from, what it produced, what it reported, and what the AADL
	 * validator had to say about the fixture.
	 */
	protected record InstantiationResult(ComponentImplementation implementation, SystemInstance instance,
			List<Message> messages, List<String> aadlIssues) {
	}

	// Readers over the component hierarchy

	protected static ComponentInstance component(ComponentInstance parent, String name) {
		return parent.getComponentInstances()
				.stream()
				.filter(component -> component.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No component instance " + name + " in " + path(parent)));
	}

	/** All instances of one subcomponent declaration, in the order they were created. */
	protected static List<ComponentInstance> components(ComponentInstance parent, String name) {
		return parent.getComponentInstances().stream().filter(component -> component.getName().equals(name)).toList();
	}

	protected static List<String> componentNames(ComponentInstance parent) {
		return parent.getComponentInstances().stream().map(ComponentInstance::getName).toList();
	}

	// Readers over features

	protected static FeatureInstance feature(ComponentInstance owner, String name) {
		return owner.getFeatureInstances()
				.stream()
				.filter(feature -> feature.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No feature instance " + name + " in " + path(owner)));
	}

	protected static FeatureInstance feature(FeatureInstance owner, String name) {
		return owner.getFeatureInstances()
				.stream()
				.filter(feature -> feature.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No feature instance " + name + " in " + path(owner)));
	}

	protected static List<FeatureInstance> features(ComponentInstance owner, String name) {
		return owner.getFeatureInstances().stream().filter(feature -> feature.getName().equals(name)).toList();
	}

	protected static List<String> featureNames(ComponentInstance owner) {
		return owner.getFeatureInstances().stream().map(FeatureInstance::getName).toList();
	}

	protected static List<String> featureNames(FeatureInstance owner) {
		return owner.getFeatureInstances().stream().map(FeatureInstance::getName).toList();
	}

	// Readers over modes, flows and diagnostics

	protected static List<String> modeNames(ComponentInstance owner) {
		return owner.getModeInstances().stream().map(ModeInstance::getName).toList();
	}

	protected static ModeInstance mode(ComponentInstance owner, String name) {
		return owner.getModeInstances()
				.stream()
				.filter(modeInstance -> modeInstance.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No mode instance " + name + " in " + path(owner)));
	}

	protected static ModeTransitionInstance transition(ComponentInstance owner, String name) {
		return owner.getModeTransitionInstances()
				.stream()
				.filter(transitionInstance -> transitionInstance.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No mode transition instance " + name));
	}

	protected static List<String> transitionNames(ComponentInstance owner) {
		return owner.getModeTransitionInstances().stream().map(ModeTransitionInstance::getName).toList();
	}

	protected static FlowSpecificationInstance flowSpecification(ComponentInstance owner, String name) {
		return owner.getFlowSpecifications()
				.stream()
				.filter(flow -> flow.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No flow specification instance " + name));
	}

	protected static List<String> flowSpecificationNames(ComponentInstance owner) {
		return owner.getFlowSpecifications().stream().map(FlowSpecificationInstance::getName).toList();
	}

	protected static List<String> somNames(SystemInstance instance) {
		return instance.getSystemOperationModes().stream().map(SystemOperationMode::getName).toList();
	}

	/** The current modes of every system operation mode, by instance object path. */
	protected static List<List<String>> somModes(SystemInstance instance) {
		return instance.getSystemOperationModes()
				.stream()
				.map(som -> som.getCurrentModes().stream().map(AbstractComponentInstantiationTest::path).toList())
				.toList();
	}

	protected static List<String> paths(List<? extends InstanceObject> objects) {
		return objects.stream().map(AbstractComponentInstantiationTest::path).toList();
	}

	protected static String path(InstanceObject object) {
		return object.getInstanceObjectPath();
	}

	/** Every reported diagnostic as {@code kind path: message}, in the order it was reported. */
	protected static List<String> diagnostics(InstantiationResult result) {
		return result.messages().stream().map(message -> message.kind + " " + where(message.where) + ": "
				+ message.message).toList();
	}

	private static String where(Element element) {
		return element instanceof InstanceObject instanceObject ? path(instanceObject) : String.valueOf(element);
	}
}
