package org.osate.ge.internal.services;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;

/**
 * Service providing a mechanism for making changes to the model
 * Only EObjects may be modified using the modification service.
 */
public interface AadlModificationService {
	/**
	 * POJO representing a change to the model.
	 * A modification is provided to the modification service in order to execute it.
	 *
	 * @param <TagType>
	 * @param <BusinessObjectType>
	 */
	static class Modification<TagType, BusinessObjectType extends EObject> {
		/**
		 * Value used by mapper to determine the business object to modify. Optional.
		 */
		private final TagType tag;

		/**
		 * Maps the tag to the business object which should be modifying. The mapper allows the business object to be lazily determined.
		 * It also allows the mapping to take place after the model has been locked. If the mapper returns null, then the modification is skipped.
		 */
		private final Function<TagType, BusinessObjectType> tagToBusinessObjectMapper;

		/**
		 * The the object which is used to modify the model.
		 */
		private final Modifier<TagType, BusinessObjectType> modifier;

		public TagType getTag() {
			return tag;
		}

		public Function<TagType, BusinessObjectType> getTagToBusinessObjectMapper() {
			return tagToBusinessObjectMapper;
		}

		public Modifier<TagType, BusinessObjectType> getModifier() {
			return modifier;
		}

		private Modification(final TagType tag, final Function<TagType, BusinessObjectType> tagToBusinessObjectMapper,
				final Modifier<TagType, BusinessObjectType> modifier) {
			this.tag = tag;
			this.tagToBusinessObjectMapper = Objects.requireNonNull(tagToBusinessObjectMapper,
					"tagToBusinessObjectMapper must not be null");
			this.modifier = Objects.requireNonNull(modifier, "modifier must not be null");
		}

		/**
		 * Creates a modification with a tag and mapping function from that tag to the business object to be modified.
		 * @param tag must not be null
		 * @param tagToBusinessObjectMapper
		 * @param modifier
		 * @return
		 */
		public static <TagType, BusinessObjectType extends EObject> Modification<TagType, BusinessObjectType> create(final TagType tag,
				final Function<TagType, BusinessObjectType> tagToBusinessObjectMapper,
				final Modifier<TagType, BusinessObjectType> modifier) {
			return new Modification<>(tag, tagToBusinessObjectMapper, modifier);
		}

		/**
		 * Creates a modification for an explicitly specified business object.
		 * @param bo
		 * @param modifier
		 * @return
		 */
		public static <BusinessObjectType extends EObject> Modification<BusinessObjectType, BusinessObjectType> create(final BusinessObjectType bo,
				final SimpleModifier<BusinessObjectType> modifier) {
			return new Modification<>(bo, bo1 -> bo1, (obj, boToModify1) -> modifier.modify(boToModify1));
		}
	}

	static interface Modifier<TagType, BusinessObjectType extends EObject> {
		void modify(final TagType tag, final BusinessObjectType boToModify);
	}

	static interface SimpleModifier<BusinessObjectType extends EObject> {
		void modify(final BusinessObjectType boToModify);
	}

	static interface ModificationPostprocessor {
		/**
		 * Calls after all modifications are performed.
		 * @param allSuccessful is true if all the modifications were completed successfully
		 */
		void modificationCompleted(boolean allSuccessful);
	}

	/**
	 * Performs a series of modifications then executes a post processor. Performing all modifications with a single call is preferred because the implementation
	 * may perform locking to prevent change notifications while modifications are being performed. If any of the modifications fail, subsequent modifications will not be performed.
	 * @param modifications
	 * @param postProcessor
	 */
	void modify(
			List<? extends Modification<?, ?>> modifications,
					ModificationPostprocessor postProcessor);

	default void modify(List<? extends Modification<?, ?>> modifications) {
		modify(modifications, null);
	}

	default void modify(Modification<?, ?> modification, ModificationPostprocessor postProcessor) {
		modify(Collections.singletonList(modification), postProcessor);
	}

	default void modify(Modification<?, ?> modification) {
		modify(modification, null);
	}

	default <BusinessObjectType extends EObject> void modify(final BusinessObjectType bo,
			final SimpleModifier<BusinessObjectType> modifier) {
		modify(Modification.create(bo, modifier), null);
	}
}
