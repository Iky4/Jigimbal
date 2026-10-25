package com.farzad.iguessimbuildingalanguage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.farzad.iguessimbuildingalanguage.TokenType.*;

class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    Scanner(String source) {
        this.source = source;
    }

    List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }

        tokens.add(new Token(TokenType.EOF, "" , null, line));
        return tokens;
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }
}
