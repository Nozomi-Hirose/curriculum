package testpack.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testpack.com.example.demo.form.BookForm;
import testpack.com.example.demo.form.EditBookForm;
import testpack.com.example.demo.form.EditOshiForm;
import testpack.com.example.demo.form.OshiForm;
import testpack.com.example.demo.model.Book;
import testpack.com.example.demo.model.Oshi;
import testpack.com.example.demo.repository.BookRepository;
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
	
    /**
     * データベースにデータを登録する
     * @return
     */
    public void insert(OshiForm oshiForm) {
        // データベースに登録する値を保持するインスタンス
        Oshi book = new Oshi();
        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        book.setTitle(oshiForm.getTitle());
        book.setPrice(oshiForm.getPrice());
        // データベースに登録する
        repository.save(book);
    }
    
    /**
     * idからデータを取得する
     * @param id
     * @return
     */
    public EditOshiForm getOneBook(Integer id) {

        // idを指定して本の情報を取得する
        Oshi oshi = repository.findById(id).orElseThrow();

        // 画面返却用のFormに値を設定する
        EditOshiForm editOshi = new EditOshiForm();
        editOshi.setId(oshi.getId());
        editOshi.setTitle(oshi.getTitle());
        editOshi.setPrice(oshi.getPrice());

        return editOshi;
    }
    
    /**
     * 本の情報を更新する
     * @param editBook
     */
    public void update(EditOshiForm editOshi) {

        // データベースに登録する値を保持するインスタンスの作成
        Oshi oshi = new Oshi();

        // 画面から受け取った値を設定する
        oshi.setId(editOshi.getId());
        oshi.setTitle(editOshi.getTitle());
        oshi.setPrice(editOshi.getPrice());

        // データベースを更新する
        repository.save(oshi);
    }
    
    /**
     * 本を削除する
     * @param id
     */
    public void delete(Integer id) {

        // idを指定して、データベースからデータを削除する
        repository.deleteById(id);
    }
}