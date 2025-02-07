package berek;
import java.util.*;
import java.io.*;

public class Berek {

 
    public static void main(String[] args) throws IOException {
        File f=new File("berek2020.txt");
            Scanner be=new Scanner(f);
         String fejlec=be.nextLine();
         String line; String cut[];
         
            String[]nev=new String[1000]; String[]nem=new String[1000];
            String[]reszleg=new String[1000]; int[]belepes=new int[1000];
            int[]ber=new int[1000]; int db=0;
            
                while(be.hasNextLine()){
                    line=be.nextLine();
                    cut=line.split(";");
                    nev[db]=cut[0];
                    nem[db]=cut[1];
                    reszleg[db]=cut[2];
                    belepes[db]=Integer.parseInt(cut[3]);
                    ber[db]=Integer.parseInt(cut[4]);
                    db++;
                } be.close();;
            System.out.println("3. Feladat: Dolgozók száma: "+db+" fő");
             double atl=0;
            for(int i=0;i<db;i++){
                atl=atl+ber[i];
            }
            double Atlag=(double)atl/db;
        System.out.print("4. Feladat: Bérek átlaga ");
                System.out.println(Math.round(Atlag*10.0)/10000.0+ " eFt");
                
        System.out.print("5. Feladat: Kérem egy részleg nevét: ");
                Scanner sc=new Scanner(System.in);
                  String reszlegnev=sc.next();
                 int max=0; int a=0;  boolean v=false; 
                 
            for(int i=0;i<db;i++){
                if(reszleg[i].equals(reszlegnev)){
                    v=true;
                if(max<ber[i]){
                    max=ber[i];
                    a=i;
                }
                }
              }
        if(v){
        System.out.println("6. Feladat: A legtöbbet kereső dolgozó a megadott részlegen");
        System.out.println("    Név: "+nev[a]);
        System.out.println("    Neme: "+nem[a]);
        System.out.println("    Belépés: "+belepes[a]);
        System.out.println("    Bér: "+ber[a]+" Forint");
       } else{
            System.out.println("6. Feladat: A megadott részleg nem létezik a cégnél!");
        }      
        System.out.println("7. Feladat: Statisztika");
            HashSet<String> hal=new HashSet<String>();
                for(int i=0;i<db;i++){
                    hal.add(reszleg[i]);
                }
            String[]egyedi=new String[hal.size()];
              int ehdb=0;
                for(String s: hal){
                    egyedi[ehdb]=s;
                    ehdb++;
                }
              int idb[]=new int[ehdb];
                for(int i=0;i<ehdb;i++){
                    for(int j=0;j<reszleg.length;j++){
                        if(egyedi[i].equals(reszleg[j])){
                            idb[i]++;
                        }
                    }
                }
                for(int i=0;i<ehdb;i++){
                    System.out.println("    "+egyedi[i]+" - "+idb[i]+" fő");
    }
    
    }
}
