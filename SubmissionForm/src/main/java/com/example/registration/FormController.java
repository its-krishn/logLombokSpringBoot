package com.example.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller

public class FormController {
	
	@Autowired
	CustomerRepo repo;
	
	
	@RequestMapping("/")
	public String details()
	{
		log.info("details method started");
		
		return "cust";
		
	}
	
	
	@RequestMapping("/details")
	public String details(Customers customers)
	{
		log.info("details method started by passing customers{}",customers);
		log.info("details method end");
		 repo.save(customers);
		return "cust";
	}
	
	
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
		log.info("getdetails method started");
		log.info("getdetails method end");
		return "View";
	}
	
	
	
	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid)
	{
		log.info("getdetails method by passing id");
		ModelAndView mv=new ModelAndView("Retrive");
		Customers customers=repo.findById(cid).orElse(null);
         mv.addObject(customers);
         log.info("getdetails method by passing id end");
         return mv;
	
	}
	
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers()
	
	{
		log.info("getCustomers method started");
		log.info("getCustomers method end");
		return repo.findAll();
	}
	
	
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomersid(@PathVariable("cid") int  cid)
	{
		log.info("getCustomersid method started");
		log.info("getCustomersid method end");
		return repo.findById(cid);
	}
	
	
	
	@PostMapping("/customers")
	
	public Customers getCustomers3(@RequestBody Customers customers)
	{
		log.info("getCustomers3 method started");
		repo.save(customers);
		log.info("getCustomers3 method end");
		
		return customers;
	}
	
	
	
@DeleteMapping("/customers/{cid}")
	
	public Customers getCustomers4(@PathVariable("cid") int cid)
	{
	    log.info("getCustomers4 method started");
		Customers c=repo.getOne(cid);
		repo.delete(c);
		log.info("getCustomers4 method end");
		
		return c;
	}




@PutMapping(path="/customers",consumes= {"application/json"})

public Customers getCustomers5(@RequestBody Customers customers)
{
	log.info("getCustomers5 method started");
	
	repo.save(customers);
	log.info("getCustomers5 method started");
	return customers;
}
}
