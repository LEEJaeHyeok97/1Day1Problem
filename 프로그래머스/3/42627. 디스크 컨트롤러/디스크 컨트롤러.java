
// 대기큐는 작업 번호, 작업의 요청 시각, 작업의 소요 시간을 저장
// 우선순위는 작업의 소요 시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순서로
// 우선순위가 높다.
import java.util.*;

class Task implements Comparable<Task> {
    int idx;
    int time;
    int startTime;
    
    public Task(int idx, int time, int startTime) {
        this.idx = idx;
        this.time = time;
        this.startTime = startTime;
    }
    
    @Override
    public int compareTo(Task o) {
        if(time != o.time) {
            return Integer.compare(time, o.time);
        }
        if(startTime != o.startTime) {
            return Integer.compare(startTime, o.startTime);
        }
        
        return Integer.compare(idx, o.idx);
    }
}
class Solution {
    
    static PriorityQueue<Task> pq = new PriorityQueue<>();
    
    static int answer = 0;
    public int solution(int[][] jobs) {
        int done = 0;
        int n = jobs.length;
        int time = 0;
        int i = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        while(done < n) {
            while(i < n && jobs[i][0] <= time) {
                pq.add(new Task(i, jobs[i][1], jobs[i][0]));
                i++;
            }
            if(pq.isEmpty()) {
                time = jobs[i][0];
            }
            else {
                Task t = pq.poll();
                time += t.time;
                answer += time - t.startTime;
                done++;
            }
        }
        
        return answer / jobs.length;
    }
}