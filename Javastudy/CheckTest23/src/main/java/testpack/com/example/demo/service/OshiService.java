package testpack.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testpack.com.example.demo.model.Oshi;
import testpack.com.example.demo.repository.OshiRepository;

@Service
@Transactional
public class OshiService {
	
    @Autowired
    OshiRepository repository;
	
    /**
     * データベースから本の一覧を取得する
     * @return
     */
    public List<Oshi> findAll() {
        return repository.findAll();
    }
}