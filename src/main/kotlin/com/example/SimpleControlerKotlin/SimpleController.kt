package com.example.SimpleControlerKotlin

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class SimpleController {
    var array =  IntArray(10,{x -> x * x})
    var array1 = Array(5,{array})
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
    //W przegladarce musimy podac wszystkie parametry , mozemy to wylaczyc
    // poprzez dodanie requiered = false uwaga zroci NULL
    //Mozemy uzyc defeultValuse = "2.2"

    fun linear(@RequestParam("b") x:Double,
               @RequestParam("a", required = false) a:Double,
               @RequestParam("b", defaultValue = "0.0") b : Double
               ):Double {
        return x + a + b
    };
    @RequestMapping("/student/{id}")
    @ResponseBody
    //{id} w to miejsce dynmicznie wypisywanie nr
    //przekazanie parametruy do fun przez przegladarkje /student?name=marek
    fun getStudent(@PathVariable("id") id:Int, @RequestParam("name") name:String):String{
        //@PathVariable("id") id: Int pobiera id z adresu
        //pobiera id i name
        return "${id} , ${name} = "
    }
//tablica zosatnie cala wyswietlana
    @RequestMapping ("tablica")
    @ResponseBody
    fun tablica(): IntArray{
    return array

}
    //z tablicy zostanie pobrana wartos z indeksu
    @RequestMapping("tablica/{i}/{j}")
    @ResponseBody
    //pobierany parametr z url {i}
    fun getTablicaValue(@PathVariable("i") i:Int,
                        @PathVariable("j") j:Int
                        ):Int{

        //return array[i]
        return array1[i][j]
    }
}