package Etanat.Etanat.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Etanat.Etanat.domain.Etana;
import Etanat.Etanat.domain.EtanaRepository;



@Controller

public class EtanaController {
	
	@Autowired
	private EtanaRepository repository;
	
	
	@RequestMapping(value = {"/", "/etanalist"})
	public String EtanaList(Model model) {
		model.addAttribute("etanat", repository.findAll());
		return "etanalist";
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteEtana(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../etanalist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/muokkaa/{id}")
	public String muokkaaEtana(@PathVariable("id") Long id, Model model) {
		Etana etana = repository.findById(id).get();
		model.addAttribute("etana", etana);
		return "muokkaaetana";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("lisaa")
	public String lisaaEtana(Model model) {
		model.addAttribute("etana", new Etana());
		return "lisaaetana";
}
	
    @RequestMapping(value="/lisaa", method=RequestMethod.POST)
    public String lisaaetana(Model model) {
    	model.addAttribute("etana", new Etana());
        return "etanalist";
    }
	
	@PostMapping("save")
    public String greetingSubmit(@Valid Etana etana, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	return "lisaaetana";
        }
    	repository.save(etana);
    	return "redirect:etanalist";
    }
	

}
