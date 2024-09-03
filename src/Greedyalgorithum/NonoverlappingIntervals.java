package Greedyalgorithum;
import java.util.*;

//same as nmeetings problem
//remove kraych ahe so that there is  no overlap--->1 3 remove kr--->o/p-->1
//for this prob we considered overlapping for other plz dont consider
public class NonoverlappingIntervals {

        static class Interval {
            int start;
            int end;

            Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        static class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end < o2.end)
                    return -1;
                else if (o1.end > o2.end)
                    return 1;
                return 0;
            }
        }

        static int minIntervalsToRemove(int[] start, int[] end, int n) {
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(start[i], end[i]));
            }

            // Sort intervals by end time
            Collections.sort(intervals, new IntervalComparator());

            int count = 1; // We can always pick at least one interval
            int lastEnd = intervals.get(0).end;//2

            for (int i = 1; i < n; i++) {
                if (intervals.get(i).start >= lastEnd) {
                    count++;
                    lastEnd = intervals.get(i).end;
                }
            }

            // Calculate the minimum number of intervals to remove
            return n - count;
        }

        public static void main(String[] args) {
            int n = 6;
            int[] start = {1, 3, 0, 5, 8, 5};
            int[] end = {2, 4, 5, 7, 9, 9};
            int minRemove = minIntervalsToRemove(start, end, n);
            System.out.println("The minimum number of intervals to remove to make the rest non-overlapping is: " + minRemove);
        }
    }
//2
