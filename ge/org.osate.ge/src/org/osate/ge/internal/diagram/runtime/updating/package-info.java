/**
 * Contains the diagram updater and the business object tree.
 *
 * <p>The diagram updater updates the diagram to reflect changes in the model.</p>
 *
 * <p>The business object tree is a tree of {@link org.osate.ge.internal.diagram.runtime.updating.BusinessObjectNode}
 * instances which is used to represent the structure of a diagram. The benefit of this tree is that it is simpler than the diagram tree.
 * For example: it doesn't include fields related to presentation or business object handlers. It also doesn't support change tracking.
 * </p>
 *
 * <p>When updating a diagram, a business object tree is created from the diagram, modified, and then the diagram is updated to reflect the new structure.
 * The simplified tree allows the focus of {@link org.osate.ge.internal.diagram.runtime.updating.DefaultBusinessObjectTreeUpdater} to be on determining
 * what should be in the business object tree. {@link org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater} is responsible for updating a
 * diagram to reflect the business object tree and for populating additional fields. {@link org.osate.ge.internal.diagram.runtime.updating.DiagramToBusinessObjectTreeConverter}
 * is responsible for converting an {@link org.osate.ge.internal.diagram.runtime.AgeDiagram} to a business object tree.
 *
 **/
package org.osate.ge.internal.diagram.runtime.updating;