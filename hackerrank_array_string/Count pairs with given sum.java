class Solution {
    int countPairs(int arr[], int target) {
    int count =0;
    int n=arr.length;
    boolean flag=false;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(arr[i]+arr[j]==target){
                count++;
                flag = true;
            }
        }
    }
    if(flag==true){
    return count;}
    else{
        return 0;
    }
    
    
}}
