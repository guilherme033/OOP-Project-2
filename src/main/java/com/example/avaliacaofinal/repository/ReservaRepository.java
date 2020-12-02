package com.example.avaliacaofinal.repository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.avaliacaofinal.model.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaRepository {
    
private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
private static int next = 1;

public List<Reserva> getAllReservas() {
    return reservas;
}

public Optional<Reserva> getReservaByNumero(long numero) {
    for (Reserva aux : reservas) {
        if (aux.getNumero() == numero) {
            return Optional.of(aux);
        }
    }
    return Optional.empty();
}

public Reserva save(Reserva reserva) {
    reserva.setNumero(next++);
    reservas.add(reserva);
    return reserva;
}

public Optional<LocalDateTime> inicio(LocalDateTime date){
    DayOfWeek dia = date.getDayOfWeek();
        while(dia != DayOfWeek.SUNDAY){
            return Optional.of(date);
        }
    return Optional.empty();
    }

public Optional<LocalDateTime> fim(LocalDateTime beginDate, LocalDateTime endDate){
    DayOfWeek dia = endDate.getDayOfWeek();
        while(dia != DayOfWeek.SUNDAY && beginDate.isBefore(endDate) == true){
            return Optional.of(endDate);
        }
        return Optional.empty();
    }

}
