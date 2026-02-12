package com.streams.training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
	
	public static void main(String... args) {
		List<Integer> numsList = Arrays.asList(5,2,1,4,3,7,9);
		
		Stream<Integer> numStream = numsList.stream();
//		numStream.filter(n -> (n%2) != 0).map(n -> n*n).sorted().forEach(System.out::println);
		List<Integer> sortedList = numStream.filter(n -> (n%2) != 0).map(n -> n*n).sorted().collect(Collectors.toList());
		
		sortedList.forEach(System.out::println);
	}
}
