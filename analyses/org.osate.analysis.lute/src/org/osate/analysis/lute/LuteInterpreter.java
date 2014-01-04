/*
Copyright (c) 2011, Rockwell Collins.
Developed with the sponsorship of the Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, 
including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/

package org.osate.analysis.lute;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.lute.language.AADLVal;
import org.osate.analysis.lute.language.Command;
import org.osate.analysis.lute.language.EmptyEnv;
import org.osate.analysis.lute.language.Environment;
import org.osate.analysis.lute.language.LuteLexer;
import org.osate.analysis.lute.language.LuteParser;
import org.osate.analysis.lute.language.SetVal;
import org.osate.analysis.lute.language.Val;
import org.slf4j.Logger;


public class LuteInterpreter {
	private final Element context;
	private final Logger log;

	public LuteInterpreter(	final Element p_context,
							final Logger p_logger ) {
		super();
		
		context = p_context;
		log = p_logger;
	}

	public void run(List<Command> program) {
		Environment env = createInitialEnvironment();
		for (Command cmd : program) {
			try {
				env = cmd.exec(env, log);
				
			}
			catch (NullPointerException npe)
			{
				DialogConsole.setLogRed();
				log.error("Command failed: " + npe.getMessage());
				npe.printStackTrace();	
			}
			catch (LuteException e) 
			{
				DialogConsole.setLogRed();
				log.error("Command failed: " + e.getMessage());
				e.printStackTrace();
			}
			log.info("Successfully done!");
		}
	}
	
	public void run(InputStream input) {
		List<Command> commands = parseStream(input);
		if (commands != null) {
			run(commands);
		}
	}
	private Environment createInitialEnvironment() {
		final NamedElement rootElem = context.getElementRoot();
		
		if ( rootElem instanceof InstanceObject ) {
			return createInitialEnvironment( (InstanceObject) rootElem );
		}

		return createInitialEnvironment( (AadlPackage) rootElem );
	}
	
	private static Environment createEnvironment( final NamedElement p_element ) {
		Environment env = new EmptyEnv();
		env = env.add( LuteConstants.SELF, new AADLVal( p_element ) );
		
		return env;
	}
	
	public static Environment createInitialEnvironment( final InstanceObject p_instanceObject ) {
		Environment env = createEnvironment( p_instanceObject );
		
		final ComponentInstance rootSystemInstance = (ComponentInstance) p_instanceObject.getElementRoot();
		final List<ComponentInstance> components = rootSystemInstance.getAllComponentInstances();
		
		for ( final ComponentCategory category : ComponentCategory.VALUES ) {
			env = env.add( LuteConstants.luteSetName( category.getName() ), filterComponents(components, category ) );
		}
		
		final List<Val> conns = new ArrayList<Val>();
		
		for ( final ConnectionInstance ci : rootSystemInstance.getConnectionInstances()) {
			conns.add(new AADLVal(ci));
		}
		
		env = env.add( LuteConstants.CONNECTION_SET, new SetVal(conns) );
		
		return env;
	}
 	
	public static Environment createInitialEnvironment( final NamedElement p_element ) {
		Environment env = createEnvironment( p_element );
		
		final AadlPackage aadlPackage = (AadlPackage) p_element.getElementRoot();

		for ( final ComponentCategory category : ComponentCategory.VALUES ) {
			final String catName = category.getName();
			final String eClassName = LuteConstants.capitalizeName( catName, "", "Subcomponent" );
			final EClassifier eClassSub = Aadl2Package.eINSTANCE.getEClassifier( eClassName );
			env = env.add( LuteConstants.luteSetName( catName ), getAllContainedElements( aadlPackage, eClassSub , new HashSet<ModelUnit>() ) );
		}
		
		env = env.add( LuteConstants.CONNECTION_SET, getAllContainedElements( aadlPackage, Aadl2Package.eINSTANCE.getConnection(), new HashSet<ModelUnit>() ) );
		
		return env;
	}
	
	private static SetVal getAllContainedElements( 	final AadlPackage p_package,
			final EClassifier p_class,
			final Set<ModelUnit> p_traversedUnits ) {
		final Set<Val> elements = new LinkedHashSet<Val>();

		final Iterator<EObject> containedElementsIt = p_package.eAllContents();

		while ( containedElementsIt.hasNext() ) {
			final EObject element = containedElementsIt.next();

			if ( p_class.isInstance( element ) ) {
				elements.add( new AADLVal( (NamedElement) element ) );
			}
		}

		modelDependencies( p_package, p_traversedUnits );
		final Set<ModelUnit> tempSet = new HashSet<ModelUnit>( );
		tempSet.remove( p_package );

		for ( final ModelUnit modelUnit : tempSet ) {
			if ( modelUnit instanceof AadlPackage ) {
				elements.addAll( getAllContainedElements( (AadlPackage) modelUnit, p_class, p_traversedUnits ).getSet() );
			}
		}

		return new SetVal( new ArrayList<Val>( elements ) );
	}
	
	private Val allComponents(List<ComponentInstance> components) {
		Collection<Val> result = new ArrayList<Val>();
		for (ComponentInstance ci : components) {
			result.add(new AADLVal(ci));
		}
		return new SetVal(result);
	}

	private static SetVal filterComponents(	final List<ComponentInstance> components, 
			final ComponentCategory category ) {
final List<Val> result = new ArrayList<Val>();

for (ComponentInstance ci : components) {
if (ci.getCategory() == category) {
result.add(new AADLVal(ci));
}
}
return new SetVal(result);
}


	private List<Command> parseStream(InputStream stream) {
		try {
			CharStream charStream = new ANTLRInputStream(stream);
			LuteLexer lexer = new LuteLexer(charStream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			LuteParser parser = new LuteParser(tokenStream, log);
			List<Command> result = parser.rule();
			if (parser.getNumberOfSyntaxErrors() > 0) {
				log.error("Unable to read lute program due to parse errors");
				return null;
			} else {
				return result;
			}
		} catch (IOException e) {
			log.error("Unable to read lute program: " + e.getMessage());
			e.printStackTrace();
		} catch (RecognitionException e) {
			log.error("Unable to parse lute program: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	

	private static void modelDependencies( 	final ModelUnit p_modelUnit,
											final Set<ModelUnit> p_modelUnits ) {
		p_modelUnits.add( p_modelUnit );
		
		if ( p_modelUnit instanceof AadlPackage ) {
			final AadlPackage aadlPackage = (AadlPackage) p_modelUnit;
			PackageSection section =  aadlPackage.getOwnedPrivateSection();
			
			if ( section != null ) {
				modelDependencies( section.getImportedUnits(), p_modelUnits );
			}
			
			section =  aadlPackage.getOwnedPublicSection();
			
			if ( section != null ) {
				modelDependencies( section.getImportedUnits(), p_modelUnits );
			}
		}
		else if ( p_modelUnit instanceof PropertySet ) {
			final PropertySet propSet = (PropertySet) p_modelUnit;
			modelDependencies( propSet.getImportedUnits(), p_modelUnits );
		}
	}
	
	private static void modelDependencies( 	final Collection<ModelUnit> p_imports,
											final Set<ModelUnit> p_modelUnits ) {
		for ( final ModelUnit modUnit : p_imports ) {
			
			// There may be circular dependencies between packages and property sets.
			if ( !p_modelUnits.contains( modUnit ) ) {
				modelDependencies( modUnit, p_modelUnits );
			}
		}
	}
	
	public static List<Command> parse(	final String p_expression,
			final Logger p_logger )
throws RecognitionException {
try  {
return parseStream( new ByteArrayInputStream( p_expression.getBytes() ), p_logger );
}
catch ( final IOException p_ex ) {
// Should not happen with a ByteArrayInputStream.
throw new IllegalStateException( p_ex );
}
}

private static List<Command> parseStream(	final InputStream p_stream,
					final Logger p_logger ) 
throws IOException, RecognitionException {
CharStream charStream = new ANTLRInputStream( p_stream );
LuteLexer lexer = new LuteLexer( charStream, p_logger );
TokenStream tokenStream = new CommonTokenStream(lexer);
LuteParser parser = new LuteParser( tokenStream, p_logger );

return parser.rule();
}
}
