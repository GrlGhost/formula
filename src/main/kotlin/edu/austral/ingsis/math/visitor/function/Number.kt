package edu.austral.ingsis.math.visitor.function

import edu.austral.ingsis.math.visitor.visitor.Visitor

sealed class Number: Function {
}

data class ByteNumber(val value: Byte): Number(){
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

data class IntNumber(val value: Int): Number() {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

data class LongNumber(val value: Long): Number() {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

data class DoubleNumber(val value: Double): Number() {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}