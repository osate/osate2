# AADL Syntax Guide

This section gives a brief overview of AADL syntax and naming rules.  The full AADL 2.1 grammer is available on a handy [syntax card](http://www.aadl.info/aadl/documents/AADL%20V2.1%20Syntax%20Card.pdf).

A complete and formal definition of the syntax is given in the AADL standard and in the book [_Model-Based Engineering with AADL: An Introduction to the SAE Architecture Analysis é Design Language_](http://www.informit.com/store/product.aspx?isbn=0321888944).



## AADL Identifier

A name must
* Start with a letter
* May be continuted by any number of letters or digits or underscoares `_`
* Not contain a space or special character

> **Example**
>
>     pr_server

> **Example**
>
>     MyProcess

> **Example**
>
>     Thread_Listener2



### White Space

Space, tab, and newline charactesr are considered white space.



### Case Sensitivity

AADL is *case insensitive* for both keywords and identifiers.

> **Example**
>
> The following is legal AADL syntax and the block end of the type definition is correctly matched with its beginning.
>
>     Process PR_Server
>         -- ...
>     END pr_SERVER;



## Comments

Comments start with the keyword `--` and go to the end of the line.  They may begin in the middle of a line.

> **Example**
>
>     -- This comment starts on a line with no other AADL syntax
>     process pr_process -- this comment follows other AADL syntax
>     end pr_process;



## Lists

Lists are denoted inside of parentheses `(` `)`.  List elements are separated by a comma `,`.

> **Example**
>
>     process pr_server
>     properties
>         Source_Text => ( "server.c", "server.h" );
>     end pr_server;



## Block Structure

Component types, component implementations, feature group types, packages, and property sets must end with the keyword `end` followed by their name.

> **Example**
>
>     process pr_server
>         -- ...
>     end pr_server;



## Package Names

A package name is a sequence of AADL identifiers separated by double colons `::`.  As with Java package names, sequence of identifiers provides nesting.

> **Example**
>
> The following are non-nested package names:
> * `MyComponents`
> * `Libary`
> * `local_components`

> **Example**
>
> The package `aircaft::hardware` is nested in the package `aircraft`.



## Property Set Names

Property sets are named by a single identifer.

> **Example**
>
>     property set data_types is
>         -- ...
>     end data_types;


## Qualified Names

Component types, component implementations, and feature group types declared in another package must have their names qualified by the name of the package in which they are declared.  The package name is separated from the type name using the double colon `::`.

A name does not need to be qualified when used within the package in which it is declared.

> **Example**
>
> The data type `data_frame` must be qualified by its package name `basic_types` because it is being referenced from the package `aircraft::software`.
>
>     package aircraft::software
>     public
>         thread thr_producer
>         features
>             out_data_stream : out event data port basic_types::data_frame;
>         end thr_producer
>     end aircraft::software



## Component Implementation Names

An implementation name is built from the name of a *component type* followed by a period `.` followed by a name for the implementation.

> **Example**
>
>     process pr_server ... end pr_server;
>     
>     process implementation pr_server.single_threaded ... end pr_server.single_threaded;
>     
>     process implementation pr_server.multi_threaded ... end pr_server.multi_threaded;

