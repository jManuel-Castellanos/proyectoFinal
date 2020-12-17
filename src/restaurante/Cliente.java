package restaurante;

import javax.swing.JOptionPane;

public class Cliente {

    private Cliente cliente[] = new Cliente[7];
    //Atributos
    private String nombre;
    private String correo;
    private String numero;

    //Variable global
    private int cantidad = 0;
    private int eliminaciones = 0;
    private String cadena = "";

    public Cliente(String nombre, String correo, String numero) {
        this.nombre = nombre;
        this.correo = correo;
        this.numero = numero;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public Cliente[] getCliente() {
        return cliente;
    }

    public void setCliente(Cliente[] cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void registrarse() {
        int opcion = 0;

        //PEDIMOS LOS DATOS DEL CLIENTE
        nombre = JOptionPane.showInputDialog("BIENVENIDO A SODA DON PEPE\n\nDigite su nombre: ");
        correo = JOptionPane.showInputDialog("BIENVENIDO A SODA DON PEPE\n\nDigite su correo: ").toLowerCase();
        do {
            if (!correo.contains("@")) {
                correo = JOptionPane.showInputDialog(null, "Digite de nuevo su correo electrónico", "**CORREO INCORRECTO**", JOptionPane.ERROR_MESSAGE).toLowerCase();
            }
        } while (!correo.contains("@"));

        numero = JOptionPane.showInputDialog("BIENVENIDO A SODA DON PEPE\n\nDigite su número de teléfono: ");
        do {
            if (numero.length() < 8 || numero.length() > 8) {
                numero = JOptionPane.showInputDialog(null, "Digite de nuevo su número telefónico", "**NÚMERO INCORRECTO**", JOptionPane.ERROR_MESSAGE);
            }
        } while (numero.length() != 8);

        //PREGUNTAMOS SI DESEA REALIZAR ALGUN CAMBIO EN LOS DATOS DIGITADOS
        opcion = Integer.parseInt(JOptionPane.showInputDialog("INFORMACION GUARDADA\n\n" + nombre + "\n" + correo + "\n" + numero + "\n\n¿DESEA REALIZAR ALGÚN CAMBIO?"
                + "\nSI    NO\n1    2"));

        while (opcion == 1) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("ELIJA LA OPCION A CAMBIAR: \n1. " + nombre + "\n2. " + correo + "\n3. " + numero));
            switch (opcion) {
                case 1:
                    nombre = JOptionPane.showInputDialog("Digite su nombre correctamente\n(SEA CUIDADOSO)\n ");
                    break;
                case 2:
                    correo = JOptionPane.showInputDialog("Digite su correo correctamente\n(SEA CUIDADOSO)\n ");
                    break;
                case 3:
                    numero = JOptionPane.showInputDialog("Digite su número telefónico correctamente\n(SEA CUIDADOSO)\n ");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "DIGITE UNA OPCIÓN VÁLIDA", "OPCIÓN INCORRECTA", JOptionPane.ERROR_MESSAGE);
                    break;
            }
            opcion = Integer.parseInt(JOptionPane.showInputDialog("INFORMACION GUARDADA\n\n" + nombre + "\n" + correo + "\n" + numero + "\n\n¿DESEA REALIZAR ALGÚN CAMBIO?"
                    + "\nSI    NO\n1    2"));
        }

        cliente[cantidad] = new Cliente(nombre, correo, numero);
        cantidad++;
    }

    public void eliminarCliente() {
        if (cliente[0] != null) {
            int posicion;
            boolean entrar = false;
            cadena = "";
            //String aux;
            for (int i = 0; i < cantidad; i++) {
                cadena += "Cliente Numero " + (i + 1) + "\n" + cliente[i].nombre + "\n" + cliente[i].correo + "\n" + cliente[i].numero + "\n\n";
            }

            posicion = Integer.parseInt(JOptionPane.showInputDialog(cadena + "Digite la posicion a eliminar"));
            posicion--;

            for (int i = posicion; i < cantidad; i++) {
                if (i == (cantidad - 1)) {
                    cliente[i] = null;
                } else {
                    cliente[i] = cliente[i + 1];
                }
                entrar = true;
            }

            if (entrar == true) {
                eliminaciones++;
                cantidad--;
            }
        }
    }

    public void mostrarClientes() {
        cadena = "";
        for (int i = 0; i < cantidad; i++) {
            if (cliente[i] != null) {
                //JOptionPane.showMessageDialog(null, "Cliente Numero " + (i + 1) + "\n" + cliente[i].nombre + "\n" + cliente[i].correo + "\n" + cliente[i].numero + "\n\n");
                cadena += "Cliente Numero " + (i + 1) + "\n" + cliente[i].nombre + "\n" + cliente[i].correo + "\n" + cliente[i].numero + "\n\n";
            }
        }
        JOptionPane.showMessageDialog(null, cadena);

    }

}
