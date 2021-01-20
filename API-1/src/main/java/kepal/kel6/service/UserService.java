package kepal.kel6.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import kepal.kel6.model.User;
import kepal.kel6.repository.UserRepository;
import net.bytebuddy.utility.RandomString;

@Service
@Transactional
public class UserService {
	
	@Autowired UserRepository userRepo;
    @Autowired JavaMailSender mailSender;
//    @Autowired PasswordEncoder passwordEncoder;
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User getUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}
	
	public User getUserById(Long id) {
		return userRepo.findById(id).get();
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
    public void generateOneTimePassword(User user) throws UnsupportedEncodingException, MessagingException  {
    	String OTP = RandomString.make(6);
        user.setOne_time_password(encodedOTP);
        user.setOtp_requested_time(new Date());
         
        userRepo.save(user);
         
        sendOTPEmail(user, OTP);
    }
     
    public void sendOTPEmail(User user, String OTP) {
    	 MimeMessage message = mailSender.createMimeMessage();              
    	 MimeMessageHelper helper = new MimeMessageHelper(message);
    	 
    	 helper.setFrom("KEPAL06@del.ac.id", "Verifikasi");
    	 helper.setTo(user.getEmail());
    	     
    	    String subject = "Ini password One Time Password (OTP) anda - Akan kadaluarsa dalam 5 menit!";
    	     
    	    String content = "<p>Halo " + user.getUsername()+ "</p>"
    	            + "<p>Silahkan masukkan kode berikut untuk alasan keamanan : "
    	            + "Kode OTP anda adalah:</p>"
    	            + "<p><b>" + OTP + "</b></p>"
    	            + "<br>"
    	            + "<p>Catatan: akan kadaluarsa dalam 5 menit.</p>";
    	     
    	    helper.setSubject(subject);
    	     
    	    helper.setText(content, true);
    	     
    	    mailSender.send(message);     
    	
    }
 
    public void clearOTP(User user) {
        user.setOne_time_password(null);
        user.setOtp_requested_time(null);
        userRepo.save(user);   
    }  
	
}
