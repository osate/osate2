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

package org.osate.ge.internal.businessobjecthandlers;

import java.util.List;
import java.util.UUID;

import org.eclipse.xtext.util.Strings;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.internal.model.Note;
import org.osate.ge.internal.model.NoteReference;

/**
 * Utility classes for working with business object which are built-in to the graphical editor and not specifically AADL related.
 *
 */
public class InternalReferenceUtil {
	private InternalReferenceUtil() {
	}

	final static String TYPE_NOTE = "note";
	final static String TYPE_NOTE_REFERENCE = "note_reference";

	/**
	 * Creates an embedded object based on its reference and extra data.
	 * @param ref
	 * @param boData
	 * @return
	 */
	public static Object createEmbeddedObject(final RelativeBusinessObjectReference ref, final String boData) {
		final List<String> segs = ref.getSegments();
		if (segs.get(0).equals(TYPE_NOTE)) {
			if (segs.size() != 2) {
				throw new RuntimeException("Invalid reference for note. Number of segments: " + segs.size());
			}

			final UUID id = UUID.fromString(segs.get(1));
			final String text = Strings.emptyIfNull(boData);

			return new Note(id, text);
		} else if (segs.get(0).equals(TYPE_NOTE_REFERENCE)) {
			if (segs.size() != 2) {
				throw new RuntimeException("Invalid reference for note reference. Number of segments: " + segs.size());
			}

			final UUID referencedDiagramElementId = UUID.fromString(segs.get(1));
			return new NoteReference(referencedDiagramElementId);
		}

		return null;
	}
}
