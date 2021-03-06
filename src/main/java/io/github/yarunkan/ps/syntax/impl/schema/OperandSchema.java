package io.github.yarunkan.ps.syntax.impl.schema;

import io.github.yarunkan.ps.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperandSchema implements TokenSchema {

    private final TokenValidator operandValidator;
    private final TokenParser operandParser;

    @Autowired
    public OperandSchema(TokenValidator operandValidator, TokenParser operandParser) {

        this.operandValidator = operandValidator;
        this.operandParser = operandParser;
    }

    @Override
    public String getDescription() {
        return "18) <expression-operand> --> <literal> | <var-name>\n";
    }

    @Override
    public TokenValidator getTokenValidator() {
        return operandValidator;
    }

    @Override
    public TokenParser getTokenParser() {
        return operandParser;
    }
}