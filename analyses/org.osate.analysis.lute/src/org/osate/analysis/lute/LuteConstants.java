package org.osate.analysis.lute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

import org.osate.aadl2.ComponentCategory;

public class LuteConstants {

	// Property
	public static final String PROPERTY = "Property";
	public static final String PROPERTY_CONSTANT = "Property_Constant";
	public static final String PROPERTY_EXISTS = "Property_Exists";

	public static final String SOURCE = "Source";
	public static final String DESTINATION = "Destination";

	public static final String OWNER = "Owner";
	public static final String IS_SUBCOMPONENT_OF = "Is_Subcomponent_Of";
	public static final String IS_DIRECT_SUBCOMPONENT_OF = "Is_Direct_Subcomponent_Of";
	public static final String IS_OF_TYPE = "Is_Of_Type";
	public static final String IS_BOUND_TO = "Is_Bound_To";
	
	public static final String GET_FEATURE = "Get_Feature";
	public static final String ASSOCIATED_DATA = "Associated_Data";
	public static final String ASSOCIATED_CLASSIFIER = "Associated_Classifier";
	
	public static final String RECORD_VALUE = "record_value";
	// Sets
	public static final String CONNECTION_SET = "Connection_Set";
	public static final String MEMBER = "Member";
	public static final String MAX = "Max";
	public static final String MIN = "Min";
	public static final String SUM = "Sum";
	public static final String CARDINAL = "Cardinal";
	public static final String FIRST = "First";
	public static final String FOR = "for";
	public static final String AT = "At";
	public static final String LAST = "Last";
	public static final String LOWER = "Lower";
	public static final String UPPER = "Upper";
	
	public static final String CONCAT = "Concat";
	public static final String SUBSTRING = "Substring";
	public static final String INDEX_OF = "Index_Of";
	public static final String LENGTH = "Length";
	
	public static final String EQUALS = "=";
	public static final String NOT_EQUALS = "!=";
	public static final String GREATER_THAN = ">";
	public static final String LESS_THAN = "<";
	public static final String GREATER_THAN_OR_EQUALS = ">=";
	public static final String LESS_THAN_OR_EQUALS = "<=";

	public static final String IS_EVENT_PORT = "is_event_port";
	public static final String IS_DATA_PORT = "is_data_port";
	public static final String IS_EVENT_DATA_PORT = "is_event_data_port";
	
	public static final String HAS_IN_PORTS = "has_in_ports";
	public static final String HAS_OUT_PORTS = "has_out_ports";
	public static final String NAME = "Name";
	
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	public static final String MULTIPLY = "*";
	public static final String DIVIDE = "/";
	public static final String POWER = "^";
	
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String NOT = "not";
	public static final String SELF = "Self";
	public static final String THEOREM = "theorem";
	public static final String END = "end";
	public static final String FOREACH = "foreach";
	public static final String IN = "in";
	public static final String DO = "do";
	public static final String CHECK = "check";
	public static final String PRINT = "print";
	public static final String IF = "if";
	public static final String THEN = "then";
	public static final String ELSE = "else";
	public static final String AND = "and";
	public static final String OR = "or";

    private static final String[] BASIC_LUTE_KEYWORDS = {
    	AND,
    	CONNECTION_SET,
    	HAS_IN_PORTS,
    	HAS_OUT_PORTS,
    	SOURCE,
    	DESTINATION,
    	LOWER,
    	UPPER,
    	MEMBER,
    	CHECK,
    	ASSOCIATED_DATA,
    	ASSOCIATED_CLASSIFIER,
    	GET_FEATURE,
    	IS_EVENT_PORT,
    	IS_DATA_PORT,
    	IS_EVENT_DATA_PORT,
    	PROPERTY,
    	DO,
    	ELSE,
    	END,
    	FALSE,
    	FOR,
    	FOREACH,
    	IF,
    	IN,
    	NOT,
    	OR,
    	PRINT,
    	THEN,
    	SELF,
    	PROPERTY_CONSTANT,
    	THEOREM,
    	TRUE,
    };
    
    public static final String[] LUTE_KEYWORDS;
    
    static {
    	final Collection<String> keyWords = new ArrayList<String>( Arrays.asList( BASIC_LUTE_KEYWORDS ) );
    	
		for ( final ComponentCategory category : ComponentCategory.VALUES ) {
			keyWords.add( luteSetName( category.getName() ) );
		}
		
		LUTE_KEYWORDS = keyWords.toArray( new String[ keyWords.size() ] );
    }
	
    public static String luteSetName (final String p_categoryName ) {
		return capitalizeName( p_categoryName, "_", "set" );
	}

	public static String capitalizeName( 	final String p_categoryName,
											final String p_replacementStr,
											final String p_suffix ) {
		final StringTokenizer tokenizer = new StringTokenizer( p_categoryName, "\\ " );
		final StringBuilder luteSetNameBdr = new StringBuilder();
		
		while ( tokenizer.hasMoreTokens() ) {
			final String token = tokenizer.nextToken();
			luteSetNameBdr.append( token.substring( 0, 1 ).toUpperCase() );
			luteSetNameBdr.append( token.substring( 1 ) );
			luteSetNameBdr.append( p_replacementStr );
		}
		
		luteSetNameBdr.append( p_suffix );
		
		return luteSetNameBdr.toString();
	}
}
