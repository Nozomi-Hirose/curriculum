package testpack.com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}