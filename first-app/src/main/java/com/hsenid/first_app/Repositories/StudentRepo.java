package com.hsenid.first_app.Repositories;

import com.hsenid.first_app.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {
}
