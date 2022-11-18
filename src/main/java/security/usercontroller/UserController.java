package security.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import security.entity.Product;
import security.entity.User;
import security.repository.Productrepos;
import security.repository.Userrepos;

@RestController
@CrossOrigin

public class UserController {
	@Autowired
	Userrepos repo;
	@Autowired
	Productrepos Product;

	@PostMapping("/add-User")

	public String addUser(@RequestBody User data) {
		if (data.getEmail() == "") {

			return "email is must";
		}
		if (data.getFirstname() == "") {
			return "Firstname is must";
		}
		if (data.getLastname() == "") {
			return "lastname is must";
		}
		if (data.getPassword() == "") {
			return "password is must";
		}

		User obj = new User();
		obj.setId(data.getId());
		obj.setFirstname(data.getFirstname());
		obj.setLastname(data.getLastname());
		obj.setEmail(data.getEmail());
		obj.setPassword(data.getPassword());
		if (repo.findByEmail(data.getEmail()) != null) {
			if (obj.getEmail().equals(data.getEmail())) {
				return "email is already registered";
			}
		} else {

			repo.save(obj);
			return "sign up succesfully";

		}
		return null;
	}

	@PostMapping("/adding-user")

	public String adduser(@RequestBody User data) {

		User obj = new User();
		obj.setId(data.getId());
		obj.setFirstname(data.getFirstname());
		obj.setLastname(data.getLastname());
		obj.setEmail(data.getEmail());
		obj.setPassword(data.getPassword());
		if (repo.findByEmail(data.getEmail()) != null) {
			if (obj.getEmail().equals(data.getEmail())) {
				return "email is already in table";
			}
		} else {

			repo.save(obj);
			return "added";
		}
		return null;
	}

	@GetMapping("/get-User")
	public Object getuser() {
		List<User> obj = repo.findAll();

		return obj;
	}

	@DeleteMapping("/delete-user")
	public String deleteuser(@RequestParam int id) {
		repo.deleteById(id);
		return "deleted";
	}

	@PutMapping("/update-user")
	public String updateuser(@RequestBody User data, int id) {
		User updateuser = repo.findById(id).get();
		updateuser.setFirstname(data.getFirstname());
		updateuser.setLastname(data.getLastname());
		updateuser.setEmail(data.getEmail());
		updateuser.setPassword(data.getPassword());
		repo.save(updateuser);
		return "update sucessfully";
	}

	@PostMapping("/forget-user")
	public String forget(@RequestBody User data) {
		if (repo.findByEmail(data.getEmail()) != null) {
			User obj = repo.findByEmail(data.getEmail());

			obj.setPassword(data.getPassword());

			if (obj.getEmail().equals(data.getEmail())) {
				repo.save(obj);
				return "password changed";
			}
		} else {

			return "email is not registered";
		}
		return null;

	}

	@PostMapping("/product-user")

	public String product(@RequestBody Product data) {
		Product obj = new Product();
		obj.setId(data.getId());
		obj.setReviewer(data.getReviewer());
		obj.setDescription(data.getDescription());
		obj.setStarrating(data.getStarrating());
		Product.save(obj);
		return "added";
	}

	@GetMapping("/get-product")
	public Object getproduct() {
		List<Product> obj = Product.findAll();

		return obj;
	}

}
