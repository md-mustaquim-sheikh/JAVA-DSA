public class Enums {
    
    public enum Week {
        Mon, Tue, Wed, Thu, Fri, Sat, Sun;
        
    }

    public static void main(String[] args) {
        Week week = Week.Mon;
        System.out.println(week);

        for(Week day : Week.values()){
            System.out.println(day);
        }
    }
}
