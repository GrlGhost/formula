package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Function
import edu.austral.ingsis.math.visitor.function.Module
import edu.austral.ingsis.math.visitor.function.Number

class PrinterVisitor(): Visitor<String> {
    override fun visit(add: Add): Result<String> {
        return insertsStringInMiddle(" + ", add.rightFunction, add.leftFunction)
    }

    override fun visit(subtract: Subtract): Result<String> {
        return insertsStringInMiddle(" - ", subtract.rightFunction, subtract.leftFunction)
    }

    override fun visit(multiply: Multiply): Result<String> {
        return insertsStringInMiddle(" * ", multiply.rightFunction, multiply.leftFunction)
    }

    override fun visit(divide: Divide): Result<String> {
        return insertsStringInMiddle(" / ", divide.rightFunction, divide.leftFunction)
    }

    override fun visit(power: Power): Result<String> {
        return insertsStringInMiddle(" ^ ", power.base, power.p)
    }

    //TODO: verify if this string is acceptable
    override fun visit(root: Root): Result<String> {
        return insertsStringInMiddle(" -^ ", root.base, root.p)
    }

    override fun visit(module: Module): Result<String> =
        surroundFunctionWithString("|", "|", module.function)


    override fun visit(number: Number): Result<String> =
        Result.success(
            when (number){
                is ByteNumber -> number.value.toString()
                is IntNumber -> number.value.toString()
                is LongNumber -> number.value.toString()
                is DoubleNumber -> number.value.toString()
            }
        )

    override fun visit(variable: Variable): Result<String> = Result.success(variable.name)

    override fun visit(parenthesis: Parenthesis): Result<String> =
        surroundFunctionWithString("(", ")", parenthesis.function)
    override fun process(function: Function): Result<String> = function.accepts(this)

    private fun insertsStringInMiddle(string: String, rightFunction: Function, leftFunction: Function): Result<String> {
        val rightResult: Result<String> =  rightFunction.accepts(this)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<String> =  leftFunction.accepts(this)
        if (leftResult.isFailure) return leftResult

        return Result.success(rightResult.getOrNull() + string + leftResult.getOrNull())
    }

    private fun surroundFunctionWithString(rightString: String, leftString: String, function: Function): Result<String> {
        val functionResult: Result<String> =  function.accepts(this)
        if (functionResult.isFailure) return functionResult

        return Result.success(rightString + functionResult.getOrNull() + leftString)
    }

}