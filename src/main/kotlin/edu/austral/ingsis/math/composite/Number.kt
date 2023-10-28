package edu.austral.ingsis.math.composite

class Number(val value: Double): Function {
    override fun toString(): String = value.toString()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> = Result.success(this)
    override fun listVariables(): List<String> = listOf()
}