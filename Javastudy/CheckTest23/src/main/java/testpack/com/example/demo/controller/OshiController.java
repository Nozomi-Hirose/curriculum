package testpack.com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import testpack.com.example.demo.form.OshiForm;
import testpack.com.example.demo.model.Oshi;
import testpack.com.example.demo.service.OshiService;


@Controller
public class OshiController {

	@Autowired
	OshiService service;

	@GetMapping("/oshi-list")
	public String oshiList(Model model) {

		// serviceを使って、本の一覧をDBから取得する
		List<Oshi> oshiList = service.findAll();
		// modelに本の一覧を設定して、画面に渡す
		model.addAttribute("oshiList", oshiList);
		// bookList.htmlの表示
		return "oshiList";
	}

	/**
	 * 新規登録画面を表示
	 * @param model
	 * @return 新規登録画面
	 */
	@GetMapping("/oshi-create")
	public String createOshi(Model model) {

		model.addAttribute("oshiForm", new OshiForm());

		return "oshiadd";
	}

	/**
	 * データベースに本を登録する
	 * @param bookForm
	 * @param model
	 * @return
	 */
	@PostMapping("/oshi-create")
	public String saveOshi(@ModelAttribute @Validated OshiForm oshiForm,  BindingResult result,Model model) {

		// バリデーションエラーの場合
		if(result.hasErrors()) {
			// 新規登録画面に遷移
			return "oshiadd";
		}
		// 本を登録する
		service.insert(oshiForm);

		// 本の一覧表示画面にリダイレクト
		return "redirect:/oshi-list";
	}
	
}

