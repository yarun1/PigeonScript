package io.github.mchuhaievskyi.pomidor.syntax.impl.validator.keyword;

import org.springframework.stereotype.Component;

@Component
public class GotoKeywordValidator implements SpecificKeywordValidator {

    @Override
    public String getKeywordConstant() {
        return "goto";
    }
}