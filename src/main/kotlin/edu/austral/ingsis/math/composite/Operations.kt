package edu.austral.ingsis.math.composite

import edu.austral.ingsis.math.visitor.visitor.numberVisitors.NumberVisitor
import kotlin.math.absoluteValue
import kotlin.math.pow


class Add(val rightFunction: Function, val leftFunction: Function): Function {
    override fun toString(): String = "$rightFunction + $leftFunction"
    override fun listVariables(): List<String> = rightFunction.listVariables() + leftFunction.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        val rightResult: Result<Number> = rightFunction.evaluate(variableValues)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = leftFunction.evaluate(variableValues)
        if (leftResult.isFailure) return leftResult

        return Result.success(rightResult.getOrNull()!! + leftResult.getOrNull()!!)
    }
}

class Subtract(val rightFunction: Function, val leftFunction: Function): Function {
    override fun toString(): String = "$rightFunction - $leftFunction"
    override fun listVariables(): List<String> = rightFunction.listVariables() + leftFunction.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        val rightResult: Result<Number> = rightFunction.evaluate(variableValues)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = leftFunction.evaluate(variableValues)
        if (leftResult.isFailure) return leftResult

        return Result.success(rightResult.getOrNull()!! - leftResult.getOrNull()!!)
    }
}

class Multiply(val rightFunction: Function, val leftFunction: Function): Function {
    override fun toString(): String = "$rightFunction * $leftFunction"
    override fun listVariables(): List<String> = rightFunction.listVariables() + leftFunction.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        val rightResult: Result<Number> = rightFunction.evaluate(variableValues)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = leftFunction.evaluate(variableValues)
        if (leftResult.isFailure) return leftResult

        return Result.success(rightResult.getOrNull()!! * leftResult.getOrNull()!!)
    }
}

class Divide(val rightFunction: Function, val leftFunction: Function): Function {
    override fun toString(): String = "$rightFunction / $leftFunction"
    override fun listVariables(): List<String> = rightFunction.listVariables() + leftFunction.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        val rightResult: Result<Number> = rightFunction.evaluate(variableValues)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = leftFunction.evaluate(variableValues)
        if (leftResult.isFailure) return leftResult

        return Result.success(rightResult.getOrNull()!! / leftResult.getOrNull()!!)
    }
}

class Power(val base: Function, val p: Function): Function {
    override fun toString(): String = "$base ^ $p"
    override fun listVariables(): List<String> = base.listVariables() + p.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        val rightResult: Result<Number> = base.evaluate(variableValues)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = p.evaluate(variableValues)
        if (leftResult.isFailure) return leftResult

        return Result.success(rightResult.getOrNull()!!.pow(leftResult.getOrNull()!!))
    }
}

class Root(val base: Function, val p: Function): Function {
    override fun toString(): String = "$base -^ $p"
    override fun listVariables(): List<String> = base.listVariables() + p.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        val rightResult: Result<Number> = base.evaluate(variableValues)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = p.evaluate(variableValues)
        if (leftResult.isFailure) return leftResult

        return Result.success(rightResult.getOrNull()!!.root(leftResult.getOrNull()!!))
    }
}

class Module(val function: Function): Function {
    override fun toString(): String = "|$function|"
    override fun listVariables(): List<String> = function.listVariables()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> {
        val result: Result<Number> = function.evaluate(variableValues)
        if (result.isFailure) return result

        return Result.success(Number(result.getOrNull()!!.value.absoluteValue))
    }
}