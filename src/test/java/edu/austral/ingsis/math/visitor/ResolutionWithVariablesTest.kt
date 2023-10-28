package edu.austral.ingsis.math.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Number
import edu.austral.ingsis.math.visitor.visitor.EvaluateWithVariables
import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    fun shouldResolveFunction1() {
        val variables = mapOf("x" to IntNumber(3))
        val visitor = EvaluateWithVariables(variables)
        val function = Add(IntNumber(1), Variable("x"))

        val resultR = visitor.process(function)

        when (val result: Number = resultR.getOrNull()!!) {
            is ByteNumber -> assertThat(result.value, equalTo(4))
            is IntNumber -> assertThat(result.value, equalTo(4))
            is LongNumber -> assertThat(result.value, equalTo(4))
            is DoubleNumber -> assertThat(result.value, equalTo(4.0))
        }
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    fun shouldResolveFunction2() {
        val variables = mapOf("div" to IntNumber(4))
        val visitor = EvaluateWithVariables(variables)
        val function = Divide(IntNumber(12), Variable("div"))

        val resultR = visitor.process(function)

        when (val result: Number = resultR.getOrNull()!!) {
            is ByteNumber -> assertThat(result.value, equalTo(3.0))
            is IntNumber -> assertThat(result.value, equalTo(3.0))
            is LongNumber -> assertThat(result.value, equalTo(3.0))
            is DoubleNumber -> assertThat(result.value, equalTo(3.0))
        }
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    fun shouldResolveFunction3() {
        val variables = mapOf("x" to IntNumber(3), "y" to IntNumber(4))
        val visitor = EvaluateWithVariables(variables)
        val function = Multiply(
            Divide(IntNumber(9), Variable("x")),
            Variable("y")
        )

        val resultR = visitor.process(function)

        when (val result: Number = resultR.getOrNull()!!) {
            is ByteNumber -> assertThat(result.value, equalTo(12.0))
            is IntNumber -> assertThat(result.value, equalTo(12.0))
            is LongNumber -> assertThat(result.value, equalTo(12.0))
            is DoubleNumber -> assertThat(result.value, equalTo(12.0))
        }
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    fun shouldResolveFunction4() {
        val variables = mapOf("a" to IntNumber(9), "b" to IntNumber(3))
        val visitor = EvaluateWithVariables(variables)
        val function = Power(
            Divide(IntNumber(27), Variable("a")),
            Variable("b")
        )

        val resultR = visitor.process(function)

        val expectedResult = 27.0
        when (val result: Number = resultR.getOrNull()!!) {
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    fun shouldResolveFunction5() {
        val variables = mapOf("z" to IntNumber(36))
        val visitor = EvaluateWithVariables(variables)
        val function = Power(Variable("z"), Parenthesis(Divide(IntNumber(1), IntNumber(2))))

        val resultR = visitor.process(function)

        val expectedResult = 6.0
        when (val result: Number = resultR.getOrNull()!!) {
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    fun shouldResolveFunction6() {
        val variables = mapOf("value" to IntNumber(8))
        val visitor = EvaluateWithVariables(variables)
        val function = Subtract(Module(Variable("value")), IntNumber(8))

        val resultR = visitor.process(function)

        val expectedResult = 0
        when (val result: Number = resultR.getOrNull()!!) {
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    fun shouldResolveFunction7() {
        val variables = mapOf("value" to IntNumber(8))
        val visitor = EvaluateWithVariables(variables)
        val function = Subtract(Module(Variable("value")), IntNumber(8))

        val resultR = visitor.process(function)

        val expectedResult = 0
        when (val result: Number = resultR.getOrNull()!!) {
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    fun shouldResolveFunction8() {
        val variables = mapOf("i" to IntNumber(2))
        val visitor = EvaluateWithVariables(variables)
        val function = Multiply(
            Parenthesis(Subtract(IntNumber(5), Variable("i"))),
            IntNumber(8)
        )

        val resultR = visitor.process(function)

        val expectedResult = 24
        when (val result: Number = resultR.getOrNull()!!) {
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }
}
