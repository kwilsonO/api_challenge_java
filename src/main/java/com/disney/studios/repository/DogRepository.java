package com.disney.studios.repository;

import com.disney.studios.domain.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

        /**
         *
         * @return the full list of dogs sorted by
         *         favorite count
         */
        @Query("SELECT * FROM Dog d ORDER BY d.favcount")
        List<Dog> listAllInOrder();

        /**
         * Returns all dogs of a given breed
         * @param breed
         * @return
         */
        @Query("SELECT * FROM Dog d WHERE d.breed = :breed")
        List<Dog> findByBreed(@Param("breed") String breed);

        /**
         * Returns the dog object with the particular url
         * @param url
         * @return
         */
        @Query("SELECT d.id FROM Dog d WHERE d.url = :url")
        String getIdByUrl(String url);
}
