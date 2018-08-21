Copyright 2016 Carnegie Mellon University. See Notice.txt
Distribution Statement A: Approved for Public Release; Distribution is Unlimited.


The SimplaControlSystem project illustrates some of the features of ALISA and its different notations.

It requires the project AlisaPredefined to be included in the  workspace. 
That project can be found on Github.com/osate under alisa-examples.

It defines goals with reference to stakeholders, and requirements with reference to goals.
The requirement specifications make use of variables to paramterize requirements.
A global constant is used in the SCSGoals declarations.

Verification plans make use of OSATE plugin verification methods, registered in AlisaBasics.
They also make use of verification methods written in Resolute and registered in Resolute.methodregistry.
One of the methods takes an additional parameter beyond the instance model element always passed to a verification method.

NOTE: The file Resolute.methodregistry may show an error marker. Ignore it!!
However when you open the file error markings are shown in grey and the references have ben resolved.
The issue is that the references to Resolute claim functions are resolved by local scope, which calls on 
the EObjectDescriptions. In the first round these are not always built yet, but in a second round they are.
The marker mechanism does not refresh correctly. 
If you save the file the grey markers go away.
