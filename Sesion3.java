//Sara Paloma Martínez-Tizón García. Matricula bw0100. Grupo IWSM12
import java.util.Scanner;

public class Sesion3 {

    public static int menu() {
        System.out.println("\nMENÚ DE OPCIONES:");
        System.out.println("1. Calcular el número de días transcurridos en un año hasta el comienzo de un mes determinado.");
        System.out.println("2. Calcular el día de la semana asociado a una fecha.");
        System.out.println("3. Mostrar todos los domingos de un mes determinado.");
        System.out.println("4. Calcular la siguiente fecha a partir de 2025 que coincida en día de la semana a una fecha dada.");
        System.out.println("5. Calcular la distancia en días, entre 2 fechas de un año no bisiesto.");
        System.out.println("0. Salir del menú.");
        int resultado = leerNumero(0,5);
        return resultado;}

    public static int leerNumero (int n1, int n2){
        Scanner scs = new Scanner(System.in);
        int numero;
        do{System.out.print("Introduce un número entre " + n1 + " y " + n2 + ": ");
            numero = scs.nextInt();
        if(numero< n1 || numero>n2){
            System.out.println("Número inválido.");}
        } while (numero< n1 || numero>n2);
        return numero;}

    public static boolean esFechaCorrecta (int dia,int mes, int ano){
        boolean resultado;
        int diaMes = 0;
        if(mes<1 || mes>12){
            resultado = false;}
        if (ano<1900 || ano>2100){
            resultado = false;}
        else {
            switch (mes) {
            case 2:
                if (ano % 4 == 0) {
                    diaMes = 29;}
                else {
                    diaMes = 28;}break;
            case 4, 6,9,11: diaMes = 30;break;
            default: diaMes = 31;}
            resultado = (dia <= diaMes);
            if (!resultado) System.out.println("Ese dia no existe en el mes definido");
        }return resultado;}

    public static int getDiasDeMes ( int n){
            int diasDeMes = 0;
            switch (n) {
                case 12, 10, 8, 7, 5, 3, 1:
                    diasDeMes = 31;
                    break;
                case 11, 9, 6, 4:
                    diasDeMes = 30;
                    break;
                case 2:
                    diasDeMes = 28;
                    break;
            }
            return diasDeMes;
        }

    public static int getDiasTranscurridosHasta ( int diaInicial){
            int diasTrans = 0;
            for (int i = 0; i <= diaInicial ; i++) {
                diasTrans += getDiasDeMes(i);}
            return diasTrans;
        }

    public static int getDiaDeLaSemana ( int diaSem, int mesSem, int anoSem){
            int diasMes = 0, bisiesto, diasSemana;

            bisiesto = ((anoSem - 1900) * 365);
            bisiesto += ((anoSem - 1900) / 4);

            if (anoSem % 4 == 0 && (mesSem == 1 || mesSem == 2)) {
                bisiesto -= 1;}

            switch (mesSem - 1) {
                case 11,9,6,4: diasMes += 30;
                case 10,8,7,5,3: diasMes += 31;
                case 2: diasMes += 28;
                case 1: diasMes += 31; break;}
            diasSemana = (diasMes + diaSem + bisiesto) % 7;
            return diasSemana;}

    public static void main (String[] args){
        int opcion;

        do{ opcion = menu();
            switch (opcion){
                case 1: opcion1(); break;
                case 2: opcion2();break;
                case 3: opcion3(); break;
                case 4: opcion4();break;
                case 5: opcion5();break;}
        }while (opcion> 0);}

    private static void opcion1(){
        int dia1,mes1, ano1;

        do{ dia1 = leerNumero(1,31);
            mes1 = leerNumero(1,12);
            ano1 = leerNumero(1900,2100);
        } while (!esFechaCorrecta(dia1,mes1,ano1));

        int suma = Sesion4.getDiasTranscurridosHastaRecursivo(mes1) + dia1;
        System.out.printf("Han pasado %d días desde el 1 de enero de %02d hasta el %02d-%02d-%02d%n", suma, ano1, dia1, mes1, ano1);}

    private static void opcion2(){
        int dia2,mes2, ano2;

        do{ dia2 = leerNumero(1,31);
            mes2 = leerNumero(1,12);
            ano2 = leerNumero(1900,2100);
        } while (!esFechaCorrecta(dia2,mes2,ano2));

        switch (getDiaDeLaSemana(dia2, mes2, ano2)) {
            case 0:
                System.out.printf("Fecha: %02d-%02d-%02d. Es Domingo", dia2, mes2, ano2 % 100);break;
            case 1:
                System.out.printf("Fecha: %02d-%02d-%02d. Es Lunes", dia2, mes2, ano2 % 100);break;
            case 2:
                System.out.printf("Fecha: %02d-%02d-%02d. Es Martes", dia2, mes2, ano2 % 100);break;
            case 3:
                System.out.printf("Fecha: %02d-%02d-%02d. Es Miércoles", dia2, mes2, ano2 % 100);break;
            case 4:
                System.out.printf("Fecha: %02d-%02d-%02d. Es Jueves", dia2, mes2, ano2 % 100);break;
            case 5:
                System.out.printf("Fecha: %02d-%02d-%02d. Es Viernes", dia2, mes2, ano2 % 100);break;
            case 6:
                System.out.printf("Fecha: %02d-%02d-%02d. Es Sabado", dia2, mes2, ano2 % 100);break;}
    }

    private static void opcion3(){
        int mes3,ano3;
        mes3 = Sesion3.leerNumero(1,12);
        ano3 = Sesion3.leerNumero(1900,2100);
        Sesion4.domingosDelMes(mes3,ano3);
    }
    private static void opcion4(){
        int dia4,mes4;

        do {dia4 = Sesion3.leerNumero(1,31);
            mes4 = Sesion3.leerNumero(1,12);
        } while (!Sesion3.esFechaCorrecta(dia4, mes4, 2025));
        Sesion4.siguienteFechaConMismoDia(dia4,mes4);
    }
    private static void opcion5() {
        int dia5, dia6, mes6, mes5;
        do {
            do {
                dia5 = Sesion3.leerNumero(1, 31);
                mes5 = Sesion3.leerNumero(1, 12);
            } while (!Sesion3.esFechaCorrecta(dia5, mes5, 2025));
            do {
                dia6 = Sesion3.leerNumero(1, 31);
                mes6 = Sesion3.leerNumero(1, 12);
            } while (!Sesion3.esFechaCorrecta(dia6, mes6, 2025));
            if (mes6< mes5 || (mes6 == mes5 && dia6<dia5)){
                System.out.println("la primera fecha ha de ser menor a la segunda");
            }
        } while (mes6< mes5 || (mes6 == mes5 && dia6<dia5));
        Sesion4.mostrarDiasEntre(dia5,mes5,dia6,mes6);
    }
}
