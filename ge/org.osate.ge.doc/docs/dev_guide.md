---
title: OSATE Graphical Editor Developer Guide
linkReferences: true
figPrefix:
- figure
- figures
tblPrefix:
- table
- tables
secPrefix:
- section
- sections
---
# Introduction
The OSATE Graphical Editor provides extension points to allow Eclipse plugins to expand the capabilities of the graphical editor.

# General Information
Extensions to the graphical editor are registered as Eclipse extensions. Each extension is implemented by a Java class which have a no-argument constructor and which contains annotations to mark methods which should be called by the graphical editor. Required services and other arguments are passed into annotated methods via dependency injection.

## Services
The graphical editor provides a limited set of services to extensions via dependency injection. The services are designed to provide a stable interface to capabilities which are needed when implementing extensions. Services provided for use by extensions are defined in the [org.osate.ge.services](../api/org/osate/ge/services/package-summary.html) package.

**Unless otherwise noted, extensions may be reused between diagrams. Extensions should not retain references to services.**
	
## Annotations
Extensions are found in the [org.osate.ge.di](../api/org/osate/ge/di/package-summary.html) package. The applicable annotations depend on the type of extension being implemented. For details regarding each annotation, consult the API reference for the annotation.

# Extension Points
The graphical editor includes several extension points.

## Categories
The graphical editor manages a list of categories. These categories are used to group items in the palette. Categories are registered using the **org.osate.ge.categories** extension point.

## Images
The graphical editor references images using unique identifiers. Images are registered using the **org.osate.go.images** extension point.

## Adding Support for a new Business Object
Extending the graphical editor with support for a new type of business object requires multiple extensions. A business object is a generic term used to refer to any object which is represented by a diagram element inside of a diagram. For example, a business object may be an element in the AADL declarative model or an element in an annex library.

### Non-EMF Objects
The graphical editor depends on capabilities provided by EMF objects. The [EmfContainerProvider](../api/org/osate/ge/EmfContainerProvider.html) interface must be implemented by all business objects which are not EMF objects. 

### Reference Builders and Reference Resolvers
Referenced builders and reference resolvers are both registered using the org.osate.ge.references extension point. The graphical editor uses reference builders to generate a serializable reference to a business object.  Reference resolvers are used to retrieve a business object using the previously generated reference. A single reference builder/resolver pair may handle multiple types of business objects. 

References are used to associate a diagram element with a business object. References are stored in the diagram and must be unique to the business object. 

**All business objects for which a diagram element is associated must be handled by a reference builder and resolver.**

#### Reference Builders
##### Examples
* org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder
* org.osate.ge.errormodel.ErrorModelReferenceHandler

##### Required Annotations:
* [BuildCanonicalReference](../api/org/osate/ge/di/BuildCanonicalReference.html)
* [BuildRelativeReference](../api/org/osate/ge/di/BuildRelativeReference.html)

#### Reference Resolvers
##### Examples
* org.osate.ge.internal.services.impl.DeclarativeReferenceResolver
* org.osate.ge.errormodel.ErrorModelReferenceHandler

Reference resolvers differ from reference builders and other extensions in a couple ways.

* Instances are not shared between diagrams.
* Constructors may accept arguments. As with method invocations, arguments are injected using dependency injection.

##### Required Annotations:
* [ResolveCanonicalReference](../api/org/osate/ge/di/ResolveCanonicalReference.html)

##### Optional Annotations:
* javax.annotation.PreDestroy

### Business Object Handlers
Business object handlers are classes which provide business object specific functionality to the graphical editor. They are registered using the org.osate.ge.businessObjectHandlers extension point. Business object handlers may provide partial functionality by only including a subset of the supported annotations.

If a business object handler exists for a parsed annex library or subclause, neither the default or the parsed annex library or subclause will be contributed automatically. This provides an extension that provides support for an annex additional flexibility in determining how the annex is represented graphically.

#### Examples
* org.osate.ge.errormodel.businessObjectHandlers package

#### Annotations
##### Required
* [IsApplicable](../api/org/osate/ge/di/IsApplicable.html)

##### General
* [GetGraphicalConfiguration](../api/org/osate/ge/di/GetGraphicalConfiguration.html)

##### Business Object Creation
* [GetPaletteEntries](../api/org/osate/ge/di/GetPaletteEntries.html)
* [CanCreate](../api/org/osate/ge/di/CanCreate.html)
* [BuildCreateOperation](../api/org/osate/ge/di/BuildCreateOperation.html)
* [CanStartConnection](../api/org/osate/ge/di/CanStartConnection.html)
* [Create](../api/org/osate/ge/di/Create.html)

##### Business Object Deletion
* [CanDelete](../api/org/osate/ge/di/CanDelete.html)
* [Delete](../api/org/osate/ge/di/Delete.html)

##### Naming
* [GetName](../api/org/osate/ge/di/GetName.html)
* [GetNameForEditing](../api/org/osate/ge/di/GetNameForEditing.html)
* [ValidateName](../api/org/osate/ge/di/ValidateName.html)
* [Rename](../api/org/osate/ge/di/Rename.html)

## Tooltip Contributors
Tooltip contributors are objects which contribute tooltip contents for a model element. When the user's cursor hovers over a pictogram element, tooltip contributors are activated to populate the tooltip.  If no content is provided, the tooltip is not shown.

Tooltip contributors are registered using the **org.osate.ge.tooltips** extension point. 

### Examples
* org.osate.ge.internal.tooltips.FeatureTooltipContributor

### Required Annotations:
* [Activate](../api/org/osate/ge/di/Activate.html)
				
