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
package org.osate.xtext.aadl2.ui.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.StringJoiner;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.xbase.lib.Exceptions;

public class ContributedAadlStorage extends PlatformObject implements IStorage, ProjectMember {
	private final ProjectMember parent;

	private final URI uri;

	private final boolean disabled;

	/**
	 * @since 5.0
	 */
	public ContributedAadlStorage(ProjectMember parent, URI uri) {
		this(parent, uri, false);
	}

	/**
	 * @since 6.2
	 */
	public ContributedAadlStorage(ProjectMember parent, URI uri, boolean disabled) {
		this.parent = parent;
		this.uri = uri;
		this.disabled = disabled;
	}

	/**
	 * @since 5.0
	 */
	public ProjectMember getParent() {
		return parent;
	}

	public URI getUri() {
		return uri;
	}

	@Override
	public InputStream getContents() throws CoreException {
		try {
			return URIConverter.INSTANCE.createInputStream(uri);
		} catch (IOException e) {
			/*
			 * Thrown undeclared, as the Xtend compiler did. IStorage.getContents may only declare CoreException, and
			 * wrapping the IOException would change what callers see.
			 */
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Override
	public IPath getFullPath() {
		var segments = uri.segments();
		var path = new StringJoiner("/");
		/* Drop the first segment, which is the plug-in or project name. */
		for (int i = 1; i < segments.length; i++) {
			path.add(segments[i]);
		}
		return new Path(path.toString());
	}

	@Override
	public String getName() {
		var segments = uri.segments();
		return (disabled ? "[Disabled] " : "") + segments[segments.length - 1];
	}

	@Override
	public boolean isReadOnly() {
		return true;
	}

	@Override
	public IProject getProject() {
		return parent.getProject();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof ContributedAadlStorage other && Objects.equals(uri, other.uri);
	}

	@Override
	public int hashCode() {
		return uri.hashCode();
	}
}
