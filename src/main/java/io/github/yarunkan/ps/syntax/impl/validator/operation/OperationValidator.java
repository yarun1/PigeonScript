package io.github.yarunkan.ps.syntax.impl.validator.operation;

import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class OperationValidator implements TokenValidator {

    private final Set<SpecificOperationValidator> specificOperationValidators;

    @Autowired
    public OperationValidator(Set<SpecificOperationValidator> specificOperationValidators) {

        this.specificOperationValidators = specificOperationValidators;
    }

    @Override
    public boolean validate(String... sourceCodeTokens) {

        return specificOperationValidators.stream().anyMatch(v -> v.validate(sourceCodeTokens));
    }

    @Override
    public boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length % 2 != 0;
    }

    @Override
    public int getExpectedTokensCount() {

        return 3;
    }
}