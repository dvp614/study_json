package org.zerock.myapp;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.zerock.myapp.domain.Bar;
import org.zerock.myapp.domain.Foo;

import com.cedarsoftware.util.io.JsonWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JSONSerializeTests {
	private Object obj;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
//		====================================
//		CASE 1
//		====================================
//		Person person = new Person();
//		person.setName("Yoon");
//		person.setAge(23);
//		person.setWeight(81);
//		person.setHeight(174);
//		person.setMale(true);
//		
//		log.info("\t+ person : {}", person);
		
//		====================================
//		CASE 2
//		====================================
//		List<Person> list = new ArrayList<>();
//		for(int counter=0; counter < 2; counter++) {
//			Person person = new Person();
//			
//			person.setName("NAME_"+ counter);
//			person.setAge(counter);
//			person.setWeight(81 + counter);
//			person.setHeight(170 +counter);
//			person.setMale((counter == 0)? true : false);
//			
//			list.add(person);
//		} // for
//		
//		log.info("\t+ List<Person> : {}", list);
//		
//		
//		this.obj = list;
		
//		====================================
//		CASE 3
//		====================================
//		Map<String, Person> map = new HashMap<>();
//		for(int counter=0; counter < 2; counter++) {
//			Person person = new Person();
//			
//			person.setName("NAME_"+ counter);
//			person.setAge(counter);
//			person.setWeight(81 + counter);
//			person.setHeight(170 +counter);
//			person.setMale((counter == 0)? true : false);
//			
//			map.put(String.valueOf(counter), person);
//		} // for
//		log.info("\t+ Map<Person> : {}", map);
//		
//		this.obj = map;
		
//		====================================
//		CASE 4
//		====================================
//		Set<Person> set = new HashSet<>();
//		for(int counter=0; counter < 2; counter++) {
//			Person person = new Person();
//			
//			person.setName("NAME_"+ counter);
//			person.setAge(counter);
//			person.setWeight(81 + counter);
//			person.setHeight(170 +counter);
//			person.setMale((counter == 0)? true : false);
//			
//			set.add(person);
//		} // for
//		log.info("\t+ Map<Person> : {}", set);
//		
//		this.obj = set;
		
//		====================================
//		CASE 5
//		====================================
//		Map<Integer, Person> map = new HashMap<>();
//		for(int counter=0; counter < 2; counter++) {
//			Person person = new Person();
//			
//			person.setName("NAME_"+ counter);
//			person.setAge(counter);
//			person.setWeight(81.4 + counter);
//			person.setHeight(170.1 +counter);
//			person.setMale((counter == 0)? true : false);
//			
//			map.put(counter, person);
//		} // for
//		log.info("\t+ Map<Person> : {}", map);
//		
//		this.obj = map;
		
//		====================================
//		CASE 6
//		====================================
//		int[] array = {1, 2, 3};
//		log.info("\t+ array : {}", array);
//		
//		this.obj = array;
		
//		====================================
//		CASE 7
//		====================================
//		String[] array = {"S1", "S2", "S3"};
//		log.info("\t+ array : {}", Arrays.toString(array));
//				
//		this.obj = array;
		
//		====================================
//		CASE 8
//		====================================
//		ComplexType complex = new ComplexType();
//		
//		// field1
//		complex.setField1(new int[] {1, 2, 3});
//		
//		Foo foo = new Foo();
//		foo.setId(01);
//		foo.setName("NAME1");
//		
//		// field2
//		complex.setField2(foo);
//		
//		Bar bar = new Bar();
//		bar.setId(02);
//		bar.setName("NAME2");
//		
//		// field3
//		complex.setField3(bar);
//		
//		Person person = new Person();
//		person.setName("Yoon");
//		person.setAge(23);
//		person.setWeight(81);
//		person.setHeight(174);
//		person.setMale(true);
//		
//		//field4
//		complex.setField4(person);
//		
//		//field5
//		complex.setField5(Set.<Integer>of(1, 2, 3, 4, 5, 6, 7));
//		
//		
//		this.obj = complex;
	} // beforeAll
	
	@Disabled
	@Order(1)
	@Test
	@RepeatedTest(1)
	@DisplayName("1. Person -> JSON")
	@Timeout(1L)
	void testCase1() {
		log.trace("testCase() invoked.");
		
		Gson gson = new Gson();
		String json = gson.toJson(this.obj);
		log.info("\t+ json : {}", json);
		
		
	} // testCase1
	
	@Disabled
	@Order(2)
	@Test
	@RepeatedTest(1)
	@DisplayName("2. List<Person> -> JSON")
	@Timeout(1L)
	void testCase2() {
		log.trace("testCase2() invoked.");
		
		Gson gson = new Gson();
		String json = gson.toJson(this.obj);
		
		log.info("\t+ json : {}", json);
	} // testCase2
	
	@Disabled
	@Order(3)
	@Test
	@RepeatedTest(1)
	@DisplayName("3. Set<Person> -> JSON")
	@Timeout(1L)
	void testCase3() {
		log.trace("testCase3() invoked.");
		
		Gson gson = new Gson();
		String json = gson.toJson(this.obj);
		log.info("\t+ json : {}", json);
	} // testCase3
	
	
	@Disabled
	@Order(4)
	@Test
	@RepeatedTest(1)
	@DisplayName("4. Set<Person> -> JSON")
	@Timeout(1L)
	void testCase4() {
		log.trace("testCase4() invoked.");
		
		Gson gson = new Gson();
		String json = gson.toJson(this.obj);
		log.info("\t+ json : {}", json);
	} // testCase4
	
	@Disabled
	@Order(5)
	@Test
	@RepeatedTest(1)
	@DisplayName("5. Map<Integer, Person> -> JSON")
	@Timeout(1L)
	void testCase5() {
		log.trace("testCase5() invoked.");
		
		Gson gson = new Gson();
		String json = gson.toJson(this.obj);
		log.info("\t+ json : {}", json);
	} // testCase5
	
	@Disabled
	@Order(6)
	@Test
	@RepeatedTest(1)
	@DisplayName("6. int Array -> JSON")
	@Timeout(1L)
	void testCase6() {
		log.trace("testCase6() invoked.");
		
		Gson gson = new Gson();
		String json = gson.toJson(this.obj);
		log.info("\t+ json : {}", json);
	} // testCase6
	
	@Disabled
	@Order(7)
	@Test
	@RepeatedTest(1)
	@DisplayName("7. String Array -> JSON")
	@Timeout(1L)
	void testCase7() {
		log.trace("testCase7() invoked.");
		
		Gson gson = new Gson();
		String json = gson.toJson(this.obj);
		log.info("\t+ json : {}", json);
	} // testCase7
	
	@Disabled
	@Order(8)
	@Test
	@RepeatedTest(1)
	@DisplayName("8. testJacksonSerialize")
	@Timeout(value=1L, unit=TimeUnit.SECONDS)
	void testJacksonSerialize() throws JsonProcessingException {
		log.trace("testJacksonSerialize() invoked.");
		
		Foo foo = new Foo();
		
		foo.setId(1);
		foo.setName("Foo");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(foo);
		
		assert json != null;
		log.info("\t+ json : {}", json);
	} // testJacksonSerialize
	
//	@Disabled
	@Order(9)
	@Test
	@RepeatedTest(1)
	@DisplayName("9. testJSONIOSerialize")
	@Timeout(value=1L, unit=TimeUnit.SECONDS)
	// json-io 라이브러리 이용해서, 직렬화 수행하는 방법을 배우자
	void testJSONIOSerialize(){
		log.trace("testJSONIOSerialize() invoked.");
		
		Bar bar = new Bar();
		bar.setId(2);
		bar.setName("Bar");
		
		String json = JsonWriter.objectToJson(bar);
		assert json != null;
		log.info("\t+ json : {}", json);
	} // testJSONIOSerialize
} // end class
