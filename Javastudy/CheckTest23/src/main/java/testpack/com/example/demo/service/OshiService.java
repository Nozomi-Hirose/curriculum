//画面からの入力値の値→DB登録用のクラスに変換・DBに登録するメソッドを呼び出す
package testpack.com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testpack.com.example.demo.form.OshiForm;
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
    	
        /**
         * データベースにデータを登録する
         * @return
         */
        public void insert(OshiForm oshiForm) {
            // データベースに登録する値を保持するインスタンス
            Oshi oshi = new Oshi();

            // 画面から受け取った値をデータベースに保存するインスタンスに渡す
            oshi.setTitle(oshiForm.getTitle());
            oshi.setPrice(oshiForm.getPrice());

            // データベースに登録する
            repository.save(oshi);
    }
}