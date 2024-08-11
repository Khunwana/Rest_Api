package com.khunwana.rest.webservices.restfulwebservices.user;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTests {
	
//	@Mock
//	private UserDaoService daoService;
//	
//	@InjectMocks
//	private UserResource userResource;
//	
//	@Autowired
//	private TestRestTemplate restTemplate;
//	
//	public static List<User> users = new ArrayList<>();
//	private static int usersCount = 0;
//	
//	static {
//		users.add(new User(++usersCount,"Monias",LocalDate.now().minusYears(30)));
//		users.add(new User(++usersCount,"Nqobizitha",LocalDate.now().minusYears(24)));
//		users.add(new User(++usersCount,"Khunwana",LocalDate.now().minusYears(20)));
//	}
//	
//	@Test
//	void mockFindAll()
//	{
//		when(daoService.findAll()).thenReturn(users);
//		assertEquals(3, userResource.retrieveAllUsers().size());
//	}
//
//	@Test
//	void findAllTest() {
//		ResponseEntity<String> response = restTemplate
//				.getForEntity("/users", String.class);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}
//	
//	@Test
//	void findOneMock()
//	{
//		when(daoService.findOne(0)).thenReturn(users.get(0));
//		assertEquals(users.get(0), userResource.retrieveUser(0));
//	}
//	
//	@Test
//	void findOneTest() {
//		ResponseEntity<String> response = restTemplate
//				.getForEntity("/users/1", String.class);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}
//	
//	@Test
//	public void delete_A_ToDo() throws Exception
//	{
//		ResponseEntity<String> response = restTemplate
//				.exchange("/users/1", HttpMethod.DELETE ,null ,String.class );
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}

}
