class TimeMap {

    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int start = 0;
        int end = list.size() - 1;

        String ans = "";

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value; // possible answer
                start = mid + 1;          // look for a larger valid timestamp
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}