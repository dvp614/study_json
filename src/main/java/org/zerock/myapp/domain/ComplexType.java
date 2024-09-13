package org.zerock.myapp.domain;

import java.util.Set;

import lombok.Data;

@Data
public class ComplexType {
	private int[] field1;
	private Foo field2;
	private Bar field3;
	private Person field4;
	private Set<Integer> field5;
} // end class
