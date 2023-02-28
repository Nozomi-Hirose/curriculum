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

import testpack.com.example.demo.form.BookForm;
import testpack.com.example.demo.form.EditBookForm;
import testpack.com.example.demo.form.EditOshiForm;
import testpack.com.example.demo.form.OshiForm;
import testpack.com.example.demo.model.Book;
import testpack.com.example.demo.model.Oshi;
import testpack.com.example.demo.service.BookService;
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
	public String saveOshi(@ModelAttribute @Validated OshiForm oshiForm, BindingResult result,Model model) {

		// バリデーションエラーの場合
		if (result.hasErrors()) {
			// 新規登録画面に遷移
			return "oshiadd";
		}

		// 本を登録する
		service.insert(oshiForm);

		// 本の一覧表示画面にリダイレクト
		return "redirect:/oshi-list";
	}

	/**
	 * 編集画面を表示する
	 * @param model
	 * @param editBook
	 * @return
	 */
	@GetMapping("/oshi-edit")
	public String editOshi(Model model, EditOshiForm editOshi) {

		editOshi = service.getOneBook(editOshi.getId());
		model.addAttribute(editOshi);

		return "oshiedit";
	}

	/**
	 * 本の情報を更新する
	 * @param editBook
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/oshi-edit")
	public String update(@ModelAttribute @Validated EditOshiForm editOshi, BindingResult result, Model model) {

		// バリデーションエラーの場合
		if (result.hasErrors()) {
			// 編集画面に遷移
			return "oshiedit";
		}

		// 本を更新する
		service.update(editOshi);

		// 本の一覧画面にリダイレクト
		return "redirect:/oshi-list";
	}

	/**
	 * 本の削除を行う
	 * @param model
	 * @param Book
	 * @return
	 */
	@GetMapping("/oshi-delete")
	public String deleteOshi(Model model, Oshi Oshi) {

		// データベースのデータを削除する
		service.delete(Oshi.getId());

		// 本の一覧画面にリダイレクト
		return "redirect:/oshi-list";
	}
}