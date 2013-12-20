public class PartII{

    public static void main(String [] args){
        int number = 4;
        System.out.println(sum(number));
    }

    public static int sum(int n){
      if(n==1){
        return 1; //base case
      }
      else{
        return n + sum(n-1); //recursive case
      }
    }

}