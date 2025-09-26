import java.util.*;

// N명 학생 B 예산
// P가격 S배송비
// 반값 쿠폰 1개
// 선생님이 선물 가능한 최대 학생 수
class Student implements Comparable<Student> {
    int p;
    int s;

    public Student(int p, int s) {
        this.p = p;
        this.s = s;
    }

    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.p + this.s, student.p + student.s);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            students[i] = new Student(x, y);
        }
        // Please write your code here.
        int ans = 0;
        Arrays.sort(students);
        for(int i = 0; i < n; i++) {
            students[i].p /=  2; int cnt = 0; int tmp = 0;
            for(int j = 0; j < n; j++) {
                if(tmp + students[j].p + students[j].s <= b) {
                    cnt++;
                    tmp += (students[j].p + students[j].s);
                }

            }
            ans = Math.max(ans, cnt);
            students[i].p *= 2;
        }

        System.out.println(ans);
    }
}