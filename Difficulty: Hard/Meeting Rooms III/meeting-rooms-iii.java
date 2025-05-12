//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap for available rooms
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.offer(i);

        // Min-heap for ongoing meetings: [endTime, roomIndex]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Integer.compare((int) a[1], (int) b[1]);
        });

        int[] roomMeetingCount = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0], end = meeting[1];
            long duration = end - start;

            // Free up rooms that are done before current start time
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{start + duration, room});
                roomMeetingCount[room]++;
            } else {
                // No free room, delay the meeting
                long[] earliest = busyRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                busyRooms.offer(new long[]{newStart + duration, room});
                roomMeetingCount[room]++;
            }
        }

        int maxMeetings = 0, resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomMeetingCount[i] > maxMeetings) {
                maxMeetings = roomMeetingCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends