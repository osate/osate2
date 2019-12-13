import glob, os
import xml.etree.ElementTree as ET

tags = ['groupId', 'artifactId', 'version']

deps = ET.Element('dependencies')

for filename in glob.iglob('../../*/*/pom.xml'):
    if os.path.isfile(filename): # filter dirs
        tree = ET.parse(filename)
        root = tree.getroot()
        pkgElem = root.find('{http://maven.apache.org/POM/4.0.0}packaging')
        packaging = ''
        if pkgElem is not None:
            packaging = pkgElem.text 
        if packaging.endswith('plugin'):
            dep = ET.SubElement(deps, 'dependency')
            for tag in tags:
                nsTag = '{http://maven.apache.org/POM/4.0.0}' + tag
                pomElem = root.find(nsTag)
                if pomElem is not None:
                    depElem = ET.SubElement(dep, tag)
                    depElem.text = pomElem.text
            depElem = ET.SubElement(dep, 'optional')
            depElem.text = 'true'
            depElem = ET.SubElement(dep, 'scope')
            if packaging == 'eclipse-test-plugin':
                depElem.text = 'test'
            else:
                depElem.text = 'compile'
        

print(ET.tostring(deps, encoding='unicode'))
