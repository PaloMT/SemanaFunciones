public class Sesion4  {
    public static void domingosDelMes(int mes3, int ano3){
        int diaspasados = Sesion3.getDiasDeMes(mes3);
        System.out.printf("El mes tiene %02d dias y caen domingo los dias: ", diaspasados);
        for (int dia = 1; dia <= diaspasados; dia++) {
            int diaSemana = Sesion3.getDiaDeLaSemana(dia, mes3, ano3);
            if (diaSemana == 0) {
                System.out.print(dia + ", ");
            }
        }
    }

    public static void siguienteFechaConMismoDia(int dia, int mes){
        int anonuevo = 2025;
        int diaAhora = Sesion3.getDiaDeLaSemana(dia, mes, 2025);
        int diaDespues;
        do { anonuevo++;
            diaDespues = Sesion3.getDiaDeLaSemana(dia, mes, anonuevo);}while ((diaAhora!=diaDespues));

        switch (Sesion3.getDiaDeLaSemana(dia, mes,2025)) {
            case 0:
                System.out.printf("Fecha: %02d/%02d. Es Domingo, y vuelve a caer el año %d04", dia, mes, anonuevo);
                break;
            case 1:
                System.out.printf("Fecha: %02d/%02d. Es Lunes y vuelve a caer el año %d04", dia, mes, anonuevo);
                break;
            case 2:
                System.out.printf("Fecha: %02d/%02d. Es Martes y vuelve a caer el año %d04", dia, mes, anonuevo);
                break;
            case 3:
                System.out.printf("Fecha: %02d/%02d. Es Miércoles y vuelve a caer el año %d04", dia, mes, anonuevo);
                break;
            case 4:
                System.out.printf("Fecha: %02d/%02d. Es Jueves y vuelve a caer el año %d04", dia, mes, anonuevo);
                break;
            case 5:
                System.out.printf("Fecha: %02d/%02d. Es Viernes y vuelve a caer el año %d04", dia, mes, anonuevo);
                break;
            case 6:
                System.out.printf("Fecha: %02d/%02d. Es Sabado y vuelve a caer el año %d", dia, mes, anonuevo);
                break;}
    }

    public static int getDiasTranscurridosHastaRecursivo(int numero){
        if (numero <= 1) {
            return 0;}
        else {
            int resultado = Sesion3.getDiasDeMes(numero - 1) + getDiasTranscurridosHastaRecursivo(numero - 1);
            return resultado;}
    }

    public static void mostrarDiasEntre (int dia5, int mes5,int dia6, int mes6){
        System.out.printf("Entre el %02d/%02d y el %02d/%02d de un año no bisiesto hay: %d dias",dia5,mes5,dia6,mes6,
                mostrarDiasEntreR( dia5, mes5, dia6, mes6));
    }

    private static int mostrarDiasEntreR (int dia5, int mes5,int dia6, int mes6){
        int resultado = 0;
        if (mes6>mes5){
            resultado= mostrarDiasEntreR(dia5, mes5, dia6 + Sesion3.getDiasDeMes(mes6-1), mes6-1);
        }
        else if (mes6 == mes5){resultado = dia6 - dia5;}

        return resultado;}

}

