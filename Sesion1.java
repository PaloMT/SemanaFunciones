import java.util.Scanner;

public class Sesion1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dia = 0, mes =0, ano = 0, diasMes = 0, diasPasados = 0,resultado = 0;

        System.out.print("introduce dia del mes: ");
        dia = teclado.nextInt();
        System.out.print("introduce mes del año: ");
        mes = teclado.nextInt();
        System.out.print("introduce año: ");
        ano = teclado.nextInt();

        if (dia>31 || dia<1){System.out.print("Dia invalido");}
        else if (mes>12 || mes<1){System.out.print("Mes invalido");}
        else if (ano<1900 || ano>2100){System.out.print("Año invalido");}
        else{
            diasPasados = ((ano-1900)*365);
            diasPasados += ((ano-1900)/4);
            if (ano%4 == 0 && (mes ==1 || mes ==2)){diasPasados -=1;}
            switch(mes-1){
                case 11: diasMes += 30;
                case 10: diasMes += 31;
                case 9: diasMes += 30;
                case 8: diasMes += 31;
                case 7: diasMes += 31;
                case 6: diasMes += 30;
                case 5: diasMes += 31;
                case 4: diasMes += 30;
                case 3: diasMes += 31;
                case 2: diasMes += 28;
                case 1: diasMes += 31;break;}

            resultado= (diasMes+dia+diasPasados)%7;
            switch (resultado){
                case 0: System.out.printf("Fecha: %02d-%02d-%02d. Es Domingo",dia,mes,ano%100);break;
                case 1: System.out.printf("Fecha: %02d-%02d-%02d. Es Lunes",dia,mes,ano%100);break;
                case 2: System.out.printf("Fecha: %02d-%02d-%02d. Es Martes",dia,mes,ano%100);break;
                case 3: System.out.printf("Fecha: %02d-%02d-%02d. Es Miércoles",dia,mes,ano%100);break;
                case 4: System.out.printf("Fecha: %02d-%02d-%02d. Es Jueves",dia,mes,ano%100);break;
                case 5: System.out.printf("Fecha: %02d-%02d-%02d. Es Viernes",dia,mes,ano%100);break;
                case 6: System.out.printf("Fecha: %02d-%02d-%02d. Es Sabado",dia,mes,ano%100);break;}
        }
    }
}

