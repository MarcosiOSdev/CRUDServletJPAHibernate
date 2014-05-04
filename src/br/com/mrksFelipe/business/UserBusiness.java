package br.com.mrksFelipe.business;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mrksFelipe.model.User;
import br.com.mrksFelipe.repository.UserRepository;
import br.com.mrksFelipe.repository.UserRepositoryJPA;

public class UserBusiness {
	
	UserRepositoryJPA userJpa;
	UserRepository userRepository;
	
	public UserBusiness(EntityManager entityManager) {
		userJpa = new UserRepositoryJPA(entityManager);
		userRepository = userJpa;
	}
	
	
	public boolean all(User user){
		
		if(user == null){
			return false;
		}
		
		if(user.getLogin()== null || user.getLogin().isEmpty() || user.getLogin().equalsIgnoreCase("")){
			return false;
		}
		
		if(user.getPassword()== null || user.getPassword().isEmpty() || user.getPassword().equalsIgnoreCase("")){
			return false;
		}
		
		if(user.getName()== null || user.getName().isEmpty() || user.getName().equalsIgnoreCase("")){
			return false;
		}
		return true;
		
	}
	
	public void save(User user)throws Exception {

		//Verificando se contem todos parametros de usuario
		if(all(user)){					
			if(findUserByLogin(user.getLogin()) == null )
				userRepository.save(user);
			else
				throw new Exception();
		}else{
			throw new Exception();
		}
	}

	public User update(User user)throws Exception {
		if(all(user))
			if(findUserByLogin(user.getLogin()) == null )
				return userRepository.update(user);
			else
				throw new Exception();
		else
			throw new Exception();
	}

	public void delete(Long id, Class<User> classe)throws Exception {
		userRepository.delete(id, classe);
	}

	
	public User findByID(Long id)throws Exception {
		return userRepository.findByID(id);
	}

	
	public List<User> findAll()throws Exception {
		return userRepository.findAll();
	}
	public User findUserByLogin(String login)throws Exception{
		try {
			return userRepository.findUserByLogin(login);
		} catch (Exception e) {
			return null;
		}
		
	}

}
