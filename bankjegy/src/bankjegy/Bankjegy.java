/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankjegy;

/**
 *
 * @author varga
 */
public class Bankjegy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[]szam={500,1000,500,1000,5000,5000,500,1000,10000,500,10000,20000,1000,20000,500};
            System.out.println("Bankjegyek száma: "+szam.length);
        int[]e=new int[szam.length]; int cs;
           for(int i=0;i<szam.length-1;i++){
               for(int j=i+1;j<szam.length;j++){
                   if(szam[i]>szam[j]&&szam[i]>0&&szam[j]>0){
                       cs=szam[i]; szam[i]=szam[j]; szam[j]=cs;
                   }
               }
           } System.out.print("Tömb elemei: ");
            for(int i=0;i<szam.length;i++){
                System.out.print(" "+szam[i]);
            } System.out.println("");
            
            szam[0]=e[0]; int db=1;
            for(int i=0;i<szam.length-1;i++){
                if(szam[i+1]!=szam[i]){
                    e[db]=szam[i+1];
                    db++;
                }
                
            } System.out.print("Egymástól eltérő bankjegyek a tömbben: ");
            for(int i=0;i<szam.length;i++){
                System.out.print(" "+e[i]);
            } System.out.println("");
            
            int h=0, h1=0, h2=0, h3=0, h4=0, h5=0;
                for(int i=0;i<e.length;i++){
                    if(szam[i]==e[0]){
                        h++;
                    }
                    if(szam[i]==e[1]){
                        h1++;
                    }
                    if(szam[i]==e[2]){
                        h2++;
                    }
                    if(szam[i]==e[3]){
                        h3++;
                    }
                    if(szam[i]==e[4]){
                        h4++;
                    }
                    if(szam[i]==e[5]){
                        h5++;
                    }
                }
                System.out.println("A "+e[1]+" ft-os bankjegyből "+h1+" db van.");
                System.out.println("A "+e[2]+" ft-os bankjegyből "+h2+" db van.");
                System.out.println("A "+e[3]+" ft-os bankjegyből "+h3+" db van.");
                System.out.println("A "+e[4]+" ft-os bankjegyből "+h4+" db van.");
                System.out.println("A "+e[5]+" ft-os bankjegyből "+h5+" db van.");
    }
    
}
