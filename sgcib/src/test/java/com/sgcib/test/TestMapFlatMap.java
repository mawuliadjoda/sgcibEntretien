package com.sgcib.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.sgcib.model.Country;

public class TestMapFlatMap {
	
	/**
	 * Exemple d'illustration de map() == > renvoie un seul élément
	 */
	@Test
	public void testMap() {
		
		List<String> myList = Stream.of("java", "python")
				  .map(String::toUpperCase)
				  .collect(Collectors.toList());
		assertEquals(Arrays.asList("JAVA", "PYTHON"), myList);		
	}
	
	/**
	 * la flatMap permet d'applatir
	 * elle renvoie un Stream qui peut contenir zéro ou plusieurs éléments
	 */
	@Test
	public void testFlatMap() {
		
		  List<String> list1 =  Arrays.asList("Java", "JEE");
	      List<String> list2 =  Arrays.asList("Angular","TypeScript");
	          List<String> finalList = Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList());
	      assertEquals(Arrays.asList("Java", "JEE", "Angular", "TypeScript"), finalList);
	      
	}
	
	
	/**
	 * exemple d'utilisation de map et flatMap
	 *
	 */
	@Test
	public void testMapAndFlatMap() {
		
		Country country1 = new Country("France");
		country1.setCities(Arrays.asList("Paris","Lyon"));
		
		Country country2 = new Country("USA");
		country2.setCities(Arrays.asList("New York","Los angelese"));
		
		List<Country> countries = new ArrayList<>();
		countries.add(country1);
		countries.add(country2);
		
		 List<String> cities =
				 countries.stream()
	                        .map(x -> x.getCities())      //Stream<List<String>>
	                        .flatMap(x -> x.stream())     //Stream<String>
	                        .distinct()
	                        .collect(Collectors.toList());

	     // cities.forEach(System.out::println);
	     
	     assertEquals(Arrays.asList("Paris", "Lyon", "New York", "Los angelese"), cities);
	        
			
	}
}
