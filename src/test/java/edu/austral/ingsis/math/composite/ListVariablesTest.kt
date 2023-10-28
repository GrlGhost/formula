package edu.austral.ingsis.math.composite

import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.empty
import org.junit.Assert.assertThat
import org.junit.Test


class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    fun shouldListVariablesFunction1() {
        val expression: Function = Add(Number(1.0), Number(2.0))
        assertThat(expression.listVariables(), empty())
    }

    /**
     * Case 12 / div
     */
    @Test
    fun shouldListVariablesFunction2() {
        val expression: Function = Divide(Number(12.0), Variable("div"))
        assertThat(expression.listVariables(), containsInAnyOrder("div"))
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    fun shouldListVariablesFunction3() {
        val expression: Function = Multiply(
            Parenthesis(Divide(Number(9.0), Variable("x"))),
            Variable("y")
        )
        assertThat(expression.listVariables(), containsInAnyOrder("x", "y"))
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    fun shouldListVariablesFunction4() {
        val expression: Function = Power(
            Parenthesis(Divide(Number(27.0), Variable("a"))),
            Variable("b")
        )

        assertThat(expression.listVariables(), containsInAnyOrder("a", "b"))
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    fun shouldListVariablesFunction5() {
        val expression: Function = Power(
            Variable("z"),
            Parenthesis(Divide(Number(1.0), Number(2.0)))
        )
        assertThat(expression.listVariables(), containsInAnyOrder("z"))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldListVariablesFunction6() {
        val expression: Function = Subtract(Module(Variable("value")), Number(8.0))
        assertThat(expression.listVariables(), containsInAnyOrder("value"))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldListVariablesFunction7() {
        val expression: Function = Subtract(Module(Variable("value")), Number(8.0))
        assertThat(expression.listVariables(), containsInAnyOrder("value"))
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    fun shouldListVariablesFunction8() {
        val expression: Function = Multiply(
            Parenthesis(Divide(Number(5.0), Variable("i"))),
            Number(8.0)
        )
        assertThat(expression.listVariables(), containsInAnyOrder("i"))
    }
}

