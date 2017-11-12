package yi.letlangproj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static yi.letlangproj.TokenType.WHITE_SPACE;

public class Scanner {
    public static void main(String[] args) {
        new Scanner().scanToTokenList("letrec double (x) = if iszero(x) then 0 else +((double -(x, 1)), 2) in (double 6)\n").forEach(System.out::println);
    }

    public List<Token> scanToTokenList(String input) {
        LinkedList<Token> tokenList = new LinkedList<>();
        Map<TokenType, Pattern> patternMap = Arrays.stream(TokenType.values())
                                                   .collect(Collectors.toMap(tokenType -> tokenType,
                                                                             tokenType -> Pattern.compile("^(" + tokenType.getPattern() + ")")));
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
