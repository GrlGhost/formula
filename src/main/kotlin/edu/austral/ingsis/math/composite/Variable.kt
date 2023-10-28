package edu.austral.ingsis.math.composite

class Variable(val name: String): Function {
    override fun toString(): String {
        TODO("Not yet implemented")
    }

    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        TODO("Not yet implemented")
    }

    override fun listVariables(): List<String> {
        TODO("Not yet implemented")
    }
}