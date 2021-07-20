/**
 * Root package of the OSATE graphical editor API. This package and subpackages contain members used to interface with and extend the OSATE graphical editor.
 *
 * <h2>Adding Business Object Support</h2>
 * The term <i>business object</i> is used to any object which is represented on a diagram. Support for new types of business objects can be
 * added to the graphical editor by registering a {@link org.osate.ge.BusinessObjectProvider} and {@link org.osate.ge.businessobjecthandling.BusinessObjectHandler}
 * implementation.  It is strongly recommended to implement {@link org.osate.ge.referencehandling.ReferenceLabelProvider} for references returned by
 * {@link org.osate.ge.BusinessObjectProvider} implementations.
 * Typically, one ore more {@link org.osate.ge.ContentFilter} or {@link org.osate.ge.FundamentalContentFilter} will be registered as well.
 * To allow creating a business object from the palette, a {@link org.osate.ge.palette.PaletteContributor} must be registered.
 *
 * <h2>Accessing Selected Business Objects</h2>
 * The {@link org.osate.ge.BusinessObjectSelection} interface is provided to allow easily accessing and modifying the business objects associated
 * with the current diagram editor selection.
 *
 * <h2>Extending Tooltips</h2>
 * The tooltips provided by the graphical editor can be extended by registered a {@link org.osate.ge.ui.TooltipContributor}. Such tooltips can
 * add additional information related to the target diagram element.
 *
 * <h2>Adding Diagram Types</h2>
 * Diagram types can be added to the graphical editor by registering a {@link org.osate.ge.DiagramType}. A {@link org.osate.ge.referencehandling.ReferenceResolver}
 * must be registered for any business object which will be used as a context of a diagram.
 *
 * <h2>Exporting Diagrams</h2>
 * Diagrams can be converted to an image file using {@link org.osate.ge.services.DiagramExportService}.
 **/
package org.osate.ge;