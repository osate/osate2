package org.osate.aadl2.provider.Decorator;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
//import org.eclipse.core.runtime.IPluginDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Plugin Class
 */
public class DecoratorPlugin extends AbstractUIPlugin
{

  private static DecoratorPlugin plugin_;

	public DecoratorPlugin() {
	}

	/**
	 * Constructor for DecoratorPlugin.
	 * @param descriptor Plugin Descriptor

	public DecoratorPlugin(IPluginDescriptor descriptor)
	{
		super(descriptor);
	plugin_ = this;
	}
	*/

  /**
   * Returns the shared instance.
   */
  public static DecoratorPlugin getDefault()
  {
    return plugin_;
  }

  /**
   * Returns the workspace instance.
   */
  public static IWorkspace getWorkspace()
  {
    return ResourcesPlugin.getWorkspace();
  }
}
