import java.util.*;

// 10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기 
// 사용자의 입력이 모두 끝난 후 동영상의 위치를 mm:ss 로 반환
class Solution {
    static String answer;
    static String video_len;
    static String pos;
    static String op_start;
    static String op_end;
    static int video_len_min;
    static int video_len_sec;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        this.video_len = video_len;
        this.pos = pos;
        this.op_start = op_start;
        this.op_end = op_end;
        String[] parsedVideoLen = video_len.split(":");
        video_len_min = Integer.parseInt(parsedVideoLen[0]);
        video_len_sec = Integer.parseInt(parsedVideoLen[1]);
        // answer = "";
        for(String command : commands) {
            if(command.equals("prev")) {
                pos = prev();
            } else if(command.equals("next")) {
                pos = next();
            }
            System.out.println(pos);
        }
        return pos;
    }
    
    static String prev() {
        opening_pass();
        String[] str = pos.split(":");
        Integer minute = Integer.parseInt(str[0]);
        Integer second = Integer.parseInt(str[1]);
        
        // 현재 위치가 10초 이상이면 10초 빼기
        if(minute > 0) {
            // 초가 10초 이상일 때
            if(second >= 10) {
                second -= 10;
            } else {// 초가 10초 미만일 때
                minute -= 1;
                second += 60;
                second -= 10;
            }
        } else if(minute == 0 && second >= 10) {
            second -= 10;
        } else if(minute == 0 && second < 10) {
            second = 0;
        }
        // 10초 미만이면 0초로 이동
        
        if(second < 10) {
            if(minute < 10) {
                pos = "0" + minute + ":0" + second;
            } else {
                pos = minute + ":0" + second;
            }
        } else {
            if(minute < 10) {
                pos = "0" + minute + ":" + second;
            } else {
                pos = minute + ":" + second;
            }
        }
        
        opening_pass();
        return pos;
    }
    
    static String next() {
        opening_pass();
        // 분, 초 나눠서 숫자로 변수 갖고 있기
        String[] str = pos.split(":");
        Integer minute = Integer.parseInt(str[0]);
        Integer second = Integer.parseInt(str[1]);
        
        // 현재 위치가 동영상 남은 시간 10초 미만일 경우 마지막 위치로 이동
        // 10초 더하기
        
        int cur = minute * 60 + second + 10;
        int len = video_len_min * 60 + video_len_sec;
        cur = Math.min(cur, len);
        minute = cur / 60;
        second = cur % 60;
        
        if(second < 10) {
            if(minute < 10) {
                pos = "0" + minute + ":0" + second;
            } else {
                pos = minute + ":0" + second;   
            }
        } else {
            if(minute < 10) {
                pos = "0" + minute + ":" + second;
            }
             else {
                pos = minute + ":" + second;
                }
            }   
        
        opening_pass();
        return pos;
    }
    
    static boolean opening_pass() {
        // 현재 위치가 오프닝 범위면 오프닝 끝나는 위치로 이동
        String[] str = pos.split(":");
        Integer curMinute = Integer.parseInt(str[0]);
        Integer curSecond = Integer.parseInt(str[1]);
        
        str = op_start.split(":");
        Integer opStartMinute = Integer.parseInt(str[0]);
        Integer opStartSecond = Integer.parseInt(str[1]);
        
        str = op_end.split(":");
        Integer opEndMinute = Integer.parseInt(str[0]);
        Integer opEndSecond = Integer.parseInt(str[1]);
        
        // if((opStartMinute <= curMinute) && (opStartSecond <= curSecond) && ((curMinute <=opEndMinute) && (curSecond <= opEndSecond))) {
        //     pos = op_end;
        //     return true;
        // }
        
        // 초로 환산
        int curTotal = (curMinute * 60) + curSecond;
        int opsTotal = (opStartMinute * 60) + opStartSecond;
        int opeTotal = (opEndMinute * 60) + opEndSecond;
        if(opsTotal <= curTotal && curTotal < opeTotal) {
            pos = op_end;
            return true;
        }
        
        return false;
    }
}