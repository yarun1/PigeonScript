package io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperandParser extends SingleWordTokenParser {

    @Autowired
    @Override
    public void setTokenType(TokenType operandType) {

        super.setTokenType(operandType);
    }
}