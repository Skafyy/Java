/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package toto;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class EredmenyElemzo {
    private String eredmenyek;

    private int dontetlenekSzama() {
        return megszamol('X');
    }

    private int megszamol(char kimenet) {
        return (int) eredmenyek.chars().filter(ch -> ch == kimenet).count();
    }

    public boolean memvoltDontetlenMerkozes() {
        return dontetlenekSzama() == 0;
    }

    EredmenyElemzo(String eredmenyek) {
        this.eredmenyek = eredmenyek;
    }
}

public class Toto {

    public static void main(String[] args) throws IOException {
        File f=new File("toto.txt");
        Scanner be=new Scanner(f);
        String firstline=be.nextLine();
        
        int[]ev=new int[2000];
        int[]het=new int[2000];
        int[]ford=new int[2000];
        int[]T13p1=new int[2000];
        int[]Ny13p1=new int[2000];
        String[]ered=new String[2000];
        
        String sor; String[]cut; int db=0;
        
        while(be.hasNextLine()){
            sor=be.nextLine();
            cut=sor.split(";");
            ev[db]=Integer.parseInt(cut[0]);
            het[db]=Integer.parseInt(cut[1]);
            ford[db]=Integer.parseInt(cut[2]);
            T13p1[db]=Integer.parseInt(cut[3]);
            Ny13p1[db]=Integer.parseInt(cut[4]);
            ered[db]=cut[5];
            db++;
        } be.close();
        
        System.out.println("3. feladat: Fordulók száma: "+db);
      
        int telit=0;
        for(int i=0;i<db;i++){
            telit=telit+T13p1[i];
        } System.out.println("4. feladat: Telitalálatos szelvények száma: "+telit+" db");
        
        long five=0;
        for (int i=0;i<db;i++) {
            if (T13p1[i]>0) {
                five=five+T13p1[i]*Ny13p1[i];
            }
        }
        DecimalFormat df=new DecimalFormat("#");
        System.out.println("5.feladat: Átlag: "+df.format((double)five/db)+" Ft");
        
        
        int max=Ny13p1[0]; int maxind=0; 
        for (int i=0;i<db;i++) {
            if (max<Ny13p1[i]) {
                max=Ny13p1[i];
                maxind=i;
            }
        } 
        int min=max; int minind=0;
        for(int i=0;i<db;i++){
            if(min>Ny13p1[i]&&Ny13p1[i]!=0){
                min=Ny13p1[i];
                minind=i;
            }
        }
        System.out.println("6. feladat: ");
        System.out.println("\tLegnagyobb: ");
        System.out.println("\tÉv: "+ev[maxind]);
        System.out.println("\tHét: "+het[maxind]);
        System.out.println("\tForduló: "+ford[maxind]);
        System.out.println("\tTelitalálat: "+T13p1[maxind]);
        System.out.println("\tNyeremény: "+Ny13p1[maxind]+" Ft");
        System.out.println("\tEredmények: "+ered[maxind]);
        System.out.println(" ");
        System.out.println("\tLegkisebb: ");
        System.out.println("\tÉv: "+ev[minind]);
        System.out.println("\tHét: "+het[minind]);
        System.out.println("\tForduló: "+ford[minind]);
        System.out.println("\tTelitalálat: "+T13p1[minind]);
        System.out.println("\tNyeremény: "+Ny13p1[minind]+" Ft");
        System.out.println("\tEredmények: "+ered[minind]);
        
        boolean v=false;
        for(int i=0;i<db;i++){
            EredmenyElemzo l=new EredmenyElemzo(ered[i]);
            if(l.memvoltDontetlenMerkozes()){
                v=true;
                break;
            }
        } if(v==true){
            System.out.println("8. feladat: Volt olyan forduló, amely döntetlen nélküli volt.");
        } else {
            System.out.println("8. feladat: Nem volt olyan forduló, amely döntetlen nélküli lett volna.");
        }
        
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<db;i++){
            h.add(T13p1[i]);
        }
        
        int edb=0; int[]egyedit=new int[db];
        for(int s : h){
            egyedit[edb]=s;
            edb++;
        }
        
        int[]egyeditomb=new int[edb];
        for(int i=0;i<edb;i++){
            for(int j=0;j<db;j++){
                if(T13p1[j]==egyedit[i]){
                    egyeditomb[i]++;
                }
            }
        }
        for(int i=0;i<edb;i++){
            System.out.println(egyedit[i]+" "+egyeditomb[i]);
        }
        
        
        System.out.println("------------------------------------------");
        
       HashSet<Integer> g=new HashSet<Integer>();
       for(int i=0;i<db;i++){
           g.add(T13p1[i]);
       }
       
       int egydb=0; int[]egyedit1=new int[db];
       for(int s: g){
           egyedit1[egydb]=s;
           egydb++;
       }
       
       int[]egyeditomb1=new int[egydb];
       for(int i=0;i<egydb;i++){
           for(int j=0;j<db;j++){
               if(T13p1[j]==egyedit1[i]){
                   egyeditomb1[i]++;
               }
           }
       }
       
       for(int i=0;i<egydb;i++){
           System.out.println(egyedit1[i]+" "+egyeditomb1[i]);
       }
       
       FileWriter fw=new FileWriter("teli.txt");
       PrintWriter pw=new PrintWriter(fw);
       for(int i=0;i<db;i++){
           if(T13p1[i]>0){
               pw.print(ev[i]+" "+het[i]+" "+ford[i]);
           }
       } pw.close();
       
        System.out.println("---------------------------------------------------");
        
        HashSet<Integer> q=new HashSet<Integer>();
        for(int i=0;i<db;i++){
            q.add(Ny13p1[i]);
        }
        
        int db1=0; int[]rt=new int[db];
        for(int s: q){
            rt[db1]=s;
            db1++;
        }
        
        int[]rz=new int[db1];
        for(int i=0;i<db1;i++){
            for(int j=0;j<db;j++){
                if(Ny13p1[j]==rt[i]){
                    rz[i]++;
                }
            }
        }
        
        for(int i=0;i<db1;i++){
            System.out.println(rt[i]+" "+rz[i]);
        }
        
        System.out.println("--------------------------------------");
        
        boolean x=false;
        for(int i=0;i<db;i++){
            EredmenyElemzo m=new EredmenyElemzo(ered[i]);
            if(m.memvoltDontetlenMerkozes()){
                x=true;
                break;
            }
        } if(x){
            System.out.println("volt döntetlen mérkőzés");
        } else {
            System.out.println("nem volt döntetlen mérkőzés");
        }
        
        System.out.println("----------------------------------------");
        
        HashSet<String> n=new HashSet<String>();
        for(int i=0;i<db;i++){
            n.add(ered[i]);
        }
        
        int gh=0; String[]ds=new String[db];
        for(String s: n){
            ds[gh]=s;
            gh++;
        }
        
        int[]gj=new int[gh];
        for(int i=0;i<gh;i++){
            for(int j=0;j<db;j++){
                if(ered[j].equals(ds[i])){
                    gj[i]++;
                }
            }
        }
        
        for(int i=0;i<gh;i++){
            System.out.println(ds[i]+" - "+gj[i]);
        }
        
    }
}

