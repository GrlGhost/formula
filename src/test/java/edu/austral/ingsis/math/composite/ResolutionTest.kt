package edu.austral.ingsis.math.composite


import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    fun shouldResolveSimpleFunction1() {
        val function = Add(Number(1.0), Number(6.0))
        assertThat(function.evaluate().getOrNull()!!.value, equalTo(7.0))
    }

    /**
     * Case 12 / 2
     */
    @Test
    fun shouldResolveSimpleFunction2() {
        val function = Divide(Number(12.0), Number(2.0))
        assertThat(function.evaluate().getOrNull()!!.value, equalTo(6.0))
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    fun shouldResolveSimpleFunction3() {
        val function = Multiply(
            Parenthesis(Divide(Number(9.0), Number(2.0))),
            Number(3.0)
        )
        assertThat(function.evaluate().getOrNull()!!.value, equalTo(13.5))
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    fun shouldResolveSimpleFunction4() {
        val function = Power(
            Parenthesis(Divide(Number(27.0), Number(6.0))),
            Number(2.0)
        )
        assertThat(function.evaluate().getOrNull()!!.value, equalTo(20.25))
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    fun shouldResolveSimpleFunction5() {
        val function = Power(Number(36.0),
            Parenthesis(Divide(Number(1.0), Number(2.0)))
        )
        assertThat(function.evaluate().getOrNull()!!.value, equalTo(6.0))
    }

    /**
     * Case |136|
     */
    @Test
    fun shouldResolveSimpleFunction6() {
        val function = Module(Number(136.0))
        assertThat(function.evaluate().getOrNull()!!.value, equalTo(136.0))
    }

    /**
     * Case |-136|
     */
    @Test
    fun shouldResolveSimpleFunction7() {
        val function = Module(Number(-136.0))
        assertThat(function.evaluate().getOrNull()!!.value, equalTo(136.0))
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    fun shouldResolveSimpleFunction8() {
        val function = Multiply(
            Parenthesis(Subtract(Number(5.0), Number(5.0))),
            Number(8.0)
        )
        assertThat(function.evaluate().getOrNull()!!.value, equalTo(0.0))
    }
}

