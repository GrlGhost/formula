package edu.austral.ingsis.math.visitor.function

import edu.austral.ingsis.math.visitor.visitor.Visitor

class Add(val rightFunction: Function, val leftFunction: Function): Function{
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

class Subtract(val rightFunction: Function, val leftFunction: Function): Function {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

class Multiply(val rightFunction: Function, val leftFunction: Function): Function {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

class Divide(val rightFunction: Function, val leftFunction: Function): Function {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

class Power(val base: Function, val p: Function): Function {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

class Root(val base: Function, val p: Function): Function {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)
}

class Module(val function: Function): Function {
    override fun <T> accepts(visitor: Visitor<T>): Result<T> = visitor.visit(this)

}