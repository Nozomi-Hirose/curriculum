package testpack.com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import testpack.com.example.demo.model.Oshi;


public interface OshiRepository extends JpaRepository<Oshi, Integer> {

}