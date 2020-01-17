<!--
Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
All Rights Reserved.

NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
which is available at https://www.eclipse.org/legal/epl-2.0/
SPDX-License-Identifier: EPL-2.0

Created, in part, with funding and support from the United States Government. (see Acknowledgments file).

This program includes and/or can make use of certain third party source code, object code, documentation and other
files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
conditions contained in any such Third Party Software or separate license file distributed with such Third Party
Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
-->
# Requirement Specification for a System 

[TOC levels=2-4 bullet hierarchy]

This document describes a textual requirement specification notation, called
*ReqSpec.*  It draws
on the draft Requirements Definition and Analysis Language (RDAL) Annex,
which defines a meta-model for requirement specification as annotations
to AADL models. 

The objective is to support the elicitation, definition and modeling of
requirements for real-time embedded systems in an iterative process,
thus supporting the refinement of requirements along with the system
design, as well as qualitative and quantitative analysis of the created
requirements specification, and finally, the verification of the
associated system architecture models to ensure that they meet the
requirements.

The draft RDAL Annex defines a Meta model that reflects RDAL’s core
concepts. These concepts have been taken from the Requirements package
of the OMG Systems Modeling Language (SysML). In addition, many other
concepts from the FAA Requirements Engineering Management Handbook
(REMH) \[FAA 2009\], the KAOS method \[Lamsweerde 2009\] and the IEEE
Std. 830-1998 have been added to cover important aspects of RE methods
not included in SysML.

ReqSpec distinguishes between stakeholder requirements, referred to as
*goals*, and system requirements, referred to as *requirements*. Goals
express stakeholder intent and may be in conflict with each other, while
system requirements represent a contract that is expected to be met by a
system implementation.

The *ReqSpec* notation accommodates two major use cases.

First, it supports an Architecture-led Requirement Specification (ALRS)
process. In this process stakeholder goals are turned into verifiable
system requirement specifications, by annotating an AADL model of the
system of interest in its operational environment and – as appropriate –
elements of the system architecture. This process has been introduced in
\[Feiler 2015\].

Second, it supports the mapping of existing
stakeholder and system requirements documents into a set of *ReqDoc* 
files that mirror the document structure organizing requirement specifications in sections. Users can then develop an AADL model of an architecture that is implicit in the requirement text and associate the requirement specificaitons with the appropriate AADL model elements.


## Concepts of the ReqSpec Notation

ReqSpec allows users to define goals, or stakeholder requirements, and
requirements, or system requirements. Goals are expressed by *goal*
declarations and requirements by *requirement* declarations.

Goals and requirements can be organized according to the architecture
structure, by associating them with AADL component types or
implementations, or they can be organized according to a document
structure, in terms of document sections.

A *stakeholder goal set* declaration represents goals for a specific
architecture component and contains a set of *goal* declarations.

A *system requirement set* declaration represents requirements for a
specific architecture component and contains a set of *system
requirement* declarations. User can also declare a set of reusable
requirement declarations through a *global requirement set* declaration.
Such reusable requirements can then be included in system requirement
set declarations.

A *goals document* contains a *document* declaration that includes
*document section* declarations and *goal* declarations.

A *requirements document* contains a *document* declaration that
includes *document section* declarations and *requirement* declarations.


> **Summary of file extensions:**                                          
 * For *goals document*, use the extension *goaldoc*.                     
 * For *requirements document*, use the extension *reqdoc*.               
 * For *stakeholder goal set*, use the file extension *goals*.            
 * For *system requirement set* and *global requirement set,* use the extension *reqspec*.               |

The *stakeholder goal set*, *system requirement set*, *global requirement set*, *goal document*, and *requirement document* constructs
represent goal and requirement containers. They can have names with
&lt;dot&gt;-separated identifiers (e.g., aircraft.Autopilot). These
names can be used to qualify goals and the requirements contained in
them.

A *goal*, *system requirement*, or *global requirement* has an
identifier as name.

Goals and requirements can be referenced by their identifiers within the
same container or by qualifying them with their container (e.g.,
aircraft.Autopilot.Req1).

References are shown in the grammar as &lt;Goal&gt; or
&lt;Requirement&gt;, indicating the type of element being referenced.

Optional elements are shown as ( )?. Elements repeated one or more times
are shown as ( )+, and elements repeated zero or more times as ( )\*.
For example:

`( **dropped** )?`

`( DocReference )+`

`( ConstantVariable )\*`

The set of elements between square brackets, \[ \], can appear in any
order.

Finally, users should be aware that ReqSpec is case sensitive. This is
different from AADL, which is not case sensitive.

## Stakeholder Goals

ReqSpec uses the *Goal* construct to represent individual stakeholder
requirements. Stakeholder goals can be organized in two ways:
* by the *StakeholderGoalSet* construct, to represent a collection of goals for a particular system that is represented as an AADL component
* by the *GoalsDocument* construct that contains goals, possibly organized into a (nested) *DocumentSection* to reflect the structure of an existing textual stakeholder requirement document

We proceed by describing the *Goal* and *StakeholderGoals* constructs.
The *Document* and *DocumentSection* constructs are also used for
requirements and are described in Section "Documents and Document
Sections".

### The Goal Construct

The *Goal* construct represents a stakeholder goal with respect to a
particular system.

<pre>
Goal ::=
  goal Name ( : Title )?
  ( for TargetElement )? 
  [
    ( category ( CategoryReference )+ )?
    ( description Description )? 
    ( Constant )*
    ( WhenCondition )?
    ( rationale Description )?
    ( refines ( &lt;Goal&gt; )+ )? 
    ( conflicts with ( &lt;Goal&gt; )+)? 
    ( evolves ( &lt;Goal&gt; )+)? 
    ( dropped )? 
    ( stakeholder ( &lt;Stakeholder&gt; )+ )?
    ( see goal ( &lt;Goal&gt; )+)?
    ( see document ( DocReference )+ )? 
    ( issues (String)+ )?
    ( ChangeUncertainty )?
  ]
</pre>
 
`Title ::= String`

`TargetClassifier ::= &lt;AADL Component Classifier&gt;`

`TargetElement ::= &lt;ModelElement&gt;`

`CategoryReference ::= &lt;CategoryType&gt;.&lt;CategoryLabel&gt;`

`DocReference ::= ( folder ‘/’ )* file ‘.’ ext [ ‘#’ ID ('.' ID)* ]`

`Description ::= String ( &lt;Constant or Variable&gt; | this | String )*`
<pre>
WhenCondition ::= 
  when in modes &lt;Mode&gt; ( , &lt;Mode&gt; )*
  |
  when in error state &lt;ErrorState&gt; ( , &lt;ErrorState&gt; )*
  |
  when &lt;qualified name&gt; ()    // Java method call
</pre>

A goal declaration has the following elements:

* *Name*: an identifier that is unique within the scope of a goal container (requirement document or stakeholder goal set container).  


* *Title*: a short descriptor of the goal. This optional element may be used as more descriptive label than the name.


* *For*: if present it identifies the target of the goal within a system, i.e., a model element within the classifier, e.g., a port, end to end flow or subcomponent. The enclosing StakeholderGoalSet container specifies the component classifier of the system of interest.  


* *Category*: list of category references without comma separation (see Section User-defined Categories) to characterize a stakeholder goal. Such labels can be used for specifying filtered views of stakeholder goals.


* *Description*: A textual description of the goal. In its most general form this can be a sequence of strings, a reference to the classifier/model element identified by the for element (expressed by the keyword this), as well as references to Variables (see below).


* *Set of Constant*: Constants are used to parameterize goal and requirement specifications (see Section Constants and Computed Variables). Many of the changes to a goal or requirement are in a value used in the goal or requirement specification. Constants allow users to define a requirement value once and reference it in the description, predicates, and in verification activities of verification plans expressed in the Verify notation (documented in a separate report).


* *WhenCondition*: the condition under which the requirement applies. The condition is a set of AADL2 modes (operational modes), EMV2 error behavior states (failure modes), or a Java or Resolute method that takes an EObject as parameter and returns a boolean.


* *Rationale*: the rationale for a stakeholder goal in *Description* format (see above).


* *Refines*: one or more references to other goals that this goal refines. Refinement of a goal does not change the system for which the goal is specified, but represents a more detailed specification of a goal.


* *Conflicts with*: references to other goals this goal is in conflict with.  


* *Evolves*: references to other goals this goal evolves from. This allows for tracking of goals as they change over time.


* *Dropped*: if keyword is present the goal has been dropped and may be replaced by a goal that has evolved from this goal.


* *Stakeholder*: Reference to a stakeholder. Stakeholders are grouped into organizations. Each organization is defined in a separate file using the Organization notation.


* *See goal*: reference to a stakeholder goal in an imported stakeholder requirement document.  


* *See document*: reference to an external document and element within expressed as URI. This is used to record the fact that a stakeholder requirement is found in an external document, e.g., Word or DOORS.


* *Issues*: allows users to record issues that may be encountered as a set of textual notes (Strings).


* *ChangeUncertainty*: user specified indication of stakeholder goal uncertainty with respect to changes. See Section [Change Uncertainty](ReqSpecDoc.html#change-uncertainty) for details on uncertainty specifications.

> Note that when a goal is used in a *GoalsDocument*, the *for* clause can
consist of a target description string or a classifier reference
followed by a target element reference within that classifier. This
allows goals found in existing stakeholder goals documents to be mapped
into an architecture model and support identifying different systems for
different goals in the same document or document section.

### The Stakeholder Goal Set Construct

The *StakeholderGoalSet* construct is a container for *Goal*
declarations. It is typically used to group together stakeholder goals
for a particular system. It represents a name scope for the goal
declarations contained in it, i.e., a goal is referenced by the
*StakeholderGoals* name and the *Goal* name – separated by a dot.

<pre>
StakeholderGoalSet ::= 
  stakeholder goals QualifiedName ( : Title )?
  for ( TargetClassifier | all )
  ( use constants &lt;GlobalConstants&gt;* )? 
  [
    (description Description )? 
    (see document ( DocReference )+ )? 
    ( Constant )*
    ( Goal )+
    ( issues (String)+ )?
  ]
</pre>

`QualifiedName ::= Identifier ( . Identifier )*`

A *StakeholderGoalSet* declaration has the following elements:


* *QualifiedName*: name as a &lt;dot&gt; separated sequence of identifiers.


* *Title*: a short descriptor of the stakeholder goal container. This optional element may be used as more descriptive label than the name.


* *For*: if present it identifies the target of the set of stakeholder goals. This is a reference to an AADL component classifier. The keyword all is used to indicate a set of goals that can be applied to any system.


* *Use constants*: set of references to global constant definitions. The constants within those set can be referenced without qualification.


* *Description*: A textual description of the Stakeholder goals for a specific system. In its most general form this can be a sequence of strings, a reference to the classifier/model element identified by the for element (expressed by the keyword this), as well as references to Variables (see below).


* *See document*: reference to an external document. This is used to record the fact that the origin of the stakeholder requirements in this container is the identified document.


* *Set of Constant*: Constants are used to parameterize goal and requirement specifications (see Section Constant and Compute Variables). Many of the changes to a goal or requirement are in a value used in the goal or requirement specification. Variables allow users to define a requirement value once and reference it in the description, predicates, and in verification activities of verification plans expressed in the Verify notation (documented in a separate report).


* *Set of Goal*: a set of goal declarations. All contained goals are intended to be associated with the system represented by the classifier.


* *Issues*: allows users to record issues that may be encountered as a set of textual notes (Strings).


## System Requirements

*SystemRequirement* construct to
represent an individual requirement for a specific system. A system
requirement is intended to be verifiable and not in conflict with other
requirements. System requirement documents are modeled by the
*Document* construct
(see Section [Documents and Document Sections](ReqSpecDoc.html#documents-and-document-sections)). When
representing system requirements in the context of an AADL model of the
system and its operational context the *SystemRequirements* construct is
used to represent a collection of requirements for a particular system.


Users can also define requirements that are not specific to a particular
system, but are applicable to any component or components of a specified
set of component categories. Such *GlobalRequirements* can then be
included in a *SystemRequirementSet* declaration as a set or set
individual requirements through an *include* statement. The system
identified by the *SystemRequirementSet* *for* statement determines the
scope of applicability of the requirement, i.e., the requirement is
applicable to that system and its subsystems down the hierarchy that
match the category.

We proceed by describing the *SystemRequirement*,
*SystemRequirementSet*, and *GlobalRequirementSet* constructs in turn.

Note that the term *system* in system requirements is not limited to the
AADL *system* component category. A system may be represented by other
categories as well, e.g., by *abstract* or *device*.

### The System Requirement Construct

The *SystemRequirement* construct represents a system requirement.

<pre> 
SystemRequirement ::=
  requirement Name ( : Title )?
  ( for TargetElement )? 
  [
    ( quality ( &lt;Qualitylabel&gt; )+ )?
    ( category ( CategoryReference )+ )?
    ( description Description )? 
    ( Variable )*
    ( WhenCondition )?
    ( Predicate )?
    ( rationale Description )?
    ( mitigates ( &lt;Hazard&gt; )+ )? 
    ( refines ( &lt;Requirement&gt; )+)?
    ( decomposes ( &lt;Requirement&gt; )+)?
    ( inherits ( &lt;Requirement&gt; )+)?
    ( evolves ( &lt;Requirement&gt; )+)? 
    ( dropped )? 
    (development stakeholder ( &lt;Stakeholder&gt; )+ )?
    ( see goal ( &lt;Goal&gt; )+)?
    ( see requirement ( &lt;Requirement&gt; )+)?
    ( see document ( DocReference )+ )? 
    ( issues (String)+ )?
    ( ChangeUncertainty )?
  ]
</pre>

A SystemRequirement declaration has the following elements:


* *Name*: an identifier that is unique within the scope of a requirement container (requirement document or system requirement set ).  


* *Title*: a short descriptor of the requirement. This optional element may be used as more descriptive label than the name.


* *For*: if present it identifies the target of the requirement within a system, i.e., a model element within the classifier, e.g., a port, end to end flow or subcomponent. The enclosing SystemRequirements container specifies the component classifier of the system of interest.  


* *Category*: list of category references without comma separation (see Section User-defined Categories) to characterize a requirement. Such labels can be used for specifying filtered views of system requirements.


* *Description*: A textual description of the requirement. In its most general form this can be a sequence of strings, a reference to the classifier/model element identified by the for element (expressed by the keyword this), as well as references to Variables (see below).  


* *Set of Variable*: Constants and compute variables are used to parameterize requirement specifications (see Section Constants and Computed Variables). Many of the changes to a goal or requirement are in a value used in the requirement specification. Constants and compute variables allow users to define a requirement value once and reference it in the description, predicates, and in verification activities of verification plans expressed in the Verify notation (documented in a separate report).


* *WhenCondition*: the condition under which the requirement applies. The condition is a set of AADL2 modes (operational modes), EMV2 error behavior states (failure modes), or a Java method that takes an EObject as parameter and returns a boolean.


* *Predicate*: a formalized specification of the condition that must be met to indicate that the requirement is satisfied. The predicate may refer to variables defined as part of this requirement or the enclosing requirement specification container. See Section Requirement Predicates for details.


* *Rationale*: the rationale for a system requirement in Description format (see above).


* *Mitigates*: one or more references to hazards that this requirement addresses. The references are to an element in an EMV2 error model associated with the AADL model.  


* *Refines*: one or more references to other requirements that this requirement refines. Refinement of a requirement represents a more detailed specification of a requirement for the same system. Requirements for a system are refined until they become verifiable.


* *Decomposes*: one or more references to requirements of an enclosing system that this requirement is derived from, i.e., it provides traceability across architecture layers.


* *Inherits*: one or more references to requirements of an enclosing system that is being inherited as a whole. For example, requirements on interfaces of an enclosing system can be inherited by those subsystems that directly take the input or produce the output of the enclosing system. This element provides traceability across architecture layers.


* *Evolves*: references to other goals this goal evolves from. This allows for tracking of goals as they change over time.


* *Dropped*: if keyword is present the goal has been dropped and may be replaced by a goal that has evolved from this goal.


* *Development Stakeholder*: Reference to a stakeholder from the development team, e.g., a security engineer or a tester. During architecture design, design choices may lead to new requirements, whose stakeholder is the developer making the choice. Stakeholders are grouped into organizations. Each organization is defined in a separate file using the Organization notation.


* *See goal*: reference to one or more stakeholder goals that the requirement represents. The goals are assumed to be declared in a StakeholderGoals container or a Document.  


* *See requirement*: reference to a system requirement, e.g., in an imported requirement document in [ReqSpec document format](ReqSpecDoc.html#documents-and-document-sections).  


* *See document*: reference to an external document and optional element within expressed as URI. This is used to record the fact that a system requirement is found in an external document.


* *Issues*: allows users to record issues that may be encountered as a set of textual notes (Strings).


* *ChangeUncertainty*: user specified indication of stakeholder goal uncertainty.  


> Note that when a requirement is declared in a *RequirementsDocument*,
the *for* clause can consist of a target description string, or a
classifier references followed by a target element reference within that
classifier. This allows requirements found in existing system
requirements documents to be mapped into an architecture model and
supports identifying different systems for different requirements within
the same document or document section.

### The System Requirement Set Construct

The *SystemRequirementSet* construct is a container for a set of
*SystemRequirement* declarations. It is used to group together system
requirements for a particular system, namely all requirements that are
associated with an AADL component type or implementation.

<pre> 
SystemRequirementSet ::=
  System requirements QualifiedName ( : Title )?
  for TargetClassifier 
  ( use constants &lt;GlobalConstants&gt;* )? 
  [
    ( description String )? 
    (see document ( DocReference )+ )? 
    (see goals ( &lt;StakeholderGoals or GoalDocument&gt; )+ )? 
    ( Variable )*
    ( SystemRequirement )*
    ( include &lt;GlobalRequirements or global requirement&gt; 
      ( for &lt;named element&gt; | self)?
    )*
    ( issues (String)+ )?
  ]
</pre>

A *SystemRequirementSet* declaration has the following elements:


* *QualifiedName*: name as a &lt;dot&gt; separated sequence of identifiers.


* *Title*: a short descriptor of the system requirement set. This optional element may be used as a more descriptive label than the name.


* *For*: identifies the target of the set of contained system requirements by a reference to an AADL classifier. The keyword all is used to indicate a set of requirements that can be applied to any system.


* *Use constants*: set of references to global constant definitions. The constants within those sets can be referenced without qualification.


* *Description*: A textual description of the system requirements for a specific system. In its most general form this can be a sequence of strings, a reference to the classifier/model element identified by the for element (expressed by the keyword this), as well as references to Variables (see below).


* *See document*: reference to an external document. This is used to record the fact that the origin of the system requirements in this container is the identified document.


* *See goals*: reference to StakeholderGoalSet or GoalsDocument.


* *Set of Variable*: Constant and compute variables are used to parameterize requirement specifications (see Section Constants and Computed Variables). Many of the changes to a goal or requirement are in a value used in the requirement specification. Variables allow users to define a requirement value once and reference it in the description, predicates, and in verification activities of verification plans expressed in the Verify notation.


* *Set of Requirement*: a set of requirement declarations. By default all requirements are associated with the entity represented by the classifier. A requirement declaration may specify a model element within the classifier as its target in for.


* *Include*: reference to a global requirements or a requirement inside a global requirements declaration. The given component is the root of the component hierarchy in which the global requirement(s) apply. The for indicates the component categories to which the requirement applies to. Self indicates that the global requirement only applies to the component itself.  


* *Issues*: allows users to record issues that may be encountered as a set of textual notes (Strings).


    

### The Global Requirement Set and Requirement Constructs

The *GlobalRequirementSet* construct is a container for *Requirement*
declarations. A *GlobalRequirementSet* declaration differs from
*SystemRequirementSet* in that it contains *GlobalRequirement*
declarations instead of *SystemRequirement* declarations, and it does
not have a *for* statement, not an *include* statement.

<pre>
GlobalRequirementSet ::=
  global requirements QualifiedName ( : Title )?
  ( use constants &lt;GlobalConstants&gt;* )? 
  [
    ( description String )? 
    (see document ( DocReference )+ )? 
    see goals ( &lt;StakeholderGoals or GoalDocument&gt; )+ )? 
    ( Variable )*
    ( GlobalRequirement )*
    ( issues (String)+ )?
  ]
</pre>

The *GlobalRequirement* construct represents a global requirement. 
The only difference to a *SystemRequirement*
construct is the *for* statement. The for statement indicates that the
requirement is to be applied to all instances of a given component
category, or to any component, feature, connection, flow, mode, any
model element, or the instance root. 

When configured as assure global
the requirement gets associated with all instance model elements
indicated by the for. When configured by *include* in a system requirement the user can
identify a specific model element by name for the given target
type.

<pre> 
GlobalRequirement ::=
  requirement Name ( : Title )?
  ( for ComponentCategory+ | TargetType )? 
  [
  // Same as for SystemRequirement
  ]
</pre>

`ComponentCategory ::= abstract | system | &lt;other AADL component categories&gt;`

`TargetType ::= component | feature | connection | flow | mode | element | root`

## Documents and Document Sections

The *Document* construct allows users to organize stakeholder goals or
system requirement into document sections to mirror existing
documentation. This supports import of existing stakeholder requirement
or system requirement documentation into ReqSpec.

A *Document* contains a set of document sections, and stakeholder goals
or system requirements. A *DocumentSection* can recursively contain
document sections, and stakeholder goals or system requirements.

A *GoalsDocument* only contains stakeholder goals, while a
*RequirementsDocument* only contains system requirements.

<pre> 
GoalsDocument ::=
  document Name ( : Title )?
  [
    (description String )? 
    ( Goal  | DocumentSection )+ 
    (issues (String)+ )?
  ]
</pre> 
<pre> 
GoalsDocumentSection ::=
  section Title | ( Name ( : Title )?)
  [
    (description String )? 
    ( Goal  | DocumentSection )+ 
    (issues (String)+ )?
  ]
</pre> 
<pre> 
RequirementsDocument ::=
  document Name ( : Title )?
  [
    (description String )? 
    ( Requirement  | DocumentSection )+ 
    (issues (String)+ )?
  ]
</pre> 
<pre> 
RequirementsDocumentSection ::=
  section Name ( : Title )?
  [
    (description String )? 
    ( Requirement  | DocumentSection )+ 
    (issues (String)+ )?
  ]
</pre>


A *RequirementsDocument* declaration has the following elements:



* *Name*: an identifier that is globally unique (within the workspace of OSATE).


* *Title*: a short descriptor of the stakeholder goal container. This optional element may be used as more descriptive label than the name.


* *Description*: A textual description of the requirement document content. 


* *Set of Goal, Requirement, or DocumentSection*: a set of goal, requirement, or document section declarations that reflect the content of a requirement document. This may be an external document that has been imported, or a set of stakeholder or system requirements developed in ReqSpec in a traditional document format.


* *Issues*: allows users to record issues that may be encountered as a set of textual notes (Strings).


A *DocumentSection* declaration has the following elements:



* *Name*: an identifier that is unique within the enclosing container. Section names are not involved in referencing goals or requirements contained in a document section.


* *Title*: a short descriptor of the document section container. This optional element may be used as more descriptive label than the name.


* *Description*: A textual description associated with a requirement document section. 


* *Set of Goal, Requirement, or DocumentSection*: a set of goal, requirement, or document section declarations that reflect the content of a requirement document. This may be an external document that has been imported, or a set of stakeholder or system requirements developed in ReqSpec in a traditional document format.


* *Issues*: allows users to record issues that may be encountered as a set of textual notes (Strings).


## Variables and Predicates

### Constants and Computed Variables

ReqSpec allows the user to introduce *Constants* to localize common changes to a stakeholder goal or system
requirement. Constants act as parameters that can be referenced by
Description elements in goal and requirement declarations and by
Predicate elements in requirement declarations. Their values can be
expressions that result in numeric values with an optional measurement
unit, numeric value ranges, as well as Booleans, strings, references to
model elements, and values of any user defined property type. Acceptable
measurement units are any unit defined as Units literals in property
sets of the AADL core language. See [Expression Notation](TypesExpressions.html#expression-notation) for expression syntax details. The
type is inferred from the value when not explicitly declared. 

A predicate for a requirement typically compares an expected value
against a value that has been computed or measured during a verification
activity. The *ComputedVariable* declaration allows the user to
introduce the name of such variables explicitly. They can then be
referenced in predicate declarations. They can also be referenced in
verification plans that complement requirement specifications in the
architecture-led incremental system assurance (ALISA) workbench
\[Delange 2016\].

`Variable ::= Constant | ComputedVariable`

`Constant ::= val Name (: TypeSpec )? = Expression `

`ComputedVariable ::=  compute Name : TypeSpec`

`TypeSpec ::= BaseType | typeof &lt;PropertyName&gt;`

<pre> 
BaseType ::= boolean 
  | string 
  | integer (units &lt;UnitsTypeName&gt; )?
  | real (units &lt;UnitsTypeName&gt; )? 
  | model element 
  | &lt;PropertyTypeName&gt;
</pre>

### Reusable Global Constants

In some cases it is desirable to define a set of constants that can be
referenced within the *ReqSpec* model of any system. Global constants
are defined in files with the extension *constants*. The following
syntax is used in those files:

<pre> 
GlobalConstants ::=
  constants QualifiedName 
  [ ConstantVariable+ ]
</pre>

### Requirement Predicates

ReqSpec supports the specification of predicates as a formalization of a
requirement. Predicates must be satisfied as part of a verification
activity in a verification plan to produce evidence that the requirement
is met. In many verification activities, an actual value from a system
implementation is verified is compared against an expected value. The
actual value may be computed by an analysis or measured in a simulation,
test execution, or operation.

Users can specify predicates in one of several forms:



* *Free form*: informal predicate "informal specification" The user informally specifies a predicate as text. This allows users to quickly attempt to specify a predicate without getting hung up about syntax of a particular notation.


* *Value assertion*: value predicate ActualBudget <= MaxBudget 
Expressions compare actual values against expected values. This is done by comparing ReqSpec constant values, AADL property constants, AADL property values associated with the system component in an AADL model, and computed values represented by a ComputedVariable. Constants and computed variables are referenced by their name. AADL property and property constant references are prefixed by #. The expression language includes the operators: and, or, not, ==, !=, >=, <=, >, <, >< (contained in range), +, -, *, /, div (integer divide), mod. It supports parentheses and functions such as min, max, round, and abs. See Expression Notation for details.
 For example, a user specifies ActualCPUBudget <= MaxCPUBudget, where MaxCPUBudget is a constant and ActualCPUBudget is a computed variable.  


* *Behavioral assertion*: Behavioral predicate syntax will be supported in a future version of ReqSpec. Meanwhile users can specify behavioral assertions through the informal predicate construct.


## User-definable and Predefined Categories

ReqSpec allows users to associate category labels with goals and
requirements. These category labels can also be associated with
verification methods and verification activities in verification plans.

Users can then define filters on those category specifications to focus
on subsets of requirements and verification activities, e.g., on
verifying key quality attributes, or on verification activities relevant
to certain development phases.

Categories are declared in a separate file with the extension *cat*
using the following syntax:

`Categories ::= ( CategoryType )+`

`CategoryType ::= Name [ (CategoryLabel )+ ]`

The name of each category type must unique among category types. Labels
must be unique within a category type.  A category is referenced by its
type and label, e.g., *Kind.Guarantee*.

The following category types have been predefined within the ALISA
workbench:

**Kind:** to indicate the kind 
of requirement

* *Guarantee:* guarantee made by a system to its environment,
typically about its output.

* *Assumption:* assumption made by a system about its environment,
typically about its input.

* *Exception:* exceptional condition such as safety hazard or security
vulnerability that the requirement addresses.

* *Constraint:* a constraint on the implementation of a system,
typically, on the subcomponents, their properties, state, and
connectivity.

* *Consistency:* a consistency constraint between information in
ReqSpec and an AADL model or between models. For example, that the
values of ReqSpec constants are consistent with property values in the
AADL model.

**Quality:** to represent
operational quality attributes that the requirement addresses. The
following category literals are included: *Behavior*, *State*, *Timing*
(schedulability), *Latency* (response time), *Safety*, *Security*,
*Reliability*, *Availability*, *CPUUtilization*, *MemoryUtilization*,
*NetworkUtilization*, *Mass*, *ElectricalPower*

**Phase:** to represent
development phases: SystemRequirements, ArchitectureDesign, PDR, CDR,
DetailedDesign, Implementation, UnitTest, SystemTest.

**Layer:** Tier of a layered
architecture: *Tier1*, *Tier2*, *Tier3*, *Tier4*, *Tier5*.

Users can define their own category types. Users can also extend
predeclared category types by defining additional category labels using
the *CategoryType* declaration.

## Stakeholders and Their Organizations

The *organization* notation allows user to define organizations and
stakeholders that belong to organizations. Stakeholder names must be
unique within an organization. Stakeholders are referenced by qualifying
them with the organization name.

Each organization is declared in a separate file with the extension
*org*.

<pre> 
Organization::=
  organization Name
  ( Stakeholder )+

Stakeholder ::=
  stakeholder Name 
  [
    ( full name String )?
    ( title String )?
    ( description String )?
    ( role String )?
    ( email String )?
    ( phone String )?
    ( supervisor &lt;Stakeholder&gt; )?
  ]
</pre>

## Change Uncertainty

Various techniques are commonly used to prioritize entities. For
example, in the Architecture Tradeoff Analysis Method^®^ (ATAM^®^)
criticality and difficulty of change are used to prioritize use cases
during an architecture evaluation. Safety analysis practices such as SAE
ARP4761 use likelihood of occurrence and severity of impact to
prioritize hazards \[SAE 1996\] to derive design assurance levels (DAL)
to focus on high payoff safety risk reduction.

We introduce the concept of change uncertainty to assess the volatility
to change and the impact of change.

* *Volatility* represents the likelihood of change to a requirement or
architecture design. Volatility may reflect several indicators, such as
familiarity with a system, i.e., whether such a system has been
developed before, frequent changes in the operational environment,

* *Impact* represents the effort involved in performing the change and
addressing its impact other parts of a system. It may reflect indicators
such as system complexity, precedence in technology use.

These measures can identify high-payoff opportunities for reducing
requirement change. \[Nolan 2011\] has demonstrated that reduction of up
to 50% in requirement changes can be achieved based on expert assessment
of such categorical measures.

## Design Goals

RDAL distinguishes between verifiable and satisfiable requirements.
Verifiable requirements must be met, and testing will provide a
true/false result. In ReqSpec, all system and global requirements must
be verifiable. Satisfiable requirements are quantified and must be met
to a certain degree.

ReqSpec supports the specification of desirable target values that a
system design is expected to satisfy. It does so in the context of a
value predicate for a requirement. The value predicate specifies the
value or value range that the system must meet (a verifiable
requirement). This predicate can optionally be augmented with a
desirable target value that is above or below the required value or
value range (a satisfiable requirement). It is specified by optionally
adding the following to value predicates:

`with ( <constant> upto | downto <value> )+`

## Types and Predicate Expressions

For details on expressing types and predicates see [Types and Expressions in ALISA](TypeExpressions.html).


## References

**\[ALISA 2016\]**

Architecture-Led Incremental System Assurance (ALISA) Workbench. 
https://github.com/osate/alisa

**\[Delange 2016\]**

Delange, J., Feiler, P., Ernst, N., <span
*Incremental Life Cycle Assurance of Safety-Critical
Systems*, Proc. 8^th^ European
Congress on Embedded Real Time Software and Systems, Jan 2016.
<http://www.erts2016.org/inc/telechargerPdf.php?pdf=paper_13> 

**\[Eclipse 2015\]**

Eclipse. Xtend. 2015. http://www.eclipse.org/xtend

**\[FAA 2009\]**

Federal Aviation Administration. <span
*Requirements Engineering Management Handbook*
. DOT/FAA/AR-08/32. FAA. 2008.
<http://www.faa.gov/aircraft/air_cert/design_approvals/air_software/media/AR-08-32.pdf>

**\[Feiler 2015\]**

Feiler, Peter. *Requirements and Architecture Specification of the Joint
Multi-Role (JMR) Joint Common Architecture (JCA) Demonstration System*.
CMU/SEI-2015-SR-031. Software Engineering Institute, Carnegie Mellon
University. 2015.
http://resources.sei.cmu.edu/library/asset-view.cfm?assetid=447184

**\[IEEE 2009\]**

Institute of Electrical and Electronics Engineers. IEEE Standard
830-1998: Recommended Practice for Software Requirements Specifications.
IEEE Standards Association. 2009.

**\[Lamsweerde 2009\]**

van Lamsweerde, Axel van. *Requirements Engineering: From System Goals
to UML Models to Software Specifications*. Wiley. 2009.

**\[Nolan 2011\]**

Nolan, A. J.; Abrahao, S.; Clements, P.; and Pickard,
A. Managing Requirements Uncertainty in Engine Control Systems
Development. 259–264. *19th IEEE International
Requirements Engineering Conference (RE)*. Aug.
29–Sep. 2, 2011.
<http://ieeexplore.ieee.org/xpls/abs_all.jsp?arnumber=6051622&tag=1>

**\[OMG 2015\]**

Object Management Group. OMG Systems Modeling Language. OMG. 2015.
http://www.omgsysml.org

**\[OSATE 2016\]**

Open Source AADL Tool Environment (OSATE). 
https://osate.org.

**\[SAE 1996\]**

SAE International. ARP4761: Guidelines and Methods for Conducting the
Safety Assessment Process on Civil Airborne Systems and Equipment. SAE.
1996.

