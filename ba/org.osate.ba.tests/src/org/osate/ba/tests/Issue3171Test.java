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
package org.osate.ba.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * AS5506/3 Rev. A lists {@code 'updated} among the D.5 port services and admits it in the D.7 {@code value_variable}
 * production as {@code port_name ' updated}, beside {@code 'count} and {@code 'fresh}. Verifies that such a value
 * parses, that it becomes a port value of its own metaclass holding the named port in the strict model, that it types as
 * a universal Boolean with no data classifier of its own, and that it round-trips through the registered unparser.
 * <p>
 * Every port the model names is incoming. The production spells {@code port_name} rather than the
 * {@code incoming_port_name} it uses for a plain port read, so it admits an outgoing port too, but nothing in D.5 or D.7
 * says what the value would mean there, and this test takes no position on that case.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3171Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3171/";

	/** The metaclass the strict model gives a port updated value. */
	private static final String PORT_UPDATED_VALUE = "PortUpdatedValue";

	/**
	 * The strict shape of {@code Issue3171.aadl}: an updated value on a data port, on an event data port in a condition
	 * and on a data-less event port in an action, and on a port reached through a feature group, which keeps the group
	 * beside the port the way every other port holder does.
	 */
	private static final List<String> RESOLVED_HOLDERS = List.of(
			"data_port -> PortUpdatedValue:reading",
			"event_data_port -> PortUpdatedValue:request, BehaviorVariableHolder:changed, PortUpdatedValue:trigger",
			"feature_group_port -> PortUpdatedValue:pulse, GroupHolder:bundle");

	/**
	 * D.7 gives the value a Boolean result. It is a universal Boolean rather than a {@code Base_Types::Boolean} value,
	 * so it carries no data classifier, which is also what lets it apply to an event port that has no data at all.
	 * <p>
	 * In annex containment order: every transition condition first, then the action blocks the annex holds beside them,
	 * which is where {@code trigger} is written.
	 */
	private static final List<String> UPDATED_TYPES = List.of("reading -> Boolean <no classifier>",
			"request -> Boolean <no classifier>", "pulse -> Boolean <no classifier>",
			"trigger -> Boolean <no classifier>");

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * Describes the holders by metaclass name rather than by Java type so that a run without the support reports the
	 * representation it did build instead of failing to compile.
	 */
	@Test
	public void portUpdatedResolvesToAPortValueOfItsOwn() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3171.aadl");
		validationHelper.assertNoIssues(root);
		assertEquals(RESOLVED_HOLDERS, strictAnnex(root).getTransitions().stream().map(Issue3171Test::describe).toList());
	}

	@Test
	public void portUpdatedIsAUniversalBoolean() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3171.aadl");
		validationHelper.assertNoIssues(root);

		var types = new ArrayList<String>();
		for (var holder : holders(strictAnnex(root))) {
			if (PORT_UPDATED_VALUE.equals(holder.eClass().getName())) {
				var type = AadlBaUtils.getTypeHolder(holder);
				types.add(name(holder.getElement()) + " -> " + type.getDataRep().getName() + ' '
						+ (type.getKlass() == null ? "<no classifier>" : type.getKlass().getName()));
			}
		}
		assertEquals(UPDATED_TYPES, types);
	}

	/**
	 * Serializes a copy of the annex instead of the annex itself: the registered unparser returns the source text of
	 * anything that still has a node model, and the generated sequencers are what has to emit the suffix. The copy joins
	 * the parsed resource for the duration, because serializing the unit and classifier cross-references needs the scope
	 * that resource provides.
	 */
	@Test
	public void portUpdatedRoundTripsThroughTheUnparser() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3171.aadl");
		validationHelper.assertNoIssues(root);
		var copy = EcoreUtil.copy(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst().getParsedAnnexSubclause());

		final String serialized;
		root.eResource().getContents().add(copy);
		try {
			serialized = ((AnnexUnparserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID))
					.getAnnexUnparser("behavior_specification")
					.unparseAnnexSubclause(copy, "");
		} finally {
			root.eResource().getContents().remove(copy);
		}
		// The formatter puts a space on either side of the tick and of a reference separator, the way it already does
		// for 'count and 'fresh, so the suffix is asserted on the closed-up text.
		var normalized = serialized.replaceAll("\\s+", " ").replace(" ' ", "'").replace(" . ", ".");
		assertTrue(serialized, normalized.contains("reading'updated"));
		assertTrue(serialized, normalized.contains("request'updated"));
		assertTrue(serialized, normalized.contains("changed := trigger'updated"));
		assertTrue(serialized, normalized.contains("bundle.pulse'updated"));

		var source = NodeModelUtils.getNode(root).getText();
		var reparsed = testHelper.parseString(source.substring(0, source.indexOf("{**") + 3) + serialized
				+ source.substring(source.indexOf("**}")));
		validationHelper.assertNoIssues(reparsed);
		assertEquals(RESOLVED_HOLDERS,
				strictAnnex(reparsed).getTransitions().stream().map(Issue3171Test::describe).toList());
	}

	private static BehaviorAnnex strictAnnex(final AadlPackage root) {
		return BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
	}

	/**
	 * The action block is not contained by its transition: the strict model keeps every block under the annex and has
	 * the transition refer to it. So the condition and the action are collected separately, condition first.
	 */
	private static String describe(final BehaviorTransition transition) {
		var holders = new ArrayList<>(holders(transition));
		if (transition.getActionBlock() != null) {
			holders.addAll(holders(transition.getActionBlock()));
		}
		return transition.getName() + " -> " + holders.stream()
				.map(holder -> holder.eClass().getName() + ':' + name(holder.getElement()))
				.collect(Collectors.joining(", "));
	}

	/** Every element holder the given object contains, in the order the annex writes them. */
	private static List<ElementHolder> holders(final EObject root) {
		var result = new ArrayList<ElementHolder>();
		root.eAllContents().forEachRemaining(object -> {
			if (object instanceof ElementHolder holder) {
				result.add(holder);
			}
		});
		return result;
	}

	private static String name(final NamedElement element) {
		return element == null ? "<null>" : element.getName();
	}
}
