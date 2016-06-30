# Adding Support for a new Business Object
**This capability is currently in development. The documentation will be updated as the extension points are finalized.**

Extending the graphical editor with support for a new type of business object requires multiple extensions. A business object is a generic term used to refer to any object which is represented by pictogram elements inside of a diagram. For example, a business object may be an element in the AADL declarative model or an element in an annex library.

## Reference Builders and Reference Resolvers
Referenced Builders and Reference Resolvers are both registered using the org.osate.ge.references extension point. The graphical editor uses reference builders to generate a serializable reference to a business object.  Reference resolvers are used to retrieve a business object using the previously generated reference.

References are used to associate a pictogram element with a business object. References are stored in the diagram and must be unique to the business object. All business objects for which a pictogram element is associated must be handled by a reference builder and resolver. A single reference builder/resolver pair may handle multiple types of business objects.				

### Reference Builders
In addition to building references, reference builders may optionally produce a user friendly title for a business object. It may also provide the ability to determine the project to which the business object belongs. The latter capabilities are required when the object may serve as the root business object for a diagram.					

The DeclarativeReferenceBuilder class may be used as an example of a reference builder.

#### Required Annotations:
* BuildReference

#### Optional Annotations:
* GetProject
* GetTitle

#### Supported named parameters:
* BUSINESS_OBJECT(BuildReference)

### Reference Resolvers
The DeclarativeReferenceResolver class may be used as an example of a reference resolver.

Reference resolvers differ from reference builders and other extensions in a couple ways.

* Instances are not shared between diagrams.
* Constructors may accept arguments. As with method invocations, arguments are injected using dependency injection.

#### Required Annotations:
* ResolveReference

#### Optional Annotations:
* PreDestroy

#### Supported named parameters:
* REFERENCE(ResolveReference)
