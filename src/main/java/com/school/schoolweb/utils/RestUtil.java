package com.school.schoolweb.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 	远程请求调用工具类
 * @author runner
 *
 */
public class RestUtil {

	/**
	 * 获取接口请求结果 post 请求
	 * @param param 参数
	 * @param apiUrl  请求接口
	 * @return
	 */
	public static ResponseEntity<String> postHttpEntity(RestTemplate restTemplate,Map<String, Object> param,String apiUrl) {
		ObjectMapper mapper = new ObjectMapper();
		String params;
		try {
			params = mapper.writeValueAsString(param);
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			HttpEntity<String> formEntity = new HttpEntity<String>(params, headers);
			return restTemplate.postForEntity(apiUrl, formEntity, String.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * post url无参  JSON传参数
	 * @param param 
	 * @param apiUrl 接口地址
	 * @return
	 */
	public static ResponseEntity<String> postHttpEntity(RestTemplate restTemplate,String param,String apiUrl) {
		try {
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			HttpEntity<String> formEntity = new HttpEntity<String>(param, headers);
			return restTemplate.postForEntity(apiUrl, formEntity, String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * post url无参
	 * @param apiUrl 接口地址
	 * @return
	 */
	public static ResponseEntity<String> postHttpEntity(RestTemplate restTemplate,String apiUrl) {
		try {
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			HttpEntity<String> formEntity = new HttpEntity<String>( headers);
			return restTemplate.postForEntity(apiUrl, formEntity, String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * post url有参  map传参数   
	 * @param 
	 * @param apiUrl 接口地址
	 * @return
	 */
	public static ResponseEntity<String> postExchangeHttpEntity(RestTemplate restTemplate,Map<String, Object> param,String apiUrl,String... agrs) {
		ObjectMapper mapper = new ObjectMapper();
		String params;
		try {
			params = mapper.writeValueAsString(param);
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			HttpEntity<String> formEntity = new HttpEntity<String>(params, headers);
			return restTemplate.exchange(apiUrl,HttpMethod.POST, formEntity, String.class, agrs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	
	/**
	 * post url有参  json传参   
	 * @param 
	 * @param apiUrl 接口地址
	 * @return
	 */
	public static ResponseEntity<String> postExchangeHttpEntityForImport(RestTemplate restTemplate,String json,String apiUrl,String... agrs) {
		ObjectMapper mapper = new ObjectMapper();
		String params;
		try {
			params = json;
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			HttpEntity<String> formEntity = new HttpEntity<String>(params, headers);
			return restTemplate.exchange(apiUrl,HttpMethod.POST, formEntity, String.class, agrs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * put  url有参  body传参 
	 * @param 
	 * @param apiUrl 接口地址
	 * @return
	 */
	public static ResponseEntity<String> putExchangeHttpEntity(RestTemplate restTemplate,Map<String, Object> param,String apiUrl,String... agrs) {
		ObjectMapper mapper = new ObjectMapper();
		String params;
		try {
			params = mapper.writeValueAsString(param);
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			HttpEntity<String> formEntity = new HttpEntity<String>(params, headers);
			return restTemplate.exchange(apiUrl,HttpMethod.PUT, formEntity, String.class, agrs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * post url有参 
	 * @param 
	 * @param apiUrl 接口地址
	 * @return
	 */
	public static ResponseEntity<String> postExchangeHttpEntity(RestTemplate restTemplate,String apiUrl,String... param) {
		try {
			return restTemplate.exchange(apiUrl,HttpMethod.POST, null, String.class, param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * put url有参
	 * @param restTemplate
	 * @param apiUrl
	 * @param param
	 * @return
	 */
	public static ResponseEntity<String> putExchangeHttpEntity(RestTemplate restTemplate,String apiUrl,String... param) {
		try {
			return restTemplate.exchange(apiUrl,HttpMethod.PUT, null, String.class, param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * put url有参
	 * @param restTemplate
	 * @param apiUrl
	 * @param param
	 * @return
	 */
	public static ResponseEntity<String> putLabelStateExchangeHttpEntity(RestTemplate restTemplate,String apiUrl,Object... param) {
		try {
			return restTemplate.exchange(apiUrl,HttpMethod.PUT, null, String.class, param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get url有参
	 * @param restTemplate
	 * @param apiUrl
	 * @param param
	 * @return
	 */
	public static ResponseEntity<String> getExchangeHttpEntity(RestTemplate restTemplate,String apiUrl,String... param) {
		try {
			return restTemplate.exchange(apiUrl,HttpMethod.GET, null, String.class, param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	
	/**
	 *  get 无参请求 
	 *  
	 * @param apiUrl
	 * @return
	 */
	public static ResponseEntity<String> getHttpEntity(RestTemplate restTemplate,String apiUrl) {
		try {
			return restTemplate.getForEntity(apiUrl,  String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * delete 请求
	 * @param apiUrl
	 * @return
	 */
	public static ResponseEntity<String> deleteHttpEntity(RestTemplate restTemplate,String apiUrl,String... param) {
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl,HttpMethod.DELETE, null, String.class, param);
			return responseEntity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
