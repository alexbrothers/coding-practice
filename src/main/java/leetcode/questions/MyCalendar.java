package leetcode.questions;

import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (calendar.containsKey(start)) {
            return false;
        }
        Integer previousMeetingStart = calendar.floorKey(start);
        Integer nextMeetingStart = calendar.ceilingKey(start);
        if (previousMeetingStart == null && nextMeetingStart == null) {
            insertMeeting(start, end);
            return true;
        }
        if (previousMeetingStart == null) {
            if (nextMeetingStart >= end) {
                insertMeeting(start, end);
                return true;
            }
            else {
                return false;
            }
        }
        if (nextMeetingStart == null) {
            if (calendar.get(previousMeetingStart) <= start) {
                insertMeeting(start, end);
                return true;
            }
            else {
                return false;
            }
        }
        if (calendar.get(previousMeetingStart) <= start && nextMeetingStart >= end) {
            insertMeeting(start, end);
            return true;
        }
        return false;
    }

    private void insertMeeting(int start, int end) {
        calendar.put(start, end);
    }

}
