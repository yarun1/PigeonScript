package io.github.mchuhaievskyi.pomidor.syntax.impl.type;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperandType implements PomidorTokenType {

    @Autowired
    private PomidorTokenSchema operandSchema;

    @Override
    public String getName() {
        return "Print command argument token";
    }

    @Override
    public PomidorTokenSchema getSchema() {
        return operandSchema;
    }
}