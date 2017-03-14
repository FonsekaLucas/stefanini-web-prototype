package br.com.stefanini.progress.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.progress.model.Profile;
import br.com.stefanini.progress.model.User;
import br.com.stefanini.progress.repository.LoginRepository;
import br.com.stefanini.progress.repository.ProfileRepository;

@Service("userService")
public class LoginServiceImpl implements LoginService {	

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public User findUserByUsername(String username) {
		return loginRepository.findByUserName(username);
	}

	@Override
	public void saveLogin(User user) {
		user.setUserName(user.getUserName());
		user.setNickname(user.getNickname());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		
		Profile userProfile = profileRepository.findByProfile("ADM");
		user.setProfiles(new HashSet<Profile>(Arrays.asList(userProfile)));
		loginRepository.save(user);
	}

}
