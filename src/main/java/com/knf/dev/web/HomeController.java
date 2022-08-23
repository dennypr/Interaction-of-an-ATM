package com.knf.dev.web;

import com.knf.dev.model.Atm;
import com.knf.dev.repository.AtmRepository;
import com.knf.dev.repository.UserRepository;
import com.knf.dev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AtmRepository atmRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Atm atm = atmRepository.findByEmail(name);
		model.addAttribute("username", name);
		Double saldo=0.0;

		if(atm == null){
			saldo =0.0;
		}else{
			saldo = atm.getSaldo();
		}
		model.addAttribute("balance", saldo);
		return "index";
	}

	@GetMapping("/deposit")
	public String deposit(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Atm atm = atmRepository.findByEmail(name);

		if(atm == null){
			Atm k = new Atm();
			k.setId(0L);
			k.setEmail(" ");
			k.setSaldo(0.0);
			k.setNorekening(null);
			model.addAttribute("Atm", k);

		}else{
			model.addAttribute("Atm", atm);
		}
		model.addAttribute("Email", name);

		return "deposit";
	}

	@GetMapping("/withdraw")
	public String withdraw(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Atm atm = atmRepository.findByEmail(name);

		if(atm == null){
			Atm k = new Atm();
			k.setId(0L);
			k.setEmail(" ");
			k.setSaldo(0.0);
			k.setNorekening(null);
			model.addAttribute("Atm", k);

		}else{
			model.addAttribute("Atm", atm);
		}
		model.addAttribute("Email", name);
		return "withdraw";
	}

	@GetMapping("/transfer")
	public String transfer(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Atm atm = atmRepository.findByEmail(name);

		model.addAttribute("Email", name);
		model.addAttribute("Atm", atm);
		if(atm == null){
			Atm k = new Atm();
			k.setId(0L);
			k.setEmail(" ");
			k.setSaldo(0.0);
			k.setNorekening(null);
			model.addAttribute("Atm", k);

		}else{
			model.addAttribute("Atm", atm);
		}
		model.addAttribute("Email", name);
		return "transfer";
	}

	@PostMapping("/save-deposit")
	public String savedeposit(@RequestParam("saldo") Double saldo,
					  @RequestParam("norekening") Long norekening) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Atm a = atmRepository.findByEmail(name);

		Double balance=0.0;

		if(a == null){
			balance =saldo;
			Atm atm = new Atm();
			atm.setEmail(name);
			atm.setSaldo(saldo);
			atm.setNorekening(norekening);
			atmRepository.save(atm);
		}else{
			balance = a.getSaldo() + saldo;
			Atm jk = atmRepository.findByEmail(name);
			jk.setEmail(name);
			jk.setSaldo(balance);
			jk.setNorekening(norekening);
			atmRepository.save(jk);
		}

		return "redirect:/";
	}

	@PostMapping("/save-withdraw")
	public String savewithdraw(@RequestParam("saldo") Double saldo,
					  @RequestParam("norekening") Long norekening) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Atm a = atmRepository.findByEmail(name);
		Double balance=0.0;
		if(a == null){
			balance =saldo;
			Atm atm = new Atm();
			atm.setEmail(name);
			atm.setSaldo(saldo);
			atm.setNorekening(norekening);
			atmRepository.save(atm);
		}else{
			balance = a.getSaldo() - saldo;
			Atm jk = atmRepository.findByEmail(name);
			jk.setEmail(name);
			jk.setSaldo(balance);
			jk.setNorekening(norekening);
			atmRepository.save(jk);
		}

		return "redirect:/";
	}

	@PostMapping("/save-transfer")
	public String savetransfer(@RequestParam("saldo") Double saldo,
							   @RequestParam("jumlah") Double jumlah,
							   @RequestParam("norekening") Long norekening,
							   @RequestParam("rekeningtujuan") Long rekeningtujuan) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Atm a = atmRepository.findByNorekening(rekeningtujuan);
		Atm sumber = atmRepository.findByEmail(name);

		Double balance=0.0;

		if(a != null){
			balance = a.getSaldo() + jumlah;
			Atm jk = atmRepository.findByNorekening(rekeningtujuan);
			jk.setEmail(a.getEmail());
			jk.setSaldo(balance);
			jk.setNorekening(rekeningtujuan);
			atmRepository.save(jk);

			balance = sumber.getSaldo()- jumlah;
			Atm x = atmRepository.findByEmail(name);
			x.setEmail(name);
			x.setSaldo(balance);
			x.setNorekening(norekening);
			atmRepository.save(x);
		}

		return "redirect:/";
	}
}
