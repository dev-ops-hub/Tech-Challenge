package com.thales.airlab.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import java.net.URI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;

import com.thales.airlab.exception.AuthenticationErrorException;
import com.thales.airlab.exception.RecordNotFoundException;
import com.thales.airlab.model.QueryForm;
import com.thales.airlab.model.User;
import com.thales.airlab.service.QueryFormRepository;

import java.util.Optional;
import javax.validation.Valid;

@RestController
public class QueryResource {
	
	@Autowired
	private QueryFormRepository queryFormRepository;
	
	
	@PostMapping("/form/query")
	public EntityModel<QueryForm> createQuery(@Valid @RequestBody QueryForm form ) {

		queryFormRepository.save(form);
		Optional<QueryForm> result = queryFormRepository.findById(form.getId());
		
		EntityModel<QueryForm> resource = null;
		if (result.isPresent())
			resource = EntityModel.of(result.get());
		else
		    throw new RecordNotFoundException("Error encounterd in Saving" );
		
		/*URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(form.getId()).toUri();
		return ResponseEntity.created(location).build();
		*/
		return resource;
	}

	@GetMapping("/form/query")
	public @ResponseBody Iterable<QueryForm> retrieveAllQueries( User form) throws AuthenticationErrorException {
		
		if (!"user".equals(form.getUserId()) )
			 throw new AuthenticationErrorException("UserID or Password is incorrect!!" );
		if (!"password".equals(form.getPwd()))
			 throw new AuthenticationErrorException("UserID or Password is incorrect!!" );
		return queryFormRepository.findAll();
	}
	
}
