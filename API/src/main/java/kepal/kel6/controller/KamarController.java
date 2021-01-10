package kepal.kel6.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kepal.kel6.model.Kamar;
import kepal.kel6.model.User;
import kepal.kel6.service.KamarService;
import kepal.kel6.service.UserService;

@RestController
@RequestMapping("kamar")
public class KamarController {
@Autowired KamarService kamarService;
	
	@GetMapping("/get")
	public List<Kamar> getAllKamar(){
		return kamarService.getAllKamar();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Kamar> getKamarById(@PathVariable("id") int id) {
		try {
			Kamar kamar = kamarService.getKamarById(id);
			return new ResponseEntity<Kamar>(kamar, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Kamar>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @PutMapping(value = "/edit/{id}")
	 public ResponseEntity<Kamar> updateKamar(@PathVariable("id") int id, @RequestBody Kamar kamar){
		 try {
			 Kamar existkamar= kamarService.getKamarById(id);
			 kamar.setKamarid(id);
			 kamarService.saveKamar(kamar);
			 return new ResponseEntity<Kamar>(kamar, HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<Kamar>(kamar, HttpStatus.NOT_FOUND);
		 }
		 
	 }
	 
	 @PostMapping(value="/add")
	 public ResponseEntity<Kamar> createKamar(@RequestBody Kamar kamar){
		 kamarService.saveKamar(kamar);
		 
		 return new ResponseEntity<Kamar>(kamar, HttpStatus.OK);
	 }
	 
	 @DeleteMapping(value="/delete/{id}")
	 public ResponseEntity<String> deleteKamar(@PathVariable("id") int id){
		 try {
			 Kamar existkamar = kamarService.getKamarById(id);
			 kamarService.deleteKamar(id);
			 return new ResponseEntity<String>(HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
	 }
	
}
