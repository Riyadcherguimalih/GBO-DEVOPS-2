package ma.gbp.objectif.controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class IndexController {

	@GetMapping("/")
	public String viewPageIndex(Model model) {
		return "index";
	}
	
}
