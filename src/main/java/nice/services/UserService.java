package nice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nice.models.User;

import nice.models.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}


	@Transactional
	public User findByIdOrUserName(String idOrUserName) {
		User user;

		try {
			Long id = new Long(idOrUserName);
			//user = userDao.findById(id);

			Optional<User> optional = userRepository.findById(id);            
			user = optional.get(); 		

		} catch (Exception e) {
			user = null;
		}

		if (user == null) {
			user = userRepository.findByUserName(idOrUserName);
		}

		return user;
	}

	@Transactional
	public User createUser(String userName) {
		User user = new User(userName);
		return userRepository.save(user);
	}

	@Transactional
	public User updateUser(Long id, String userName) {
		try {
			Optional<User> optional = userRepository.findById(id);            
			User  user = optional.get(); 		

			user.setUserName(userName);
			return userRepository.save(user);
		} catch (Exception e) {
			return null;
		}
	}



	@Transactional
	public void deleteUser(Long id) {
		
		System.out.println( "  Delete User id  == " + id );
		
		try {
			//Optional<User> optional = userRepository.findById(id);            
			//User  user = optional.get(); 		


			userRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}