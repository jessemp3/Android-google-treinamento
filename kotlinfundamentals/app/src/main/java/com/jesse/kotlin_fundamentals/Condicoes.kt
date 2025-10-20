package com.jesse.kotlin_fundamentals

class Condicoes {
    fun condicoes(){
        val x = 4

        when (x) {
            2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
            in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
            else -> println("x isn't a prime number between 1 and 10.")
        }


        val trafficLightColor = "Red"

        val message =
            if (trafficLightColor == "Red") "Stop"
            else if (trafficLightColor == "Yellow") "Slow"
            else if (trafficLightColor == "Green") "Go"
            else "Invalid traffic-light color"

        println(message)
    }


    fun nulabilidade(){
        var nome: String? = null

        // Usando o operador safe call (?.)
        val tamanhoNome = nome?.length
        println("Tamanho do nome: $tamanhoNome") // Imprime: Tamanho do nome: null

        // Usando o operador Elvis (?:)
        val tamanhoNomeComDefault = nome?.length ?: 0
        println("Tamanho do nome com valor padrão: $tamanhoNomeComDefault") // Imprime: Tamanho do nome com valor padrão: 0

        // Usando o operador not-null assertion (!!)
        try {
            val tamanhoNomeNaoNulo = nome!!.length
            println("Tamanho do nome não nulo: $tamanhoNomeNaoNulo")
        } catch (e: KotlinNullPointerException) {
            println("Erro: Tentativa de acessar uma variável nula usando '!!'")
        }
    }

}