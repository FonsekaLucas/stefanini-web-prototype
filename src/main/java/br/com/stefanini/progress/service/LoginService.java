package br.com.stefanini.progress.service;

import br.com.stefanini.progress.model.User;

public interface LoginService {	
	public User findUserByUsername(String username);
	public void saveLogin(User user);
}
