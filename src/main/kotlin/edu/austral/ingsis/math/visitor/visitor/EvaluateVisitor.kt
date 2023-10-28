package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Function
import edu.austral.ingsis.math.visitor.function.Number
import edu.austral.ingsis.math.visitor.visitor.numberVisitors.AddNumbersVisitor
import edu.austral.ingsis.math.visitor.visitor.numberVisitors.MultiplyNumberVisitor
import edu.austral.ingsis.math.visitor.visitor.numberVisitors.NumberVisitor
import kotlin.math.absoluteValue
import kotlin.math.pow


class EvaluateVisitor: Visitor<Number> {
    private val addVisitor: NumberVisitor = AddNumbersVisitor()
    private val multiVisitor: NumberVisitor = MultiplyNumberVisitor()
    override fun visit(add: Add): Result<Number> =
        applyOperation(addVisitor, add.rightFunction, add.leftFunction)

    override fun visit(subtract: Subtract): Result<Number> =
        applyOperationWithOperationToLeft(
            addVisitor, subtract.rightFunction, subtract.leftFunction, ::multiplyByMinusOne
        )

    override fun visit(multiply: Multiply): Result<Number> =
        applyOperation(multiVisitor, multiply.rightFunction, multiply.leftFunction)

    override fun visit(divide: Divide): Result<Number> =
        applyOperationWithOperationToLeft(
            multiVisitor, divide.rightFunction, divide.leftFunction, ::invertNumber
        )

    override fun visit(power: Power): Result<Number> {
        val baseResult: Result<Number> = power.base.accepts(this)
        if (baseResult.isFailure) return baseResult
        val pResult: Result<Number> = power.p.accepts(this)
        if (pResult.isFailure) return pResult

        val base: Double = numberToDouble(baseResult.getOrNull()!!)
        val p: Double = numberToDouble(pResult.getOrNull()!!)

        return Result.success(DoubleNumber(base.pow(p)))
    }

    override fun visit(root: Root): Result<Number> {
        val baseResult: Result<Number> = root.base.accepts(this)
        if (baseResult.isFailure) return baseResult
        val pResult: Result<Number> = root.p.accepts(this)
        if (pResult.isFailure) return pResult

        val base: Double = numberToDouble(baseResult.getOrNull()!!)
        val p: Double = numberToDouble(pResult.getOrNull()!!)

        return Result.success(DoubleNumber(base.pow(-p)))
    }

    override fun visit(module: Module): Result<Number> {
        val modResult: Result<Number> = module.function.accepts(this)
        if (modResult.isFailure) return modResult

        return Result.success(when(val value: Number = modResult.getOrNull()!!){
            is ByteNumber -> value
            is IntNumber -> IntNumber(value.value.absoluteValue)
            is LongNumber -> LongNumber(value.value.absoluteValue)
            is DoubleNumber -> DoubleNumber(value.value.absoluteValue)
        })
    }

    override fun visit(number: Number): Result<Number> =
        Result.success(number)

    override fun visit(variable: Variable): Result<Number> =
        Result.failure(Exception("Can not evaluate variable"))

    override fun visit(parenthesis: Parenthesis): Result<Number> =
        parenthesis.function.accepts(this)

    override fun process(function: Function): Result<Number> =
        function.accepts(this)


    private fun numberToDouble(number: Number): Double = when(number){
            is ByteNumber -> number.value.toDouble()
            is IntNumber -> number.value.toDouble()
            is LongNumber -> number.value.toDouble()
            is DoubleNumber -> number.value
    }

    private fun applyOperation(numberOperator: NumberVisitor, rFunction: Function, lFunction: Function): Result<Number>{
        val rightResult: Result<Number> = rFunction.accepts(this)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = lFunction.accepts(this)
        if (leftResult.isFailure) return leftResult

        return numberOperator.process(rightResult.getOrNull()!!, leftResult.getOrNull()!!)
    }

    /**
     * Calculates the functions if all successful results then the extraOp is applied to the left result.
     * Then the number operator is applied to the rightResult and left value got from extraOp
     */
    private fun applyOperationWithOperationToLeft(
        numberOperator: NumberVisitor, rFunction: Function, lFunction: Function, extraOp: (Number) -> Number
    ): Result<Number> {
        val rightResult: Result<Number> = rFunction.accepts(this)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = lFunction.accepts(this)
        if (leftResult.isFailure) return leftResult

        val leftValue: Number = extraOp.invoke(leftResult.getOrNull()!!)

        return numberOperator.process(rightResult.getOrNull()!!, leftValue)
    }

    /**
     * Given any type of number x the value returned is -x of th same type.
     * There is an exception with ByteType witch will be IntNumber
     */
    private fun multiplyByMinusOne(number: Number): Number = when (number){
        is ByteNumber -> IntNumber(-1*number.value)
        is IntNumber -> IntNumber(-1*number.value)
        is LongNumber -> LongNumber(-1*number.value)
        is DoubleNumber -> DoubleNumber(-1*number.value)
    }

    /**
     * Given any type of number x the value returned is 1/x as a DoubleNumber
     */
    private fun invertNumber(number: Number): Number = when (number){
        is ByteNumber -> DoubleNumber(1 / number.value.toDouble())
        is IntNumber -> DoubleNumber( 1 / number.value.toDouble())
        is LongNumber -> DoubleNumber(1 / number.value.toDouble())
        is DoubleNumber -> DoubleNumber(1/ number.value)
    }


}