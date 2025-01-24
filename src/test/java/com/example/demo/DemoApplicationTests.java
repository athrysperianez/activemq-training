package com.example.demo;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.net.URI;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jayway.jsonpath.DocumentContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		int rand = new Random().nextInt(Integer.MAX_VALUE / 2);
		int target = rand * 2;

		RequestEntity<String> request = new RequestEntity<String>("Test", HttpMethod.GET,
				URI.create(restTemplate.getRootUri() + "/send/" + rand));

		assert (this.restTemplate.exchange(request, String.class).getStatusCode().value() == 200);

		DocumentContext context = parse(this.restTemplate.getForObject("/seeAll", String.class));
		List<Integer> numbers = context.read("$..number");

		assertThat(numbers, contains(target));
	}

}
