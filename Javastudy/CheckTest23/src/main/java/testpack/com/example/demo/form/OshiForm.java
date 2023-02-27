//ユーザーが画面で入力した値を保持するクラス
package testpack.com.example.demo.form;

import lombok.Data;

@Data
public class OshiForm {

    /**
     * 本のタイトルを保持する
     */
    private String title;

    /**
     * 本のタイトルを保持する
     */
    private String impressions;
    
    /**
     * 本の値段を保持する
     */
    private Integer price;
}