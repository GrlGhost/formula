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
    override fun visit(add: Add): Result<Number> {
        val rightResult: Result<Number> = add.rightFunction.accepts(this)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = add.leftFunction.accepts(this)
        if (leftResult.isFailure) return leftResult

        return addVisitor.process(rightResult.getOrNull()!!, leftResult.getOrNull()!!)
    }

    override fun visit(subtract: Subtract): Result<Number> {
        val rightResult: Result<Number> = subtract.rightFunction.accepts(this)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = subtract.leftFunction.accepts(this)
        if (leftResult.isFailure) return leftResult

        val minusLeftValue: Number = when (val leftValue: Number = leftResult.getOrNull()!!){
            is ByteNumber -> IntNumber(-1*leftValue.value)
            is IntNumber -> IntNumber(-1*leftValue.value)
            is LongNumber -> LongNumber(-1*leftValue.value)
            is DoubleNumber -> DoubleNumber(-1*leftValue.value)
        }

        return addVisitor.process(rightResult.getOrNull()!!, minusLeftValue)
    }

    override fun visit(multiply: Multiply): Result<Number> {
        val rightResult: Result<Number> = multiply.rightFunction.accepts(this)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = multiply.leftFunction.accepts(this)
        if (leftResult.isFailure) return leftResult

        return multiVisitor.process(rightResult.getOrNull()!!, leftResult.getOrNull()!!)
    }

    override fun visit(divide: Divide): Result<Number> {
        val rightResult: Result<Number> = divide.rightFunction.accepts(this)
        if (rightResult.isFailure) return rightResult
        val leftResult: Result<Number> = divide.leftFunction.accepts(this)
        if (leftResult.isFailure) return leftResult

        val divisionValue: Number = when (val leftValue: Number = leftResult.getOrNull()!!){
            is ByteNumber -> DoubleNumber(1 / leftValue.value.toDouble())
            is IntNumber -> DoubleNumber( 1 / leftValue.value.toDouble())
            is LongNumber -> DoubleNumber(1 / leftValue.value.toDouble())
            is DoubleNumber -> DoubleNumber(1/leftValue.value)
        }

        return multiVisitor.process(rightResult.getOrNull()!!, divisionValue)
    }

    override fun visit(power: Power): Result<Number> {
        val baseResult: Result<Number> = power.base.accepts(this)
        if (baseResult.isFailure) return baseResult
        val pResult: Result<Number> = power.p.accepts(this)
        if (pResult.isFailure) return pResult

        val base: Double = when(val baseAux = baseResult.getOrNull()!!){
            is ByteNumber -> baseAux.value.toDouble()
            is IntNumber -> baseAux.value.toDouble()
            is LongNumber -> baseAux.value.toDouble()
            is DoubleNumber -> baseAux.value
        }

        val p: Double = when(val pAux = pResult.getOrNull()!!){
            is ByteNumber -> pAux.value.toDouble()
            is IntNumber -> pAux.value.toDouble()
            is LongNumber -> pAux.value.toDouble()
            is DoubleNumber -> pAux.value
        }
        return Result.success(DoubleNumber(base.pow(p)))
    }

    override fun visit(root: Root): Result<Number> {
        val baseResult: Result<Number> = root.base.accepts(this)
        if (baseResult.isFailure) return baseResult
        val pResult: Result<Number> = root.p.accepts(this)
        if (pResult.isFailure) return pResult

        val base: Double = when(val baseAux = baseResult.getOrNull()!!){
            is ByteNumber -> baseAux.value.toDouble()
            is IntNumber -> baseAux.value.toDouble()
            is LongNumber -> baseAux.value.toDouble()
            is DoubleNumber -> baseAux.value
        }

        val p: Double = when(val pAux = pResult.getOrNull()!!){
            is ByteNumber -> pAux.value.toDouble()
            is IntNumber -> pAux.value.toDouble()
            is LongNumber -> pAux.value.toDouble()
            is DoubleNumber -> pAux.value
        }
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
}