# Count component instances in an instance model
# The instance model must be selected in the AADL navigator when this script is called
# The script assumes that the selected file is an instance model file.

loadModule('/System/UI')

def is_instance_of(object, javaclass):
    return py4j.java_gateway.is_instance_of(gateway, object, javaclass)

def countComponents(instance):
    count = 1
    for c in instance.getComponentInstances():
    	count += countComponents(c)
    return count
    
def main():
    selection = getSelection('org.osate.ui.navigator.AadlNavigator')
    if is_instance_of(selection, org.eclipse.jface.viewers.IStructuredSelection):
	    selection = selection.getFirstElement()

    if is_instance_of(selection, org.eclipse.core.resources.IFile):
        print('Selection is a file named ' + selection.getName())
    else:
        print('Selection is not a file')
        return -1

    resourceSet = org.eclipse.emf.ecore.resource.impl.ResourceSetImpl()
    print('created resource set')
    
    uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(selection.getFullPath().toString(), True)
    resource = resourceSet.getResource(uri, True)
    print('loaded ' + resource.getURI().toString())

    if resource.getContents().size() == 0:
        print('resource is empty')
        return -1
	    
    systemInstance = resource.getContents().get(0)
    if is_instance_of(systemInstance, org.osate.aadl2.instance.SystemInstance):
        cs = countComponents(systemInstance)
        print('result = {}'.format(cs))
        return cs
    else:
        print('Selection is not an instance model')
        return -1

print ('executing ' + argv[0])
main()



