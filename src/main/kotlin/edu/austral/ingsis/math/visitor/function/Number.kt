package edu.austral.ingsis.math.visitor.function

import edu.austral.ingsis.math.visitor.visitor.Visitor
import edu.austral.ingsis.math.visitor.visitor.numberVisitors.NumberVisitor


sealed class Number: Function {
    abstract fun accepts(numberVisitor: NumberVisitor, other: Number): Result<Number>
    abstract fun acceptsAux(numberVisitor: NumberVisitor, other: ByteNumber): Result<Number>
    abstract fun acceptsAux(numberVisitor: NumberVisitor, other: IntNumber): Result<Number>
    abstract fun acceptsAux(numberVisitor: NumberVisitor, other: LongNumber): Result<Number>
    abstract fun acceptsAux(numberVisitor: NumberVisitor, other: DoubleNumber): Result<Number>
}

data class ByteNumber(val value: Byte): Number(){
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)

    override fun accepts(numberVisitor: NumberVisitor, other: Number): Result<Number> =
        other.acceptsAux(numberVisitor, this)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: ByteNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: IntNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: LongNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: DoubleNumber): Result<Number> =
        numberVisitor.visit(this, other)
}

data class IntNumber(val value: Int): Number() {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)


    override fun accepts(numberVisitor: NumberVisitor, other: Number): Result<Number> =
        other.acceptsAux(numberVisitor, this)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: ByteNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: IntNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: LongNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: DoubleNumber): Result<Number> =
        numberVisitor.visit(this, other)
}

data class LongNumber(val value: Long): Number() {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)


    override fun accepts(numberVisitor: NumberVisitor, other: Number): Result<Number> =
        other.acceptsAux(numberVisitor, this)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: ByteNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: IntNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: LongNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: DoubleNumber): Result<Number> =
        numberVisitor.visit(this, other)
}

data class DoubleNumber(val value: Double): Number() {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)


    override fun accepts(numberVisitor: NumberVisitor, other: Number): Result<Number> =
        other.acceptsAux(numberVisitor, this)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: ByteNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: IntNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: LongNumber): Result<Number> =
        numberVisitor.visit(this, other)
    override fun acceptsAux(numberVisitor: NumberVisitor, other: DoubleNumber): Result<Number> =
        numberVisitor.visit(this, other)
}
