/**
 * Contains interfaces for services provided by the OSATE graphical editor.
 *
 * There are two types of services. Editor services are passed as arguments to extensions or are retrieved by adapting an editor instance
 * using {@link org.eclipse.core.runtime.Adapters#adapt(Object, Class)}. In addition to being available from editor instances, global services are registered
 * as OSGi services and are also available from {@link org.eclipse.e4.core.contexts.EclipseContextFactory#createServiceContext(org.osgi.framework.BundleContext)}
 * or other APIs that provide access to OSGi services.
 *
 **/
package org.osate.ge.services;