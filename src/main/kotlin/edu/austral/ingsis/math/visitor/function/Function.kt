package edu.austral.ingsis.math.visitor.function;

import edu.austral.ingsis.math.visitor.visitor.Visitor


interface Function{
    fun <T> accepts(visitor: Visitor<T>): Result<T>
}

