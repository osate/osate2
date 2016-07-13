# General Information
Extensions to the graphical editor are registered as Eclipse extensions. Each extension is implemented by a Java class which have a no-argument constructor and which contains annotations to mark methods which should be called by the graphical editor. Required services and other arguments are passed into annotated methods via dependency injection.

## Services
The graphical editor provides a limited set of services to extensions via dependency injection. The services are designed to provide a stable interface to capabilities which are needed when implementing extensions. Services provided for use by extensions are defined in the [org.osate.ge.services](../api/org/osate/ge/services/package-summary.html) package.

**Unless otherwise noted, extensions may be reused between diagrams. Extensions should not retain references to services.**
	
## Annotations
Extensions are found in the [org.osate.ge.di](../api/org/osate/ge/di/package-summary.html) package. The applicable annotations depend on the type of extension being implemented. For details regarding each annotation, consult the API reference for the annotation.				