package Greedyalgorithum;

//max to max meetings find
//ill take the meetin which are small means je lvke end hotil
//stsrt ,end ,position store krnar kahi sangta yet nahi order vicharl tr te pahije positions
//(1 2 3) (3 4 2) (0 5 1) (5 7 5) (5 9 4) (8 9 6)
//tc-->O(n) +O(n log n) + O(n) ~O(n log n)    sc--->n
import java.util.*;

public class Nmeetinginoneroom {

    static class Meeting {
        int start;
        int end;
        int pos;

        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if (o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }

    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meet = new ArrayList<>();

        for (int i = 0; i < n; i++)
            meet.add(new Meeting(start[i], end[i], i + 1));
//        Meeting(1, 2, 1)
//        Meeting(3, 4, 2)
//        Meeting(0, 5, 3)
//        Meeting(5, 7, 4)
//        Meeting(8, 9, 5)
//        Meeting(5, 9, 6)
        Collections.sort(meet, new MeetingComparator());
        //sorted by endtime
//        Meeting(1, 2, 1)
//        Meeting(3, 4, 2)
//        Meeting(0, 5, 3)
//        Meeting(5, 7, 4)
//        Meeting(8, 9, 5)
//        Meeting(5, 9, 6)

        ArrayList<Integer> answer = new ArrayList<>();

        //0 th ch store kel
        answer.add(meet.get(0).pos); //answer={1};
        int limit = meet.get(0).end; //end time=2

        for (int i = 1; i < n; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }

        System.out.println("The order in which the meetings will be performed is:");
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public static void main(String args[]) {
        int n = 6;
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 5, 7, 9, 9};
        maxMeetings(start, end, n);
    }
}
//The order in which the meetings will be performed is:
//        1 2 4 5  positions