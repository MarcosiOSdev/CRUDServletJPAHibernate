package br.com.mrksFelipe.repository;

import br.com.mrksFelipe.model.User;

public interface UserRepository extends GenericRepository<User, Long>{

	public User findUserByLogin(String login);
	
}
