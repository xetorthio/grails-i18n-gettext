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

class I18nGettextGrailsPlugin {
    def observe = ['*']
    def version = 0.94

    def author = "Rainer Brang, Backend-Server GmbH & Co. KG"
    def authorEmail = "info@backend-server.de"
    def title = "I18n gettext plugin for grails"
    def description = """This plugin adds i18n support to your app, in 'gnu gettext'-style.
1 First, you need to wrap special tags or service calls around all strings you want to translate.
2 Then you call "grails i18n-gettext" to extract all translatable strings from your sources.
3 Now you translate all strings from step 2 which you will find in .po files in your i18n directory.
4 Call "grails i18n-gettext makemo" to compile your translated .po files into resource classes.
5 repeat 1-4 each time you added some new strings to your application. Existing translations will be merged in. 

During runtime: The methods, you wrapped around the strings, will pick the correct translation according to the
current locale, and return the translated string. You may also force a locale for a specific call.

What you need: The developer needs these command line tools for the development machine: xgettext, msgmerge and msgfmt
The translator may like: PoEdit or alike to translate texts.

You will love the dead simple plural form handling and FormatMessage-like String handling. Additionally, you can 
forget about inventing lookup keys for your .properties files, because for gnu gettext, the original string is the key.
Plus: No more problems with special chars like german umlauts. gettext can handle that.

You can exclude directories from being scanned for translatable strings in your Config.groovy file.

Beware: 
a) Gnu gettext can not handle groovy's "here-doc" strings, so don't try to wrap tr() or alike around them. Also some
xgettext binaries seem to dislike here-doc strings so much, they don't parse files containing here-doc files correctly.
b) Your original strings should be english, because Gnu gettext can't cope with non-ascii characters as original strings.

Many thanks to:
Donal Murtagh for testing and giving valuable feedback and ideas!
"""

    /**
     * URL to the plugin's documentation
     */ 
    def documentation = "http://www.grails.org/I18n-gettext+Plugin"

}
