package edu.austral.ingsis.math.composite;


interface Function {
    override fun toString(): String
    fun evaluate(variableValues: Map<String, Number> = mapOf()): Result<Number>
    fun listVariables(): List<String>
}
