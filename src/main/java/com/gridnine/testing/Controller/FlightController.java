package com.gridnine.testing.Controller;

import com.gridnine.testing.Model.Flight;
import com.gridnine.testing.Service.Filters.Filter1;
import com.gridnine.testing.Service.Filters.Filter2;
import com.gridnine.testing.Service.Filters.Filter3;
import com.gridnine.testing.Service.FlightBuilder;
import com.gridnine.testing.Service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    private final FlightBuilder flightBuilder;

    public FlightController(FlightService flightService, FlightBuilder flightBuilder) {
        this.flightService = flightService;
        this.flightBuilder = flightBuilder;
    }

    @GetMapping("/init")
    public String initFlights() {
        flightBuilder.createFlights();
        System.out.println("Список полётов создан");
        return "Список полётов создан";
    }

    @GetMapping("/printall")
    public String printAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        System.out.println("Все перелёты:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        return "Список всех рейсов выведен в консоль";
    }

    @GetMapping("/filter1")
    public String filter1Flights() {
        Filter1 filter = new Filter1();
        List<Flight> flights = filter.filter1(flightService);
        System.out.println("Рейсы с датой вылета раньше текущего времени:");
        System.out.println(flights);
        return "Рейсы с датой вылета раньше текущего времени выведены в консоль";
    }

    @GetMapping("/filter2")
    public String filter2Flights() {
        Filter2 filter = new Filter2();
        List<Flight> flights = filter.filter2(flightService);
        System.out.println("Рейсы с датой прилёта раньше даты вылета:");
        System.out.println(flights);
        return "Рейсы с датой прилёта раньше даты вылета выведены в консоль";
    }

    @GetMapping("/filter3")
    public String filter3Flights() {
        Filter3 filter = new Filter3();
        List<Flight> flights = filter.filter3(flightService);
        System.out.println("Рейсы со временем нахождения на земле более двух часов:");
        System.out.println(flights);
        return "Рейсы со временем нахождения на земле более двух часов выведены в консоль";
    }
}
