package edu.austral.ingsis.math.composite

import kotlin.math.pow

class Number(val value: Double): Function {
    override fun toString(): String = if (value.rem(1) != 0.0) value.toString() else value.toLong().toString()
    override fun evaluate(variableValues: Map<String, Number>): Result<Number> = Result.success(this)
    override fun listVariables(): List<String> = listOf()

    operator fun plus(other: Number): Number = Number(value + other.value)
    operator fun minus(other: Number): Number = Number(value - other.value)
    operator fun times(other: Number): Number = Number(value * other.value)
    operator fun div(other: Number): Number = Number(value / other.value)
    fun pow(other: Number): Number = Number(value.pow(other.value))
    fun root(other: Number): Number = Number(value.pow(-other.value))
}