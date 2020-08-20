package io.github.mchuhaievskyi.pomidor.syntax.impl.parser;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.PomidorTokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class PrintCommandTokenParser implements PomidorTokenParser {

    @Autowired
    private PomidorTokenType printCommandType;
    @Autowired
    private PomidorTokenParser keywordTokenParser;

    private final PomidorTokenParser expressionTokenParser;

    @Autowired
    public PrintCommandTokenParser(PomidorTokenParser expressionTokenParser) {

        this.expressionTokenParser = expressionTokenParser;
    }

    @Override
    public PomidorToken parse(String... sourceCodeTokens) {

        final List<PomidorToken> sourceCodeSubTokens = new ArrayList<>();

        sourceCodeSubTokens.add(keywordTokenParser.parse(sourceCodeTokens[0]));

        final int sourceCodeSubTokensCount = sourceCodeTokens.length;
        final int previousSourceCodeSubTokensCount = 1;
        final int sourceCodeExpressionSubTokensCount = sourceCodeSubTokensCount - previousSourceCodeSubTokensCount;
        final String[] sourceCodeExpressionSubTokens = new String[sourceCodeExpressionSubTokensCount];

        System.arraycopy(sourceCodeTokens,
                         previousSourceCodeSubTokensCount,
                         sourceCodeExpressionSubTokens,
                        0,
                         sourceCodeExpressionSubTokensCount);

        final PomidorToken sourceCodeExpressionToken = expressionTokenParser.parse(sourceCodeExpressionSubTokens);
        final List<PomidorToken> sourceCodeExpressionSubTokensList = sourceCodeExpressionToken.getSubTokens();

        sourceCodeSubTokens.addAll(sourceCodeExpressionSubTokensList);

        final String sourceCodeLine = String.join(" ", sourceCodeTokens);

        return new PomidorTokenImpl(printCommandType, sourceCodeLine, sourceCodeSubTokens);
    }
}