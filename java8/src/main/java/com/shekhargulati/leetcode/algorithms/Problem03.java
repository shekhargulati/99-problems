package com.shekhargulati.leetcode.algorithms;
import java.util.HashMap;
import java.util.Map;

/**
 * Longest substring without repeating characters
 */
public class Problem03 {

   public static String substring(final String input) {
		Map<Integer, Integer> resultCache = new HashMap<Integer, Integer>();
		int start = 0;
		int curIndex = -1;
		StringBuilder subStr = new StringBuilder();
		String[] chars = input.split("");
		for (String ch : chars) {
			curIndex++;
			int indexCh = subStr.indexOf(ch);
			if (indexCh == -1) {
				subStr.append(ch);
			}
			else {
				int l = subStr.length();
				subStr = new StringBuilder(subStr.substring(indexCh + 1));
				subStr.append(ch);
				start += indexCh + 1;
			}
			resultCache.put(start, curIndex);
		}
		return processResult(resultCache, chars);
	}

	public static String processResult(Map<Integer, Integer> result, String[] chars) {
		int maxLength = 0;
		int resultStart = 0;
		int resultEnd = 0;
		for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
			int start = entry.getKey().intValue();
			int end = entry.getValue().intValue();
			int length = end - start + 1;
			if (length > maxLength) {
				maxLength = length;
				resultStart = start;
				resultEnd = end;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = resultStart; i <= resultEnd; i++) {

			sb.append(chars[i]);
		}
		return sb.toString();
	}
}
