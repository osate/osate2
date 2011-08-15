
grammar Aadl2;
options {
	language = Java;
	backtrack = true;
}


@header {	
	package org.osate.aadl2.parser;
	
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.TreeSet;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.MismatchedNotSetException;
import org.antlr.runtime.MismatchedRangeException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MismatchedTreeNodeException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.resource.Resource;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessKind;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.ArraySpecification;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusImplementation;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.BusType;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.CallSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentPrototypeReference;
import org.osate.aadl2.ComponentReference;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionKind;
import org.osate.aadl2.ConstantValue;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupPrototypeReference;
import org.osate.aadl2.FeatureGroupReference;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureGroupTypeRename;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.GlobalNamespace;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.InternalEvent;
import org.osate.aadl2.impl.IntegerLiteralImpl;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.MemoryType;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.Numeral;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.OperationKind;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.PortCategory;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorCall;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.ProcessorSubprogram;
import org.osate.aadl2.ProcessorPort;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyReference;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyOwner;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.Realization;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordField;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.StructuralFeature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.Subprogram;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupImplementation;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.VirtualBusImplementation;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualBusType;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.VirtualProcessorType;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.aadl2.parsesupport.LocationReference;
import org.osate.annexsupport.AnnexParser;
import org.osate.annexsupport.AnnexParserRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.aadl2.parser.provider.AadlParserPlugin;
	
}

@lexer::header{
	package org.osate.aadl2.parser;
	
	import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
	import org.eclipse.core.resources.IResource; 
}


@members {
	protected Aadl2Factory Aadl2F = Aadl2Factory.eINSTANCE;
	
	protected int commentIndex=0;
	
	/**
	* All unresolved references ordered by dependencies. To determine the order look at
	* the RecordReference main() to see an example of the ordering technique used here.
	*/
	protected TreeSet<ReferenceRecord> unresolvedReferences;

	/**
	 * The error reporter to use.
	 */
	protected ParseErrorReporter errReporter = null;
	
	/**
	 * All external packages referenced in the parsed file.
	 */
	private Set referencedPackages = new HashSet();
	
	/**
	 * All packages defined iin the parsed file.
	 */
	private Set definedPackages = new HashSet();
	
	/**
	 * All external property sets referenced in the parsed file.
	 */
	private Set referencedPropertySets = new HashSet();

	/**
	 * All property sets defined in the parsed file.
	 */
	private Set definedPropertySets = new HashSet();

	/**
	 * global namespace to perform the resolution of names
	 */
	 
	private GlobalNamespace globalNamespace=null;
	
	public void setGlobalNamespace(GlobalNamespace ns){
		globalNamespace = ns;
	}
	
	
	/**
	 * Set the error reporter to use.
	 */
		
	public void setParseErrorReporter(final ParseErrorReporter reporter) {
		  errReporter = reporter;
	}
	
	String filename;
	
	public void setFilename(String fn){
		filename=fn;
	}
	
	public String getFilename(){
		return filename;
	}
	/**
	 * Report parser error
	 * @param msg  error message
	 * @param e  antlr error exception 
	 */
	public  void reportError(RecognitionException e)  {
    		String description=null;
    		if (e instanceof MismatchedTokenException){
    			MismatchedTokenException mte = (MismatchedTokenException) e;
    			if (mte.expecting != -1)
    				description = "Expecting: "+tokenNames[mte.expecting]+", found: "+mte.token.getText();
    			else
    				description = "Unexpected token '"+mte.token.getText()+"'";
    		} else if (e instanceof MismatchedTreeNodeException){
    			description = "Unexpected Tree Node Exception";
    		} else if (e instanceof NoViableAltException){
    			NoViableAltException nva = (NoViableAltException) e;
    			description = "No viable alternative: "+nva.grammarDecisionDescription;
    		} else if (e instanceof EarlyExitException){
    			EarlyExitException ee = (EarlyExitException) e;
    			description = "Early Exit";
    		} else if (e instanceof FailedPredicateException){
    			FailedPredicateException fp = (FailedPredicateException)e;
    			description = "Semantic error: "+fp.predicateText;
    		} else if (e instanceof MismatchedRangeException){
    			MismatchedRangeException mr = (MismatchedRangeException)e;
    			description = "Mismatched range: ";
    		} else if (e instanceof MismatchedSetException){
    			MismatchedSetException ms = (MismatchedSetException)e;
    			description = "Mismatched set";
    		} else if (e instanceof MismatchedNotSetException){
    			description="Mismatched of inverse of a set";
    		} 
    		  errReporter.error(getFilename(), e.line, description);
	}

	/**
	 * Report parser error
	 * @param msg  error message
	 * @param e  any exception 
	 */
	public  void reportError(Exception e) {
		AadlParserPlugin.INSTANCE.log(e);
	  errReporter.error(this.getFilename(), 0, e.toString());
	}
	/**
	 * Report parser error
	 * @param msg  error message
	 * @param e  antlr error exception 
	 */
	 
	/* 
	public  void reportError(ANTLRException e) {
			  errReporter.error(this.getFilename(), 0, e.getMessage());
			}
	*/

	/**
	 * the current resource being parsed
	 */
	protected SplitStreamFilter filter = null;
	
	/**
	 * sets the filter for pulling comment tokens.
	 * @param filter  filter with comment tokens
	 */
	public void setFilter(SplitStreamFilter filter){
		this.filter = filter;
	}
	
	/* Process comments attached to the beginning of a declaration */
	public void processComments(AObject o){
		attachComments(o, getComments());
	}

	/* Get comments at the start of a declaration */
	/*
	public Vector getComments() {
		if (filter == null ) return null;
		return filter.getSplitTokens();
	}
	*/
	
	public Vector getComments() {
		int i = input.index();
		i = ((MultiChannelTokenStream)input).indexOfPreviousInChannelToken(i);

		if (i>commentIndex){
			List commList = ((CommonTokenStream)input).getTokens(commentIndex,i,Aadl2Lexer.SL_COMMENT);
			Vector v;
			if (commList != null)
				v=new Vector(commList);
			else
				v = new Vector();
			commentIndex = i;
			return v;
		}
		
		return new Vector();
	}

	/* Attach comments to an object. */
	
	/*
	public void attachComments(AObject o, Vector cmt) {
		if (cmt == null) return;
		for ( Iterator i = cmt.iterator(); i.hasNext();)
		{
			Token t = (Token) i.next();
		}
	}
	*/

	public void attachComments(AObject o, Vector cmt) {
		if (cmt == null) return;
		for ( Iterator i = cmt.iterator(); i.hasNext();)
		{
			Token t = (Token) i.next();
			String c = t.getText();
			if (c.startsWith("--")){
				c = c.substring(2);
			} else if (c.startsWith("/*")){
				c = c.substring(2, c.length()-2);
			}
			int idx = c.indexOf("\n");
			while (idx >= 0){
				if (idx == 0){
					c = c.substring(1);
				} else {
				  String com = c.substring(0, idx-1);
				  if (o instanceof Element)
				      ((Element)o).createOwnedComment().setBody(com);
				  c = c.substring(idx+1);
				}
				idx = c.indexOf("\n");
			}
			if (c.length()>0){
			  if (o instanceof Element)
			  	((Element)o).createOwnedComment().setBody(c);
			}
		}
	}

	
	/**
	 * Dummy method
	 * see http://www.antlr.org:8080/pipermail/antlr-interest/2005-August/013323.html and replies
	 */
	 void recover (RecognitionException e, BitSet b) {
	 }

	/* Process comments attached to the end of a declaration */
	public void processPostComments(AObject o){
		processComments(o);
	}
	
	private void setToDo(Set packagesToDo, Set propertySetsToDo) {
		if (packagesToDo != null) {
			for (Iterator i = referencedPackages.iterator(); i.hasNext();) {
				String name = (String) i.next();
				boolean foundIt = false;
				for (Iterator ii = definedPackages.iterator(); ii.hasNext();) {
					if (name.equalsIgnoreCase((String)ii.next())) {
						foundIt = true;
						break;
					}
				}
				if (!foundIt)
				    packagesToDo.add(name);
				
			}
		}
		if (propertySetsToDo != null) {
			for (Iterator i = referencedPropertySets.iterator(); i.hasNext();) {
				String name = (String) i.next();
				boolean foundIt = false;
				for (Iterator ii = definedPropertySets.iterator(); ii.hasNext();) {
					if (name.equalsIgnoreCase((String)ii.next())) {
						foundIt = true;
						break;
					}
				}
				if ( ! foundIt)
					propertySetsToDo.add(name);
			}
		}
	}
}


@lexer::members {
	
	public static final int COMMENT_CHANNEL=10;
	protected String filename=null;
	
	public void setFilename(String n){
	 filename=n;
	}
	/**
	 * the current resource being parsed
	 */
	protected ParseErrorReporter errReporter = null;
	
	/**
	 * Set the Parse Error Reporter with which to produce error messages.
	 */
	public void setParseErrorReporter(final ParseErrorReporter reporter) {
		  errReporter = reporter;
	}
			
	/**
	 * Report lexer error
	 * @param e  antlr error exception 
	 */
	public  void reportError(RecognitionException e) {
    		String description=null;
    		if (e instanceof MismatchedTokenException){
    			MismatchedTokenException mte = (MismatchedTokenException) e;
       			String found = (mte.token != null ) ? mte.token.getText() : "null";
       			String expecting = (mte.expecting < Aadl2Parser.tokenNames.length && mte.expecting >=0) ? 
       					Aadl2Parser.tokenNames[mte.expecting] : "null";
       			description = "Expecting: "+expecting+", found: "+found;
    		} else if (e instanceof MismatchedTreeNodeException){
    			description = "Unexpected Tree Node Exception";
    		} else if (e instanceof NoViableAltException){
    			NoViableAltException nva = (NoViableAltException) e;
    			description = "No viable alternative: "+nva.grammarDecisionDescription;
    		} else if (e instanceof EarlyExitException){
    			EarlyExitException ee = (EarlyExitException) e;
    			description = "Early Exit";
    		} else if (e instanceof FailedPredicateException){
    			FailedPredicateException fp = (FailedPredicateException)e;
    			description = "Semantic error: "+fp.predicateText;
    		} else if (e instanceof MismatchedRangeException){
    			MismatchedRangeException mr = (MismatchedRangeException)e;
    			description = "Mismatched range: ";
    		} else if (e instanceof MismatchedSetException){
    			MismatchedSetException ms = (MismatchedSetException)e;
    			description = "Mismatched set";
    		} else if (e instanceof MismatchedNotSetException){
    			description="Mismatched of inverse of a set";
    		} 
		  errReporter.error(filename, e.line, description);
	}
	
	/**
	 * Dummy method
	 * see http://www.antlr.org:8080/pipermail/antlr-interest/2005-August/013323.html and replies
	 */
	 void recover (RecognitionException e, BitSet b) {
	 }
}

//-------------------------------------------------------------------
//-------------------------------------------------------------------
//  AADL Syntax per AADL_V0.994 -- Aug2004
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 4  COMPONENT TYPES AND PACKAGES
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 4.1 AADL Specifications
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

// Now AadlSpecification does not exist (all classifiers need to be in packages now), it is only an entry point to parse a file
// this aadl_specification returns a collection of namespaces that can either be packages or property sets
 
aadl_specification [GlobalNamespace gns, Resource r, TreeSet<ReferenceRecord> uReferences]
	@init{
		unresolvedReferences = uReferences;
		//jseibelTestString
	}
	:
	(package_spec[gns, r]//)+ 
	|property_set[gns, r]
	)+
	EOF
	;


/*
aadl_specification [GlobalNamespace gns, Resource r, Set packagesToDo, Set propertySetsToDo] returns [AadlSpecification aadl]
	@init {
		aadl = Aadl2F.createAadlSpecification();
		if (r != null) {
			r.getContents().add(aadl);
		}
		aadl.setLocationReference(this.getFilename(),1);
		aadl.setGlobalNamespace(gns);
		setGlobalNamespace(gns);
	}
:
	(name_visibility_declaration[aadl])* (aadl_declaration[aadl])+
	{ processComments(aadl);}
	EOF
	{
	     
	//	setToDo(packagesToDo, propertySetsToDo);
	}
;
*/

name_visibility_declaration [PackageSection pkg ]
	@init{
	 String pkgName = "";
	}
	:
	WITH 
	(pn=package_name
		{
		  ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.WithStatementReference,
		                                            pkg,
		                                            new String[]{pn}
		                                            ); 
      unresolvedReferences.add(rr);
		} 
	)
	(COMMA
	 pn=package_name
    { 
      ReferenceRecord rr1 = new ReferenceRecord(ParserReferenceType.WithStatementReference,
                                                pkg,
                                                new String[]{pn}
                                                ); 
      unresolvedReferences.add(rr1); 
    } 
	)*
		SEMI
	|alias_declaration[pkg]
	;
	

alias_declaration [PackageSection pkg ]
	@init {
		String newname = null;
		String oldpkg="";
	}
	:
	newid=IDENT RENAMES PACKAGE pn=package_name SEMI
	{
   if( pkg.findNamedElement(newid.getText()) != null) 
      errReporter.error(new LocationReference(input.getSourceName(),newid.getLine()),"Duplicate renames identifier");
      
		PackageRename pr = Aadl2F.createPackageRename();
		pr.setName(newid.getText());
		pr.setLocationReference(this.getFilename(), newid.getLine());
		pkg.getOwnedPackageRenames().add(pr);
		ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.PackageRenameReference,
		                                          pr,
		                                          new String[]{pn});
    unresolvedReferences.add(rr);		                                         
	} 
	|
	((newid=IDENT 
	     {
         if( pkg.findNamedElement(newid.getText()) != null) 
          errReporter.error(new LocationReference(input.getSourceName(),newid.getLine()),
                            "Duplicate renames identifier");
	       newname=newid.getText();
	     } 
	  )?
	 r=RENAMES 
	(
		(cc=component_category
		 (pkgId = IDENT DOUBLECOLON
         {
            oldpkg+= ((oldpkg.length() > 0)?"::":"")+ pkgId.getText();
          } 
      )+
		 
		oldid=IDENT SEMI
			{
				ComponentTypeRename ctren = Aadl2F.createComponentTypeRename();
				if (newname != null){
					ctren.setName(newname);
				} else {
					ctren.setName(oldid.getText());
				}
				ctren.setLocationReference(this.getFilename(), r.getLine());
				pkg.getOwnedComponentTypeRenames().add(ctren);
				ctren.setCategory(cc);

        ReferenceRecord rr1=new ReferenceRecord(ParserReferenceType.ComponentTypeRename,
                                                ctren,
                                                new String[]{oldpkg,oldid.getText()});
        unresolvedReferences.add(rr1);
        oldpkg="";                                               
			}
		) 
		|(FEATURE GROUP 
		 (pkgId = IDENT DOUBLECOLON
         {
            oldpkg+= ((oldpkg.length() > 0)?"::":"")+ pkgId.getText();
          } 
      )+
		oldid=IDENT SEMI
			{
				FeatureGroupTypeRename fgren = Aadl2F.createFeatureGroupTypeRename();				
				if (newname != null){
					fgren.setName(newname);
				} else {
				  fgren.setName(oldid.getText());
				}
				fgren.setLocationReference(this.getFilename(), r.getLine());
				ReferenceRecord rr2 = new ReferenceRecord(ParserReferenceType.FeatureGroupTypeRename,
				                                          fgren,
				                                          new String []{oldpkg,oldid.getText()});
        unresolvedReferences.add(rr2);				                                          
				pkg.getOwnedFeatureGroupTypeRenames().add(fgren);
			}
		)
	)
	)
	| (r=RENAMES pn=package_name DOUBLECOLON ALL SEMI
	 {
     PackageRename pr = Aadl2F.createPackageRename();
     pr.setLocationReference(this.getFilename(), r.getLine());
     ReferenceRecord rr3 = new ReferenceRecord(ParserReferenceType.RenamesAll,
                                                pr,
                                                new String[]{pn});
     unresolvedReferences.add(rr3);                                                	   
	   pr.setRenameAll(true);
	   pkg.getOwnedPackageRenames().add(pr);
	 }
	)
	;
		
//-------------------------------------------------------------------
//aadl_declaration [AadlSpecification aadl ]
//		/*options {defaultErrorHandler=true;}*/ 
//      @init { 
//      //Classifier a1=null,a=null;   
//      //PropertySet ps=null;
//      //AnnexLibrary ax = null;
//      }:
//      ( a = component_classifier 
//      		{   if( aadl.getClassifiers().contains(a)) errReporter.warning(a.getLocationReference(),"Duplicate component classifier");
//      			aadl.getClassifiers().add(a);
//      			processComments(a);
//      		}
//      |  a1 = port_group_type 
//      		{ if( aadl.findClassifier(a1.getName()) != null) errReporter.warning(a1.getLocationReference(),"Duplicate port group type");
//      			aadl.getClassifiers().add(a1);
//      			processComments(a1);
//      		} 
//
//      |  ax = annex_library 
//      		{ 
//      			if( aadl.findAnnexLibrary(ax.getName()) != null) errReporter.warning(ax.getLocationReference(),"Duplicate annex library");
//      			aadl.getAnnexLibraries().add(ax);
//      			processComments(ax);
//      		}
//      | package_spec[aadl]
//      /*TODO: [AADL2-PROPERTIES] uncomment and fix when meta-model properties ready*/
//      /* 
//      | ps = property_set 
//      		{  
//      			if( aadl.findPropertySet(ps.getName()) != null) errReporter.error(ps.getLocationReference(),"Duplicate property set");
//      			if( aadl.findPublicAadlPackage(ps.getName())!=null || aadl.findPrivateOnlyAadlPackage(ps.getName())!=null) errReporter.error(ps.getLocationReference(),"Aadl Package with same name exists");
//      			aadl.addPropertySet(ps);
//      			processComments(ps);
//      		}
//      */
//      )
//;

//-------------------------------------------------------------------
//component_classifier returns [ComponentClassifier aadldecl]
//	@init{
//		aadldecl=null;
//	}:
//      ( tt1 = thread_type  {aadldecl=tt1;}
//      |   tt2 = thread_implementation {aadldecl=tt2;}
//      | tt3 = thread_group_type {aadldecl=tt3;}
//      |   tt4 = thread_group_implementation {aadldecl=tt4;}
//      | tt5 = system_type {aadldecl=tt5;}
//      |   tt6 = system_implementation {aadldecl=tt6;}
//      | tt7 = data_type  {aadldecl=tt7;}
//      |   tt8= data_implementation {aadldecl=tt8;}
//      | tt9 = subprogram_type {aadldecl=tt9;}
//      |   tt10 = subprogram_implementation {aadldecl=tt10;}
//      | tt11 = process_type  {aadldecl=tt11;}
//      |   tt12 = process_implementation {aadldecl=tt12;}
//      | tt13 = processor_type {aadldecl=tt13;}
//      |   tt14 = processor_implementation {aadldecl=tt14;}
//      | tt15 = memory_type {aadldecl=tt15;}
//      |   tt16 = memory_implementation {aadldecl=tt16;}
//      | tt17 = bus_type {aadldecl=tt17;}
//      |   tt18 = bus_implementation {aadldecl=tt18;}
//      | tt19 = device_type {aadldecl=tt19;}
//      |   tt20 = device_implementation {aadldecl=tt20;}
//      )
//	 
//;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 4.2 Packages
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

// Now we have a single entry to the parser
// Standalone package in a file
//package_file [Resource r, Set packagesToDo, Set propertySetsToDo] returns [AadlSpecification as] 
//		/*options {defaultErrorHandler=true;}*/ 
//		@init {
//			as=Aadl2F.createAadlSpecification();
//			AadlPackage pkg = Aadl2F.createAadlPackage();
//			//String packname=null;
//			//String pname2=null;
//			processComments(pkg);
//		as.addAadlPackage(pkg);
//		if (r != null) {
//			r.getContents().add(as);
//		}
//		}
//:
//	fl=PACKAGE packname = package_name 
//	{
//		pkg.setName(packname);
//		pkg.setLocationReference(this.getFilename(), fl.getLine());
//	}
//	(
//		(public_part[pkg] (private_part[pkg])?)
//	|
//		private_part[pkg]
//	)
//	END pname2 = package_name sl=SEMI
//	{
//		if (!(packname.equalsIgnoreCase(pname2))) {
//			//throw new SemanticException("package name '" + packname + "' does not match end identifier '" + pname2+"'",
//			//		getFilename(), sl.getLine(), sl.getCharPositionInLine());
//			throw new FailedPredicateException(input, "package file", "package name '" + packname + "' does not match end identifier '" + pname2+"'"); 
//		}		
//		processComments(pkg);
//		setToDo(packagesToDo, propertySetsToDo);
//	}
//	EOF
//;


// Nested package inside an AADL specification
package_spec [GlobalNamespace gns, Resource r] 
	@init {
		AadlPackage aadllib = Aadl2F.createAadlPackage();
	   	processComments(aadllib);
	}
	:
  	fl=PACKAGE packname = package_name
  		{
  			aadllib.setName(packname);
  			aadllib.setLocationReference(this.getFilename(),fl.getLine());
     	}       
     ( (public_part[aadllib]
     		{
  				definedPackages.add(packname);
     		} 
     		( private_part[aadllib]
     		)?
     	)
	 | (private_part[aadllib]
     		{
  				definedPackages.add(packname);
     		} 
	 	) 
	 )
   (PROPERTIES
     (pa=property_association
       {
         aadllib.getOwnedPropertyAssociations().add(pa);
       }
     )+
   )?
  END pname2 = package_name sl=SEMI   
  	{
	  	if (!( packname.equalsIgnoreCase(pname2) )) 
  			throw new FailedPredicateException(input, "package spec", "package name '"+packname+"' does not match end identifier '"+pname2+"'");

		// now is safe to add it.
		r.getContents().add(aadllib);  	
	}
  { processComments(aadllib); }
  ;

      catch [RecognitionException ex] {
            reportError(ex);
			consumeUntil(input,END);
			consumeUntil(input,SEMI);
			input.consume();
        }


//-------------------------------------------------------------------
  
  public_part [AadlPackage aadllib]  
      @init {
      		PublicPackageSection pub = aadllib.createOwnedPublicSection();
      		processComments(pub);
      }
      :
      p=PUBLIC
      	{
      		pub.setLocationReference(this.getFilename(), p.getLine());
      	}
      (name_visibility_declaration[pub])* package_items[pub] ;
//-------------------------------------------------------------------
  
  private_part [AadlPackage aadllib]  
        @init {
        	PrivatePackageSection priv = aadllib.createOwnedPrivateSection();
        	processComments(priv);
      }
      :
      p=PRIVATE
      	{
      		priv.setLocationReference(this.getFilename(), p.getLine());
      	}
      (name_visibility_declaration[priv])* package_items[priv] ;
//-------------------------------------------------------------------
 
 
package_items [PackageSection section]
			@init { 
			//Properties ps=null;
			} :
       ( package_item[section]
       )+
//	   ( ps = propertyAssociations { section.setProperties(ps); })?
	   ;
	   
package_item [PackageSection section]
		/*options {defaultErrorHandler=true;}*/ 
         @init { 
         	//Classifier cd = null; 
         	//AnnexLibrary ax = null; 
         }
     :  
     ax = annex_library 
     	{ 
        	if( section.findNamedElement(ax.getName()) != null) 
        		errReporter.error(ax.getLocationReference(),"Duplicate annex library");
        		
     		section.getOwnedAnnexLibraries().add(ax);
   		}
   	|
	cd =  classifier_declaration 
		{ 
			if (cd != null){
				if(section.findNamedElement(cd.getName()) != null) 
					errReporter.error(cd.getLocationReference(),"Duplicate component classifier");
				
             	section.getOwnedClassifiers.add(cd);
             }
        } 
	;

//class_name returns [String name]
//	@init{
//		name = "";
//	}
//	:
//	(id=IDENT
//		{
//			name=id.getText();
//		}
//	)
//	(DOT id2=IDENT
//		{
//			name += "."+id2.getText();
//		}
//	)*
//	;
	
package_name returns [String name]
  @init{
  	name="";
  }
  :
  (
  (id=IDENT 
  	{ 
  		name = id.getText();
  	}
  ) 
  (
  	( DOUBLECOLON id2=IDENT 
  		{ 
  			name = name + "::" + id2.getText();
  		} 
  	)*
  )
  )
  ;


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 4.3 Component Types
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

classifier_declaration returns [Classifier classifier]
	@init{
	}
	:
	classifier1=component_classifier_declaration {classifier=classifier1;}
	| classifier2=feature_group_type {classifier=classifier2;}
	;
	
component_classifier_declaration returns [Classifier classifier]
	@init{
	}
	:
	classifier2=component_implementation {classifier=classifier2;}
	| classifier1=component_type {classifier= classifier1;}
	;	

	
component_implementation returns [ComponentImplementation aadldecl]
	@init{
		aadldecl=null;
	}:
	  (	tt1 = abstract_implementation {aadldecl=tt1;}
      |   tt2 = thread_implementation {aadldecl=tt2;}
      |   tt4 = thread_group_implementation {aadldecl=tt4;}
      |   tt6 = system_implementation {aadldecl=tt6;}
      |   tt8 = data_implementation {aadldecl=tt8;}
      |   tt10 = subprogram_implementation {aadldecl=tt10;}
      |   tt12 = process_implementation {aadldecl=tt12;}
      |   tt14 = processor_implementation {aadldecl=tt14;}
      |   tt16 = memory_implementation {aadldecl=tt16;}
      |   tt18 = bus_implementation {aadldecl=tt18;}
      |   tt20 = device_implementation {aadldecl=tt20;}
      |   tt21 = subprogram_group_implementation {aadldecl=tt21;}
      |   tt22 = virtual_bus_implementation {aadldecl=tt22;}
      |   tt23 = virtual_processor_implementation {aadldecl=tt23;}  
      )
	;

component_type returns [ComponentClassifier aadldecl]
	@init{
		aadldecl=null;
	}:
      ( tt1 = thread_type  {aadldecl=tt1;}
      | tt3 = thread_group_type {aadldecl=tt3;}
      | tt5 = system_type {aadldecl=tt5;}
      | tt7 = data_type  {aadldecl=tt7;}
      | tt9 = subprogram_type {aadldecl=tt9;}
      | tt11 = process_type  {aadldecl=tt11;}
      | tt13 = processor_type {aadldecl=tt13;}
      | tt15 = memory_type {aadldecl=tt15;}
      | tt17 = bus_type {aadldecl=tt17;}
      | tt19 = device_type {aadldecl=tt19;}
      | tt20 = abstract_type {aadldecl = tt20;}
      | tt21 = subprogram_group_type {aadldecl = tt21;}
      | tt22 = virtual_bus_type {aadldecl = tt22;}
      | tt23 = virtual_processor_type {aadldecl = tt23;} 
      )
	;

properties_for_classifiers [ Classifier ct ]
 :
  (PROPERTIES
   (
   (none_stmt
     {
       // TODO: wait for this method to be put into 
       // classifier in the meta-model
       ct.setNoProperties(true);
     }
   )
   |
   (
     (cpa = contained_property_association
       {
        ct.getOwnedPropertyAssociations().add(cpa);
       }
     )+
    )
   )
   )
   ;
	
implementation_extension [ComponentImplementation ci]
	:
	e=EXTENDS cr = unique_impl_name 
		{ 		  
		  ImplementationExtension implEx = Aadl2F.createImplementationExtension();
		  ci.setOwnedExtension(implEx);
		  implEx.setLocationReference(this.getFilename(), e.getLine());
		  cr.setReferencingObject(implEx);
		  cr.setReferenceType(ParserReferenceType.ComponentImplementationExtensionReference);
		  unresolvedReferences.add(cr);
		}
		( LPAREN pb=prototype_binding
			{
				ci.getOwnedPrototypeBindings().add(pb);
			}
			(COMMA pb=prototype_binding
				{
					ci.getOwnedPrototypeBindings().add(pb);
				}
			)*
		 RPAREN
		)?
	;

prototypes_for_implementation [boolean extension, ComponentImplementation ci]
	:
	PROTOTYPES
		(none_stmt
			{
				ci.setNoPrototypes(true);
			}
		| (
			(pt = prototype[extension]
				{
					ci.getOwnedPrototypes().add(pt);
				}
			 )+
		   )
		)
	;
	
modes_for_implementations[ComponentImplementation ai]
:
MODES
    (
    (none_stmt
      {
        ai.setNoModes(true);
      }
    )
  |
    (
    (
      (md=mode
        {
          ai.getOwnedModes().add(md);
        }
      )
      |
      (mt =mode_transition[ai]
        {
          ai.getOwnedModeTransitions().add(mt);
        }
      )
    )+
    )
    )
;	
	
component_implementation_realization[ComponentImplementation ci, Token typeid]
  @init{
  }
  :
  {
    Realization realization = Aadl2F.createRealization();
    realization.setLocationReference(this.getFilename(), typeid.getLine());
    ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.RealizationReference,
                                                                realization,
                                                                new String[]{typeid.getText()});
    ci.setOwnedRealization(realization);
    unresolvedReferences.add(rr);                                                             
  }
  ;	

connections[ComponentImplementation ai, boolean extension]
  :
   (conn=connection[extension]
      {
            ai.addConnection(conn);
            if (conn.getSource() != null){
              if (conn.getSource() instanceof InternalEvent){
                ai.getOwnedInternalEvents().add((InternalEvent)conn.getSource());
              } else if (conn.getSource() instanceof ProcessorPort){
                ai.getOwnedProcessorPorts().add((ProcessorPort)conn.getSource());
              } else if (conn.getSource() instanceof ProcessorSubprogram){
                ai.getOwnedProcessorSubprograms().add((ProcessorSubprogram) conn.getSource());
              }
            }
            if (conn.getDestination() != null){
              if (conn.getDestination() instanceof InternalEvent){
                ai.getOwnedInternalEvents().add((InternalEvent)conn.getDestination());
              } else if (conn.getDestination() instanceof ProcessorPort){
                ai.getOwnedProcessorPorts().add((ProcessorPort)conn.getDestination());
              }
            }
          }
  )+
;
	
abstract_implementation returns [AbstractImplementation ai]
  scope{
    boolean extension;
  }
	@init{
	 $abstract_implementation::extension=false;
	}
	:
	ABSTRACT IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createAbstractImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
	component_implementation_realization[ai,id]
	(implementation_extension[ai]
	 {
	   $abstract_implementation::extension=true;
	 }
	)?
	(prototypes_for_implementation[$abstract_implementation::extension, ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ds=data_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedDataSubcomponents().add(ds);
				}
			)
			|(ss=subprogram_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedSubprogramSubcomponents().add(ss);
				}
			)
			|(sgs=subprogram_group_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedSubprogramGroupSubcomponents().add(sgs);
				}
			)
			|(ts=thread_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedThreadSubcomponents().add(ts);
				}			
			)
			|(tgs=thread_group_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedThreadGroupSubcomponents().add(tgs);
				}
			)
			|(ps=process_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedProcessSubcomponents().add(ps);
				}
			)
			|(procs=processor_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedProcessorSubcomponents().add(procs);
				}
			)
			|(vps=virtual_processor_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedVirtualProcessorSubcomponents().add(vps);
				}
			)
			|(ms=memory_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedMemorySubcomponents().add(ms);
				}
			)
			|(devs=device_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedDeviceSubcomponents().add(devs);
				}
			)
			|(syss=system_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedSystemSubcomponents().add(syss);
				}
			)
			|(as=abstract_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			|(bs=bus_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedBusSubcomponents().add(bs);
				}
			)
			|(vbs=virtual_bus_subcomponent[$abstract_implementation::extension]
				{
					ai.getOwnedVirtualBusSubcomponents().add(vbs);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CALLS
		(
			(	(scs=subprogram_call_sequence
					{
						ai.getOwnedSubprogramCallSequences().add(scs);
					}
				)+
			)
		|
			(none_stmt
				{
					ai.setNoCalls(true);
				}
			)
		)
	)?
	(CONNECTIONS
		(
			(connections[ai,$abstract_implementation::extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[$abstract_implementation::extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[$abstract_implementation::extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
	(properties_for_classifiers[ai]
	)?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"abstract implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
bus_implementation returns [BusImplementation ai]
  scope{
    boolean extension;
  }
	@init{
	$bus_implementation::extension=false;
	}
	:
	BUS IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createBusImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
	 {
	   $bus_implementation::extension=true;
	 }
	)?
	(prototypes_for_implementation[$bus_implementation::extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(vbs=virtual_bus_subcomponent[$bus_implementation::extension]
				{
					ai.getOwnedVirtualBusSubcomponents().add(vbs);
				}
			)
			|(as=abstract_subcomponent[$bus_implementation::extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"bus implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
data_implementation returns [DataImplementation ai]
  scope{
    boolean extension;
  }
	@init{
   $data_implementation::extension=false;
	}
	:
	DATA IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createDataImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]	
	(implementation_extension[ai]
	 {
	   $data_implementation::extension=true;
	 }
	)?
	(prototypes_for_implementation[$data_implementation::extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ds=data_subcomponent[$data_implementation::extension]
				{
					ai.getOwnedDataSubcomponents().add(ds);
				}
			)
			|(ss=subprogram_subcomponent[$data_implementation::extension]
        {
          ai.getOwnedSubprogramSubcomponents().add(ss);
        }
      )
			|(as=abstract_subcomponent[$data_implementation::extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		(
			(
				connections[ai,$data_implementation::extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"data implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
device_implementation returns [DeviceImplementation ai]
	@init{
   boolean extension=false;
	}
	:
	DEVICE IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createDeviceImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
	 {
	   extension=true;
	 }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
				(
					(bs=bus_subcomponent[extension]
						{
							ai.getOwnedBusSubcomponents().add(bs);
						}
					)
				|
					(as=abstract_subcomponent[extension]
						{
							ai.getOwnedAbstractSubcomponents().add(as);
						}
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		(
			(
        connections[ai,extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"device implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       

	
memory_implementation returns [ MemoryImplementation ai]
  scope{
    boolean extension;
  }
	@init{
   $memory_implementation::extension=false;
	}
	:
	MEMORY IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createMemoryImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      $memory_implementation::extension=true;
    }
	)?
	(prototypes_for_implementation[$memory_implementation::extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ms=memory_subcomponent[$memory_implementation::extension]
				{
					ai.getOwnedMemorySubcomponents().add(ms);
				}
			)
			|(as=abstract_subcomponent[$memory_implementation::extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			|(bs=bus_subcomponent[$memory_implementation::extension]
				{
					ai.getOwnedBusSubcomponents().add(bs);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		(	
			(
				connections[ai,$memory_implementation::extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"memory implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
process_implementation returns [ ProcessImplementation ai ]
  scope{
    boolean extension;
  }
	@init{
   $process_implementation::extension=false;
	}
	:
	PROCESS IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createProcessImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      $process_implementation::extension=true;
    }
	)?
	(prototypes_for_implementation[$process_implementation::extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ds=data_subcomponent[$process_implementation::extension]
				{
					ai.getOwnedDataSubcomponents().add(ds);
				}
			)
			|(ss=subprogram_subcomponent[$process_implementation::extension]
				{
					ai.getOwnedSubprogramSubcomponents().add(ss);
				}
			)
			|(sgs=subprogram_group_subcomponent[$process_implementation::extension]
				{
					ai.getOwnedSubprogramGroupSubcomponents().add(sgs);
				}
			)
			|(ts=thread_subcomponent[$process_implementation::extension]
				{
					ai.getOwnedThreadSubcomponents().add(ts);
				}			
			)
			|(tgs=thread_group_subcomponent[$process_implementation::extension]
				{
					ai.getOwnedThreadGroupSubcomponents().add(tgs);
				}
			)
			|(as=abstract_subcomponent[$process_implementation::extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		(
			(
				connections[ai,$process_implementation::extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[$process_implementation::extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[$process_implementation::extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"process implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
processor_implementation returns [ ProcessorImplementation ai]
	@init{
   boolean extension=false;
	}
	:
	PROCESSOR IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createProcessorImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      extension = true;
    }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(vps=virtual_processor_subcomponent[extension]
				{
					ai.getOwnedVirtualProcessorSubcomponents().add(vps);
				}
			)
			|(ms=memory_subcomponent[extension]
				{
					ai.getOwnedMemorySubcomponents().add(ms);
				}
			)
			|(as=abstract_subcomponent[extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			|(bs=bus_subcomponent[extension]
				{
					ai.getOwnedBusSubcomponents().add(bs);
				}
			)
			|(vbs=virtual_bus_subcomponent[extension]
				{
					ai.getOwnedVirtualBusSubcomponents().add(vbs);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		(
			(
				connections[ai,extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"processor implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
subprogram_implementation returns [ SubprogramImplementation ai]
	@init{
   boolean extension=false;
	}
	:
	SUBPROGRAM IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createSubprogramImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      extension=true;
    }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ds=data_subcomponent[extension]
				{
					ai.getOwnedDataSubcomponents().add(ds);
				}
			)
			|(as=abstract_subcomponent[extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CALLS
		(
		(
			(scs=subprogram_call_sequence
				{
					ai.getOwnedSubprogramCallSequences().add(scs);
				}
			)+
		)
		|
		(none_stmt
			{
				ai.setNoCalls(true);
			}
		)
		)
	)?
	(CONNECTIONS
		(
			(
				connections[ai,extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"subprogram implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
subprogram_group_implementation returns [ SubprogramGroupImplementation ai]
	@init{
   boolean extension=false;
	}
	:
	SUBPROGRAM GROUP IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createSubprogramGroupImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      extension=true;
    }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ss=subprogram_subcomponent[extension]
				{
					ai.getOwnedSubprogramSubcomponents().add(ss);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		connections[ai,extension]
		| none_stmt
			{
				ai.setNoConnections(true);
			}
	)?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"subprogram group implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
system_implementation returns [ SystemImplementation ai]
	@init{
   boolean extension=false;
	}
	:
	SYSTEM IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createSystemImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      extension = true;
    }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ds=data_subcomponent[extension]
				{
					ai.getOwnedDataSubcomponents().add(ds);
				}
			)
			|(ss=subprogram_subcomponent[extension]
				{
					ai.getOwnedSubprogramSubcomponents().add(ss);
				}
			)
			|(sgs=subprogram_group_subcomponent[extension]
				{
					ai.getOwnedSubprogramGroupSubcomponents().add(sgs);
				}
			)
			|(ps=process_subcomponent[extension]
				{
					ai.getOwnedProcessSubcomponents().add(ps);
				}
			)
			|(procs=processor_subcomponent[extension]
				{
					ai.getOwnedProcessorSubcomponents().add(procs);
				}
			)
			|(vps=virtual_processor_subcomponent[extension]
				{
					ai.getOwnedVirtualProcessorSubcomponents().add(vps);
				}
			)
			|(ms=memory_subcomponent[extension]
				{
					ai.getOwnedMemorySubcomponents().add(ms);
				}
			)
			|(devs=device_subcomponent[extension]
				{
					ai.getOwnedDeviceSubcomponents().add(devs);
				}
			)
			|(syss=system_subcomponent[extension]
				{
					ai.getOwnedSystemSubcomponents().add(syss);
				}
			)
			|(as=abstract_subcomponent[extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			|(bs=bus_subcomponent[extension]
				{
					ai.getOwnedBusSubcomponents().add(bs);
				}
			)
			|(vbs=virtual_bus_subcomponent[extension]
				{
					ai.getOwnedVirtualBusSubcomponents().add(vbs);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		(
			(
				connections[ai,extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"system implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       

thread_implementation returns [ThreadImplementation ai]
	@init{
   boolean extension=false;
	}
	: 
	THREAD IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createThreadImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      extension = true;
    }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ds=data_subcomponent[extension]
				{
					ai.getOwnedDataSubcomponents().add(ds);
				}
			)
			|(ss=subprogram_subcomponent[extension]
				{
					ai.getOwnedSubprogramSubcomponents().add(ss);
				}
			)
			|(sgs=subprogram_group_subcomponent[extension]
				{
					ai.getOwnedSubprogramGroupSubcomponents().add(sgs);
				}
			)
			|(as=abstract_subcomponent[extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CALLS
		(
		(
			(scs=subprogram_call_sequence
				{
					ai.getOwnedSubprogramCallSequences().add(scs);
				}
			)+
		)
		|
		(none_stmt
			{
				ai.setNoCalls(true);
			}
		)
		)
	)?
	(CONNECTIONS
		(
			(
				connections[ai,extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"thread implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
thread_group_implementation returns [ThreadGroupImplementation ai]
	@init{
   boolean extension=false;
	}
	:
	THREAD GROUP IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createThreadGroupImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      extension = true;
    }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
			(
			(ds=data_subcomponent[extension]
				{
					ai.getOwnedDataSubcomponents().add(ds);
				}
			)
			|(ss=subprogram_subcomponent[extension]
				{
					ai.getOwnedSubprogramSubcomponents().add(ss);
				}
			)
			|(sgs=subprogram_group_subcomponent[extension]
				{
					ai.getOwnedSubprogramGroupSubcomponents().add(sgs);
				}
			)
			|(ts=thread_subcomponent[extension]
				{
					ai.getOwnedThreadSubcomponents().add(ts);
				}			
			)
			|(tgs=thread_group_subcomponent[extension]
				{
					ai.getOwnedThreadGroupSubcomponents().add(tgs);
				}
			)
			|(as=abstract_subcomponent[extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		((
		connections[ai,extension]
		)
		| (none_stmt)
			{
				ai.setNoConnections(true);
			}
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"thread group implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
		
virtual_bus_implementation returns [VirtualBusImplementation ai]
	@init{
   boolean extension=false;
	}
	:
	VIRTUAL BUS IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createVirtualBusImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      extension=true;
    }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
			(
				(
					(as=abstract_subcomponent[extension]
						{
							ai.getOwnedAbstractSubcomponents().add(as);
						}
					)
				|
					(bs=virtual_bus_subcomponent[extension]
						{
							ai.getOwnedVirtualBusSubcomponents().add(bs);
						}
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoSubcomponents(true);
					}
			)
		)
	)?
	(CONNECTIONS
		(
			(
				connections[ai,extension]
			)
		| 
			(
				none_stmt
					{
						ai.setNoConnections(true);
					}
			)
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(	
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"virtual bus implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
virtual_processor_implementation returns [VirtualProcessorImplementation ai]
	@init{
   boolean extension=false;
	}
	:
	VIRTUAL PROCESSOR IMPLEMENTATION id=IDENT DOT iid=IDENT
		{
			ai=Aadl2F.createVirtualProcessorImplementation();
			ai.setName(id.getText()+"."+iid.getText());
			ai.setLocationReference(this.getFilename(),id.getLine());
		}
  component_implementation_realization[ai,id]
	
	(implementation_extension[ai]
    {
      extension=true;
    }
	)?
	(prototypes_for_implementation[extension,ai]
	)?
	( SUBCOMPONENTS
		(
		((
			(vps=virtual_processor_subcomponent[extension]
				{
					ai.getOwnedVirtualProcessorSubcomponents().add(vps);
				}
			)
			|(as=abstract_subcomponent[extension]
				{
					ai.getOwnedAbstractSubcomponents().add(as);
				}
			)
			|(vbs=virtual_bus_subcomponent[extension]
				{
					ai.getOwnedVirtualBusSubcomponents().add(vbs);
				}
			)
		)+)
		| (none_stmt)
			{
				ai.setNoSubcomponents(true);
			}
		)
	)?
	(CONNECTIONS
		(
			(
			connections[ai,extension]
			)
			| (none_stmt)
				{
					ai.setNoConnections(true);
				}
		)
	)?
	(FLOWS
		(
			(
				(
					(fi=flow_implementation[extension]
						{
							ai.getOwnedFlowImplementations().add(fi);
						}
					)
				|
					(e2e=end_to_end_flow_implementation[extension]
						{
							ai.getOwnedEndToEndFlows().add(e2e);
						}	
					)
				)+
			)
		| 
			(
				none_stmt
					{
						ai.setNoFlows(true);
					}
			)
		)
	)?
 (modes_for_implementations[ai]
 )?
  (properties_for_classifiers[ai]
  )?
	(asub=annex_subclause
		{	
			ai.getOwnedAnnexSubclauses().add(asub);
		}
	)?
	END eid=IDENT DOT eiid=IDENT
		{
			if (!(iid.getText().equalsIgnoreCase(eiid.getText())) || !(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"virtual processor implementation", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
	
//component_type returns [Classifier classifier]
//	@init{
//		ComponentType compType= Aadl2F.createComponentType();
//	}
//	:
//	cc=component_category frontid=IDENT
//	(PROTOTYPES
//		(pt=prototype {compType.getPrototypes().add(pt);})+ | none_stmt
//	)?
//	(FEATURES
//		(ft=feature 
//			{
//				// Verify component category against the defining features
//				// if erroneous then issue an exception
//				if ( cc == ComponentCategory.BUS){ 
//					if (ft instanceof 	PortFeature) {
//						throw new FailedPredicateException("component type", "A type of category "+cc+" cannot have ports");
//					}
//					if (ft instanceof FeatureGroup ){
//						throw new FailedPredicateException("component type", "A type of category "+cc+" cannot have feature groups");					
//					} 
//					if(ft instanceof  ParameterFeature) {
//						throw new FailedPredicateException("component type", "A type of category "+cc+" cannot have parameters");
//					}
//				 	if (!(ft instanceof BusAccess)) {
//						throw new FailedPredicateException("component type", "A type of category "+cc+" cannot have data access");
//				 	} else if ( ((BusAccess)ft).getKind() != AccessType.REQUIRED ){
//						throw new FailedPredicateException("component type", "A type of category "+cc+" cannot a feature to provide bus access");
//					}
//				}	
//				compType.getFeatures().add(ft);
//			}
//		)+ 
//		| none_stmt
//	)?
//	(FLOWS
//			{
//				// check the component categories to see which of them accept flows
//				if (   cc == ComponentCategory.BUS
//					|| cc == ComponentCategory.DATA
//					|| cc == ComponentCategory.MEMORY
//					|| cc == ComponentCategory.SUBPROGRAM_GROUP
//					|| cc == ComponentCategory.VIRTUAL_BUS
//					){
//					throw new FailedPredicateException("component type", "A type of category "+cc+" cannot have flows");
//				}
//			}
//		(fs=flow_spec {compType.getOwnedFlowSpecifications().add(fs);})+ | none_stmt
//	)?
//	(MODES
//			{
//				// check the component categories to see which of them accept modes
//				if (   cc == ComponentCategory.DATA
//					|| cc == ComponentCategory.SUBPROGRAM_GROUP
//					){
//					throw new FailedPredicateException("component type", "A type of category "+cc+" cannot have modes");
//				}
//			}
//		(mode)+ | none_stmt
//	)?
////	(PROPERTIES
////		(component_type_property_association | contained_property_association)+ | none_stmt
////	)?
//	(annex_subclause)*
//	END backid=IDENT SEMI
//	{
//		if (!backid.equalsIgnoreCase(frontid)){
//  			throw new FailedPredicateException(input, "component type", "component name '"+frontid+"' does not match end identifier '"+backid+"'");			
//		}
//	}
//	;
//      catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//prototype_reference returns [Subcomponent pr]
//	@init{
//	}
//	:
//	id=IDENT COLON PROTOTYPE pid=IDENT
//		{
//			pr = Aadl2F.createSubcomponent();
//			pr.setName(id.getText());
//			pr.setLocationReference(this.getFilename(), id.getLine());
//			protRef.setElementName(id.getText());
//			protRef.setLine(id.getLine());
//			protRef.setFilename(this.getFilename());
//			pr.setPrototypeReferernce(protRef);
//		}
//	;

implementation_reference_prototype_bindings [ComponentImplementationReference cir]
@init{
}
:
    ( LPAREN pb=prototype_binding
      {
        cir.getOwnedPrototypeBindings().add(pb);
      }
      (COMMA pb1=prototype_binding
        {
          cir.getOwnedPrototypeBindings().add(pb1);
        }
      )*
     RPAREN
    )
;


subcomponent_prototype_bindings [Subcomponent sc]
@init{
}
:
    ( LPAREN pb=prototype_binding
      {
        sc.getOwnedPrototypeBindings().add(pb);
      }
      (COMMA pb1=prototype_binding
        {
          sc.getOwnedPrototypeBindings().add(pb1);
        }
      )*
     RPAREN
    )
;

subcomponent_properties [Subcomponent sc]
  @init{
  }
  :
  LCURLY
    (
      (cpa=contained_property_association
        {
          sc.getOwnedPropertyAssociations().add(cpa);
        }
      ) 
    )+
  RCURLY  
  ;

subcomponent_array_element_references [Subcomponent sc]
  @init{
  ComponentImplementationReference cir=null;
  ComponentImplementationReference cir2=null;
  }
  :
    ( l=LPAREN cr1=classifier_reference
        {
          // verify that it is an implementation label
          if (!cr1.getLabels()[cr1.getLabels().length-1].contains(".")){
             throw new FailedPredicateException(input, "subcomponent array element references", "array element reference '"+cr1.getLabels()[0]+"' is not an implementation reference ");
          }
           cir = Aadl2F.createComponentImplementationReference();
           cir.setLocationReference(this.getFilename(), l.getLine());
          sc.getImplementationReferences().add(cir);
          cr1.setReferenceType(ParserReferenceType.ArrayElementClassifierReference);
          cr1.setReferencingObject(cir);
          unresolvedReferences.add(cr1);
        }
        (implementation_reference_prototype_bindings[cir]
        )?
      (c=COMMA cr2=classifier_reference
        {
          // verify that it is an implementation label
          if (!cr2.getLabels()[cr1.getLabels().length-1].contains(".")){
             throw new FailedPredicateException(input, "subcomponent array element references", "array element reference '"+cr2.getLabels()[0]+"' is not an implementation reference ");
          }
          cir2 = Aadl2F.createComponentImplementationReference();
          cir2.setLocationReference(this.getFilename(), c.getLine());
          sc.getImplementationReferences().add(cir2);
          cr2.setReferenceType(ParserReferenceType.ArrayElementClassifierReference);
          cr2.setReferencingObject(cir2);
          unresolvedReferences.add(cr2);
        }
        (implementation_reference_prototype_bindings[cir2]
        )?
      )*
      RPAREN
    )
  ;
  catch [RecognitionException ex] {
      reportError(ex);
      consumeUntil(input,SEMI);
      input.consume();
  }
  
data_subcomponent [boolean extension] returns [DataSubcomponent ds]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
		  if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
		  }
			refinement = true;
		}
	)? 
	DATA 
		{
			ds = Aadl2F.createDataSubcomponent();
			ds.setName(id.getText());
			ds.setLocationReference(this.getFilename(),id.getLine());
			if (refinement){
			  ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
			                                           ds,
			                                           new String[]{id.getText()}
			                                           );
        unresolvedReferences.add(rr);			                                           
			}
		}
	(cr=classifier_reference
		{
		  // if the reference includes a package name we know that it is a classifier
		  // if not then it could either be a prototype or a classifier
		  cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
		                                               : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
		                      );
		  cr.setReferencingObject(ds);
		  unresolvedReferences.add(cr);
		}
		(subcomponent_prototype_bindings[ds]
		  {
		    // now I know is a classifier reference. Overwrite
		    unresolvedReferences.remove(cr);
		    cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
		    unresolvedReferences.add(cr);
		  }
		)?
	)?
	(ad=array_dimensions
		{
			ds.setArraySpecification(ad);
		}
		(subcomponent_array_element_references[ds]
		)?
	)?
	(subcomponent_properties[ds]
	)?
	(
	component_in_modes[ds]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

subprogram_subcomponent [boolean extension] returns [SubprogramSubcomponent ss]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
		  if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	SUBPROGRAM 
		{
			ss = Aadl2F.createSubprogramSubcomponent();
			ss.setName(id.getText());
			ss.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 ss,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(ss);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[ss]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
  (ad=array_dimensions
		{
			ss.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[ss]
    )?
	)?
  (subcomponent_properties[ss]
  )?
	(
	component_in_modes[ss]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
	
subprogram_group_subcomponent [boolean extension] returns [SubprogramGroupSubcomponent ss]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	SUBPROGRAM GROUP
		{
			ss = Aadl2F.createSubprogramGroupSubcomponent();
			ss.setName(id.getText());
			ss.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 ss,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(ss);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[ss]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			ss.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[ss]
    )?
	)?
  (subcomponent_properties[ss]
  )?
	(
	component_in_modes[ss]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
	
thread_subcomponent [boolean extension] returns [ThreadSubcomponent ts]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON 
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)?
	THREAD 
		{
			ts = Aadl2F.createThreadSubcomponent();
			ts.setName(id.getText());
			ts.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 ts,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(ts);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[ts]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			ts.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[ts]
    )?
	)?
  (subcomponent_properties[ts]
  )?
	(
	component_in_modes[ts]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
	
thread_group_subcomponent [boolean extension] returns [ThreadGroupSubcomponent tgs]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO 
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	THREAD GROUP 
		{
			tgs = Aadl2F.createThreadGroupSubcomponent();
			tgs.setName(id.getText());
			tgs.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 tgs,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(tgs);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[tgs]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			tgs.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[tgs]
    )?
	)?
  (subcomponent_properties[tgs]
  )?
	(
	component_in_modes[tgs]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

process_subcomponent [boolean extension] returns [ProcessSubcomponent ps]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	PROCESS 
		{
			ps = Aadl2F.createProcessSubcomponent();
			ps.setName(id.getText());
			ps.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 ps,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(ps);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[ps]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			ps.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[ps]
    )?
	)?
  (subcomponent_properties[ps]
  )?
	(
	component_in_modes[ps]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

processor_subcomponent [boolean extension] returns [ProcessorSubcomponent ps]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO 
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	PROCESSOR 
		{
			ps = Aadl2F.createProcessorSubcomponent();
			ps.setName(id.getText());
			ps.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 ps,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(ps);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[ps]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			ps.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[ps]
    )?
	)?
  (subcomponent_properties[ps]
  )?
	(
	component_in_modes[ps]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

virtual_processor_subcomponent [boolean extension] returns [VirtualProcessorSubcomponent vps]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	VIRTUAL PROCESSOR 
		{
			vps = Aadl2F.createVirtualProcessorSubcomponent();
			vps.setName(id.getText());
			vps.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 vps,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{	
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(vps);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[vps]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			vps.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[vps]
    )?
	)?
  (subcomponent_properties[vps]
  )?
	(
	component_in_modes[vps]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

memory_subcomponent [boolean extension] returns [MemorySubcomponent ms]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	MEMORY 
		{
			ms = Aadl2F.createMemorySubcomponent();
			ms.setName(id.getText());
			ms.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 ms,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(ms);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[ms]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			ms.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[ms]
    )?
	)?
  (subcomponent_properties[ms]
  )?
	(
	component_in_modes[ms]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

bus_subcomponent [boolean extension] returns [BusSubcomponent bs]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	BUS 
		{
			bs = Aadl2F.createBusSubcomponent();
			bs.setName(id.getText());
			bs.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 bs,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(bs);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[bs]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			bs.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[bs]
    )?
	)?
  (subcomponent_properties[bs]
  )?
	(
	component_in_modes[bs]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

virtual_bus_subcomponent [boolean extension] returns [VirtualBusSubcomponent vbs]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	VIRTUAL BUS 
		{
			vbs = Aadl2F.createVirtualBusSubcomponent();
			vbs.setName(id.getText());
			vbs.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 vbs,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(vbs);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[vbs]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			vbs.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[vbs]
    )?
	)?
  (subcomponent_properties[vbs]
  )?
	(
	component_in_modes[vbs]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
	
device_subcomponent [boolean extension] returns [DeviceSubcomponent ds]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	DEVICE 
		{
			ds = Aadl2F.createDeviceSubcomponent();
			ds.setName(id.getText());
			ds.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 ds,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(ds);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[ds]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			ds.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[ds]
    )?
	)?
  (subcomponent_properties[ds]
  )?
	(
	component_in_modes[ds]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
	
system_subcomponent [boolean extension] returns [SystemSubcomponent ss]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	SYSTEM 
		{
			ss = Aadl2F.createSystemSubcomponent();
			ss.setName(id.getText());
			ss.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 ss,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(ss);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[ss]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			ss.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[ss]
    )?
	)?
  (subcomponent_properties[ss]
  )?
	(
	component_in_modes[ss]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

abstract_subcomponent [boolean extension] returns [AbstractSubcomponent as]
	@init{
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	( REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"subcomponent ", "refinement only allowed in extension");
      }
			refinement = true;
		}
	)? 
	ABSTRACT 
		{
			as = Aadl2F.createAbstractSubcomponent();
			as.setName(id.getText());
			as.setLocationReference(this.getFilename(),id.getLine());
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.SubcomponentRefinementReference,
                                                 as,
                                                 new String[]{id.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                
      }
		}
	(cr=classifier_reference
		{
      // if the reference includes a package name we know that it is a classifier
      // if not then it could either be a prototype or a classifier
      cr.setReferenceType((cr.getLabels().length >1) ? ParserReferenceType.SubcomponentClassifierReference
                                                   : ParserReferenceType.SubcomponentPrototypeOrClassifierReference
                          );
      cr.setReferencingObject(as);
      unresolvedReferences.add(cr);
		}
    (subcomponent_prototype_bindings[as]
      {
        // now I know is a classifier reference. Overwrite
        unresolvedReferences.remove(cr);
        cr.setReferenceType(ParserReferenceType.SubcomponentClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )?
	(ad=array_dimensions
		{
			as.setArraySpecification(ad);
		}
    (subcomponent_array_element_references[as]
    )?
	)?
  (subcomponent_properties[as]
  )?
	(
	component_in_modes[as]
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
	
				
//component_implementation returns [Classifier classifier]
//	@init{
//	}
//	:
//	classifier=abstract_implementation
//	| classifier=bus_implementation
//	| classifier=data_implementation
//	| classifier=device_implementation
//	| classifier=memory_implementation
//	| classifier=process_implementation
//	| classifier=processor_implementation
//	| classifier=subprogram_implementation
//	| classifier=subprogram_group_implementation
//	| classifier=system_implementation
//	| classifier=thread_implementation
//	| classifier=thread_group_implementation
//	| classifier=virtual_bus_implementation
//	| classifier=virtual_processor_implementation
//	;
	
				
//feature_group_classifier_declaration returns [Classifier classifier]
//	@init{
//	}
//	:
//	classifier=feature_group_type
//	| classifier=feature_group_type_extension
//	;	


prototype [boolean extension] returns [Prototype prototype]
  @init{
    boolean refinement=false;
    DirectionType direction=DirectionType.IN_OUT;
    ComponentPrototype cp=null;
  }
  :
  id=IDENT COLON
  (REFINED TO
    {
      if (!extension){
          throw new FailedPredicateException(input,"prototypes", "refinement only allowed in extensions");
      }
      refinement=true;
    }
  )?
  (
  (cc=component_category
      {
        cp= Aadl2F.createComponentPrototype();
        cp.setLocationReference(this.getFilename(), id.getLine());
        cp.setName(id.getText());
        cp.setCategory(cc);
        prototype = cp;
        if (refinement){
            ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.ComponentPrototypeRefinementReference,
                                                                      cp,
                                                                      new String[]{id.getText()}
                                                                      );
            unresolvedReferences.add(rr);
        }
      }
      (cr=classifier_reference
        {
        cr.setReferencingObject(prototype);
        cr.setReferenceType(ParserReferenceType.ComponentPrototypeClassifierReference);
        unresolvedReferences.add(cr);
        }
      )?
      (LBRACK RBRACK
        {
          cp.setArray(true);
        }
      )?
  )
  |(FEATURE GROUP
    {
      FeatureGroupPrototype fgp = Aadl2F.createFeatureGroupPrototype();
      fgp.setLocationReference(this.getFilename(), id.getLine());
      fgp.setName(id.getText());
      prototype = fgp;
      if (refinement){
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FeatureGroupPrototypeRefinementReference,
                                                                  fgp,
                                                                  new String[]{id.getText()}
                                                                  );
        unresolvedReferences.add(rr);
      }
    }
    (cr=classifier_reference
      {
        cr.setReferencingObject(prototype);
        cr.setReferenceType(ParserReferenceType.FeatureGroupPrototypeClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )
  |(
    (
      (IN
        {
          direction = DirectionType.IN;
        }
      )
      |(OUT
        {
          direction = DirectionType.OUT;
        }
      )
    )?
    FEATURE
      {
          FeaturePrototype fp = Aadl2F.createFeaturePrototype();
          fp.setLocationReference(this.getFilename(), id.getLine());
          fp.setName(id.getText());
          fp.setDirection(direction);
          prototype=fp;
          if (refinement){
            ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FeaturePrototypeRefinementReference,
                                                                      fp,
                                                                      new String[]{id.getText()}
                                                                      );
            unresolvedReferences.add(rr);
          }
      }
    (cr = classifier_reference
      {
        cr.setReferencingObject(prototype);
        cr.setReferenceType(ParserReferenceType.FeaturePrototypeClassifierReference);
        unresolvedReferences.add(cr);
      }
    )?
  )
  )
  (
  LCURLY
   (pa = property_association
     {
       prototype.getOwnedPropertyAssociations().add(pa);
     }
   )+
  RCURLY
  )? 
  SEMI
  ;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
  

//prototype [boolean extension] returns [Prototype prototype]
//	@init{
//		prototype = Aadl2F.createPrototype();
//	}
//	:
//	identifier=IDENT COLON
//	   {
//      prototype.setName(identifier.getText());
//     }
//	(REFINED TO
//		{
//		  // refinement is only allowed in extension
//		  if (!extension){
//          throw new FailedPredicateException(input,"prototypes", "refinement only allowed in extensions");
//		  }
//		  
//        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.RefinementReference);
//        rr.setLabels(new String[]{identifier.getText()});
//        rr.setReferencingObject(prototype);
//        unresolvedReferences.add(rr);
//		}
//	)?
//	cc=component_category 
//		{
//			prototype.setCategory(cc);
//		}
//	(cr=unique_type_name 
//		{
//			cr.setReferingObject(prototype);
//			cr.setReferenceType(ParserReferenceType.ClassifierReference);
//		  unresolvedReferences.add(cr);
//		}
//	)?
//	( LBRACK RBRACK
//	 {
//	   prototype.setArray(true);
//	 }
//	)?
//	(
//	LCURLY
//	 (pa = property_association
//	   {
//	     prototype.getOwnedPropertyAssociations().add(pa);
//	   }
//	 )+
//	RCURLY
//	)? 
//	SEMI
//	;
//  catch [RecognitionException ex] {
//    reportError(ex);
//    consumeUntil(input,SEMI);
//    input.consume();
//  }       


		
// note: we recognize none by the appropriate subclause object without content
none_stmt : NONE SEMI ; 

//feature returns [ Feature feat]
//	@init{
//	}
//	:
//	ps=port_spec {feat = ps;}
//	| fgs=feature_group_spec {feat = fgs;}
//	| sca=subcomponent_access {feat = sca;}
//	| param=parameter {feat = (Feature) param;}	
//	;

abstract_feature returns [AbstractFeature af]
  @init{
    DirectionType direction = null;
    boolean refined=false;
  }
  :
  fid= IDENT COLON
  (REFINED TO
    {
      refined = true;
    }
  )?
  (
    (IN
      {
        direction = DirectionType.IN;
      }
    )
    |(OUT
      {
        direction = DirectionType.OUT;
      }
    )
  )?
  FEATURE
    {
      af = Aadl2F.createAbstractFeature();
      af.setName(fid.getText());
      if (direction != null)
        af.setDirection(direction);
      else
        af.setDirection(DirectionType.IN_OUT);
      af.setLocationReference(this.getFilename(), fid.getLine());
      if (refined) {
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.AbstractFeatureRefinementReference,af,new String[]{fid.getText()});
        unresolvedReferences.add(rr);
      }
    }
  (cr=classifier_reference
    {
      if (cr.getLabels().length > 1){
//        if (refined){
//          // this should not have a reference to a classifier this is an error
//           throw new FailedPredicateException(input,"feature ", "refinement cannot have reference to classifier");
//        }
        cr.setReferenceType(ParserReferenceType.FeatureClassifierReference);
      } else {
//        if (refined){
//          cr.setReferenceType(ParserReferenceType.FeaturePrototypeReference);
//        } else {
          cr.setReferenceType(ParserReferenceType.FeatureClassifierOrPrototypeReference);
//        }
      }
      cr.setReferencingObject(af);
      unresolvedReferences.add(cr);
    }
  )?
  (ad=array_dimension
   {
     af.setArraySpecification(ad);
   }
  )?
   (LCURLY
   (pa=property_association
     {
       af.getOwnedPropertyAssociations().add(pa); 
     }
   )+
   RCURLY
  )?
  
  SEMI
  ;
   catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
  
feature_group [boolean extension] returns [ FeatureGroup fg ]
	@init{
		boolean refinement = false;
		DirectionType direction = DirectionType.IN_OUT;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
			refinement=true;
		}
	)? 
  (
   (IN
     {
       direction=DirectionType.IN;
     }
   )
   |(OUT
     {
       direction = DirectionType.OUT;
     }
   )
  )?
	FEATURE GROUP
		{
			fg = Aadl2F.createFeatureGroup();
			fg.setName(id.getText());
			if (direction != null)
			   fg.setDirection(direction);
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			fg.setLocationReference(lr);
			if (refinement){
        ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.FeatureGroupRefinementReference,
                                                    fg,
                                                    new String[]{id.getText()}
                                                    );			 
				unresolvedReferences.add(refref);
			}
		}
	(
		(INVERSE OF
		  {
		    fg.setInverse(true);
		  }
		)? 
		(cr=classifier_reference
			{
      if (cr.getLabels().length >1){
			   // it has a package reference hende it is a 
			   // classifier
			   cr.setReferenceType(ParserReferenceType.FeatureGroupClassifierReference);
			 } else {
			   // it could be either prototype or classifier reference 
			   cr.setReferenceType(ParserReferenceType.FeatureGroupPrototypeOrClassifierReference);
			 }
			 cr.setReferencingObject(fg);
			 unresolvedReferences.add(cr);
			}
		)
  )?
  (ad=array_dimension
   {
     fg.setArraySpecification(ad);
   }
  )?
  ( LCURLY
   (pa = property_association
    {
      fg.getOwnedPropertyAssociations().add(pa);
    }
   )+ 
   RCURLY 
  )?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
			
//feature_group_spec returns [ Feature feat ]
//	@init{
//		FeatureGroup fg = Aadl2F.createFeatureGroup();
//	}
//	:
//	iden=IDENT COLON FEATURE GROUP
//	(INVERSE OF)? cr=classifier_reference
//	(prototype_binding)*
////	( LCURLY (property_association)+ RCURLY )?
//	SEMI
//	;
		
component_prototype_actual [PrototypeBinding pb] returns [PrototypeBinding rpb]
  @init{
    ComponentReference cmr=null;  
    boolean recursiveBinding=false;
  }
  :
   (cc = component_category
      {
        if (pb ==null){
        //XXX: Location
          rpb = Aadl2F.createComponentPrototypeBinding();
          pb = rpb;
        }
      }
    (cr=classifier_reference
      ( LPAREN pb1=prototype_binding
          {
          //XXX: Location
            cmr = Aadl2F.createComponentReference();
            cmr.setCategory(cc);
            ((ComponentPrototypeBinding)pb).getActuals().add(cmr);
            cr.setReferenceType(ParserReferenceType.ClassifierReference);
            cr.setReferencingObject(cmr);  
            cmr.getBindings().add(pb1);
            recursiveBinding=true;
          }
          (pb2=prototype_binding
            {
             cmr.getBindings().add(pb2);
            }
          )*
        RPAREN
      )?
      {
        if (!recursiveBinding){
          if (cr.getLabels().length > 1){
            // it contains a package label, hence it is a classifier
            //XXX: Location
              cmr = Aadl2F.createComponentReference();
              cmr.setCategory(cc);
              ((ComponentPrototypeBinding)pb).getActuals().add(cmr);
              cr.setReferenceType(ParserReferenceType.ClassifierReference);
              cr.setReferencingObject(cmr);
          } else {
            // does not contain a package label
            // neither prototype bindings so it can be
            // either a component reference or a prototype reference.
            // this means that we are not going to create any of the references
            // and we will only have a pointer to the ComponentPrototypeBinding
            // with a reference to be resolve and transformed into a PrototypeActual
            // to be added with the getActuals.add();
            cr.setReferenceType(ParserReferenceType.PrototypeOrClassifierReference);
            cr.setReferencingObject(pb);
          
            // this component category should be added to the final actual
            // (prototype or component) once the name resolver knows what it is
            cr.getResolvedObjects().add(cc);
          }
        }
        unresolvedReferences.add(cr);
      }
    )
   )
  ;	
	
component_prototype_actual_list [PrototypeBinding pb] returns [PrototypeBinding rpb]
  @init{
  }
  :
  LPAREN
  rpb1 = component_prototype_actual [pb]
    {
      rpb = rpb1;
    }
  (COMMA rpb1 = component_prototype_actual [rpb]
  )*
  RPAREN
  ;

feature_group_type_prototype_actual returns [FeatureGroupPrototypeBinding rpb]
  @init{
    FeatureGroupReference fpr=null;
    boolean recursiveBinding=false;
  }
  :
  f=FEATURE GROUP
    {
      rpb = Aadl2F.createFeatureGroupPrototypeBinding();
      rpb.setLocationReference(this.getFilename(), f.getLine());
    } 
  cr =classifier_reference
      (
      ( LPAREN pb1=prototype_binding
          {
          //XXX: Location
            fpr = Aadl2F.createFeatureGroupReference();
            rpb.setActual(fpr);
            cr.setReferenceType(ParserReferenceType.FeatureGroupTypeReference);
            cr.setReferencingObject(fpr);  
            fpr.getBindings().add(pb1);
            recursiveBinding=true;
          }
          (pb2=prototype_binding
            {
             fpr.getBindings().add(pb2);
            }
          )*
        RPAREN
      )?
      )
      {
        if (!recursiveBinding){
          if (cr.getLabels().length > 1){
          //XXX: Location
            FeatureGroupReference fgr  = Aadl2F.createFeatureGroupReference();
            rpb.setActual(fgr);
            cr.setReferenceType(ParserReferenceType.FeatureGroupTypeReference);
            cr.setReferencingObject(fgr);  
          } else {
            cr.setReferenceType(ParserReferenceType.PrototypeOrFeatureGroupTypeReference);
            cr.setReferencingObject(rpb);
          }
        }
        unresolvedReferences.add(cr);
      }
  
  ;
    	
feature_prototype_actual returns [FeaturePrototypeBinding rpb]
  @init{
    PortCategory pCategory=null;
    DirectionType direction=null;
    AccessType accessType = null;
    AccessCategory accessCategory=null;
    boolean portClassifier=false;
  }
  :
  (
    (
      (IN
        {
          direction=DirectionType.IN;
        }
      )
      |(OUT
        {
          direction=DirectionType.OUT;
        }
      )
    )?
    FEATURE
    fprotid = IDENT
      {
      //XXX: Location
        rpb = Aadl2F.createFeaturePrototypeBinding();
        //XXX: Location
        FeaturePrototypeReference fpr = Aadl2F.createFeaturePrototypeReference();
        if (direction != null)
          fpr.setDirection(direction);
        rpb.setActual(fpr);  
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FeaturePrototypeReference,
                                                 fpr,
                                                 new String[]{fprotid.getText()}
                                                 );
        unresolvedReferences.add(rr);
      }
  )
  |(
    (
      (IN OUT
        {
          direction=DirectionType.IN_OUT;
        }
      )
      |(OUT
        {
          direction=DirectionType.OUT;
        }
      )
      |(IN
        {
          direction = DirectionType.IN;
        }
      )
    )
    (
      (EVENT DATA
        {
          pCategory=PortCategory.EVENT_DATA;
        }
      )
      |(EVENT
        {
          pCategory=PortCategory.EVENT;
        }
      )
      |(DATA
        {
          pCategory=PortCategory.DATA;
        }
      )
    )
    (PORT 
      (cr=classifier_reference
        {
          if (pCategory == PortCategory.EVENT){
            throw new FailedPredicateException(input,"feature prototype actual", "an event port cannot have a classifier");
          }
          //XXX: Location
          rpb = Aadl2F.createFeaturePrototypeBinding();
          //XXX: Location
          PortSpecification ps = Aadl2F.createPortSpecification();
          if (direction != null)
            ps.setDirection(direction);
          if (pCategory !=null)
            ps.setCategory(pCategory);
          rpb.setActual(ps);
          cr.setReferenceType(ParserReferenceType.FeaturePortSpecificationClassifierReference);
          cr.setReferencingObject(ps);
          unresolvedReferences.add(cr);
          portClassifier=true;
        }
      )?
      {
        if (!portClassifier){
        //XXX: Location
          rpb = Aadl2F.createFeaturePrototypeBinding();
          //XXX: Location
          PortSpecification ps = Aadl2F.createPortSpecification();
           if (direction != null)
            ps.setDirection(direction);
          if (pCategory !=null)
            ps.setCategory(pCategory);
          rpb.setActual(ps);
        }
      }
    )
  )
  |(
    (
      (REQUIRES
        {
          accessType = AccessType.REQUIRED;
        }
      )
      |(PROVIDES
        {
          accessType = AccessType.PROVIDED;
        }
      )
    )
    (
      (BUS
        {
          accessCategory=AccessCategory.BUS;
        }
      )
      |(DATA
        {
          accessCategory=AccessCategory.DATA;
        }
      )
      |(SUBPROGRAM GROUP
        {
          accessCategory=AccessCategory.SUBPROGRAM_GROUP;
        }
      )
      |(SUBPROGRAM
        {
          accessCategory=AccessCategory.SUBPROGRAM;
        }
      )
    )
   ACCESS cr=classifier_reference
    {
    //XXX: Location
      rpb = Aadl2F.createFeaturePrototypeBinding();
      //XXX: Location
      AccessSpecification as = Aadl2F.createAccessSpecification();
      if (accessType != null)
        as.setKind(accessType);
      if (accessCategory != null)
        as.setCategory(accessCategory);       
      cr.setReferenceType(ParserReferenceType.FeatureAccessSpecificationClassifierReference);
      cr.setReferencingObject(as);
      unresolvedReferences.add(cr);
      rpb.setActual(as);
    } 
  )
  ;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
  
   	
prototype_binding returns [PrototypeBinding pb]
  scope {
    PrototypeBinding pbret;
  }
  @init{
    pb=null;
    $prototype_binding::pbret=null;
  }
  :
  protid= IDENT ASSIGN
  (
  pb1=feature_group_type_prototype_actual 
        {
          $prototype_binding::pbret = pb1;
          ReferenceRecord fref = new ReferenceRecord(ParserReferenceType.PrototypeFormalReference,
                                               pb1,
                                               new String[]{protid.getText()}
                                               );
          unresolvedReferences.add(fref);      
        }
  |
   pb4=component_prototype_actual_list[$prototype_binding::pbret]
        {
          $prototype_binding::pbret=pb4;
           ReferenceRecord fref = new ReferenceRecord(ParserReferenceType.PrototypeFormalReference,
                                               pb4,
                                               new String[]{protid.getText()}
                                               );
          unresolvedReferences.add(fref);      
      }
 | pb3=component_prototype_actual[$prototype_binding::pbret]
        {
          $prototype_binding::pbret=pb3;
          ReferenceRecord fref = new ReferenceRecord(ParserReferenceType.PrototypeFormalReference,
                                               pb3,
                                               new String[]{protid.getText()}
                                               );
          unresolvedReferences.add(fref);      
        }
 |  pb2=feature_prototype_actual
        {
          $prototype_binding::pbret=pb2;
          ReferenceRecord fref = new ReferenceRecord(ParserReferenceType.PrototypeFormalReference,
                                               pb2,
                                               new String[]{protid.getText()}
                                               );
          unresolvedReferences.add(fref);      
        }
   )
   {
        pb = $prototype_binding::pbret;
   }
  ;  	
  	
//prototype_binding returns [PrototypeBinding pb ]
//	@init{
//	}
//	:
//	id=IDENT ASSIGN
//		{
//			pb=Aadl2F.createPrototypeBinding();
//			pb.setName(id.getText());
//			LocationReference lr = new LocationReference();
//			lr.setFilename(this.getFilename());
//			lr.setLine(id.getLine());
//			pb.setLocationReference(lr);			
//		}
//	(	
//	 (cc = component_category
//	  cr=classifier_reference 
//		  {
//        pb.setCategory(cc);
//		    cr.setReferencingObject(pb);
//		    if (cr.getLabels.size() >1){
//		      // I Already know that it has a package 
//		      // hence it must be a classifier
//          cr.setReferenceType(ParserReferenceType.ClassifierReference);  
//		    } else { 
//		      cr.setReferenceType(ParserReferenceType.PrototypeOrClassifierReference);
//		    }
//		    unresolvedReferences.add(cr);
//		  }
//		  ( LPAREN pb1=prototype_binding
//		      {
//		        pb.getOwnedPrototypeBindings().add(pb1);
//		      }
//		    (COMMA pb2=prototype_binding
//		      {
//		        pb.getOwnedPrototypeBindings().add(pb2);
//		      }
//		    )*
//		    RPAREN
//		      {
//		        // overwrite the reference type because we know
//		        // that if we have bindings it is a prototype
//		        cr.setReferenceType(ParserReferenceType.PrototypeReference);
//		        pb.setPrototype(true);
//		      }
//		  )?
//	 )
//	)
//	;
	
array_dimension_body [ArraySpecification as]
@init{
}
:
    (
    l=LBRACK 
      (
      (il=integer_literal
        {
          Numeral num = Aadl2F.createNumeral();
          num.setLocationReference(this.getFilename(), l.getLine());
          num.setValue(Integer.parseInt(il.getText()));
          as.getSizes().add(num);
        }
      )
      |(pid=unique_property_identifier
        {
          pid.setReferencingObject(as);
          pid.setReferenceType(ParserReferenceType.DimensionPropertyReference);
          unresolvedReferences.add(pid);
        }
      )
      ) ?
    RBRACK
    )
    {
    	as.setLocationReference(this.getFilename(), l.getLine());
    }
    ;

array_dimension returns [ArraySpecification as]
  @init{
    as = Aadl2F.createArraySpecification();
  }
  :
  (
  array_dimension_body[as]
  )
  {
   as.setDimension(1);
  }
  ;

	
array_dimensions returns [ArraySpecification as]
  @init{
    as = Aadl2F.createArraySpecification();
    int dimension=0;
  }
	:
	(
	array_dimension_body[as]
	{
	 dimension++;
	}
	)+
	{
	 as.setDimension(dimension);
	}
	;

feature_group_type returns [FeatureGroupType fgt]
	@init{
	 boolean extension=false;
	}
	:
	FEATURE GROUP id=IDENT
		{
			fgt = Aadl2F.createFeatureGroupType();
			fgt.setName(id.getText());
			fgt.setLocationReference(this.getFilename(),id.getLine());
		}
	
	(EXTENDS cr = unique_type_name 
		{
		  extension=true;
		  cr.setReferencingObject(fgt);
		  cr.setReferenceType(ParserReferenceType.FeatureGroupTypeExtendReference);
		  unresolvedReferences.add(cr); 
		}
		(LPAREN pb=prototype_binding
			{
				fgt.getOwnedPrototypeBindings().add(pb);
			}
			(
			(COMMA pb=prototype_binding
				{
					fgt.getOwnedPrototypeBindings().add(pb);
				}
			)*
			)
			RPAREN
		)?
	)?
	( PROTOTYPES
		(
		(none_stmt
			{
				fgt.setNoPrototypes(true);
			}
		)
		|(
			(pt = prototype[extension]
				{
					fgt.getOwnedPrototypes().add(pt);
				}
			)+
		)
		)
	)?
	( FEATURES
		(
		 (par = parameter [extension]
		    {
		      fgt.getOwnedParameters().add(par);
		    } 
		 )
		 |	 
		 (af=abstract_feature
		    {
		      fgt.getOwnedAbstractFeatures().add(af);
		    }
		 )
		|
		(ba = bus_access[extension]
				{
					fgt.getOwnedBusAccesses().add(ba);
				}
			 )
			|(da = data_access[extension]
				{
					fgt.getOwnedDataAccesses().add(da);
				}
			 )
			|(sa = subprogram_access[extension]
				{
					fgt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					fgt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(fg = feature_group[extension]
				{
					fgt.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(dp = data_port[extension]
				{
					fgt.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					fgt.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					fgt.getOwnedEventPorts().add(ep);
				}
			 )
		)+
	)?
	( INVERSE OF cr=classifier_reference
		{
		  cr.setReferencingObject(fgt);
		  cr.setReferenceType(ParserReferenceType.FeatureGroupTypeInverseOfReference);
		  unresolvedReferences.add(cr);
		}
	)?
	(PROPERTIES
	 ((none_stmt
	   {
	     // TODO: wait for this method to be put in Classifier
	   }
	  )
	 |(
	   (pa=property_association
	     {
	       fgt.getOwnedPropertyAssociations().add(pa);
	     }
	    )+
	   )
	  )
	)?
	(as=annex_subclause
		{	
			fgt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText()))){
    			throw new FailedPredicateException(input,"feature group type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
				
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ category specific type portion
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

type_extension [ComponentType ct]
	:
	EXTENDS cr = unique_type_name 
		{
		  cr.setReferencingObject(ct);
		  cr.setReferenceType(ParserReferenceType.ComponentTypeExtensionReference); 
		  unresolvedReferences.add(cr);
		}
		( LPAREN pb=prototype_binding
			{
				ct.getOwnedPrototypeBindings().add(pb);
			}
			(COMMA pb=prototype_binding
				{
					ct.getOwnedPrototypeBindings().add(pb);
				}
			)*
		 RPAREN
		)?
	;

prototypes_for_types [ boolean extension, ComponentType ct]
	:
	PROTOTYPES
		(none_stmt
			{
				ct.setNoPrototypes(true);
			}
		| (
			(pt = prototype[extension]
				{
					ct.getOwnedPrototypes().add(pt);
				}
			 )+
		   )
		)
	; 

modes_for_types [ComponentType tt]
:
  (REQUIRES MODES
    (
      (md=mode
        {
          md.setDerived(true);
          tt.getOwnedModes().add(md);
        }
      )+
    )
    |
    none_stmt
      {
        tt.setNoModes(true);
      }
  )
  |(MODES
    (
      (md=mode
        {
          md.setDerived(false);
          tt.getOwnedModes().add(md);
        }
      )*
      (mt =mode_transition[tt]
        {
          tt.getOwnedModeTransitions().add(mt);
        }
      )*
    )
    |
    none_stmt
      {
        tt.setNoModes(true);
      }
  )
;

abstract_type returns [AbstractType at]
	@init{
		at = Aadl2F.createAbstractType();
		boolean extension=false;
	}
	:
	ABSTRACT id=IDENT 	
	    { 
	    	processComments(at);
	    	at.setName(id.getText());
	    	at.setLocationReference(this.getFilename(),id.getLine());
	    }
	(type_extension[at]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension, at]
	)?
	( FEATURES
		((none_stmt 
			{
				at.setNoFeatures(true);
			}
		  )
		|((
		  (fg = feature_group[extension]
				{
					at.getOwnedFeatureGroups().add(fg);
				}
			 )
       |(af=abstract_feature
        {
          at.getOwnedAbstractFeatures().add(af);
        }
       )
			|(dp = data_port[extension]
				{
					at.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					at.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					at.getOwnedEventPorts().add(ep);
				}
			 )
		 
			|(ba = bus_access[extension]
				{
					at.getOwnedBusAccesses().add(ba);
				}
			 )
			|(da = data_access[extension]
				{
					at.getOwnedDataAccesses().add(da);
				}
			 )
			|(sa = subprogram_access[extension]
				{
					at.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					at.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
		)+)
		)
	)?
	(FLOWS
		(
		(none_stmt
			{
				at.setNoFlows(true);
			}
		)
		|((fs=flow_spec[extension]
			{
				at.getOwnedFlowSpecifications().add(fs);
			}
		)+)
		)
	)?
	(modes_for_types[at]
	)?
	(properties_for_classifiers[at]	
	)?
	(as=annex_subclause
		{	
			at.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END backid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(backid.getText()))){
    		throw new FailedPredicateException(input,"abstract type", "End identifier "+backid.getText()+" does not match defining identifier "+id.getText());
			}
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	 
subprogram_group_type returns [SubprogramGroupType spgt]
	@init{
	 boolean extension=false;
	}
	:
	SUBPROGRAM GROUP id=IDENT
		{
			spgt = Aadl2F.createSubprogramGroupType();
			spgt.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			spgt.setLocationReference(lr);
		}
	(type_extension[spgt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,spgt]
	)?
	(FEATURES
		(((
			(sa = subprogram_access[extension]
				{
					spgt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					if (sga.getKind() != AccessType.REQUIRED)
	    				throw new FailedPredicateException(input,"program group type", "subprogram group access can only be required");						
					spgt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
       |(af=abstract_feature
        {
          spgt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+)
		|(none_stmt)
			{
				spgt.setNoFeatures(true);
			}
		)
	)?
  (properties_for_classifiers[spgt] 
  )?
	(as=annex_subclause
		{
			spgt.getOwnedAnnexSubclauses().add(as);
		}
	)*
	END eid=IDENT 
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"program group type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());				
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
virtual_bus_type returns [VirtualBusType vbt]
	@init{
	 boolean extension=false;
	}
	:
	VIRTUAL BUS id=IDENT
		{
			vbt = Aadl2F.createVirtualBusType();
			vbt.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			vbt.setLocationReference(lr);
		}
	(type_extension[vbt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,vbt]
	)?
	(FEATURES
		none_stmt
			{
				vbt.setNoFeatures(true);
			} 
	)?
	(modes_for_types[vbt]
	)?
  (properties_for_classifiers[vbt] 
  )?
	(as=annex_subclause
		{
			vbt.getOwnedAnnexSubclauses().add(as);
		}
	)*
	END eid=IDENT
		{
			if (!(eid.getText().equalsIgnoreCase(id.getText())))
	    		throw new FailedPredicateException(input,"program group type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());				
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
virtual_processor_type returns [VirtualProcessorType vpt]
	@init {
	 boolean extension=false;
	}
	:
	VIRTUAL PROCESSOR id=IDENT
		{
			vpt = Aadl2F.createVirtualProcessorType();
			vpt.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			vpt.setLocationReference(lr);
		}
	(type_extension[vpt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,vpt]
	)?
	(FEATURES
		(
			(none_stmt
				{
					vpt.setNoFeatures(true);
				}
			)
			|
			((sa = subprogram_access[extension]
				{
					if (sa.getKind() != AccessType.PROVIDED)
			    		throw new FailedPredicateException(input,"virtual processor type", "subprogram access can only be provided");					
					vpt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					if (sga.getKind() != AccessType.PROVIDED)
			    		throw new FailedPredicateException(input,"virtual processor type", "subprogram group access can only be provided");					
					vpt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(fg = feature_group[extension]
				{
					vpt.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(dp = data_port[extension]
				{
					vpt.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					vpt.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					vpt.getOwnedEventPorts().add(ep);
				}
			 )
       |(af= abstract_feature
        {
          vpt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+)
	)?
	(FLOWS
		((none_stmt
			{
				vpt.setNoFlows(true);
			}
		)
		|((fs=flow_spec[extension]
			{
				vpt.getOwnedFlowSpecifications().add(fs);
			}
		)+)
		)
	)?
	(modes_for_types[vpt]
	)?
  (properties_for_classifiers[vpt] 
  )?
	(as=annex_subclause
		{	
			vpt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"virtual processor type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());				
		}
	SEMI
	; 
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       

thread_type returns [ThreadType tt]
	@init{
	 boolean extension=false;
	}
	:
	THREAD id=IDENT
		{
			tt=Aadl2F.createThreadType();
			tt.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			tt.setLocationReference(lr);
		}
	(type_extension[tt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,tt]
	)?
	(FEATURES
		((none_stmt
			{
				tt.setNoFeatures(true);
			}
		)
		|((
			(da = data_access[extension]
				{
					tt.getOwnedDataAccesses().add(da);
				}
			 )
			|(sa = subprogram_access[extension]
				{
					tt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					tt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(fg = feature_group[extension]
				{
					tt.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(dp = data_port[extension]
				{
					tt.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					tt.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					tt.getOwnedEventPorts().add(ep);
				}
			 )
       |(af=abstract_feature
        {
          tt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+))
	)?
	(FLOWS
		((none_stmt
			{
				tt.setNoFlows(true);
			}
		)
		|((fs=flow_spec[extension]
			{
				tt.getOwnedFlowSpecifications().add(fs);
			}
		)+)
		)
	)?
	(modes_for_types[tt]
	)?
  (properties_for_classifiers[tt] 
  )?
	(as=annex_subclause
		{	
			tt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"thread type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());								
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       

thread_group_type returns [ThreadGroupType tt]
	@init{
	 boolean extension=false; 
	}
	:
	
	THREAD GROUP id=IDENT
		{
			tt = Aadl2F.createThreadGroupType();
			tt.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			tt.setLocationReference(lr);
		}
	(type_extension[tt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,tt]
	)?
	(FEATURES
		((none_stmt
			{
				tt.setNoFeatures(true);
			}
		)
		|((
			(da = data_access[extension]
				{
					tt.getOwnedDataAccesses().add(da);
				}
			 )
			|(sa = subprogram_access[extension]
				{
					tt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					tt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(fg = feature_group[extension]
				{
					tt.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(dp = data_port[extension]
				{
					tt.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					tt.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					tt.getOwnedEventPorts().add(ep);
				}
			 )
       |(af=abstract_feature
        {
          tt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+))
	)?
	(FLOWS
		((none_stmt
			{
				tt.setNoFlows(true);
			}
		)
		|((fs=flow_spec[extension]
			{
				tt.getOwnedFlowSpecifications().add(fs);
			}
		)+)
		)
	)?
	(modes_for_types[tt]
	)?
  (properties_for_classifiers[tt] 
  )?
	(as=annex_subclause
		{	
			tt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"thread group type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());								
		}
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
process_type returns [ProcessType pt]
	@init{
	 boolean extension=false;
	}
	:
	PROCESS id=IDENT
		{
			pt = Aadl2F.createProcessType();
			pt.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			pt.setLocationReference(lr);
		}
	(type_extension[pt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,pt]
	)?
	(FEATURES
		((none_stmt
			{
				pt.setNoFeatures(true);
			}
		)
		|((
			(da = data_access[extension]
				{
					pt.getOwnedDataAccesses().add(da);
				}
			 )
			|(sa = subprogram_access[extension]
				{
					pt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					pt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(fg = feature_group[extension]
				{
					pt.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(dp = data_port[extension]
				{
					pt.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					pt.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					pt.getOwnedEventPorts().add(ep);
				}
			 )
       |(af=abstract_feature
        {
          pt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+))
	)?
	(FLOWS
		((none_stmt
			{
				pt.setNoFlows(true);
			}
		)
		|((fs=flow_spec[extension]
			{
				pt.getOwnedFlowSpecifications().add(fs);
			}
		)+)
		)
	)?
	(modes_for_types[pt]
	)?
  (properties_for_classifiers[pt] 
  )?
	(as=annex_subclause
		{	
			pt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"process type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());			
		} 
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
system_type returns [SystemType st]
	@init{
	 boolean extension=false;
	}
	:
	SYSTEM id=IDENT
		{
			st=Aadl2F.createSystemType();
			st.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			st.setLocationReference(lr);
		}
	(type_extension[st]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,st]
	)?
	( FEATURES
		((none_stmt
			{
				st.setNoFeatures(true);
			}
		)
		|((	 (ba = bus_access[extension]
				{
					st.getOwnedBusAccesses().add(ba);
				}
			 )
			|(da = data_access[extension]
				{
					st.getOwnedDataAccesses().add(da);
				}
			 )
			|(sa = subprogram_access[extension]
				{
					st.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					st.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(fg = feature_group[extension]
				{
					st.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(dp = data_port[extension]
				{
					st.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					st.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					st.getOwnedEventPorts().add(ep);
				}
			 )
       |(af=abstract_feature
        {
          st.getOwnedAbstractFeatures().add(af);
        }
       )
		)+))
	)?
	(FLOWS
		((none_stmt
			{
				st.setNoFlows(true);
			}
		)
		|((fs=flow_spec[extension]
			{
				if (fs !=null){
					st.getOwnedFlowSpecifications().add(fs);
				}
			}
		)+))
	)?
	(modes_for_types[st]
	)?	
  (properties_for_classifiers[st] 
  )?
	(as=annex_subclause
		{	
			st.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"system type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());			
		} 
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
			
subprogram_type returns [SubprogramType st]
	@init{
	 boolean extension=false;
	}
	:
	SUBPROGRAM id=IDENT
		{
			st = Aadl2F.createSubprogramType();
			st.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			st.setLocationReference(lr);
		}
	(type_extension[st]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,st]
	)?
	(FEATURES
		((
			(sa = subprogram_access[extension]
				{
					st.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					if (sga.getKind() != AccessType.REQUIRED)
	    				throw new FailedPredicateException(input,"program type", "subprogram group access can only be required");						
					st.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(edp = event_data_port[extension]
				{
					if (edp.getDirection() != DirectionType.OUT)
	    				throw new FailedPredicateException(input,"program type", "event data ports can only be out");						
					st.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					if (ep.getDirection() != DirectionType.OUT)
						throw new FailedPredicateException(input,"program type", "event ports can only be out");						
					st.getOwnedEventPorts().add(ep);
				}
			 )
			|(fg = feature_group[extension]
				{
					st.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(da = data_access[extension]
				{
					if (da.getKind() != AccessType.REQUIRED)
	    				throw new FailedPredicateException(input,"program type", "data access can only be required");											
					st.getOwnedDataAccesses().add(da);
				}
			 )
			|(pa = parameter[extension]
				{
					st.getOwnedParameters().add(pa);
				}
			  )
       |(af=abstract_feature
        {
          st.getOwnedAbstractFeatures().add(af);
        }
       )
		)+)
		| (none_stmt
				{
					st.setNoFeatures(true);
				}
		   )
	)?
	(modes_for_types[st]
	)?
  (properties_for_classifiers[st] 
  )?
	(as=annex_subclause
		{
			st.getOwnedAnnexSubclauses().add(as);
		}
	)*
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"subprogram type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());			
		} 
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
data_type returns [DataType dt]
	@init{
	 boolean extension=false;
	}
	:
	DATA id=IDENT
		{
			dt = Aadl2F.createDataType();
			dt.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			dt.setLocationReference(lr);
		}
	(type_extension[dt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,dt]
	)?
	(FEATURES
		((
			(sa = subprogram_access[extension]
				{
					dt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					if (sga.getKind() != AccessType.REQUIRED)
	    				throw new FailedPredicateException(input,"data type", "subprogram group access can only be required");						
					dt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
       |(af=abstract_feature
        {
          dt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+)
		|(none_stmt
			{
				dt.setNoFeatures(true);
			}
		)
	)?
  (properties_for_classifiers[dt] 
  )?
	(as=annex_subclause
		{
			dt.getOwnedAnnexSubclauses().add(as);
		}
	)*
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"data type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());			
		} 
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
		
processor_type returns [ProcessorType pt]
	@init{
	 boolean extension=false;
	}
	:
	PROCESSOR id=IDENT
		{
			pt = Aadl2F.createProcessorType();
			pt.setName(id.getText());
			pt.setLocationReference(this.getFilename(),id.getLine());
		}
	(type_extension[pt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,pt]
	)?
	( FEATURES
		((none_stmt
			{
				pt.setNoFeatures(true);
			}
		)
		|((	 (ba = bus_access[extension]
				{
					pt.getOwnedBusAccesses().add(ba);
				}
			 )
			|(sa = subprogram_access[extension]
				{
					if (sa.getKind() != AccessType.PROVIDED)
	    				throw new FailedPredicateException(input,"processor type", "subprogram access can only be provided");						
					pt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					if (sga.getKind() != AccessType.PROVIDED)
	    				throw new FailedPredicateException(input,"processor type", "subprogram group access can only be provided");						
					pt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(fg = feature_group[extension]
				{
					pt.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(dp = data_port[extension]
				{
					pt.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					pt.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					pt.getOwnedEventPorts().add(ep);
				}
			 )
       |(af=abstract_feature
        {
          pt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+))
	)?
	(FLOWS
		((none_stmt
			{
				pt.setNoFlows(true);
			}
		)
		|((fs=flow_spec[extension]
			{
				pt.getOwnedFlowSpecifications().add(fs);
			}
		)+)
		)
	)?	
	(modes_for_types[pt]
	)?
  (properties_for_classifiers[pt] 
  )?
	(as=annex_subclause
		{	
			pt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"processor type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());			
		} 
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
	
memory_type returns [MemoryType mt]
	@init{
	 boolean extension=false;
	}
	:
	MEMORY id=IDENT
		{
			mt = Aadl2F.createMemoryType();
			mt.setName(id.getText());
			mt.setLocationReference(this.getFilename(),id.getLine());
		}
	(type_extension[mt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,mt]
	)?
	( FEATURES
		((none_stmt
			{
				mt.setNoFeatures(true);
			}
		)
		|((	 (ba = bus_access[extension]
				{
					mt.getOwnedBusAccesses().add(ba);
				}
			 )
			|(fg = feature_group[extension]
				{
					mt.getOwnedFeatureGroups().add(fg);
				}
			)
       |(af=abstract_feature
        {
          mt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+))
	)?
	(modes_for_types[mt]
	)?
  (properties_for_classifiers[mt] 
  )?
	(as=annex_subclause
		{	
			mt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"memory type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());			
		} 
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
		
bus_type returns [BusType bt]
	@init{
	 boolean extension=false;
	}
	:
	BUS id=IDENT
		{
			bt = Aadl2F.createBusType();
			bt.setName(id.getText());
			bt.setLocationReference(this.getFilename(),id.getLine());
		}
	(type_extension[bt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension, bt]
	)?
	( FEATURES
		(
		(none_stmt
			{
				bt.setNoFeatures(true);
			}
		)
		|((	 (ba = bus_access[extension]
				{
					if (ba != null){
						if (ba.getKind() != AccessType.REQUIRED)
	    					throw new FailedPredicateException(input,"bus type", "bus access can only be required");						
						bt.getOwnedBusAccesses().add(ba);
					}
				}
			 )
			|( fg = feature_group[extension]
				{
					bt.getOwnedFeatureGroups().add(fg);
				}
			)
       |(af= abstract_feature
        {
          bt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+)
		)
	)?
	(modes_for_types[bt]
	)?
  (properties_for_classifiers[bt] 
  )?
	(as=annex_subclause
		{	
			bt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"bus type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());			
		} 
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
		
device_type returns [DeviceType dt]
	@init{
	 boolean extension=false;
	}
	:
	DEVICE id=IDENT
		{
			dt = Aadl2F.createDeviceType();
			dt.setName(id.getText());
			dt.setLocationReference(this.getFilename(),id.getLine());
		}
	(type_extension[dt]
	 {
	   extension=true;
	 }
	)?
	( prototypes_for_types[extension,dt]
	)?
	( FEATURES
		(((	 (ba = bus_access[extension]
				{
					dt.getOwnedBusAccesses().add(ba);
				}
			 )
			|(sa = subprogram_access[extension]
				{
					if (sa.getKind() != AccessType.PROVIDED)
	    				throw new FailedPredicateException(input,"processor type", "subprogram access can only be provided");						
					dt.getOwnedSubprogramAccesses().add(sa);
				}
			 )
			|(sga = subprogram_group_access[extension]
				{
					if (sga.getKind() != AccessType.PROVIDED)
	    				throw new FailedPredicateException(input,"processor type", "subprogram group access can only be provided");						
					dt.getOwnedSubprogramGroupAccesses().add(sga);
				}
			 )
			|(fg = feature_group[extension]
				{
					dt.getOwnedFeatureGroups().add(fg);
				}
			 )
			|(dp = data_port[extension]
				{
					dt.getOwnedDataPorts().add(dp);
				}
			 )
			|(edp = event_data_port[extension]
				{
					dt.getOwnedEventDataPorts().add(edp);
				}
			 )
			|(ep = event_port[extension]
				{
					dt.getOwnedEventPorts().add(ep);
				}
			 )
       |(af=abstract_feature
        {
          dt.getOwnedAbstractFeatures().add(af);
        }
       )
		)+)
		| (none_stmt
			{
				dt.setNoFeatures(true);
			}
		))
	)?
	(FLOWS
		((none_stmt
			{
				dt.setNoFlows(true);
			}
		)
		|((fs=flow_spec[extension]
			{
				dt.getOwnedFlowSpecifications().add(fs);
			}
		)+)
		)
	)?	
	(modes_for_types[dt]
	)?
  (properties_for_classifiers[dt] 
  )?
	(as=annex_subclause
		{	
			dt.getOwnedAnnexSubclauses().add(as);
		}
	)?
	END eid=IDENT
		{
			if (!(id.getText().equalsIgnoreCase(eid.getText())))
	    		throw new FailedPredicateException(input,"bus type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());			
		} 
	SEMI
	;
	catch [RecognitionException ex] {
		reportError(ex);
		consumeUntil(input,END);
		consumeUntil(input,SEMI);
		input.consume();
	}       
				
//thread_type returns [ThreadType tt]
//		/*options {defaultErrorHandler=true;}*/ 
//   @init { 
//   	tt=null; 
//   	//ClassifierReference cr =null;
//    //AnnexSubclause ax=null; 
//    //Properties ps=null; 
//    }:
//	THREAD 	id=IDENT 	
//	    { tt = Aadl2F.createThreadType(); processComments(tt);}
//	    {tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	( featuresThread[tt] )?
//	 ( flow_specs[tt] )?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT sl=SEMI
//    { 
//    	if (!id.getText().equalsIgnoreCase(eid.getText())) 
//    		//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());
//    		throw new FailedPredicateException(input,"thread type", "End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
//    }
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }       
	
//thread_group_type returns [ThreadGroupType tt]
///*options {defaultErrorHandler=true;}*/
//
//   @init { 
//   		tt= null; 
//   		//AnnexSubclause ax=null; Properties ps=null; 
//    	//ClassifierReference cr =null;
//    	 }:
//	THREAD GROUP 	id=IDENT 	
//	    { tt = Aadl2F.createThreadGroupType(); processComments(tt);}
//	    {	tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	(featuresThreadGroup[tt])?
//	 ( flow_specs[tt] )?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT SEMI 
//     { if (!id.getText().equalsIgnoreCase(eid.getText())) 
//     	//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());
//     	throw new FailedPredicateException(input,"thread group type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
//     }
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }
	
//process_type returns [ProcessType tt]
///*options {defaultErrorHandler=true;}*/
//   @init { 
//   	tt=null;
//	//AnnexSubclause ax=null; 
//	//Properties ps=null; 
//    //ClassifierReference cr=null ;
//    }:
//	PROCESS 	id=IDENT 	
//	    { tt = Aadl2F.createProcessType(); processComments(tt);}
//	    {	tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS  cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	(featuresProcess[tt])?
//	 ( flow_specs[tt] )?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT SEMI 
//    { if (!id.getText().equalsIgnoreCase(eid.getText())) 
//    	//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());}
//    	throw new FailedPredicateException(input,"process type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());}
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }
	
//system_type returns [SystemType tt]
///*options {defaultErrorHandler=true;}*/
//   @init { 
//   	tt=null;
//   	//AnnexSubclause ax=null; 
//   	//Properties ps=null; 
//   	//ClassifierReference cr =null;
//   }:
//	SYSTEM 	id=IDENT 	
//	    { tt = Aadl2F.createSystemType(); processComments(tt);}
//	    {	tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	(featuresSystem[tt])?
//	 ( flow_specs[tt] )?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT SEMI 
//    { if (!id.getText().equalsIgnoreCase(eid.getText())) 
//    	//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());}
//    	throw new FailedPredicateException(input,"system type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());}
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }
	
//subprogram_type returns [SubprogramType tt]
///*options {defaultErrorHandler=true;}*/
//   @init {
//   	tt=null; 
//   	//AnnexSubclause ax=null; 
//   	//Properties ps=null; 
//   	//ClassifierReference cr =null;
//   }:
//	SUBPROGRAM 	id=IDENT 	
//	    { tt = Aadl2F.createSubprogramType(); processComments(tt);}
//	    {	tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	(featuresSubprogram[tt])?
//	 ( flow_specs[tt] )?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT SEMI 
//    { if (!id.getText().equalsIgnoreCase(eid.getText())) 
//    	//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());}
//    	throw new FailedPredicateException(input,"subprogram type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());}
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

	
//data_type returns [DataType tt]
///*options {defaultErrorHandler=true;}*/
//   @init { 
//   	tt=null;
//   	//AnnexSubclause ax=null; 
//   	//Properties ps=null; 
//    //ClassifierReference cr =null;
//    }:
//	DATA 	id=IDENT 	
//	    { tt = Aadl2F.createDataType(); processComments(tt);}
//	    {	tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	(featuresData[tt])?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT SEMI 
//    { if (!id.getText().equalsIgnoreCase(eid.getText())) 
//    	//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());}
//    	throw new FailedPredicateException(input,"data type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());}
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

	
//processor_type returns [ProcessorType tt]
///*options {defaultErrorHandler=true;}*/
//   @init { 
//   	tt=null;
//   	//AnnexSubclause ax=null; 
//   	//Properties ps=null; 
//    //ClassifierReference cr =null;
//    }:
//	PROCESSOR 	id=IDENT 	
//	    { tt = Aadl2F.createProcessorType(); processComments(tt);}
//	    {	tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	(featuresProcessor[tt])?
//	 ( flow_specs[tt] )?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT SEMI 
//    { if (!id.getText().equalsIgnoreCase(eid.getText())) 
//    	//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());}
//    	throw new FailedPredicateException(input,"processor type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());}
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }
	
//memory_type returns [MemoryType tt]
///*options {defaultErrorHandler=true;}*/
//   @init { 
//   	tt=null;
//   	//AnnexSubclause ax=null; 
//   	//Properties ps=null; 
//    //ClassifierReference cr =null;
//    }:
//	MEMORY 	id=IDENT 	
//	    { tt = Aadl2F.createMemoryType(); processComments(tt);}
//	    {	tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	(featuresMemory[tt])?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT SEMI 
//    { if (!id.getText().equalsIgnoreCase(eid.getText())) 
//    	//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());}
//    	throw new FailedPredicateException(input,"memory type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());}
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }
	
//bus_type returns [BusType tt]
///*options {defaultErrorHandler=true;}*/
//   @init { 
//   	tt=null;
//   	//AnnexSubclause ax=null; 
//   	//Properties ps=null; 
//    //	ClassifierReference cr =null;
//    }:
//	BUS id=IDENT 	
//	    { 
//	    	tt = Aadl2F.createBusType(); processComments(tt);
//	    	tt.setName(id.getText());
//	    	tt.setLocationReference(this.getFilename(),id.getLine());
//	    }
//	(EXTENDS cr = unique_type_name 
//		{ 
//			tt.setExtendedClassifierReference(cr);
//		}
//	)?
//	(prototypes[tt])?
//	(featuresBus[tt])?
//	( ps = propertyAssociations_no_modes 
//		{ 
//			tt.setProperties(ps); 
//		}
//	)?
//	( ax = annex_subclause 
//		{ 
//			tt.addAnnexSubclause(ax); 
//		} 
//	)?
//    END eid=IDENT SEMI 
//    	{ 
//    		if (!id.getText().equalsIgnoreCase(eid.getText())) 
//		    	throw new FailedPredicateException(input,"bus type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());
//		    
//		    processPostComments(tt);
//		 }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }
	
//device_type returns [DeviceType tt]
///*options {defaultErrorHandler=true;}*/
//   @init { 
//   	tt=null;
//   	//AnnexSubclause ax=null; 
//   	//Properties ps=null; 
//    //	ClassifierReference cr =null;
//    }:
//	DEVICE 	id=IDENT 	
//	    { tt = Aadl2F.createDeviceType(); processComments(tt);}
//	    {	tt.setName(id.getText());tt.setLocationReference(this.getFilename(),id.getLine());}
//	(EXTENDS cr = unique_type_name { tt.setExtendedClassifierReference(cr);})?
//	(featuresDevice[tt])?
//	 ( flow_specs[tt] )?
//	( ps = propertyAssociations_no_modes { tt.setProperties(ps); } )?
//	( ax = annex_subclause { tt.addAnnexSubclause(ax); } )?
//    END eid=IDENT SEMI 
//    { if (!id.getText().equalsIgnoreCase(eid.getText())) 
//    	//throw new SemanticException("End identifier "+eid.getText()+" does not match defining identifier "+id.getText(),this.getFilename(),eid.getLine(),eid.getCharPositionInLine());}
//    	throw new FailedPredicateException(input,"device type","End identifier "+eid.getText()+" does not match defining identifier "+id.getText());}
//    { processPostComments(tt); }
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }
		
//-------------------------------------------------------------------
//  unique type name must refer to a type
// unqiue implemenation name must refer to an implementation
// classifier reference may be incomplete.
// ClassifierReference is an object that has three fields:
// package name, type name, impl name. Any of them can be null
//---------------------------------------------------------------

//unique_type_name returns [ClassifierReference cr]
//  @init {
//    cr = new ClassifierReference();
//    String pn = "";
//  }:
//   ( pid= IDENT DOUBLECOLON 
//      { pn = pn + (pn.length() == 0 ? "":"::")+pid.getText();}
//   )* 
//   {
//    if ( pn.length() > 0 ) {
//      cr.setPackageName(pn);
//      referencedPackages.add(pn);
//    }
//   }
//   tid=IDENT { cr.setClassifierName(tid.getText()); cr.setFilename(this.getFilename());cr.setLine(tid.getLine());}
//;


unique_type_name returns [ReferenceRecord rr]
	@init {
		String pn = "";
	}:
	 ( pid= IDENT DOUBLECOLON 
	 		{ pn = pn + (pn.length() == 0 ? "":"::")+pid.getText();}
	 )* 
	 {
	 	if ( pn.length() > 0 ) {
	 		referencedPackages.add(pn);
	 	}
	 }
	 tid=IDENT 
	   { 
	     rr = new ReferenceRecord( (pn.length() >0)? new String[]{pn,tid.getText()} 
	                                               : new String[]{tid.getText()}
	                              );
	   }
;

unique_impl_name returns [ReferenceRecord rr ]
  @init {
    String pn = "";
  }:
   ( pid= IDENT DOUBLECOLON 
      { pn = pn +(pn.length() == 0 ? "":"::")+pid.getText();}
   )* 
   {
    if ( pn.length() > 0 ) {
      referencedPackages.add(pn);
    }
   }
   tid=IDENT DOT iid=IDENT 
      {
         rr = new ReferenceRecord( (pn.length() >0) ? new String[]{pn,tid.getText(),iid.getText()} 
                                                    : new String[]{tid.getText(), iid.getText()}
                                  );
      }
    ;


//unique_impl_name returns [ClassifierReference cr ]
//	@init {
//		cr = new ClassifierReference();
//		String pn = "";
//	}:
//	 ( pid= IDENT DOUBLECOLON 
//	 		{ pn = pn +(pn.length() == 0 ? "":"::")+pid.getText();}
//	 )* 
//	 {
//	 	if ( pn.length() > 0 ) {
//	 		cr.setPackageName(pn);
//	 		referencedPackages.add(pn);
//	 	}
//	 }
//	 tid=IDENT { cr.setFilename(this.getFilename());cr.setLine(tid.getLine());}
//	DOT iid=IDENT { cr.setClassifierName(tid.getText()+"."+iid.getText());}
//    ;

classifier_reference returns [ReferenceRecord cr]
	@init {
		String pn = "";
		String stid ="";
		String siid = "";
	}:
	(
	 ( pid= IDENT DOUBLECOLON 
	 		{ 
	 		  pn = pn +(pn.length() == 0 ? "":"::")+pid.getText();
	 		}
	 )* 
	 {
	 	if ( pn.length() > 0 ) {
	 		referencedPackages.add(pn);
	 	}
	 }
	 tid=IDENT 
	   {
	     stid = tid.getText();
	    }
	( DOT iid=IDENT 
			{
			 siid = iid.getText(); 
			}
	)?
	)
	 {
	   cr = new ReferenceRecord();
	   stid = (siid.length() >0) ? stid + "."+siid : stid;
	   cr.setLabels((pn.length() >0) ? (new String[]{pn,stid})
	                                 : (new String[]{stid}) 
	               );
	 }
    ;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 4.4 Component Implementations
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ category specific implementation portion
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//common_component_impl [ComponentImplementation ci]
//	@init {
//		//Properties ps =null;
//		//AnnexSubclause ax =null;
//	}
//:
//		(mode_subclause[ci])?
////	   ( ps = containedPropertyAssociations { ci.setProperties(ps); processComments(ps);} )?
//		( ax = annex_subclause { ci.addAnnexSubclause(ax); processComments(ax);} )?
//;


//thread_implementation returns [ThreadImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null; 
//		//CallSequences calls = null;
//	}:
//		THREAD IMPL { ci = Aadl2F.createThreadImplementation();processComments(ci);}
//	 typeid=IDENT DOT 
//	defid=IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	   (EXTENDS cr = unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		(threadSubcomponents[ci] )?
//		(calls = callsSubclause { ci.setCallSequences(calls);})?
//		(connectionsSubclause[ci])?
//		(flow_impls[ci])?
//		common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("Defining identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"thread implementation","Defining identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//thread_group_implementation returns [ThreadGroupImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null;
//	}:
//		THREAD GROUP IMPL { ci = Aadl2F.createThreadGroupImplementation();processComments(ci);}
//	 typeid=IDENT DOT 
//	defid=IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	(EXTENDS cr = unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		(threadgroupSubcomponents[ci] )?
//		(connectionsSubclause[ci])?
//		(flow_impls[ci])?
//		common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"thread group implementation","Defining identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//process_implementation returns [ProcessImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null;
//	}:
//		PROCESS IMPL { ci = Aadl2F.createProcessImplementation();processComments(ci);}
//	 typeid= IDENT DOT 
//	 defid= IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	   (EXTENDS cr= unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		(processSubcomponents[ci] )?
//		(connectionsSubclause[ci])?
//		(flow_impls[ci])?
//		common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           //throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           throw new FailedPredicateException(input,"process implementation","identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//system_implementation returns [SystemImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null;
//	}:
//		SYSTEM IMPL { ci = Aadl2F.createSystemImplementation();processComments(ci);}
//	 typeid= IDENT DOT 
//	defid= IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	  (EXTENDS cr= unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		(systemSubcomponents[ci] )?
//		(connectionsSubclause[ci])?
//		(flow_impls[ci])?
//		common_component_impl[ci]


//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"system implementation","identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//data_implementation returns [DataImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null;
//	}:
//		DATA IMPL { ci = Aadl2F.createDataImplementation();processComments(ci);}
//	 typeid= IDENT DOT 
//	defid= IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	  (EXTENDS cr= unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		(dataSubcomponents[ci] )?
//        (dataConnectionsSubclause[ci] )?		
//        common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"data implementation","identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//subprogram_implementation returns [SubprogramImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null; 
//		//CallSequences calls=null;
//	}:
//		SUBPROGRAM IMPL { ci = Aadl2F.createSubprogramImplementation();processComments(ci);}
//	 typeid= IDENT DOT 
//	defid= IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	(EXTENDS cr= unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		( calls = callsSubclause {ci.setCallSequences(calls);} )?
//		(connectionsSubclause[ci])?
//		(flow_impls[ci])?
//		common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"subprogram implementation","identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//processor_implementation returns [ProcessorImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null;
//	}:
//		PROCESSOR IMPL { ci = Aadl2F.createProcessorImplementation();processComments(ci);}
//	 typeid= IDENT DOT 
//	defid= IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	(EXTENDS cr= unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		(processorSubcomponents[ci])? 
//        (busConnectionsSubclause[ci] )?		
//		(flow_impls[ci])?
//		common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"processor implementation","identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//memory_implementation returns [MemoryImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null;
//	}:
//		MEMORY IMPL { ci = Aadl2F.createMemoryImplementation();processComments(ci);}
//	 typeid= IDENT DOT 
//	defid= IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	(EXTENDS cr= unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		(memorySubcomponents[ci] )?
//        (busConnectionsSubclause[ci] )?		
//		common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"memory implementation","identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//bus_implementation returns [BusImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null;
//	}:
//		BUS IMPL { ci =Aadl2F.createBusImplementation();processComments(ci);}
//	 typeid= IDENT DOT 
//	defid= IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	(EXTENDS cr= unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"bus implementation","identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//device_implementation returns [DeviceImplementation ci]
///*options {defaultErrorHandler=true;}*/
//	@init {
//		ci=null;
//		//ClassifierReference cr=null;
//	}:
//		DEVICE IMPL { ci = Aadl2F.createDeviceImplementation();processComments(ci);}
//	 typeid= IDENT DOT 
//	defid= IDENT { ci.setName(typeid.getText()+"."+defid.getText());ci.setLocationReference(this.getFilename(),defid.getLine());}
//	(EXTENDS cr = unique_impl_name { ci.setExtendedClassifierReference(cr);})?
//	    (refinestypeSubclause[ci])?
//		(flow_impls[ci])?
//		common_component_impl[ci]

//		END id=IDENT DOT id2=IDENT SEMI
//           { if (!((id.getText().equalsIgnoreCase(typeid.getText()) && id2.getText().equalsIgnoreCase(defid.getText()) ))) 
//           	//throw new SemanticException("identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText(),this.getFilename(),id.getLine(),id.getCharPositionInLine());}
//           	throw new FailedPredicateException(input,"device implementation","identifier "+typeid.getText()+"."+defid.getText()+" does not match end identifier "+id.getText()+"."+id2.getText());}
//            { processPostComments(ci); }
//		;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ category specific provides clauses
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//featuresData [DataType ct]  
//@init {DataFeatures pr=null;}:		 
//     FEATURES {  pr = Aadl2F.createDataFeatures(); processComments(pr);}
//                   { ct.setFeatures(pr); }
//	  ( ( 
//	  		dataFeature[pr]
//	    )+ 
//	      // an empty provides object represents none
//		|  none_stmt )
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//dataFeature[DataFeatures pr]
//	@init {
//	boolean refined = false; 
//	Feature fs =null;
//	}:
//         id= IDENT 
//         COLON 
//         ( REFINED TO { refined = true; } )?
//	      
//	    (  fs1=data_subprogram {fs=fs1;}
//        | ( PROVIDES fs2= dataAccess[AccessDirection.PROVIDED_LITERAL] {fs=fs2;}
//	      )
//	    ) 
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//				{ if (refined){RefinedReference fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//featuresSubprogram [SubprogramType ct]  
////options {defaultErrorHandler=true;}
//@init {SubprogramFeatures pr=null;}:		 
//     FEATURES {  pr = Aadl2F.createSubprogramFeatures(); processComments(pr);}
//                   { ct.setFeatures(pr); }
//	    ( ( subprogramFeature[pr]
//	      )+ 
//	    // an empty provides object represents none
//		|  none_stmt  )
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//subprogramFeature[SubprogramFeatures pr]
//	      @init {
//			boolean refined = false; 
//			Feature fs =null;
//		  }:
//         id= IDENT 
//         COLON 
//         ( REFINED TO { refined = true; } )?
//	      
//	      ( fs1= subprogramPort {fs=fs1;}
//	        | fs2 = port_group_spec {fs=fs2;}
//	      |
//	        ( REQUIRES fs3= dataAccess[AccessDirection.REQUIRED_LITERAL] {fs=fs3;}
//	        )
//	      | fs4= parameter {fs=fs4;}
//	      )
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){
//                	RefinedReference fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}
//                }
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//featuresThread [ThreadType ct]  
////options {defaultErrorHandler=true;}
//@init { ThreadFeatures pr = Aadl2F.createThreadFeatures(); processComments(pr);
//         ct.setFeatures(pr); }:		 
//    FEATURES 
//	    ( ( threadFeature[pr]
//	      )+ 
//	    // an empty provides object represents none
//		|  none_stmt  )
//    ;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//threadFeature[ThreadFeatures pr]
//	        @init {
//	        	boolean refined = false; 
//	        	Feature fs =null;
//	        }:
//         id=IDENT 
//         COLON 
//         ( REFINED TO { refined = true; } )?
//	      
//	      (  fs1= port_spec {fs=fs1;} 
//	        | fs2 = port_group_spec {fs=fs2;}
//	        | fs3 = server_subprogram {fs=fs3;}
//	        | (PROVIDES fs4= dataAccess[AccessDirection.PROVIDED_LITERAL] ) {fs=fs4;}
//	        | (REQUIRES fs5= dataAccess[AccessDirection.REQUIRED_LITERAL] ) {fs=fs5;}
//	        )
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){RefinedReference fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//featuresThreadGroup [ThreadGroupType ct]  
////options {defaultErrorHandler=true;}
//@init { ThreadGroupFeatures pr = Aadl2F.createThreadGroupFeatures(); processComments(pr);
//                    ct.setFeatures(pr); }:		 
//    FEATURES 
//	    ( ( threadGroupFeature[pr]
//	    )+ 
//	    // an empty provides object represents none
//		|  none_stmt  );
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//threadGroupFeature[ThreadGroupFeatures pr]
//	      @init {
//	      	boolean refined = false; 
//	      	RefinedReference fr=null;
//	      	Feature fs =null;
//	      	}:
//         id= IDENT 
//         COLON 
//         ( REFINED TO { refined = true; } )?
//	      
//	      (  fs1= port_spec {fs=fs1;} 
//	      | fs2= port_group_spec {fs=fs2;}
//	      | fs3= server_subprogram {fs=fs3;}
//	      | (PROVIDES fs4=dataAccess[AccessDirection.PROVIDED_LITERAL] ) {fs=fs4;}
//	      | (REQUIRES fs5= dataAccess[AccessDirection.REQUIRED_LITERAL] ) {fs=fs5;}
//	        )
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//;		
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//featuresProcess [ProcessType ct]  
////options {defaultErrorHandler=true;}
//@init { ProcessFeatures pr = Aadl2F.createProcessFeatures(); processComments(pr);
//                    ct.setFeatures(pr); }:		 
//    FEATURES 
//	    ( ( processFeature[pr]
//	    )+ 
//	    // an empty provides object represents none
//		|  none_stmt );
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//processFeature[ProcessFeatures pr]
//	        @init {
//	        	boolean refined = false; 
//	        	RefinedReference fr=null;
//	        	Feature fs =null;
//	        }:
//         id= IDENT 
//         COLON 
//         ( REFINED TO { refined = true; } )?
//	      
//	      (  fs1= port_spec {fs=fs1;} 
//	      | fs2= port_group_spec {fs=fs2;}
//	      | fs3= server_subprogram  {fs=fs3;}
//	      | (PROVIDES fs4= dataAccess[AccessDirection.PROVIDED_LITERAL] ) {fs=fs4;}
//	      | (REQUIRES fs5= dataAccess[AccessDirection.REQUIRED_LITERAL] ) {fs=fs5;}
//	      )
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//featuresSystem [SystemType ct]  
////options {defaultErrorHandler=true;}
//@init { SystemFeatures pr = Aadl2F.createSystemFeatures(); processComments(pr);
//                   ct.setFeatures(pr); }:		 
//     FEATURES 
//	    ((  systemFeature[pr]
//	     )+ 
//	    // an empty provides object represents none
//		|  none_stmt  );
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//systemFeature[SystemFeatures pr]
//	        @init {
//	        	boolean refined = false; 
//	        	RefinedReference fr=null;
//	        	Feature fs =null;
//	        }:
//           id= IDENT 
//           COLON 
//           ( REFINED TO { refined = true; } )?
//	      
//	       (  fs1= port_spec {fs=fs1;}
//	         | fs2= port_group_spec {fs=fs2;}
//	         | fs3= server_subprogram {fs=fs3;}
//	         | ( PROVIDES fs4=  dataAccess[AccessDirection.PROVIDED_LITERAL] ) {fs=fs4;}
//	         | (PROVIDES fs5= busAccess[AccessDirection.PROVIDED_LITERAL] ) {fs=fs5;}
//	         | (REQUIRES fs6= dataAccess[AccessDirection.REQUIRED_LITERAL] ) {fs=fs6;}
//	         | (REQUIRES fs7= busAccess[AccessDirection.REQUIRED_LITERAL] ){fs=fs7;}
//	        )
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//featuresProcessor[ProcessorType ct]  
////options {defaultErrorHandler=true;}
//@init { ProcessorFeatures pr = Aadl2F.createProcessorFeatures(); processComments(pr);
//                    ct.setFeatures(pr); }:		 
//     FEATURES 
//	  (  (  
//	  		processorFeature[pr]
//	    )+ 
//	    // an empty provides object represents none
//		|  none_stmt );
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//processorFeature[ProcessorFeatures pr]
//	        @init {
//	        	boolean refined = false; 
//	        	RefinedReference fr=null;
//	        	Feature fs =null;
//	        }:
//         id= IDENT 
//         COLON 
//         ( REFINED TO { refined = true; } )?
//	      
//	      (  fs1= port_spec {fs=fs1;}
//	      | fs2= port_group_spec {fs=fs2;}
//	      | fs3= server_subprogram {fs=fs3;}
//	      | (REQUIRES fs4= busAccess[AccessDirection.REQUIRED_LITERAL] ){fs=fs4;}
//	      )
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//;       
//		catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//featuresDevice [DeviceType ct] 
////options {defaultErrorHandler=true;}
//@init { DeviceFeatures pr = Aadl2F.createDeviceFeatures(); processComments(pr);
//                    ct.setFeatures(pr); }:
//     FEATURES 
//	  (  (  
//	  		deviceFeature[pr]
//	    )+ 
//	    // an empty provides object represents none
//		|  none_stmt 
//	);
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//deviceFeature[DeviceFeatures pr]
//	        @init {
//	        	boolean refined = false; 
//	        	Feature fs =null;
//	        }:
//           id= IDENT 
//           COLON 
//           ( REFINED TO { refined = true; } )?
//	      
//	       ( fs1=  port_spec {fs=fs1;} 
//	       | fs2= port_group_spec {fs=fs2;} 
//	       | fs3= server_subprogram {fs=fs3;} 
//	       |( REQUIRES fs4= busAccess[AccessDirection.REQUIRED_LITERAL] ){fs=fs4;} 
//	       |( PROVIDES fs5= busAccess[AccessDirection.PROVIDED_LITERAL] ){fs=fs5;} 
//	       )
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){RefinedReference fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//;          
//		catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }
	

//featuresMemory [MemoryType ct]  
////options {defaultErrorHandler=true;}
//@init { MemoryFeatures pr = ct.getFeatures();}:	
//     FEATURES { if (pr == null) {pr = Aadl2F.createMemoryFeatures(); ct.setFeatures(pr);} processComments(pr);}
//	    (  (
//	    memoryFeature[pr]
//	      )+ 
//	      // an empty provides object represents none
//		  |  none_stmt  
//		);
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//memoryFeature[MemoryFeatures pr]
//		   @init {
//		   		boolean refined = false; 
//		   		//Feature fs =null;
//		   	}:
//           id= IDENT 
//           COLON 
//           ( REFINED TO { refined = true; } )?
//	       (
//	         REQUIRES fs= busAccess[AccessDirection.REQUIRED_LITERAL] 
//                { fs.setName(id.getText()); fs.setRefined(refined); pr.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){RefinedReference fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//	       )
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//featuresBus [BusType ct]  
////options {defaultErrorHandler=true;}
//            @init { BusFeatures pr = ct.getFeatures();}:
//     FEATURES { if (pr == null) {pr = Aadl2F.createBusFeatures(); ct.setFeatures(pr);}processComments(pr); }
//     ( (
//	     busFeature[pr]
//	    )+ 
//	    // an empty provides object represents none
//		|  none_stmt 
//	) ;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//busFeature[BusFeatures bf]
//	        @init {
//	        	boolean refined = false; 
//	        	//Feature fs =null;
//	        }:
//         id= IDENT 
//         COLON 
//         ( REFINED TO { refined = true; } )?
//	      (
//	        REQUIRES fs= busAccess[AccessDirection.REQUIRED_LITERAL] 
//	      )
//                { fs.setName(id.getText()); fs.setRefined(refined); bf.addFeature(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                { if (refined){RefinedReference fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}}
//   ;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ refines type subclause
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//refinestypeSubclause [ComponentImplementation ci]
//	@init { 
//		RefinesType rt = Aadl2F.createRefinesType(); 
//		ci.setRefinesType(rt);
//		processComments(rt);
//		RefinedReference fr=null;
//		Feature fs =null;
//	}: 
//	REFINES TYPE 
//		( ( 
//             id= IDENT 
//             COLON 
//             REFINED TO 
//			 ( fs1 =  port_spec  {fs=fs1;}
//			 | fs2 = port_group_spec {fs=fs2;}
//			 | fs3= subcomponent_access {fs=fs3;}
//			 | fs4 = parameter  {fs=fs4;}
//			 | fs5 = server_subprogram {fs=fs5;}
//			 | fs6 = data_subprogram {fs=fs6;}
//			 )
//                { fs.setName(id.getText()); fs.setRefined(true); rt.addFeatureRefinement(fs); }
//				{ fs.setLocationReference(this.getFilename(),id.getLine());  }
//                {  fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	fs.setRefinedReference(fr);}
//		   )+ 
//		 | ( none_stmt ) 
//		 )
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 4.5 Subcomponents
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ category specific subcompoennts subclause to reflect acceptable categories
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//threadSubcomponents [ThreadImplementation ci]
//@init { ThreadSubcomponents ts = Aadl2F.createThreadSubcomponents(); processComments(ts);}:		 
//     SUBCOMPONENTS 
//                     {  ci.setSubcomponents(ts); }
//			( ( threadSubcomponent[ts] )+ 
//			| ( none_stmt ) )
//	;
			
//processorSubcomponents[ProcessorImplementation ci]
//@init { ProcessorSubcomponents ts = Aadl2F.createProcessorSubcomponents(); processComments(ts);}: 
//    SUBCOMPONENTS 
//                     {  ci.setSubcomponents(ts); }
//			( ( processorSubcomponent[ts] )+ 
//			| ( none_stmt ) )
//	;


//memorySubcomponents[MemoryImplementation ci]
//@init { MemorySubcomponents ts = Aadl2F.createMemorySubcomponents(); processComments(ts);}: 
//     SUBCOMPONENTS 
//                     {  ci.setSubcomponents(ts); }
//			( ( memorySubcomponent[ts] )+ 
//			| ( none_stmt ) )
//	;


//threadgroupSubcomponents[ThreadGroupImplementation ci]
//@init { ThreadGroupSubcomponents ts = Aadl2F.createThreadGroupSubcomponents(); processComments(ts);}: 
//     SUBCOMPONENTS 
//                     {  ci.setSubcomponents(ts); }
//			( ( threadgroupSubcomponent[ts] )+ 
//			| ( none_stmt ) )
//	;


//processSubcomponents[ProcessImplementation ci]
//@init { ProcessSubcomponents ts = Aadl2F.createProcessSubcomponents(); processComments(ts);}: 
//     SUBCOMPONENTS 
//                     {  ci.setSubcomponents(ts); }
//			( ( processSubcomponent[ts] )+ 
//			| ( none_stmt ) )
//	;


//systemSubcomponents[SystemImplementation ci]
//@init { SystemSubcomponents ts = Aadl2F.createSystemSubcomponents(); processComments(ts);}: 
//     SUBCOMPONENTS 
//                     {  ci.setSubcomponents(ts); }
//			( ( systemSubcomponent[ts] )+ 
//			| ( none_stmt ) )
//	;


//dataSubcomponents[DataImplementation ci]
//@init { DataSubcomponents ts = Aadl2F.createDataSubcomponents(); processComments(ts);}: 
//     SUBCOMPONENTS 
//                     {  ci.setSubcomponents(ts); }
//			( ( dataSubcomponent[ts] )+ 
//			| ( none_stmt ) )
//	;
	


		
			
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ category specific subcomponent declaration to reflect acceptable categories
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//threadSubcomponent [ThreadSubcomponents ts]
//@init {DataSubcomponent ds=null;
//RefinedReference fr =null;}:
//    id= IDENT 
//    COLON 
//        {ds = Aadl2F.createDataSubcomponent(); processComments(ds);}
//    ( REFINED TO 
//    	{  ds.setRefined(true);} 
//        {  fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//        	fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//        	ds.setRefinedReference(fr);}
//    )?
//    DATA 
//    subcomponent_decl[ds] 
//            {  ds.setName(id.getText()); ts.addDataSubcomponent(ds); }
//				{ ds.setLocationReference(this.getFilename(),id.getLine());  }
//    ;

//threadgroupSubcomponent [ThreadGroupSubcomponents ts]
//        @init {Subcomponent sc = null; RefinedReference fr = null;
//        	boolean refined = false;}:
//    id= IDENT COLON 
//    ( REFINED TO {  refined = true;} 
//    )?
//    ( DATA {sc = Aadl2F.createDataSubcomponent();processComments(sc);}
//     |
//      THREAD GROUP {sc = Aadl2F.createThreadGroupSubcomponent();processComments(sc);}
//     |
//      THREAD {sc = Aadl2F.createThreadSubcomponent();processComments(sc);}
//     )
//         {sc.setRefined(refined);}
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	sc.setRefinedReference(fr);}}
//    subcomponent_decl[sc] 
//            {  sc.setName(id.getText()); ts.addSubcomponent(sc); }
//				{ sc.setLocationReference(this.getFilename(),id.getLine());  }
//    ;

//dataSubcomponent [DataSubcomponents ts]
//        @init { boolean refined = false;
//        	RefinedReference fr=null;
//        	DataSubcomponent ds=null;}:
//    id= IDENT 
//    COLON 
//    ( REFINED TO {  refined = true;} )?
//    DATA { ds = Aadl2F.createDataSubcomponent();processComments(ds);}
//         {ds.setRefined(refined);}
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	ds.setRefinedReference(fr);}}
//    subcomponent_decl[ds] 
//                {  ds.setName(id.getText()); ts.addDataSubcomponent(ds); }
//				{ ds.setLocationReference(this.getFilename(),id.getLine());  }
//    ;


//processSubcomponent [ProcessSubcomponents ts]
//        @init {Subcomponent sc = null;boolean refined = false;
//        RefinedReference fr=null;}:
//    id= IDENT 
//    COLON 
//    ( REFINED TO {  refined = true;} )?
//    ( DATA {sc = Aadl2F.createDataSubcomponent(); processComments(sc);}
//     |
//      THREAD GROUP {sc = Aadl2F.createThreadGroupSubcomponent();processComments(sc);}
//     |
//      THREAD {sc = Aadl2F.createThreadSubcomponent();processComments(sc);}
//      )
//         {sc.setRefined(refined);}
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	sc.setRefinedReference(fr);}}
//    subcomponent_decl[sc] 
//                {  sc.setName(id.getText()); ts.addSubcomponent(sc); }
//				{ sc.setLocationReference(this.getFilename(),id.getLine());  }
//    ;


//processorSubcomponent [ProcessorSubcomponents ts]
//	@init { MemorySubcomponent ds=null;
//		boolean refined = false;RefinedReference fr=null;}:
//    id= IDENT 
//    COLON 
//    ( REFINED TO {  refined = true;} )?
//    MEMORY { ds = Aadl2F.createMemorySubcomponent();processComments(ds);}
//         {ds.setRefined(refined);}
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	ds.setRefinedReference(fr);}}
//    subcomponent_decl[ds] 
//                {  ds.setName(id.getText()); ts.addMemorySubcomponent(ds); }
//				{ ds.setLocationReference(this.getFilename(),id.getLine());  }
//    ;

//memorySubcomponent [MemorySubcomponents ts]
//	@init { MemorySubcomponent ds=null;
//		boolean refined = false;RefinedReference fr=null;}:
//    id= IDENT 
//    COLON 
//    ( REFINED TO {  refined = true;} )?
//    MEMORY { ds = Aadl2F.createMemorySubcomponent();processComments(ds);}
//         {ds.setRefined(refined);}
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	ds.setRefinedReference(fr);}}
//    subcomponent_decl[ds] 
//                {  ds.setName(id.getText()); ts.addMemorySubcomponent(ds); }
//				{ ds.setLocationReference(this.getFilename(),id.getLine());  }
//    ;

//systemSubcomponent [SystemSubcomponents ts]
//	@init { boolean refined = false;RefinedReference fr=null;
//        Subcomponent sc = null;}:
//    id= IDENT 
//    COLON 
//    ( REFINED TO {  refined = true;} )?
//    (
//    DATA {sc = Aadl2F.createDataSubcomponent(); processComments(sc);}
//    |
//    MEMORY {sc = Aadl2F.createMemorySubcomponent(); processComments(sc);}
//    |
//    PROCESSOR {sc = Aadl2F.createProcessorSubcomponent();processComments(sc);}
//    |
//    BUS {sc = Aadl2F.createBusSubcomponent();processComments(sc);}
//    |
//    DEVICE {sc = Aadl2F.createDeviceSubcomponent();processComments(sc);}
//    |
//    PROCESS { sc = Aadl2F.createProcessSubcomponent();processComments(sc);}
//    |
//    SYSTEM { sc = Aadl2F.createSystemSubcomponent();processComments(sc);}
//    )
//         {sc.setRefined(refined);}
//                { if (refined){ fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//           			fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//                	sc.setRefinedReference(fr);}}
//    subcomponent_decl[sc] 
//                {  sc.setName(id.getText()); ts.addSubcomponent(sc); }
//				{ sc.setLocationReference(this.getFilename(),id.getLine());  }
//    ;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ common part of subcomponent declaration
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//subcomponent_decl[Subcomponent sc] 
//		@init {
//			//ClassifierReference cr;
//			//Properties ps;
//		}:
//	( cr = classifier_reference  
//			{ sc.setClassifierReference(cr);}
//	)?
////	(ps = containedCurlyPropertyAssociations {sc.setProperties(ps);})?
//	 (in_modes[sc])? SEMI ;




//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 4.6 Annex Subclasses
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

// **** set up gammar to let everything but **} through

annex_library returns [AnnexLibrary al]
/*options {defaultErrorHandler=true;}*/
	@init {
		al = null;
		Vector cmt = null;
	}:
    ANNEX id=IDENT
		{
			cmt = getComments();
		}
	at = ANNEX_TEXT 
		{ 
			String annexName = id.getText();
			String annexText = at.getText();
			if (annexText.length() > 6) {
		        annexText = annexText.substring(3, annexText.length() - 3);
			}
			AnnexParserRegistry registry = (AnnexParserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID);
			AnnexParser ap = registry.getAnnexParser(annexName);
			al = ap.parseAnnexLibrary(id.getText(), annexText, getFilename(), at.getLine(), at.getCharPositionInLine() + 3, errReporter);
			al.setName(id.getText());
			al.setLocationReference(this.getFilename(), id.getLine());
			attachComments(al, cmt);
	   }
	SEMI;

annex_subclause returns [AnnexSubclause as ]
/*options {defaultErrorHandler=true;}*/
	@init {
		as = null;
		Vector cmt = null;
	}: 
    ANNEX id=IDENT
		{
			cmt = getComments();
		}
	at = ANNEX_TEXT
		{ 
			String annexName = id.getText();
			String annexText = at.getText();
			if (annexText.length() > 6 ){
		        annexText = annexText.substring(3, annexText.length() - 3);
			}
			AnnexParserRegistry registry = (AnnexParserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID);
			AnnexParser ap = registry.getAnnexParser(annexName);
			as = ap.parseAnnexSubclause(id.getText(), annexText, getFilename(), at.getLine(), at.getCharPositionInLine() + 3, errReporter);
			as.setName(id.getText());
			as.setLocationReference(this.getFilename(), id.getLine());
			attachComments(as, cmt);
		}
	SEMI ;


 
 


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 5 PROPERTIES
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 5.1 Property Sets
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

// We must support multiple property type, name, and constant definitions in one declaration
// This is done through the list of defining identifiers
// A pain in the neck to process. We must first construct the whole thing, then dupliate it.
// The addition of the items into the propertyset is subclass specific, thus, ps and the list of identifeir strings are passed in as paramters

// Standalone property set in a separate file
//propertyset_file [Resource r, Set packagesToDo, Set propertySetsToDo] returns [AadlSpecification as]
//		/*options {defaultErrorHandler=true;}*/
//		@init {
//		as=Aadl2F.createAadlSpecification();
//		PropertySet ps=PF.createPropertySet();
//			String ps_name = null;
//			String ps_end_name = null;
//		as.addPropertySet(ps);
//		if (r != null) {
//			r.getContents().add(as);
//		}
//		} 
//:
//	PROPERTY SET ps_id=IDENT IS
//	{
//		ps_name = ps_id.getText();
//		ps.setName(ps_name);
//		definedPropertySets.add(ps_name);
//		ps.setLocationReference(this.getFilename(), ps_id.getLine());
//		processComments(ps);
//	}
//	(   
//		id= IDENT COLON
//		{
//			if (ps.findPropertySetElement(id.getText()) != null ) {
//				errReporter.warning(new LocationReference(this.getFilename(), id.getLine()), "Duplicate property set entry");
//			}
//		}
//		(
//			property_constant[ps, id] 
//			| property_type_declaration[ps, id] 
//			| property_name_declaration[ps, id]
//		)
//	)+
//	END ps_id2=IDENT SEMI
//	{
//		ps_end_name = ps_id2.getText();
//		if (!(ps_end_name.equalsIgnoreCase(ps_name))) {
//			//throw new SemanticException("Property set name '" + ps_name + "' does not match end identifier '" + ps_end_name+"'", 
//			throw new FailedPredicateException(input,"property set file","Property set name '" + ps_name + "' does not match end identifier '" + ps_end_name+"'");
//		}
//		processComments(ps);
//	}
//	EOF
//	{
////		System.out.println("Referenced Packages: ");
////		for (Iterator i = referencedPackages.iterator(); i.hasNext();) {
////			System.out.println("\t" + (String)i.next());
////		}
////		System.out.println("\nDefined Packages: ");
////		for (Iterator i = definedPackages.iterator(); i.hasNext();) {
////			System.out.println("\t" + (String)i.next());
////		}
////		System.out.println("\nReferenced Property Sets: ");
////		for (Iterator i = referencedPropertySets.iterator(); i.hasNext();) {
////			System.out.println("\t" + (String)i.next());
////		}
////		System.out.println("\nDefined Property Sets: ");
////		for (Iterator i = definedPropertySets.iterator(); i.hasNext();) {
////			System.out.println("\t" + (String)i.next());
////		}
//		setToDo(packagesToDo, propertySetsToDo);
//		
//	}
//;

property_set [GlobalNamespace gns, Resource r]
	@init{
		PropertySet ps=null;
	}
	:
	PROPERTY SET psid1=IDENT IS
		{
			ps = Aadl2F.createPropertySet();
			ps.setName(psid1.getText());
			ps.setLocationReference(this.getFilename(),psid1.getLine());
		}
	(WITH 
		(opsid=IDENT
			{
				ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.WithStatementReference,
				                                          ps,
				                                          new String[]{opsid.getText()});
        unresolvedReferences.add(rr);				                                          
			}
			(COMMA opsid1=IDENT
				{
          ReferenceRecord rr1 = new ReferenceRecord(ParserReferenceType.WithStatementReference,
                                                  ps,
                                                  new String[]{opsid1.getText()});
          unresolvedReferences.add(rr1);                                                 
				}			
			)*
		)+
	SEMI
	)*
	(
		pt=property_type_declaration
			{
				if (ps.findNamedElement(pt.getName()) != null ) {
					errReporter.error(new LocationReference(this.getFilename(), pt.getLocationReference().getLine()), "Duplicate property set entry");
				}
				ps.getOwnedPropertyTypes().add(pt);
			}
		|
		pd=property_definition_declaration
			{
				ps.getOwnedProperties().add(pd);
			}
		|
		pc=property_constant
			{
				ps.getOwnedPropertyConstants().add(pc);
			}
	)*
	END psid2=IDENT SEMI
	{
		if (!(psid2.getText().equalsIgnoreCase(psid1.getText()))) {
			throw new FailedPredicateException(input,"property set","Property set name '" + psid1.getText() + "' does not match end identifier '" + psid2.getText()+"'");
		}
		processComments(ps);
		r.getContents().add(ps); 
		//gns.getPropertySets().add(ps);
	}
	;
		catch [RecognitionException ex] {
			reportError(ex);
			consumeUntil(input,END);
			consumeUntil(input,SEMI);
			input.consume();
        }

property_definition_declaration returns [Property p]
  @init{
    boolean inherit=false;
  }
  :
  id=IDENT COLON
  (INHERIT
    {
      inherit=true;
    }
  )?
    {
      p = Aadl2F.createProperty();
      p.setInherit(inherit);
      p.setName(id.getText());
      p.setLocationReference(this.getFilename(),id.getLine());
    }
  ( LIST OF {
      p.setList(p.getList() + 1);
    }
  )*
  (nr= unique_property_type_identifier
    {
      nr.setReferencingObject(p);
      nr.setReferenceType(ParserReferenceType.PropertyValuePropertyTypeReference);
      unresolvedReferences.add(nr);
    }
   |pt = property_type
    {
      p.setOwnedType(pt);
    }
  )
  ( ASSIGN
    ce=property_expression[p]
      {
        if (ce != null)
          p.setDefaultValue(ce);
      }
  )?
  APPLIES TO LPAREN
  ( (po=property_owner
    {
      p.getAppliesTos().add(po);
    } 
    ( COMMA po1=property_owner
      {
        p.getAppliesTos().add(po1);
      }
    )*
  )
  | (a=ALL 
  	{
  	   MetaclassReference mrf = Aadl2F.createMetaclassReference();
  	   mrf.setLocationReference(this.getFilename(), a.getLine());
  	   mrf.getMetaclassNames().add("named");
       mrf.getMetaclassNames().add("element");
       p.getAppliesTos().add(mrf);
  	}
    )
  )
  RPAREN SEMI
  ;

property_owner returns [PropertyOwner po]
  @init{
  }
  :
 (
  (unique_impl_name) => ui = unique_impl_name
    {
    //XXX: Location
      po = Aadl2F.createClassifierValue();
      ui.setReferencingObject(po);
      ui.setReferenceType(ParserReferenceType.ClassifierValueComponentImplementationReference);
      unresolvedReferences.add(ui);
    }
  |mi=qualified_meta_model_identifier
      {
        po = mi;
      //TODO: separate in proper metaclass fields
      //s = mi.getAnnexName()+" "+mi.getMetaclassName();
      }
  |un=unique_type_name
    {
    //XXX: Location
      po = Aadl2F.createClassifierValue();
      un.setReferencingObject(po);
      un.setReferenceType(ParserReferenceType.ClassifierValueComponentTypeReference);
      unresolvedReferences.add(un);
      //classifier reference
      // TODO: separate in proper metaclass fields
      //s = un.getPackageName()+"::"+un.getClassifierName();
    }
   ) 
  ;
    
property_type_declaration returns [PropertyType pt]
	@init{
	}
	:
	id=IDENT COLON TYPE
	ptt=property_type
		{
			pt=ptt;
			pt.setName(id.getText());
			pt.setLocationReference(this.getFilename(),id.getLine());
			processComments(pt);
		}
	SEMI
	;
		catch [RecognitionException ex] {
			reportError(ex);
			consumeUntil(input,END);
			consumeUntil(input,SEMI);
			input.consume();
        }
	
	
//property_set [GlobalNamespace gns, Resource r, ArrayList<Namespace> nameSpaces]
//	@init{
//	}
//	:
//	PROPERTY SET psid1=IDENT IS
//		{
//			PropertySet ps = Aadl2F.createPropertySet();
//			ps.setName(psid1.getText());
//			ps.setLocationReference(this.getFilename(),psid1.getLine());
//		}
//	(WITH 
//		(opsid=IDENT
//			{
//				//pending
//			}
//		)+
//	)?
//	(id= IDENT COLON
//		{
//			if (ps.getNamedElement(id.getText()) != null ) {
//				errReporter.warning(new LocationReference(this.getFilename(), id.getLine()), "Duplicate property set entry");
//			}
//		}
//		(
//			//property_constant[ps, id] 
//			//| 
//			property_type_declaration[ps, id] 
//			//| property_name_declaration[ps, id]
//		)
//	)+
//	END psid2=IDENT SEMI
//	{
//		if (!(psid2.getText().equalsIgnoreCase(psid1.getText()))) {
//			throw new FailedPredicateException(input,"property set","Property set name '" + psid1.getText() + "' does not match end identifier '" + psid2.getText()+"'");
//		}
//		processComments(ps);
//		gns.getPropertySets().add(ps);
//	}
//	;
//		catch [RecognitionException ex] {
//			reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


// Nested property set inside an Aadl specification
//property_set returns [PropertySet ps]
//		/*options {defaultErrorHandler=true;}*/
//		@init {
//			ps=PF.createPropertySet();
//			String ps_name = null;
//			String ps_end_name = null;
//		}
//:
//	PROPERTY SET ps_id= IDENT IS
//	{
//		ps_name = ps_id.getText();
//		ps.setName(ps_name);
//		definedPropertySets.add(ps_name);
//		ps.setLocationReference(this.getFilename(), ps_id.getLine());
//		processComments(ps);
//	}
//	(   
//		id= IDENT COLON
//		{
//			if (ps.findPropertySetElement(id.getText()) != null ) {
//				errReporter.warning(new LocationReference(this.getFilename(), id.getLine()), "Duplicate property set entry");
//			}
//		}
//		(
//			property_constant[ps, id] 
//			| property_type_declaration[ps, id] 
//			| property_name_declaration[ps, id]
//		)
//	)+
//	END ps_id2=IDENT SEMI
//	{
//		ps_end_name = ps_id2.getText();
//		if (!(ps_end_name.equalsIgnoreCase(ps_name))) {
//			//throw new SemanticException("Property set name '" + ps_name + "' does not match end identifier '" + ps_end_name+"'", 
//			throw new FailedPredicateException(input,"property set","Property set name '" + ps_name + "' does not match end identifier '" + ps_end_name+"'");
//		}
//		processComments(ps);
//	};
//		catch [RecognitionException ex] {
//			reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 5.1.1 Property Types
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

// Property type can be named, i.e., defined with a list of identifiers.
// this means they must be replicated.
// They can also be declared as unnamed types as part of property name declarations.
// In that case they are a single instance with no name. Thus, two rules for every property type.

// ParsedPropertyReference object is used to hold the parsed idendieirs. 
// This is used for references to other properties, from property associaitons to property names,
// references to units literals, and enumeration literals. The objects are processed by the name resolver.

//property_type_declaration [PropertySet ps,Token il] 
/////*options {defaultErrorHandler=true;}*/
//	:
//    TYPE 
//    property_type[ps,il] 
//    SEMI
//////-------------------------------------------------------------------
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//property_type [PropertySet ps, Token il]:
property_type returns [PropertyType pt]
	:
    	bt = boolean_type
    		{
    			pt = bt;	
	    	}
	| st=string_type
    		{
    			pt = st;
	    	}
	| et = enumeration_type
		{
			pt = et;
		} 
	| ut = units_type
		{
			pt = ut;
		}
	| rt = real_type
		{
			pt = rt;
		} 
	| it = integer_type
		{
			pt = it;
		} 
	| gt = range_type
		{
			pt = gt;
		}
	| ct = classifier_type
		{
			pt = ct;
		}
	| ft = reference_type
		{
			pt =ft;
		}
	| dt = record_type
		{
			pt = dt;
		}
//    | cpt = component_property_type[id]
//    	{
//    		pt = cpt;
//    	}
;
////-------------------------------------------------------------------

record_type returns [RecordType rt]
	@init{
	}
	:
	r=RECORD LPAREN rf = record_field
		{
			rt = Aadl2F.createRecordType();
			rt.setLocationReference(this.getFilename(), r.getLine());
			rt.getOwnedFields().add(rf);
		}
		(rf1 = record_field
			{
				rt.getOwnedFields().add(rf1);				
			}
		)*
	RPAREN
	;

record_field returns [RecordField rf]
	@init{
	 String ps ="";
	}
	:
	id=IDENT COLON
		{
			rf=Aadl2F.createRecordField();
			rf.setName(id.getText());
			rf.setLocationReference(this.getFilename(),id.getLine());
		}
	(LIST OF
		{
			rf.setList(rf.getList() + 1);
		}
	)*
	(pt=property_type
		{
			rf.setOwnedType(pt);
			//rf.setPropertyType(pt);
		}
	|( ptid = IDENT DOUBLECOLON
		{
		  ps=ptid.getText();
		}
		)?
		(ptid1 = IDENT
			{
			   ReferenceRecord rr = null;
			   if (ps.length() > 0) {
			     rr = new ReferenceRecord(ParserReferenceType.PropertyTypeReference,rf,new String[]{ps,ptid1.getText()});
			   } else {
           rr = new ReferenceRecord(ParserReferenceType.PropertyTypeReference,rf,new String[]{ptid1.getText()});
			   }
			  unresolvedReferences.add(rr);
			}
		)
	)
	SEMI
	;
	
	
reference_type returns [ReferenceType rt]
	@init{
	}
	:
	r=REFERENCE 
		{
			rt = Aadl2F.createReferenceType();
			rt.setLocationReference(this.getFilename(), r.getLine());
		}
	(LPAREN mcr = qualified_meta_model_identifier
		{
			rt.getNamedElementReferences().add(mcr);
		}
		(COMMA mcr1 = qualified_meta_model_identifier
			{
				rt.getNamedElementReferences().add(mcr1);
			}
		)*
	RPAREN
	)? 
	;

unnamed_property_type returns [PropertyType pt]
	@init{
		pt=null;
	}:
    (
    ppt1 = unnamed_boolean_type {pt=ppt1;}
    | ppt2 = unnamed_string_type {pt=ppt2;}
	| ppt3 = unnamed_enumeration_type {pt=ppt3;}
	| ppt4 = unnamed_units_type {pt=ppt4;}
	| ppt5 = unnamed_real_type {pt=ppt5;}
	| ppt6 = unnamed_integer_type {pt=ppt6;} 
	| ppt7 = unnamed_range_type {pt=ppt7;}
	| ppt8 = unnamed_classifier_type {pt=ppt8;}
//  | ppt9 = unnamed_component_property_type {pt=ppt9;}
    )
	;
//-------------------------------------------------------------------

unnamed_boolean_type  returns [AadlBoolean ab]
	@init{
	 	ab=Aadl2F.createAadlBoolean();
	}
	:
    b=BOOLEAN  
    	{ 
    		processComments(ab);
    		ab.setLocationReference(this.getFilename(), b.getLine());
    	}
   ;

boolean_type returns [AadlBoolean ab]
	@init {
	}
	:
    b=BOOLEAN 
     	{ 
      		ab = Aadl2F.createAadlBoolean();
      		ab.setLocationReference(this.getFilename(), b.getLine());
      	}
   ;

string_type  returns [AadlString pt]
	@init {
	}
	:
	s=STRING 
    	{  
    		pt = Aadl2F.createAadlString();
    		pt.setLocationReference(this.getFilename(), s.getLine());
		}
   ;
   
unnamed_string_type  returns [AadlString ab]
	@init{
		ab=Aadl2F.createAadlString();
	}
	:
    s=STRING  
    	{
    		processComments(ab);
    		ab.setLocationReference(this.getFilename(), s.getLine());
    	}
   ;
   
enumeration_type returns [EnumerationType et]
	@init { 
	}
	:
	ett = unnamed_enumeration_type
		{
			et = ett;  
		}
;

unnamed_enumeration_type returns [EnumerationType et ]
	@init { 
		EnumerationLiteral el=null; 
	}
	:
	e=ENUMERATION
	LPAREN 
	lit= IDENT  
		{ 
			et = Aadl2F.createEnumerationType();
			et.setLocationReference(this.getFilename(), e.getLine());
			el = Aadl2F.createEnumerationLiteral();
	      	el.setName(lit.getText());
	      	el.setLocationReference(this.getFilename(),lit.getLine());
	      	et.getOwnedLiterals().add(el);
	    }
	( COMMA morelit=IDENT 
	    {
	    	el = Aadl2F.createEnumerationLiteral();
	      	el.setName(morelit.getText());
	      	el.setLocationReference(this.getFilename(), morelit.getLine());
	      	et.getOwnedLiterals().add(el); 
	     }
	)* 
	RPAREN 
	;
	  
//-------------------------------------------------------------------

units_type returns [UnitsType ut]
	@init { 
	}
	:
    u=UNITS
    	{
 			ut = Aadl2F.createUnitsType();
 			ut.setLocationReference(this.getFilename(), u.getLine());
    	} 
    units_list[ut]
	;

unnamed_units_type returns [UnitsType ut]
	@init{
		ut=Aadl2F.createUnitsType();
	}
	:
	u=UNITS units_list[ut]
	{
		ut.setLocationReference(this.getFilename(), u.getLine());
	}
	;

units_list [UnitsType ut]
	@init {
		UnitLiteral el=null; 
		//NumberValue nv = null;
	}
	:
    LPAREN 
    lit=IDENT
		{ 
			el = Aadl2F.createUnitLiteral();
		      	el.setName(lit.getText());
		      	el.setLocationReference(this.getFilename(), lit.getLine());
		      	ut.getOwnedLiterals().add(el);

		}
	(COMMA morelit= IDENT 
		{
			el = Aadl2F.createUnitLiteral();
	      	el.setName(morelit.getText());
	      	el.setLocationReference(this.getFilename(), morelit.getLine()); 
	      	ut.getOwnedLiterals().add(el);
	    }
	 ASSIGN unitid = IDENT 
	 STAR nv = number_value  
	 	{ 
	 		ut.getOwnedLiterals().add(el);
	 		el.setFactor(nv);
	 		ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.BaseUnitIdentifierReference, 
	 		                                                            el, 
	 		                                                            new String[]{unitid.getText()});
      unresolvedReferences.add(rr);	 		                                                        
		}
	)* 
	RPAREN
;
//-------------------------------------------------------------------


real_type returns [AadlReal ar]
	@init { 
	}
	:
	arr = unnamed_real_type
		{
			ar = arr;
		}
	;    

unnamed_real_type returns [AadlReal ar]
	@init { 
		//ParsedPropertyReference ppr = null; 
		UnitsType ut = null;
	}
	:
    (r=REAL 
    	{
			ar= Aadl2F.createAadlReal();
			ar.setLocationReference(this.getFilename(),r.getLine());
    	}
    )

    ( 
    	real_range[ar] 
    )?   
    ( u=UNITS 
      	(ppr = unique_property_type_identifier
	    	{ 
	    	  ppr.setReferencingObject(ar);
	    	  ppr.setReferenceType(ParserReferenceType.PropertyUnitsTypeReference);
	    	  unresolvedReferences.add(ppr);
	    	}
       	| 
       		{ 
       			ut = Aadl2F.createUnitsType(); 
       			ut.setLocationReference(this.getFilename(), u.getLine());
       			ar.setOwnedUnitsType(ut);
       		}
         	units_list[ut] 
      	)
     )?
	;    

integer_type returns [AadlInteger ai]
	:
	aii = unnamed_integer_type
		{  
			ai=aii;
		}
	;    

unnamed_integer_type returns [AadlInteger ai]
	@init { 
		//ParsedPropertyReference ppr = null;
		UnitsType ut= null;
	}
	:
	(i=INTEGER 
		{ 
			ai= Aadl2F.createAadlInteger();
			ai.setLocationReference(this.getFilename(), i.getLine()); 
		}
	)
	(integer_range[ai] 
	)? 
	( u=UNITS 
		(ppr =  unique_property_type_identifier
	    	{
	    	  ppr.setReferencingObject(ai);
	    	  ppr.setReferenceType(ParserReferenceType.PropertyUnitsTypeReference); 
	    	  unresolvedReferences.add(ppr);
	    	}
	    | 
	    	{ 
	    		ut = Aadl2F.createUnitsType(); 
	    		ut.setLocationReference(this.getFilename(), u.getLine());
	    		ai.setOwnedUnitsType(ut);
	    	}
	    	units_list[ut] 
	  	)
	)?
	;

// For these next rules we know that we have only reals or only integers due to a preceding reserverd word
// We also know that any identiifier is a reference to a property constant of the appropriate type.
// Those references are recorded as ParsedPropertyReferences with the RealValue and IntegerValue instead of the generic reference class

real_range [AadlReal ar]
  @init { 
    String lbsign="";
    String ubsign="";
    NumericRange nr = null;
  }
	:

	(nv = signed_aadlreal
		{
		  nr = Aadl2F.createNumericRange();
			nr.setLowerBound(nv);
			ar.setRange(nr);
		}
	 | (
	 	(PLUS
	 		{
	 		  lbsign="+";
	 		}
	 	 | MINUS
	 	 	{
	 	 	 lbsign = "-";
	 	 	}
		)?
		cr = property_name_constant_reference
			{
        nr = Aadl2F.createNumericRange();
        ar.setRange(nr);
			  if (lbsign.length() > 0){
			   String [] labels = cr.getLabels();
			   String [] nlabels = new String [labels.length+1];
			   nlabels[0] = lbsign;
			   for (int i=0;i<labels.length;i++)
			     nlabels[i+1] = labels[i];
			   cr.setLabels(nlabels);
			  }
			  cr.setReferencingObject(nr);
			  cr.setReferenceType(ParserReferenceType.RealRangeLowerBoundConstantReference);
			  unresolvedReferences.add(cr);
			}
	 )
	)
//    nv=signed_aadlreal_or_constant
//    	{ 	
//    		ar.setLowerBound(nv);
//    	}
    d=DOTDOT
    {
    	nr.setLocationReference(this.getFilename(), d.getLine());
    } 
	(nv = signed_aadlreal
		{
		  if (nr != null){
			 nr.setUpperBound(nv);
		 }
		}
	 | (
	 	(PLUS
	 		{
	 		  ubsign="+";
	 		}
	 	 | MINUS
	 	 	{
	 	 	 ubsign="-";
	 	 	}
		)?
		cr = property_name_constant_reference
			{
        if (ubsign.length() > 0){
         String [] labels = cr.getLabels();
         String [] nlabels = new String [labels.length+1];
         nlabels[0] = ubsign;
         for (int i=0;i<labels.length;i++)
           nlabels[i+1] = labels[i];
         cr.setLabels(nlabels);
        }
        cr.setReferencingObject(nr);
        cr.setReferenceType(ParserReferenceType.RealRangeUpperBoundConstantReference);
        unresolvedReferences.add(cr);
			}
	 )
	)
//    nv = signed_aadlreal_or_constant
//    	{
//    		ar.setUpperBound(nv);
//    	}
	;
//-------------------------------------------------------------------

integer_range [AadlInteger ai]
	@init { 
	   String lbsign="";
	   String ubsign="";
	   NumericRange nr= null;
	}
	:
	(	(bound =  signed_aadlinteger
			{ 
			   nr = Aadl2F.createNumericRange();
				 nr.setLowerBound(bound);
				 ai.setRange(nr);
			}
		)
		|
		(
		 	(PLUS
	 			{
	 				lbsign="+";
		 		}
		 	 | MINUS
	 		 	{
	 	 			lbsign="-";
		 	 	}
			)?
		cr = property_name_constant_reference
			{
        nr = Aadl2F.createNumericRange();
        ai.setRange(nr);
        if (lbsign.length() > 0){
         String [] labels = cr.getLabels();
         String [] nlabels = new String [labels.length+1];
         nlabels[0] = lbsign;
         for (int i=0;i<labels.length;i++)
           nlabels[i+1] = labels[i];
         cr.setLabels(nlabels);
        }
			  cr.setReferencingObject(nr);
			  cr.setReferenceType(ParserReferenceType.IntegerRangeLowerBoundConstantReference);
			  unresolvedReferences.add(cr);
			}
		 )
	 )
	d=DOTDOT
	{
		nr.setLocationReference(this.getFilename(), d.getLine());
	} 
	(	(bound =  signed_aadlinteger
			{
			 if (nr != null){ 
			   	nr.setUpperBound(bound);
				}
			}
		)
		|
		(
		 	(PLUS
	 			{
	 				ubsign="+";
		 		}
		 	 | MINUS
	 		 	{
	 	 			ubsign="-";
		 	 	}
			)?
		cr = property_name_constant_reference
			{
				if (ubsign.length() > 0){
         String [] labels = cr.getLabels();
         String [] nlabels = new String [labels.length+1];
         nlabels[0] = ubsign;
         for (int i=0;i<labels.length;i++)
           nlabels[i+1] = labels[i];
         cr.setLabels(nlabels);
        }
        cr.setReferencingObject(nr);
        cr.setReferenceType(ParserReferenceType.IntegerRangeUpperBoundConstantReference);
        unresolvedReferences.add(cr);
			}
		 )
	)
	;

// real literal with an optional sign and unit
signed_aadlreal returns [RealLiteral cv]
	@init { 
		cv=Aadl2F.createRealLiteral();
		char sign = ' '; 
		//Token numericval;
	}
	:
	(PLUS 
		{
			sign = '+';
		}
	| MINUS 
		{
			sign = '-';
		} 
	)?  
	( numericval = real_literal   
    { 
      cv.setValueString(sign == ' '?numericval.getText():sign+numericval.getText());
	  	cv.setValue(sign == '-' ? -1.0 * Double.parseDouble(numericval.getText()): Double.parseDouble(numericval.getText()));
			cv.setLocationReference(this.getFilename(), numericval.getLine()); 
		}
  )
    // optional unit
    ( ui=IDENT 
    	{
    	   ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.PropertyUnitLiteralReference,
    	                                                               cv,
    	                                                               new String[]{ui.getText()});
        unresolvedReferences.add(rr);    	                                                                
    	}
    )?
    ;


// real literal with optional sign, named reference with or without sign
// Note that here we know that an identifier is referring to a real
//signed_aadlreal_or_constant returns [ NumberValue nv ] //[AadlReal ar] //returns [NumberOrPropertyReference cv]
//	@init {  
//		//NumberOrPropertyReference sr = null;
//		nv=null;
//		String sign ="";
//   	}
//   :
//   sr = signed_aadlreal 
//   		{
//   			nv = sr;
//   		}
//   |
//   (
//	(PLUS 
//		{
//			sign = "+";
//		}
//	| MINUS 
//		{
//			sign = "-";
//		} 
//        )? 
//        cr = property_name_constant_reference 
//	    	{ 
//	    		nv = Aadl2F.createRealLiteral();
//	  		nv.setConstantReference(cr);
//	  		nv.setValueString(sign+cr.getContextName()+"::"+cr.getElementName());
//	    	}
//	)
//	;

// HERE HERE -- I was modifying this (separate signed constant from
// signed literal)	

//signed_property_constant returns [PropertyReference pr]
//	@init{
//		String sign = null;
//	}
//	:
//	(PLUS
//		{
//			sign = "+";
//		}
//	| MINUS
//		{
//			sign = "-";
//		}
//	)?
//	cr = property_name_constant_reference
//		{
//			// TODO: (Dio) uncomment and modify
//			//cr.setReferenceSign(sign);
//		}
//	;	

// integer literal with optional sign and unit
signed_aadlinteger returns [IntegerLiteral cv]
	@init { 
		cv=Aadl2F.createIntegerLiteral();
		char sign = ' '; 
		//Token numericval; 
	}
  	:
  	(PLUS 
  		{
  			sign = '+';
  		}
	| MINUS 
		{
			sign = '-';
		} 
    )?  
   (numericval = integer_literal 
   	{ 
   		cv.setValue((sign == ' ' || sign=='+')?numericval.getText():sign+numericval.getText());
   		cv.setValueString(sign == ' '?numericval.getText():sign+numericval.getText());
	    cv.setLocationReference(this.getFilename(), numericval.getLine()); 
	   }
    )
    // optional unit
    ( ui=IDENT 
    	{ 
    	  ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.PropertyUnitLiteralReference,
    	                                                             cv,
    	                                                             new String[]{ui.getText()});
        unresolvedReferences.add(rr);    	                                                             
    	}
    )?
    ;

//// integer literal with optional sign and unit, named reference with or without sign
//// Note that here we know that an identifier is referring to a integer
//signed_aadlinteger_or_constant returns [IntegerLiteral cv]//[NumberOrPropertyReference cv]
//	@init { 
//		//NumberOrPropertyReference si=null;
//		cv=null;
//		String sign = "";
//	}
//	:
//	si1 = signed_aadlinteger 
//		{
//			cv=si1;
//		}
//	| 
//	(
//		(PLUS 
//			{
//				sign = "+";
//			}
//		| MINUS 
//			{
//				sign = "-";
//			} 
//		)? 
//	si = property_name_constant_reference 
//	  	{ 
//	  		cv = Aadl2F.createIntegerLiteral();
//	  		if (sign.length() >0){
//	  		   String [] labels = si.getLabels();
//	  		   String [] nlabels = new String[labels.length+1];
//	  		   nlabels[0] = sign;
//	  		   for (int i=0; i<labels.length;i++)
//	  		       nlabels[i+1] = labels[i];
//	  		   si.setLabels(nlabels);
//	  		}
//	  		si.setReferencingObject(cv);
//	  		si.setReferenceType(ParserReferenceType.PropertyConstantReference);
//	  		unresolvedReferences.add(si);
//	    	}
//    )
//	;	


// numeric literal with optional sign and unit
 signed_aadlnumeric returns [NumberValue cv]
	@init { 
		cv=null;
		char sign = ' '; 
	}
	:
	(PLUS 
		{
			sign = '+';
		}
	| MINUS 
		{
			sign = '-';
		} 
	)?
	(
		(realval=REAL_LIT
			{
				cv = Aadl2F.createRealLiteral();
				String str = realval.getText();
				cv.setValueString(sign == ' '? str:sign+str);
				cv.setLocationReference(this.getFilename(),realval.getLine());
			}
		)
		|
		(integerval= INTEGER_LIT
			{
				cv = Aadl2F.createIntegerLiteral();
				String str = integerval.getText();
				cv.setValueString(sign == ' '? str:sign+str);
				cv.setLocationReference(this.getFilename(),integerval.getLine());
			}
		)
	)  
//   	( numericval= NUMERIC_LIT 
//		{ 
//			String str = numericval.getText();
//			if ( str.indexOf('.') == -1 ) 
//				cv =Aadl2F.createIntegerLiteral();
//	        else
//				cv =Aadl2F.createRealLiteral();
//       		cv.setValueString(sign == ' '?str:sign+str); 
//			cv.setLocationReference(this.getFilename(), numericval.getLine()); 
//		}
//	)
   // optional unit
	( ui=IDENT 
		{
		  ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.PropertyUnitLiteralReference, 
		                                                              cv, 
		                                                              new String[]{ui.getText()});
      unresolvedReferences.add(rr);		                                                               
		}
	)?
	;



// numeric literal without optional sign and unit
number_value returns [NumberValue cv]
	@init { 
		cv=null;
		char sign = ' '; 
	}
	:
	(
		(realval=REAL_LIT
			{
				String str = realval.getText();
				cv = Aadl2F.createRealLiteral();
				cv.setValueString(sign==' '?str:sign+str);
				cv.setValue(cv.getValueString());
				cv.setLocationReference(this.getFilename(),realval.getLine());
			}
		)
		|
		(integerval=INTEGER_LIT
			{
				String str = integerval.getText();
				cv = Aadl2F.createIntegerLiteral();
				cv.setValueString(sign==' '?str:sign+str);
				cv.setValue(cv.getValueString());
				cv.setLocationReference(this.getFilename(),integerval.getLine());
			}
		)
	)	
//	(numericval= NUMERIC_LIT 
//		{ 
//			String str = numericval.getText();
//			if ( str.indexOf('.') == -1 ) 
//	         	cv =Aadl2F.createIntegerLiteral();
//			else
//	         	cv =Aadl2F.createRealLiteral();
//       	
//			cv.setValueString(sign == ' '?str:sign+str); 
//			cv.setLocationReference(this.getFilename(), numericval.getLine()); 
//		}
//	)
	;

// real literal with optional sign, named reference with or without sign
// Note that here we know that an identifier is referring to a real
//signed_aadlnumeric_or_constant returns [NumberOrPropertyReference cv]
//	@init { 
//		cv=null;
//		//ParsedPropertyReference ppr = null; 
//		String sign =null;
//		//NumberOrPropertyReference sn=null;
//	}
//	:
//	sn1 = signed_aadlnumeric 
//		{
//			cv=sn1;
//		}
//	|
//	(
//		( PLUS 
//			{
//				sign = "+";
//			}
//		| MINUS 
//			{
//				sign = "-";
//			} 
//		)? 
//	sn = property_name_constant_reference 
//		{ 
//			cv=sn;
//			if(sign != null) 
//				((PropertyReference)cv).setReferenceSign(sign);
//		}
//	)
//	;


// real literal with optional sign, named reference with or without sign
// Note that here we know that an identifier is referring to a real
signed_aadlnumeric_or_signed_constant returns [PropertyValue cv]
	@init { 
		cv=null;
		//ParsedPropertyReference ppr = null; 
		String sign =null;
		//NumberOrPropertyReference sn=null;
	}
	:
	sn1 = signed_aadlnumeric 
		{
			cv=sn1;
		}
	|
	(
		( PLUS 
			{
				sign = "+";
			}
		| MINUS 
			{
				sign = "-";
			} 
		) 
	sn = property_name_constant_reference 
		{ 
			// TODO: wait for Lutz to fix the ranges in property types
//			cv=sn;
//			if(sign != null) 
//				((PropertyReference)cv).setPropertyReferenceSign(sign);
		}
	)
	;


// note that in case of the range type any name references in the range are created in terms of Real or Integer objects with a ParsedProeprtyReference    
unnamed_range_type  returns[ RangeType rt ]
	@init { 
		rt = Aadl2F.createRangeType();
		//ParsedPropertyReference ppr = null; 
		//Aadlreal urt = null;
		//Aadlinteger uit = null;
	}
	:
	r=RANGE OF 
	( urt = unnamed_real_type 
		{ 
			rt.setOwnedNumberType(urt);
		}
	| uit = unnamed_integer_type 
		{ 
			rt.setOwnedNumberType(uit);
		}
	| ppr = unique_property_type_identifier 
		{ 
		  ppr.setReferencingObject(rt);
		  ppr.setReferenceType(ParserReferenceType.RangeTypePropertyTypeReference);
		  unresolvedReferences.add(ppr);
		}
	)
		{
			rt.setLocationReference(this.getFilename(), r.getLine());
		}
	;

range_type returns [RangeType rt]
	@init {
		//RangeType rt = PF.createRangeType();
	}
	:
	rt1 = unnamed_range_type
		{ 
			rt = rt1;			
		}
	;



//unnamed_classifier_type  returns [ClassifierType ct ]
//	@init { 
//		ct = Aadl2F.createClassifierType();
//		//ComponentCategory cc; 
//	}
//	:
//	CLASSIFIER
//	// component _category should now be a metaclass string name
//	( LPAREN cc= component_category 
//		{
//			ct.addCategory(cc);
//		}
//		( id= COMMA cc = component_category 
//			{
//				if ( ct.getCategory().contains(cc))
//					errReporter.warning(this.getFilename(), id.getLine(),"Duplicate component category "+cc.getReadableName());
//				else
//					ct.addCategory(cc);
//			}
//		)* 
//	RPAREN 
//	)?
//	;

unnamed_classifier_type  returns [ClassifierType ct ]
	@init{
	}
	:
	c=CLASSIFIER
		{
			ct = Aadl2F.createClassifierType();
			ct.setLocationReference(this.getFilename(), c.getLine());
		}
	(LPAREN qmi=qualified_meta_model_identifier
		{
			ct.getClassifierReferences().add(qmi);
		}
		(COMMA qmi1=qualified_meta_model_identifier
			{
				ct.getClassifierReferences().add(qmi1);
			}
		)*
	 RPAREN
	)?
	;
	
qualified_meta_model_identifier returns [MetaclassReference mtr]
	@init{
	//XXX: Location
		mtr = Aadl2F.createMetaclassReference();
	}
	:
	(LCURLY annexid=IDENT
	 RCURLY STAR STAR
	 	{
	 		mtr.setAnnexName(annexid.getText());
	 	}
	)?
	meta_model_class_identifier[mtr]
//		{
//			mtr.setMetaclassName(mmc);
//		}
	;
	
meta_model_class_identifier [MetaclassReference mtr] //returns [String cid]
	@init{
	}
	:
	(
		(core_metaclass_keyword) => cm=core_metaclass_keyword
		  {
		    //cid += cm;
		    mtr.getMetaclassNames().add(cm);
		  }
   |id=IDENT
    {
      mtr.getMetaclassNames().add(id.getText());
    }
	) + 
	;	

//TODO: see if we really want all the keywords here
core_metaclass_keyword returns [String s]
  @init{
  }
  :
  ABSTRACT
    {
      s="abstract";
    }
  |ACCESS
    {
      s="access";
    } 
  |AND
    {
      s="and";
    }
  |ALL
    {
      s="all";
    }
  | ANNEX
    {
      s="annex";
    }
  | APPLIES
    {
      s="applies";
    }
  | BINDING
    {
      s="binding";
    }
  | BOOLEAN
    {
      s="boolean";
    }
  | BUS
    {
      s="bus";
    }
  | CALLS
    {
      s="calls";
    }
  | CLASSIFIER
    { 
      s="classifier";
    }
  | REFERENCE
    {
      s="reference";
    }
  | CONNECTIONS
    {
      s="connections";
    }
  | CONSTANT
    {
      s="constant";
    }
  | DATA
    {
      s="data";
    }
  | DELTA
    {
      s="delta";
    }
  | DEVICE
    {
      s="device";
    }
  | END
    {
      s="end";
    }
  | ENUMERATION
    {
      s="enumeration";
    }
  | EVENT
    {
      s="event";
    }
  | EXTENDS
    {
      s="extends";
    }
  | FALSE
    {
      s="false";
    }
  | FEATURE
    {
      s="feature";
    }
  | FEATURES
    {
      s="features";
    }
  | FLOW
    {
      s="flow";
    }
  | FLOWS
    {
      s="flows";
    }
  | GROUP
    {
      s="group";
    }
  |IMPLEMENTATION
    {
      s="implementation";
    }
  | IN
    {
      s="in";
    }
  | INHERIT
    {
      s="inherit";
    }
  | INITIAL
    {
      s="initial";
    }
  | INTEGER
    {
      s="integer";
    }
  | INVERSE
    {
      s="inverse";
    }
  | IS
    {
      s="is";
    }
  | LIST
    {
      s="list";
    }
  | MEMORY
    {
      s="memory";
    }
  | MODE
    {
      s="mode";
    }
  | MODES 
    {
      s="modes";
    }
  |NONE
    {
      s="none";
    }
  |NOT
    {
      s="not";
    }
  |OF
    {
      s="of";
    }
  |OR
    {
      s="or";
    }
  |OUT
    {
      s="out";
    }
  |PACKAGE
    {
      s="package";
    }
  |PARAMETER
    {
      s="parameter";
    }
  |PATH
    {
      s="path";
    }
  |PORT
    {
      s="port";
    }
  |PRIVATE
    {
      s="private";
    }
  |PROCESS
    {
      s="process";
    }
  |PROCESSOR
    {
      s="processor";
    }
  |PROPERTIES
    {
      s="properties";
    }
  |PROPERTY
    {
      s="property";
    }
  |PROTOTYPE
    {
      s="prototype";
    }
  |PROTOTYPES
    {
      s="prototypes";
    }
  |PROVIDES
    {
      s="provides";
    }
  |PUBLIC
    {
      s="public";
    }
  |RANGE
    {
      s="range";
    }
  |REAL
    {
      s="real";
    }
  |RECORD
    {
      s="record";
    }
  |REFINED
    {
      s="refined";
    }
  |REFINES
    {
      s="refines";
    }
  |RENAMES
    {
      s="renames";
    }
  |REQUIRES
    {
      s="requires";
    }
  |SERVER
    {
      s="server";
    }
  |SET 
    {
      s="set";
    }
  |SINK
    {
      s="sink";
    }
  |SOURCE
    {
      s="source";
    }
  |STRING
    {
      s="string";
    }
  |SUBCOMPONENTS
    {
      s="subcomponents";
    }
  |SUBPROGRAM
    {
      s="subprogram";
    }
  |SYSTEM
    {
      s="system";
    }
  |THREAD
    {
      s="thread";
    }
  |TO
    {
      s="to";
    }
  |TRANSITIONS
    {
      s="transitions";
    }
  |TRUE
    {
      s="true";
    }
  |TYPE
    {
      s="type";
    }
  |UNITS
    {
      s="units";
    }
  |VALUE
    {
      s="value";
    }
  |VIRTUAL
    {
      s="virtual";
    }
  |WITH
    {
      s="with";
    }
  ;
  		
classifier_type returns [ClassifierType ct]
	@init { 
		//ClassifierType ct = null;
	}
	:
	ct1 = unnamed_classifier_type
		{ 
			ct = ct1;
		}
	;

//unnamed_component_property_type returns [ ReferenceType ct ]
//	@init { 
//		ct = Aadl2F.createReferenceType();
//		//ReferableElementCategory cc; 
//	}
//	:
//	REFERENCE
//	( LPAREN cc = CLASSNAME // use class_name instead //referable_element_category
//		{
//			ct.setMetaclass(cc);
//			//ct.addCategory(cc);
//		}
//		( id=COMMA cc = CLASSNAME // use class_name instead //referable_element_category 
//			{
//				if ( ct.getCategory().contains(cc))
//					errReporter.warning(this.getFilename(),id.getLine(),"Duplicate referable element category "+cc);
//				else {
//					ct.setMetaclass(cc);
//					//ct.addCategory(cc);
//				}
//			}
//		)* 
//	RPAREN 
//	)?
//	;
	
	
//component_property_type [PropertySet ps, Token il]
//	@init {
//		//ReferenceType ct =null;
//		LocationReference lr=null;
//	}
//	:
//	ct = unnamed_component_property_type
//		{ 
//			ct.setName(il.getText()); 
//			ps.addPropertyType(ct);
//			lr = new LocationReference(this.getFilename(),il.getLine()); 
//			ct.setLocationReference(lr);
//		}
//	;

//referable_element_category returns [ComponentCategory cat]
//	@init{
//		cat=null;
//	}
//	:
//	( THREAD GROUP 
//		{ 
//			cat = ComponentCategory.THREAD_GROUP;
//			//cat = ReferableElementCategory.THREAD_GROUP_LITERAL; 
//		}
//	| THREAD 
//		{ 
//			cat = ComponentCategory.THREAD;
//			//cat = ReferableElementCategory.THREAD_LITERAL; 
//		}
//	| DATA 
//		{ 
//			cat = ComponentCategory.DATA;
//			//cat = ReferableElementCategory.DATA_LITERAL; 
//		}
//	| SUBPROGRAM 
//		{ 
//			cat = ComponentCategory.SUBPROGAM;
//			//cat = ReferableElementCategory.SUBPROGRAM_LITERAL; 
//		}
//	| PROCESS 
//		{ 
//			cat = ComponentCategory.PROCESS;
//			//cat = ReferableElementCategory.PROCESS_LITERAL; 
//		}
//	| PROCESSOR 
//		{ 
//			cat = ComponentCategory.PROCESSOR;
//			//cat = ReferableElementCategory.PROCESSOR_LITERAL; 
//		}
//	| MEMORY 
//		{ 
//			cat = ComponentCategory.MEMORY;
//			//cat = ReferableElementCategory.MEMORY_LITERAL; 
//		}
//	| BUS 
//		{ 
//			cat = ComponentCategory.BUS;
//			//cat = ReferableElementCategory.BUS_LITERAL; 
//		}
//	| DEVICE 
//		{ 
//			cat = ComponentCategory.DEVICE;
//			//cat = ReferableElementCategory.DEVICE_LITERAL; 
//		}
//	| SYSTEM 
//		{ 
//			cat = ComponentCategory.SYSTEM;
//			//cat = ReferableElementCategory.SYSTEM_LITERAL; 
//		} 
//	| CONNECTIONS 
//		{ 
//			cat = ReferableElementCategory.CONNECTIONS_LITERAL; 
//		}
//	| SERVER SUBPROGRAM 
//		{ 
//			cat = ReferableElementCategory.SERVER_SUBPROGRAM_LITERAL; 
//		}
//	)
//	; 

unique_property_type_identifier returns [ ReferenceRecord pr]
	@init{
		pr= new ReferenceRecord();
		String ps="";
	}
	:
	( pset= IDENT 
		{
		  ps = pset.getText();
		}
	DOUBLECOLON 
	)? 
	ptype= IDENT 
		{
		  if (ps.length() >0){
		    pr = new ReferenceRecord(new String[]{ps,ptype.getText()});
		  } else {
		    pr = new ReferenceRecord(new String[]{ptype.getText()});
		  } 
		}
;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 5.1.2 Property Names
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//property_name_declaration [PropertySet ps, Token il]
///*options {defaultErrorHandler=true;}*/
//        @init {  
//        PropertyDefinition pn = PF.createPropertyDefinition();
//        processComments(pn);
//	   	pn.setName(il.getText()); 
//	   	ps.addPropertyDefinition(pn);
//          LocationReference lr = new LocationReference(this.getFilename(),il.getLine()); 
//          pn.setLocationReference(lr);
//          }:
//    ( ACCESS {pn.setAccess(true);} )?
//	( INHERIT {pn.setInherit(true);} )?
//	( single_valued_property[pn] | multi_valued_property[pn] )
//	APPLIES TO
//	    { PropertyOwnerCategory pc; }
//	LPAREN 
//	( (  property_owner[pn]
//	    ( COMMA property_owner[pn] 
//	    )* 
//	   ) 
//	   | ( ALL 
//	   // set all values by hand
//	   {		for (Iterator i = PropertyOwnerCategory.VALUES.iterator(); i.hasNext();) {
//			        pn.addAppliesto( (PropertyOwnerCategory)i.next());
//	            }
//	   }
//	) )
//	RPAREN SEMI
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//property_owner [Property pd]
//	    @init { 
//	    PropertyOwnerCategory cat=null; 
//	    int lineno = 0;
//	    //ClassifierReference cr = null; 
//	    }:
//    ( id1=THREAD GROUP { cat = PropertyOwnerCategory.THREAD_GROUP_LITERAL; lineno = id1.getLine();}
//    | id2=THREAD { cat = PropertyOwnerCategory.THREAD_LITERAL; lineno = id2.getLine();}
//    | id3=DATA { cat = PropertyOwnerCategory.DATA_LITERAL; lineno = id3.getLine();}
//    | id4=SUBPROGRAM { cat = PropertyOwnerCategory.SUBPROGRAM_LITERAL; lineno = id4.getLine();}
//    | id5=PROCESS { cat = PropertyOwnerCategory.PROCESS_LITERAL; lineno = id5.getLine();}
//    | id6=PROCESSOR { cat = PropertyOwnerCategory.PROCESSOR_LITERAL; lineno = id6.getLine();}
//    | id7=MEMORY { cat = PropertyOwnerCategory.MEMORY_LITERAL; lineno = id7.getLine();}
//    | id8=BUS { cat = PropertyOwnerCategory.BUS_LITERAL; lineno = id8.getLine();}
//    | id9=DEVICE { cat = PropertyOwnerCategory.DEVICE_LITERAL; lineno = id9.getLine();}
//    | id10=SYSTEM { cat = PropertyOwnerCategory.SYSTEM_LITERAL; lineno = id10.getLine();} 
//    | id11=CONNECTIONS { cat = PropertyOwnerCategory.CONNECTIONS_LITERAL; lineno = id11.getLine();}
//	| id12=SERVER SUBPROGRAM { cat = PropertyOwnerCategory.SERVER_SUBPROGRAM_LITERAL; lineno = id12.getLine();}
//	 | id13=MODE { cat = PropertyOwnerCategory.MODE_LITERAL; lineno = id13.getLine();}
//	 | id14=PORT GROUP CONNECTIONS { cat = PropertyOwnerCategory.PORT_GROUP_CONNECTIONS_LITERAL; lineno = id14.getLine();}
//	 | id15=PORT GROUP { cat = PropertyOwnerCategory.PORT_GROUP_LITERAL; lineno = id15.getLine();}
//	 | id16=PORT CONNECTIONS { cat = PropertyOwnerCategory.PORT_CONNECTIONS_LITERAL; lineno = id16.getLine();}
//	 | id17=PORT { cat = PropertyOwnerCategory.PORT_LITERAL; lineno = id17.getLine();}
//	 | id18=DATA PORT { cat = PropertyOwnerCategory.DATA_PORT_LITERAL; lineno = id18.getLine();}
//	 | id19=EVENT DATA PORT { cat = PropertyOwnerCategory.EVENT_DATA_PORT_LITERAL; lineno = id19.getLine();}
//	 | id20=EVENT PORT { cat = PropertyOwnerCategory.EVENT_PORT_LITERAL; lineno = id20.getLine();}
//	 | id21=DATA PORT CONNECTIONS { cat = PropertyOwnerCategory.DATA_PORT_CONNECTIONS_LITERAL; lineno = id21.getLine();}
//	 | id22=EVENT DATA PORT CONNECTIONS { cat = PropertyOwnerCategory.EVENT_DATA_PORT_CONNECTIONS_LITERAL; lineno = id22.getLine();}
//	 | id23=EVENT PORT CONNECTIONS { cat = PropertyOwnerCategory.EVENT_PORT_CONNECTIONS_LITERAL; lineno = id23.getLine();}
//	 | id24=FLOW { cat = PropertyOwnerCategory.FLOW_LITERAL; lineno = id24.getLine();}
//	 | id25=ACCESS CONNECTIONS { cat = PropertyOwnerCategory.ACCESS_CONNECTIONS_LITERAL; lineno = id25.getLine();}
//	 | id26=PARAMETER { cat = PropertyOwnerCategory.PARAMETER_LITERAL; lineno = id26.getLine();}
//	 | id27=PARAMETER CONNECTIONS { cat = PropertyOwnerCategory.PARAMETER_CONNECTIONS_LITERAL; lineno = id27.getLine();}
//	 )
//	( cr = classifier_reference	)?
//	{ 
//		if ( cr == null) {
//			if ( pd.getAppliesto().contains(cat) ) 
//			    errReporter.warning(this.getFilename(), lineno,"Duplicate property owner category "+cat.getReadableName());
//			else
//				pd.addAppliesto(cat);
//		} else {
//			if ( cat.getValue() > PropertyOwnerCategory.SYSTEM) {
//			    errReporter.warning(this.getFilename(), lineno,"No classifier for property owner category "+ cat.getReadableName());
//			} else {
//				ClassifierValue cv = PF.createClassifierValue();
//				cv.setValue(ComponentCategory.get(cat.getValue()));
//				cv.setClassifierReference(cr);
//				pd.addAppliesToClassifier(cv);
//			}
//		}
//	}
//;

//single_valued_property [Property pn]
//     		@init { 
//     		//PropertyValue val = null; 
//     		//ParsedPropertyReference ppr=null;
//     		//PropertyType upt;
//     		}:
//    ( 
//      upt = unnamed_property_type 
//      	{ 
//      		pn.setPropertyType(upt);
//      	}
//     | 
//        ppr = unique_property_type_identifier
//            { 
//            	pn.setParsedPropertyReference(ppr); 
//            }
//    )
//    
//    ( ASSIGN val =  
//    	{  pn.addDefaultpropertyValue(val); }
//    )?
//;


//multi_valued_property [Property pn]
//     		@init { 
//     		//PropertyValue val = null; 
//     		//ParsedPropertyReference ppr=null;
//     		//PropertyType upt;
//     		}:
//	LIST OF {pn.setList(true);} 
//    ( 
//      upt = unnamed_property_type 
//      	{ pn.setPropertyType(upt);}
//     | 
//        ppr = unique_property_type_identifier
//            { pn.setParsedPropertyReference(ppr); }
//    )
//    
//    ( ASSIGN LPAREN { pn.setHasEmptyList(true); }
//    ( val =  
//    		{  pn.addDefaultpropertyValue(val); pn.setHasEmptyList(false);} 
//        ( COMMA val =  { pn.addDefaultpropertyValue(val);}
//        )*
//    )?
//    RPAREN 
//    )?
//;



// Note that for property constants we know we are dealing with reals and integers,
// even when identifiers are used - they refer to other constants
// As a result we create the respective Value objects and attach the ParsedPropertyReference object to it.


property_constant returns [PropertyConstant pc]
	@init { 
        }
        :
  id=IDENT COLON CONSTANT
    {
      pc = Aadl2F.createPropertyConstant();
      pc.setName(id.getText());
      pc.setLocationReference(this.getFilename(),id.getLine());
    }
  (
    LIST OF {
      pc.setList(pc.getList() + 1);
    }
  )*
  (nr= unique_property_type_identifier
    {
      nr.setReferencingObject(pc);
      nr.setReferenceType(ParserReferenceType.PropertyTypeReference);
      unresolvedReferences.add(nr);
    }
   |pt = property_type
    {
      pc.setOwnedType(pt);
    }
  )
  ASSIGN
    ce=constant_property_expression[pc]
      {
        if (ce != null)
          pc.setConstantValue(ce);
      }
  SEMI
     ;
          catch [RecognitionException ex] {
            reportError(ex);
			consumeUntil(input,SEMI);
			input.consume();
        }

constant_property_expression [Element refObj] returns [PropertyExpression pe]
	scope{
	   Element ro;
	}
	@init{
	 pe = null;
	 $constant_property_expression::ro = refObj; 
	}
	:
	(
   (LPAREN IDENT ASSIGN) => rct=record_term
    {
      pe=rct;
    }
  | (~(DOTDOT|SEMI)* DOTDOT) =>  nr=numeric_range_term
    {
      pe=nr;
    }
  | bt=boolean_term 
    {
      pe=bt;
    }
	| rt=real_term
		{
			pe=rt;
		}
	| it=integer_term
		{
			pe=it;
		}
	| st=string_term
		{
			pe=st;
		}
	| cct=component_classifier_term
		{
			pe=cct;
		}
	| ct=computed_term
		{
			pe=ct;
		}
  | li = list_term[$constant_property_expression::ro]
    {
      pe = li;
    }
  // this type of term includes: 
  // enumeration_term,
  // unit_term,
  // and property_term
	| property_constant_or_namelike_literal[$constant_property_expression::ro] 
	)
	;     
	
computed_term returns [PropertyExpression ct]
  @init{
  }
  :
  COMPUTE
  LPAREN 
  id=IDENT
  RPAREN
  {
    ComputedValue cv = Aadl2F.createComputedValue();
    cv.setLocationReference(this.getFilename(), id.getLine());
    cv.setFunction(id.getText());
    ct = cv;
  }
  ;
  	
record_term returns [PropertyExpression rt]
	@init{
		rt=null;
		RecordValue rv=null;
		BasicPropertyAssociation bpa=null;
		BasicPropertyAssociation bpa1=null;
	}
	:
	LPAREN
	( id=IDENT ASSIGN 
		(
			{
					rv = Aadl2F.createRecordValue();
					rv.setLocationReference(this.getFilename(),id.getLine());
					bpa = Aadl2F.createBasicPropertyAssociation();
					bpa.setLocationReference(this.getFilename(), id.getLine());
					ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.PropertyRecordFieldReference,
					                                                           bpa,
					                                                           new String[]{id.getText()});
          unresolvedReferences.add(rr);					                                                           
			}
			(pv=property_expression[bpa] SEMI
				{
					// if all parsing works then assign our record
					rv.getOwnedFieldValues().add(bpa);
					bpa.setOwnedValue(pv);
					rt=rv;
				}
			)
		)
		(id1=IDENT ASSIGN 
			{
				bpa1 = Aadl2F.createBasicPropertyAssociation();
				bpa1.setLocationReference(this.getFilename(), id1.getLine());
          ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.PropertyRecordFieldReference,
                                                                     bpa1,
                                                                     new String[]{id1.getText()});
          unresolvedReferences.add(rr);                                                                    
			}
			(pv1=property_expression[bpa1] SEMI
				{
					rv.getOwnedFieldValues().add(bpa1);
					bpa1.setOwnedValue(pv1);
				}
			)
		)*
	)
	RPAREN
	;
	
	
modal_property_value [PropertyAssociation pa]
  scope{
    ModalPropertyValue mpv;
  }
  @init{
  //XXX: Location
    $modal_property_value::mpv=null; //Aadl2F.createModalPropertyValue(); 
    boolean prevInmodes = false;
    boolean currInmodes = false;
    //BasicPropertyAssociation bpa=Aadl2F.createBasicPropertyAssociation();
  }
  :
  (LPAREN
   (
    (
      {
        $modal_property_value::mpv=Aadl2F.createModalPropertyValue(); 
      }
      pv = property_expression[$modal_property_value::mpv]
      {
        $modal_property_value::mpv.setOwnedValue(pv);
        pa.getOwnedValues().add($modal_property_value::mpv);
      }
    (
      in_modes[$modal_property_value::mpv]
      {     
        prevInmodes = currInmodes;
        currInmodes = true;
      }
    )   
    )
    (COMMA
      {
        $modal_property_value::mpv=Aadl2F.createModalPropertyValue(); 
      }    
      pv = property_expression[$modal_property_value::mpv]
      {
      	$modal_property_value::mpv.setOwnedValue(pv);
        pa.getOwnedValues().add($modal_property_value::mpv);
      }
    (
      in_modes[$modal_property_value::mpv]
      {     
        prevInmodes = currInmodes;
        currInmodes = true;
      }
    )   
    )*
    (COMMA
      {
        $modal_property_value::mpv=Aadl2F.createModalPropertyValue(); 
      }
      pv = property_expression[$modal_property_value::mpv]
      {
        $modal_property_value::mpv.setOwnedValue(pv);    
        pa.getOwnedValues().add($modal_property_value::mpv);
      }
    )?
    )
    RPAREN
  )
  |
  (
      {
        $modal_property_value::mpv=Aadl2F.createModalPropertyValue(); 
      }
      pv = property_expression[$modal_property_value::mpv]
      {
        $modal_property_value::mpv.setOwnedValue(pv);    
        pa.getOwnedValues().add($modal_property_value::mpv);
      }
  )
  ;
	
//property_value [Element bpa]
//  scope{
//    Element bpa1;
//  }
//	@init{
//	 $property_value::bpa1=bpa;
//	}
//	:
//	sp=property_expression[$property_value::bpa1]
//		{
//		  if (sp != null){
//		    if (bpa instanceof BasicPropertyAssociation)
//			     ((BasicPropertyAssociation)bpa).getOwnedValues().add(sp);
//			  else
//           ((ModalPropertyValue)bpa).getOwnedValues().add(sp);
//			 }
//		}
//  |
//  property_list_value[bpa]
//	;
//		     
//property_list_value[Element bpa]
//	@init{
//	}
//	:
//	LPAREN
//	(pe=property_expression[bpa]
//		{
//		  if (pe != null){
//		    if (bpa instanceof BasicPropertyAssociation)
//			     ((BasicPropertyAssociation)bpa).getOwnedValues().add(pe);
//			  else 
//           ((ModalPropertyValue)bpa).getOwnedValues().add(pe);
//			 }
//		}
//		(COMMA pe1=property_expression[bpa]
//			{
//			   if (pe1 != null){
//	       if (bpa instanceof BasicPropertyAssociation)
//           ((BasicPropertyAssociation)bpa).getOwnedValues().add(pe1);
//        else 
//           ((ModalPropertyValue)bpa).getOwnedValues().add(pe1);
//				 }
//			}
//		)*
//	)?
//	RPAREN
//	;
			     
property_expression [Element refObject] returns [PropertyExpression pe]
  scope{
    Element ro;
  }
	@init{
	 pe = null;
	 $property_expression::ro = refObject;
	}
	:
	(
   (LPAREN IDENT ASSIGN) => rct=record_term
    {
      pe=rct;
    }
  // we had to force the discovery of whether a dotdot is present in the expression
  // and if so, then go into the numeric_range_term rule and if not FORCE going into the
  // property_constant_or_namelike_literal rule. Without this syntactic predicate it goes into
  // the numeric_range_term always even when no DOTDOT is present.
  |(~(DOTDOT|SEMI)* DOTDOT) => nt = numeric_range_term
            {
              pe=nt;
            }
  | rft=reference_term
    {
      pe=rft;
    }
  | ct=computed_term
    {
      pe=ct;
    }
  | st=string_term
    {
      pe=st;
    }
  | rt=real_term
    {
      pe=rt;
    }
  | it=integer_term
    {
      pe=it;
    }
	| cct=component_classifier_term
		{
			pe=cct;
		}
	// this type of term includes: 
	// enumeration_term,
	// unit_term,
	// and property_term
  | bt=boolean_term
    {
      pe=bt;
    }
  | property_constant_or_namelike_literal[$property_expression::ro]
  |	li = list_term[$property_expression::ro]
	  {
	    pe = li;
	  }
	)
	;     

list_term [Element refObj] returns [ListValue li]
  @init{
      li = Aadl2F.createListValue();
      Element refObj1 = li;
  }
  :
  (
  (
  LPAREN RPAREN
  )
  |
  (
  LPAREN
  exp = property_expression[refObj1] {
      if (exp != null)
      	li.getOwnedListElements().add(exp);
  }
  (
    COMMA
    exp = property_expression[refObj1] {
      if (exp != null)
        li.getOwnedListElements().add(exp);
    }
  )*
  RPAREN
  )
  )
  ;
    
reference_term returns [PropertyExpression pe]
  @init{
      ReferenceValue rf = Aadl2F.createReferenceValue();
  }
  :
  REFERENCE LPAREN
  contained_model_element_path[rf]
   {
     pe=rf;
   }
  RPAREN
  ;
    
// need to relocated these paths

array_range returns [ArrayRange ar]
	@init{
		int intValue;
	}
	:
	LBRACK num1=INTEGER_LIT
//	num1=NUMERAL_LIT
		{
			ar = Aadl2F.createArrayRange();
			ar.setLocationReference(this.getFilename(), num1.getLine());
			intValue= IntegerLiteralImpl.parseInt(num1.getText());
			if (intValue <0)
  				throw new FailedPredicateException(input, "array_range", "array range cannot be negative");
			ar.setLowerBound(intValue);
		}
	(DOTDOT num2=INTEGER_LIT //num2=NUMERAL_LIT
		{
			intValue= IntegerLiteralImpl.parseInt(num2.getText());
			if (intValue <0)
  				throw new FailedPredicateException(input, "array_range", "array range cannot be negative");
			ar.setUpperBound(intValue);
		}
	)?
	RBRACK
	;
      catch [RecognitionException ex] {
            reportError(ex);
			consumeUntil(input,RBRACK);
			consumeUntil(input,SEMI);
			input.consume();
        }
	
contained_model_element_path [ContainedNamedElement cne]
	@init{
		ContainmentPathElement cpe=null;
		ContainmentPathElement cpe1=null;
	}
	:
	(
		(id=IDENT
			{
				cne.setLocationReference(this.getFilename(),id.getLine());
				cpe = Aadl2F.createContainmentPathElement();
				cpe.setLocationReference(this.getFilename(), id.getLine());
				ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.ContainedPathElementReference,
				                                                            cpe,
				                                                            new String[]{id.getText()});
				unresolvedReferences.add(rr);
				cne.getContainmentPathElements().add(cpe);
			}
			(ar=array_range
				{
					cpe.getArrayRanges().add(ar);
				}
			)?
			(DOT id1=IDENT
				{
					cpe1 = Aadl2F.createContainmentPathElement();
					cpe1.setLocationReference(this.getFilename(), id1.getLine());
         ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.ContainedPathElementReference,
                                                                    cpe1,
                                                                    new String[]{id1.getText()});
          unresolvedReferences.add(rr);
					cne.getContainmentPathElements().add(cpe1);
				}
				(ar1=array_range
					{
						cpe1.getArrayRanges().add(ar1);
					}
				)?
			)*
		)
		(annexid=IDENT
		  LCURLY STARSTAR
		  text=ANNEX_TEXT
		  STARSTAR RCURLY
		    {
            cpe = Aadl2F.createContainmentPathElement();
            cpe.setLocationReference(this.getFilename(), annexid.getLine());
            ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.AnnexElementReference,
                                                                        cpe,
                                                                        new String[]{annexid.getText(), text.getText()});
            unresolvedReferences.add(rr);
            cne.getContainmentPathElements().add(cpe);		      
		    }
		)?
	)
	|
  (annexid=IDENT
      LCURLY STARSTAR
      text=ANNEX_TEXT
      STARSTAR RCURLY
        {
            cpe = Aadl2F.createContainmentPathElement();
            cpe.setLocationReference(this.getFilename(), annexid.getLine());
            ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.AnnexElementReference,
                                                                        cpe,
                                                                        new String[]{annexid.getText(), text.getText()});
            unresolvedReferences.add(rr);
            cne.getContainmentPathElements().add(cpe);          
        }
  )
	;
	
	
component_classifier_term returns [PropertyExpression pe]
	@init{
	}
	:
	c=CLASSIFIER LPAREN
	(
		(ci=unique_impl_name
			{
				ClassifierValue cv = Aadl2F.createClassifierValue();
				cv.setLocationReference(this.getFilename(), c.getLine());
				ci.setReferenceType(ParserReferenceType.ClassifierValueComponentImplementationReference);
				ci.setReferencingObject(cv);
				unresolvedReferences.add(ci);
				pe=cv;
			}
		)
		|
		(ct=unique_type_name
			{
				ClassifierValue cv = Aadl2F.createClassifierValue();
				cv.setLocationReference(this.getFilename(), c.getLine());
        ct.setReferenceType(ParserReferenceType.ClassifierValueComponentTypeReference);
        ct.setReferencingObject(cv);
        unresolvedReferences.add(ct);
				pe=cv;
			}
		)
	)
	RPAREN
	;

numeric_range_term returns [RangeValue rv]
	@init{
  // move it from below
  // they can be overwritten
    rv = Aadl2F.createRangeValue();
	}
	:
	(
  lowerreal=signed_aadlreal d1=DOTDOT
    {
      rv = Aadl2F.createRangeValue();
      rv.setLocationReference(this.getFilename(), d1.getLine());
      rv.setMinimum(lowerreal);
    }
    (upperreal=signed_aadlreal
      {
        rv.setMaximum(upperreal);
      }
    |crx1=signed_property_name_constant_reference
      {
        crx1.setReferencingObject(rv);
        crx1.setReferenceType(ParserReferenceType.UpperBoundPropertyConstantReference);
        unresolvedReferences.add(crx1);
      }
    )
	 |lowerint=signed_aadlinteger d2=DOTDOT
		{
			rv = Aadl2F.createRangeValue();
			rv.setLocationReference(this.getFilename(), d2.getLine());
			rv.setMinimum(lowerint);
		}
		(upperint=signed_aadlinteger
			{
				rv.setMaximum(upperint);
			}
		| crx2=signed_property_name_constant_reference
			{
			 crx2.setReferencingObject(rv);
			 crx2.setReferenceType(ParserReferenceType.UpperBoundPropertyConstantReference);
			 unresolvedReferences.add(crx2);
			}
		)
	|
//	{
//		// otherwise we assume real and if not switch to integer
//		rl = Aadl2F.createRealLiteral();
//		rv = Aadl2F.createRangeValue();
//	}
	crm=signed_property_name_constant_reference d3=DOTDOT
	   {
	     rv.setLocationReference(this.getFilename(), d3.getLine());
	     crm.setReferencingObject(rv);
	     crm.setReferenceType(ParserReferenceType.LowerBoundPropertyConstantReference);
	     unresolvedReferences.add(crm);
	   }
		(upperreal=signed_aadlreal
			{
				rv.setMaximum(upperreal);
			}
		|upperint=signed_aadlinteger
			{
				rv.setMaximum(upperint);
			}
		|
		crx=signed_property_name_constant_reference
			{
			 crx.setReferencingObject(rv);
			 crx.setReferenceType(ParserReferenceType.UpperBoundPropertyConstantReference);
			 unresolvedReferences.add(crx);
			}
		)
	)
	(DELTA 
		(incrint=signed_aadlinteger
			{
				rv.setDelta(incrint);
			}
		|incrreal=signed_aadlreal
			{
				rv.setDelta(incrreal);
			}
		|
		crd=signed_property_name_constant_reference
			{
			 crd.setReferencingObject(rv);
			 crd.setReferenceType(ParserReferenceType.DeltaPropertyConstantReference);
			 unresolvedReferences.add(crd);
			}
		)
	)?
	;
	
signed_property_name_constant_reference returns [ReferenceRecord rr]
	@init{
		String sign="";
	}
	:
	('+'
		{
			sign="+";
		}
	| '-'
		{
			sign="-";
		}
	)?
	si=property_name_constant_reference
		{
		    if (sign.length() > 0){
		      String[] labels = si.getLabels();
		      String [] nlabels = new String [labels.length+1];
		      nlabels[0]=sign;
		      for (int i=0; i<labels.length;i++)
		        nlabels[i+1] = labels[i];
		      si.setLabels(nlabels);
		    }
		    rr = si;
		}
	;
		
//integer_range_term returns [RangeValue rv]
//	@init{
//	}
//	:
//	lower=signed_aadlinteger_or_constant
//	DOTDOT
//	upper=signed_aadlinteger_or_constant
//		{
//			rv = Aadl2F.createRangeValue();
//			rv.setMinimum(lower);
//			rv.setMaximum(upper);
//		}
//	(DELTA increment=signed_aadlinteger_or_constant
//		{
//			rv.setDelta(increment);
//		}
//	)?
//	;
	
//real_range_term returns [RangeValue rv]
//	@init{
//	}
//	:
//	lower=signed_aadlreal_or_constant
//	DOTDOT
//	upper=signed_aadlreal_or_constant
//		{
//			rv = Aadl2F.createRangeValue();
//			rv.setMinimum(lower);
//			rv.setMaximum(upper);
//		}
//	( DELTA increment=signed_aadlreal_or_constant
//		{
//			rv.setDelta(increment);
//		}
//	)?
//	;
	
// namelike literal such as enumeration and units cannot be resolved in the
// parser, instead they are stored in "unresolved" format to  be passed to the
// name resolver
property_constant_or_namelike_literal [Element refObj] 
	@init{
		String sign="";
	}
	:
	(
		('+'
			{
				sign="+";
			}
		)
		|
		('-'
			{
				sign="-";
			}
		)
	 
	)?
	(pct=property_constant_term
		{
		  if (sign.length() >0){
		    String[] labels = pct.getLabels();
		    String[] nlabels = new String[labels.length+1];
		    nlabels[0] = sign;
		    for (int i=0;i<labels.length;i++)
		      nlabels[i+1] = labels[i];
		    pct.setLabels(nlabels);
		  } 
		  
		  if (pct.getLabels().length>1 || sign.length() > 0) {
		    //containes a property set designator or a sign so it 
		    // either be a constant or a property
        pct.setReferenceType(ParserReferenceType.PropertyOrConstantReference);
		  } else {
		    // without property set designator or sign
		    // it can be any thing: constant, property or enumeration literal
        pct.setReferenceType(ParserReferenceType.EnumerationLiteralOrPropertyOrConstantReference);
		  }
		  pct.setReferencingObject(refObj);
		  unresolvedReferences.add(pct);
		}
	)
	;
		
string_term returns [PropertyExpression st]
	@init{
	}
	:
	(
		(sl=STRING_LITERAL
			{
				StringLiteral slit= Aadl2F.createStringLiteral();
				slit.setLocationReference(this.getFilename(), sl.getLine());
				String str = sl.getText();
				// stripout the quotes
				str = str.substring(1,str.length()-1);
				slit.setValue(str);
				st=slit;
			}	
		)
//		|
//		(pct=property_constant_term
//			{
//				ConstantValue cv = Aadl2F.createConstantValue();
//				cv.setPropertyConstantReference(pct);
//				st = cv;
//			}	
//		)
	)
	;
	 
integer_term returns [PropertyExpression it]
	@init{
	}
	:
	//ic=signed_aadlinteger_or_constant
	ic=signed_aadlinteger
		{
			it = ic;
		}
	;
	
real_term returns [PropertyExpression rt]
	@init{
	}
	:
	//sc=signed_aadlreal_or_constant
	sc=signed_aadlreal
		{
			rt = sc;
		}
	;


boolean_term returns [PropertyExpression bt]
	@init{
	}
	:
	(at= or_term
		{
			bt=at;
		}
	)
	;
	
  	
and_term returns [PropertyExpression ae]	
	@init{
		PropertyExpression tae=null;
		Operation op=null;
	}
	:
	(oe=boolean_atom
		{
			tae=oe;
		}
		(andtoken=AND oe1= boolean_atom
			{
				if (op ==null){
					op=Aadl2F.createOperation();
					op.setLocationReference(this.getFilename(),andtoken.getLine());
					op.setOp(OperationKind.AND);
					op.getOwnedPropertyExpressions().add(oe);
					tae=op;
				}
				op.getOwnedPropertyExpressions().add(oe1);
			}	
		)*
	)
		{
			ae=tae;
		}
	;
	
or_term returns [PropertyExpression oe]
	@init{
		oe=null;
		PropertyExpression toe=null;
		Operation op = null;
	}
	:
	(at=and_term
		{
			toe=at;
		}
		(ortoken=OR at1=and_term
			{
				if (op == null){
					op=Aadl2F.createOperation();
					op.setLocationReference(this.getFilename(),ortoken.getLine());
					op.setOp(OperationKind.OR);
					op.getOwnedPropertyExpressions().add(at);
					toe=op;
				}
				op.getOwnedPropertyExpressions().add(at1);
			}
		)*
	)
		{
			oe=toe;
		}
	;	

boolean_atom returns [PropertyExpression ba]
	@init{
	}
	:
	TRUE
		{
		//XXX: Location
			BooleanLiteral bl = Aadl2F.createBooleanLiteral();
			bl.setValue(true);
			ba = bl;
		}
	| FALSE
		{
		//XXX: Location
			BooleanLiteral bl = Aadl2F.createBooleanLiteral();
			bl.setValue(false);
			ba = bl;
		}
	| NOT bt1=boolean_term
		{
		//XXX: Location
			Operation op = Aadl2F.createOperation();
			op.setOp(OperationKind.NOT);
			op.getOwnedPropertyExpressions().add(bt1);
			ba=op;
		}
	| pct=property_constant_term
		{
		//XXX: Location
			ConstantValue cv = Aadl2F.createConstantValue();
			pct.setReferencingObject(cv);
			if (pct.getLabels().length > 1) {
			  pct.setReferenceType(ParserReferenceType.BooleanOrConstantPropertyOrConstantReference);
			} else {
			  pct.setReferenceType(ParserReferenceType.BooleanOrConstantEnumerationLiteralOrPropertyOrConstantReference);
			}
			unresolvedReferences.add(pct);
			ba = cv;
		}	
//	| {input.LA(3) != RPAREN}? =>LPAREN bt1=boolean_term RPAREN
	| LPAREN bt1=boolean_term RPAREN
		{
			ba = bt1;

		}
	;
	
property_constant_term returns [ReferenceRecord nr]
	@init{
		String ps="";
	}
	:
	(
	(psid=IDENT DOUBLECOLON
		{
		  ps=psid.getText();
		}
  id=IDENT
    {
      if (ps.length() >0){
        nr = new ReferenceRecord(new String[]{ps, id.getText()});
      } else {
        nr = new ReferenceRecord(new String[]{id.getText()});
      }
    }
	)
	|
	(
	id=IDENT
		{
		  if (ps.length() >0){
		    nr = new ReferenceRecord(new String[]{ps, id.getText()});
		  } else {
		    nr = new ReferenceRecord(new String[]{id.getText()});
		  }
		}
		)
		)
	;	
	
// single_valued_property_constant[PropertyConstant pc] 
// 				@init { 
// 				//ParsedPropertyReference ppr = null; 
// 				//PropertyValue val;  
// 				Aadlinteger ai = null;
// 				Aadlreal ar=null;
// 				}
// :
//    (( INTEGER 
//     			{ ai = PF.createAadlinteger();
//     				pc.setPropertyType(ai);
//     			}
//     	(
//    		ppr = unique_property_type_identifier  
//    				{ ai.setParsedPropertyReference(ppr); }    	
//     	)?
//       ASSIGN 
//        val1 = signed_aadlinteger { pc.addConstantValue(val1); }
//       )
//      |( REAL 
//     			{  ar = PF.createAadlreal();
//     				pc.setPropertyType(ar);
//     			}
//          (
//     		ppr = unique_property_type_identifier  
//     				{ ar.setParsedPropertyReference(ppr); }    	
//          )?
//         ASSIGN 
//        val2 = signed_aadlreal { pc.addConstantValue(val2); }
//      )
//     |( STRING ASSIGN 
//       { pc.setPropertyType(PF.createAadlstring()); }
//       val3 = string_term 
//       { pc.addConstantValue(val3); }
//     )
//     |( BOOLEAN ASSIGN 
//       { pc.setPropertyType(PF.createAadlboolean()); }
//       val4 = true_false_value 
//       { pc.addConstantValue(val4); }
//     )
//     |( 
//     	     { 
//     	           ppr = null; 
//     	     }
//          ppr = unique_property_type_identifier ASSIGN 
//     		       {
//     		                pc.setParsedPropertyReference(ppr); 
//     		        }
//          (val5 = enumeration_term 
//              {
//                       pc.addConstantValue(val5); 
//               }
//           |(
//        	     ( 
//        	       (signed_aadlnumeric DOTDOT) =>
//         	           val6 = aadl_numeric_range { pc.addConstantValue(val6); }
//         	          | val7 = signed_aadlnumeric{ pc.addConstantValue(val7); }
//       		     )
//       	    )
//          )
//     )
//    ) 
//    ;


     
// multi_valued_property_constant[PropertyConstant pc] 
//     		@init { 
//     		//ParsedPropertyReference ppr = null; 
//     		//PropertyValue val; 
//     		Aadlinteger ai = null;
// 			Aadlreal ar=null;
//     		}
// :
//     LIST OF {pc.setList(true);}
//    (( INTEGER 
//     			{  ai = PF.createAadlinteger();
//     				pc.setPropertyType(ai);}
//    	(
//    		ppr = unique_property_type_identifier  
//    				{ ai.setParsedPropertyReference(ppr); }    	
//     	)?
//    ASSIGN LPAREN
//      ( val = signed_aadlinteger { pc.addConstantValue(val); }
//        ( COMMA val = signed_aadlinteger { pc.addConstantValue(val); }
//        )* 
//      )?
//      RPAREN
//     )
//    |( REAL 
//     			{  ar = PF.createAadlreal();
//     				pc.setPropertyType(ar);
//     			}
//          (
//     		ppr = unique_property_type_identifier  
//     				{ ar.setParsedPropertyReference(ppr); }    	
//          )?
//       ASSIGN LPAREN
//      ( val1 = signed_aadlreal { pc.addConstantValue(val1); }
//        ( COMMA val2 = signed_aadlreal { pc.addConstantValue(val2); }
//        )*
//      )?
//      RPAREN
//     )
//     |( STRING 
//     		{ pc.setPropertyType(PF.createAadlstring()); }
//        ASSIGN LPAREN
//      ( val3 = string_term { pc.addConstantValue(val3); }
//        ( COMMA val4 = string_term { pc.addConstantValue(val4); }
//        )*
//      )?
//      RPAREN
//     )
//     |( BOOLEAN 
//     		{ pc.setPropertyType(PF.createAadlboolean()); }
//        ASSIGN LPAREN
//       ( val5 = true_false_value { pc.addConstantValue(val5); }
//         ( COMMA val6 = true_false_value { pc.addConstantValue(val6); }
//         )*
//        )?
//        RPAREN
//     )
//     |( 
//     	{  ppr = null; }
//     	ppr = unique_property_type_identifier ASSIGN LPAREN
//     		{ pc.setParsedPropertyReference(ppr); }
//       ( ( val7 = enumeration_term { pc.addConstantValue(val7); }
//         	( COMMA val8 = enumeration_term { pc.addConstantValue(val8); }
//         	)*
//         )
//         |
//          ( (signed_aadlnumeric DOTDOT) =>
//         	( val9 = aadl_numeric_range { pc.addConstantValue(val9); }
//         	  ( COMMA val10 = aadl_numeric_range { pc.addConstantValue(val10); }
//         	  )*
//             )
//             |
//       		 ( val11 = signed_aadlnumeric { pc.addConstantValue(val11); }
//         	  ( COMMA val12 = signed_aadlnumeric { pc.addConstantValue(val12); }
//         	  )*
//       		 )
//       		)  // signed_aadlnumeric DOTDOT
//       	)?
//       	RPAREN
//     )
//   )
//   ;

//aadl_numeric_range returns [RangeValue nrv]
//	@init{ 
//		nrv=null;
//		//NumberValue pv = null;  
//		//NumberValue val = null; 
//	}:
//    pv = signed_aadlnumeric
//	DOTDOT val = signed_aadlnumeric
//	{
//			if ( pv instanceof IntegerValue ){
//	     		nrv = PF.createIntegerRangeValue();
//	     		((IntegerRangeValue)nrv).setMinimum((IntegerValue)pv); 
//	        } else if ( pv instanceof RealValue ){
//	     		nrv = PF.createRealRangeValue();
//	     		((RealRangeValue)nrv).setMinimum((RealValue)pv);
//		    }
//		    if (nrv != null) nrv.setLocationReference(pv.getLocationReference());
//	   		if ( nrv instanceof IntegerRangeValue) {
//	   			if ( val instanceof IntegerValue){
//	   			    ((IntegerRangeValue)nrv).setMaximum((IntegerValue)val); 
//	   			} else {
//	   				// expected integer max value, but got real value
//	   				errReporter.warning(nrv.getLocationReference(),"Expected integer maximum value, but got real maximum");
//	   			}
//	   		} else if ( nrv instanceof RealRangeValue ) {
//	   			if ( val instanceof RealValue){
//	   			    ((RealRangeValue)nrv).setMaximum((RealValue)val); 
//	   			} else {
//	   				// expected real max value, but got integer value
//	   				errReporter.warning(nrv.getLocationReference(),"Expected real maximum value, but got integer maximum");
//	   			}
//	   		}
//	}
//	( DELTA val = signed_aadlnumeric
//	{
//	   		if ( nrv instanceof IntegerRangeValue) {
//	   			if ( val instanceof IntegerValue){
//	   			    ((IntegerRangeValue)nrv).setDelta((IntegerValue)val); 
//	   			} else {
//	   				// expected integer max value, but got real value
//	   				errReporter.warning(nrv.getLocationReference(),"Expected integer delta value, but got real delta");
//	   			}
//	   		} else if ( nrv instanceof RealRangeValue ) {
//	   			if ( val instanceof RealValue){
//	   			    ((RealRangeValue)nrv).setDelta((RealValue)val); 
//	   			} else {
//	   				// expected real max value, but got integer value
//	   				errReporter.warning(nrv.getLocationReference(),"Expected real delta value, but got integer delta");
//	   			}
//	   		}
//	}
//	)?
//;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 5.3 Property Associations
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//propertyAssociations returns [Properties ps ]
////options {defaultErrorHandler=true;}
//	@init { 
//		ps = null;
//		//PropertyAssociation pa ; 
//	}:
//   PROPERTIES { ps = PF.createProperties(); processComments(ps);}
//    (none_stmt | 
//      (  pa = property_association { ps.addPropertyAssociation(pa); }
//      )+ ) ;


//containedPropertyAssociations returns [Properties ps]
////options {defaultErrorHandler=true;}
//	@init { 
//		ps = null;
//		//PropertyAssociation pa ; 
//	}:
//   PROPERTIES { ps = PF.createProperties(); }
//    (none_stmt | 
//      (  pa = contained_property_association { ps.addPropertyAssociation(pa); processComments(pa);}
//      )+ ) ;

//propertyAssociations_no_modes returns [Properties ps]
////options {defaultErrorHandler=true;}
//	 @init { 
//	 	ps = null;
//	 	//PropertyAssociation pa ; 
// 	}:
//   PROPERTIES { ps = PF.createProperties(); processComments(ps);}
//    (none_stmt | 
//      (  pa = property_association_no_modes { ps.addPropertyAssociation(pa); }
//      )+ ) ;


//curlyPropertyAssociations returns [Properties ps]
///*options {defaultErrorHandler=true;}*/
//	@init { 
//		ps = null;
//		//PropertyAssociation pa ; 
//	}:
//     LCURLY { ps = PF.createProperties(); processComments(ps);}
//    ( pa = property_association { ps.addPropertyAssociation(pa); }
//    )+ RCURLY  ;


//curlyPropertyAssociations_no_modes returns [Properties ps]
///*options {defaultErrorHandler=true;}*/ 
//	@init { 
//		ps = null;
//		//PropertyAssociation pa ; 
//	}:
//     LCURLY { ps = PF.createProperties(); processComments(ps);}
//    ( pa = property_association_no_modes { ps.addPropertyAssociation(pa); }
//    )+ RCURLY  ;


//containedCurlyPropertyAssociations returns [Properties ps]
///*options {defaultErrorHandler=true;}*/
//	@init { 
//		ps = null;
//		//PropertyAssociation pa ; 
//	}:
//   LCURLY { ps = PF.createProperties(); processComments(ps);}
//    ( pa =  contained_property_association { ps.addPropertyAssociation(pa); }
//    )+ RCURLY  ;

contained_property_association returns [PropertyAssociation pa]
  @init{
    pa = Aadl2F.createPropertyAssociation();
    boolean notContained=false;
    ContainedNamedElement cne=null;
  }
  :
  {
    processComments(pa);
  }
  nr=property_name_reference
    {
      nr.setReferencingObject(pa);
      nr.setReferenceType(ParserReferenceType.PropertyDefinitionReference);
      unresolvedReferences.add(nr);
    }
  (ap=ASSIGNPLUS
    {
      notContained=true;
      pa.setAppend(true);
      pa.setLocationReference(this.getFilename(), ap.getLine());
    }
  |a=ASSIGN
  	{
  		pa.setLocationReference(this.getFilename(), a.getLine());
  	}
  )
  (CONSTANT
    {
      pa.setConstant(true);
    }
  )?
  (modal_property_value[pa]
  )
  (APPLIES TO
    {
      if (notContained){
            throw new FailedPredicateException(input, "property association", "contained property association cannot have an append");
      }    
    }
  {
    cne = Aadl2F.createContainedNamedElement();
  }
  contained_model_element_path[cne]
    {
      pa.getAppliesTos().add(cne);
    }
  (
    {
      cne = Aadl2F.createContainedNamedElement();     
    }
    COMMA contained_model_element_path[cne]
    {
      pa.getAppliesTos().add(cne);
    }
  )*
  )? 
  (ib=in_binding[pa]
  )?
  SEMI
  ;
   catch [RecognitionException ex] {
      reportError(ex);
      consumeUntil(input,SEMI);
      input.consume();
   }

property_association returns [PropertyAssociation pa]
  @init{
    pa = Aadl2F.createPropertyAssociation();
  }
  :
  {
    processComments(pa);
  }
  nr=property_name_reference
    {
      nr.setReferencingObject(pa);
      nr.setReferenceType(ParserReferenceType.PropertyDefinitionReference);
      unresolvedReferences.add(nr);
    }
  (ap=ASSIGNPLUS
    {
      pa.setAppend(true);
      pa.setLocationReference(this.getFilename(), ap.getLine());
    }
  |a=ASSIGN
  	{
  		pa.setLocationReference(this.getFilename(), a.getLine());
  	}
  )
  (CONSTANT
    {
      pa.setConstant(true);
    }
  )?
  modal_property_value[pa]
  (ib=in_binding[pa]
  )?
  SEMI 
  ;
  
in_binding[PropertyAssociation pa]
@init{
}
:
IN BINDING LPAREN
(cr=classifier_reference
  {
    cr.setReferencingObject(pa);
    cr.setReferenceType(ParserReferenceType.PropertyAssociationInBindingReference);
    unresolvedReferences.add(cr);
  }
  (COMMA cr1=classifier_reference
    {
      cr1.setReferencingObject(pa);
      cr1.setReferenceType(ParserReferenceType.PropertyAssociationInBindingReference);
      unresolvedReferences.add(cr1);
    }
  )*
)
RPAREN
;
  
//property_association returns [PropertyAssociation pa]
////options {defaultErrorHandler=true;}
//    	@init { 
//    		pa = PF.createPropertyAssociation();
//    		//PropertyValue val = null;
//    		//ParsedPropertyReference pr = null; 
//    	}:
//    	{processComments(pa);}
//    pr = property_name_reference { 
//    		pa.setParsedPropertyReference(pr);
//    		    pa.setLocationReference(this.getFilename(),pr.getLine());
//    		}
//    ( ASSIGN | ASSIGNPLUS { pa.setAppend(true);} )
//    
//    ( CONSTANT { pa.setConstant(true);} 
//    )?
//    ( ACCESS { pa.setAccess(true);} 
//    )?
//    pe_or_list[pa]
//    ( in_binding[pa] )?
//    ( in_modes[pa] )?
//		{ if (pa.isAppend() && (!pa.getModeName().isEmpty() || pa.isNoMode())){
//				errReporter.error(pa.getLocationReference(),"Append not permitted for in modes property values");			
//			}
//		}
//    SEMI;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }



//property_association_no_modes returns [PropertyAssociation pa ] 
////options {defaultErrorHandler=true;}
//    	@init { 
//    		pa = PF.createPropertyAssociation();
//    		//PropertyValue val = null;
//    		//ParsedPropertyReference pr = null; 
//    	}:
//    	{processComments(pa);}
//    pr = property_name_reference { 
//    		pa.setParsedPropertyReference(pr);
//    		pa.setLocationReference(this.getFilename(),pr.getLine()); }

//    ( ASSIGN | ASSIGNPLUS { pa.setAppend(true);} )
    
//    ( CONSTANT { pa.setConstant(true);} 
//    )?
//    ( ACCESS { pa.setAccess(true);} 
//    )?
//    pe_or_list[pa]

//    ( in_binding[pa] )?
//    SEMI;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

unique_property_identifier returns [ReferenceRecord pr]
  @init{
    pr = new ReferenceRecord();
    String pslabel="";
  }
  :
  (psid=IDENT DOUBLECOLON
    {
      pslabel=psid.getText();
    }
  )?
  pid=IDENT
    {
      if (pslabel.length() > 0) {
        pr.setLabels(new String[]{pslabel,pid.getText()});
      } else {
        pr.setLabels(new String[]{pid.getText()});
      }
    }
  ;

property_name_reference returns [ReferenceRecord pr]
	@init{
	 String ps="";
	}
	:
	(
	( psid=IDENT DOUBLECOLON pid=IDENT
		{
        pr = new ReferenceRecord(new String[]{psid.getText(),pid.getText()});
		} 
	)
	|(pid=IDENT  
		{
	    pr = new ReferenceRecord(new String[]{pid.getText()});
		}
	)
	)
	;


property_name_constant_reference returns [ReferenceRecord pr]
	@init { 
		//ParsedPropertyReference ppr;  
	}
	:
//	VALUE 
//	LPAREN
	ppr = property_name_reference
//	RPAREN
		{
			pr = ppr;
	}
	;

// NOTE: This is not exactly the same as the contained_property_assocation rule in the
// spec.  In this case, "contained_property_assocation" is used whereever contained
// property assocations are allowed, and thus this rule really handles both normal and
// contained property associations.
//contained_property_association returns [PropertyAssociation pa]
//    	@init { 
//    		pa = PF.createPropertyAssociation();
//    		//PropertyValue val = null;
//    		//ParsedPropertyReference pr = null;
//    		processComments(pa);
//    	}:
//    pr = property_name_reference { pa.setParsedPropertyReference(pr);
//    pa.setLocationReference(this.getFilename(),pr.getLine()); }
//    ( ASSIGN | ASSIGNPLUS { pa.setAppend(true); } )
//    ( CONSTANT { pa.setConstant(true);} 
//    )?

//    pe_or_list[pa]
//    ( applies_to[pa] )?
//		{ if (pa.isAppend() && (pa.getComponentPath() != null && !pa.getComponentPath().isEmpty())){
//				errReporter.error(pa.getLocationReference(),"Append not permitted for contained property associations");			
//			}
//		}
//    ( in_binding[pa] )?
//    ( in_modes[pa] )?
//		{ if (pa.isAppend() && (!pa.getModeName().isEmpty() || pa.isNoMode())){
//				errReporter.error(pa.getLocationReference(),"Append not permitted for in modes property values");			
//			}
//		}
// SEMI;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//applies_to [ PropertyAssociation pa]:
//APPLIES TO cid= IDENT { pa.addComponentPath(cid.getText());}
//		( DOT mid= IDENT { pa.addComponentPath(mid.getText());}
//		)* 
//		;

//in_binding [ PropertyAssociation pa] 
//	@init {
//	//ClassifierReference cr;
//	}:
//	IN BINDING LPAREN cr = classifier_reference {pa.addClassifierReference(cr);}
//	( COMMA cr = classifier_reference {pa.addClassifierReference(cr);}
//	)*
//	RPAREN
//		{ if (pa.isAppend()){
//				errReporter.error(pa.getLocationReference(),"Append not permitted for in binding propery values");			
//			}
//		}
//;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 5.4 Property Expressions
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Same as pe_or_list but callable as a start rule
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//pe_or_list_top_level returns [PropertyAssociation pa]
//	@init{
//		pa = PF.createPropertyAssociation();
//	}:
//  pe_or_list[pa]
//;

	
//pe_or_list [PropertyAssociation pa]
//	@init { 
//	//ParsedPropertyReference ppr= null;
//		//PropertyValue val = null;
//	}
//:
//( LPAREN property_expression COMMA ) => 
//	(LPAREN val1 = property_expression 
//		{ pa.addPropertyValue(val1);}
//	( COMMA val2 = property_expression 
//		{ pa.addPropertyValue(val2);}
//	)+ RPAREN
//	)
//	|
//	( LPAREN
//	( val3=allbutbool )?
//		{ pa.addPropertyValue(val3);}
//	RPAREN
//	)
//	| 
//	(val4= allbutbool 
//			{ pa.addPropertyValue(val4);}
//	)
//	|
//	(
//		( property_name_constant_reference DOTDOT ) =>
//		( val5 = property_name_constant_reference
//		  val6 = num_range[val5] 
//		    { pa.addPropertyValue(val6); }
//		)
//		| 	
//		( val7 = logical_or
//			{ pa.addPropertyValue(val7);}
//		)
//	)
//;
//allbutbool returns [PropertyValue pv] 
//	@init{
//		//PropertyValue rt=null;
//	}:
//	( rt1 = reference_term {pv=rt1;}
//	| rt2 = enumeration_term {pv=rt2;}
//	| rt3 = string_term {pv=rt3;}
//	| rt4 = component_classifier_term {pv=rt4;}
// 	| rt5 = numeric_or_range_term {pv=rt5;}
// 	)
//;



//property_expression returns [PropertyValue pv]
//	@init{
//		 pv = null;
//	}:
////   property_term is already covered in boolean expression (logical_or)
//	(
// 	//rt1 = numeric_or_range_term {pv = rt1;}
//	//| 
//	rt2 = reference_term {pv = rt2;}
//	| rt3 = enumeration_term {pv = rt3;}
//	| rt4 = string_term {pv = rt4;}
//	| rt5 = component_classifier_term {pv = rt5;}
//	| rt6 = logical_or {pv = rt6;}
//	)	
//	 ;


//logical_or returns [ BooleanOrPropertyReference bv]
//        @init { 
//        	bv = null;
//        	BooleanOrPropertyReference  bv1; 
//        }:
//    bvr = logical_and ( OR bv2 = logical_and 
//         { 
//         	bv=bvr;
//         	bv1 = bv; bv = PF.createBooleanOR();
//         	  ((BooleanOR)bv).addBooleanValue(bv1);
//         	  ((BooleanOR)bv).addBooleanValue(bv2);
//         	  bv.setLocationReference(bv1.getLocationReference()); 
//        }
//    )*
//    ;
    
//logical_and returns [ BooleanOrPropertyReference bv ]
//        @init { 
//        	bv = null;
//        	BooleanOrPropertyReference bv1; 
//        }:
//    bvr = logical_unary ( AND bv2 = logical_unary 
//         { 
//         	bv = bvr;
//         	bv1 = bv; 
//         	bv = PF.createBooleanAND(); 
//         	  ((BooleanAND)bv).addBooleanValue(bv1);
//         	  ((BooleanAND)bv).addBooleanValue(bv2);
//         	  bv.setLocationReference(bv1.getLocationReference()); 
//         }
//    )*
//    ;
    
//logical_unary returns [ BooleanOrPropertyReference bv ]
//        @init { 
//        	bv = null;
//        }:
//    tv=TRUE { bv = PF.createTRUE(); bv.setLocationReference(this.getFilename(), tv.getLine()); }
//    | fv=FALSE { bv = PF.createFALSE(); bv.setLocationReference(this.getFilename(), fv.getLine()); }
//    | LPAREN bvr = logical_or RPAREN {bv = bvr;}
//    | not=NOT bv1 = logical_unary {    	    
//    	    bv = PF.createBooleanNOT();
//    	    ((BooleanNOT)bv).setBooleanValue(bv1);
//    	    bv.setLocationReference(this.getFilename(), not.getLine());
//    	  }
//    | pt = property_term {bv=pt;}
//    ;

//true_false_value returns [ BooleanLiteral bv]
//	@init{
//		 bv = null;
//	}:
//    tv=TRUE 
//    	{ 
//    		bv = Aadl2F.createBooleanLiteral(); 
//    		bv.setValue(true); 
//    		bv.setLocationReference(this.getFilename(), tv.getLine()); 
//    	}
//    | fv=FALSE 
//    	{ 
//    		bv = Aadl2F.createBooleanLiteral(); 
//    		bv.setValue(false); 
//    		bv.setLocationReference(this.getFilename(), fv.getLine()); 
//    	}
//;


//signed_constant returns [PropertyReference pv]
//       @init { 
//       	 //PropertyReference pvr;
//       	 pv=null;
//       	 //ParsedPropertyReference ppr = null; 
//       	 String sign =null;
//       	} :
//        ( PLUS {sign = "+";}
//        | MINUS {sign = "-";} 
//        )
//        pvr = property_name_constant_reference 
//    	{ 
//    		pv=pvr;
//	    	if (sign != null) 
//	    		pv.setPropertReferenceSign(sign);
//    	}
//;

// this rule handles integers, reals, as well as ranges of both types
// This includes the use of identifiers when they are preceded by a sign
// or all identifiers in the max and delta part of ranges
// Those references are represented as IntegerValue if known, with a ParsedPropertyReference object.
// Otherwise they are represented as RealValue - it may have to be recast into an IntergerValue at the time of name resolution.



//numeric_or_range_term returns [PropertyValue pv]
//        @init {
//        	//PropertyValue pvr1, pvr2;
//        	pv=null;
//        	//NumberValue val; 
//        }:
//	( signed_constant DOTDOT ) =>
//	  (	pvr1 = signed_constant 
//	  pvr2 = num_range[pvr1]
//	) {pv=pvr2;}
//	|
//    ( pvr1 = signed_aadlnumeric_or_signed_constant {pv=pvr1;}
//		 (  	pvr2 = num_range[pvr1] {pv=pvr2;}
//		 )?
//	   )
//         ;

// support rule to handle remainder of range if DOTDOT is identified in look ahead
//num_range [PropertyValue pv] returns [RangeValue nrv]
//	@init { 
//		nrv=null;
//		//NumberOrPropertyReference val = null;
//	}:
//			{ if ( pv instanceof IntegerValue ){
//		     		nrv = PF.createIntegerRangeValue();
//		     		((IntegerRangeValue)nrv).setMinimum((IntegerValue)pv); 
//		      } else if ( pv instanceof RealValue ){
//		     		nrv = PF.createRealRangeValue();
//		     		((RealRangeValue)nrv).setMinimum((RealValue)pv);
//		      } else if ( pv instanceof PropertyReference){
//		     		nrv = PF.createRangeValue();
//	   		  	((RangeValue)nrv).setMinimum((PropertyReference)pv);
//			  }
//			  LocationReference loc = pv.getLocationReference();
//			  if ( loc != null) 
//			  	nrv.setLocationReference(loc.getFilename(),loc.getLine());
//		  	}
//		   DOTDOT val = signed_aadlnumeric_or_constant 
//		   		{ nrv.setMaximum(val); 
//		   		  if (nrv instanceof IntegerRangeValue && val instanceof RealValue) {
//		   		  	errReporter.warning(nrv.getLocationReference(), 
//		   		  	  "Expected integer maximum value, but got real maximum");
//		   		  }
//		   		  if (nrv instanceof RealRangeValue && val instanceof IntegerValue) {
//		   		  	errReporter.warning(nrv.getLocationReference(), 
//		   		  	  "Expected real maximum value, but got integer maximum");
//		   		  }
//		   		}
//		   ( DELTA val = signed_aadlnumeric_or_constant 
//		   		{ nrv.setDelta(val);
//		   		  if (nrv instanceof IntegerRangeValue && val instanceof RealValue) {
//		   		  	errReporter.warning(nrv.getLocationReference(), 
//		   		  	  "Expected integer delta value, but got real delta");
//		   		  }
//		   		  if (nrv instanceof RealRangeValue && val instanceof IntegerValue) {
//		   		  	errReporter.warning(nrv.getLocationReference(), 
//		   		  	  "Expected real delta value, but got integer delta");
//		   		  }
//		   		}
//		   )?
//;


//string_term returns [ StringLiteral sv]
//	@init{
//		sv =Aadl2F.createStringLiteral();
//	}:
//     sl= STRING_LITERAL 
//         { 
//         	String s = sl.getText();
//         	if (s.startsWith("\"")){
//         		s = s.substring(1);
//         	}
//         	if (s.endsWith("\"")){
//         		s = s.substring(0,s.length()-1);
//         	}
//         	sv.setValue(s); sv.setLocationReference(this.getFilename(),sl.getLine()); 
//         }
////-------------------------------------------------------------------
//;

//enumeration_term returns [ EnumerationValue ev = null]
//	@init{
//		ev = null;
//	}:
//     enum_id= IDENT  
//     	{ 
//     		ev = Aadl2F.createEnumerationValue();
//     		ev.setEnumLiteralName(enum_id.getText()); 
//     		ev.setParsedEnumLiteral(enum_id.getText(),this.getFilename(),enum_id.getLine());
//     		ev.setLocationReference(this.getFilename(),enum_id.getLine());
//     	}
////-------------------------------------------------------------------
//;

//property_term returns [ PropertyReference pr]
//	@init{
//		//PropertyReference prr;
//		pr = null;
//	}:
//        prr = property_name_constant_reference {pr=prr;}
////------------------------------------------------------------------
//;



//component_classifier_term returns [ ClassifierValue cv]
//	@init { 
//		cv=null;
//		//ClassifierReference cr = null; 
//		//ComponentCategory cat;
//	}:
//      cat = component_category ( cr = classifier_reference )?
//         { cv = PF.createClassifierValue(); cv.setClassifierReference(cr); cv.setValue(cat);
//           if ( cr != null) cv.setLocationReference(this.getFilename(),cr.getLine());
//         }
//     ;

component_category returns [ComponentCategory cat]
	@init{
		cat = null;
	}:
	ABSTRACT { cat = ComponentCategory.ABSTRACT;}
    | BUS { cat = ComponentCategory.BUS; }
    | DATA { cat = ComponentCategory.DATA; }
    | DEVICE { cat = ComponentCategory.DEVICE; }
    | MEMORY { cat = ComponentCategory.MEMORY; }
    | PROCESS { cat = ComponentCategory.PROCESS; }
    | PROCESSOR { cat = ComponentCategory.PROCESSOR; }
    |( SUBPROGRAM GROUP { cat = ComponentCategory.SUBPROGRAM_GROUP; })
    | SUBPROGRAM { cat = ComponentCategory.SUBPROGRAM; }
    | SYSTEM { cat = ComponentCategory.SYSTEM; } 
    |( THREAD GROUP { cat = ComponentCategory.THREAD_GROUP; })
    | THREAD { cat = ComponentCategory.THREAD; }
    |( VIRTUAL BUS {cat = ComponentCategory.VIRTUAL_BUS;})
    |( VIRTUAL PROCESSOR {cat = ComponentCategory.VIRTUAL_PROCESSOR;})
//-------------------------------------------------------------------
;
// ** may be the same as the instance association
//reference_term returns [ ReferenceValue ct]
//	@init{
//		ct = PF.createReferenceValue();
//	}:
//     REFERENCE subcomponentid= IDENT 
//         { ct.addSubcomponentName(subcomponentid.getText()); }
//         { LocationReference lr = new LocationReference(this.getFilename(),subcomponentid.getLine()); ct.setLocationReference(lr);}
//     ( DOT subcomponentidmore= IDENT 
//         { ct.addSubcomponentName(subcomponentidmore.getText()); }
//     )*
//     ;
//-------------------------------------------------------------------


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 6.2 Subprograms
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


//callsSubclause returns [CallSequences cs]
//        @init { 
//        	cs = Aadl2F.createCallSequences() ;
//        	//CallSequence scs = null; 
//        	processComments(cs);
//        }:
//     CALLS  
//			( ( scs = subprogram_call_sequence { cs.addCallSequence(scs); }
//			   )+ |  none_stmt  )
//	;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,RCURLY);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


subprogram_call_sequence returns [SubprogramCallSequence cs]
	@init{
	}
	:
	id=IDENT COLON
		{
			cs = Aadl2F.createSubprogramCallSequence();
			cs.setLocationReference(this.getFilename(), id.getLine());
			cs.setName(id.getText());
		}
	LCURLY
	(spc=subprogram_call
			{
				cs.getOwnedCallSpecifications().add(spc);
			}
	)+
	RCURLY
	(LCURLY
	 (pa=property_association
	   {
	     cs.getOwnedPropertyAssociations().add(pa);
	   }
	 )+
	RCURLY
	)?
  (in_modes[cs]
  )?
	SEMI
;

subprogram_call returns [ CallSpecification sc]
	@init{
	}
	:
	id=IDENT COLON
	SUBPROGRAM cs=called_subprogram
		{
		  if (cs.getReferenceType() == ParserReferenceType.ProcessorSubprogramCallReference){
		    ProcessorCall pc = Aadl2F.createProcessorCall();
		    pc.setSubprogramAccessName(cs.getLabels()[0]);
		    sc = pc;
		    sc.setName(id.getText());
        sc.setLocationReference(this.getFilename(), id.getLine());		    
		  } else {
  			sc = Aadl2F.createSubprogramCall();
	   		sc.setName(id.getText());
  			sc.setLocationReference(this.getFilename(), id.getLine());
	   		cs.setReferencingObject(sc);
			   unresolvedReferences.add(cs);
			}
		}
	(LCURLY
	(pa = property_association
	 {
	   sc.getOwnedPropertyAssociations().add(pa);
	 }
	)+
	RCURLY
	)?
	SEMI
	;

called_subprogram returns [ReferenceRecord cs]
	@init{
		String contextLabel="";
		String pkgLabel = "";
		boolean processorProgram = false;
	}
	:
	(PROCESSOR DOT scId=IDENT
    {
        cs = new ReferenceRecord(ParserReferenceType.ProcessorSubprogramCallReference,
                                new String[]{scId.getText()}
                                );
    }
	)
	|
	(pkgId=IDENT DOUBLECOLON
	 {
	   pkgLabel = pkgId.getText();
	 }
	 (pkgId1=IDENT DOUBLECOLON
	   {
	     pkgLabel = pkgLabel+"::"+pkgId1.getText();
	   }
	 )*
	 (
	   (ctxId=IDENT DOT scId=IDENT
        {
         cs = new ReferenceRecord(ParserReferenceType.PackageAndContextSubprogramCallReference,
                                new String[]{pkgLabel,ctxId.getText(),scId.getText()}
                                );
        }
	   )
	   |
	   (scId=IDENT
        {
          cs = new ReferenceRecord(ParserReferenceType.PackageSubprogramCallReference,
                                new String[]{pkgLabel, scId.getText()}
                                );        
        }
	   )
	 )
	)
	|
	(ctxId=IDENT DOT scId=IDENT
    {
       cs = new ReferenceRecord(ParserReferenceType.ContextSubprogramCallReference,
                                new String[]{ctxId.getText(),scId.getText()}
                                );
    }
	)
	|
	(scId=IDENT
    {
        cs = new ReferenceRecord(ParserReferenceType.SubprogramCallReference,
                                new String[]{scId.getText()}
                                );
    }
	)
	;
	
//subprogram_call_sequence returns [CallSequence cs]
//        @init { 
//        	cs = Aadl2F.createCallSequence();
//        	//SubprogramSubcomponent spc = null;
//        	processComments(cs);
//        }:
//    ( id= IDENT COLON 
//    	{ cs.setName(id.getText()); }
//    )?
//    LCURLY ( spc=subprogram_call { cs.addCall(spc); }
//    )+ RCURLY
//    ( in_modes[cs] )? 
//	SEMI
//-------------------------------------------------------------------
//;

//subprogram_call returns [SubprogramSubcomponent spc]
//        @init { 
//        	spc=Aadl2F.createSubprogramSubcomponent();
//        	//Properties ps; 
//        }:
//    defcallid=IDENT COLON { spc.setName(defcallid.getText());}
//    SUBPROGRAM 
//    called_subprogram[spc]  
//	     { processComments(spc); }
////	( ps = curlyPropertyAssociations { spc.setProperties(ps);} )? 
//	SEMI 
////-------------------------------------------------------------------
//;
//called_subprogram [SubprogramSubcomponent sc]
//        //@init { ClassifierReference cr;}
//        :
//// 	data_identifier DOT data_subprogram_identifier | unique_subprogram_classifier_reference
//    cr = classifier_reference  { sc.setClassifierReference(cr); }
////-------------------------------------------------------------------
//;


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 8.2 Modes
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


//mode_subclause [ComponentImplementation ci ]
//@init {Modes ms=null;}:		
//    MODES  {  ms = Aadl2F.createModes(); ci.setModes(ms);  processComments(ms); }
////  (    (  mode[ms])* ( mode_transition [ms]  )*  
////  |  none_stmt )
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//mode [Modes ms]
//        @init { 
//        //Properties ps=null; 
//        Mode m = null;
//        boolean mstate_isInitial = false; 
//         }:
//     id=IDENT COLON 
//         { m = Aadl2F.createMode();
//         	  m.setName(id.getText());
//         	  m.setLocationReference(new LocationReference(this.getFilename(),id.getLine()));
//         	  ms.addMode(m);
//         	  processComments(m); }
//     ( INITIAL { mstate_isInitial = true;} )?
//     ( REFINED TO 
//        { m.setRefined(true);
//           RefinedReference fr = new RefinedReference(); 
//           fr.setRefinedName(id.getText()); 
//           fr.setFilename(this.getFilename());fr.setLine(id.getLine());
//           m.setRefinedReference(fr);  }
//     )?
//     MODE  
//     	{m.setInitial(mstate_isInitial);}
//	 ( ps = curlyPropertyAssociations {m.setProperties(ps);} )?
//     SEMI ;

mode returns [Mode mode]
        @init { 
        //Properties ps=null; 
         }:
     id=IDENT COLON 
		{ 
         	mode = Aadl2F.createMode();
         	mode.setInitial(false);
        	mode.setName(id.getText());
         	mode.setLocationReference(new LocationReference(this.getFilename(),id.getLine()));
       	  processComments(mode); 
		}
     ( INITIAL 
     	{ 
     		mode.setInitial(true);
     	} 
     )?

// mode refinement is gone     
//     ( REFINED TO 
//        { 
//        	//mode.setRefined(true);
//           	RefinedReference fr = new RefinedReference(); 
//           	fr.setRefinedName(id.getText()); 
//           	fr.setFilename(this.getFilename());
//           	fr.setLine(id.getLine());
//           	mode.setRefinedReference(fr);  
//        }
//     )?
     MODE  
    ( LCURLY
      (
        (pa=property_association
          {
            mode.getOwnedPropertyAssociations().add(pa);
          }
        ) 
      )+
      RCURLY
    )?  
     SEMI ;


//mode_transition [Modes ms]
//     	@init { 
//     	ModeTransition mt = Aadl2F.createModeTransition(); 
//     	ms.addModeTransition(mt);
//     	processComments(mt);
//     	 Vector il = new Vector();
//     	 //FeatureReference fr=null;
//     	 LocationReference lr=null;
//     	 ModeTransition cp;
//     	 }:
//     ( mtid=IDENT COLON  { mt.setName(mtid.getText());})?
//     id= IDENT { mt.setSrcModeName(id.getText()); }
////     ( COMMA moreid: IDENT
////     	{ il.add(moreid.getText());}
////     )*
//	 LTRANS fr=unique_port_identifier 
//	 	{ mt.addPortReference(fr); }
//	 ( COMMA fr= unique_port_identifier 
//	 	{ mt.addPortReference(fr); }
//	 )* RTRANS
//	 destination_mode=IDENT { mt.setDstModeName(destination_mode.getText());}
//	 			{  lr = new LocationReference(this.getFilename(),destination_mode.getLine());}
//	 			{ mt.setLocationReference(lr); }
//         { for ( int i = 0; i < il.size(); i++) {  cp = (ModeTransition)EcoreUtil.copy(mt); cp.setSrcModeName((String)il.get(i)); cp.setDstModeName(destination_mode.getText()); ms.addModeTransition(cp); Vector pp = mt.getPortReference(); for (int j = 0; j<pp.size();j++) cp.addPortReference((FeatureReference) pp.get(j)); }}
//     SEMI ;

mode_transition [ComponentClassifier cl] returns [ModeTransition mt]
   	@init { 
     	mt = Aadl2F.createModeTransition(); 
     	processComments(mt);
     	LocationReference lr=null;
     	ModeTransition cp;
   	 }
   	 :
     ( mtid=IDENT COLON  
     	{ 
     		mt.setName(mtid.getText());
     	}
     )?
     id= IDENT 
     	{
     	  mt.setLocationReference(this.getFilename(), id.getLine());
     	  ReferenceRecord mr = new ReferenceRecord(ParserReferenceType.SourceModeReference,
     	                                           mt,
     	                                           new String[]{id.getText()}
     	                                          ); 
     		unresolvedReferences.add(mr);
     	}
	 l=LTRANS fr=mode_transition_trigger  
	 	{
	 	   if (fr.getReferenceType() == ParserReferenceType.ModeTriggerFromSelfReference){
	 	     InternalEvent ie = Aadl2F.createInternalEvent();
	 	     ie.setLocationReference(this.getFilename(), l.getLine());
	 	     ie.setName(fr.getLabels()[0]);
	 	     mt.getTriggers().add(ie);
	 	     cl.getOwnedInternalEvents().add(ie);
	 	   } else if (fr.getReferenceType() == ParserReferenceType.ModeTriggerFromProcessorReference) {
	 	     ProcessorPort pp = Aadl2F.createProcessorPort();
	 	     pp.setLocationReference(this.getFilename(), l.getLine());
	 	     pp.setName(fr.getLabels()[0]);
	 	     mt.getTriggers().add(pp);
	 	     cl.getOwnedProcessorPorts().add(pp); 
	 	   } else {
	 	     TriggerPort tp = Aadl2F.createTriggerPort();
	 	     tp.setLocationReference(this.getFilename(), l.getLine());
	 	     mt.getTriggers().add(tp);
	 	     mt.getOwnedTriggers().add(tp);
         fr.setReferencingObject(tp);
         unresolvedReferences.add(fr);	 	     
	 	   }
	 	}
	 ( c=COMMA fr= mode_transition_trigger
	 	{ 
      if (fr.getReferenceType() == ParserReferenceType.ModeTriggerFromSelfReference){
         InternalEvent ie = Aadl2F.createInternalEvent();
         ie.setLocationReference(this.getFilename(), c.getLine());
         ie.setName(fr.getLabels()[0]);
         mt.getTriggers().add(ie);
         cl.getOwnedInternalEvents().add(ie);
       } else if (fr.getReferenceType() == ParserReferenceType.ModeTriggerFromProcessorReference) {
         ProcessorPort pp = Aadl2F.createProcessorPort();
         pp.setLocationReference(this.getFilename(), c.getLine());
         pp.setName(fr.getLabels()[0]);
         mt.getTriggers().add(pp);
         cl.getOwnedProcessorPorts().add(pp); 
       } else {
         TriggerPort tp = Aadl2F.createTriggerPort();
         tp.setLocationReference(this.getFilename(), c.getLine());
         mt.getTriggers().add(tp);
         mt.getOwnedTriggers().add(tp);
         fr.setReferencingObject(tp);
         unresolvedReferences.add(fr);         
       }
	 	}
	 )*  
	 RTRANS
	 destination_mode=IDENT 
	 	{ 
        ReferenceRecord mr = new ReferenceRecord(ParserReferenceType.DestinationModeReference,
                                                 mt,
                                                 new String[]{destination_mode.getText()}
                                                ); 
        unresolvedReferences.add(mr);
	 	}
    ( LCURLY
      (
        (pa=property_association
          {
            mt.getOwnedPropertyAssociations().add(pa);
          }
        ) 
      )+
      RCURLY
    )?  
     SEMI ;

mode_transition_trigger returns [ReferenceRecord rt]
  @init{
    boolean self=false;
    boolean processor = false;
    String ctx="";
  }
  :
  (
  (
    (SELF DOT
      {
       self = true; 
      }
    |PROCESSOR DOT
      {
        processor = true;
      }
    |ctxId = IDENT DOT
      {
        ctx = ctxId.getText();
      }
    )
    portId=IDENT
      {
      if (self){
        rt = new ReferenceRecord(ParserReferenceType.ModeTriggerFromSelfReference,
                                new String[]{portId.getText()}
                                );
      } else if (processor){
        rt = new ReferenceRecord(ParserReferenceType.ModeTriggerFromProcessorReference,
                                 new String[]{portId.getText()}
                                );
      } else {
        rt = new ReferenceRecord(ParserReferenceType.ModeTriggerFromSubcomponentOrFeatureGroupReference,
                                new String[]{ctx,portId.getText()}
                                );
      }
      }
  )
  |(portId = IDENT
    {
        rt = new ReferenceRecord(ParserReferenceType.ModeTriggerFromExternalPortReference,
                                new String[]{portId.getText()}
                                );
    }
  )
  )
  ;
  

//unique_port_identifier returns [ReferenceRecord cr]
//	@init{
//		cr = new FeatureReference();
//		boolean self=false;
//		boolean processor = false;
//		String compLabel = "";
//	}:
//	(
//   (SELF
//    {
//      self = true;
//    }
//	 )
//	 |(PROCESSOR
//	   {
//	     processor = true;
//	   }
//	 )
//	 |(compid=IDENT
//	   {
//	     compLabel = compid.getText();
//	   }
//	 )
//	)?
//	
//	// this can include both "self" and "processor" component id's
// 	compid=IDENT {cr.setCompName(compid.getText());}
// 	DOT portid=IDENT {cr.setFeatureName(portid.getText());cr.setFilename(this.getFilename());cr.setLine(portid.getLine());}
//   |
//   soleportid=IDENT {cr.setFeatureName(soleportid.getText());cr.setCompName("");cr.setFilename(this.getFilename());cr.setLine(soleportid.getLine());}
//  ;
  
 
// phf *** details for rule above: unique_port_identifier :
//    component_type_port_identifier
//	| subcomponent_identifier "." port_identifier
//  | component_type_port_group_identifier "." port_identifier


//in_modes [ModeMember mm]
//	@init { 
//		LocationReference lr=null;
//	}:
//    IN MODES
//    LPAREN 
//    ( 
//    	( m1=IDENT { mm.addModeName(m1.getText());}
//            {  lr = new LocationReference(this.getFilename(),m1.getLine());}
//            	{ mm.setLocationReference(lr);}
//    		( COMMA m2=IDENT { mm.addModeName(m2.getText());}
//    		)* 
//    	) 
//    	| NONE { mm.setNoMode(true); }
//    ) RPAREN;

component_in_modes [Subcomponent mm]
  @init { 
    LocationReference lr=null;
  }:
    IN MODES
    LPAREN 
    ( 
      ( m1=IDENT 
        {
          ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.InModesReference,
                                                   mm,
                                                   new String[]{m1.getText()}
                                                   );
          unresolvedReferences.add(rr); 
         }
        (ASSIGN om1=IDENT
          {
            ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.ModeMappingReference,
                                                mm,
                                                new String[]{m1.getText(), om1.getText()}
                                                );
            unresolvedReferences.add(rr); 
          }
        )?                                                   
        (COMMA m2=IDENT 
          { 
            ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.InModesReference,
                                                     mm,
                                                     new String[]{m2.getText()}
                                                     );
            unresolvedReferences.add(rr); 
          }
          (ASSIGN om2=IDENT
            {
              ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.ModeMappingReference,
                                                  mm,
                                                  new String[]{m2.getText(), om2.getText()}
                                                  );
              unresolvedReferences.add(rr); 
            }
          )?                                                   
        )* 
      ) 
      |(ALL
        {
          mm.setAllModes(true);
        }
      )
    ) RPAREN
    ;
    
in_modes [ModalElement mm]
	@init { 
		LocationReference lr=null;
	}:
    IN MODES
    LPAREN 
    ( 
      ( m1=IDENT 
        {
          ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.InModesReference,
                                                   mm,
                                                   new String[]{m1.getText()}
                                                   );
          unresolvedReferences.add(rr); 
         }                                                   
        (COMMA m2=IDENT 
          { 
            ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.InModesReference,
                                                     mm,
                                                     new String[]{m2.getText()}
                                                     );
            unresolvedReferences.add(rr); 
          }
        )* 
    	) 
    ) RPAREN
    ;
    
in_modes_and_transitions [ModalElement mm]:
    IN MODES
    LPAREN ( 
    	( mode_or_transition[mm] 
    		( COMMA mode_or_transition[mm] )* 
    	) 
    ) RPAREN // extra parens
;

mode_or_transition [ModalElement mm]
	@init { 
		LocationReference lr=null;
	}:
    mode_id= IDENT 
    	{
    	   ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.ModeOrTransitionReference,
    	                                                               mm,
    	                                                               new String[]{mode_id.getText()}
    	                                                               );
    	   unresolvedReferences.add(rr);
         lr = new LocationReference(this.getFilename(),mode_id.getLine());
         mm.setLocationReference(lr);
		}
;




//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 9 FEATURES AND SHARED ACCESS
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

// specific features are called in category specific provides clauses
//feature :
//    port_spec | server_subprogram | subprogram_spec |
//    subcomponent_access ;
// phf: the subrules are used selectively

//feature_refinement returns [Feature ft=null]:
//    ft = port_refinement |
//    ft = server_subprogram_refinement | ft = data_subprogram_refinement |
//    ft = subcomponent_access_refinement 
//    ;
// phf: refines is handled as part of the regular rule
			
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 9.1 Ports
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

data_port [boolean extension] returns [DataPort dp]
	@init{
		DirectionType dt=null;
		boolean refinement=false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
			refinement=true;
		}
	)?
	((IN OUT)
		{
			dt = DirectionType.IN_OUT;
		}
	| OUT
		{
			dt = DirectionType.OUT;
		}
	| IN
		{
			dt = DirectionType.IN;
		}
	)
	(DATA PORT
		{
			dp = Aadl2F.createDataPort();
			dp.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			dp.setLocationReference(lr);
			dp.setDirection(dt);
			if (refinement){
			  ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.PortRefinementReference,
			                                               dp,
			                                               new String[]{id.getText()}
			                                               );
			  unresolvedReferences.add(refref);
			}
		}
			
		(cr=classifier_reference
			{
			  if(cr.getLabels().length > 1){
          cr.setReferenceType(ParserReferenceType.PortClassifierReference);
			  } else {
          cr.setReferenceType(ParserReferenceType.PortPrototypeOrClassifierReference);
			  }
			  cr.setReferencingObject(dp);
			  unresolvedReferences.add(cr);
			}
		)?
	(ad=array_dimension
	 {
	   dp.setArraySpecification(ad);
	 }
	)?
	)
	(LCURLY
	 (pa=property_association
	   {
	     dp.getOwnedPropertyAssociations().add(pa);
	   }
	 )+
	 RCURLY
	)?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
		
event_data_port [boolean extension] returns [EventDataPort edp]
	@init{
		DirectionType dt=null;
		boolean refinement=false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
			refinement=true;
		}
	)?
	((IN OUT)
		{
			dt = DirectionType.IN_OUT;
		}
	| OUT
		{
			dt = DirectionType.OUT;
		}
	| IN
		{
			dt = DirectionType.IN;
		}
	)
	(EVENT DATA PORT
		{
			edp = Aadl2F.createEventDataPort();
			edp.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			edp.setLocationReference(lr);
			edp.setDirection(dt);
			if (refinement){
        ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.PortRefinementReference,
                                                     edp,
                                                     new String[]{id.getText()}
                                                     );
        unresolvedReferences.add(refref);
			}
		}
			
		(cr=classifier_reference
			{
			  if (cr.getLabels().length>1){
          cr.setReferenceType(ParserReferenceType.PortClassifierReference);
			  } else {
          cr.setReferenceType(ParserReferenceType.PortPrototypeOrClassifierReference);
			  }
        cr.setReferencingObject(edp);
        unresolvedReferences.add(cr);
			}
		)?
	)
    (ad=array_dimension
   {
     edp.setArraySpecification(ad);
   }
  )?
  (LCURLY
   (pa=property_association
     {
       edp.getOwnedPropertyAssociations().add(pa);
     }
   )+
   RCURLY
  )?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

event_port [boolean extension] returns [EventPort ep]
	@init{
		DirectionType dt=null;
		boolean refinement=false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
			refinement=true;
		}
	)?
	((IN OUT)
		{
			dt = DirectionType.IN_OUT;
		}
	| OUT
		{
			dt = DirectionType.OUT;
		}
	| IN
		{
			dt = DirectionType.IN;
		}
	)
	(EVENT PORT
		{
			ep = Aadl2F.createEventPort();
			ep.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			ep.setLocationReference(lr);
			ep.setDirection(dt);
			if (refinement){
			  ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.PortRefinementReference,
                                                     ep,
                                                     new String[]{id.getText()}
                                                     );
        unresolvedReferences.add(refref);
			}
		}
	)
  (ad=array_dimension
   {
     ep.setArraySpecification(ad);
   }
  )?
  (LCURLY
   (pa=property_association
     {
       ep.getOwnedPropertyAssociations().add(pa);
     }
   )+
   RCURLY
  )?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

//port_spec returns[PortFeature prt]
//	@init {
//		//Port prtr=null;
//		prt=null;
//		//Properties ps; 
//		PortDirection pd = null; 
//	}:
//     ( IN OUT { pd = PortDirection.INOUT_LITERAL; }
//     | IN { pd = PortDirection.IN_LITERAL; }
//     | OUT { pd = PortDirection.OUT_LITERAL; }
//     ) 
//     prtr = port_type 
//           { 
//           	prt=prtr;
//	        prt.setDirection(pd);   
//	   }
////	 ( ps = curlyPropertyAssociations_no_modes  { prt.setProperties(ps);} )?
//	 SEMI ;
	 
//port_type returns [PortFeature pt]
//	@init { 
//		pt = null;
//		//ClassifierReference cr = null;
//	}:
//    (EVENT DATA PORT { pt = Aadl2F.createEventDataPort();processComments(pt);}
//        ( cr = classifier_reference {pt.setClassifierReference(cr);})?
//    ) 
//    |
//    (DATA PORT { pt = Aadl2F.createDataPort();processComments(pt);}
//        ( cr = classifier_reference {pt.setClassifierReference(cr);})?
//    ) 
//    | 
//    (EVENT PORT   { pt = Aadl2F.createEventPort();processComments(pt);}
//    ) 
//    ;
    

//subprogramPort returns [PortFeature ep]
//       @init {
//       	ep=null;
//       	//Properties ps; 
//       	//ClassifierReference cr = null; 
//       }:
//      (  OUT  EVENT PORT 
//           { ep = Aadl2F.createEventPort(); ep.setDirection(PortDirection.OUT_LITERAL);processComments(ep);}
//     | OUT EVENT DATA PORT ( cr = classifier_reference )?
//           { ep = Aadl2F.createEventDataPort();  processComments(ep); }
//           { ep.setDirection(PortDirection.OUT_LITERAL); ep.setClassifierReference(cr);}
//     )
////	 ( ps = curlyPropertyAssociations_no_modes { ep.setProperties(ps);}  )?
//	 SEMI
////-------------------------------------------------------------------
//;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 9.2 Subprograms
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//data_subprogram returns [Subprogram sb]
//	@init {
//		sb=Aadl2F.createSubprogram();
//		//Properties ps; 
//		//ClassifierReference cr; 
//		processComments(sb);
//	}:
//     SUBPROGRAM
//	 ( cr = classifier_reference {sb.setClassifierReference(cr);} )?
////	 (ps = curlyPropertyAssociations_no_modes { sb.setProperties(ps);})?
//	  SEMI
////-------------------------------------------------------------------
//;

//server_subprogram returns [ServerSubprogram sp]
//        @init {
//        	sp= Aadl2F.createServerSubprogram();
//        	//Properties ps; 
//        	//ClassifierOrFeatureReference cr; 
//        	processComments(sp);
//        }:
//     SERVER 
//     SUBPROGRAM
//	 ( cr = unique_subprogram_reference {sp.setClassifierOrFeatureReference(cr);} )?
////	 (ps = curlyPropertyAssociations_no_modes { sp.setProperties(ps);})?
//	 SEMI
////-------------------------------------------------------------------
//;


//unique_subprogram_reference returns [ClassifierOrFeatureReference cr]
//	@init {
//		cr = new ClassifierOrFeatureReference();
//		String pn = "";
//	}:
//	 ( pid= IDENT DOUBLECOLON 
//	 		{ pn = pn +(pn.length() == 0 ? "":"::")+pid.getText();}
//	 )* 
//	 {
//	 	if (pn.length() > 0) {
//		 	cr.setPackageName(pn);
//		 	referencedPackages.add(pn);
//	 	}
//	 }
//	 tid=IDENT {cr.setClassifierName(tid.getText()); cr.setFilename(this.getFilename());cr.setLine(tid.getLine());}
//	( DOT iid=IDENT 
//			{ cr.setClassifierName(tid.getText()+"."+iid.getText());}
//	)?
//    ;


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 9.3 Component Parameters
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

parameter [boolean extension] returns [ Parameter p ]
       @init {
    		DirectionType dt=null;
    		boolean refinement=false;
        ReferenceRecord rr = null;
       }
       :
 	id=IDENT COLON
 	(REFINED TO
 		{
 			if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
 			refinement=true;
 		}
 	)?
     ( (IN OUT 
     		{ 
     			dt = DirectionType.IN_OUT;
     			//p.setDirection(DirectionType.IN_OUT); 
     		}
     	)
     | (IN 
     		{ 
     			dt = DirectionType.IN;
     			//p.setDirection(DirectionType.IN); 
     		}
     	)
     | (OUT 
     		{ 
     			dt = DirectionType.OUT;
     			//p.setDirection(DirectionType.OUT); 
     		}
     	)
     ) 
     PARAMETER
     	{
	       	p = Aadl2F.createParameter();
	       	p.setName(id.getText());
	       	p.setLocationReference(this.getFilename(),id.getLine());
	       	p.setDirection(dt);
       		//Properties ps; 
       		//ClassifierReference cr; 
       		processComments(p);
       		if (refinement){
       		    rr = new ReferenceRecord(ParserReferenceType.ParameterRefinementReference,
       		                                                               p,
       		                                                               new String[]{id.getText()}
       		                                                               ); 
            unresolvedReferences.add(rr);
       		}
     	}
	 ( cr = classifier_reference 
	 	{
	 	   if (cr.getLabels().length>1){
	 	     cr.setReferenceType(ParserReferenceType.ParameterClassifierReference);
	 	   } else {
	        cr.setReferenceType(ParserReferenceType.ParameterPrototypeOrClassifierReference);
 	     
	 	   }
	 	   cr.setReferencingObject(p);
	 	   unresolvedReferences.add(cr);
	 	} 
	 )?
  (ad=array_dimension
   {
     p.setArraySpecification(ad);
   }
  )?
  (LCURLY
   (pa=property_association
     {
       p.getOwnedPropertyAssociations().add(pa); 
     }
   )+
   RCURLY
  )?
	 SEMI
//-------------------------------------------------------------------
;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 9.4 Subcomponent Acess
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//dataAccess [AccessType d] returns [DataAccess da]
//	@init {
//		da=null;
//		//Properties ps; 
//		//ClassifierReference cr; 
//	}:
//  DATA ACCESS 
//    { 
//        da = Aadl2F.createDataAccess();  
//        da.setKind(d);processComments(da);
//    }
// ( cr = classifier_reference 
//      {
//          cr.setReferencingObject(da);
//          cr.setReferenceType(ParserReferenceType.ClassifierReference);
//          unresolvedReferences.add(cr);
//      }
//  )?
////	 ( ps = curlyPropertyAssociations_no_modes  { da.setProperties(ps);} )?
//	 SEMI
////-------------------------------------------------------------------
//;

data_access [boolean extension] returns [DataAccess da]
	@init{
		AccessType accessType = null;
		boolean refinement = false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
			refinement=true;
		}
	)?
	(	PROVIDES DATA ACCESS
			{
				accessType=AccessType.PROVIDED;
			}
	| 	REQUIRES DATA ACCESS
			{
				accessType = AccessType.REQUIRED;
			}
	)	
		{
			da = Aadl2F.createDataAccess();
			da.setCategory(AccessCategory.DATA);
			da.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			da.setLocationReference(lr);
			if (accessType != null)
			   da.setKind(accessType);
			if (refinement){
			   ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.AccessFeatureRefinementReference,
			                                            da,
			                                            new String[]{id.getText()}
			                                            );
        unresolvedReferences.add(rr);
			}
		}
	
	(cr=classifier_reference
		{
		  if (cr.getLabels().length >1){
		    cr.setReferenceType(ParserReferenceType.AccessFeatureClassifierReference);
		   } else {
		    cr.setReferenceType(ParserReferenceType.AccessFeaturePrototypeOrClassifierReference);
		   }
		  cr.setReferencingObject(da);
		  unresolvedReferences.add(cr);
		}
	)?
  (ad=array_dimension
   {
     da.setArraySpecification(ad);
   }
  )?
  (LCURLY
   (pa=property_association
     {
       da.getOwnedPropertyAssociations().add(pa);
     }
   )+
   RCURLY
  )?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
	
bus_access [boolean extension] returns [BusAccess ba]
	@init{
		boolean provides=false;
		boolean refinement=false;
		AccessType accessType=null;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
			refinement=true;
		}
	)?
	((	(PROVIDES BUS ACCESS
			{
					accessType = AccessType.PROVIDED;
			}
		)
	
	|	(REQUIRES BUS ACCESS
			{
				accessType = AccessType.REQUIRED;
			}
		)
	)
		{
			ba=Aadl2F.createBusAccess();
			ba.setCategory(AccessCategory.BUS);
			ba.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			ba.setLocationReference(lr);
			if (accessType != null)
			  ba.setKind(accessType);
			if (refinement){
			  ReferenceRecord refr= new ReferenceRecord(ParserReferenceType.AccessFeatureRefinementReference,
			                                           ba,
			                                           new String[]{id.getText()}
			                                           );
        unresolvedReferences.add(refr);			                                           
			}
		}
	)
	(cr=classifier_reference
		{
      if (cr.getLabels().length >1){
        cr.setReferenceType(ParserReferenceType.AccessFeatureClassifierReference);
       } else {
        cr.setReferenceType(ParserReferenceType.AccessFeaturePrototypeOrClassifierReference);
       }
		  cr.setReferencingObject(ba);
		  unresolvedReferences.add(cr);
		}
	)?
  (ad=array_dimension
   {
     ba.setArraySpecification(ad);
   }
  )?
  (LCURLY
   (pa=property_association
     {
       ba.getOwnedPropertyAssociations().add(pa);
     }
   )+
   RCURLY
  )?

	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

//busAccess [AccessType d] returns [BusAccess ba]
//	@init {
//		 ba=null;
//		 //Properties ps;
//		 //ClassifierReference cr; 
//	}:
//     BUS ACCESS 
//         { ba = Aadl2F.createBusAccess();  ba.setKind(d);processComments(ba);}
//     ( cr = classifier_reference 
//          {
//            cr.setReferencingObject(ba);
//            cr.setReferenceType(ParserReferenceType.ClassifierReference);
//            unresolvedReferences.add(cr);
//           } 
//    )?
////	 ( ps = curlyPropertyAssociations_no_modes { ba.setProperties(ps);} )?
//	 SEMI
////-------------------------------------------------------------------
//;

//subcomponent_access returns [Feature fe]
//	@init{
//		fe=null;
//	}:
//	(
//    REQUIRES fer1 = dataAccess[AccessType.REQUIRED] {fe=fer1;}
//    | REQUIRES fer2 = busAccess[AccessType.REQUIRED] {fe=fer2;}
//    | PROVIDES fer3 = dataAccess[AccessType.PROVIDED] {fe=fer3;}
//    | PROVIDES fer4 = busAccess[AccessType.PROVIDED] {fe=fer4;}
//    | spa = subprogram_access[false] {fe=spa;}
//    )
//    
//    ;
//-------------------------------------------------------------------
 
subprogram_access [boolean extension] returns [ SubprogramAccess sa ]
	@init{
		AccessType accessType = null;
		boolean refinement=false;
	}
	:
	id= IDENT COLON 
	(REFINED TO
		{
      if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
			refinement=true;
		}
	)?
	(	(PROVIDES SUBPROGRAM ACCESS
			{
				accessType = AccessType.PROVIDED;
			}
		)
	 	|(REQUIRES SUBPROGRAM ACCESS
	 		{
	 			accessType = AccessType.REQUIRED;
	 		}
	 	) 
	 ) 	
		{
			sa = Aadl2F.createSubprogramAccess();
			sa.setCategory(AccessCategory.SUBPROGRAM);
			sa.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			sa.setLocationReference(lr);
			if (accessType != null)
			 sa.setKind(accessType);
			if (refinement){
			  ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.AccessFeatureRefinementReference,
			                                           sa,
			                                           new String[]{id.getText()}
			                                           );
        unresolvedReferences.add(rr);
			}
		}
	( cr=classifier_reference 
		{
      if (cr.getLabels().length >1){
        cr.setReferenceType(ParserReferenceType.AccessFeatureClassifierReference);
       } else {
        cr.setReferenceType(ParserReferenceType.AccessFeaturePrototypeOrClassifierReference);
       }
		  cr.setReferencingObject(sa);
		  unresolvedReferences.add(cr);
		}
	)?
  (ad=array_dimension
   {
     sa.setArraySpecification(ad);
   }
  )?
  (LCURLY
   (pa=property_association
     {
       sa.getOwnedPropertyAssociations().add(pa);
     }
   )+
   RCURLY
  )?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       

subprogram_group_access [boolean extension] returns [SubprogramGroupAccess sga]
	@init{
		AccessType accessType = null;
		boolean refinement=false;
	}
	:
	id=IDENT COLON
	(REFINED TO
		{
			if (!extension){
          throw new FailedPredicateException(input,"feature ", "refinement only allowed in extension");
      }
			refinement=true;
		}
	)?
	( 	PROVIDES SUBPROGRAM GROUP ACCESS
			{
			  accessType = AccessType.PROVIDED;
			}
	| 	REQUIRES SUBPROGRAM GROUP ACCESS
			{
				accessType = AccessType.REQUIRED;
			}
	)
	
		{
			sga = Aadl2F.createSubprogramGroupAccess();
			sga.setCategory(AccessCategory.SUBPROGRAM_GROUP);
			sga.setName(id.getText());
			LocationReference lr = new LocationReference();
			lr.setFilename(this.getFilename());
			lr.setLine(id.getLine());
			sga.setLocationReference(lr);
			if (accessType != null)
			 sga.setKind(accessType);
			if (refinement){
			  ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.AccessFeatureRefinementReference,
			                                           sga,
			                                           new String[]{id.getText()}
			                                           );
			  unresolvedReferences.add(rr);
			}
		}
	( cr = classifier_reference
		{
      if (cr.getLabels().length >1){
        cr.setReferenceType(ParserReferenceType.AccessFeatureClassifierReference);
       } else {
        cr.setReferenceType(ParserReferenceType.AccessFeaturePrototypeOrClassifierReference);
       }
		  cr.setReferencingObject(sga);
		  unresolvedReferences.add(cr);
		}
	)?
  (ad=array_dimension
   {
     sga.setArraySpecification(ad);
   }
  )?
  (LCURLY
   (pa=property_association
     {
       sga.getOwnedPropertyAssociations().add(pa);
     }
   )+
   RCURLY
  )?
	SEMI
	;
  catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input,SEMI);
    input.consume();
  }       
	

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 9.5 Port Groups
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//port_group_type returns [FeatureGroupType pg]
//   @init { 
//   	pg=Aadl2F.createFeatureGroupType();
//   	PortGroupFeatures pgf=null;
//   	//AnnexSubclause ax; 
//   	//Properties ps; 
//   	//ClassifierReference pgr;
//   	boolean refined = false; 
//   	Feature fs =null;
//   	RefinedReference fr;
//   }:
//    PORT GROUP defid=IDENT { 
//    	pg.setName(defid.getText());
//    	pg.setLocationReference(this.getFilename(),defid.getLine());
//    	processComments(pg);
//    	}
//    ( EXTENDS epg = unique_type_name 
//            {pg.setExtendedClassifierReference(epg);}
//    )?
//	(( 
//	  FEATURES
//	  		{  pgf = Aadl2F.createPortGroupFeatures();
//	  			pg.setFeatures(pgf);
//	  		}
//	    ( 
//             id= IDENT 
//             COLON 
//             ( REFINED TO { refined = true; } )?
//	         (	
//	         	fs1 = port_spec {fs=fs1;} 
//	         	| fs2 = port_group_spec {fs=fs2;}
//	         )
//                { 
//                	fs.setName(id.getText()); 
//                	fs.setLocationReference(new LocationReference(this.getFilename(),id.getLine()));
//                	fs.setRefined(refined); 
//                    if (refined){
//                    		 fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//                    		fs.setRefinedReference(fr);
//                    		fr.setFilename(this.getFilename());fr.setLine(id.getLine());
//                    		refined = false; }
//                	pgf.addPortGroupElement(fs);
//                }
//	     )*
//	  ( INVERSE OF pgr= unique_type_name { pg.setInverseClassifierReference(pgr);}
//	   )?
//	)
//	|
//	( INVERSE OF pgr= unique_type_name { pg.setInverseClassifierReference(pgr);} 
//	))
////	( ps = propertyAssociations_no_modes { pg.setProperties(ps); } )?
//	( ax = annex_subclause { pg.addAnnexSubclause(ax); } )?
//	END id2=IDENT SEMI
//  { if (!( defid.getText().equalsIgnoreCase(id2.getText()) )) 
//  	//throw new SemanticException("Port group type name "+defid.getText()+" does not match "+id2.getText(), getFilename(),id2.getLine(), id2.getCharPositionInLine());}
//  	throw new FailedPredicateException(input,"port group type","Port group type name "+defid.getText()+" does not match "+id2.getText());}
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,END);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

//port_group_spec returns [FeatureGroup pg]
//        @init {
//        	pg=Aadl2F.createFeatureGroup();
//        	//ClassifierReference pgt; 
//        	//Properties ps; 
//        	processComments(pg);
//        }:
//    PORT GROUP
//    ( pgt = unique_type_name { pg.setClassifierReference(pgt);} )?
////    ( ps = curlyPropertyAssociations_no_modes { pg.setProperties(ps);} )?
//    SEMI
////-------------------------------------------------------------------
//;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@ Section 10 CONNECTIONS
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//connectionsSubclause [ComponentImplementation ci]
//@init {Connections cns =null;}:		
//     CONNECTIONS  
//       {  cns = Aadl2F.createConnections(); ci.setConnections(cns);processComments(cns);}
////			(( connection[cns] | connection_refinement[cns] )+ | ( none_stmt ))
//	;

connection [boolean extension] returns [Connection conn]
	:
		(
			(pconn=port_connection[extension]
				{
					conn = pconn;
				}
			) 	
		 	|(pgconn = feature_group_connection[extension] 
		 		{
		 			conn = pgconn;
		 		}
		 	)
		 	|(pmconn = parameter_connection[extension] 
		 		{
		 			conn = pmconn;
		 		}
		 	)
		 	|( aconn = access_connection[extension]
		 	  {
		 	    conn = aconn;
		 	  }
		 	)
			|( fconn = feature_connection[extension]
			 {
			   conn = fconn;
			 }
			)
			
		)
	;
    catch [RecognitionException ex] {
    	reportError(ex);
		consumeUntil(input,SEMI);
		input.consume();
    }

	
//connection [Connections cns] 
//	@init {
//	//Properties ps=null; 
//	Connection cn=null; 
//	String cname=null;
//	}:
//     ( id=IDENT COLON  { cname = id.getText();})?
//     ( cn1 = data_connection { cn = cn1; cns.addDataConnection((DataConnection)cn);}
//	 | cn2 = event_data_connection { cn = cn2; cns.addEventDataConnection((EventDataConnection)cn);}
//	 | cn3 = event_connection { cn = cn3; cns.addEventConnection((EventConnection)cn);}
//	 | cn4 = port_group_connection { cn = cn4; cns.addPortGroupConnection((FeatureGroupConnection)cn);}
//	 | cn5 = parameter_connection { cn = cn5; cns.addParameterConnection((ParameterConnection)cn);}
//	 | cn6 = bus_access_connection { cn = cn6; cns.addBusAccessConnection((BusAccessConnection)cn);}
//	 | cn7 = data_access_connection { cn = cn7; cns.addDataAccessConnection((DataAccessConnection)cn);}
//	 )
//	     { processComments(cn);}
//	    { if (cname != null) cn.setName(cname); }
//	 ( ps = curlyPropertyAssociations { cn.setProperties(ps);} )?
// 	 ( in_modes_and_transitions[cn] )? SEMI
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

feature_connection [boolean extension] returns [FeatureConnection fc]
  @init{
    String srcContextLabel="";
    String dstContextLabel="";
    boolean bidirectional = false;
    boolean refinement = false;
    String idString="";
  }
  :
  (connid=IDENT COLON
    {
      idString = connid.getText();
    }
  )?
  (REFINED TO
    {
       //refinement only allowed in extensions
       if (!extension){
        throw new FailedPredicateException(input, "port connection", "refinement only allowed in extensions");
       }
       if (idString.length() == 0){
        throw new FailedPredicateException(input, "port connection", "refinement requires a name");
       }
      refinement = true;
    }
  )?
  (srcCtxId=IDENT DOT
    { 
      srcContextLabel = srcCtxId.getText();
    }
  )?
  srcid=IDENT
  (ARROW 
  |(BARROW
      {
        bidirectional = true;
      }
    )
  )
  (dstCtxId = IDENT DOT
    {
      dstContextLabel = dstCtxId.getText();
    }
  )?
  dstid=IDENT
  {
    fc = Aadl2F.createFeatureConnection();
    fc.setLocationReference(this.getFilename(), srcid.getLine());
    fc.setName(idString);
    fc.setBidirectional(bidirectional);
    fc.setKind(ConnectionKind.FEATURE);
    if (srcContextLabel.length() > 0){
      ReferenceRecord srcContextReference = new ReferenceRecord(ParserReferenceType.FeatureConnectionSourceContextReference,
                                                                fc,
                                                                new String[]{srcContextLabel}
                                                                );
      unresolvedReferences.add(srcContextReference);                                                               
    }
    if (dstContextLabel.length() >0){
      ReferenceRecord dstContextReference = new ReferenceRecord(ParserReferenceType.FeatureConnectionDestinationContextReference,
                                                                fc,
                                                                new String[]{dstContextLabel}
                                                                );
      unresolvedReferences.add(dstContextReference);                                                                
    }
    
    ReferenceRecord srcReference = new ReferenceRecord(ParserReferenceType.FeatureConnectionSourceReference,
                                                       fc,
                                                        new String[]{srcid.getText()}
                                                       );
    unresolvedReferences.add(srcReference);
                                                           
    ReferenceRecord dstReference = new ReferenceRecord(ParserReferenceType.FeatureConnectionDestinationReference,
                                                       fc,
                                                       new String[]{dstid.getText()}
                                                       );
    unresolvedReferences.add(dstReference);
    if (refinement){
      ReferenceRecord refRef = new ReferenceRecord(ParserReferenceType.ConnectionRefinementReference,
                                                   fc,
                                                   new String[]{idString}
                                                   );
      unresolvedReferences.add(refRef);                                                  
    }                                                             
  }
    ( LCURLY 
      (pa = property_association
        {
          fc.getOwnedPropertyAssociations().add(pa);
        }
      )+ 
      RCURLY
    )?
    ( in_modes_and_transitions[fc]
    )?
   SEMI
  ;

port_connection_port_association [boolean extension, boolean refinement, PortConnection dc]
  @init{
    boolean srcSelf = false;
    boolean srcProcessor = false;
    boolean dstSelf = false;
    boolean dstProcessor = false;
  }
  :
   (
    (
     (SELF
       {
        srcSelf= true;
       }
     )
     |(PROCESSOR
       {
        srcProcessor = true;
       }
     )
     |(srcCtxId=IDENT
       {
           ReferenceRecord cref = new ReferenceRecord(ParserReferenceType.PortConnectionSourceContextReference,
                                                      dc,
                                                      new String[]{srcCtxId.getText()}
                                                      );
          unresolvedReferences.add(cref);
        }
     )
     )
     DOT
   )?
   srcportid=IDENT
     {
         if (srcProcessor){
          ProcessorPort srcProcPort = Aadl2F.createProcessorPort();
          srcProcPort.setLocationReference(this.getFilename(), srcportid.getLine());
          srcProcPort.setName(srcportid.getText());
          dc.setSource(srcProcPort);
         } else if (srcSelf){
          InternalEvent ie = Aadl2F.createInternalEvent();
          ie.setLocationReference(this.getFilename(), srcportid.getLine());
          ie.setName(srcportid.getText());
          dc.setSource(ie);
         } else {
           ReferenceRecord pref = new ReferenceRecord(ParserReferenceType.PortConnectionSourcePortReference,
                                                    dc,
                                                    new String[]{srcportid.getText()}
                                                   );
          unresolvedReferences.add(pref);
        }
     }
   ( ARROW 
   | BARROW 
    {
     dc.setBidirectional(true); 
    }
   ) 
    (
     (
     (SELF
       {
        dstSelf = true;
       }
     )
     |(PROCESSOR
       {
        dstProcessor = true;
       }
     )
     |(dstCtxId=IDENT
       {
         ReferenceRecord cref = new ReferenceRecord(ParserReferenceType.PortConnectionDestinationContextReference,
                                                    dc,
                                                    new String[]{dstCtxId.getText()}
                                                    );
        unresolvedReferences.add(cref);
       }
     )
     )
     DOT
   )?
   dstportid=IDENT
     {
      if (dstSelf){
        InternalEvent ie = Aadl2F.createInternalEvent();
        ie.setLocationReference(this.getFilename(), dstportid.getLine());
        ie.setName(dstportid.getText());
        dc.setDestination(ie);
      } else if (dstProcessor) {
        ProcessorPort pp = Aadl2F.createProcessorPort();
        pp.setLocationReference(this.getFilename(), dstportid.getLine());
        pp.setName(dstportid.getText());
        dc.setDestination(pp);      
      } else {
         ReferenceRecord pref = new ReferenceRecord(ParserReferenceType.PortConnectionDestinationPortReference,
                                                    dc,
                                                    new String[]{dstportid.getText()}
                                                   );
          unresolvedReferences.add(pref);
        }
     }
  ;
    
port_connection [boolean extension] returns [PortConnection dc]
   @init { 
      	//FeatureReference cr;
      boolean refinement = false;
      boolean self=false;
      boolean processor=false;
      String srcContext = "";
      String idString="";
   }:
	 (id=IDENT COLON
	   {
	     idString = id.getText();
	   }
	 )?
	 (
	 REFINED TO
	   {
	     //refinement only allowed in extensions
	     if (!extension){
        throw new FailedPredicateException(input, "port connection", "refinement only allowed in extensions");
	     }
	     if (idString.length() == 0){
        throw new FailedPredicateException(input, "port connection", "refinement requires a name");
	     }
	     refinement=true;
	   }
   (lbl= PORT 
    { 
      dc=Aadl2F.createPortConnection();
      dc.setName(idString);
      dc.setLocationReference(this.getFilename(),lbl.getLine());
      dc.setKind(ConnectionKind.PORT);
      if (refinement){
        ReferenceRecord rref = new ReferenceRecord(ParserReferenceType.ConnectionRefinementReference,
                                                   dc,
                                                   new String[]{idString}
                                                  );
        unresolvedReferences.add(rref);
      }
    }
    (port_connection_port_association[extension, refinement, dc]
    )?	   
	 )
	 |
	 (lbl= PORT 
    { 
      dc=Aadl2F.createPortConnection();
      dc.setName(idString);
      dc.setLocationReference(this.getFilename(),lbl.getLine());
      dc.setKind(ConnectionKind.PORT);
      if (refinement){
        ReferenceRecord rref = new ReferenceRecord(ParserReferenceType.ConnectionRefinementReference,
                                                   dc,
                                                   new String[]{idString}
                                                  );
        unresolvedReferences.add(rref);
      }
    }
	 port_connection_port_association[extension, refinement, dc]
	 )
	 )
			{
				processComments(dc);
				dc.setName(idString);
			}
		( LCURLY 
			(pa = property_association
				{
					dc.getOwnedPropertyAssociations().add(pa);
				}
			)+ 
		  RCURLY
		)?
		( in_modes_and_transitions[dc]
		)?
	SEMI
;

//data_connection returns [PortConnection dc]
//        @init { 
//        	dc=Aadl2F.createPortConnection();
//        	//FeatureReference cr; 
//        }:
//	 id=IDENT COLON
//	 lbl= PORT cr = unique_port_identifier
//	 	{ dc.setLocationReference(this.getFilename(),lbl.getLine());}
//	    { dc.setSourceFeatureReference(cr);}
//	 ( ARROW 
//	 	{ 
//	 		//dc.setTiming(ConnectionTiming.IMMEDIATE_LITERAL);
//	 	}
//	 | DARROW 
//	 	{ 
//	 		//dc.setTiming(ConnectionTiming.DELAYED_LITERAL);
//	 	}
//	 ) cr = unique_port_identifier
//	    { dc.setDestinationFeatureReference(cr);}
//			{
//				processComments(dc);
//				dc.setName(id.getText());
//			}
////		( LCURLY 
////			(pa = property_association
////				{
////					//conn.getOwnedPropertyAssociations().add(pa);
////				}
////			)+ 
////		  RCURLY
////		)?
//		( in_modes_and_transitions[dc]
//		)?
//	SEMI
//;

//event_connection returns [PortConnection ec]
//        @init { 
//        	ec=Aadl2F.createPortConnection();
//        	ec.setKind(ConnectionKind.PORT);
//        	//FeatureReference cr; 
//        }:
//	 id=IDENT COLON
//	 lbl= PORT cr = unique_port_identifier
//	 	{ ec.setLocationReference(this.getFilename(),lbl.getLine());}
//	     { ec.setSourceFeatureReference(cr);}
//	 ARROW 	 cr = unique_port_identifier
//	     { ec.setDestinationFeatureReference(cr);}
//			{
//				processComments(ec);
//				ec.setName(id.getText());
//			}
////		( LCURLY 
////			(pa = property_association
////				{
////					//conn.getOwnedPropertyAssociations().add(pa);
////				}
////			)+ 
////		  RCURLY
////		)?
//		( in_modes_and_transitions[ec]
//		)?
//	SEMI
////-------------------------------------------------------------------
//;


//event_data_connection returns [PortConnection edc]
//        @init { 
//        	edc=Aadl2F.createPortConnection();
//        	edc.setKind(ConnectionKind.PORT);
//        	//FeatureReference cr; 
//        }:
//	 id=IDENT COLON
//	 lbl= PORT cr = unique_port_identifier
//	 	{ edc.setLocationReference(this.getFilename(),lbl.getLine());}
//	     { edc.setSourceFeatureReference(cr);}
//	 ARROW 	 cr = unique_port_identifier
//        { edc.setDestinationFeatureReference(cr);}
//			{
//				processComments(edc);
//				edc.setName(id.getText());
//			}
////		( LCURLY 
////			(pa = property_association
////				{
////					//conn.getOwnedPropertyAssociations().add(pa);
////				}
////			)+ 
////		  RCURLY
////		)?
//		( in_modes_and_transitions[edc]
//		)?
//	SEMI
////-------------------------------------------------------------------
//;

parameter_connection_parameter_association[boolean extension, boolean refined, ParameterConnection pc]
  :
     (srcCtx = IDENT DOT
     {
       ReferenceRecord srcCtxRef = new ReferenceRecord(ParserReferenceType.ParameterConnectionSourceContextReference,
                                                       pc,
                                                       new String[]{srcCtx.getText()}
                                                       );
       unresolvedReferences.add(srcCtxRef);
     }
   )?
   (srcPort = IDENT
     {
       ReferenceRecord srcRef = new ReferenceRecord(ParserReferenceType.ParameterConnectionSourceReference,
                                                       pc,
                                                       new String[]{srcPort.getText()}
                                                       );
       unresolvedReferences.add(srcRef);       
     }
   )
   ARROW
   (dstCtx=IDENT DOT
     {
       ReferenceRecord dstCtxRef = new ReferenceRecord(ParserReferenceType.ParameterConnectionDestinationContextReference,
                                                       pc,
                                                       new String[]{dstCtx.getText()}
                                                       );
       unresolvedReferences.add(dstCtxRef);
     }
   )?
   (dstPort=IDENT
     {
       ReferenceRecord dstRef = new ReferenceRecord(ParserReferenceType.ParameterConnectionDestinationReference,
                                                       pc,
                                                       new String[]{dstPort.getText()}
                                                       );
       unresolvedReferences.add(dstRef);      
     }
   )
  ;

parameter_connection [boolean extension] returns [ParameterConnection pc]
  @init { 
      	boolean refined = false;
      	String idString="";
   }
   :
	 (id=IDENT COLON
	   {
	     idString = id.getText();
	   }
	 )?
	 (
	 (REFINED TO
	   {
       //refinement only allowed in extensions
       if (!extension){
        throw new FailedPredicateException(input, "port connection", "refinement only allowed in extensions");
       }
       if (idString.length() == 0){
        throw new FailedPredicateException(input, "port connection", "refinement requires a name");
       }
	     refined=true;
	   }
    lbl= PARAMETER 
    { 
      pc=Aadl2F.createParameterConnection();
      pc.setName(idString);
      pc.setKind(ConnectionKind.PARAMETER);
      pc.setLocationReference(this.getFilename(),lbl.getLine());
      
      if (refined) {
         ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.ConnectionRefinementReference,
                           pc,
                           new String[]{idString}
                           );
        unresolvedReferences.add(refref);
      }
    }
    (parameter_connection_parameter_association[extension, refined, pc]
    )?
	 )
	 |
	 (lbl= PARAMETER 
	 	{ 
      pc=Aadl2F.createParameterConnection();
      pc.setName(idString);
      pc.setKind(ConnectionKind.PARAMETER);
	 	  pc.setLocationReference(this.getFilename(),lbl.getLine());
	 	  
	 	  if (refined) {
	 	     ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.ConnectionRefinementReference,
	 	                       pc,
	 	                       new String[]{idString}
	 	                       );
        unresolvedReferences.add(refref);
	 	  }
	 	}
    parameter_connection_parameter_association[extension, refined, pc]
	 )
	 )
			{
				processComments(pc);
			}
		( LCURLY 
			(pa = property_association
				{
					pc.getOwnedPropertyAssociations().add(pa);
				}
			)+ 
		  RCURLY
		)?
		( in_modes_and_transitions[pc]
		)?
	SEMI
//-------------------------------------------------------------------
;

access_connection_access_association[boolean extension, boolean refinement, AccessConnection ac]
  @init{
    boolean srcProcSubp=false;
  }
  :
  ( 
    (
    (PROCESSOR
      {
        srcProcSubp=true;
      }
    )
    |(srcCtx=IDENT
      {
        ReferenceRecord srcCtxRef = new ReferenceRecord(ParserReferenceType.AccessConnectionSourceContextReference,
                                                        ac,
                                                        new String[]{srcCtx.getText()}
                                                        );
        unresolvedReferences.add(srcCtxRef);                                                        
      }
    )
    )
    DOT
  )?
  (srcPort=IDENT
    {
      // this part should not exist if it is refinement
      // so it should throw an exception
      
      if (refinement){
        throw new FailedPredicateException(input, "access connection", "access connection refinement should not include the actual port connection");
      }
      if (srcProcSubp){
        ProcessorSubprogram psubp = Aadl2F.createProcessorSubprogram();
        psubp.setLocationReference(this.getFilename(), srcPort.getLine());
        psubp.setName(srcPort.getText());
        ac.setSource(psubp);
      } else {      
        ReferenceRecord srcRef = new ReferenceRecord(ParserReferenceType.AccessConnectionSourceReference,
                                                    ac,
                                                    new String[]{srcPort.getText()}
                                                    );
        unresolvedReferences.add(srcRef);
      }                                                  
    }
  )
  (BARROW
    {
      ac.setBidirectional(true);
    } 
  | ARROW
  )
  (dstCtx = IDENT DOT
    {
        ReferenceRecord dstCtxRef = new ReferenceRecord(ParserReferenceType.AccessConnectionDestinationContextReference,
                                                        ac,
                                                        new String[]{dstCtx.getText()}
                                                        );
        unresolvedReferences.add(dstCtxRef);
    }                                                        
  )?
  (dstPort = IDENT
    {
      ReferenceRecord dstRef = new ReferenceRecord(ParserReferenceType.AccessConnectionDestinationReference,
                                                  ac,
                                                  new String[]{dstPort.getText()}
                                                  );
      unresolvedReferences.add(dstRef);
    }                                                  
  )
  ;
  
access_connection_access_definition[boolean refinement, String idString] returns  [AccessConnection ac]
  @init{
    AccessCategory accessCategory=null;
  }
  :
  (
  (BUS
    {
      accessCategory = AccessCategory.BUS;
    }
  )
  |(SUBPROGRAM GROUP
    {
      accessCategory = AccessCategory.SUBPROGRAM_GROUP;
    }
  )
  |(SUBPROGRAM
     {
      accessCategory = AccessCategory.SUBPROGRAM;
    }
  )
  |(DATA
     {
      accessCategory = AccessCategory.DATA;
    }
  )
  )?
  (a=ACCESS
    {
      ac = Aadl2F.createAccessConnection();
      ac.setLocationReference(this.getFilename(), a.getLine());
      if (accessCategory!= null){
        ac.setAccessCategory(accessCategory);
      }
      ac.setName(idString);
      if (refinement){
        ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.ConnectionRefinementReference,
                                                    ac,
                                                    new String[]{idString}
                                                    );
        unresolvedReferences.add(refref);                                                    
      }
    }
  )
  ;  
  
access_connection [boolean extension] returns [AccessConnection ac]
  @init{
    boolean refinement = false;
    String idString=""; 
  }
  :
  (id=IDENT COLON
    {
      idString = id.getText();
    }
  )?
  (
  (REFINED TO
    {
       //refinement only allowed in extensions
       if (!extension){
        throw new FailedPredicateException(input, "port connection", "refinement only allowed in extensions");
       }
       if (idString.length() == 0){
        throw new FailedPredicateException(input, "port connection", "refinement requires a name");
       }
      refinement=true;
    }
    ad=access_connection_access_definition[refinement, idString]
      {
        ac = ad;
      } 
    (access_connection_access_association[ extension,  refinement, ac]
    )?
  )
  |
  (
  ad=access_connection_access_definition[refinement, idString]
    {
      ac = ad;
    } 
  access_connection_access_association[ extension,  refinement, ac]
  )
  )    
    ( LCURLY 
      (pa = property_association
        {
          ac.getOwnedPropertyAssociations().add(pa);
        }
      )+ 
      RCURLY
    )?
    ( in_modes_and_transitions[ac]
    )?
  SEMI
  { processComments(ac); }
  ;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMI);
  input.consume();
}
  
//bus_access_connection returns [AccessConnection pc]
//        @init { 
//        	pc=Aadl2F.createAccessConnection();
//        	pc.setAccessKind(AccessKind.BUS);
//        	//FeatureReference cr; 
//        }:
//	 id=IDENT COLON
//	 lbl= BUS ACCESS cr = unique_port_identifier
//	 	{ pc.setLocationReference(this.getFilename(),lbl.getLine());}
//	     { pc.setSourceFeatureReference(cr);}
//	 ARROW 	 cr = unique_port_identifier
//        { pc.setDestinationFeatureReference(cr);}
//			{
//				processComments(pc);
//				pc.setName(id.getText());
//			}
//		( LCURLY 
//			(pa = property_association
//				{
//					pc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes[pc]
//		)?
//	SEMI
////-------------------------------------------------------------------
//;

//bus_access_connection_refinement returns [AccessConnection pc]
//        @init { 
//        	//FeatureReference cr; 
//        }:
//	 id=IDENT COLON
//	 REFINED TO
//	 lbl= BUS ACCESS
//	 	{ 
//        	pc=Aadl2F.createAccessConnection();
//        	pc.setAccessKind(AccessKind.BUS);	 		
//	 		pc.setLocationReference(this.getFilename(),lbl.getLine());
//			processComments(pc);
//			pc.setName(id.getText());
//			RefinedReference rr = new RefinedReference();
//			rr.setRefinedName(id.getText());
//		}
//		( LCURLY 
//			(pa = property_association
//				{
//					pc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes[pc]
//		)?
//	SEMI
////-------------------------------------------------------------------
//;


//data_access_connection returns [AccessConnection pc]
//        @init { 
//        	pc=Aadl2F.createAccessConnection();
//        	pc.setAccessKind(AccessKind.DATA);
//        	//FeatureReference cr; 
//        }:
//	 id=IDENT COLON
//	 lbl= DATA ACCESS cr = unique_port_identifier
//	 	{ pc.setLocationReference(this.getFilename(),lbl.getLine());}
//	     { pc.setSourceFeatureReference(cr);}
//	 ARROW 	 cr = unique_port_identifier
//        { pc.setDestinationFeatureReference(cr);}
//			{
//				processComments(pc);
//				pc.setName(id.getText());
//			}
//		( LCURLY 
//			(pa = property_association
//				{
//					pc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes[pc]
//		)?
//	SEMI
////-------------------------------------------------------------------
//;

//data_access_connection_refinement returns [AccessConnection pc]
//        @init { 
//        	//FeatureReference cr; 
//        }:
//	 id=IDENT COLON
//	 REFINED TO
//	 lbl= DATA ACCESS
//	 	{ 
//        	pc=Aadl2F.createAccessConnection();
//        	pc.setAccessKind(AccessKind.DATA);
//	 		pc.setLocationReference(this.getFilename(),lbl.getLine());
//			processComments(pc);
//			pc.setName(id.getText());
//			RefinedReference rr = new RefinedReference();
//			rr.setRefinedName(id.getText());
//			pc.setRefinedReference(rr);
//	 	}
//		( LCURLY 
//			(pa = property_association
//				{
//					pc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes[pc]
//		)?
//	SEMI
////-------------------------------------------------------------------
//;


//subprogram_access_connection returns [AccessConnection pc]
//	@init{
//		pc = Aadl2F.createAccessConnection();
//		pc.setAccessKind(AccessKind.SUBPROGRAM);
//	}
//	:
//	id=IDENT COLON
//	lbl= SUBPROGRAM ACCESS srcref=unique_port_identifier ARROW dstref=unique_port_identifier
//		{
//			pc.setLocationReference(this.getFilename(), lbl.getLine());
//			pc.setSourceFeatureReference(srcref);
//			pc.setDestinationFeatureReference(dstref);
//		}
//			{
//				processComments(pc);
//				pc.setName(id.getText());
//			}
//		( LCURLY 
//			(pa = property_association
//				{
//					pc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes[pc]
//		)?
//	SEMI
//	;
	
//subprogram_access_connection_refinement returns [AccessConnection pc]
//	@init{
//	}
//	:
//	id=IDENT COLON
//	REFINED TO
//	lbl= SUBPROGRAM ACCESS
//		{
//			pc = Aadl2F.createAccessConnection();
//			pc.setAccessKind(AccessKind.SUBPROGRAM);
//			pc.setLocationReference(this.getFilename(), lbl.getLine());
//			processComments(pc);
//			pc.setName(id.getText());
//			RefinedReference rr = new RefinedReference();
//			rr.setRefinedName(id.getText());
//			pc.setRefinedReference(rr);
//		}
//		( LCURLY 
//			(pa = property_association
//				{
//					pc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes[pc]
//		)?
//	SEMI
//	;
	
	
//subprogram_group_access_connection returns [AccessConnection pc]
//	@init{
//		pc = Aadl2F.createAccessConnection();
//		pc.setAccessKind(AccessKind.SUBPROGRAM_GROUP);
//	}
//	:
//	id=IDENT COLON
//	lbl= SUBPROGRAM GROUP ACCESS srcref=unique_port_identifier ARROW dstref=unique_port_identifier
//		{
//			pc.setLocationReference(this.getFilename(), lbl.getLine());
//			pc.setSourceFeatureReference(srcref);
//			pc.setDestinationFeatureReference(dstref);
//		}
//			{
//				processComments(pc);
//				pc.setName(id.getText());
//			}
//		( LCURLY 
//			(pa = property_association
//				{
//					pc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes[pc]
//		)?
//	SEMI
//	;
	
//subprogram_group_access_connection_refinement returns [AccessConnection pc]
//	@init{
//	}
//	:
//	id=IDENT COLON
//	REFINED TO
//	lbl= SUBPROGRAM GROUP ACCESS
//		{
//			pc = Aadl2F.createAccessConnection();
//			pc.setAccessKind(AccessKind.SUBPROGRAM_GROUP);
//			pc.setLocationReference(this.getFilename(), lbl.getLine());
//			processComments(pc);
//			pc.setName(id.getText());
//			RefinedReference rr = new RefinedReference();
//			rr.setRefinedName(id.getText());
//			pc.setRefinedReference(rr);
//		}
//		( LCURLY 
//			(pa = property_association
//				{
//					pc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes[pc]
//		)?
//	SEMI
//	;

feature_group_connection_port_association[boolean extension, boolean refinement, FeatureGroupConnection sc]
  :
   (srcCtx = IDENT DOT
     {
       // a refinement should not have the repetition of the connection again
       if (refinement){
        throw new FailedPredicateException(input, "feature group connection", "feature group connection refinement should not include the actual port connection");
       }
         
       ReferenceRecord srcCtxRef = new ReferenceRecord(ParserReferenceType.FeatureGroupConnectionSourceContextReference,
                                                       sc,
                                                       new String []{srcCtx.getText()}
                                                       );
        unresolvedReferences.add(srcCtxRef);
     }
   )?
   (srcPort=IDENT
     {
       ReferenceRecord srcRef = new ReferenceRecord(ParserReferenceType.FeatureGroupConnectionSourceReference,
                                                   sc,
                                                   new String[]{srcPort.getText()}
                                                   );
       unresolvedReferences.add(srcRef);
     }
   )
   BARROW
     {
       sc.setBidirectional(true);
     }
   (dstCtx = IDENT DOT
     {
       ReferenceRecord dstCtxRef = new ReferenceRecord(ParserReferenceType.FeatureGroupConnectionDestinationContextReference,
                                                       sc,
                                                       new String []{dstCtx.getText()}
                                                       );
        unresolvedReferences.add(dstCtxRef);
     }
   )?
   (dstPort= IDENT
     {
       ReferenceRecord dstRef = new ReferenceRecord(ParserReferenceType.FeatureGroupConnectionDestinationReference,
                                                   sc,
                                                   new String[]{dstPort.getText()}
                                                   );
       unresolvedReferences.add(dstRef);
       processComments(sc);
     }
   )  
  ;

feature_group_connection [boolean extension] returns [FeatureGroupConnection sc ]
        @init { 
        	//FeatureReference cr; 
        	boolean refinement = false;
        	String idString ="";
        }:
	(id=IDENT COLON
	 {
	   idString = id.getText();
	 }
	)?
	(
	(REFINED TO
	 {
       //refinement only allowed in extensions
       if (!extension){
        throw new FailedPredicateException(input, "port connection", "refinement only allowed in extensions");
       }
       if (idString.length() == 0){
        throw new FailedPredicateException(input, "port connection", "refinement requires a name");
       }
	   refinement = true;
	 }
  lbl= FEATURE GROUP
    { 
       sc = Aadl2F.createFeatureGroupConnection();
       sc.setName(idString);
       sc.setLocationReference(this.getFilename(),lbl.getLine());
       if (refinement){
         ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.ConnectionRefinementReference,
                                                     sc,
                                                     new String[]{idString}
                                                     );
        unresolvedReferences.add(refref);
       }
    }
	 (feature_group_connection_port_association[extension, refinement, sc]
	 )?
	)
	|
	(lbl= FEATURE GROUP
	 	{ 
       sc = Aadl2F.createFeatureGroupConnection();
       sc.setName(idString);
	 	   sc.setLocationReference(this.getFilename(),lbl.getLine());
	 	   if (refinement){
	 	     ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.ConnectionRefinementReference,
	 	                                                 sc,
	 	                                                 new String[]{idString}
	 	                                                 );
        unresolvedReferences.add(refref);
	 	   }
	 	}
   feature_group_connection_port_association[extension, refinement, sc]
  )
  )
	( LCURLY 
			(pa = property_association
				{
					sc.getOwnedPropertyAssociations().add(pa);
				}
			)+ 
		  RCURLY
	)?
	( in_modes_and_transitions[sc]
	)?
	SEMI
;
catch [RecognitionException ex] {
  reportError(ex);
  consumeUntil(input,SEMI);
  input.consume();
}

//feature_group_connection_refinement returns [FeatureGroupConnection sc ]
//        @init { 
//        	//FeatureReference cr; 
//        }:
//	id=IDENT COLON
//	REFINED TO
//	 lbl= FEATURE GROUP
//	 	{ 
//	 		sc = Aadl2F.createFeatureGroupConnection();
//	 		sc.setLocationReference(this.getFilename(),lbl.getLine());
//			processComments(sc);
//			sc.setName(id.getText());
//			ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.RefinementReference,
//			                                                           sc,
//			                                                           new String[]{id.getText()}
//			                                                           );
//			                                                           
//			unresolvedReferences.add(rr); 
//		}
//		( LCURLY 
//			(pa = property_association
//				{
//					sc.getOwnedPropertyAssociations().add(pa);
//				}
//			)+ 
//		  RCURLY
//		)?
//		( in_modes_and_transitions[sc]
//		)?
//	SEMI
//;

		
//port_group_connection returns [FeatureGroupConnection sc ]
//        @init { 
//        	sc = Aadl2F.createFeatureGroupConnection();
//        	//FeatureReference cr; 
//        }:
//	 lbl= PORT GROUP
//	 	{ sc.setLocationReference(this.getFilename(),lbl.getLine());}
//	 cr = unique_port_group_identifier
//	     { sc.setSourceFeatureReference(cr);}
//	 ARROW  cr = unique_port_group_identifier
//	     { sc.setDestinationFeatureReference(cr);}
//;

//unique_port_group_identifier returns [ReferenceRecord cr ]
//	@init{
//	}:
// 	compid=IDENT 
// 	  {
// 	      cr.setCompName(compid.getText());
// 	  }
// 	DOT portid=IDENT 
// 	    {
// 	       cr = new ReferenceRecord(new String[]{compid.getText(), portid.getText()});
// 	    }
//   |
//   soleportid=IDENT 
//      {
//        cr = new ReferenceRecord(new String[]{soleportid.getText()});
//      }
//;

//connection_refinement[Connections cns] 
//	@init {
//	//Properties ps; 
//	Connection cn = null;
//	RefinedReference fr;
//	}:
//     id=IDENT COLON REFINED TO
//     ( EVENT DATA PORT { cn = Aadl2F.createEventDataConnection();cns.addEventDataConnection((EventDataConnection)cn);}
//     | EVENT PORT { cn = Aadl2F.createEventConnection();cns.addEventConnection((EventConnection)cn);}
//     | DATA PORT { cn = Aadl2F.createDataConnection();cns.addDataConnection((DataConnection)cn);}
//     | PORT GROUP { cn = Aadl2F.createFeatureGroupConnection();cns.addPortGroupConnection((FeatureGroupConnection)cn);}
//     | PARAMETER { cn = Aadl2F.createParameterConnection();cns.addParameterConnection((ParameterConnection)cn);}
//     | BUS ACCESS { cn = Aadl2F.createBusAccessConnection();cns.addBusAccessConnection((BusAccessConnection)cn);}
//     | DATA ACCESS { cn = Aadl2F.createDataAccessConnection();cns.addDataAccessConnection((DataAccessConnection)cn);}
//     )
//     	{ cn.setName(id.getText()); }
//         { cn.setRefined(true); processComments(cn);}
//                {  fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//                	cn.setRefinedReference(fr);
//               		fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//          		}
//	 (( 
////	 	ps = curlyPropertyAssociations 
////	      { cn.setProperties(ps); }
//	 	( in_modes_and_transitions[cn] )?
//	  ) |
//	  in_modes_and_transitions[cn]
//	 )
//	 SEMI
//;

//dataConnectionsSubclause [ComponentImplementation ci]
//	@init {
//	Connections cns =null; 
//	//Connection cn = null;
//	}:		
//     CONNECTIONS  
//       {  cns = Aadl2F.createConnections(); ci.setConnections(cns);processComments(cns);}
//			(( cn = data_access_connection_decl { cns.addDataAccessConnection((DataAccessConnection)cn);}
//	         | cn = data_access_connection_refinement_decl { cns.addDataAccessConnection((DataAccessConnection)cn);}
//	         )+ | ( none_stmt ));

//data_access_connection_decl returns [Connection cn]
//	@init {
//		//Connection cnr=null;
//		cn = null;
//		//Properties ps=null; 
//		String cname=null;
//	}:
//     ( id=IDENT COLON  { cname = id.getText();})?
//	 cnr = data_access_connection 
//	     { 
//	     	cn=cnr;
//	     	processComments(cn);
//	     }
//	    { if (cname != null) cn.setName(cname); }
////	 ( ps = curlyPropertyAssociations { cn.setProperties(ps);} )?
// 	 ( in_modes[cn] )? SEMI
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//data_access_connection_refinement_decl returns [Connection cn ]
//	@init {
//		cn = null;
//		//Properties ps; 
//		RefinedReference fr;
//	}:
//     id=IDENT COLON REFINED TO
//      DATA ACCESS { cn = Aadl2F.createDataAccessConnection();}
//     	{ cn.setName(id.getText()); }
//         { cn.setRefined(true); processComments(cn);}
//                {  fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//                	cn.setRefinedReference(fr);
//               		fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//          		}
//	 (( 
////	 	ps = curlyPropertyAssociations 
////	      { cn.setProperties(ps); }
//	 	( in_modes[cn] )?
//	  ) |
//	  in_modes[cn]
//	 )
//	 SEMI
//;


//busConnectionsSubclause [ComponentImplementation ci]
//	@init {
//	Connections cns =null; 
//	//Connection cn = null;
//	}:		
//     CONNECTIONS  
//       {  cns = Aadl2F.createConnections(); ci.setConnections(cns);processComments(cns);}
//			(( cn = bus_access_connection_decl { cns.addBusAccessConnection((BusAccessConnection)cn);}
//	         | cn = bus_access_connection_refinement_decl { cns.addBusAccessConnection((BusAccessConnection)cn);}
//	         )+ | ( none_stmt ));


//bus_access_connection_decl returns [Connection cn]
//	@init {
//		//Connection cnr=null;
//		cn = null;
//		//Properties ps=null; 
//		String cname=null;
//	}:
//     ( id=IDENT COLON  { cname = id.getText();})?
//	 cnr = bus_access_connection 
//	     { 
//	     	cn=cnr;
//	     	processComments(cn);
//	     }
//	    { if (cname != null) cn.setName(cname); }
////	 ( ps = curlyPropertyAssociations { cn.setProperties(ps);} )?
// 	 ( in_modes[cn] )? SEMI
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }


//bus_access_connection_refinement_decl returns [Connection cn] 
//	@init{
//		cn=null;
//		//Properties ps; 
//		RefinedReference fr;
//	}:
//     id=IDENT COLON REFINED TO
//      BUS ACCESS { cn = Aadl2F.createBusAccessConnection();}
//     	{ cn.setName(id.getText()); }
//         { cn.setRefined(true); processComments(cn);}
//                {  fr = new RefinedReference(); fr.setRefinedName(id.getText()); 
//                	cn.setRefinedReference(fr);
//               		fr.setFilename(this.getFilename());fr.setLine(id.getLine()); 
//          		}
//	 (( 
////	 	ps = curlyPropertyAssociations 
////	      { cn.setProperties(ps); }
//	 	( in_modes[cn] )?
//	  ) |
//	  in_modes[cn]
//	 )
//	 SEMI
//;


//-------------------------------------------------------------------
//@
//@   End-To-End Flows
//@

//flow_specs[ComponentType ct]
//	@init {
//	FlowSpecs flows=null;}: 
//    FLOWS {  flows = Aadl2F.createFlowSpecs(); ct.setFlowSpecs(flows);processComments(flows); }
//      ( (flow_spec[flows])+
//      | none_stmt
//      )
//;

//flow_spec [FlowSpecs flows]:
//     defining_identifier=IDENT 
//     COLON 
//     ( flow_source_spec[flows,defining_identifier]
//     | flow_sink_spec[flows,defining_identifier]
//     | flow_path_spec[flows,defining_identifier] 
//     |  ( REFINED TO 
//         ( flow_source_spec_refinement[flows,defining_identifier]
//         | flow_sink_spec_refinement[flows,defining_identifier]
//         | flow_path_spec_refinement[flows,defining_identifier] 
//         )
//       )
//     )
//	 SEMI
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

flow_spec [boolean extension] returns [FlowSpecification flowSpec]
	:
	fss=flow_source_spec {flowSpec = fss;}
	| fks=flow_sink_spec {flowSpec = fks;}
	| fps=flow_path_spec {flowSpec = fps;}
	| (
	     (fssr=flow_source_spec_refinement {flowSpec = fssr;}
	     | fksr=flow_sink_spec_refinement {flowSpec = fksr;}
	     | fpsr=flow_path_spec_refinement {flowSpec = fpsr;}
	     )
	     {
          if (!extension){
            throw new FailedPredicateException(input,"flow spec ", "refinement only allowed in extension");
          }
	     }
	)
	;
  catch [RecognitionException ex] {
    reportError(ex);
  }       

flow_source_spec returns [FlowSpecification flowSrcSpec]
	@init{
		flowSrcSpec = Aadl2F.createFlowSpecification();
		flowSrcSpec.setKind(FlowKind.SOURCE);
	}
	:
	flowident=IDENT COLON FLOW SOURCE cr=flow_feature_identifier 
		{
			flowSrcSpec.setName(flowident.getText());
			processComments(flowSrcSpec);
			flowSrcSpec.setLocationReference(new LocationReference(this.getFilename(),flowident.getLine()));
			cr.setReferencingObject(flowSrcSpec);
			cr.setReferenceType(ParserReferenceType.FlowSpecificationOutFeatureReference);
			unresolvedReferences.add(cr);
		}
	( LCURLY (pa=property_association 
				{
					flowSrcSpec.getOwnedPropertyAssociations().add(pa);
				}
			  )+ 
	  RCURLY 
	)?
	(in_modes[flowSrcSpec])?
	SEMI
	;

flow_sink_spec returns [FlowSpecification flowSinkSpec]
	@init{
		flowSinkSpec = Aadl2F.createFlowSpecification();
		flowSinkSpec.setKind(FlowKind.SINK);
	}
	:
	flowident=IDENT COLON FLOW SINK cr=flow_feature_identifier
		{
			flowSinkSpec.setName(flowident.getText());
			processComments(flowSinkSpec);
			flowSinkSpec.setLocationReference(new LocationReference(this.getFilename(),flowident.getLine()));
			cr.setReferencingObject(flowSinkSpec);
			cr.setReferenceType(ParserReferenceType.FlowSpecificationInFeatureReference);
			unresolvedReferences.add(cr);
		}
	( LCURLY (pa=property_association 
				{
					flowSinkSpec.getOwnedPropertyAssociations().add(pa);
				}
			  )+ 
	  RCURLY 
	)?
	(in_modes[flowSinkSpec])?
	SEMI		
	;
	
flow_path_spec returns [FlowSpecification flowPathSpec]
	@init{
	}
	:
	flowident=IDENT COLON FLOW PATH incr=flow_feature_identifier ARROW outcr=flow_feature_identifier
		{
      flowPathSpec = Aadl2F.createFlowSpecification();
      flowPathSpec.setKind(FlowKind.PATH);
			flowPathSpec.setName(flowident.getText());
			processComments(flowPathSpec);
			flowPathSpec.setLocationReference(new LocationReference(this.getFilename(),flowident.getLine()));
			incr.setReferencingObject(flowPathSpec);
			incr.setReferenceType(ParserReferenceType.FlowSpecificationInFeatureReference);
			outcr.setReferencingObject(flowPathSpec);
      outcr.setReferenceType(ParserReferenceType.FlowSpecificationOutFeatureReference);
      unresolvedReferences.add(incr);
      unresolvedReferences.add(outcr);
		}
	( LCURLY (pa=property_association 
				{
					flowPathSpec.getOwnedPropertyAssociations().add(pa);
				}
			  )+ 
	  RCURLY 
	)?
	(in_modes[flowPathSpec])?
	SEMI	
	;
	
flow_source_spec_refinement returns [FlowSpecification flowSrcSpec]
	@init{
	}
	:
	flowident=IDENT COLON REFINED TO FLOW SOURCE 
		{
			flowSrcSpec = Aadl2F.createFlowSpecification();
			flowSrcSpec.setKind(FlowKind.SOURCE);
			flowSrcSpec.setName(flowident.getText());
			processComments(flowSrcSpec);
			flowSrcSpec.setLocationReference(new LocationReference(this.getFilename(), flowident.getLine()));
			ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FlowSpecificationRefinementReference,
			                                         flowSrcSpec,
			                                         new String[]{flowident.getText()}
			                                         );
      unresolvedReferences.add(rr);
		}
	(LCURLY (pa=property_association 
			{
				flowSrcSpec.getOwnedPropertyAssociations().add(pa);
			}
		    )+ 
	RCURLY
	)?
	(in_modes[flowSrcSpec])?
	SEMI
	;
	
flow_sink_spec_refinement returns [FlowSpecification flowSinkSpec]
	@init{
	}
	:
	flowident=IDENT COLON REFINED TO FLOW SINK
		{
      flowSinkSpec = Aadl2F.createFlowSpecification();
      flowSinkSpec.setKind(FlowKind.SINK);
			flowSinkSpec.setName(flowident.getText());
			processComments(flowSinkSpec);
			flowSinkSpec.setLocationReference(new LocationReference(this.getFilename(), flowident.getLine()));
      ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FlowSpecificationRefinementReference,
                                               flowSinkSpec,
                                               new String[]{flowident.getText()}
                                               );
      unresolvedReferences.add(rr);
		}
	(LCURLY 
	 (pa=property_association 
	   {
	     flowSinkSpec.getOwnedPropertyAssociations().add(pa);
	   }
	  )+ 
	 RCURLY
	 )?
	(in_modes[flowSinkSpec])?
	SEMI
	;
	
flow_path_spec_refinement returns [FlowSpecification flowPathSpec]
	@init{ 
	}
	:
	flowident=IDENT COLON REFINED TO FLOW PATH
		{
      flowPathSpec = Aadl2F.createFlowSpecification();
      flowPathSpec.setKind(FlowKind.PATH);
			flowPathSpec.setName(flowident.getText());
			processComments(flowPathSpec);
			flowPathSpec.setLocationReference(new LocationReference(this.getFilename(), flowident.getLine()));
      ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FlowSpecificationRefinementReference,
                                               flowPathSpec,
                                               new String[]{flowident.getText()}
                                               );
      unresolvedReferences.add(rr);
		}
	(LCURLY 
	   (pa=property_association 
	     { 
	       flowPathSpec.getOwnedPropertyAssociations().add(pa);
	     } 
	    )+ 
	RCURLY
	)?
	(in_modes[flowPathSpec])?
	SEMI
	;	
				
//-------------------------------------------------------------------
//flow_source_spec [FlowSpecs fss, Token defining_identifier]
//	@init {
//	//Properties ps; 
//	//FeatureReference cr;
//	FlowSourceSpecification flow=null;
//	}: 
//	FLOW SOURCE 
//        { flow = Aadl2F.createFlowSourceSpecification();}
//        { fss.addFlowSourceSpec(flow); processComments(flow);}
//		{ flow.setName(defining_identifier.getText()); flow.setLocationReference(new LocationReference(this.getFilename(),defining_identifier.getLine())); }
//     cr = flow_feature_identifier
//	     { flow.setDstPortReference(cr);}
//	 ( ps = curlyPropertyAssociations_no_modes 
//	     { flow.setProperties(ps); }
//	     )?
//;

//flow_source_spec_refinement [FlowSpecs fss, Token defining_identifier]
//	@init {
//	//Properties ps; 
//	//FeatureReference cr;
//	FlowSourceSpecification flow=null;
//	RefinedReference fr;
//	}: 
//	FLOW SOURCE 
//        { flow = Aadl2F.createFlowSourceSpecification();}
//        { fss.addFlowSourceSpec(flow); processComments(flow);}
//		{ flow.setName(defining_identifier.getText()); flow.setLocationReference(new LocationReference(this.getFilename(),defining_identifier.getLine()));
//           flow.setRefined(true);
//           fr = new RefinedReference(); 
//           fr.setRefinedName(defining_identifier.getText()); 
//           fr.setFilename(this.getFilename());fr.setLine(defining_identifier.getLine()); 
//           flow.setRefinedReference(fr);}
//	  ps = curlyPropertyAssociations_no_modes 
//	     { flow.setProperties(ps); }
	     
//;


//flow_sink_spec [FlowSpecs fss, Token defining_identifier]
//	@init {
//	//Properties ps; 
//	//FeatureReference cr; 
//	FlowSinkSpecification flow=null;
//	}: 
//     FLOW SINK 
//        {flow= Aadl2F.createFlowSinkSpecification();
//        fss.addFlowSinkSpec(flow); processComments(flow);
//        flow.setName(defining_identifier.getText()); flow.setLocationReference(new LocationReference(this.getFilename(),defining_identifier.getLine()));}
//
//     cr = flow_feature_identifier
//	     { flow.setSrcPortReference(cr);}
//	 ( ps = curlyPropertyAssociations_no_modes 
//	     { flow.setProperties(ps); }
//	 )?
//;


//flow_sink_spec_refinement [FlowSpecs fss, Token defining_identifier]
//	@init {
//	//Properties ps; 
//	//FeatureReference cr; 
//	FlowSinkSpecification flow=null;
//	RefinedReference fr;
//	}: 
//     FLOW SINK 
//        { flow= Aadl2F.createFlowSinkSpecification();
//        fss.addFlowSinkSpec(flow); processComments(flow);
//        flow.setName(defining_identifier.getText()); flow.setLocationReference(new LocationReference(this.getFilename(),defining_identifier.getLine()));
//        flow.setRefined(true);
//           fr = new RefinedReference(); 
//           fr.setRefinedName(defining_identifier.getText()); 
//           fr.setFilename(this.getFilename());fr.setLine(defining_identifier.getLine()); 
//           flow.setRefinedReference(fr); }
//	  ps = curlyPropertyAssociations_no_modes 
//	     { flow.setProperties(ps); }
//	 
//;

//flow_path_spec [FlowSpecs fss, Token defining_identifier]
//	@init {
//	//Properties ps; 
//	//FeatureReference cr; 
//	FlowPathSpecification flow=null;
//	}: 
//	FLOW PATH
//        { flow= Aadl2F.createFlowPathSpecification();
//        fss.addFlowPathSpec(flow); processComments(flow);
//        flow.setName(defining_identifier.getText()); flow.setLocationReference(new LocationReference(this.getFilename(),defining_identifier.getLine()));}

//      cr = flow_feature_identifier ARROW 
//	     { flow.setSrcPortReference(cr);}
//      cr = flow_feature_identifier
//	     { flow.setDstPortReference(cr);}
//	 ( ps = curlyPropertyAssociations_no_modes 
//	     { flow.setProperties(ps); }
//	 )?
//;

//flow_path_spec_refinement [FlowSpecs fss, Token defining_identifier]
//	@init {
//	//Properties ps; 
//	FeatureReference cr; 
//	FlowPathSpecification flow=null;
//	RefinedReference fr;
//	}: 
//	FLOW PATH
//        { flow= Aadl2F.createFlowPathSpecification();
//        fss.addFlowPathSpec(flow); processComments(flow);
//        flow.setName(defining_identifier.getText()); flow.setLocationReference(new LocationReference(this.getFilename(),defining_identifier.getLine()));
//        flow.setRefined(true);
//           fr = new RefinedReference(); 
//           fr.setRefinedName(defining_identifier.getText()); 
//           fr.setFilename(this.getFilename());fr.setLine(defining_identifier.getLine()); 
//           flow.setRefinedReference(fr);  }
//	  ps = curlyPropertyAssociations_no_modes 
//	     { flow.setProperties(ps); }
//;

end_to_end_flow_implementation [boolean extension] returns [EndToEndFlow e2e]
	@init{
	}
	:
     ( 
     	(e2ef=end_to_end_flow
     		{
     			e2e = e2ef; 
     		} 
     	)
     | 
     	(e2efr=end_to_end_flow_refinement
     	 	{
          //refinement only allowed in extensions
          if (!extension){
            throw new FailedPredicateException(input, "end to end flow implementation", "refinement only allowed in extensions");
          }
     	 		e2e = e2efr;
     	 	}
     	 )
     )
	 SEMI
;
   catch [RecognitionException ex] {
      reportError(ex);
		  consumeUntil(input,SEMI);
		  input.consume();
   }
	
flow_implementation [boolean extension] returns [FlowImplementation flowImpl]
	@init{
	}
	:
     ( 
     	(fsi=flow_source_implementation
     		{
     			flowImpl = fsi;
     		}
     	)
     |
      (fsir=flow_source_implementation_refinement
        {
         //refinement only allowed in extensions
         if (!extension){
          throw new FailedPredicateException(input, "flow implementation", "refinement only allowed in extensions");
         }
         flowImpl = fsir;            
        }
      ) 
     	|
     	(fki=flow_sink_implementation
     		{
     			flowImpl = fki;
     		}
     	)
     |
     (fkir=flow_sink_implementation_refinement
         {
         //refinement only allowed in extensions
         if (!extension){
          throw new FailedPredicateException(input, "flow implementation", "refinement only allowed in extensions");
         }
         
         flowImpl = fkir;            
        }    
     )
     | 
     	(fpi=flow_path_implementation
     	 	{
     	 		flowImpl = fpi;
     	 	}
     	 )
     	|
     	  (fpir = flow_path_implementation_refinement
           {
               //refinement only allowed in extensions
               if (!extension){
                  throw new FailedPredicateException(input, "flow implementation", "refinement only allowed in extensions");
               }
         
               flowImpl = fkir;            
            }    
     	  )
     )
    (LCURLY
      (pa=property_association
        {
          flowImpl.getOwnedPropertyAssociations().add(pa);
        }
      )+
     RCURLY
    )?
    (in_modes_and_transitions[flowImpl]
    )?
	 SEMI
;
   catch [RecognitionException ex] {
        reportError(ex);
		    consumeUntil(input,SEMI);
		    input.consume();
    }


//flow_impls[ComponentImplementation ci]
//@init { Flows flows=null;}: 
//    FLOWS {  flows = Aadl2F.createFlows(); ci.setFlows(flows); processComments(flows);}
//      ( ( flow_sequence[flows]  )+ 
//      | none_stmt
//      )
//;

//flow_sequence [Flows flows] 
//:
//     defining_identifier=IDENT 
//     COLON 
//     ( flow_source_implementation[flows,defining_identifier]
//     | flow_sink_implementation[flows,defining_identifier]
//     | flow_path_implementation[flows,defining_identifier] 
//     | end_to_end_flow[flows,defining_identifier] 
//     |  ( REFINED TO 
//         ( flow_source_implementation_refinement[flows,defining_identifier]
//         | flow_sink_implementation_refinement[flows,defining_identifier]
//         | flow_path_implementation_refinement[flows,defining_identifier] 
//         | end_to_end_flow_refinement[flows,defining_identifier] 
//         )
//       )
//     )
//	 SEMI
//;
//          catch [RecognitionException ex] {
//            reportError(ex);
//			consumeUntil(input,SEMI);
//			input.consume();
//        }

flow_source_implementation returns [FlowImplementation fi]
	@init {
		LocationReference fr;
	}
	:
	 flow_identifier=IDENT COLON 
	 FLOW SOURCE
    	{ 
        		fi = Aadl2F.createFlowImplementation();
        		fi.setKind(FlowKind.SOURCE);
				    processComments(fi);
				    // Flow implementations do not have a name 
         		//fi.setName(flow_identifier.getText());
         		
         		ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FlowImplementationSpecificationReference,
         		                                         fi,
         		                                         new String[]{flow_identifier.getText()}
         		                                         );
            unresolvedReferences.add(rr);         		                                         
         		fr = new LocationReference(this.getFilename(),flow_identifier.getLine());
         		fi.setLocationReference(fr);
     	}
       ( 
          cr = subcomponent_flow_identifier 
            {
              cr.setReferenceType(ParserReferenceType.FlowImplementationFlowElementReference);
              cr.setReferencingObject(fi);
              unresolvedReferences.add(cr);
            }
       		ARROW
       		 
       		cid= IDENT
       			{
       			  ReferenceRecord cref = new ReferenceRecord(ParserReferenceType.FlowImplementationConnectionReference,
       			                                        fi,
       			                                        new String[]{cid.getText()}
       			                                        );
              unresolvedReferences.add(cref);                                                    
       			}
       		ARROW 
       	)*
        cr = flow_feature_identifier 
          {
            cr.setReferenceType(ParserReferenceType.FlowImplementationOutFeatureReference);
            cr.setReferencingObject(fi);
            unresolvedReferences.add(cr); 
          }
;

flow_sink_implementation returns [FlowImplementation fi]
	@init {
		LocationReference fr;
	}:
	 flow_identifier=IDENT COLON 
     FLOW SINK
     	{ 
     		fi = Aadl2F.createFlowImplementation();
     		fi.setKind(FlowKind.SINK);
			  processComments(fi);
        //fi.setName(flow_identifier.getText());
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FlowImplementationSpecificationReference,
                                                 fi,
                                                 new String[]{flow_identifier.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                      
        fr = new LocationReference(this.getFilename(),flow_identifier.getLine());
        fi.setLocationReference(fr);
        }
      cr = flow_feature_identifier 
     	  {
     	    cr.setReferenceType(ParserReferenceType.FlowImplementationInFeatureReference);
     	    cr.setReferencingObject(fi);
     	    unresolvedReferences.add(cr); 
     	  }
     ( 
     	ARROW cid = IDENT
        {
          ReferenceRecord cref=new ReferenceRecord(ParserReferenceType.FlowImplementationConnectionReference,
                                                  fi,
                                                  new String[]{cid.getText()}
                                                  );  
          unresolvedReferences.add(cref);
     		}
     	ARROW cr = subcomponent_flow_identifier 
     		{
     		  cr.setReferenceType(ParserReferenceType.FlowImplementationFlowElementReference);
     		  cr.setReferencingObject(fi);
     		  unresolvedReferences.add(cr);
     		}
     )*
;

flow_path_implementation returns [FlowImplementation fi]
	@init {
		LocationReference fr;
	}
	:
	flow_identifier=IDENT COLON 
    FLOW PATH 
    	{ 
        fi = Aadl2F.createFlowImplementation();
        fi.setKind(FlowKind.PATH);
        processComments(fi);
        ReferenceRecord rr = new ReferenceRecord(ParserReferenceType.FlowImplementationSpecificationReference,
                                                 fi,
                                                 new String[]{flow_identifier.getText()}
                                                 );
        unresolvedReferences.add(rr);                                                      
        //fi.setName(flow_identifier.getText());
        fr = new LocationReference(); 
        fr.setFilename(this.getFilename()); 
        fr.setLine(flow_identifier.getLine());
        fi.setLocationReference(fr);
       }
	   cr = flow_feature_identifier 
    	 { 
         cr.setReferenceType(ParserReferenceType.FlowImplementationInFeatureReference);
         cr.setReferencingObject(fi);
         unresolvedReferences.add(cr); 
    	 }
    ARROW 
       ( 
       		cid = IDENT 
            {
              ReferenceRecord cref=new ReferenceRecord(ParserReferenceType.FlowImplementationConnectionReference,
                                                      fi,
                                                      new String[]{cid.getText()}
                                                      );  
              unresolvedReferences.add(cref);
            }
         	ARROW
         		(  
         			cr = subcomponent_flow_identifier 
                {
                  cr.setReferenceType(ParserReferenceType.FlowImplementationFlowElementReference);
                  cr.setReferencingObject(fi);
                  unresolvedReferences.add(cr);
                }
         			ARROW cid = IDENT 
         				{
         					 ReferenceRecord cref=new ReferenceRecord(ParserReferenceType.FlowImplementationConnectionReference,
                                                           fi,
                                                           new String[]{cid.getText()}
                                                           );  
                   unresolvedReferences.add(cref);
     					  } 
         			ARROW 
         		)+
       )?
      cr = flow_feature_identifier 
      	{
         cr.setReferenceType(ParserReferenceType.FlowImplementationOutFeatureReference);
         cr.setReferencingObject(fi);
         unresolvedReferences.add(cr); 
      	}
;

flow_source_implementation_refinement returns [FlowImplementation fi]
     @init {
     }
     :
	flow_identifier=IDENT COLON 
  FLOW SOURCE
	REFINED TO 
		{ 
			fi = Aadl2F.createFlowImplementation();
			fi.setLocationReference(this.getFilename(), flow_identifier.getLine());
			fi.setKind(FlowKind.SOURCE);
			processComments(fi);
			ReferenceRecord refref = new ReferenceRecord(ParserReferenceType.RefinementReference,
			                                             fi,
			                                             new String[]{flow_identifier.getText()}
			                                             );
      unresolvedReferences.add(refref);			                                             
      fi.setName(flow_identifier.getText());
    	}
;

flow_sink_implementation_refinement returns [FlowImplementation fi]
	@init {
  }
  :
  flow_identifier=IDENT COLON 
  FLOW SINK
	REFINED TO 
		{ 
			fi = Aadl2F.createFlowImplementation();
			fi.setLocationReference(this.getFilename(), flow_identifier.getLine());
			fi.setKind(FlowKind.SINK);
			processComments(fi);
      fi.setName(flow_identifier.getText());
      ReferenceRecord rref = new ReferenceRecord(ParserReferenceType.RefinementReference,
                                                fi,
                                                new String[]{flow_identifier.getText()}
                                                );
      unresolvedReferences.add(rref);                                                
		}
;

flow_path_implementation_refinement returns [FlowImplementation fi]
	@init {
  }
  :
  flow_identifier=IDENT COLON 
  FLOW PATH
	REFINED TO 
		{ 
			fi = Aadl2F.createFlowImplementation();
			fi.setLocationReference(this.getFilename(), flow_identifier.getLine());
			fi.setKind(FlowKind.PATH);
			processComments(fi);
      fi.setName(flow_identifier.getText());
      ReferenceRecord rref = new ReferenceRecord(ParserReferenceType.RefinementReference,
                                                fi,
                                                new String[]{flow_identifier.getText()}
                                                );
      unresolvedReferences.add(rref);                                                
    }
;

subcomponent_flow_identifier  returns [ReferenceRecord cr]
	@init{
	}:
 	(subcompid=IDENT DOT flowid=IDENT 
 	  {
 	    cr = new ReferenceRecord(new String[]{subcompid.getText(),flowid.getText()});
 	  }
 	)
 	|(flowid=IDENT
 	  {
 	    cr = new ReferenceRecord(new String[]{flowid.getText()});
 	  }
 	)
;

end_to_end_flow returns [EndToEndFlow fi]
	@init {
    }
    :
    flow_identifier=IDENT COLON 
    END TO END FLOW  
    	{ 
    		fi = Aadl2F.createEndToEndFlow();
        processComments(fi);
        fi.setName(flow_identifier.getText());
        LocationReference lr = new LocationReference(); 
        lr.setFilename(this.getFilename()); 
        lr.setLine(flow_identifier.getLine());
        fi.setLocationReference(lr);
      }
     cr = subcomponent_flow_identifier 
     	{ 
     	  cr.setReferenceType(ParserReferenceType.FlowImplementationFlowElementReference);
     	  cr.setReferencingObject(fi);
     	  unresolvedReferences.add(cr);
     	}
     ( 
     	ARROW cid = IDENT 
     		{
     		 ReferenceRecord cref = new ReferenceRecord(ParserReferenceType.FlowImplementationConnectionReference,
     		                                           fi,
     		                                           new String[]{cid.getText()}
     		                                           );
          unresolvedReferences.add(cref);
     		}
     	ARROW cr = subcomponent_flow_identifier 
     		{
     			cr.setReferenceType(ParserReferenceType.FlowImplementationFlowElementReference);
          cr.setReferencingObject(fi);
          unresolvedReferences.add(cr);
     		}
     )+
     (LCURLY
      (pa=property_association
        {
          fi.getOwnedPropertyAssociations().add(pa);
        }
      )+
      RCURLY
     )?
     (in_modes_and_transitions[fi]
     )?
;

end_to_end_flow_refinement returns [EndToEndFlow fi]
	@init {
        LocationReference lr;
    }
    :
  flow_identifier=IDENT COLON 
	REFINED TO 
  END TO END FLOW 
		{ 
			fi = Aadl2F.createEndToEndFlow();
			processComments(fi);
      fi.setName(flow_identifier.getText());
      ReferenceRecord rref = new ReferenceRecord(ParserReferenceType.EndToEndFlowRefinementReference,
                                                 fi,
                                                 new String[]{flow_identifier.getText()}
                                                 );
      unresolvedReferences.add(rref);                                                 
      lr = new LocationReference(); 
      lr.setFilename(this.getFilename()); 
      lr.setLine(flow_identifier.getLine());
      fi.setLocationReference(lr);
    }
  (LCURLY
    (pa=property_association
      {
        fi.getOwnedPropertyAssociations().add(pa);
      }
    )+
   RCURLY
  )?
  (in_modes_and_transitions[fi]
  )?
;

//connection_identifier returns [ReferenceRecord cr]
//	@init{
//	}:
//   connid=IDENT 
//   {
//      cr.setFeatureName(connid.getText());
//      cr.setCompName("");
//      cr.setFilename(this.getFilename());
//      cr.setLine(connid.getLine());
//   }
//;

flow_feature_identifier returns [ReferenceRecord cr ]
	@init{
	 String ctx="";
	}:
	(ctxId = IDENT DOT
	   {
	     ctx = ctxId.getText();	   
	   } 
	)?
	portId=IDENT
	 {
	   if (ctx.length()>0){
       cr = new ReferenceRecord(new String[]{ctx,portId.getText()});
	   } else {
       cr = new ReferenceRecord(new String[]{portId.getText()});
	   }
	 }
;

real_literal returns [Token tok]
	@init {
		tok=null;
		String str;
	}:
    //id=NUMERIC_LIT
    id=REAL_LIT
	{ 
	str = id.getText();
	tok = id;
        if ( str.indexOf('.') == -1 ) 
        	//throw new SemanticException("Expected a real value: "+str,getFilename(),id.getLine(), id.getCharPositionInLine()); 
        	throw new FailedPredicateException(input,"real literal","Expected a real value: "+str);
       }
	;
	
integer_literal returns [Token tok]
	@init {
		tok =null;
		String str;
	}:
    id=INTEGER_LIT
	{ 
	 	str = id.getText();
		tok = id;
         	if ( str.indexOf('.') != -1 ) 
         		//throw new SemanticException("Expected an integer value: "+str,getFilename(),id.getLine(), id.getCharPositionInLine()); 
         		throw new FailedPredicateException(input,"integer literal","Expected an integer value: "+str);
        }
	;


/*options {
    k=3; // needed for newline junk
    charVocabulary='\u0000'..'\uFFFE'; // allow UNICODE
    caseSensitive = false;
    caseSensitiveLiterals = false;
	defaultErrorHandler=true;
}*/

//	AADLSPEC;
	ABSTRACT:'abstract';
	ACCESS:'access';
	AND:'and';
	ALL:'all';
	ANNEX:'annex';
	APPLIES:'applies';
	BINDING:'binding';
	BOOLEAN:'aadlboolean';
	BUS:'bus';
	CALLS:'calls';
	CLASSIFIER:'classifier';
	REFERENCE:'reference';
	COMPUTE:'compute';
	CONNECTIONS:'connections';
	CONSTANT:'constant';
	DATA:'data';
	DELTA:'delta';
	DEVICE:'device';
	END:'end';
	ENUMERATION:'enumeration';
	EVENT:'event';
	EXTENDS:'extends';
	FALSE:'false';
	FEATURE:'feature';
	FEATURES:'features';
	FLOW:'flow';
	FLOWS:'flows';
	GROUP:'group';
//	IMPL:'implementation';
	IMPLEMENTATION:'implementation';
	IN:'in';
	INHERIT:'inherit';
	INITIAL:'initial';
	INTEGER:'aadlinteger';
	INVERSE:'inverse';
	IS:'is';
	LIST:'list';
	MEMORY:'memory';
	MODE:'mode';
	MODES:'modes';
	NONE : 'none';
	NOT:'not';
	OF:'of';
	OR:'or';
	OUT:'out';
	PACKAGE:'package';
	PARAMETER:'parameter';
	PATH:'path';
	PORT:'port';
	PRIVATE:'private';
	PROCESS:'process';
	PROCESSOR:'processor';
	PROPERTIES:'properties';
	PROPERTY:'property';
	PROTOTYPE:'prototype';
	PROTOTYPES:'prototypes';
	PROVIDES:'provides';
	PUBLIC:'public';
	RANGE:'range';
	REAL:'aadlreal';
	RECORD: 'record';
	REFINED:'refined';
	REFINES:'refines';
	RENAMES:'renames';
	REQUIRES : 'requires';
	SELF : 'self';
	SERVER:'server';
	SET : 'set';
	SINK:'sink';
	SOURCE:'source';
	STRING:'aadlstring';
	SUBCOMPONENTS:'subcomponents';
	SUBPROGRAM:'subprogram';
	SYSTEM:'system';
	THREAD:'thread';
	TO:'to';
	TRANSITIONS:'transitions';
	TRUE:'true';
	TYPE:'type';
	UNITS:'units';
	VALUE:'value';
	VIRTUAL:'virtual';
	WITH: 'with';
	
 
LPAREN: '(' ;
RPAREN: ')' ;
LCURLY: '{' ;
RCURLY: '}' ;
COLON:  ':' ;
PLUS  : '+' ;
MINUS : '-' ;
STAR  : '*' ;
STARSTAR
	:	'**' ;
SEMI  : ';' ;
COMMA : ',' ;
DOT	  : '.' ;
DOTDOT : '..' ;
ASSIGN : '=>';
ASSIGNPLUS : '+=>';
DOUBLECOLON: '::';
LTRANS : '-[';
RTRANS : ']->';
LBRACK : '[';
RBRACK : ']';
ARROW : '->' ;
BARROW: '<->';
DARROW: '->>';
DHARROW: '>->';
HASH: '#';

IDENT:	LETTER 
	    ( 
	    	('_')? 
	    	(LETTER|'0'..'9')
	    )*
	;


	/*
          catch [RecognitionException ex] {
            reportError(ex);
			input.consume();
          }
          */

fragment
LETTER :('a'..'z');

// string literals
STRING_LITERAL:
//	'"' ('\"\"' |ESC|~('"'|'\\'))* '"'
	'"' ('""' |ESC|~('"'|'\\'))* '"'
	;

REAL_LIT : 	(DIGIT)+('_' (DIGIT)+)*
		( //{ input.LA(2)!='.' }?  //&& input.LA(3)!='.' }?
		  //( { input.LA(2)!='.' && input.LA(3)!='.' }?
				// real
			( '.' (DIGIT)+('_' (DIGIT)+)* ( EXPONENT )?)
		)
  ;

INTEGER_LIT : 
		(DIGIT)+('_' (DIGIT)+)*
		(
			( '#' BASED_INTEGER  '#' ( INT_EXPONENT )? )
			| (INT_EXPONENT)?
		)
  ;

//NUMERAL_LIT :	 (DIGIT)(('_')?DIGIT)*
//	;

//NUMERIC_LIT : 
//		( DIGIT )+
//		(( '#' BASED_INTEGER  '#' ( INT_EXPONENT )? )
//		| ( '_' ( DIGIT )+ )*  // INTEGER
//		  ( { input.LA(2)!='.' }?  //&& input.LA(3)!='.' }?
//		  //( { input.LA(2)!='.' && input.LA(3)!='.' }?
//				// real
//			( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )?)
//				// integer with exponent
//			| (INT_EXPONENT)?
//		  )
//		)
// ;
  /*
          catch [RecognitionException ex] {
            reportError(ex);
			input.consume();
          }
*/


// a couple protected methods to assist in matching the various numbers

fragment
DIGIT   :  ( '0'..'9' ) ;

fragment
EXPONENT           :  ('e') ('+'|'-')? ( DIGIT )+ ;

fragment
INT_EXPONENT           :  ('e') ('+')? ( DIGIT )+ 
	;
	/*
          catch [RecognitionException ex] {
            reportError(ex);
			input.consume();
          }
    */


fragment
EXTENDED_DIGIT     :  ( DIGIT | 'a'..'f' ) ;

fragment
BASED_INTEGER      :  ( EXTENDED_DIGIT ) ( ('_')? EXTENDED_DIGIT )* ;

fragment
BASE				: DIGIT ( DIGIT )?
;

// escape sequence -- note that this is protected; it can only be called
//   from another lexer rule -- it will not ever directly return a token to
//   the parser
// There are various ambiguities hushed in this rule.  The optional
// '0'...'9' digit matches should be matched here rather than letting
// them go back to STRING_LITERAL to be matched.  ANTLR does the
// right thing by matching immediately; hence, it's ok to shut off
// the FOLLOW ambig warnings.
fragment
ESC
	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	('u')+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
		|	'0'..'3'
			(
				/* options {
					warnWhenFollowAmbig = false;
				} */
				'0'..'7'
				(
					/* options {
						warnWhenFollowAmbig = false;
					} */
					'0'..'7'
				)?
			)?
		|	'4'..'7'
			(
				/* options {
					warnWhenFollowAmbig = false;
				} */
				'0'..'7'
			)?
		)
	;


// hexadecimal digit (again, note it's protected)
fragment
HEX_DIGIT
	:	('0'..'9'|
	//'A'..'F'|
	'a'..'f')
	;

WS    : ( ' '
        | '\r' '\n' 
        | '\r' 
        | '\n' 
        | '\t' 
        )
        {$channel=HIDDEN;}
      ;    
    
// multiple-line comments
// if we change the comment characters, we need to fix the unparser
// Unparser supports conversion of multi-line into single line comments.
//ML_COMMENT
//	:	"/*"
//		(	/*	'\r' '\n' can be matched in one alternative or by matching
//				'\r' in one iteration and '\n' in another.  I am trying to
//				handle any flavor of newline that comes in, but the language
//				that allows both "\r\n" and "\r" and "\n" to all be valid
//				newline is ambiguous.  Consequently, the resulting grammar
//				must be ambiguous.  I'm shutting this warning off.
//			 */
//			options {
//				generateAmbigWarnings=false;
//			}
//		:
//			{ input.LA(2)!='/' }? '*'
//			//{ input.LA(2)!='*' || input.LA(3) != '}' }? '*'
//		|	'\r' '\n'		
//		|	'\r'			
//		|	'\n'			
//		|	~('*'|'\n'|'\r')
//		)*
//		"*/"
//	;
     
// Annex text processing: derived from multiple-line comments
ANNEX_TEXT
	:	 
	'{**'
		(	/*	'\r' '\n' can be matched in one alternative or by matching
				'\r' in one iteration and '\n' in another.  I am trying to
				handle any flavor of newline that comes in, but the language
				that allows both "\r\n" and "\r" and "\n" to all be valid
				newline is ambiguous.  Consequently, the resulting grammar
				must be ambiguous.  I'm shutting this warning off.
			 */
			/*options {
				generateAmbigWarnings=false;
			}*/
		
			{ input.LA(2)!='*' || input.LA(3) != '}' }?=> '*'
		|	'\r'			
		|	'\n'			
		|	(~('*'|'\n'|'\r'))
		)*
		'**}'
	;
      
// Single-line comments
SL_COMMENT
	:	'--'
(~('\n'|'\r' ))* {$channel=COMMENT_CHANNEL;}
	;
 
 
