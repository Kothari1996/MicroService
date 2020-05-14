package com.kothari.webservice.restfulwebservice.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDAOService service;
	
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private PostRepository PostRepository;
	@GetMapping(path="/users")
	public List<User> retriveAllUsers(){
		//return service.findAll();
		return UserRepository.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User getUser(@PathVariable int id){
		//User user = service.findUser(id);
		Optional<User> user = UserRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id -"+id);
			
		}
		
		return user.get();
		
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> CreateUser(@RequestBody User user) {
		//User userSaved=service.save(user);
		User userSaved=UserRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
		return  ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		UserRepository.deleteById(id);
		//if(user ==null) {
		//	throw new UserNotFoundException("id -"+id);
		//}
		
	}
		@GetMapping("/users/{id}/posts")
		public List<Post> retriveAllUsersPost(@PathVariable int id){
			Optional<User>  userOptional =UserRepository.findById(id);
			if(!userOptional.isPresent()) {
				throw new UserNotFoundException("id -"+id);
			}
			
			return userOptional.get().getPosts();
		}
		
		
		@PostMapping(path="/users/{id}/posts")
		public ResponseEntity<Object> CreatePost(@PathVariable int id ,@RequestBody Post post) {
			//User userSaved=service.save(user);
			Optional<User>  userOptional =UserRepository.findById(id);
			if(!userOptional.isPresent()) {
				throw new UserNotFoundException("id -"+id);
			}
			
			User user =userOptional.get();
			post.setUser(user);
			PostRepository.save(post);
			
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
			return  ResponseEntity.created(location).build();
			
		}
		
		@DeleteMapping(path="/users/{id}/posts/{postId}")
		public void deletePost(@PathVariable int id,@PathVariable int postId) {
			Optional<User>  userOptional =UserRepository.findById(id);
			if(!userOptional.isPresent()) {
				throw new UserNotFoundException("id -"+id);
			}
			
			User user =userOptional.get();
			//Post post =post.setUser(user);
			
			PostRepository.deleteById(postId);
			
		}
		
	

}
