package restaurante;

import javax.swing.JOptionPane;

public class Menu {

    Cliente cliente1 = new Cliente("", "", "");
    Carta carta1 = new Carta("", "", 0, 0, "");
    Empleado empleado1 = new Empleado("", "");
    Promociones promo = new Promociones("", 0, "", "");
    Reservacion reserva = new Reservacion("", 0, "", 0);

    public void menu() {
        int opcion = 0;
        int opcionClientes = 0;

        if (empleado1.getEstado() == false) {
            empleado1.verificar();
        }

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("--SODA DON PEPE--"
                    + "\n\n1. Opciones de Cliente"
                    + "\n2. Opciones Carta"
                    + "\n3. Agregar Pedido"
                    + "\n4. Reservaciones"
                    + "\n5. Promociones"
                    + "\n6. Salir"));

            switch (opcion) {
                case 1:
                    do {
                        opcionClientes = Integer.parseInt(JOptionPane.showInputDialog("--SODA DON PEPE--"
                                + "\n\n1. Registrar Cliente"
                                + "\n2. Mostrar Clientes"
                                + "\n3. Eliminar Cliente"
                                + "\n4. Regresar"));
                        switch (opcionClientes) {
                            case 1:
                                cliente1.registrarse();
                                break;
                            case 2:
                                cliente1.mostrarClientes();
                                break;
                            case 3:
                                cliente1.eliminarCliente();
                                break;
                            case 4:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "DIGITE UNA OPCIÓN VALIDA", "**OPCION INCORRECTA**", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    } while (opcionClientes != 4);
                    break;
                case 2:
                    do {
                        opcionClientes = Integer.parseInt(JOptionPane.showInputDialog("--SODA DON PEPE--"
                                + "\n\n1. Mostrar Carta"
                                + "\n2. Modificar Carta"
                                + "\n3. Regresar"));
                        switch (opcionClientes) {
                            case 1:
                                carta1.mostrarCarta(0, 0, 0, false);
                                break;
                            case 2:
                                carta1.modificarCarta();
                                break;
                            case 3:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "DIGITE UNA OPCIÓN VALIDA", "**OPCION INCORRECTA**", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    } while (opcionClientes != 3);

                case 3://Agregar Pedido
                    break;
                case 4://Hacer Reservacion
                    do {
                        opcionClientes = Integer.parseInt(JOptionPane.showInputDialog("--SODA DON PEPE--"
                                + "\n\n1. Agregar Reservación"
                                + "\n2. Mostrar Reservaciones"
                                + "\n3. Eliminar Reservación"
                                + "\n4. Regresar"));
                        switch (opcionClientes) {
                            case 1:
                                reserva.agregarReservacion();
                                break;
                            case 2:
                                reserva.mostrarReservaciones(false);
                                break;
                            case 3:
                                reserva.eliminarReservación();
                                break;
                            case 4:

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "DIGITE UNA OPCIÓN VALIDA", "**OPCION INCORRECTA**", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    } while (opcionClientes != 4);
                    break;
                case 5://Promociones
                    do {
                        opcionClientes = Integer.parseInt(JOptionPane.showInputDialog("--SODA DON PEPE--"
                                + "\n\n1. Mostrar Promociones"
                                + "\n2. Agregar Promoción"
                                + "\n3. Eliminar Promoción"
                                + "\n4. Regresar"));
                        switch (opcionClientes) {
                            case 1:
                                promo.mostrarPromociones(false);
                                break;
                            case 2:
                                promo.agregarPromocion();
                                break;
                            case 3:
                                promo.eliminarPromocion();
                                break;
                            case 4:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "DIGITE UNA OPCIÓN VALIDA", "**OPCION INCORRECTA**", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    } while (opcionClientes != 4);
                case 6://Salir
                    break;
            }

        } while (opcion != 6);

    }

}
