package restaurante;

import javax.swing.JOptionPane;

public class Reservacion {

    Reservacion mesas[] = new Reservacion[7];

    private String nombrePersona = "";
    private int cantidadPersonas = 0;
    private String fecha = "";
    private int hora = 0;

    //VARIABLE GLOBAL
    private byte reservaciones = 0;
    private String cadena = "";
    private byte contadorMuestra = 0;

    public Reservacion(String nombrePersona, int cantidadPersonas, String fecha, int hora) {
        this.nombrePersona = nombrePersona;
        this.cantidadPersonas = cantidadPersonas;
        this.fecha = fecha;
        this.hora = hora;
    }

    public void agregarReservacion() {
        nombrePersona = JOptionPane.showInputDialog("¿BAJO QUE NOMBRE ESTARÁ LA RESERVACIÓN?");

        byte cambio = 0;
        boolean correcto = false;
        byte error = 0;

        do {
            cantidadPersonas = Byte.parseByte(JOptionPane.showInputDialog("CANTIDAD DE PERSONAS"));

            if (cantidadPersonas > 8) {
                cambio = Byte.parseByte(JOptionPane.showInputDialog(null, "NUESTRO MÁXIMO DE PERSONAS PARA UNA RESERVACIÓN ES DE 8\n¿DESEA CANCELAR LA RESERVACIÓN?\nSI    NO\n1      2",
                        "MAXIMO DE PERSONAS SUPERADO", JOptionPane.ERROR_MESSAGE));
            } else {
                correcto = true;//CAMBIÉ DE TURE
            }

            if (cantidadPersonas > 8 && cambio == 2) {
                correcto = false;//CAMBIÉ DE FALSE
            } else {
                correcto = true;
            }
//SI DIGITA BIEN ES TRUE
//DESEA CANCELAR TRUE
//VOLVER A DIGITAR FALSE
        } while (correcto != true);
//CAMBIÉ DE TRUE
        if (cantidadPersonas < 8 && cantidadPersonas > 0) {
            correcto = false;
        }

        if (correcto == false) {
            cambio = 0;

            fecha = JOptionPane.showInputDialog("FECHA DE LA RESERVACIÓN\nFormato: (dia/mes/año)\nEjemplo: (5/04/2020)");
            hora = Byte.parseByte(JOptionPane.showInputDialog("HORA DE LA RESERVACIÓN\n(Formato 24 horas) "));

            if (reservaciones > 0) {
                do {
                    correcto = true;
                    error = 0;
                    byte j = 0;

                    //VERIFICAMOS QUE NINGUNA FECHA SE REPITA
                    while (j < reservaciones) {
                        if (fecha.equals(mesas[j].fecha)) {
                            if (hora == mesas[j].hora) {
                                error++;
                            } else {
                                correcto = false;
                            }
                        }
                        j++;
                    }

                    //EN CASO DE EXISTIR ALGUN ERROR ENTRAMOS Y PEDIMOS DE NUEVO LA FECHA
                    if (error != 0) {
                        correcto = true;
                        fecha = JOptionPane.showInputDialog(null, "FECHA DE LA RESERVACIÓN\nFormato: (dia/mes/año)\nEjemplo: (5/04/2020)", "HORA OCUPADA", JOptionPane.ERROR_MESSAGE);
                        hora = Byte.parseByte(JOptionPane.showInputDialog(null, "HORA DE LA RESERVACIÓN\n(Formato 24 horas)", "HORA OCUPADA", JOptionPane.ERROR_MESSAGE));
                    }

                } while (correcto != false);

            }

            //SI RESERVACIONES ES 0, NO HAY CON QUE COMPARAR POR ENDE SALE DIRECTAMENTE
            if (reservaciones == 0) {
                correcto = false;
            }
            if (correcto == false) {
                mesas[reservaciones] = new Reservacion(nombrePersona, cantidadPersonas, fecha, hora);
                reservaciones++;
            }

            mostrarReservaciones(true);
        }
    }

    public void mostrarReservaciones(boolean entrada) {
        if (entrada) {
            while (contadorMuestra < reservaciones) {
                cadena += "Reservación " + (contadorMuestra + 1)
                        + "\n" + mesas[contadorMuestra].nombrePersona
                        + "\n" + mesas[contadorMuestra].cantidadPersonas
                        + " personas\n" + mesas[contadorMuestra].fecha
                        + "\n" + mesas[contadorMuestra].hora + " horas\n\n";

                contadorMuestra++;
            }
        }
        if (!entrada) {
            JOptionPane.showMessageDialog(null, cadena);
        }
    }

    public void eliminarReservación() {
        if (reservaciones != 0) {
            byte opcionEliminar = 0;

            do {
                opcionEliminar = Byte.parseByte(JOptionPane.showInputDialog(cadena + "DIGITE LA OPCION A ELIMINAR"));
                opcionEliminar--;
                if (opcionEliminar >= 0 && opcionEliminar <= reservaciones) {

                    for (int i = opcionEliminar; i < reservaciones - 1; i++) {
                        mesas[i] = mesas[i + 1];
                    }
                    mesas[reservaciones - 1] = null;
                    reservaciones--;
                    // cantidadDescuento--;
                    //vueltasDescuentos--;

                    cadena = "";
                    for (int i = 0; i < reservaciones; i++) {
                        cadena += "Reservación " + (i + 1)
                                + "\n"
                                + mesas[i].nombrePersona + "\n"
                                + mesas[i].cantidadPersonas + "\n"
                                + mesas[i].fecha + "\n"
                                + mesas[i].hora + "\n\n";
                    }
                }
            } while (opcionEliminar < 0 && opcionEliminar > reservaciones);

        } else {
            JOptionPane.showMessageDialog(null, "No hay promociones disponibles", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
    }

}
