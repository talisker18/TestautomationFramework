package com.henz.joel.testcases;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class ParamProvider {
	
	static Stream<Arguments> sourceList_StringDoubleStream(){
		return Stream.of(Arguments.arguments("tomato", 2.0), 
				Arguments.arguments("carrot", 3.5), 
				Arguments.arguments("cabbage", 5.3)
				);
	}
}
