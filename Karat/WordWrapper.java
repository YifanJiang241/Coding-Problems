package Karat;

import java.util.ArrayList;
import java.util.List;
//给一个word list 和最大的长度，要求把这些word用 - 串联起来，但不能超过最大的长度。
public class WordWrapper {

    public static List<String> wordWrap(String[] words, int maxLen) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        int i = 0;
        while (i < words.length) {
            int remain = maxLen;
            int count = 0;

            // 尝试添加尽可能多的单词到当前行
            while (i < words.length) {
                // 判断当前单词是否能加入到这一行中
                // 注意：需要减去一个字符的长度来考虑后续可能添加的连字符
                if (remain - words[i].length() < 0) {
                    break;
                }

                // 更新剩余长度，这里需要加1是为了计入后面可能添加的连字符
                count++;
                remain -= words[i].length() + (count > 1 ? 1 : 0); // 第一个单词前面不加连字符
                i++;
            }

            // 创建当前行的字符串
            StringBuilder sb = new StringBuilder();
            for (int j = i - count; j < i; j++) {
                if (sb.length() > 0) sb.append('-');
                sb.append(words[j]);
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "this", "is", "java"};
        int maxLen = 10;
        List<String> wrapped = wordWrap(words, maxLen);
        for (String line : wrapped) {
            System.out.println(line);
        }
    }
}
