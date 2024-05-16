package org.example;

/**
 * La interfaz Invitable define el comportamiento de invitar a una reunión.
 */
public interface Invitable {
        /**
         * Invita a una reunión.
         *
         * @param reunion La reunión a la que se invita.
         */
        void invitar(Reunion reunion);
}