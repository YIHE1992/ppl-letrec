package yi.letlangproj;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static yi.letlangproj.TokenType.WHITE_SPACE;

public class Scanner {
    public List<Token> scanToTokenList(String input) {
        LinkedList<Token> tokenList = new LinkedList<>();
        TokenType[] tokenTypes = TokenType.values();
        LinkedHashMap<TokenType, Pattern> patternMap = new LinkedHashMap<>();
        for(int i = 0; i < tokenTypes.length; i++) {
            patternMap.put(tokenTypes[i], Pattern.compile("^(" + tokenTypes[i].getPattern() + ")"));
        }
        int start = 0;
        outer:
        while(start < input.length()) {
            for(Entry<TokenType, Pattern> entry : patternMap.entrySet()) {
                Matcher matcher = entry.getValue().matcher(input.substring(start));
                if(matcher.find()) {
                    String matchedString = matcher.group();
                    start += matchedString.length();
                    TokenType tokenType = entry.getKey();
                    if(tokenType != WHITE_SPACE) {
                        tokenList.add(new Token(tokenType, matchedString));
                    }
                    continue outer;
                }
            }
            throw new RuntimeException("cannot match: " + input.substring(start));
        }
        return tokenList;
    }
}
