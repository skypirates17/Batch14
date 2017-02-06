package com.batch.fourteen.utils;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;


/**
 * 
 * @author Johnrey Angolluan
 * @since January 2016
 */
public class Util {

	public static boolean isNullOrEmpty(String s) {
		return StringUtils.isBlank(s);
	}

	public static boolean isNullOrEmpty(final Collection<?> c) {
		return CollectionUtils.isEmpty(c);
	}

	public static boolean isNullOrEmpty(final Map<?, ?> m) {
		return MapUtils.isEmpty(m);
	}

	public static String toString(Object o) {
		return o == null ? null : String.valueOf(o);
	}
	
	public static String toString(Object o, boolean convertToEmptyIfNull) {
		return o == null ? "" : String.valueOf(o);
	}
}
