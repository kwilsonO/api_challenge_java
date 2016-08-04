package com.disney.studios.controller;

import com.disney.studios.Utils;
import com.disney.studios.domain.Dog;
import com.disney.studios.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DogController {

	@Autowired
	private DogRepository dogRepository;

	@RequestMapping(value = "/dogs", method = RequestMethod.GET)
	public @ResponseBody String listDog(){

			//how to check for errors?
			//if iter is empty, will just return empty json
			//which seems fine
			Iterable<Dog> iter = dogRepository.findAll();

			return Utils.jsonify((Object)iter);

	}

	@RequestMapping(value = "/dog/breed/{breed}", method = RequestMethod.GET)
	public @ResponseBody String listDogsOfBreed(@PathVariable String breed){

		Iterable<Dog> iter = dogRepository.findByBreed(breed);

		return Utils.jsonify((Object)iter);
	}

	@RequestMapping(value = "/dog/favorite/{url}", method = RequestMethod.PUT)
	public @ResponseBody String favoriteDog(@PathVariable String url){


		String dec_url = Utils.decodeUrl(url);

		Long id = Long.parseLong(dogRepository.getIdByUrl(dec_url));

		Dog d = dogRepository.findOne(id);

		if(d == null){
			return Utils.jsonifyRes("Could not find dog");
		}

		d.favorite();
		dogRepository.save(d);

		return Utils.jsonifyRes("Successfully favorited dog");
	}

	@RequestMapping(value = "/dog/upvote/{url}", method = RequestMethod.PUT)
	public @ResponseBody String upvoteDog(@PathVariable String url){

		String dec_url = Utils.decodeUrl(url);

		Long id = Long.parseLong(dogRepository.getIdByUrl(dec_url));

		Dog d = dogRepository.findOne(id);

		if(d == null) {
			return Utils.jsonifyRes("Could not find dog");
		}

		d.upvote();

		dogRepository.save(d);

		return Utils.jsonifyRes("Succesfully upvoted dog");
	}

	@RequestMapping(value = "/dog/downvote/{url}", method = RequestMethod.PUT)
	public @ResponseBody String downvoteDog(@PathVariable String url){

		String dec_url = Utils.decodeUrl(url);

		Long id = Long.parseLong(dogRepository.getIdByUrl(dec_url));

		Dog d = dogRepository.findOne(id);

		if(d == null){
			return Utils.jsonifyRes("Could not find dog");
		}

		d.downvote();

		dogRepository.save(d);

		return Utils.jsonifyRes("Succesfully downvoted dog");
	}


}
