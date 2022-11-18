package security.repository;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import security.entity.User;


	@Repository
	public interface Userrepos extends JpaRepository<User,Integer>{

		public User findByEmail(String email);

	 
}

