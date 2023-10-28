package edu.austral.ingsis.math.composite

class Variable(val name: String): Function {
    override fun toString(): String = name
    override fun listVariables(): List<String> = listOf(name)

    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        val value: Number = variableValues[name] ?: return Result.failure(Exception("Variable value not defined"))
        return Result.success(value)
    }

}