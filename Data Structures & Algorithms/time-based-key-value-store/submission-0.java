class TimeMap {

    class Data{
        String val;
        int timeStamp;

        public Data(String val, int timeStamp){
            this.val = val;
            this.timeStamp = timeStamp;
        }
    }

    private Map<String,List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k->new ArrayList<>()).add(new Data(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        int left = 0;
        int right = list.size()-1;

        String result = "";

        while(left<=right){
            int mid = left+(right-left)/2;
            if(list.get(mid).timeStamp<=timestamp){
                result = list.get(mid).val;
                left=mid+1;
            }
            else right=mid-1;
        }
        return result;
    }
}
