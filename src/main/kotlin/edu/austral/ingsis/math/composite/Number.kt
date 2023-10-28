package edu.austral.ingsis.math.composite

class Number(val value: Double): Function {
    override fun toString(): String = if (value.rem(1) != 0.0) value.toString() else value.toLong().toString()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> = Result.success(this)
    override fun listVariables(): List<String> = listOf()
}