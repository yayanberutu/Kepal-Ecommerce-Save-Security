package com.buyer.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.buyer.model.Kamar;


@Service
public class KamarApi {
	@Value(value = "${base.url}")
	private String url;	
	
	@Autowired RestTemplate restTemplate;
	
	public List<Kamar> getAllKamar(){
		List<Kamar> listKamar= Arrays.stream(restTemplate.getForObject(url + "/kamar/get", Kamar[].class)).collect(Collectors.toList());
		return listKamar;
	}
	
	public Kamar getKamarById(int id) {
		Kamar kamar = restTemplate.getForObject(url + "/kamar/get/{id}", Kamar.class, id);
		return kamar;
	}
	
	public void deleteKamar(Integer id) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", id);
		restTemplate.delete(url + "/kamar/delete/{id}", parameter);
	}
	
	public void updateKamar(Kamar kamar) {
		Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("id", kamar.getKamarid());
		restTemplate.put(url + "/kamar/edit/{id}", kamar, parameter);
	}
	
	public void addKamar(Kamar kamar) {
		restTemplate.postForObject(url + "/kamar/add", kamar, Kamar.class);
	}
	
}
