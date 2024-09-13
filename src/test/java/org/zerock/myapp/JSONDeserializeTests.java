package org.zerock.myapp;

import static org.junit.Assert.assertNotNull;

import java.util.List;
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
import org.zerock.myapp.domain.Human;
import org.zerock.myapp.domain.Person;

import com.cedarsoftware.util.io.JsonReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JSONDeserializeTests {
	private String json;
	// 역직렬화를 위해서, 가장먼저 해야할 일은,
	// JSON문자열로 표현된 객체를 찍어낼 수 있는 클래스를 만들어야 합니다.
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
		//Case1 - JSON 문자열
//		final String json="""
//							{
//			        "myName": "Yoon",
//			        "myAge": 23,
//			        "eyePower": 1.0,
//			        "gender" :  "female"
//			    }
//				""";
//		log.info("\t+ json :\n{}", json);
		
//		final String json = "[1, 2, 3]";
//				
//		log.info("\t+ json :\n{}", json);
		
//		final String json = """
//					   [
//	               {
//	                    "name": "NAME_0",
//	                    "age": 22,
//	                    "weight": 60.1,
//	                    "height": 170.1,
//	                    "isMale": true
//	                },
//	               {
//	                    "name": "NAME_1",
//	                    "age": 23,
//	                    "weight": 61.1,
//	                    "height": 171.1,
//	                    "isMale": false
//	                }
//	            ]
//				""";
		
		final String json = """
				{
					"@type":"org.zerock.myapp.domain.Bar",
					"id":2,
					"name":"Bar"
				}
				""";
		this.json = json;
	} // beforeAll
	
	@Disabled
	@Order(1)
	@Test
	@RepeatedTest(1)
	@DisplayName("1. testCase1")
	@Timeout(value=1L, unit=TimeUnit.SECONDS)
	// 주어진 JSON 문자열로부터, Human 타입의 객체로 역변화(역직렬화)
	void testCase1() {
		log.trace("testCase1() invoked.");
		
		Gson gson = new Gson();
		Human human = gson.<Human>fromJson(json, Human.class);
//		Objects.nonNull(human);
		assertNotNull(human);
		
		log.info("\t+ human : {}", human);
	} // testCase1
	
	@Disabled
	@Order(2)
	@Test
	@RepeatedTest(1)
	@DisplayName("2. testCase2")
	@Timeout(value=1L, unit=TimeUnit.SECONDS)
	// 주어진 JSON 문자열로부터, Human 타입의 객체로 역변화(역직렬화)
	void testCase2() {
		log.trace("testCase2() invoked.");
		
		Gson gson = new Gson();
		int[] list = gson.<int[]>fromJson(json, int[].class);
		assertNotNull(list);
		
		log.info("\t+ list : {}", list);
	} // testCase2
	
	@Disabled
	@Order(3)
	@Test
	@RepeatedTest(1)
	@DisplayName("3. testCase3")
	@Timeout(value=1L, unit=TimeUnit.SECONDS)
	// 주어진 JSON 문자열로부터, Human 타입의 객체로 역변화(역직렬화)
	void testCase3() {
		log.trace("testCase3() invoked.");
		
		Gson gson = new Gson();
		List<Person> person = gson.<List<Person>>fromJson(json, List.class);
		assertNotNull(person);
		
		log.info("\t+ list : {}", person);
	} // testCase3
	
	@Disabled
	@Order(4)
	@Test
	@RepeatedTest(1)
	@DisplayName("4. testJacksonDeSerialize")
	@Timeout(value=1L, unit=TimeUnit.SECONDS)
	// 주어진 JSON 문자열로부터, Human 타입의 객체로 역변화(역직렬화)
	void testJacksonDeSerialize() throws JsonProcessingException {
		log.trace("testJacksonDeSerialize() invoked.");
		final String json ="""
				{
					"id":2,
					"name":"Foo2"
				}
				""";
		ObjectMapper mapper = new ObjectMapper();
		
		Foo foo = mapper.readValue(json, Foo.class);
		assert foo != null;
		log.info("\t+ foo : {}", foo);
	} // testJacksonDeSerialize
	
//	@Disabled
	@Order(5)
	@Test
	@RepeatedTest(1)
	@DisplayName("5. testJSONIODeSerialize")
	@Timeout(value=1L, unit=TimeUnit.SECONDS)
	// json-io 라이브러리 이용해서, 직렬화 수행하는 방법을 배우자
	void testJSONIODeSerialize(){
		log.trace("testJSONIODeSerialize() invoked.");
		Bar bar = (Bar) JsonReader.jsonToJava(json);
		assertNotNull(bar);
		log.info("\t+ bar : {}", bar);
	} // testJSONIODeSerialize
} // end class
