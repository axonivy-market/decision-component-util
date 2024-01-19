package com.axonivy.utils.approvaldecision.utils;

import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

public class SortFieldUtils {
	public static SortMeta buildSortMeta(String field, boolean isSortDescending) {
		return SortMeta.builder().field(field).order(isSortDescending ? SortOrder.DESCENDING : SortOrder.ASCENDING)
				.build();
	}
}
