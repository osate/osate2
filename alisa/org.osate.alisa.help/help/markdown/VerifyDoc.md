# Verification Plans for a System

[TOC levels=2-4 bullet hierarchy]

The *Verify* notation lets users specify *verification plans* for each *system requirement set* of system components as well as for *global requirment sets*. Verify also lets users specify a *method registry* that identifies verification methods implemented in different languages and apply to AADL models, detailed design models, and source code. 

A verification plan specifies how every requirement of a system or
global requirement set is verified. This is achieved by specifying a set
of verification activities that must complete successfully as evidence
that a requirement is met. Users specify a claim declaration for each
requirement that contains a set of verification activities. Users may
also specify an optional condition under which verification activities
are performed, e.g., one verification has to be successful for another
one to be executed, and a verification activity acts as backup if the
original one fails to complete successfully. In addition, verification
methods may have specified an optional *precondition* that must be
satisfied before the method is executed, and a result *validation* that
determines the degree of validity of the result.

A verification activity is performed on an artifact representing the
system implementation. This artifact is an AADL model representing the
architecture specification of the system, or accessible from the AADL
model, such as detailed design models, e.g., Simulink models of physical
or control behavior, or the source code. Verification activities may
also include manual activities, e.g., review of documents, design, or
code by human reviewers.

A verification activity identifies the *verification method* to be used,
and a set of parameters. By default every verification method is assumed
to accept a reference to an AADL instance model element. The
verification method may accept additional parameters, or it may expect
the relevant information to be available as a property on the AADL
model.

We support two types of methods: 

* a predicate method that evaluates the artifact to determine if it meets the requirement (success, fail); 

* a compute method that computes values (referenced by computed variables) that can be used to evaluate the predicate specified as part of the requirement or used as input parameter for a succeeding verification activity.


A verification method registry allows users to specify the type and
signature of a verification method as well as a reference to its
implementation in an implementation language neutral way. The actual
method may take a variety of forms. However, the methods have a common
interface to interface with the ALISA incremental assurance engine.
Currently we support Osate analysis plug-ins (reporting results via
Eclipse markers), Resolute (reporting results in Resolute format),
JUnit4 (reporting results via AssertionException and JUnit result
format), and Java/Xtend based method implementations (reporting result
via AssertionException, return value, or a result format defined by
ALISA.

The Verify notation supports two file extensions: 
* verify for verification plans, and 
* methodregistry for verification method specifications.

## Verification Plan

Users define one verification plan for each system requirement set or global requirement set declaration. The verification plan must have one claim for each requirement in system requirements or global requirements. The verification plans of a system and its subsystems get combined into an assurance case expressed in the Alisa notation (see [Assurance Cases](AlisaDoc.html)). 


A component type that is an extension of another component type may have a separate system requirement set declaration to represent requirements that are specific to the extension. Note that the requirements declared for the original component type are inherited by a component type or implementation extension and requirements associated with a component type are inherited by each implementation of that type. Similarly, the verification plan of the component type being extended is inherited to complement the verification activities of the extension and component implementations inherit verification plans of the component types.

Verification plans are defined in files with the extension verify. Multiple verification plans can be placed in a single file.  

<pre>
VerificationPlan ::= 
verification plan qualifiedname ( : "descriptive title" )? 
for &lt;system or global requirement set reference&gt; 
[
 ( description Description )? 
 Claim* 
 ( rationale String )? 
 ( issues ("explanation")+ )? 
] 
</pre>

The verification plan specifies a claim for each of the requirements in the requirement set identified by the for reference. 

A verification plan consists of the following:



* *Qualifiedname*: a name that consists of one or more &lt;dot&gt; separated identifiers. This name is globally known and must be unique with respect to other verification plan names. A verification plan is referenced by its name. 


* *Title*: a short descriptor of the verification plan. This optional element may be used as more descriptive label than the name.


* *For*: reference to system requirements or global requirements.  


* *Description*: A textual description of the verification plan. In its most general form this can be a sequence of strings, a reference to the classifier/model element identified by the for element (expressed by the keyword this), as well as references to Variables defined with requirements.


* *Rationale*: the rationale for a system requirement as a string.


* *Claim*: a set of claims that make up the verification plan, one claim per requirement in the requirement set identified by the for. The individual requirement can be referenced in a claim by its identifier without qualification.


* *Issues*: allows users to record issues that may be encountered as a set of textual notes (Strings).


> Note: Users may want to follow the convention to name the system requirement set and related verification plan by qualified name of the component classifier, whose requirements and verification plans are specified.

## Claim

A claim represents the set of verification activities that must be
successful for a requirement to be met. An argument expression may be
defined on the set of verification activities to specify a condition on
the combination of verification activities that must be successful. If
no argument expression is specified all verification activities must be
successful.

A claim declaration specifies a set of verification activities for a
requirement.

<pre>
Claim ::= 
claim &lt;requirement reference&gt; ( : "descriptive title" )? 
[
( activities VerificationActivity+ )?
( assert ArgumentExpression }?
( rationale String )?
( weight Integer )?
( Claim )*      // subclaims
( issues ("explanation")+ )?
] 
</pre>

A claim declaration consists of the following:



* *Requirement reference*: a reference to a requirement in the requirements set identified in the for of the enclosing verification plan. The reference identifies the requirement by its identifier without qualification.


* *Title*: a short descriptor of the claim. This optional element may be used as more descriptive label than the name.


* *Activities*: A sequence of verification activity declarations associated with a claim.  


* *Assert*: An optional argument expression specifying the argument logic for the claim. By default all verification activities are required to be successful (see below).


* *Rationale*: the rationale for a system requirement as a string.


* *Claim*: a set of zero or more subclaims. A subclaim is associated with a requirement that is a refinement of the requirement associated with a given claim.


* *Weight*: a weighting factor used in metrics to indicate the importance of different claims as evidence.


* *Issues*: allows users to record issues that may be encountered as a set of textual notes (Strings).


> Note: A requirement for a system may have been refined into
sub-requirements that are verifiable. Typically, only the leaf elements
of a requirement refinement hierarchy involve verification activities.
In other words, a claim for a requirement that has been refined only may
only contain subclaims that themselves contain verification activities.
However, the notation supports the possibility for a verification
activity for each claim in the requirement refinement hierarchy.

## Verification Activity

A verification activity specifies the verification
method to be called, the actual parameter values to be passed directly
as part of the call, values to be made available to the method via
properties associated with the component, and any result values to be
bound to **compute** variables
defined in requirements. Verification
activities can have phase and user defined category labels that will be
used for filtered views of an assurance case instance (see [Incremental Assurance Plans and Cases](AlisaDoc.html)).

A verification activity when executed can have
*success*, *failure*, or does not complete for two
reasons: *timeout* (currently not supported by the runtime system) or
any other reason (uncaught exception thrown during the execution) not to
complete indicated by *error*. This state is maintained in an instance
representation of the assurance case (see [Assurance Case
Result](AlisaDoc.html#assurance-case-result)).

<pre>
VerificationActivity ::= 
activity activityname ( : "descriptive title" )? 
  : ( &lt;result parameter list&gt; = )? 
    &lt;verification method reference&gt; ( &lt;actual parameter list&gt; )
    ( property values ( &lt;property value list&gt; ) )?
    [
      ( category categorylabel* )?
      ( timeout Integer &lt;time unit&gt; )?
      ( weight Integer )?
    ]
</pre>

`CategoryLabel ::=  CategoryTypeID . CategoryLabelID`

A verification activity declaration consists of the following:



* *Activityname*: unique name within a verification plan. Verification activities are referenced by this name in argument expressions.


* *Title*: a short descriptor of the verification activity. This optional element may be used as more descriptive label than the name.


* *Result parameter list*: comma separated list of zero or more compute variable references to hold any returned result parameter of a verification method.


* *Verification method reference*: qualified reference to a verification method in the method registry.


* *Actual parameter list*: comma separated list of zero or more actual parameter values. The target model element to be verified is passed to the method by default and does not have to be specified explicitly as an actual parameter (see 
[Verification Method Specification](VerifyDoc.html#verification-method-specification)). Acceptable parameter values are expressions that include references to constants (val) and computed variables (compute), integers and reals with or without measurement unit, strings, booleans, AADL properties, property constants, as well as references into the instance model relative to the model element that is the target of the verification - specified by *this*.<element>.<element2>.... For details of the expression language see 
[Expression Notation](TypesExpressions.html#expression-notation).


* *Property value list*: optional comma separated list of values to be made available to the verification method via an AADL property. The expected set of properties with specific value are specified as part of the verification method in the method registry. Currently the values are limited to references to constant variables (val).


* *Category*: list of user defined category labels (without comma separation) in which this verification activity should be performed. It is used when defining filter criteria (assurance task).


* *Timeout*: specification of a time limit for the execution of the verification activity. When the time limit is reached the verification activity is aborted with a timeout result error indication.


* *Weight*: a weighting factor used in metrics to indicate the importance of different verification activities as evidence.


The intent of result parameters is to provide access to computed results
from the execution of a verification method. These results can then be
evaluated by the predicate specified as part of the requirement
declaration or passed as input to succeeding verification activities.

Actual parameter and property value expressions may refer to constants
and computed variables. Those can be variables defined in requirements
or requirement sets associated with the verification activity, including
those of requirements and their containing requirement sets inherited
through the component classifier extends hierarchy.

## Argument Expression

Without an argument expression all verification expressions must be
successful for the claim to be met. The argument expression allows users
to specify condition under which verification activities are performed:
one verification has to be successful for another one to be executed
(**then**, and a verification
activity acts as backup if the original one fails to complete
successfully (**else**). In the
case of backup verification activity, users can specify a single
verification activity executed if the original one is not successful, or
users can specify separately whether they intend to have a backup
verification activity for the original activity return *Fail*, not
completing because of a *Timeout*, or
because the execution failed to complete for other reasons, e.g., the
result of an uncaught exception (*Error*).

`ArgumentExpr ::=  ElseExpr | ElseExpr then ArgumentExpr`

`ElseExpr ::= SingleElseExpr | CompositeElseExpr`

<pre>
SingleElseExpr ::=   &lt;VerificationActivity&gt; |
  &lt;VerificationActivity&gt; else  ( ElseExpr |
  [ 
    ( fail:  ArgumentExpr )?
    ( error: ArgumentExpr )?
    ( timeout: ArgumentExpr )?
  ] )
</pre>

`CompositeElseExpr ::=  CompositeExpr |  CompositeExpr else ElseExpr`

`CompositeExpr ::=  ( ArgumentExpr ) | all [ ArgumentExpr ( , ArgumentExpr)* ]`

The expression takes the following
form:

* *Then*: lets users specify an ordering of verification activities, i.e., the second verification activity is only executed if the first one is successful.  

* *Else*: lets users specify an alternate verification activity if the first one returns fail or does not complete.  

* *Fail, Error, Timeout*: lets users specify a different alternative verification activity for each of the three results of an unsuccessful first verification activity. This is possible only if the first verification activity is a single activity.

* *All*: lets users specify that all of a set of verification activities must be successful. All verification activities will be executed independent of whether they are successful or not. The result of the all operator will indicate success only if all listed verification activities were successful. 


*Brackets* allow users to
specify a change in precedence ordering of argument expression
operators. 

## Registry of Verification Methods

A verification method registry allows users to register implementations
of different verification methods in an implementation language neutral
format. Currently OSATE Analysis plug-ins, Java, Resolute, Agree, JUnit,
and manual methods are supported.

A verification method registry is defined in a separate
file with the extension *methodregistry*.

<pre>
VerificationMethodRegistry ::= 
verification methods qualifiedname ( : "descriptive title" )? 
[ 
  ( description Description )? 
  VerificationMethod+ 
] 
</pre>

The verification method registry consists of:



* *Qualifiedname*: a &lt;dot&gt; separated sequence of identifiers. The registry name acts as qualifier for verification methods.


* *Title*: a short descriptor of the verification method registry. This optional element may be used as more descriptive label than the name.


* *Description*: a description of the verification method.

* a collection of verification method specifications


## Verification Method Specification

A verification method is invoked when a verification activity is
executed. The method analyzes, simulates, or executes an AADL model, or
a detailed design model, or source code associated with a component in
the AADL model.

The verification method may evaluate a predicate to indicate whether the
verification is successful or failed to be successful, or the
verification method may compute one or more values that are turned. In
the latter case a predicate defined for the requirement may refer to the
computed variable holding the result value, or the result value may be
passed as in parameter to a succeeding verification activity.

A
verification method is assumed to always be passed the
component instance as its first parameter. This parameter does not have
to be specified in the registry. The model element type of this
parameter must be specified if it is not the component itself, i.e., if
it is a *feature*, *connection*, end to
end *flow*, or any model *element* in the
AADL instance model.

Additional parameters are passed to the method as part of the call as
specified by the list of typed formal parameters or through a property
associated with the model element being passed as first parameter.

Return values are assigned to *Computed Variables*, whose names match
the formal parameter specification of the **returns** clause.

For further details see the description below.

<pre>
VerificationMethod ::= 
method methodname 
  ( ( ( TargetType , )?
      FormalParameter ( , FormalParameter )* ) 
    ( properties ( Property ( , Property )* ) )?
    ( returns ( FormalParameter ( , FormalParameter )* ) )?
  )?
  ( : "descriptive title" )? 
  ( for &lt;ComponentClassifier&gt;  | ComponentCategory* )? 
  [ 
    MethodKind 
    ( description Description )? 
    VerificationPrecondition?
    VerificationValidation?
    ( category categorylabel* )?
  ] 
</pre>
<pre>
TargetType ::=
  component | feature | connection | flow | mode | element | root
</pre>
<pre>
MethodKind ::=
  java MethodPath  |
  plugin MethodID |
  resolute QualifiedMethodName |
  junit ClassPath |
  manual DialogIdentifier
</pre>
<pre>
FormalParameter ::=
  ID : TypeSpec ( in Unit )?
</pre>
<pre>
VerificationPrecondition ::= 
precondition &lt;method reference&gt; ( &lt;formal parameter reference list&gt; )
</pre>
<pre>
VerificationValidation ::= 
validation &lt;method reference&gt; ( &lt;formal parameter reference list&gt; ) 
</pre>

The verification method declaration consists of:



 
* *Methodname*: identifier for the method that must be unique within the registry.  


* *TargetType*: The type of the first parameter passed to the method when invoked. By default the component instance, whose requirement is verified, is passed. Some requirements apply to an element within a component instance, e.g., to a feature. In this case, users must specify the fact that the methods express a feature instance instead of a component instance. Other targets are connection instances, mode instances, and (end to end) flow instances. Element is used to indicate that a InstanceObject is expected. In the case of Java methods, the specified target type must match the class of the first parameter.  Root is used to indicate that the method is only invoked on the root of the instance model. Note: if no target type is specified, the Assure verification engine will attempt to call the registered method implementation with or without the instance model target element - this allows for methods that are independent of the instance model, e.g., computation on some input parameters, or operation such as comparison of multiple instance model elements specified as actual parameters through *this* expressions.


* *FormalParameter list*: optional comma separated list of formal parameter specifications. The formal parameter specification consists of an identifier as name, a type, and an optional specification of expected measurement unit for the value if the expected type is numeric without measurement unit. The actual value will be converted into the expected unit. This feature is useful when the method expects a value without a measurement unit.  The *TypeSpec* for a formal parameter indicates *boolean*, *integer*, *real*, *string*, *model element* for any AADL instance model element, a reference to a property type, or *typeof* <reference to property> to identify a property type. The property type may indicate any of the above basic types as well as a reference type to AADL model elements. See also [Type Spec](TypesExpressions.html#specifying-types).


* *Property list*: optional comma separated list of AADL property definition references. The references use the core AADL syntax for property references. The properties will be assigned the value specified as part of the method call in a verification activity if no property value is present for the model element. If a property value is present the value must be the same as the value specified in the call.


* *Result list*: optional comma separated list of formal parameter specifications to indicate result values. The Result object values will be assigned in order to Computed Variables specified as part of the method call in a verification activity. If the method returns a single value it is assigned to the compute variable. If the returned numeric value has no unit and **in** &lt;unitliteral&gt; is specified the unit literal is attached to the numeric value.


* *Title*: a short descriptor of the verification method registry. This optional element may be used as more descriptive label than the name.


* *For*: a restriction on the type of component the verification methods can be applied to. For example, a verificaiton methods may have been developed to only apply to threads, or for specific component classifiers.


* *MethodKind*: identification of the method implementation and implementation specific reference to the method. The following method kinds are supported*: OSATE analysis plug-ins, Resolute, Junit4, Java, Agree, Manual. See 
[Verification Method Kinds](VerifyDoc.html#supported-verification-method-kinds) for details.


* *Description*: a description of the verification method.


* *Precondition*: reference to a registered verification method that determines whether the model meets criteria for the verification method to be able to execute. If the method takes parameters their values are those of the verification method formal parameters as a comma separate list. Typically such a method will check that certain model element and expected property values are in place. The verification method in a verification activity will not execute if the precondition is not met.


* *Validation*: reference to a registered verification method that determines the validity of the results from the execution of the verification method. If the method takes parameters their values are those of the verification method formal parameters as a comma separate list. Typically such a method is used when a verification method can operate on a model with incomplete information, i.e., it will indicate how complete the input was. Similarly, the method can be used to assess whether the results are within a reserve margin, e.g., whether the result has an x% margin from the limits. The verification method may return a success result while the validation may indicate a fail.


* *Category*: list of quality attribute labels (without comma separation) that this verification method addresses. It is used when defining filter criteria via assurance tasks.


### Supported Verification Method Kinds

The following method types are supported:

* *Java*: a Java method identified by a path to a method inside a class. Note that Xtend methods can be registered this way as they get translated into Java. 
 Java methods can report violation of assertions (predicates) by throwing AssertionException. They are mapped into Fail results. This is how JUnit and Java8 support assertions (see below for registering Junit4 test classes). 
 Uncaught runtime exceptions within a Java method are also caught by the Assure execution harness and mapped into Error results. 
 Java methods can return a Boolean result, which gets mapped into Success and Fail if specified to do so by the boolean keyword. 
 Java methods can return AnalysisResult or Result in an ALISA defined format (see [Analysis Result](AnalysisResultFormat.html)).
 Java methods can return a single value as object. These values will be assigned to the specified computed variables.
 The actual Java method may expect Java types that are not part of the ALISA Types. For example, the Java method may expect a long numeric. We automatically map StringLiteral -> String, BooleanLiteral -> Boolean, RealLiteral -> double, IntegerLiteral -> long. For model element references we map InstanceReferenceValue into an InstanceObject reference.

* *Plugin*: an OSATE analysis plugin method identified by an identifier. Plugin methods are defined in a predeclared method registry (see [Predefined Method Registry](VerifyDoc.html#predefined-method-registry)). OSATE analysis plugins report their results via the Eclipse Marker mechanism. These results are mapped into the Diagnostic format (see [Analysis Result](AnalysisResultFormat.html)) for inclusion in the assurance case result instance.


* *Resolute*: a Resolute claim function or computational functions identified by the qualified name of the claim or compute function in the Resolute library. It consists of the *&lt;package name&gt;.&lt;package name&gt;_public.Resolute.Resolute.&lt;function name&gt;*. Results in the Resolute result format are mapped into the Diagnostic format (see [Analysis Result](AnalysisResultFormat.html)). In the case of computational functions the returned value is assigned to the specified Computed Variable.

> Note: by using 'control' 'shift' 'F3' you get the global scope browser to see which entities are known globally.

> Note that the use the function name by itself is considered deprecated and will not be supported in the near future.

* *JUnit*: The specified JUnit test class is invoked. Results of a JUnit run are mapped back into the Diagnostic format (see [Analysis Result](AnalysisResultFormat.html)).


* *Manual*: the method represents a manual method, i.e., a method that is performed by a human. The person will interactively report the result of the verification, e.g., the result of performing a review. 


### Built-in and User-defined Registries

ALISA comes with two built-in registries of verification methods. These registries are available in a project called *AlisaPredefined* in the Github repository https://github.com/osate/alisa-examples. One registry called *Plugins* contains OSATE analysis plugin method declarations. The second registry called *Alisa_Consistency* contains method declarations for a set of Java-based verification methods that check certain physical system properties in the model.

The *AlisaPredefined* Project also contains a set of predefined category types and labels. See the ReqSpec documentation for details.


Users can add verification methods to ALISA in several ways.

First, users can write claim functions and computational functions in
Resolute (see Resolute language specification in OSATE Help for
details). Users then define their own verification method registry to
complement the "predefined" registry. Since Resolute is an interpreted
notation, these newly registered methods are immediately available for
use. An example can be found in the project *SimpleControlSystem* found in
the Github repository https://github.com/osate/alisa-examples.

Second, users can write or make use of verification
methods written in Java or Xtend. Users may even write Java wrapper
methods to interface with existing tools or external tools, such as
Simulink or the execution of source code via JUnit
tests. 
Java methods must reside in a plug-in project that is installed as part of the OSATE installation in the *plugins* or *dropins* folder. The Java class that provides the Java methods must be recorded through the extension point *org.osate.pluginsupport.registeredjavaclasses*. See *org.osate.alisa.contribution* for an example.

Third, users can write JUnit tests and register test classes. Those
tests can operate on an AADL model or they may execute source code.

## Interpretation of Return Values

ALISA accepts verification methods that return an AnalysisResult object, a Result object, a Diagnostic object, a boolean, or any other Java object.

The return values are handled as follows:

* *AnalysisResult*: If the AnalysisResult object has the result type *error* the verification result is marked as *error*. If any of the top level Result objects in an AnalysisResult object have the result type *error* then the verification result is marked as *error*, otherwise if any top level Result objects are *failure* the verification result is marked as *failure*, otherwise (if all Result objects are *success*) the verification result is marked as *success*.

* *Result*: The Result object *ResultType* determines the *ResultType* of the VerificationResult object. In addition the Result object is recorded in *VerificationResult* as result.

* *Diagnostic*: The Diagnostic object *Type* determines the *ResultType* of the VerificationResult object. An *Error* Diagnostic results in *Failure*, otherwise it is *Success*.  In addition is Diagnostic object is recorded in *VerificationResult* as an issue.

* *Boolean*: The boolean value *true* maps into *Success* of the VerificationResult object and the value *false* maps into *Failure*. This is only done if the return value is not assigned to a compute variable.

* Values assigned to compute variables: A single return value or the Value obejcts of the top-level Result object may be assigned to compute variables. If a *value predicate* with references to the assigned compute variables exists, then the predicate is evaluated to determine *Success* or *Failure* of the VerificationResult object.

* *AssertionException*: If an analysis throws an AssertionException that is not caught by the verification method itself, the Assure engine catches it and interprets it as *Failure* in the VerificationResult object and records the AssertionException information as issue in the form of a Diagnostic object.

* *Any other Exception*: If an analysis throws any other Exception not caught by a verification method itself, the Assure engine catches it and interprets it as *Error* in the VerificationResult object.

If the return values from Result objects are assigned to compute variables and the value predicate specified in the requirement references the compute variables, then the predicate is evaluated and its result is reflected as *Success* or *Failure* in the Result object.

Issues reported by verification methods such as OSATE analysis plug-in via Eclipse Markers, Resolute
result issues, as well as
JUnit results are converted into Result and Diagnostic objects. 

For example, Resolute claim functions
that has been registered as verification method return a Resolute result that is converted into a Result object. 
Claim functions call other claim functions and computational functions,which results in a nested set of results in Resolute format. Our interface with Resolute translates that information
into a nested set of Result objects for inclusion in the assurance
case result instance. This allows for a uniform representation of analysis results.

