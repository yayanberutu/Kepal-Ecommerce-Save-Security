package kepal.kel6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kepal.kel6.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findUserByEmail(String email);
}
