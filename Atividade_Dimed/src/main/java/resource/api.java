package resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mensagem")
public class api {
	
	@GetMapping
	public String getOpa() {
		return "Opa! Estamos no ar!";
	}

}
