import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int len = friends.length;
        int[][] record = new int[len][len];
        
        // 이름에 따른 인덱스를 먼저 구한다?
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<len; i++) {
            map.put(friends[i], i);
        }
        
        for (int i=0; i<gifts.length; i++) {
            String[] arr = gifts[i].split(" ");
            record[map.get(arr[0])][map.get(arr[1])]++;
        }
        
        // 선물 지수를 계산
        int[] giftScore = new int[len];
        
        for (int i = 0; i<len; i++) {
            // i는 giftScore의 각 원소
        for (int j=0; j<len; j++) {
            giftScore[i] += (record[i][j] - record[j][i]);
            }
        }
        
        // 1번 - 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
        // 2번 - 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
        // 3번 - 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
        // 선물을 가장 많이 받을 친구가 받을 선물의 수
        
        int[] result = new int[len];
        for (int i=0; i<len; i++) {
            for (int j=i; j<len; j++) {
                if (i==j) continue;
                
                if (record[i][j] > 0) { // 선물을 주고 받은 기록이 있음.
                    if (record[i][j] > record[j][i]) {
                        result[i]++;
                    } else if (record[i][j] < record[j][i]) {
                        result[j]++;
                    } else { // 주고 받은 수가 같아요
                        if (giftScore[i] > giftScore[j]) {
                            result[i]++;
                        } else if (giftScore[i] < giftScore[j]) {
                            result[j]++;
                        }
                    }
                } else { // 주고 받은 기록이 없어요.
                        if (giftScore[i] > giftScore[j]) {
                            result[i]++;
                        } else if (giftScore[i] < giftScore[j]) {
                            result[j]++;
                        }
                }
            }
        }
        
        
        // System.out.println(Arrays.toString(giftScore));
        Arrays.sort(result);
        
        
        
        return result[len-1];
        
        
    }
}