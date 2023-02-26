package testpack.com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testpack.com.example.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}