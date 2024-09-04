package com.introduction.ProductServiceAug24.Controllers;

import com.introduction.ProductServiceAug24.Exceptions.ProductNotFoundExceptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello")
public class SampleController {

    @GetMapping("/hello")
    public String printString() {
        return "Hello World!! First Project";
    }

    @GetMapping("/hello/{name}")
    public String printName(@PathVariable("name") String name) throws ProductNotFoundExceptions{
        if(name.charAt(0)<65 || name.charAt(0)>90) {
            throw new ProductNotFoundExceptions("Name starts with capital english alphabet");
        }
        return "Hello "+name+". Welcome to SpringBoot Project";
    }

    @GetMapping("/shows/{show_name}/seats/{seat_id}")
    public String showSeatStatus(@PathVariable("show_name") String show, @PathVariable("seat_id") int seat_num) {
        return "Seat for "+show+" having seat number "+seat_num;
    }
}
