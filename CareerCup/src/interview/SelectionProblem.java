package interview;

import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class SelectionProblem {

    static class Meeting {
        public long startTime;
        public long endTime;

        public Meeting(long sTime, long eTime) {
            startTime = sTime;
            endTime = eTime;
        }
    }

    public static void main(String[] args) {
        Comparator<Meeting> comp = new Comparator<SelectionProblem.Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return new Long(o1.endTime).compareTo(new Long(o2.endTime));
            }

        };
        Queue<Meeting> meetings = new PriorityBlockingQueue<SelectionProblem.Meeting>(6, comp);
        Queue<Meeting> overlapMeetings = new PriorityBlockingQueue<SelectionProblem.Meeting>(6, comp);
        initMeetings(overlapMeetings);
        int rooms = 0;
        int numberOfMeetings = 0;
        do {
            rooms++;
            numberOfMeetings = overlapMeetings.size();
            meetings.clear();
            meetings.addAll(overlapMeetings);
            overlapMeetings.clear();
            Meeting currentMeeting = meetings.poll();
            while (!meetings.isEmpty()) {
                Meeting nextM = meetings.poll();
                if (nextM.startTime >= currentMeeting.endTime) {
                    currentMeeting = nextM;
                } else {
                    overlapMeetings.add(nextM);
                }
            }
        } while (overlapMeetings.size() + 1 != numberOfMeetings && !overlapMeetings.isEmpty());
        if (!overlapMeetings.isEmpty()) {
            rooms += overlapMeetings.size();
        }
        System.out.println("Number of rooms: " + rooms);
    }

    public static void initMeetings(Queue<Meeting> meetings) {
        meetings.offer(new Meeting(5, 7));
        meetings.offer(new Meeting(1, 2));
        meetings.offer(new Meeting(3, 4));
        meetings.offer(new Meeting(8, 9));
        meetings.offer(new Meeting(5, 9));
        meetings.offer(new Meeting(0, 6));
    }
}
