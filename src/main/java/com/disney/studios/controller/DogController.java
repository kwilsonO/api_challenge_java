package com.disney.studios.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.disney.studios.Utils;
import com.disney.studios.domain.Dog;
import com.disney.studios.repository.DogRepository;
import com.disney.studios.service.DogService;
import com.sun.media.sound.ModelMappedInstrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DogController {

	@Autowired
	private DogRepository dogRepository;

	@RequestMapping(value = "/dogs", RequestMethod.GET)
	public @ResponseBody String listDog(){

			//how to check for errors?
			//if iter is empty, will just return empty json
			//which seems fine
			Iterable<Dog> iter = dogRepository.findAll();

			return Utils.jsonify((Object)iter);

	}

	@RequestMapping(value = "/dog/breed/{breed}", RequestMethod.GET)
	public @ResponseBody String listDogsOfBreed(@PathVariable String breed){

		Iterable<Dog> iter = dogRepository.findByBreed(breed);

		return Utils.jsonify((Object)iter);
	}

	@RequestMapping(value = "/dog/favorite/{url}", RequestMethod.PUT)
	public @ResponseBody String favoriteDog(@PathVariable String url){


		String dec_url = Utils.decodeUrl(url);

		int id = Integer.parseInt(dogRepository.getIdByUrl(dec_url));

		Dog d = dogRepository.findOne(d.getId());

		if(d == null){
			return Utils.jsonifyRes("Could not find dog");
		}

		d.favorite();
		dogRepository.save(d);

		return Utils.jsonifyRes("Successfully favorited dog");
	}

	@RequestMapping(value = "/dog/upvote/{url}", RequestMethod.PUT)
	public @ResponseBody String upvoteDog(@PathVariable String url){

		String dec_url = Utils.decodeUrl(url);

		int id = Integer.parseInt(dogRepository.getIdByUrl(dec_url));

		Dog d = dogRepository.findOne(d.getId());

		if(d == null) {
			return Utils.jsonifyRes("Could not find dog").
		}

		d.upvote();

		dogRepository.save(d);

		return Utils.jsonifyRes("Succesfully upvoted dog");
	}

	@RequestMapping(value = "/dog/downvote/{url}", RequestMethod.PUT)
	public @ResponseBody String downvoteDog(@PathVariable String url){

		String dec_url = Utils.decodeUrl(url);

		int id = Integer.parseInt(dogRepository.getIdByUrl(dec_url));

		Dog d = dogRepository.findOne(d.getId());

		if(d == null){
			return Utils.jsonifyRes("Could not find dog");
		}

		d.downvote();

		dogRepository.save(d);

		return Utils.jsonifyRes("Succesfully downvoted dog");
	}


}
