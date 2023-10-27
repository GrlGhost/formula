package edu.austral.ingsis.math.visitor.visitor

import edu.austral.ingsis.math.visitor.function.*
import edu.austral.ingsis.math.visitor.function.Function
import edu.austral.ingsis.math.visitor.function.Module
import edu.austral.ingsis.math.visitor.function.Number

class VariableListerVisitor: Visitor<List<String>> {
    override fun visit(add: Add): Result<List<String>> =
        combineLists(add.rightFunction, add.leftFunction)

    override fun visit(subtract: Subtract): Result<List<String>> =
        combineLists(subtract.rightFunction, subtract.leftFunction)

    override fun visit(multiply: Multiply): Result<List<String>> =
        combineLists(multiply.rightFunction, multiply.leftFunction)

    override fun visit(divide: Divide): Result<List<String>> =
        combineLists(divide.rightFunction, divide.leftFunction)

    override fun visit(power: Power): Result<List<String>> =
        combineLists(power.base, power.p)

    override fun visit(root: Root): Result<List<String>> =
        combineLists(root.base, root.p)

    override fun visit(module: Module): Result<List<String>> =
        module.function.accepts(this)

    override fun visit(number: Number): Result<List<String>> =
        Result.success(listOf())

    override fun visit(variable: Variable): Result<List<String>> =
        Result.success(listOf(variable.name))

    override fun visit(parenthesis: Parenthesis): Result<List<String>> =
        parenthesis.function.accepts(this)

    override fun process(function: Function): Result<List<String>> =
        function.accepts(this)

    fun combineLists(function1: Function, function2: Function): Result<List<String>> =
        Result.success(
            function1.accepts(this).getOrNull()!! + function2.accepts(this).getOrNull()!!
        )
}