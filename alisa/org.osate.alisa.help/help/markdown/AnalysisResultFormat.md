# Common Format for Analysis Results and Diagnostics

[TOC levels=2-4 bullet hierarchy]


OSATE provides a common analysis result format through the plug-in
*org.osate.results*. An analysis result consists of 
* an *AnalysisResult* object to record the type of analysis, parameters, and instance model target,
* *Result* objects to record analysis data and diagnostic messages for a specific instance model element as well as contributors to the result through nested result objects
* *Diagnostic* objects associated with each Result object identifying the target model element for the issue, providing a message and an indicator (*info*, *success*, *failure*, *error*, *warning*, *none*).

Verification, precondition, validation activity result objects keep
a record of any issues, i.e., error, warning, or info messages that may be reported by an analysis.  
Error issues from analyses are mapped into verification *failure* diagnostics, and inability of a verification activity to complete is recorded as *error* Diagnostic.

> The class *ResultUtil* contains supporting methods to deal with Diagnostic objects.

## AnalysisResult Object as Record of an Analysis Invocation

The **AnalysisResult** object keeps a record of the type of analysis being invoked as well as the instance model target and parameters passed to the analysis. It has the following fields:

* *Analysis*: name of the analysis in string format. 

* *Parameters*: a list of serializable Java Objects represented by ObjectValue (asee below)

* *Message*: a string that can be used to record any parameters passed to the analysis method, e.g., parameters passed to the latency analysis. It is included as the tail for the resource name

* *ModelElement*: reference to the instance model target on which the analysis is to be performed, typically the instance model root

* *Results*: a collection of Result object one for each analysis instance being run, e.g., one Result object for each mode that the analysis is run.

* *Diagnostics*: a collection of Diagnostic objects providing messages regarding the analysis.


## Result Objects as Record of Analysis Results

The **Result** object provides a record of the result of an analysis execution. It includes a record of the instance model target, result data, diagnostic messages, and possibly sub-results, i.e., contributors by individual analysis steps to the overall result of an analysis execution. It has the following fields:

* *ModelElement*: reference to the instance model element with which the result is associated. This may be the original the instance model root, or any element within the instance model.

* *Type*: The ResultType of the result, i.e., *success*, *failure*, *error*, or *none*.  

* *Message*: A String message associated with the Result, i.e., the execution of an analysis or analysis step on a target. 

* *Values*: a collection of data values that represent the results of an analysis or analysis contribution. The values are of type BooleanValue, StringValue, IntegerValue, RealValue, EObjectValue, and ObjectValue. The *value* of of those types is Boolean, String, long for integer, double for real, EObject, and serializable Java Object. IntegerVlaue and RealValue may have a *unit* specified as string. 

* *Diagnostics*: a collection of Diagnostic objects providing messages regarding the analysis execution reflected in the Result object.

* *SubResults*: a collection of Result objects that represent contributions to the overall result of an analysis. For example, latency analysis uses sub-results to record latency contributions by elements of an end to end flow.

> Note that analysis providers should document the interpretation of the collection of values. 


## Diagnostic Objects as Record of Issues

The **Diagnostic** object is used to represent issues. It is typically associated with Result objects, but can also be used separate from Result objects. 
It has the following fields:

* *ModelElement*: reference to the instance model element with which the result is associated. This may be the original the instance model root, or any element within the instance model.

* *Type*: The DiagnosticType of the result, i.e., *info*, *warning*, *error*, or *none*.  

* *Message*: A String message associated with the Result, i.e., the execution of an analysis or analysis step on a target. 

## Result Type

The **Result Type** is used to record the type of result.

* *Success*: The result represents a successful execution of an analysis (step). If a predicate evaluation is part of the analysis step the predicate evaluated to true.  For example, the latency result does not exceed the specified latency limit.

* *Failure*: The result represents a successful execution of an analysis (step), but the predicate evaluation resulted in false. For example, the latency result does exceed the specified latency limit.

* *Error*: The result represents a the fact that the execution of an analysis (step) did not complete. 

* *TBD*: The result type has not been categorized.

## Diagnostic Type

The **Diagnostic Type** is used to record the type of diagnostic issue.

* *Error*: The diagnostic represents an error message. This is considered to be a failure or error of the enclosing Result object.

* *Warning*: The diagnostic represents a warning message. This is not considered to be a failure or error of the enclosing Result object.

* *Info*: The diagnostic represents an informational message. This is not considered to be a failure or error of the enclosing Result object.

* *TBD*: The diagnostic or result type has not been categorized.


## Use in ALISA

ALISA accepts verification methods that return an AnalysisResult object, a Result object, a Diagnostic object, a boolean, or any other Java object.

See [Interpretation of Return Values in ALISA](VerifyDoc.html#interpretation-of-return) for details.