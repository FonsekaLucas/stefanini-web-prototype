package br.com.stefanini.progress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.progress.model.User;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<User, Long>{	
	User findByUserName(String username);
}
