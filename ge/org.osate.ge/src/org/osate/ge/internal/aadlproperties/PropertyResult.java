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
package org.osate.ge.internal.aadlproperties;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.services.QueryService;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * Contains the result of retrieving the value of a property for a specified model element.
 *
 */
public class PropertyResult {
	public static enum NullReason {
		ARRAY_ELEMENT_SPECIFIC,
		MODAL,
		BINDING_SPECIFIC,
		UNDEFINED
	}

	// An object of this class will either have a non-null value or a reason why the value is null.

	/**
	 * value is the value of the property when it is not specific to an array index, mode, or binding.
	 * The value will be null if any of the flags are true or if there is not a value for the property
	 */
	public final Object value;
	public final NullReason nullReason;

	public PropertyResult(final NullReason nullReason) {
		this.value = null;
		this.nullReason = Objects.requireNonNull(nullReason, "nullReason must not be null");
	}

	public PropertyResult(final Object value) {
		this.value = Objects.requireNonNull(value, "value must not be null");
		this.nullReason = null;
	}

	/**
	 * Does not include inherited or default values
	 * @param qr
	 * @param q
	 * @param p
	 * @param ancestorLevelOffset is the offset between the queryable the value is being retrieved for an the queryable specified. (This function
	 * is called recursively for inherited properties)
	 * @return
	 */
	public static PropertyResult getProcessedPropertyValue(final AadlPropertyResolver qr,
			final QueryService queryService,
			final Queryable q,
			final Property p) {
		// Return null if the business object isn't a named element.
		Object bo = q.getBusinessObject();
		if(!(bo instanceof NamedElement)) {
			return null;
		}

		// Return null if the element doesn't accept the property
		final NamedElement namedElement = (NamedElement)bo;
		if(!namedElement.acceptsProperty(p)) {
			return null;
		}

		// Only look at property associations that are applied to the queryable
		final Stream<ProcessedPropertyAssociation> completelyProcessedPpas = qr.getProcessedPropertyAssociations(q, p).stream().filter(ppa -> ppa.isCompletelyProcessed());
		return createPropertyResult((Iterable<ProcessedPropertyAssociation>)completelyProcessedPpas::iterator, q, queryService);
	}

	public static <T, K, V> Collector<T, ?, ImmutableMap<K,V>> toImmutableMap(
			Function<? super T, ? extends K> keyMapper,
			Function<? super T, ? extends V> valueMapper) {
		return Collector.of(
				ImmutableMap.Builder<K, V>::new,
				(b, e) -> b.put(keyMapper.apply(e), valueMapper.apply(e)),
				(b1, b2) -> b1.putAll(b2.build()),
				ImmutableMap.Builder::build);
	}

	/**
	 * Returns incompletely processed reference property values. Such property values apply to children of the specified queryable.
	 * @param pr
	 * @param queryService
	 * @param q is the queryable for which incompletely processed property values should be retrieved.
	 * @param p
	 * @return a mapping whose key describes the child model element to which the property result applies and whose value is the property result.
	 */
	public static Map<String, PropertyResult> getIncompletelyProcessedReferencePropertyValues(final AadlPropertyResolver pr,
			final QueryService queryService,
			final Queryable q,
			final Property p) {
		// Return an empty map if the business object isn't a named element.
		final Object bo = q.getBusinessObject();
		if(!(bo instanceof NamedElement)) {
			return Collections.emptyMap();
		}

		final Multimap<String, ProcessedPropertyAssociation> elementPathToIncompletelyProcessedPropertyAssociations =
				Multimaps.index(pr.getProcessedPropertyAssociations(q, p).stream().filter(ppa -> !ppa.isCompletelyProcessed()).iterator(),
						ppa -> ppa.getUnprocessedPathDescription());

		return elementPathToIncompletelyProcessedPropertyAssociations.asMap().entrySet().stream().collect(toImmutableMap(Map.Entry::getKey,
				e -> createPropertyResult(e.getValue(), q, queryService)));
	}

	/**
	 * Create a PropertyResult from a collection of processed property associations.
	 * @param ppas is the collection of process property associations. All processed property associations must apply to the same model element.
	 * @param q
	 * @param queryService
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static PropertyResult createPropertyResult(final Iterable<ProcessedPropertyAssociation> ppas,
			final Queryable q,
			final QueryService queryService) {
		// Find the value which isn't tied to a specific array element, mode, or binding
		Object value = null;

		for(ProcessedPropertyAssociation ppa : (Iterable<ProcessedPropertyAssociation>)ppas::iterator) {
			// Check for cases which result in not being able to return the property value
			if(ppa.hasArrayIndices()) {
				return new PropertyResult(NullReason.ARRAY_ELEMENT_SPECIFIC);
			}

			if(ppa.isModal()) {
				return new PropertyResult(NullReason.MODAL);
			}

			if(ppa.isBindingSpecific()) {
				return new PropertyResult(NullReason.BINDING_SPECIFIC);
			}

			final PropertyAssociation pa = ppa.getPropertyAssociation();
			for(final ModalPropertyValue mpv : pa.getOwnedValues()) {
				final Object newValue = convertValue(queryService, mpv.getOwnedValue(),
						ppa.getPropertyAssociationOwnerAncestorLevel());
				if(value != null && newValue instanceof LinkedList) {
					final LinkedList<Object> valueList = ((LinkedList<Object>)value);

					// Iterate backwards so we can prepend bindings properly.
					final List<Object> newList = (List<Object>)newValue;
					for(int i = newList.size() - 1; i >= 0; i--) {
						final Object newListElement = newList.get(i);
						valueList.addFirst(newListElement);
					}
				} else {
					value = newValue;
				}
			}

			// Stop determining the value unless appending to a list.
			if(!pa.isAppend()) {
				break;
			}
		}

		return value == null ? new PropertyResult(NullReason.UNDEFINED) : new PropertyResult(value);
	}

	private static Object convertValue(final QueryService queryService, final PropertyExpression propertyExpression,
			final int processedAppliedToPathElements) {
		if(propertyExpression == null) {
			return null;
		}

		if(propertyExpression instanceof ListValue) {
			// Convert the ListValue to a java list
			final ListValue lv = (ListValue)propertyExpression;
			final List<Object> convertedList = new LinkedList<>();
			for(final PropertyExpression innerExpression : lv.getOwnedListElements()) {
				final Object innerValue = convertValue(queryService, innerExpression, processedAppliedToPathElements);
				if(innerValue != null) {
					convertedList.add(innerValue);
				}
			}

			return convertedList;
		} else if(propertyExpression instanceof ReferenceValue) {
			return new ReferenceValueWithContext((ReferenceValue)propertyExpression, processedAppliedToPathElements);
		} else {
			return propertyExpression;
		}
	}
}
