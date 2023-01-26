package l01;


class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 13;
        System.out.println(search(arr, target));
        System.out.println(searchR(arr, target));
    }

    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) min = mid + 1;
            else max = mid - 1;
        }

        return -1;

    }

    public static int searchR(int[] nums, int target) {
        return searchR(nums, target, 0, nums.length - 1);
    }

    private static int searchR(int[] nums, int target, int from, int to) {
        if (from > to) return -1;
        int mid = from + (to - from) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return searchR(nums, target, mid + 1, to);
        else return searchR(nums, target, from, mid - 1);
    }


}
