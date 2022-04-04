package com.test.exam03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExam {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("abba","chemical","brand");
		
		//for(String str:list) System.out.println(str);
		
		Stream<String> listStream = list.stream();
		System.out.println(listStream);
		
	}

}
