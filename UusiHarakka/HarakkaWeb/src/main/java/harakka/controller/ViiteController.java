/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harakka.controller;

import harakka.domain.Viite;
import harakka.service.ViitePalvelu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kari Korpinen
 */
@Controller
public class ViiteController {
    @Autowired
   private ViitePalvelu viitepalvelu;

   @RequestMapping("*")
   public String nayta() {
       System.out.println("controller nayta ");
          return "redirect:/listaa";
   }
    @RequestMapping(value = "lisaa", method=RequestMethod.POST)
    public String lisaa(Viite viite,Model model) {
       System.out.println("controller lisaa "+viite.getViitenimi());
        viite.setId(viite.getLASKURI());
       viitepalvelu.lisaa(viite);
       model.addAttribute("viitteet",viitepalvelu.listaa());
       return "redirect:/listaa";
    }
    @RequestMapping(value = "poista/{esineId}")
   public String poista(Model mod,@PathVariable Integer esineId) {
      viitepalvelu.poista(esineId);
      mod.addAttribute("esineet", viitepalvelu.listaa());
      return "redirect:/listaa";
    }
   @RequestMapping(value = "listaa")
    public String listaa(Model model){       
       System.out.println("controller listaa ");
       model.addAttribute("viitteet", viitepalvelu.listaa());
       return "viitenakyma";
    }
   @RequestMapping(value = "tiedosto")
    public String tallennaBibTex(@RequestParam String tiedostonimi, Model model){       
       System.out.println("controller tiedostotallennaBibTex "+tiedostonimi);
       viitepalvelu.tallennaBibTex(tiedostonimi);
       model.addAttribute("viitteet", viitepalvelu.listaa());
       return "viitenakyma";
    }
    
}
