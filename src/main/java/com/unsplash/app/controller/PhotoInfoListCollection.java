package com.unsplash.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unsplash.app.dto.PhotoSummary;

@RestController
@RequestMapping("/collections")
public class PhotoInfoListCollection {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	public String url = "https://api.unsplash.com/collections/?client_id=ejcxMYgmWK3jRhq90P3UkVUDWWtsJ50DRCSqn4b_p10";

	/**
	 * Metodo que se encarga de obtener los campos indicados de las imagenes
	 * 
	 * @param filter:
	 * @return PhotoSummary[]:
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/all")
	public List<PhotoSummary> getFilterPhotoInfo(@RequestParam(value = "filter", required = false) String filter)
			throws JsonMappingException, JsonProcessingException {

		String json = restTemplate.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper();

		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING, true);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		PhotoSummary[] photoSummaries = mapper.readValue(json, PhotoSummary[].class);

		List<PhotoSummary> listPhotoSummary = Arrays.asList(photoSummaries);

		return listPhotoSummary
				.stream()
				.filter(a -> (null != filter) &&
						     (null !=  a.getId() && a.getId().contains(filter)) ||
							 (null !=  a.getCover_photo_id() && a.getCover_photo_id().contains(filter)) ||
							 (null !=  a.getDescription() && a.getDescription().contains(filter)) ||
							 (null !=  a.getTitle() && a.getTitle().contains(filter)))
					
				.collect(Collectors.toList());

	}

}
