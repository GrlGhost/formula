package edu.austral.ingsis.math.composite


class Add(val rightFunction: Function, val leftFunction: Function): Function {
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

class Subtract(val rightFunction: Function, val leftFunction: Function): Function {
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

class Multiply(val rightFunction: Function, val leftFunction: Function): Function {
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

class Divide(val rightFunction: Function, val leftFunction: Function): Function {
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

class Power(val base: Function, val p: Function): Function {
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

class Root(val base: Function, val p: Function): Function {
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

class Module(val function: Function): Function {
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