**The extension points used for adding support for new business objects are experimental. The following documentation is out of date. These APIs will be changed while the extension points are refined.**

# Adding Support for a new Business Object
Extending the graphical editor with support for a new type of business object requires multiple extensions. A business object is a generic term used to refer to any object which is represented by a diagram element inside of a diagram. For example, a business object may be an element in the AADL declarative model or an element in an annex library.

## Non-EMF Objects
The graphical editor depends on capabilities provided by EMF objects. The [EmfContainerProvider](../api/org/osate/ge/EmfContainerProvider.html) interface must be implemented by all business objects which are not EMF objects. 

## Reference Builders and Reference Resolvers
Referenced builders and reference resolvers are both registered using the org.osate.ge.references extension point. The graphical editor uses reference builders to generate a serializable reference to a business object.  Reference resolvers are used to retrieve a business object using the previously generated reference. A single reference builder/resolver pair may handle multiple types of business objects. 

References are used to associate a diagram element with a business object. References are stored in the diagram and must be unique to the business object. 

**All business objects for which a diagram element is associated must be handled by a reference builder and resolver.**

### Reference Builders
#### Examples
* org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder
* org.osate.ge.errormodel.ErrorModelReferenceHandler

#### Required Annotations:
* [BuildReference](../api/org/osate/ge/di/BuildReference.html)

### Reference Resolvers
#### Examples
* org.osate.ge.internal.services.impl.DeclarativeReferenceResolver
* org.osate.ge.errormodel.ErrorModelReferenceHandler

Reference resolvers differ from reference builders and other extensions in a couple ways.

* Instances are not shared between diagrams.
* Constructors may accept arguments. As with method invocations, arguments are injected using dependency injection.

#### Required Annotations:
* [ResolveReference](../api/org/osate/ge/di/ResolveReference.html)

#### Optional Annotations:
* javax.annotation.PreDestroy

## Business Object Handlers
Business object handlers are classes which provide business object specific functionality to the graphical editor. They are registered using the org.osate.ge.businessObjectHandlers extension point. Business object handlers may provide partial functionality by only including a subset of the supported annotations.

#### Examples
* org.osate.ge.errormodel.businessObjectHandlers package

#### Annotations
##### Required
* [IsApplicable](../api/org/osate/ge/di/IsApplicable.html)

##### General
* [GetGraphicalConfiguration](../api/org/osate/ge/GetGraphicalConfiguration.html)
* [GetChildren](../api/org/osate/ge/di/GetChildren.html)
* [HandleDoubleClick](../api/org/osate/ge/di/HandleDoubleClick.html)

##### Business Object Creation
* [GetPaletteEntries](../api/org/osate/ge/di/GetPaletteEntries.html)
* [CanCreate](../api/org/osate/ge/di/CanCreate.html)
* [GetCreateOwner](../api/org/osate/ge/di/GetCreateOwner.html)
* [CanStartConnection](../api/org/osate/ge/di/CanStartConnection.html)
* [Create](../api/org/osate/ge/di/Create.html)

##### Business Object Deletion
* [CanDelete](../api/org/osate/ge/di/CanDelete.html)
* [Delete](../api/org/osate/ge/di/Delete.html)

##### Naming
* [GetName](../api/org/osate/ge/di/GetName.html)
* [ValidateName](../api/org/osate/ge/di/ValidateName.html)
* [SetName](../api/org/osate/ge/di/SetName.html)


