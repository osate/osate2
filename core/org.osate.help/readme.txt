The TOC mechanism is not able to find the contents.xml files 
for each of the manuals when they are in the zip file.
Therefore, the contents files have to be copied by hand into 
this folder and named appropriately.
Thse content files are:
javadoccontents.xml
metamodelcontents.xml
plugindevcontents.xml
refcontents.xml (reference manual aka standard document)
usermanualcontents.xml

When generating one of the manuals with MindManager you need
to make sure that the correct root is set - the default is html/ref.
You can reset that root when doing a Save as Web pages.. and then look under Customize -> Advanced Settings: HTML root path.
For example, for the user manual it should be set to html/usermanual.
