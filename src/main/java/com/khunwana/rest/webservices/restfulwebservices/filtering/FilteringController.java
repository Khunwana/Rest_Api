package com.khunwana.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering()
	{
		SomeBean someBean = new SomeBean("val1","val2","val3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		return filters(mappingJacksonValue,"field1","field3");
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList()
	{
		
		List<SomeBean> asList = Arrays.asList(new SomeBean("val1","val2","val3"),new SomeBean("va15","val5","val4"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
		
		return filters(mappingJacksonValue,"field2","field3");
	}

	private MappingJacksonValue filters(MappingJacksonValue mappingJacksonValue,String val1,String val2) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(val1,val2);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomebeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
}
