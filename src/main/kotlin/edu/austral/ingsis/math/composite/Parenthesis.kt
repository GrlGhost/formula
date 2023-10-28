package edu.austral.ingsis.math.composite

class Parenthesis(val function: Function): Function {
    override fun toString(): String = "($function)"
    override fun listVariables(): List<String> = function.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> = function.evaluate(variableValues)

}