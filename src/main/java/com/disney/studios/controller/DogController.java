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

			String resJson = "";

			Iterable<Dog> iter = dogRepository.findAll();

			//TODO: Jsonify
			resJson = iter.toString();

			return resJson;
	}

	@RequestMapping(value = "/dog/breed/{breed}", RequestMethod.GET)
	public @ResponseBody String listDogsOfBreed(@PathVariable String breed){

		String resJson = "";

		Iterable<Dog> iter = dogRepository.findByBreed(breed);

		//TODO: Jsonify
		resJson = iter.toString();

		return resJson;
	}

	@RequestMapping(value = "/dog/favorite/{url}", RequestMethod.PUT)
	public @ResponseBody String favoriteDog(@PathVariable String url){

		String resJson = "";

		String dec_url = Utils.decodeUrl(url);

		Dog d = dogRepository.getDog(dec_url);

		d = dogRepository.findOne(d.getId());

		d.favorite();

		dogRepository.save(d);

		//TODO: check for errors and return success msg
		resJson = d.toString();

		return resJson;
	}

	@RequestMapping(value = "/dog/upvote/{url}", RequestMethod.PUT)
	public @ResponseBody String upvoteDog(@PathVariable String url){

		String resJson = "";

		String dec_url = Utils.decodeUrl(url);

		Dog d = dogRepository.getDog(dec_url);

		d = dogRepository.findOne(d.getId());

		d.upvote();

		dogRepository.save(d);

		//TODO: check for errors and return success msg
		resJson = d.toString();

		return resJson;
	}

	@RequestMapping(value = "/dog/downvote/{url}", RequestMethod.PUT)
	public @ResponseBody String downvoteDog(@PathVariable String url){

		String resJson = "";

		String dec_url = Utils.decodeUrl(url);

		Dog d = dogRepository.getDog(dec_url);

		d = dogRepository.findOne(d.getId());

		d.downvote();

		dogRepository.save(d);

		//TODO: check for errors and return success msg
		resJson = d.toString();

		return resJson;
	}


}
