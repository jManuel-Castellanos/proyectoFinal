package restaurante;

import javax.swing.JOptionPane;

public class Empleado {

    private String nombre;
    private String clave;
    private boolean estado = false;
    private String nombres[] = {"Pedro Jimenez", "Ernesto Salazar", "Alejandro Pérez", "Alez Rodriguez"};
    private String claves[] = {"ABCD", "ZZZZ", "AAAA", "BBBB"};

    public Empleado(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public Empleado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void verificar() {
        int vueltas = 3;

        do {
            clave = JOptionPane.showInputDialog("[ACCESO RESTRINGIDO]\n\nDIGITE SU CLAVE DE ACCESO AL SISTEMA: ").toUpperCase();

            for (int i = 0; i < claves.length; i++) {
                if (clave.equals(claves[i])) {
                    JOptionPane.showMessageDialog(null, "ACCESO PERMITIDO\n\nBienvenido " + nombres[i]);
                    estado = true;
                    vueltas = 0;
                }
            }
            if (estado == false) {
                JOptionPane.showMessageDialog(null, "Intentos restantes: " + (vueltas - 1), "[ACCESO DENEGADO]", JOptionPane.ERROR_MESSAGE);
                vueltas--;
            }

        } while (vueltas != 0);

    }
}
