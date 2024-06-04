package com.hsenid.first_app.repositories;

import com.hsenid.first_app.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {
}
