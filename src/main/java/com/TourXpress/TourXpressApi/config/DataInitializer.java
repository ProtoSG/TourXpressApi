package com.TourXpress.TourXpressApi.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.TourXpress.TourXpressApi.domain.Bus;
import com.TourXpress.TourXpressApi.domain.City;
import com.TourXpress.TourXpressApi.domain.Customer;
import com.TourXpress.TourXpressApi.domain.Discount;
import com.TourXpress.TourXpressApi.domain.Passenger;
import com.TourXpress.TourXpressApi.domain.Route;
import com.TourXpress.TourXpressApi.domain.Seat;
import com.TourXpress.TourXpressApi.domain.ServiceTerminal;
import com.TourXpress.TourXpressApi.domain.Terminal;
import com.TourXpress.TourXpressApi.domain.Ticket;
import com.TourXpress.TourXpressApi.domain.Transaction;
import com.TourXpress.TourXpressApi.domain.Trip;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (isDatabaseEmpty()) {
            initializeData();
        }
    }

    private boolean isDatabaseEmpty() {
        Long count = entityManager.createQuery("SELECT COUNT(c) FROM City c", Long.class).getSingleResult();
        return count == 0;
    }

    @Transactional
    public void initializeData() {
        // 1. Crear ciudades
        City lima = new City(null, "Lima");
        City arequipa = new City(null, "Arequipa");
        City cusco = new City(null, "Cusco");
        City trujillo = new City(null, "Trujillo");
        City ica = new City(null, "Ica");

        entityManager.persist(lima);
        entityManager.persist(arequipa);
        entityManager.persist(cusco);
        entityManager.persist(trujillo);
        entityManager.persist(ica);

        // 2. Crear terminales
        Terminal terminalLima = new Terminal(null, "Terminal Plaza Norte", "Av. Túpac Amaru, Lima");
        Terminal terminalArequipa = new Terminal(null, "Terminal Terrestre", "Av. Andrés Avelino Cáceres, Arequipa");
        Terminal terminalCusco = new Terminal(null, "Terminal Santiago", "Av. Velasco Astete, Cusco");
        Terminal terminalTrujillo = new Terminal(null, "Terminal EPO", "Av. Nicolás de Piérola, Trujillo");
        Terminal terminalIca = new Terminal(null, "Terminal San Martín", "Av. Municipalidad, Ica");

        entityManager.persist(terminalLima);
        entityManager.persist(terminalArequipa);
        entityManager.persist(terminalCusco);
        entityManager.persist(terminalTrujillo);
        entityManager.persist(terminalIca);

        // 3. Crear buses
        Bus bus1 = new Bus(null, 2, 45);
        Bus bus2 = new Bus(null, 1, 30);
        Bus bus3 = new Bus(null, 2, 50);
        Bus bus4 = new Bus(null, 1, 35);

        entityManager.persist(bus1);
        entityManager.persist(bus2);
        entityManager.persist(bus3);
        entityManager.persist(bus4);

        // 4. Crear servicios
        ServiceTerminal servicioVIP = new ServiceTerminal(null, 25.0, "Servicio VIP - Asientos reclinables, aire acondicionado, snacks");
        ServiceTerminal servicioEconomico = new ServiceTerminal(null, 10.0, "Servicio Económico - Transporte básico");
        ServiceTerminal servicioEjecutivo = new ServiceTerminal(null, 18.0, "Servicio Ejecutivo - Asientos cómodos, aire acondicionado");

        entityManager.persist(servicioVIP);
        entityManager.persist(servicioEconomico);
        entityManager.persist(servicioEjecutivo);

        // 5. Crear rutas
        Route rutaLimaArequipa = new Route(null, lima, arequipa, 65.0);
        Route rutaLimaCusco = new Route(null, lima, cusco, 85.0);
        Route rutaArequipaCusco = new Route(null, arequipa, cusco, 45.0);
        Route rutaLimaTrujillo = new Route(null, lima, trujillo, 35.0);
        Route rutaLimaIca = new Route(null, lima, ica, 25.0);

        entityManager.persist(rutaLimaArequipa);
        entityManager.persist(rutaLimaCusco);
        entityManager.persist(rutaArequipaCusco);
        entityManager.persist(rutaLimaTrujillo);
        entityManager.persist(rutaLimaIca);

        // 6. Crear viajes
        Trip viaje1 = new Trip(null, rutaLimaArequipa, LocalDate.now().plusDays(1), "08:00", 
                              terminalLima, "16:00", terminalArequipa, "Programado", servicioVIP, bus1, 90.0, 40);
        Trip viaje2 = new Trip(null, rutaLimaCusco, LocalDate.now().plusDays(2), "22:00", 
                              terminalLima, "10:00", terminalCusco, "Programado", servicioEjecutivo, bus2, 103.0, 25);
        Trip viaje3 = new Trip(null, rutaLimaIca, LocalDate.now().plusDays(1), "14:00", 
                              terminalLima, "18:00", terminalIca, "Programado", servicioEconomico, bus3, 35.0, 45);

        entityManager.persist(viaje1);
        entityManager.persist(viaje2);
        entityManager.persist(viaje3);

        // 7. Crear asientos para los buses
        createSeatsForBus(bus1);
        createSeatsForBus(bus2);
        createSeatsForBus(bus3);
        createSeatsForBus(bus4);

        // 8. Crear clientes
        Customer cliente1 = new Customer(null, "Juan", "Pérez", LocalDate.of(1985, 3, 15), 
                                        "M", "12345678", "juan.perez@email.com", "987654321");
        Customer cliente2 = new Customer(null, "María", "García", LocalDate.of(1990, 7, 22), 
                                        "F", "87654321", "maria.garcia@email.com", "912345678");
        Customer cliente3 = new Customer(null, "Carlos", "López", LocalDate.of(1982, 11, 8), 
                                        "M", "11223344", "carlos.lopez@email.com", "998877665");

        entityManager.persist(cliente1);
        entityManager.persist(cliente2);
        entityManager.persist(cliente3);

        // 9. Crear pasajeros
        Passenger pasajero1 = new Passenger(null, "Juan", "Pérez", LocalDate.of(1985, 3, 15), "M", "12345678");
        Passenger pasajero2 = new Passenger(null, "María", "García", LocalDate.of(1990, 7, 22), "F", "87654321");
        Passenger pasajero3 = new Passenger(null, "Ana", "Rodríguez", LocalDate.of(1995, 5, 10), "F", "55667788");

        entityManager.persist(pasajero1);
        entityManager.persist(pasajero2);
        entityManager.persist(pasajero3);

        // 10. Crear descuentos
        Discount descuentoEstudiante = new Discount(null, "ESTUDIANTE10", 10.0);
        Discount descuentoAdultoMayor = new Discount(null, "ADULTOMAYOR15", 15.0);
        Discount sinDescuento = new Discount(null, "NINGUNO", 0.0);

        entityManager.persist(descuentoEstudiante);
        entityManager.persist(descuentoAdultoMayor);
        entityManager.persist(sinDescuento);

        // Flush para obtener los IDs generados
        entityManager.flush();

        // 11. Crear transacciones
        Transaction transaccion1 = new Transaction(null, cliente1, sinDescuento, 90.0, 
                                                  "Tarjeta de Crédito", "Completada", LocalDateTime.now());
        Transaction transaccion2 = new Transaction(null, cliente2, descuentoEstudiante, 92.7, 
                                                  "Efectivo", "Completada", LocalDateTime.now().minusDays(1));

        entityManager.persist(transaccion1);
        entityManager.persist(transaccion2);

        entityManager.flush();

        // 12. Crear boletos
        Seat asiento1 = entityManager.createQuery("SELECT s FROM Seat s WHERE s.bus = :bus AND s.seatNumber = 1", Seat.class)
                                   .setParameter("bus", bus1).getSingleResult();
        Seat asiento2 = entityManager.createQuery("SELECT s FROM Seat s WHERE s.bus = :bus AND s.seatNumber = 2", Seat.class)
                                   .setParameter("bus", bus2).getSingleResult();

        Ticket boleto1 = new Ticket(null, viaje1, asiento1, transaccion1, 90.0, LocalDateTime.now());
        Ticket boleto2 = new Ticket(null, viaje2, asiento2, transaccion2, 92.7, LocalDateTime.now().minusDays(1));

        // Asignar pasajeros a los boletos (usando reflection o directamente si hay setter)
        boleto1.setPassenger(pasajero1);
        boleto2.setPassenger(pasajero2);

        entityManager.persist(boleto1);
        entityManager.persist(boleto2);

        // Actualizar disponibilidad de asientos
        asiento1.setAvailable(false);
        asiento2.setAvailable(false);

        System.out.println("=== Base de datos inicializada con datos de prueba ===");
    }

    private void createSeatsForBus(Bus bus) {
        int capacity = bus.getCapacity();
        int floors = bus.getFloor();
        int seatsPerFloor = capacity / floors;
        
        for (int floor = 1; floor <= floors; floor++) {
            for (int seatNum = 1; seatNum <= seatsPerFloor; seatNum++) {
                int globalSeatNumber = ((floor - 1) * seatsPerFloor) + seatNum;
                if (globalSeatNumber <= capacity) {
                    Double seatPrice = getSeatPrice(floor, seatNum);
                    Seat seat = new Seat(null, bus, globalSeatNumber, floor, seatPrice, true);
                    entityManager.persist(seat);
                }
            }
        }
    }

    private Double getSeatPrice(int floor, int seatNumber) {
        if (floor == 1) {
            return seatNumber <= 10 ? 15.0 : 12.0; // Primeras filas más caras
        } else {
            return seatNumber <= 5 ? 20.0 : 18.0; // Segundo piso, primeras filas más caras
        }
    }
}
