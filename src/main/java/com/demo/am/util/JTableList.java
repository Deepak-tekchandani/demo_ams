package com.demo.am.util;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JTableList<L> implements Serializable {

	private static final long serialVersionUID = 6695625930049463695L;

	private String Result = "ERROR";
	private List<L> Records;
	private long TotalRecordCount;

}
