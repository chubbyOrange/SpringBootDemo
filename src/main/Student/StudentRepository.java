package com.example.demo.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // The two lines below is equivalent.
    @Query("SELECT s FROM Student s WHERE s.email=?1") // jpql, not sql
    Optional<Student> findStudentByEmail(String email);
}
