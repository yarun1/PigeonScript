package io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorTokenParser extends SingleWordTokenParser {

    @Autowired
    @Override
    public void setTokenType(PomidorTokenType operatorType) {

        super.setTokenType(operatorType);
    }
}