package com.example.mip.funciones

import java.lang.ArithmeticException

object OpMatematicas {

    fun dividirValores(valor1: Int, valor2:Int):String{
        try {
            var calculo_interno: Int = valor1 / valor2
            return calculo_interno.toString()
        }catch (e: ArithmeticException){
            return "error 404"
        }finally {
            println("SE A CONTROLADO EL ERROR DIVISION BY ZERO")
        }

    }
}