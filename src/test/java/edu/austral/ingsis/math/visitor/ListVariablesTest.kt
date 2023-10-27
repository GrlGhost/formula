package edu.austral.ingsis.math.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Function
import edu.austral.ingsis.math.visitor.visitor.VariableListerVisitor
import edu.austral.ingsis.math.visitor.visitor.Visitor
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.empty

class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    fun shouldListVariablesFunction1() {
        val visitor: Visitor<List<String>> = VariableListerVisitor()
        val expression: Function = Add(IntNumber(1), IntNumber(2))

        val result = visitor.process(expression).getOrNull()

        assertThat(result, empty())
    }

    /**
     * Case 12 / div
     */
    @Test
    fun shouldListVariablesFunction2() {
        val visitor: Visitor<List<String>> = VariableListerVisitor()
        val expression: Function = Divide(IntNumber(12), Variable("div"))

        val result = visitor.process(expression).getOrNull()

        assertThat(result, containsInAnyOrder("div"))
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    fun shouldListVariablesFunction3() {
        val visitor: Visitor<List<String>> = VariableListerVisitor()
        val expression: Function = Multiply(
            Parenthesis(Divide(IntNumber(9), Variable("x"))),
            Variable("y")
        )

        val result = visitor.process(expression).getOrNull()

        assertThat(result, containsInAnyOrder("x", "y"))
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    fun shouldListVariablesFunction4() {
        val visitor: Visitor<List<String>> = VariableListerVisitor()
        val expression: Function = Power(
            Parenthesis(Divide(IntNumber(27), Variable("a"))),
            Variable("b")
        )

        val result = visitor.process(expression).getOrNull()

        assertThat(result, containsInAnyOrder("a", "b"))
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    fun shouldListVariablesFunction5() {
        val visitor: Visitor<List<String>> = VariableListerVisitor()
        val expression: Function = Power(
            Variable("z"),
            Parenthesis(Divide(IntNumber(1), IntNumber(2)))
        )

        val result = visitor.process(expression).getOrNull()

        assertThat(result, containsInAnyOrder("z"))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldListVariablesFunction6() {
        val visitor: Visitor<List<String>> = VariableListerVisitor()
        val expression: Function = Subtract(Module(Variable("value")), IntNumber(8))

        val result = visitor.process(expression).getOrNull()

        assertThat(result, containsInAnyOrder("value"))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldListVariablesFunction7() {
        val visitor: Visitor<List<String>> = VariableListerVisitor()
        val expression: Function = Subtract(Module(Variable("value")), IntNumber(8))

        val result = visitor.process(expression).getOrNull()

        assertThat(result, containsInAnyOrder("value"))
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    fun shouldListVariablesFunction8() {
        val visitor: Visitor<List<String>> = VariableListerVisitor()
        val expression: Function = Multiply(
            Parenthesis(Divide(IntNumber(5), Variable("i"))),
            IntNumber(8)
        )

        val result = visitor.process(expression).getOrNull()

        assertThat(result, containsInAnyOrder("i"))
    }
}

