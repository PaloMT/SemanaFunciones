//Sara Paloma Martínez-Tizón García. Matricula bw0100. Grupo IWSM12
import java.util.Scanner;

public class Sesion2 {
    public static void main (String[] args) {
        int ano, dia, lim;

        Scanner sn = new Scanner(System.in);
        do{
        System.out.print("Introduce año: ");
        ano = sn.nextInt();} while(ano<1901 || ano>2099);

        do{
        System.out.print("Introduce Dia (0 = Lunes, 1= Martes,...): ");
        dia = sn.nextInt();}while(dia<0 || dia> 31);

        if (ano%4 ==0){ lim = 30;}
        else {lim = 29;}

        //Enero
        System.out.println("\n\t\tEnero " + ano);
        System.out.println("Lun\tMar\tMie\tJue\tVie\tSab\tDom");
        for (int i = 0; i< dia; i++){
                System.out.print("\t");}
        for (int i= 1; i<32; i++){
                System.out.print(i+"\t");
                dia ++;
                if (dia == 7){
                    System.out.print ("\n");
                    dia = 0;}}

        //Febrero
        System.out.println("\n\t\tFebrero " + ano);
        System.out.println("Lun\tMar\tMie\tJue\tVie\tSab\tDom");
        for (int i = 0; i< dia; i++){
                System.out.print("\t");}
        for (int j= 1; j<lim; j++){
                System.out.print(j+"\t");
                dia ++;
                if (dia == 7){
                    System.out.print ("\n");
                    dia = 0;}}

    }
}

