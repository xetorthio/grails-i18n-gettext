import grails.plugins.i18n_gettext.*

class T9nServiceTests extends GroovyTestCase{
	
	def t9nService
	StringWriter out
	T9nTagLib t9n


	protected void setUp() {
        super.setUp()
        
		out = new StringWriter()
        T9nTagLib.metaClass.out = out
        T9nService.metaClass.log = log
        
        t9n = new T9nTagLib()
        t9n.t9nService = new T9nService()
            }

	
    protected void tearDown() {
        super.tearDown()
    
        t9n.t9nService = null
        t9n = null
        
        def remove = GroovySystem.metaClassRegistry.&removeMetaClass
    	remove T9nTagLib
    }
	
    
    // Most of the following tests will not work as unit tests, because t9nService uses encodeAsHTML()
    
    
    void testTrAvailability() {
    	assert !t9nService.getCurrentLocale().equals("")
    }


    void testGetCurrentLocale() {
    	out.getBuffer().setLength(0)
    	assertToString t9n.getCurrentLocale(), "en"
    }
    

    void testTrParameters() {
    	// no parameters
    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.tr() 
    	}
    	
    	// wrong parameter order
    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.tr( locale:"de", s:"anything" ) 
    	}
    }
    
    
    void testTrFunctionality() {
    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"foo" ), "foo" 

    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"foo", locale:"de" ), "schnick" 

    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"foo{0}", f:42 ), "foo42" 

    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"foo{0}", f:42, locale:"de" ), "schnick42" 

    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"foo{0} and {1}", f:[42,"bar"] ), "foo42 and bar"
    }
    
    
    void testTrnParameters(){
    	// no parameters
    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trn() 
    	}
    	
    	
    	// wrong parameter count
    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trn( s:"singular" ) 
    	}

    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trn( s:"singular", p:"plural" ) 
    	}
    	
    	
    	// wrong parameter order
    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trn( p:"plural", n:0, s:"singular" ) 
    	}

    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trn( n:0, s:"singular", p:"plural" ) 
    	}

    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trn( s:"singular", n:0, p:"plural" ) 
    	}
    }
    
    
    void testTrnFunctionality(){
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo", p:"foos", n:1 ), "foo" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo", p:"foos", n:2 ), "foos" 

    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo{0}", p:"foos{1}", n:1, f:["bar", "bars", "baz", "bazs"] ), "foobar" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo{2}", p:"foos{3}", n:1, f:["bar", "bars", "baz", "bazs"] ), "foobaz" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo{0}", p:"foos{1}", n:2, f:["bar", "bars", "baz", "bazs"] ), "foosbars" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo{2}", p:"foos{3}", n:2, f:["bar", "bars", "baz", "bazs"] ), "foosbazs" 
    }
    
    
    void testTrnFunctionalityWithForcedLocale(){
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo", p:"foos", n:1, locale:"de" ), "schnick" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo", p:"foos", n:2, locale:"de" ), "schnicks" 

    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo{0}", p:"foos{1}", n:1, f:["bar", "bars", "baz", "bazs"], locale:"de" ), "schnickbar" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo{2}", p:"foos{3}", n:1, f:["bar", "bars", "baz", "bazs"], locale:"de" ), "schnickbaz" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo{0}", p:"foos{1}", n:2, f:["bar", "bars", "baz", "bazs"], locale:"de" ), "schnicksbars" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trn( s:"foo{2}", p:"foos{3}", n:2, f:["bar", "bars", "baz", "bazs"], locale:"de" ), "schnicksbazs" 
    	
    }
    
    
    void testTrcParameters(){
    	// no parameters
    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trc() 
    	}
    	
    	// wrong parameter count
    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trc( s:"singular" ) 
    	}

    	// wrong parameter order
    	out.getBuffer().setLength(0)
    	shouldFail( IllegalArgumentException ){
    		t9n.trc( s:"singular", c:"context" ) 
    	}
    }
    
    
    void testTrcFunctionality(){
    	out.getBuffer().setLength(0)
    	assertToString t9n.trc( c:"fish (verb)", s:"fish" ), "fish" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trc( c:"fish (noun)", s:"fish" ), "fish" 
    }
    
    
    void testTrcFunctionalityWithForcedLocale(){
    	out.getBuffer().setLength(0)
    	assertToString t9n.trc( c:"fish (verb)", s:"fish", locale:"de" ), "angeln" 
    	out.getBuffer().setLength(0)
    	assertToString t9n.trc( c:"fish (noun)", s:"fish", locale:"de" ), "Fisch" 
    }
    
    
    void testEscalation(){
    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"bar", locale:"de" ), "schnack" 

    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"bar", locale:"de_DE" ), "SCHNACK" 

    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"bar", locale:"de_CH" ), "schnackli" 

    	
    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"baz", locale:"de" ), "schnuck"	// "baz" is only translated in de.po 

    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"baz", locale:"de_DE" ), "schnuck"	// "baz" is missing in de_DE.po
    	
    	out.getBuffer().setLength(0)
    	assertToString t9n.tr( s:"baz", locale:"de_CH" ), "schnuck"	// "baz" is missing in de_CH.po 
    }    
        
}
