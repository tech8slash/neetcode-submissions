class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int n : map.keySet()){
            int freq = map.get(n);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(n);
        }
        int[] result = new int[k];
        int index = 0;
        for(int i = bucket.length - 1;i>=0;i--){
            if(bucket[i] != null){
                for(int n : bucket[i]){
                    result[index] = n;
                    index++;
                if(index == k){
                   return result;
            }
        }
        }
        }
        return result;
    }
}
