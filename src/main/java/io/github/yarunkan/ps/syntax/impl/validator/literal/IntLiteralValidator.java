package io.github.yarunkan.ps.syntax.impl.validator.literal;

import org.springframework.stereotype.Component;

@Component
public class IntLiteralValidator implements SpecificLiteralValidator {

    @Override
    public boolean validate(String... sourceCodeTokens) {

        if (!preValidate(sourceCodeTokens)) {

            return false;
        }

        return sourceCodeTokens[0] != null && sourceCodeTokens[0].matches("-?\\d{1,9}");
    }

    @Override
    public Class<Long> getType() {

        return Long.class;
    }
}