package com.saks.display;

import java.util.stream.Stream;

public class TestHarness {

	public static void main(String[] args) {
		Stream<Integer> numbers = Stream.iterate(0, n -> n + 1);
		numbers.limit(100).forEach(System.out::println);
	}

}
