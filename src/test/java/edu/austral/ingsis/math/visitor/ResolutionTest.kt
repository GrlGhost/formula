package edu.austral.ingsis.math.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Number
import edu.austral.ingsis.math.visitor.visitor.EvaluateVisitor
import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    fun shouldResolveSimpleFunction1() {
        val visitor = EvaluateVisitor()
        val function = Add(IntNumber(1), IntNumber(6))

        val resultR = visitor.process(function)

        when (val result: Number = resultR.getOrNull()!!){
            is ByteNumber -> assertThat(result.value, equalTo(7))
            is IntNumber -> assertThat(result.value, equalTo(7))
            is LongNumber -> assertThat(result.value, equalTo(7.0))
            is DoubleNumber -> assertThat(result.value, equalTo(7.0))
        }
    }

    /**
     * Case 12 / 2
     */
    @Test
    fun shouldResolveSimpleFunction2() {
        val visitor = EvaluateVisitor()
        val function = Divide(IntNumber(12), IntNumber(2))

        val resultR = visitor.process(function)

        when (val result: Number = resultR.getOrNull()!!){
            is ByteNumber -> assertThat(result.value, equalTo(6.0))
            is IntNumber -> assertThat(result.value, equalTo(6.0))
            is LongNumber -> assertThat(result.value, equalTo(6.0))
            is DoubleNumber -> assertThat(result.value, equalTo(6.0))
        }    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    fun shouldResolveSimpleFunction3() {
        val visitor = EvaluateVisitor()
        val function = Multiply(
            Parenthesis(Divide(IntNumber(9), IntNumber(2))),
            IntNumber(3)
        )

        val resultR = visitor.process(function)

        when (val result: Number = resultR.getOrNull()!!){
            is ByteNumber -> assertThat(result.value, equalTo(13.5))
            is IntNumber -> assertThat(result.value, equalTo(13.5))
            is LongNumber -> assertThat(result.value, equalTo(13.5))
            is DoubleNumber -> assertThat(result.value, equalTo(13.5))
        }    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    fun shouldResolveSimpleFunction4() {
        val visitor = EvaluateVisitor()
        val function = Power(
            Parenthesis(Divide(IntNumber(27), IntNumber(6))),
            IntNumber(2)
        )

        val resultR = visitor.process(function)

        val expectedResult = 20.25
        when (val result: Number = resultR.getOrNull()!!){
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    fun shouldResolveSimpleFunction5() {
        val visitor = EvaluateVisitor()
        val function = Power(IntNumber(36),
            Parenthesis(Divide(IntNumber(1), IntNumber(2)))
        )

        val resultR = visitor.process(function)

        val expectedResult = 6.0
        when (val result: Number = resultR.getOrNull()!!){
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }

    /**
     * Case |136|
     */
    @Test
    fun shouldResolveSimpleFunction6() {
        val visitor = EvaluateVisitor()
        val function = Module(IntNumber(136))

        val resultR = visitor.process(function)

        val expectedResult = 136
        when (val result: Number = resultR.getOrNull()!!){
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }

    /**
     * Case |-136|
     */
    @Test
    fun shouldResolveSimpleFunction7() {
        val visitor = EvaluateVisitor()
        val function = Module(IntNumber(-136))

        val resultR = visitor.process(function)

        val expectedResult = 136
        when (val result: Number = resultR.getOrNull()!!){
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    fun shouldResolveSimpleFunction8() {
        val visitor = EvaluateVisitor()
        val function = Multiply(
            Parenthesis(Subtract(IntNumber(5), IntNumber(5))),
            IntNumber(8)
        )

        val resultR = visitor.process(function)

        val expectedResult = 0
        when (val result: Number = resultR.getOrNull()!!){
            is ByteNumber -> assertThat(result.value, equalTo(expectedResult))
            is IntNumber -> assertThat(result.value, equalTo(expectedResult))
            is LongNumber -> assertThat(result.value, equalTo(expectedResult))
            is DoubleNumber -> assertThat(result.value, equalTo(expectedResult))
        }
    }
}
