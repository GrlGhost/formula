package edu.austral.ingsis.math.visitor.function

import edu.austral.ingsis.math.visitor.visitor.Visitor

class Parenthesis(val function: Function): Function {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}