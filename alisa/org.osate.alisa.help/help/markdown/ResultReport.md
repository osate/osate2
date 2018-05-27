# Result Issue Reports

[TOC levels=2-4 bullet hierarchy]

Verification, precondition, validation activity result objects also have
a record of any issues, i.e., error, warning, or info messages providing
explanation of the results, in particular if the verification activity
fails. In our example in the previous section, Resolute claim functions
that has been registered as verification method. The claim functions
themselves call other claim functions and computational functions.
Recursively executed claim functions create a result report structure in
Resolute format. Our interface with Resolute translates that information
into a common result diagnostic format for inclusion in the assurance
case result instance. The result diagnostic format is provided by OSATE
as part of a common analysis result format provided by the plug-in
org.osate.results.

## Result Diagnostic Format

The **Diagnostic** format shown here is part of a common representation for analysis results provided by the org.osate.results plug-in. This Diagnostic is used to represent result issues in assurance case instances, i.e., file with the *assure* extension.

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

Result issues reported by OSATE analysis plug-in via Eclipse Markers, Resolute
result issues, AssertionExceptions and other Java exceptions, as well as
JUnit results are mapped into this format as part of an assurance case
result instance.
