package com.visa.workshop13prac.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.workshop13prac.Model.Contacts;
import com.visa.workshop13prac.Service.util;

@Controller
public class AddressBookController {
    
    private static final Logger logger = LoggerFactory.getLogger(AddressBookController.class);

    @Autowired      // autowire Args to get dataDir path
    ApplicationArguments args;


    @RequestMapping("/saved")
    public String saveDetails(@ModelAttribute Contacts contact, Model model){       

        String dataDirectory = args.getOptionValues("dataDir").get(0);
        logger.info("Inside Controller >>> check DataDir " + dataDirectory);

        contact.generateId();
        String fileName = dataDirectory + "/" + contact.getId();

        util.saveContact(fileName, contact);
        model.addAttribute("Contact", contact);

        return "saveConfirmation";
    }


    @GetMapping("Contacts/{id}")
    public String getDetails(@PathVariable String id, Model model){
        
        String dataDirectory = args.getOptionValues("dataDir").get(0);
        Contacts contact = new Contacts();
        contact.setId(id);

        String fileName = dataDirectory + "/" + id;
        util.loadContact(fileName, contact);

        logger.info("Inside displycontact check email >>>>> " + contact.getEmail());
        model.addAttribute("Contact", contact);

        return "displayContact";

    }


}
