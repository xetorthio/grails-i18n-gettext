package grails.plugins.i18n_gettext

/**
 * T9nTagLib - Tag library for translation (t9n) functions using gettext.
 * IMPORTANT NOTE: Althoug the tag attributes are named s, p, n, and so on, it is VITALLY IMPORTANT to keep their order
 * exactly like you see here. Why? When xgettext scans your code, it relies on the attribute order to find all singular
 * and plural forms of the original source texts. If you mess up the order of the attributes, xgettext will not find the
 * right strings to translate. xgettext does not know anything about named attributes.
 */
class T9nTagLib {
	
	def t9nService
	static namespace = "t9n"
	
	def tr = { attrs->
		out << t9nService.tr( attrs )
	}
	 
	def trn = { attrs ->
		out << t9nService.trn( attrs )
	}
	 
	def trc = { attrs ->
		out << t9nService.trc( attrs )
	}

	def marktr = { attrs ->
		out << t9nService.marktr( attrs )
	}

	def getCurrentLocale = { attrs ->
		out << t9nService.getCurrentLocale()
	}

}
