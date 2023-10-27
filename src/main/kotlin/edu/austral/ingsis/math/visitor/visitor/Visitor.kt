package edu.austral.ingsis.math.visitor.visitor;

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Function
import edu.austral.ingsis.math.visitor.function.Number


interface Visitor <T>{
    fun visit(add: Add): Result<T>
    fun visit(subtract: Subtract): Result<T>
    fun visit(multiply: Multiply): Result<T>
    fun visit(divide: Divide): Result<T>
    fun visit(power: Power): Result<T>
    fun visit(root: Root): Result<T>
    fun visit(module: Module): Result<T>
    fun visit(number: Number): Result<T>
    fun visit(variable: Variable): Result<T>
    fun visit(parenthesis: Parenthesis): Result<T>
    fun process(function: Function): Result<T>
}
