package com.axonivy.utils.decisioncomponent.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import ch.ivyteam.ivy.environment.Ivy;

public class DateUtils {

	private static final String DD_MM_YYYY_HH_MM = "dd.MM.yyyy HH:mm";
	private static final String YYYY_MM_DD_HH_MM_SS = "yyyy.MM.dd HH:mm:ss";

	public static String getFormattedDateTime(LocalDateTime dateTime) {
		if (Objects.isNull(dateTime)) {
			return StringUtils.EMPTY;
		}
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(extractDateTimePattern());
		return formatter.format(dateTime);
	}

	public static String getSortableFormattedDateTime(LocalDateTime dateTime) {
		if (Objects.isNull(dateTime)) {
			return StringUtils.EMPTY;
		}
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
		return formatter.format(dateTime);
	}

	private static String extractDateTimePattern() {
		String pattern = Ivy.cms().co("/Labels/DateTimePattern");
		if (pattern == null || pattern.isBlank()) {
			pattern = DD_MM_YYYY_HH_MM;
		}

		return pattern;
	}
}
