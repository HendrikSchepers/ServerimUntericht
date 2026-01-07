import jutils.*;

public class Main {

     public static void main(String[] args) {

         Connection connection=new Connection("time-b.timefreq.bldrdoc.gov",13);
         String a=connection.receive();
         String Zeit = connection.receive();
         System.out.println("sever time:"+ Zeit);
         connection.close();

         //DaytimeClient daytimeClient= new DaytimeClient("time.fu-berlin.de");

         QOTDClient qotdClient=new QOTDClient("djxmmx.net" );


    }
}
