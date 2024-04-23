package dev.swanhtet.graph;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlling {

	@GetMapping("/index")
	public String Indexing(){
		return "index";
	}
}
