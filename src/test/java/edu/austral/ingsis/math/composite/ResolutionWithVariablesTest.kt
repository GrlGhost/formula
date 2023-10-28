import edu.austral.ingsis.math.composite.*
import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class ResolutionWithVariablesTest {

    @Test
    fun shouldResolveFunction1() {
        val variables = mapOf("x" to Number(3.0))
        val function = Add(Number(1.0), Variable("x"))
        assertThat(function.evaluate(variableValues = variables).getOrNull()!!.value, equalTo(4.0))
    }

    @Test
    fun shouldResolveFunction2() {
        val variables = mapOf("div" to Number(4.0))
        val function = Divide(Number(12.0), Variable("div"))
        assertThat(function.evaluate(variableValues = variables).getOrNull()!!.value, equalTo(3.0))
    }

    @Test
    fun shouldResolveFunction3() {
        val variables = mapOf("x" to Number(3.0), "y" to Number(4.0))
        val function = Multiply(Divide(Number(9.0), Variable("x")), Variable("y"))
        assertThat(function.evaluate(variableValues = variables).getOrNull()!!.value, equalTo(12.0))
    }

    @Test
    fun shouldResolveFunction4() {
        val variables = mapOf("a" to Number(9.0), "b" to Number(3.0))
        val function = Power(Divide(Number(27.0), Variable("a")), Variable("b"))
        assertThat(function.evaluate(variableValues = variables).getOrNull()!!.value, equalTo(27.0))
    }

    @Test
    fun shouldResolveFunction5() {
        val variables = mapOf("z" to Number(36.0))
        val function = Power(
            Variable("z"),
            Parenthesis(Divide(Number(1.0), Number(2.0)))
        )
        assertThat(function.evaluate(variableValues = variables).getOrNull()!!.value, equalTo(6.0))
    }

    @Test
    fun shouldResolveFunction6() {
        val variables = mapOf("value" to Number(8.0))
        val function = Subtract(Module(Variable("value")), Number(8.0))
        assertThat(function.evaluate(variableValues = variables).getOrNull()!!.value, equalTo(0.0))
    }

    @Test
    fun shouldResolveFunction7() {
        val variables = mapOf("value" to Number(8.0))
        val function = Subtract(Module(Variable("value")), Number(8.0))
        assertThat(function.evaluate(variableValues = variables).getOrNull()!!.value, equalTo(0.0))
    }

    @Test
    fun shouldResolveFunction8() {
        val variables = mapOf("i" to Number(2.0))
        val function = Multiply(
            Parenthesis(Subtract(Number(5.0), Variable("i"))),
            Number(8.0)
        )
        assertThat(function.evaluate(variableValues = variables).getOrNull()!!.value, equalTo(24.0))
    }
}

