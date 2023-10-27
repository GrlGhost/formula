package edu.austral.ingsis.math.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Function
import edu.austral.ingsis.math.visitor.function.Module
import edu.austral.ingsis.math.visitor.visitor.PrinterVisitor
import edu.austral.ingsis.math.visitor.visitor.Visitor
import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    fun shouldPrintFunction1() {
        val expected = "1 + 6"
        val visitor: Visitor<String> = PrinterVisitor()
        val function: Function = Add(IntNumber(1), IntNumber(6))

        val result: String = visitor.process(function).getOrNull()!!

        assertThat(result, equalTo(expected))
    }

    /**
     * Case 12 / 2
     */
    @Test
    fun shouldPrintFunction2() {
        val expected = "12 / 2"
        val visitor: Visitor<String> = PrinterVisitor()
        val function: Function = Divide(IntNumber(12), IntNumber(2))

        val result: String = visitor.process(function).getOrNull()!!

        assertThat(result, equalTo(expected))
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    fun shouldPrintFunction3() {
        val expected = "(9 / 2) * 3"
        val visitor: Visitor<String> = PrinterVisitor()
        val function: Function = Multiply(
            Parenthesis(Divide(IntNumber(9), IntNumber(2))),
            IntNumber(3)
        )

        val result: String = visitor.process(function).getOrNull()!!

        assertThat(result, equalTo(expected))
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    fun shouldPrintFunction4() {
        val expected = "(27 / 6) ^ 2"
        val visitor: Visitor<String> = PrinterVisitor()
        val function: Function = Power(
            Parenthesis(Divide(IntNumber(27), IntNumber(6))),
            IntNumber(2)
        )

        val result: String = visitor.process(function).getOrNull()!!

        assertThat(result, equalTo(expected))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldPrintFunction6() {
        val expected = "|value| - 8"
        val visitor: Visitor<String> = PrinterVisitor()
        val function: Function = Subtract(Module(Variable("value")), IntNumber(8))

        val result: String = visitor.process(function).getOrNull()!!

        assertThat(result, equalTo(expected))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldPrintFunction7() {
        val expected = "|value| - 8"
        val visitor: Visitor<String> = PrinterVisitor()
        val function: Function = Subtract(Module(Variable("value")), IntNumber(8))

        val result: String = visitor.process(function).getOrNull()!!

        assertThat(result, equalTo(expected))
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    fun shouldPrintFunction8() {
        val expected = "(5 - i) * 8"
        val visitor: Visitor<String> = PrinterVisitor()
        val function: Function = Multiply(
            Parenthesis(Subtract(IntNumber(5), Variable("i"))),
            IntNumber(8)
        )

        val result: String = visitor.process(function).getOrNull()!!

        assertThat(result, equalTo(expected))
    }
}

