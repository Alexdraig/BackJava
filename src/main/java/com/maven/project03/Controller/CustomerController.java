package com.maven.project03.Controller;

import com.maven.project03.Model.Customer;
import com.maven.project03.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/customers"})
public class CustomerController {
    @Autowired
    CustomerRepository cr;

    @GetMapping
    public List<Customer> listar(){
        return cr.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public Customer listarId(@PathVariable Integer id){
        return cr.findById(id).get();
    }

    @PostMapping
    public Customer agregar(@RequestBody Customer customer){
        return cr.save(customer);
    }

    @PutMapping(path = {"/{id}"})
    public Customer editar(@PathVariable Integer id, @RequestBody Customer customer){
        //customer.setCustomer_id(id);
        Customer updateCustom = cr.findById(id).get();
        updateCustom.setCompany_name(customer.getCompany_name());
        updateCustom.setContact_name(customer.getContact_name());
        updateCustom.setContact_title(customer.getContact_title());
        updateCustom.setAddress(customer.getAddress());
        updateCustom.setCity(customer.getCity());
        updateCustom.setRegion(customer.getRegion());
        updateCustom.setPostal_code(customer.getPostal_code());
        updateCustom.setCountry(customer.getCountry());
        updateCustom.setPhone(customer.getPhone());
        updateCustom.setFax(customer.getFax());
        return cr.save(updateCustom);
    }

    @DeleteMapping(path = {"/{id}"})
    public Customer delete(@PathVariable Integer id){
        Customer deleteCustom = cr.findById(id).get();
        if(deleteCustom != null){
            cr.delete(deleteCustom);
        }
        return deleteCustom;
    }
}
