package io.github.yarunkan.ps.syntax.impl.interpreter.expression;

import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class ExpressionInterpreter extends AbstractTokenInterpreter {

    private final Set<SpecificExpressionInterpreter<?>> specificExpressionTokenInterpreters;

    @Autowired
    public ExpressionInterpreter(Set<SpecificExpressionInterpreter<?>> specificExpressionTokenInterpreters) {

        this.specificExpressionTokenInterpreters = specificExpressionTokenInterpreters;
    }

    @Override
    public boolean interpret(Token token) {

        return specificExpressionTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}