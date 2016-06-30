# General Information
Extensions to the graphical editor are registered as Eclipse extensions. Each extension is implemented by the Java Extensions are implemented which have a no-argument constructor and which contains annotations to specify which methods should be called. Required services and other arguments are passed into annotated methods via dependency injection.

The graphical editor is built on top of the Graphiti framework. In many cases knowledge of Graphiti is not required, but it is needed for more advanced use cases.

## Services
The graphical editor provides a limited set of services to extensions via dependency injection. The services are designed to provide a stable interface to capabilities which are needed when implementing extensions. Services provided for use by extensions are defined in the <emphasis>TBD</emphasis> package.

**Unless otherwise noted, extensions may be reused between diagrams. Extensions should not retain references to services.**
	
**The set of services which will be provided to extensions has not yet been finalized.**
				
## Annotations
Extensions are found in the <emphasis>org.osate.ge.ext.annotations</emphasis> package. The applicable extensions depend on the type of extension being implemented. For details regarding each annotation, it is recommended to consult the annotation package.				