package br.com.mrksFelipe.repository;

import javax.persistence.EntityManager;

import br.com.mrksFelipe.model.User;

public class UserRepositoryJPA extends RepositoryJPA<User, Long> implements UserRepository {

	
	public UserRepositoryJPA(EntityManager em) {
		super(User.class, em);
	}
	public User findUserByLogin(String login){
		 return getEm().createNamedQuery("User.findUserByLogin", User.class) 
		.setParameter("login", login).getSingleResult(); 
   }
	

}
