package com.example.SimpleControlerKotlin

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@Controller
class SimpleController {
    @RequestMapping( "/home")
    //@ResponseBody tworzy stronke tylko dla home gdy uzywamy @Controller
    @ResponseBody
    fun info():String{
        return "info 12345"
    }
    //tworzymy endpoint z sciezka /next
    //brak @ResponseBody = error
    @RequestMapping("/next")
    //funkcja ktora cos zwroci na stronie
    fun add():Int{
     val x = 2;
        val y = 3;
        return x + y
    };
    @RequestMapping("/linear")

    @ResponseBody
    //przekazanie parametru w przegladarce
    //localhosty:8080/linear?x=10
    //localhosty:8080/linear?x=10 & a=5 & b=4
    //Aby dodad killa parametrow nalezy ponownie uzyc @RequestParam
    fun linear(@RequestParam("b") x:Double,
    @RequestParam("a") a:Double,
               @RequestParam("b") b : Double
               ):Double {
        return x + a + b
    };

}