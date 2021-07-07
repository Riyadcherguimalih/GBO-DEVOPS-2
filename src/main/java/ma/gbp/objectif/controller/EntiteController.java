package ma.gbp.objectif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.gbp.objectif.model.Agence;
import ma.gbp.objectif.model.BPR;
import ma.gbp.objectif.model.Succursale;
import ma.gbp.objectif.service.AgenceService;
import ma.gbp.objectif.service.BPRService;
import ma.gbp.objectif.service.SuccursaleService;

@Controller
@RequestMapping("entite")
public class EntiteController {
	
	
		@Autowired
		private BPRService bprService;
		
		@Autowired
		private SuccursaleService succursaleService;
		
		@Autowired
		private AgenceService agenceService;
		
		
		@GetMapping("/")
		public String voirPageDesBPR(Model model) {
			List<BPR> listeDesBPR = bprService.findAllBPR();
			model.addAttribute("listeDesBPR", listeDesBPR);
			System.out.println(listeDesBPR);
			return "entite";
		}
		
		@GetMapping("/bpr/{id_bpr}")
		public String voirSuccursalesDeBPR(Model model, @PathVariable(value = "id_bpr") Integer id_bpr) {
			List<Succursale> listeDesSuccursales = succursaleService.findAllSuccursaleByIdBPR(id_bpr);
			model.addAttribute("listeDesSuccursales", listeDesSuccursales);
			return "bpr";
		}
		
		@GetMapping("/succursale/{id_succursale}")
		public String voirAgencesDeSuccursale(Model model, @PathVariable(value = "id_succursale") Integer id_succursale) {
			List<Agence> listeDesAgences = agenceService.findAllAgenceBySuccursaleID(id_succursale);
			model.addAttribute("ListeDesAgences", listeDesAgences);
			return "succursale";
			
		
		
		}
	

}
