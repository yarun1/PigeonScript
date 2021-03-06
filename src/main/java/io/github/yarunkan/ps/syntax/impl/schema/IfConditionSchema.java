package io.github.yarunkan.ps.syntax.impl.schema;

import io.github.yarunkan.ps.syntax.token.TokenParser;
import io.github.yarunkan.ps.syntax.token.TokenSchema;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IfConditionSchema implements TokenSchema {

    private final TokenValidator ifConditionValidator;
    private final TokenParser ifConditionParser;

    @Autowired
    public IfConditionSchema(TokenValidator ifConditionValidator,
                             TokenParser ifConditionParser) {

        this.ifConditionValidator = ifConditionValidator;
        this.ifConditionParser = ifConditionParser;
    }

    @Override
    public String getDescription() {

        return "if <expression> then\n";
    }

    @Override
    public TokenValidator getTokenValidator() {

        return ifConditionValidator;
    }

    @Override
    public TokenParser getTokenParser() {

        return ifConditionParser;
    }
}