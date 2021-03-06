package io.github.yarunkan.ps.syntax.impl.schema.keyword;

import io.github.yarunkan.ps.syntax.token.TokenParser;
import io.github.yarunkan.ps.syntax.token.TokenSchema;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordSchema implements TokenSchema {

    private final TokenParser keywordTokenParser;
    private final TokenValidator keywordValidator;

    @Autowired
    public KeywordSchema(TokenParser keywordParser,
                         TokenValidator keywordValidator) {

        this.keywordTokenParser = keywordParser;
        this.keywordValidator = keywordValidator;
    }

    @Override
    public String getDescription() {

        return "10) <var-declaration> --> var <var-name> = <literal>\n" +
                "14) <label-declaration> --> label <label-name>\n" +
                "16) <goto> --> goto <label-name>\n" +
                "23) <if-else-block> --> if <expression> then <ps-statement>" +
                "| if <expression> then <ps-statement> else <ps-statement>\n" +
                "24) <print> --> print <expression>\n";
    }

    @Override
    public TokenValidator getTokenValidator() {
        return keywordValidator;
    }

    @Override
    public TokenParser getTokenParser() {
        return keywordTokenParser;
    }
}