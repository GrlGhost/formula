package edu.austral.ingsis.math.visitor.visitor.numberVisitors

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Number

interface NumberVisitor {
    fun visit(byte: ByteNumber, other: ByteNumber): Result<Number>
    fun visit(byte: ByteNumber, other: IntNumber): Result<Number>
    fun visit(byte: ByteNumber, other: LongNumber): Result<Number>
    fun visit(byte: ByteNumber, other: DoubleNumber): Result<Number>


    fun visit(int: IntNumber, other: ByteNumber): Result<Number>
    fun visit(int: IntNumber, other: IntNumber): Result<Number>
    fun visit(int: IntNumber, other: LongNumber): Result<Number>
    fun visit(int: IntNumber, other: DoubleNumber): Result<Number>


    fun visit(long: LongNumber, other: ByteNumber): Result<Number>
    fun visit(long: LongNumber, other: IntNumber): Result<Number>
    fun visit(long: LongNumber, other: LongNumber): Result<Number>
    fun visit(long: LongNumber, other: DoubleNumber): Result<Number>


    fun visit(double: DoubleNumber, other: ByteNumber): Result<Number>
    fun visit(double: DoubleNumber, other: IntNumber): Result<Number>
    fun visit(double: DoubleNumber, other: LongNumber): Result<Number>
    fun visit(double: DoubleNumber, other: DoubleNumber): Result<Number>


    fun process(number: Number, other: Number): Result<Number>
}