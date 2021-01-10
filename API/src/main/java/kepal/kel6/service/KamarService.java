package kepal.kel6.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kepal.kel6.model.Kamar;
import kepal.kel6.repository.KamarRepository;

@Service
@Transactional
public class KamarService {
	@Autowired KamarRepository kamarRepo;
	
	public List<Kamar> getAllKamar(){
		return kamarRepo.findAll();
	}
	
	public Kamar getKamarById(int id) {
		return kamarRepo.findById(id).get();
	}
		
	public void saveKamar(Kamar kamar) {
		kamarRepo.save(kamar);
	}
	
	public void deleteKamar(int id) {
		kamarRepo.deleteById(id);
	}
	
}
