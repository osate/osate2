# Types and Expressions in ALISA

[TOC levels=2-4 bullet hierarchy]

*ReqSpec* allows the user to introduce typed variables and specify
predicates using an expression notation. Similarly, *Verify* allows users to specify formal parameters
for verification methods and actual parameter values to be used when
verification activities call verification methods. This section provides
details on how to specify types and expressions.

## Specifying Types

The types of variables and formal parameters can be numeric values with an optional measurement unit, numeric value ranges, as well as Booleans, strings, references to model elements, and values of any user defined property type. Acceptable measurement units are any unit defined as Units literals in property sets of the AADL core language. 

```
TypeSpec ::= BaseType | typeof <PropertyName>
BaseType ::= boolean 
  | string 
  | integer (units <UnitsTypeName> )?
  | real (units &lt;UnitsTypeName&gt; )? 
  | model element 
  | &lt;PropertyTypeName&gt;
```

Users can introduce new types through the property sublanguage of AADL by defining new property types. They can also use predeclared property types that come with the AADL V2.2 standard.

## Expression Notation

This section describes the initial expression notation support for
*ReqSpec* and *Verify* in the OSATE 2.2.1 maintenance release of May
2015. The expression notation will be aligned with the emerging AADL
Constraint Annex.

It supports the specification of value predicates in ReqSpec and of
actual parameter values in calls to verification methods in verification
plans expressed in Verify.

The expression notations allows for reference to constants and compute
variables defined in ReqSpec, to properties in the AADL model,literals
of the various types, as well as references to model elements.

Operators in increasing precedence order in ReqSpec expressions

* *Logical OR*: **or** 

* *Logical AND*: **and** 

* *Equality*: **==** **!=** 

* *Relational*: **&lt;** **&lt;=**, **&gt;**, **&gt;=** for &lt;numeric&gt; 

* *Containment*:  &lt;numeric&gt; **in** &lt;range&gt; and  &lt;range&gt; **in** &lt;range&gt;

* *Additive*: &lt;numeric&gt; **+**  **-** for &lt;numeric&gt; &lt;range1&gt; 

* *Multiplicative*: *****  for &lt;numeric&gt; &lt;range&gt; (range intersection) **/** for lt;real&gt;  **div** **mod** &lt;integer&gt;  For multiplication at most one argument may have a units type. For division, if theright hand side argument has a unit it must be of the same type as the unit the left hand side.         

* *Unary*: **+** **-** for &lt;numeric&gt;\  **not** for &lt;Boolean&gt; 

 
## Primary Expressions

Unit operations for numeric
expressions

* Unit assignment to a
unit-less expression
 `&lt;primary expression&gt; &lt;unit name&gt;\`
 Example: (x **+** 1) ms, where X is an integer or real value without a
unit.

* Conversion to numeric value
without unit
 `&lt;primary expression&gt; **in** &lt;unit name&gt;` 
 Example: (2.0ms) **in** ns, evaluates to 2000

* Conversion to different unit
 `&lt;primary expression&gt; **%** &lt;unit name&gt;`
 Example: (2ms) **%** ns, evaluates to 2000ns

Conditional expression 
**if** &lt;Boolean&gt; **then** &lt;expression1&gt; **else**
&lt;expression2&gt; **endif**
 Both expression1 and expression2 must have the same type.

Reference to model element
 **this**.&lt;element name&gt;.&lt;element name&gt;. … .&lt;element
name&gt;
 The keyword **this** refers to the target classifier of the requirement
or requirement set.

Reference to property value
in model
 &lt;model element&gt;\#&lt;property name&gt;\
 \#&lt;property name&gt; (short form of **this**\#&lt;property
name&gt;)
 The property name must be a property or a property constant, the model
element must be either a literal model element reference or a value of
type model element.

Literals with examples

* Boolean literal: true,
false

* Integer literal, optionally
with unit: 2000, 20ms

* Real literal: 12.5, 2.5ms

* String literal: “strings
are enclosed in double quotes”

* Range literal: \[1 .. 5\],
\[500ms .. 2s\]\
 Note that a space character is needed before the two dots.

Automatic type conversion
between Real and Integer occurs to match the target type. For example
users can assign an Integer value (numeric value without decimal point)
to a *constant* of type Real. Similarly, addition of an Integer value
and a Real value results in a Real value.

Built-in functions: the
following built-in functions are supported

* *min*, *max*: minimum or maximum value of one or more range or numeric values. Takes into account units.

* *abs*: absolute value for integer and real values

* *floor*, *ceil*, *round*: next lower, higher, closest Integer value
for a given Real value. Any unit is carried over to the new value.

