package edu.austral.ingsis.math.composite


class Add(val rightFunction: Function, val leftFunction: Function): Function {
    override fun toString(): String = "$rightFunction + $leftFunction"
    override fun listVariables(): List<String> = rightFunction.listVariables() + leftFunction.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        TODO("Not yet implemented")
    }
}

class Subtract(val rightFunction: Function, val leftFunction: Function): Function {
    override fun toString(): String = "$rightFunction - $leftFunction"
    override fun listVariables(): List<String> = rightFunction.listVariables() + leftFunction.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        TODO("Not yet implemented")
    }
}

class Multiply(val rightFunction: Function, val leftFunction: Function): Function {
    override fun toString(): String = "$rightFunction * $leftFunction"
    override fun listVariables(): List<String> = rightFunction.listVariables() + leftFunction.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        TODO("Not yet implemented")
    }
}

class Divide(val rightFunction: Function, val leftFunction: Function): Function {
    override fun toString(): String = "$rightFunction / $leftFunction"
    override fun listVariables(): List<String> = rightFunction.listVariables() + leftFunction.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        TODO("Not yet implemented")
    }
}

class Power(val base: Function, val p: Function): Function {
    override fun toString(): String = "$base ^ $p"
    override fun listVariables(): List<String> = base.listVariables() + p.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        TODO("Not yet implemented")
    }
}

class Root(val base: Function, val p: Function): Function {
    override fun toString(): String = "$base -^ $p"
    override fun listVariables(): List<String> = base.listVariables() + p.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        TODO("Not yet implemented")
    }
}

class Module(val function: Function): Function {
    override fun toString(): String = "|$function|"
    override fun listVariables(): List<String> = function.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        TODO("Not yet implemented")
    }
}