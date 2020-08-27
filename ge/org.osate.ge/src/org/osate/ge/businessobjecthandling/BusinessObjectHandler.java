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
package org.osate.ge.businessobjecthandling;

import java.util.Optional;

import org.osate.ge.BusinessObjectProvider;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.RelativeBusinessObjectReference;

/**
 * Handles the graphical behavior for a business object. The business object must be contributed using a
 * {@link BusinessObjectProvider}
 * @since 2.0
 */
public interface BusinessObjectHandler {
	/**
	 * Determines whether a business object handler is applicable based on the specified context. This method should return true if the
	 * business object handler handles the business object provided in the context. If this method returns false, no other methods will be executed
	 * for the specified business object.
	 * @param ctx is the context which contains the business object for which the handler is being checked for applicability.
	 * @return whether the business object handler is applicable based on the specified context.
	 */
	boolean isApplicable(IsApplicableContext ctx);

	/**
	 * Returns a canonical reference for the business object contained in the context.
	 * @param ctx the context containing the business object.
	 * @return a canonical reference for the business object contained in the context. Should not return null. Null is currently supported for
	 * legacy reasons but new business object handlers should not return null. The lack of a canonical reference will restrict functionality
	 * and may result in an error in a future release.
	 */
	CanonicalBusinessObjectReference getCanonicalReference(ReferenceContext ctx);

	/**
	 * Returns a relative reference for the business object contained in the context.
	 * @param ctx the context containing the business object.
	 * @return a relative reference for the business object contained in the context. Must not return null.
	 *  {@link #isApplicable(IsApplicableContext) should only return true if a relative reference can be generated for the business object.
	 */
	RelativeBusinessObjectReference getRelativeReference(ReferenceContext ctx);

	/**
	 * Returns the graphical configuration for the specified context.
	 * An empty optional should only be returned in specialized cases. In most cases a handler should return false in {@link #isApplicable(IsApplicableContext)}
	 * Such cases where an empty optional is appropriate include:
	 * <ul>
	 * <li>A business object handler for an annex library or subclause. This will override the default AADL annex library or subclause behavior and
	 * result in a representation of the annex library or subclause not appearing in the diagram.</li>
	 * <li>Cases where it is not possible to determine whether the element can be represented graphically during {@link #isApplicable(IsApplicableContext)}.
	 * For example: if the appearance of the element depends on the existence of another element.</li>
	 * </ul>
	 * @param ctx is the context for which to return the graphical configuration.
	 * @return the graphical configuration for the specified context or an empty optional if the business object should not be shown in the diagram.
	 */
	Optional<GraphicalConfiguration> getGraphicalConfiguration(GetGraphicalConfigurationContext ctx);

	/**
	 * Gets the name that should be displayed in labels for the business object in the user interface.
	 * This value is also used in the default implementations of {@link #getNameForDiagram(GetNameForDiagramContext)} and {@link #getNameForRenaming(GetNameContext)}
	 * A blank string will result in the object and its children not appearing the the outline or configure diagram dialog.
	 * @param ctx is the context for the request.
	 * @return the name that should be displayed for the business object in the user interface. Must not be null.
	 */
	String getName(GetNameContext ctx);

	/**
	 * Returns the name that should be used for the primary label for diagram elements representing the business object in the diagram editor.
	 * A blank string will result in the no label being displayed in the diagram editor.
	 * Defaults to the value returned by {@link #getNameForUserInterface}
	 * @param ctx the context for the request.
	 * @return is the name to be displayed for the business object in the diagram editor. Must not be null.
	 */
	default String getNameForDiagram(final GetNameForDiagramContext ctx) {
		return getName(new GetNameContext(ctx.getBusinessObjectContext().getBusinessObject()));
	}

	/**
	 * Gets the name of the element that is edited by the user during the renaming process.
	 * Used as the initial value when the user is editing the name of a business object.
	 * Defaults to the value returned by {@link #getNameForUserInterface}
	 * @param ctx the context for the request.
	 * @return the name that should be the initial value when a user is editing the name of a business object. Must not be null.
	 */
	default String getNameForRenaming(final GetNameContext ctx) {
		return getName(ctx);
	}

	/**
	 * Returns an icon to use for the business object specified in the context.
	 * @param ctx the context for the request.
	 * @return an optional describing the icon used for the command.
	 */
	default Optional<String> getIconId(final GetIconIdContext ctx) {
		return Optional.empty();
	}

	/**
	 * Returns true if the business object specified in the context can be renamed. If this method returns true, the business object
	 * should be supported by the graphical editor's the LTK-based rename refactoring or the business object handler must implement
	 * the {@link CustomRenamer} interface.
	 * @param ctx the context for the request.
	 * @return whether the business object can be renamed.
	 */
	default boolean canRename(final CanRenameContext ctx) {
		return false;
	}

	/**
	 * Determines whether a proposed name is a valid new name for a business object.
	 * If {@link #canRename(CanRenameContext) is implemented, this method should be implemented as well.
	 * @param ctx the context for the request.
	 * @return empty if validation succeeds. Otherwise, a validation error to be presented to the user. Must not return null.
	 */
	default Optional<String> validateName(final RenameContext ctx) {
		return Optional.empty();
	}

	/**
	 * Returns true if the business object specified in the context can be deleted.
	 * Deletable business objects must match one of the following criteria:
	 * <ul>
	 * <li>It must be an instance of {@link org.eclipse.emf.ecore.EObject}.</li>
	 * <li>It must be an instance of {@link org.osate.ge.EmfContainerProvider} and the business object handler must implement {@link CustomDeleter}.</li>
	 * <li>The business object handler must implement {@link RawDeleter}.
	 * </ul>
	 * @param ctx the context for the request.
	 * @return whether the business object can be deleted.
	 */
	default boolean canDelete(final CanDeleteContext ctx) {
		return false;
	}
}
