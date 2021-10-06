/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.services;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;

/**
 * Service providing a mechanism for making changes to the model
 * Only {@link EObject} instances may be modified using the modification service.
 */
public interface AadlModificationService {
	/**
	 * Represents a change to the model.
	 * A modification is provided to the modification service in order to execute it.
	 *
	 * @param <T> the type of the tag passed to the tag to business object mapper
	 * @param <B> the type of business object being modified
	 */
	static class Modification<T, B extends EObject> {
		/**
		 * Value used by mapper to determine the business object to modify. Optional.
		 */
		private final T tag;

		/**
		 * Maps the tag to the business object which should be modifying. The mapper allows the business object to be lazily determined.
		 * It also allows the mapping to take place after the model has been locked. If the mapper returns null, then the modification is skipped.
		 */
		private final Function<T, B> tagToBusinessObjectMapper;

		/**
		 * The the object which is used to modify the model.
		 */
		private final Modifier<T, B> modifier;

		/**
		 * Returns the modifier's tag
		 * @return the modifier's tag
		 */
		public T getTag() {
			return tag;
		}

		/**
		 * Returns a function which maps the tag to the business object to modify
		 * @return a function which maps the tag to the business object to modify
		 */
		public Function<T, B> getTagToBusinessObjectMapper() {
			return tagToBusinessObjectMapper;
		}

		/**
		 * Returns the modifier to call to modify the business object
		 * @return the modifier to call to modify the business object
		 */
		public Modifier<T, B> getModifier() {
			return modifier;
		}

		private Modification(final T tag, final Function<T, B> tagToBusinessObjectMapper,
				final Modifier<T, B> modifier) {
			this.tag = tag;
			this.tagToBusinessObjectMapper = Objects.requireNonNull(tagToBusinessObjectMapper,
					"tagToBusinessObjectMapper must not be null");
			this.modifier = Objects.requireNonNull(modifier, "modifier must not be null");
		}

		/**
		 * Creates a modification with a tag and mapping function from that tag to the business object to be modified.
		 * @param tag see {@link #getTag()}
		 * @param tagToBusinessObjectMapper see {@link #getTagToBusinessObjectMapper()}. Must not be null
		 * @param modifier see {@link #getModifier()}
		 * @return the new modification
		 */
		public static <TagType, BusinessObjectType extends EObject> Modification<TagType, BusinessObjectType> create(final TagType tag,
				final Function<TagType, BusinessObjectType> tagToBusinessObjectMapper,
				final Modifier<TagType, BusinessObjectType> modifier) {
			return new Modification<>(tag, tagToBusinessObjectMapper, modifier);
		}

		/**
		 * Creates a modification for an explicitly specified business object.
		 * @param bo the business object to modify
		 * @param modifier see {@link #getModifier()}
		 * @return the new modification
		 */
		public static <BusinessObjectType extends EObject> Modification<BusinessObjectType, BusinessObjectType> create(final BusinessObjectType bo,
				final SimpleModifier<BusinessObjectType> modifier) {
			return new Modification<>(bo, bo1 -> bo1, (obj, boToModify1) -> modifier.modify(boToModify1));
		}
	}

	/**
	 * Function interface for objects which perform model modifications
	 *
	 * @param <T> the type of the tag passed to the modifier
	 * @param <B> the type of business object being modified
	 */
	static interface Modifier<T, B extends EObject> {
		/**
		 * Called to modify the model
		 * @param tag the modification's tag. See {@link Modification#getTag()}
		 * @param boToModify the business object to modify. Only business objects retrieved from this object should be modified. If the tag is a
		 * model object, it should be treated as non-modifiable and may not belong to the same resource.
		 */
		void modify(final T tag, final B boToModify);
	}

	/**
	 * A minimal functional interface for object which perform model modifications
	 *
	 * @param <B> the type of business object being modified
	 */
	static interface SimpleModifier<B extends EObject> {
		/**
		 * Called to modify the model
		 * @param boToModify the business object to modify
		 */
		void modify(final B boToModify);
	}

	/**
	 * Functional interface for a callback which is invoked when modifications are complete.
	 *
	 */
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
	 * @param modifications the modifications to perform
	 * @param postProcessor the post process to notify after completion
	 */
	void modify(
			List<? extends Modification<?, ?>> modifications,
					ModificationPostprocessor postProcessor);

	/**
	 * Performs modifications without a post processor
	 * @param modifications the modifications to perform
	 * See {@link #modify(Modification, ModificationPostprocessor)}
	 */
	default void modify(List<? extends Modification<?, ?>> modifications) {
		modify(modifications, null);
	}

	/**
	 * Performs a single modification with a post processor
	 * @param modification the modification to perform
	 * @param postProcessor the post processor to notify after completion
	 */
	default void modify(Modification<?, ?> modification, ModificationPostprocessor postProcessor) {
		modify(Collections.singletonList(modification), postProcessor);
	}

	/**
	 * Performs a single modification
	 * @param modification the modification to perform
	 */
	default void modify(Modification<?, ?> modification) {
		modify(modification, null);
	}

	/**
	 * Creates a modification and performs it
	 * @param <B> the type of business object being modified
	 * @param bo the business object to modify
	 * @param modifier the object which will perform the model modification
	 */
	default <B extends EObject> void modify(final B bo, final SimpleModifier<B> modifier) {
		modify(Modification.create(bo, modifier), null);
	}
}
