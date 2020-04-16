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
package org.osate.ge.swt.prototypeBindings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test implementation of the {@link PrototypeBindingsModel} view model.
 * The root node represents a subcomponent and will not have options for the direction or type.
 */
public class TestPrototypeBindingsModel extends BaseObservableModel
		implements PrototypeBindingsModel<TestNode, String, String, String> {
	private final TestNode root;

	public TestPrototypeBindingsModel() {
		root = new TestNode("");
		root.classifier = "c1";

		final TestNode cn1 = new TestNode("n1");
		cn1.classifier = "c2";
		root.children.add(cn1);
		root.children.add(new TestNode("n2"));
		root.children.add(new TestNode("n3"));
	}

	@Override
	public Stream<TestNode> getChildren(final TestNode parent) {
		// Don't return children when classifier isn't set. Children represent bindings and those require a classifier.
		return rootIfNull(parent).classifier == null ? Stream.empty() : rootIfNull(parent).children.stream();
	}

	@Override
	public String getLabel(final TestNode node) {
		return rootIfNull(node).label;
	}

	@Override
	public Stream<String> getDirectionOptions(final TestNode node) {
		return node == null ? Stream.empty() : Arrays.stream(new String[] { "d1", "d2" });
	}

	@Override
	public String getDirectionLabel(final String direction) {
		return direction == null ? "<None>" : direction;
	}

	@Override
	public String getDirection(final TestNode node) {
		return rootIfNull(node).direction;
	}

	@Override
	public void setDirection(final TestNode node, final String value) {
		rootIfNull(node).direction = value;
		triggerChangeEvent();
	}

	@Override
	public Stream<String> getTypeOptions(final TestNode node) {
		return node == null ? Stream.empty() : Arrays.stream(new String[] { "t1", "t2" });
	}

	@Override
	public String getTypeLabel(final String type) {
		return type == null ? "<None>" : type;
	}

	@Override
	public String getType(final TestNode node) {
		return rootIfNull(node).type;
	}

	@Override
	public void setType(final TestNode node, final String value) {
		rootIfNull(node).type = value;
		triggerChangeEvent();
	}

	@Override
	public Stream<String> getClassifierOptions(final TestNode node) {
		return Arrays.stream(new String[] { "c1", "c2" });
	}

	@Override
	public String getClassifierLabel(final String classifier) {
		return classifier == null ? "<None>" : classifier;
	}

	@Override
	public String getClassifier(final TestNode node) {
		return rootIfNull(node).classifier;
	}

	@Override
	public void setClassifier(final TestNode node, final String value) {
		rootIfNull(node).classifier = value;
		triggerChangeEvent();
	}

	/**
	 * Returns the root node if the specified node is null. Otherwise, returns the specified node.
	 * @param node is the node to check
	 * @return the specified node or the root node.
	 */
	private TestNode rootIfNull(final TestNode node) {
		return node == null ? root : node;
	}
}

class TestNode {
	public final String label;
	public String direction = null;
	public String type = null;
	public String classifier = null;
	public final List<TestNode> children = new ArrayList<>();

	public TestNode(final String label) {
		this.label = label;
	}
}
