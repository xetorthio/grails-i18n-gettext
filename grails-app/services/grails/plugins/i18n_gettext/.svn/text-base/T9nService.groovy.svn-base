package grails.plugins.i18n_gettext

//
//   Copyright 2008 Rainer Brang
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
//

import java.text.MessageFormat
import java.util.Locale
import org.xnap.commons.i18n.*
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.springframework.web.context.request.RequestContextHolder as RCH
import java.lang.IllegalArgumentException

class T9nService {

    static transactional = false
    
    
    /**
     * @param s - the text to translate
     * @param f - the messageFormat of single
     * @param locale - the locale to translate into
     * @param sourceLocale - the locale of the source
     * @return the translation of single
     */
	def tr = { attrs ->
	
		if( !attrs || !attrs.s ){
			throwError "method [tr] requires attribute [s] but got null"
		}
		
		if( attrs?.c ){
			log?.info "method [tr] does not accept attribute [c]"
		}
		if( attrs?.p ){
			log?.info "method [tr] does not accept attribute [p]"
		}
		if( attrs?.n ){
			log?.info "method [tr] does not accept attribute [n]"
		}
		
		// check attribute order
		def theKeys = attrs.keySet().toArray();
		if( !"s".equals(theKeys[0]) ){
			throwError "Tag [tr] requires attribute [s] to be the first attribute"
		}
	
		def i18n = getI18nObject( attrs.locale, attrs.sourceLocale )
		def theTrans = i18n ? (i18n.tr( attrs.s, (Object[])attrs.f)) : (MessageFormat.format(attrs.s, (Object[])attrs.f))
				
		if( attrs?.encoding=="none" ){
			return theTrans
		} else {
			return theTrans.encodeAsHTML()
		}
	}     


	/**
	 * trn - translation of plural strings.
	 * @param s singular string to translate
	 * @param p plural string to translate
	 * @param n number which decides between singular and plural form
	 * @param f optional arguments to messageFormat if you are using {0}, {1}... in your singular or plural string
	 * @param locale optional argument to set the locale you want to translate to
	 * @param sourceLocale optional argument to set the locale of the original string
	 * @return translated string in singular or plural form, depending on what n is
	 **/
	def trn = { attrs ->
	
		if( !attrs || !attrs.s || !attrs.p ){
			throwError "method [trc] requires attribute [s] and [p] but got at least one of them as null"
		}
		
		if( !attrs.n ){
			throwError "method [trn] requires attribute [n]"
		}
		if( attrs?.c ){
			log?.info("method [trn] does not accept attribute [c]")
		}
		
		// check attribute order
		def theKeys = attrs.keySet().toArray();
		if( !"s".equals( theKeys[0] ) ){
			throwError "method [trn] requires attribute [s] to be the first attribute"
		}
		if( !"p".equals( theKeys[1] ) ){
			throwError "method [trn] requires attribute [p] to be the second attribute"
		}
		if( !"n".equals( theKeys[2] ) ){
			throwError "method [trn] requires attribute [n] to be the third attribute"
		}
		
		def i18n = getI18nObject( attrs.locale, attrs.sourceLocale )
		def theTrans = i18n ? (i18n.trn( attrs.s, attrs.p, attrs.n, (Object[])attrs.f )) : (attrs.n>1? (MessageFormat.format(attrs.p, (Object[])attrs.f)) : (MessageFormat.format(attrs.s, (Object[])attrs.f)) )
				
		if( attrs?.encoding=="none" ){
			return theTrans
		} else {
			return theTrans.encodeAsHTML()
		}
				
	}

	
	/**
	 * trc - translation with comment, disambiguates translation text.
	 * @param c context of the singular string
	 * @param s singular string to translate
	 * @param locale optional argument to set the locale you want to translate to
	 * @param sourceLocale optional argument to set the locale of the original string
	 * @return translated string
	 **/
	def trc = { attrs ->
		if( !attrs || !attrs.s ){
			throwError "method [trc] requires attribute [s] but got null"
		}
		if( !attrs.c ){
			throwError "method [trc] requires attribute [c]"
		}
		if( attrs?.p ){
			log?.info("method [trc] does not accept attribute [p]")
		}
		if( attrs?.n ){
			log?.info("method [trc] does not accept attribute [n]")
		}
		if( attrs?.f ){
			log?.info("method [trc] does not accept attribute [f]")
		}
		
		
		// check attribute order
		def theKeys = attrs.keySet().toArray();
		if( !"c".equals( theKeys[0] ) ){
			throwError("method [trc] requires attribute [c] to be the first attribute")
		}
		if( !"s".equals( theKeys[1] ) ){
			throwError("method [trc] requires attribute [s] to be the second attribute")
		}
		
		def i18n = getI18nObject( attrs.locale, attrs.sourceLocale )
		def theTrans = i18n ? (i18n.trc( attrs.c, attrs.s, false )) : (attrs.s)
				
		if( attrs?.encoding=="none" ){
			return theTrans
		} else {
			return theTrans.encodeAsHTML()
		}
				
	}   	
	 
	 
	/**
	 * marktr - mark for translation, but always return the original string.
	 * @param s singular string to translate
	 * @return original untranslated string
	 **/
	def marktr = { attrs ->
		if( !attrs || !attrs.s ){
			throwError "method [marktr] requires attribute [s] but got null"
		}
		if( attrs?.c ){
			log?.info("method [marktr] does not accept attribute [c]")
		}
		if( attrs?.p ){
			log?.info("method [marktr] does not accept attribute [p]")
		}
		if( attrs?.n ){
			log?.info("method [marktr] does not accept attribute [n]")
		}
		if( attrs?.f ){
			log?.info("method [marktr] does not accept attribute [f]")
		}
		if( attrs?.locale ){
			log?.info("method [marktr] does not accept attribute [locale]")
		}
		if( attrs?.sourceLocale ){
			log?.info("method [marktr] does not accept attribute [sourceLocale]")
		}
		
		// check attribute order
		def theKeys = attrs.keySet().toArray();
		if( !"s".equals( theKeys[0] ) ){
			throwError("Tag [tr] requires attribute [s] to be the first attribute")
		}

		// we are not interested in the current locale, we just force the source code locale. marktr does not return a translated string, anyway.
		def i18n = getI18nObject( null, ApplicationHolder?.application?.config?.I18nGettext?.sourceCodeLocale ?:"en" )
		def theTrans = i18n ? (i18n.marktr(attrs.s)) : (attrs.s)
				
		if( attrs?.encoding=="none" ){
			return theTrans
		} else {
			return theTrans.encodeAsHTML()
		}
				
	}	 
    
    
	/**
	 * getCurrentLocale - get the current locale
	 * Get the current locale - either from the session, or from the browser's language
	 * @return the current locale as a string
	 **/
	def getCurrentLocale = { ->
		
		def currentLocale = null
		
		try{
			def request = RCH.currentRequestAttributes().currentRequest
			def session = RCH.currentRequestAttributes().session

			currentLocale = session?.getAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE")
			currentLocale = currentLocale?currentLocale:request?.getLocale()
		} catch( Exception e ){
			// no implementation. This could be an IllegalStateException because we try to access the session during bootstrap when there is no session available... 
		}
				
		// Fallbacks		
		if( !currentLocale ){
			currentLocale = ApplicationHolder?.application?.config?.I18nGettext?.sourceCodeLocale ?:"en"			
		}
		
		return currentLocale.toString()		
	}
    
    
    /**
     * Get an I18n from the I81nFactoy and set the current locale and source code locale.
     */
	private getI18nObject( wantLocale=null, forceSourceCodeLocale=null ) {
    	
		def i18n = null
		try{
			
			def language = ""
			def country = ""
			def variant = ""
			
			// use locale string forced by the method call or from the session.
			if ( !wantLocale ){
				wantLocale = getCurrentLocale()
			}
			def wantedLocale = null
			try{
				language = wantLocale?.split("_")[0].toLowerCase()
				country = wantLocale?.split("_")[1].toUpperCase()
				variant = wantLocale?.split("_")[2]
			} catch( ArrayIndexOutOfBoundsException aioe0 ){
				// ignore
			}
			wantedLocale = new Locale( language, country, variant )
			
			// use source code locale string forced by the method call or from config or use the bailout "en"
			if ( !forceSourceCodeLocale ){
				forceSourceCodeLocale = ApplicationHolder?.application?.config?.I18nGettext?.sourceCodeLocale ?:"en"
			}
			def wantedSourceCodeLocale = null
			language = ""
			country = ""
			variant = ""
			try{
				language = forceSourceCodeLocale?.split("_")[0].toLowerCase()
				country = forceSourceCodeLocale?.split("_")[1].toUpperCase()
				variant = forceSourceCodeLocale?.split("_")[2]
			} catch( ArrayIndexOutOfBoundsException aioe1 ){
				// ignore
			}
			wantedSourceCodeLocale = new Locale( language, country, variant )
			
			i18n = I18nFactory.getI18n( T9nService.class, "i18ngettext.Messages" )
			i18n.setSourceCodeLocale( wantedSourceCodeLocale )
			i18n.setLocale( wantedLocale )
			
		} catch( MissingResourceException mre ){
			log.error( mre.getMessage()+". Key: "+mre.getKey()+" Class: "+mre.getClassName() )
			return null
		}
		return i18n
	}
    

    private throwError( String message ){
    	throw new IllegalArgumentException( message );
    }
	
}