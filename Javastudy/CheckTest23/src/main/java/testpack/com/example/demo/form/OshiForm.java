//ユーザーが画面で入力した値を保持するクラス
package testpack.com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OshiForm {

	/**
	 * 本のタイトルを保持する
	 * チェック内容：空でないこと
	 */
	@NotBlank(message="活動記録を入力してください")
	private String title;

	/**
	 * 本のタイトルを保持する
	 */
	@NotBlank(message="感想を記入してくだい")
	private String impressions;

	/**
	 * 本の値段を保持する
	 */
	@NotNull(message="値段を入力してください。")
	@Positive(message="値段はプラスの値を入力してください。")
	private Integer price;
}