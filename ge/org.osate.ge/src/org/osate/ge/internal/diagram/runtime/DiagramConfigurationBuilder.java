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
package org.osate.ge.internal.diagram.runtime;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.osate.ge.DiagramType;

public class DiagramConfigurationBuilder {
	private DiagramType diagramType;
	private CanonicalBusinessObjectReference contextBoReference;
	private final Set<String> lcEnabledAadlPropertyNames = new HashSet<>();
	private Boolean connectionPrimaryLabelsVisible;

	/**
	 *
	 * @param diagramType
	 * @param populateDefaults if true then the value of fields will be populated based on the specified diagram type.
	 */
	public DiagramConfigurationBuilder(final DiagramType diagramType, final boolean populateDefaults) {
		this.diagramType = Objects.requireNonNull(diagramType, "diagramType must not be null");
		this.contextBoReference = null;

		if (populateDefaults) {
			for (final String propertyName : this.diagramType.getDefaultAadlPropertyNames()) {
				addAadlProperty(propertyName);
			}

			connectionPrimaryLabelsVisible(diagramType.getDefaultConnectionPrimaryLabelsVisible());
		}
	}

	public DiagramConfigurationBuilder(final DiagramConfiguration config) {
		Objects.requireNonNull(config, "config must not be null");
		this.diagramType = config.getDiagramType();
		this.contextBoReference = config.getContextBoReference();
		this.lcEnabledAadlPropertyNames.addAll(config.getEnabledAadlPropertyNames());
		this.connectionPrimaryLabelsVisible = config.getConnectionPrimaryLabelsVisible();
	}

	public DiagramType getDiagramType() {
		return this.diagramType;
	}

	public CanonicalBusinessObjectReference getContextBoReference() {
		return this.contextBoReference;
	}

	public DiagramConfigurationBuilder setContextBoReference(final CanonicalBusinessObjectReference value) {
		this.contextBoReference = value;
		return this;
	}

	public Boolean getConnectionPrimaryLabelsVisible() {
		return connectionPrimaryLabelsVisible;
	}

	public DiagramConfigurationBuilder connectionPrimaryLabelsVisible(final Boolean value) {
		this.connectionPrimaryLabelsVisible = value;
		return this;
	}

	public DiagramConfigurationBuilder addAadlProperty(final String qualifiedPropertyName) {
		lcEnabledAadlPropertyNames.add(qualifiedPropertyName.toLowerCase());
		return this;
	}

	public DiagramConfigurationBuilder removeAadlProperty(final String qualifiedPropertyName) {
		lcEnabledAadlPropertyNames.remove(qualifiedPropertyName.toLowerCase());
		return this;
	}

	public Set<String> getEnabledAadlPropertiesLowercase() {
		return Collections.unmodifiableSet(lcEnabledAadlPropertyNames);
	}

	public DiagramConfiguration build() {
		return new DiagramConfiguration(diagramType, contextBoReference, lcEnabledAadlPropertyNames,
				connectionPrimaryLabelsVisible);
	}
}
