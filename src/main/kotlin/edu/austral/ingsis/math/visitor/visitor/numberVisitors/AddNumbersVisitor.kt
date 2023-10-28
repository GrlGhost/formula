package edu.austral.ingsis.math.visitor.visitor.numberVisitors

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Number


class AddNumbersVisitor: NumberVisitor {
    override fun visit(byte: ByteNumber, other: ByteNumber): Result<Number> =
        Result.success(ByteNumber((byte.value + other.value).toByte()))
    override fun visit(byte: ByteNumber, other: IntNumber): Result<Number> =
        Result.success(IntNumber(byte.value + other.value))
    override fun visit(byte: ByteNumber, other: LongNumber): Result<Number> =
        Result.success(LongNumber(byte.value + other.value))
    override fun visit(byte: ByteNumber, other: DoubleNumber): Result<Number> =
        Result.success(DoubleNumber(byte.value + other.value))


    override fun visit(int: IntNumber, other: ByteNumber): Result<Number> =
        Result.success(IntNumber(int.value + other.value))
    override fun visit(int: IntNumber, other: IntNumber): Result<Number> =
        Result.success(IntNumber(int.value + other.value))
    override fun visit(int: IntNumber, other: LongNumber): Result<Number> =
        Result.success(LongNumber(int.value + other.value))
    override fun visit(int: IntNumber, other: DoubleNumber): Result<Number> =
        Result.success(DoubleNumber(int.value + other.value))


    override fun visit(long: LongNumber, other: ByteNumber): Result<Number> =
        Result.success(LongNumber(long.value + other.value))
    override fun visit(long: LongNumber, other: IntNumber): Result<Number> =
        Result.success(LongNumber(long.value + other.value))
    override fun visit(long: LongNumber, other: LongNumber): Result<Number> =
        Result.success(LongNumber(long.value + other.value))
    override fun visit(long: LongNumber, other: DoubleNumber): Result<Number> =
        Result.success(DoubleNumber(long.value + other.value))


    override fun visit(double: DoubleNumber, other: ByteNumber): Result<Number> =
        Result.success(DoubleNumber(double.value + other.value))
    override fun visit(double: DoubleNumber, other: IntNumber): Result<Number> =
        Result.success(DoubleNumber(double.value + other.value))
    override fun visit(double: DoubleNumber, other: LongNumber): Result<Number> =
        Result.success(DoubleNumber(double.value + other.value))
    override fun visit(double: DoubleNumber, other: DoubleNumber): Result<Number> =
        Result.success(DoubleNumber(double.value + other.value))

    override fun process(number: Number, other: Number): Result<Number> =
        number.accepts(this, other)
}