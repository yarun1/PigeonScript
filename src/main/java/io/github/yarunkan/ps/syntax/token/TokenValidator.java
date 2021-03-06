package io.github.yarunkan.ps.syntax.token;

public interface TokenValidator {

    boolean validate(String... sourceCodeTokens);

    default boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length == getExpectedTokensCount();
    }

    default int getExpectedTokensCount() {
        return 1;
    }
}