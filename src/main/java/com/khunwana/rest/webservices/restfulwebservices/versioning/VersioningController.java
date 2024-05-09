package com.khunwana.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson()
	{
		return new PersonV1("Monias Khunwana");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getFirstVersionOfPerson2()
	{
		return new PersonV2(new Name("Monias","Khunwana"));
	}

	@GetMapping(path="/person",params="version=1")
	public PersonV1 getFirstVersionOfPersonFromRequestParam()
	{
		return new PersonV1("Monias Khunwana");
	}
	
	@GetMapping(path="/person",params="version=2")
	public PersonV2 getFirstVersionOfPersonFromRequestParam2()
	{
		return new PersonV2(new Name("Monias","Khunwana"));
	}

	@GetMapping(path="/person/header",headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonFromRequestHeader()
	{
		return new PersonV1("Monias Khunwana");
	}
	@GetMapping(path="/person/header",headers="X-API-VERSION=2")
	public PersonV2 getFirstVersionOfPersonFromRequestHeader2()
	{
		return new PersonV2(new Name("Monias","Khunwana"));
	}

	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonFromRequestAcceptHeader()
	{
		return new PersonV1("Monias Khunwana");
	}
	@GetMapping(path="/person/accept",produces ="application/vnd.company.app-v2+json")
	public PersonV2 getFirstVersionOfPersonFromRequestAcceptHeader2()
	{
		return new PersonV2(new Name("Monias","Khunwana"));
	}
}
