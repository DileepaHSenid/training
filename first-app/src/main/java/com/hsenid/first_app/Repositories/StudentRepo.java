package com.hsenid.first_app.repositories;

import com.hsenid.first_app.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * StudentRepo is an interface for performing CRUD operations on Student objects in a MongoDB database.
 * It extends the MongoRepository interface provided by Spring Data MongoDB, which includes several
 * generic methods for working with MongoDB collections.
 * <p>
 * The MongoRepository interface is parameterized with the type of the entity (Student) and the type of
 * the entity's ID (String in this case).
 */
public interface StudentRepo extends MongoRepository<Student, String> {
    // Additional query methods can be defined here if needed.
}
