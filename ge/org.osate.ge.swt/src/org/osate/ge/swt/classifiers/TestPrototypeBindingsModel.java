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
package org.osate.ge.swt.classifiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Test implementation of the {@link PrototypeBindingsModel} model.
 * The root node represents a subcomponent and will not have options for the direction or type.
 */
public class TestPrototypeBindingsModel extends BaseObservableModel
		implements PrototypeBindingsModel<String, String, String, String> {
	private Map<String, String> directionMap = new HashMap<>();
	private Map<String, String> typeMap = new HashMap<>();
	private Map<String, String> classifierMap = new HashMap<>();

	public TestPrototypeBindingsModel() {
		setClassifier(null, "c1");
	}

	@Override
	public Stream<String> getChildren(final String parent) {
		final String c = getClassifier(parent);

		if (c == null) {
			return Stream.empty();
		}

		final ArrayList<String> children = new ArrayList<>();
		if (Objects.equals(c, "c1")) {
			children.add(node(parent, "n1"));
			children.add(node(parent, "n2"));
			children.add(node(parent, "n3"));
			children.add(node(parent, "n4"));
			children.add(node(parent, "n5"));
			children.add(node(parent, "n6"));
			children.add(node(parent, "n7"));
		} else {
			children.add(node(parent, "n1"));
			children.add(node(parent, "n2"));
		}

		return children.stream();
	}

	@Override
	public String getValueLabel(final String node) {
		return getDirectionLabel(getDirection(node)) + " : " + getTypeLabel(getType(node)) + " : "
				+ getClassifierLabel(getClassifier(node)) + " (" + getChildrenLabel(node) + ")";
	}

	@Override
	public String getChildrenLabel(final String node) {
		return getChildren(node).map(c -> getLabel(c) + " => " + getValueLabel(c)).collect(Collectors.joining(","));
	}

	private static String node(final String parent, String label) {
		final String n = parent == null ? "" : parent;
		return n + "_" + label;
	}

	@Override
	public String getLabel(final String node) {
		if (node == null) {
			return "";
		}

		// Get the label for the node from the reference
		return node.substring(node.lastIndexOf("_") + 1);
	}

	@Override
	public Stream<String> getDirectionOptions(final String node) {
		return node == null ? Stream.empty() : Arrays.stream(new String[] { "d1", "d2" });
	}

	@Override
	public String getDirectionLabel(final String direction) {
		return direction == null ? "<None>" : direction;
	}

	@Override
	public String getDirection(final String node) {
		return directionMap.get(node);
	}

	@Override
	public void setDirection(final String node, final String value) {
		directionMap.put(node, value);
		triggerChangeEvent();
	}

	@Override
	public Stream<String> getTypeOptions(final String node) {
		return node == null ? Stream.empty() : Arrays.stream(new String[] { "t1", "t2" });
	}

	@Override
	public String getTypeLabel(final String type) {
		return type == null ? "<None>" : type;
	}

	@Override
	public String getType(final String node) {
		return typeMap.get(node);
	}

	@Override
	public void setType(final String node, final String value) {
		typeMap.put(node, value);
		triggerChangeEvent();
	}

	@Override
	public Stream<String> getClassifierOptions(final String node) {
		return Arrays.stream(new String[] { "c1", "c2", "c3", "c4", "c5", "c6" });
	}

	@Override
	public String getClassifierLabel(final String classifier) {
		return classifier == null ? "<None>" : classifier;
	}

	@Override
	public String getClassifier(final String node) {
		return classifierMap.get(node);
	}

	@Override
	public void setClassifier(final String node, final String value) {
		classifierMap.put(node, value);
		triggerChangeEvent();
	}

	@Override
	public String validateNode(final String node) {
		if (Objects.equals("c6", getClassifier(node))) {
			return "Classifier must not be 'c6'";
		}

		return null;
	}

	@Override
	public void flush() {
		System.out.println("Flushing");
	}
}
