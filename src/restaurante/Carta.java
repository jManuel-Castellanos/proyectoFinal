package restaurante;

import javax.swing.JOptionPane;

public class Carta {

    private Carta carta[] = new Carta[4];
    //ATRIBUTOS
    private String nomComida;
    private String nomBebida;
    private String descripcion;
    private float precioComida;
    private float precioBebida;

    //VARIABLES GLOBALES
    private String comida = "";
    private String bebida = "";
    private boolean definido = false;
    private boolean cambio = false;

    private String pedidoComida = "";
    private String pedidoBebida = "";
    private float totalComida = 0;
    private float totalBebida = 0;

    public Carta(String nomComida, String nomBebida, float precioBebida, float precioComida, String descripcion) {
        this.nomComida = nomComida;
        this.nomBebida = nomBebida;
        this.descripcion = descripcion;
        this.precioBebida = precioBebida;
        this.precioComida = precioComida;
    }

    public String getPedidoComida() {
        return pedidoComida;
    }

    public String getPedidoBebida() {
        return pedidoBebida;
    }

    public float getTotalComida() {
        return totalComida;
    }

    public float getTotalBebida() {
        return totalBebida;
    }

    public void mostrarCarta(int opcion, int opcion2, int opcion3, boolean cambio) {
        //ENTRA SI AUN NO ESTÁ DEFINIDO EL ARREGLO
        if (!definido) {
            carta[0] = new Carta("La Básica", "Coca Cola", 750f, 1000f,
                    "Una torta, queso amarillo, queso blanco, pepinillos y salsa de tomate");

            carta[1] = new Carta("La Doble", "Fanta Naranja", 650f, 1500f,
                    "Una torta, queso amarillo, queso blanco, pepinillos y salsa de tomate");

            carta[2] = new Carta("La Tres Pisos", "Sprite", 525f, 2500f,
                    "Triple torta, doble queso amarillo, pepinillos, bacon, salsa de tomate y mostaza");

            carta[3] = new Carta("La Cochina", "Limonada", 400f, 3350f,
                    "Triple torta doble queso amarillo, doble queso blanco, papas tostadas, triple bacon y chipotle");

            for (int i = 0; i < carta.length; i++) {
                comida += (i + 1) + ". " + carta[i].nomComida + ": " + carta[i].precioComida + " colones" + "\nDescripción: " + carta[i].descripcion + "\n\n";
                //JOptionPane.showInputDialog(null,"SODA DON PEPE\n\nMENÚ DISPONIBLE\n\nCOMIDAS\n"+carta[i].nomComida+"\nDescripción: "+carta[i].descripcion+"\n\nBEBIDAS\n"+carta[i].nomBebida);
            }

            for (int i = 0; i < carta.length; i++) {
                bebida += (i + 1) + ". " + carta[i].nomBebida + ": " + carta[i].precioBebida + " colones\n\n";
            }
            definido = true;
        }

        //ENTRA CUANDO EXISTE UN CAMBIO
        if (cambio) {
            switch (opcion) {
                case 1: //En caso de querer cambiar las comidad
                    comida = "";

                    for (int i = 0; i < carta.length; i++) {
                        comida += (i + 1) + ". " + carta[i].nomComida + ": " + carta[i].precioComida + " colones" + "\nDescripción: " + carta[i].descripcion + "\n\n";

                    }
                    break;
                case 2: //en caso de querer cambiar las bebidas

                    bebida = "";

                    for (int i = 0; i < carta.length; i++) {
                        bebida += (i + 1) + ". " + carta[i].nomBebida + ": " + carta[i].precioBebida + " colones" + "\n\n";

                    }
                    break;
            }

        }
        //ENTRA SI NO EXISTE NINGUN CAMBIO
        if (!cambio) {
            JOptionPane.showMessageDialog(null, "               SODA DON PEPE\n\nMENÚ DISPONIBLE\n\nCOMIDAS\n" + comida + "BEBIDAS\n\n" + bebida);
        }
    }

    public void modificarCarta() {
        int opcion = 0;   //Elegir entre comida y bebida
        int opcion2 = 0;    //Elegir entre nombre, precio y descripcion
        int opcion3 = 0;    //Elegir el elemento a cambiar

        //ENTRA SI EL ARREGLO NO ESTÁ DEFINIDO
        if (!definido) {
            mostrarCarta(opcion, opcion2, opcion3, true);
        }

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(comida + bebida + "\n\n¿Qué desea cambiar?\n1.Comidas        2.Bebidas"));
        } while (opcion != 1 && opcion != 2);

        //OPCIONES DE CAMBIAR COMIDA
        if (opcion == 1) {

            do {
                opcion2 = Integer.parseInt(JOptionPane.showInputDialog(comida + "\n\n¿Qué opcion desea cambiar?\n1. Nombre\n2. Precio\n3. Descripción"));
            } while (opcion2 != 1 && opcion2 != 2 && opcion2 != 3);

            switch (opcion2) {
                case 1:

                    do {
                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(comida + "\n\n¿Digite la opcion a cambiar"));
                    } while (opcion3 < 0 || opcion3 > carta.length);

                    for (int i = 0; i < carta.length; i++) {
                        if ((opcion3 - 1) == i) {
                            carta[i].nomComida = JOptionPane.showInputDialog("¿Digite el nuevo nombre de la comida");

                        }
                    }
                    cambio = true;
                    break;
                case 2:

                    do {
                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(comida + "\n\n¿Digite la opcion a cambiar"));
                    } while (opcion3 < 0 || opcion3 > carta.length);

                    for (int i = 0; i < carta.length; i++) {
                        if ((opcion3 - 1) == i) {
                            carta[i].precioComida = Float.parseFloat(JOptionPane.showInputDialog("¿Digite el nuevo precio de la comida"));

                        }
                    }
                    cambio = true;
                    break;
                case 3:

                    do {
                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(comida + "\n\n¿Digite la opcion a cambiar"));
                    } while (opcion3 < 0 || opcion3 > carta.length);

                    for (int i = 0; i < carta.length; i++) {
                        if ((opcion3 - 1) == i) {
                            carta[i].descripcion = JOptionPane.showInputDialog("¿Digite la nueva descripcion de la comida");

                        }
                    }
                    cambio = true;
                    break;
            }
            //OPCIONES DE CAMBIAR BEBIDAS
        } else {
            do {
                opcion2 = Integer.parseInt(JOptionPane.showInputDialog(bebida + "\n\n¿Qué opcion desea cambiar?\n1. Nombre\n2. Precio"));
            } while (opcion2 != 1 && opcion2 != 2);
            switch (opcion2) {

                case 1:
                    do {
                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(bebida + "\n\n¿Digite la opcion a cambiar"));
                    } while (opcion3 < 0 || opcion3 > carta.length);

                    for (int i = 0; i < carta.length; i++) {
                        if ((opcion3 - 1) == i) {
                            carta[i].nomBebida = JOptionPane.showInputDialog("¿Digite el nuevo nombre de la comida");
                        }
                    }
                    cambio = true;
                    break;

                case 2:
                    do {
                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(bebida + "\n\n¿Digite la opcion a cambiar"));
                    } while (opcion3 < 0 || opcion3 > carta.length);

                    for (int i = 0; i < carta.length; i++) {
                        if ((opcion3 - 1) == i) {
                            carta[i].precioBebida = Float.parseFloat(JOptionPane.showInputDialog("¿Digite el nuevo precio de la comida"));

                        }
                    }
                    cambio = true;
                    break;

            }
        }
        mostrarCarta(opcion, opcion2, opcion3, true);
    }

}
