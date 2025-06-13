class Solution {
    public int kokoEat(int[] arr, int k) {
        int left = 1;
        int right = 0;

        for (int bananas : arr) {
            right = Math.max(right, bananas);
        }

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(arr, k, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canEatAll(int[] arr, int k, int s) {
        int totalHours = 0;
        for (int pile : arr) {
            totalHours += (pile + s - 1) / s;
        }
        return totalHours <= k;
    }
}