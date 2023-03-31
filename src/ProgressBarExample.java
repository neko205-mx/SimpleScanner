public class ProgressBarExample {
    public static void main(String[] args){
        int total = 100;
        for (int i = 0; i<=total; i++){
            System.out.println("\r");
            System.out.println(String.format("[%s%s] %d%%","#".repeat(i)," ".repeat(total-i),i));
        }
    }
}
