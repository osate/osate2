# Common Format for Analysis Results and Diagnostics

[TOC levels=2-4 bullet hierarchy]


OSATE provides a common analysis result format through the plug-in
*org.osate.results*. An analysis result consists of 
* an *AnalysisResult* object to record the type of analysis, parameters, and instance model target,
* *Result* objects to record analysis data and diagnostic messages for a specific instance model element as well as contributors to the result through nested result objects
* *Diagnostic* objects associated with each Result object providing a message and an indicator (*info*, *success*, *failure*, *error*, *warning*, *none*).

Verification, precondition, validation activity result objects keep
a record of any issues, i.e., error, warning, or info messages that may be reported by an analysis.  
Error issues from analyses are mapped into verification *failure* diagnostics, and inability of a verification activity to complete is recorded as *error* Diagnostic.

## AnalysisResult Object as Record of an Analysis Invocation

The **AnalysisResult** object keeps a record of the type of analysis being invoked as well as the instance model target and parameters passed to the analysis. It has the following fields:

* *Analysis*: name of the analysis in string format. The name may be a path to a Java method in a class or some other unique identifier for the analysis.

* *Info*: a string that can be used to record any parameters passed to the analysis method, e.g., parameters passed to the latency analysis

* *SourceReference*: reference to the instance model target on which the analysis is to be performed, typically the instance model root

* *Results*: a collection of Result object one for each analysis instance being run, e.g., one Result object for each mode that the analysis is run.

* *Diagnostics*: a collection of Diagnostic objects providing messages regarding the analysis invocation.

> Note the parameters are explicitly specified as part of the verification method invocation. In the case of an Eclispe handler for an analysis, the parameters may come from preference settings for the analysis.

## Result Objects as Record of Analysis Results

The **Result** object provides a record of the result of an analysis execution. It includes a record of the instance model target, result data, diagnostic messages, and possibly sub-results, i.e., contributors to the overall result of an analysis execution. It has the following fields:

* *Info*: a string that can be used to record any additional information

* *SourceReference*: reference to the instance model element with which the result is associated. This may be the original the instance model root, or any element within the instance model.

* *Diagnostics*: a collection of Diagnostic objects providing messages regarding the analysis invocation.

* *Values*: a collection of data values that represent the results of an analysis or analysis contribution. The values are of type BooleanValue, StringValue, IntegerValue, or RealValue. IntegerVlaue and RealValue may have units.

* *SubResults*: a collection of Result objects that represent contributions to the overall result of an analysis. For example, latency analysis uses sub-results to record latency contributions by elements of an end to end flow.

> Note that analysis providers should document the interpretation of the collection of values. 


## Diagnostic Objects as Record of Result Issues

The **Diagnostic** object is part of a common representation for analysis results provided by the org.osate.results plug-in. This Diagnostic is used to represent result issues in assurance case instances, i.e., file with the *assure* extension.

```
Diagnostic ::=
type=DiagnosticType
message=“message”
( sourceReference=&lt;Eobject&gt; )?
( exceptionType=“exceptionType” )?
( source=“source” )?

issues=Diagnostic\*

ResultIssueType ::=
'NONE' |'ERROR' | 'WARNING' | 'INFO' | 'SUCCESS' | 'FAILURE'
```

Issues reported by OSATE analysis plug-in via Eclipse Markers, Resolute
result issues, AssertionExceptions and other Java exceptions, as well as
JUnit results are converted into Diagnostic objects as part of an assurance case
result instance.

For example, Resolute claim functions
that has been registered as verification method. The claim functions
themselves call other claim functions and computational functions.
Recursively executed claim functions create a result report structure in
Resolute format. Our interface with Resolute translates that information
into Diagnostic objects for inclusion in the assurance
case result instance.

> Note that nested issues, i.e., issues containing issues, are marked as deprecated. Users should utilize nested Result objects to represent issues related to analysis contributors, e.g., results of analyzing individual connections. 

> The class *ResultUtil* contains supporting methods to deal with Diagnostic objects.
