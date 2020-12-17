package restaurante;

import javax.swing.JOptionPane;

public class Promociones {

    private Promociones promociones[] = new Promociones[6];
    //private String calendario[] = new String[12];

    //ATRIBUTOS
    private String mes;
    private float valorDescuento;
    private String nombreDescuento;
    private String codigo;

    //VARIABLES GLOBALES
    int cantidadDescuento = 0;
    String cadena = "";
    int vueltasDescuentos = 0;

    public Promociones(String mes, float valorDescuento, String nombreDescuento, String codigo) {
        this.mes = mes;
        this.valorDescuento = valorDescuento;
        this.nombreDescuento = nombreDescuento;
        this.codigo = codigo;
    }

    public void mostrarPromociones(boolean agregar) {
        if (!agregar) {
            JOptionPane.showMessageDialog(null, cadena);
        } else {
            while (vueltasDescuentos < cantidadDescuento) {
                if (promociones[vueltasDescuentos] != null) {
                    cadena += "Promoción " + (vueltasDescuentos + 1) + "\n" + promociones[vueltasDescuentos].mes
                            + "\n" + promociones[vueltasDescuentos].nombreDescuento
                            + "\n" + promociones[vueltasDescuentos].valorDescuento
                            + "\n" + promociones[vueltasDescuentos].codigo + "\n\n";
                    vueltasDescuentos++;
                } else {
                    break;
                }

            }
        }

    }

    public void agregarPromocion() {

        byte agregarDescuento = 0;
        boolean agregar = false;
        byte error = 0;
        byte error2 = 0;
        byte error3 = 0;

        do {
            mes = JOptionPane.showInputDialog("**MES DE LA PROMOCIÓN**");

            nombreDescuento = JOptionPane.showInputDialog("**DIGITE EL NOMBRE/MOTIVO DEL DESCUENTO**");
            valorDescuento = Float.parseFloat(JOptionPane.showInputDialog("**DIGITE EL MONTO DE DESCUENTO**\n(por ejemplo 0.20)"));
            codigo = JOptionPane.showInputDialog("**AGREGUE UN CÓDIGO PARA EL DESCUENTO**");
            promociones[cantidadDescuento] = new Promociones(mes, valorDescuento, nombreDescuento, codigo);

            error = Byte.parseByte(JOptionPane.showInputDialog(promociones[cantidadDescuento].mes + "\n" + promociones[cantidadDescuento].nombreDescuento + "\n"
                    + promociones[cantidadDescuento].valorDescuento + "\n"
                    + promociones[cantidadDescuento].codigo + "\n\n¿Existe algún fallo?\n¿Desea corregirlo?\n\nSI    NO\n1      2"));
            do {
                if (error == 1) {
                    error2 = Byte.parseByte(JOptionPane.showInputDialog("1. " + promociones[cantidadDescuento].mes + "\n2. " + promociones[cantidadDescuento].nombreDescuento + "\n"
                            + "3. " + promociones[cantidadDescuento].valorDescuento + "\n"
                            + "4. " + promociones[cantidadDescuento].codigo + "\n\nElija la opcion a cambiar"));

                    do {
                        switch (error2) {
                            case 1:
                                promociones[cantidadDescuento].mes = JOptionPane.showInputDialog("**MES DE LA PROMOCIÓN*");
                                break;
                            case 2:
                                promociones[cantidadDescuento].nombreDescuento = JOptionPane.showInputDialog("**DIGITE EL NOMBRE/MOTIVO DEL DESCUENTO**");
                                break;
                            case 3:
                                promociones[cantidadDescuento].valorDescuento = Float.parseFloat(JOptionPane.showInputDialog("**DIGITE EL MONTO DE DESCUENTO**"));
                                break;
                            case 4:
                                promociones[cantidadDescuento].codigo = JOptionPane.showInputDialog("**AGREGUE UN CÓDIGO PARA EL DESCUENTO**");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "DIGITE UNA OPCIÓN VALIDA", "**OPCION INCORRECTA**", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                        error3 = Byte.parseByte(JOptionPane.showInputDialog(promociones[cantidadDescuento].mes + "\n" + promociones[cantidadDescuento].nombreDescuento + "\n"
                                + promociones[cantidadDescuento].valorDescuento + "\n"
                                + promociones[cantidadDescuento].codigo + "\n\n¿CONFIRMAR CAMBIO?\n\nSI    NO\n1      2"));

                    } while (error3 != 1);
                }
                if (error == 1) {
                    error = Byte.parseByte(JOptionPane.showInputDialog(promociones[cantidadDescuento].mes + "\n" + promociones[cantidadDescuento].nombreDescuento + "\n"
                            + promociones[cantidadDescuento].valorDescuento + "\n"
                            + promociones[cantidadDescuento].codigo + "\n\n¿Algún otro cambio?\n\nSI    NO\n1      2"));
                }
            } while (error != 2);

            cantidadDescuento++;
            agregarDescuento = Byte.parseByte(JOptionPane.showInputDialog("¡DESEA AGREGAR OTRO DESCUENTO?\n\nSI    NO\n1      2"));

        } while (agregarDescuento != 2);

        agregar = true;
        mostrarPromociones(agregar);
    }

    public void eliminarPromocion() {
        if (cantidadDescuento != 0) {
            byte opcionEliminar = 0;

            do {
                opcionEliminar = Byte.parseByte(JOptionPane.showInputDialog(cadena + "DIGITE LA OPCION A ELIMINAR"));
                opcionEliminar--;
                if (opcionEliminar >= 0 && opcionEliminar <= cantidadDescuento) {

                    for (int i = opcionEliminar; i < cantidadDescuento - 1; i++) {
                        promociones[i] = promociones[i + 1];
                    }
                    promociones[promociones.length - 1] = null;
                    cantidadDescuento--;
                    vueltasDescuentos--;

                    cadena = "";
                    for (int i = 0; i < cantidadDescuento; i++) {
                        cadena += "Promoción " + (i + 1)
                                + "\n"
                                + promociones[i].mes + "\n"
                                + promociones[i].nombreDescuento + "\n"
                                + promociones[i].valorDescuento + "\n"
                                + promociones[i].codigo + "\n\n";
                    }
                }
            } while (opcionEliminar < 0 && opcionEliminar > cantidadDescuento);

        } else {
            JOptionPane.showMessageDialog(null, "No hay promociones disponibles", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
