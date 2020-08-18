package io.github.mchuhaievskyi.pomidor.syntax.token;

public interface PomidorTokenValidator {

    boolean validate(String... sourceCodeTokens);

    default boolean preValidate(String... sourceCodeTokens) {

        return sourceCodeTokens != null && sourceCodeTokens.length == getExpectedTokensCount();
    }

    default int getExpectedTokensCount() {
        return 1;
    }
}