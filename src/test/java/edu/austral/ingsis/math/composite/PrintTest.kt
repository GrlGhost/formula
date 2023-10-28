package edu.austral.ingsis.math.composite


import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test


class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    fun shouldPrintFunction1() {
        val expected = "1 + 6"
        val function: Function = Add(Number(1.0), Number(6.0))
        assertThat(function.toString(), equalTo(expected))
    }

    /**
     * Case 12 / 2
     */
    @Test
    fun shouldPrintFunction2() {
        val expected = "12 / 2"
        val function: Function = Divide(Number(12.0), Number(2.0))
        assertThat(function.toString(), equalTo(expected))
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    fun shouldPrintFunction3() {
        val expected = "(9 / 2) * 3"
        val function: Function = Multiply(
            Parenthesis(Divide(Number(9.0), Number(2.0))),
            Number(3.0)
        )
        assertThat(function.toString(), equalTo(expected))
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    fun shouldPrintFunction4() {
        val expected = "(27 / 6) ^ 2"
        val function: Function = Power(
            Parenthesis(Divide(Number(27.0), Number(6.0))),
            Number(2.0)
        )
        assertThat(function.toString(), equalTo(expected))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldPrintFunction6() {
        val expected = "|value| - 8"
        val function: Function = Subtract(Module(Variable("value")), Number(8.0))
        assertThat(function.toString(), equalTo(expected))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldPrintFunction7() {
        val expected = "|value| - 8"
        val function: Function = Subtract(Module(Variable("value")), Number(8.0))
        assertThat(function.toString(), equalTo(expected))
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    fun shouldPrintFunction8() {
        val expected = "(5 - i) * 8"
        val function: Function = Multiply(
            Parenthesis(Subtract(Number(5.0), Variable("i"))),
            Number(8.0)
        )
        assertThat(function.toString(), equalTo(expected))
    }
}

