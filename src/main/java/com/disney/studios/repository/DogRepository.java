package com.disney.studios.repository;

import com.disney.studios.domain.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long>{

        /**
         *
         * @return the full list of dogs sorted by
         *         favorite count
         */
        List<Dog> listAllInOrder();

        /**
         * Returns all dogs of a given breed
         * @param breed
         * @return
         */
        List<Dog> findByBreed(String breed);

        /**
         * Returns the dog object with the particular url
         * @param url
         * @return
         */
        Dog getDog(String url);
}
