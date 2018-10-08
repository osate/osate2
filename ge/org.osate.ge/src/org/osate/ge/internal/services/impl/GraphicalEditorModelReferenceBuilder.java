package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Named;

import org.eclipse.xtext.util.Strings;
import org.osate.ge.di.BuildCanonicalReference;
import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.model.Note;
import org.osate.ge.internal.model.NoteReference;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.internal.model.Tag;
import org.osate.ge.services.ReferenceBuilderService;

/**
 * Reference builder which builds references to graphical editor specific model objects.
 *
 */
public class GraphicalEditorModelReferenceBuilder {
	public final static String TYPE_TAG = "tag";
	public final static String TYPE_PROPERTY_VALUE_GROUP = "pvg";
	public final static String TYPE_NOTE = "note";
	public final static String TYPE_NOTE_REFERENCE = "note_reference";

	@BuildRelativeReference
	public String[] getRelativeReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if (bo instanceof BusinessObjectProxy) {
			return ((BusinessObjectProxy) bo).getRelativeReference().toSegmentArray();
		} else if (bo instanceof Tag) {
			final Tag uv = (Tag) bo;
			return new String[] { TYPE_TAG, uv.key };
		} else if (bo instanceof PropertyValueGroup) {
			final PropertyValueGroup pvg = (PropertyValueGroup) bo;
			final String propertyName = pvg.getProperty().getQualifiedName();
			if (propertyName == null) {
				return null;
			}

			// Build reference segments
			final List<String> segments = new ArrayList<>(3);
			segments.add(TYPE_PROPERTY_VALUE_GROUP);
			segments.add(propertyName.toLowerCase());

			if (pvg.getReferenceId() != null) {
				segments.add(pvg.getReferenceId().toString());
			}

			return segments.toArray(new String[segments.size()]);
		} else if (bo instanceof Note) {
			final Note note = (Note) bo;
			return new String[] { TYPE_NOTE, note.getId().toString() };
		} else if (bo instanceof NoteReference) {
			final NoteReference noteReference = (NoteReference) bo;
			return new String[] { TYPE_NOTE_REFERENCE, noteReference.getReferencedDiagramElementId().toString() };
		} else {
			return null;
		}
	}

	@BuildCanonicalReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo,
			final ReferenceBuilderService refBuilder) {
		if (bo instanceof BusinessObjectProxy) {
			return ((BusinessObjectProxy) bo).getCanonicalReference().toSegmentArray();
		}
		return null;
	}

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
