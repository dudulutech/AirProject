package com.company.Admin;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class AdminThreadKabyldau extends Thread{
    Socket socket;
    ObjectInputStream ois;
    Connection connection;
    public AdminThreadKabyldau(Socket socket,Connection connection){
        this.connection=connection;
        this.socket=socket;
        try {
          ois = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while (true) {
                try {
                    Object object = ois.readObject();
                    if (object instanceof AircraftPackage) {
                        AircraftPackage ap = (AircraftPackage) object;
                        System.out.println(ap.operationType);
                        if (ap.operationType.equals("ADD")) {
                            AddAircrafts(ap.airCraft);
                        }
                        if (ap.operationType.equals("DELETE")) {
                            DeleteAircrafts(ap.airCraft);
                        }
                            }
                    if (object instanceof CitiesPackage){
                        CitiesPackage cp =(CitiesPackage)object;
                        System.out.println(cp.operationType);
                        if (cp.operationType.equals("ADD")){
                            AddCities(cp.cities);
                        }
                        if (cp.operationType.equals("DELETE")){
                            deleteCities(cp.cities);
                        }
                    }
                    if (object instanceof String ){
                        if (object.equals("aircrafts")){
                            ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                            ous.writeObject(AircraftData());
                        }
                        if (object.equals("cities")){
                            ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                            ous.writeObject(CityData());
                        }if(object.equals("flights")){
                            ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                            ous.writeObject(FlightData());
                        }
                    }
                    if (object instanceof FlightsPackage){
                        FlightsPackage fp =(FlightsPackage) object;
                        System.out.println(fp.operationType);
                        if (fp.operationType.equals("ADD")){
                            AddFlights(fp.flight);
                        }if (fp.operationType.equals("DELETE")){
                            deleteFlights(fp.flight);
                        }
                    }
                    if(object instanceof EditAircraftPackage){
                        EditAircraftPackage aep = (EditAircraftPackage) object;
                        if(aep.parameter.equals("id")) {
                            DeleteAircrafts(aep.airCraft);
                            Aircraft airCraft = new Aircraft(aep.integer, aep.airCraft.name, aep.airCraft.model, aep.airCraft.business_class_capacity, aep.airCraft.econom_class_capacity);
                            AddAircrafts(airCraft);
                        }if(aep.parameter.equals("business_class_capacity")){
                            DeleteAircrafts(aep.airCraft);
                            Aircraft airCraft = new Aircraft(aep.airCraft.id, aep.airCraft.name, aep.airCraft.model, aep.integer, aep.airCraft.econom_class_capacity);
                            AddAircrafts(airCraft);
                        }if(aep.parameter.equals("econom_class_capacity")){
                            DeleteAircrafts(aep.airCraft);
                            Aircraft airCraft = new Aircraft(aep.airCraft.id, aep.airCraft.name, aep.airCraft.model, aep.airCraft.business_class_capacity, aep.integer);
                            AddAircrafts(airCraft);
                        }if(aep.parameter.equals("name")){
                            DeleteAircrafts(aep.airCraft);
                            Aircraft airCraft = new Aircraft(aep.airCraft.id, aep.string, aep.airCraft.model, aep.airCraft.business_class_capacity, aep.airCraft.econom_class_capacity);
                            AddAircrafts(airCraft);
                        }if(aep.parameter.equals("model")){
                            DeleteAircrafts(aep.airCraft);
                            Aircraft airCraft = new Aircraft(aep.airCraft.id, aep.airCraft.name, aep.string, aep.airCraft.business_class_capacity, aep.airCraft.econom_class_capacity);
                            AddAircrafts(airCraft);
                        }
                    }
                    if (object instanceof EditCitiesPackage){
                        EditCitiesPackage ep =(EditCitiesPackage)object;
                        if (ep.parameter.equals("id")){
                            deleteCities(ep.city);
                            City city = new City(ep.integer,ep.city.name,ep.city.country,ep.city.shortname);
                            AddCities(city);
                        }
                        if (ep.parameter.equals("name")){
                            deleteCities(ep.city);
                            City city = new City(ep.city.id,ep.string,ep.city.country,ep.city.shortname);
                            AddCities(city);
                        }
                        if (ep.parameter.equals("country")){
                            deleteCities(ep.city);
                            City city = new City(ep.city.id,ep.city.name,ep.string,ep.city.shortname);
                            AddCities(city);
                        }
                        if (ep.parameter.equals("short_name")){
                            deleteCities(ep.city);
                            City city = new City(ep.city.id,ep.city.name,ep.city.country,ep.string);
                            AddCities(city);
                        }
                    }
                    if(object instanceof EditFlightsPackage){
                        EditFlightsPackage fep = (EditFlightsPackage)object;
                        if(fep.parameter.equals("id")){
                            deleteFlights(fep.flight);
                            Flight flight = new Flight(fep.integer,fep.flight.aircraftid,fep.flight.departureid,fep.flight.arrivalid,fep.flight.departuretime,fep.flight.economprice,fep.flight.businessprice);
                            AddFlights(flight);
                        }if(fep.parameter.equals("departure_time")){
                            deleteFlights(fep.flight);
                            Flight flight = new Flight(fep.flight.id,fep.flight.aircraftid,fep.flight.departureid,fep.flight.arrivalid,fep.string,fep.flight.economprice,fep.flight.businessprice);
                            AddFlights(flight);
                        }if(fep.parameter.equals("econom_place_price")){
                            deleteFlights(fep.flight);
                            Flight flight = new Flight(fep.flight.id, fep.flight.aircraftid,fep.flight.departureid,fep.flight.arrivalid,fep.flight.departuretime,fep.integer,fep.flight.businessprice);
                            AddFlights(flight);
                        }if(fep.parameter.equals("business_place_price")){
                            deleteFlights(fep.flight);
                            Flight flight = new Flight(fep.flight.id, fep.flight.aircraftid,fep.flight.departureid,fep.flight.arrivalid,fep.flight.departuretime,fep.flight.economprice,fep.integer);
                            AddFlights(flight);
                        }
                        if(fep.parameter.equals("aircraft_id")){
                            deleteFlights(fep.flight);
                            Flight flight = new Flight(fep.flight.id, fep.integer,fep.flight.departureid,fep.flight.arrivalid,fep.flight.departuretime,fep.flight.economprice,fep.flight.businessprice);
                            AddFlights(flight);
                        }
                        if(fep.parameter.equals("departure_city_id")){
                            deleteFlights(fep.flight);
                            Flight flight = new Flight(fep.flight.id, fep.flight.aircraftid, fep.integer,fep.flight.arrivalid,fep.flight.departuretime,fep.flight.economprice,fep.flight.businessprice);
                            AddFlights(flight);
                        }
                        if(fep.parameter.equals("arrival_city_id")){
                            deleteFlights(fep.flight);
                            Flight flight = new Flight(fep.flight.id, fep.flight.aircraftid, fep.flight.departureid,fep.integer,fep.flight.departuretime,fep.flight.economprice,fep.flight.businessprice);
                            AddFlights(flight);
                        }
                    }
                } catch (Exception e) {


                }
            }

        }catch (Exception e){

        }
    }
    public void AddAircrafts(Aircraft aircraft){

        try {
            PreparedStatement statement =connection.prepareStatement("INSERT INTO aircrafts(id,name,model,business_class_capacity,econom_class_capacity) VALUES(?,?,?,?,?)");
            statement.setInt(1,aircraft.id);
            statement.setString(2,aircraft.name);
            statement.setString(3,aircraft.model);
            statement.setInt(4,aircraft.business_class_capacity);
            statement.setInt(5,aircraft.econom_class_capacity);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddCities(City cities){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name) VALUES(?,?,?,?)");
            statement.setInt(1,cities.id);
            statement.setString(2,cities.name);
            statement.setString(3,cities.country);
            statement.setString(4,cities.shortname);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Aircraft> AircraftData() {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int business_class_capacity = rs.getInt("business_class_capacity");
                int econom_class_capacity = rs.getInt("econom_class_capacity");
                aircrafts.add(new Aircraft(id, name, model, business_class_capacity, econom_class_capacity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aircrafts;
    }

    public ArrayList<City> CityData() {
        ArrayList<City> cities = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String short_name = rs.getString("short_name");
                cities.add(new City(id, name, country, short_name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
    public void AddFlights(Flight flight){

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) VALUES(?,?,?,?,?,?,?)");
            statement.setInt(1,flight.id);
            statement.setInt(2,(flight.aircraftid));
            statement.setInt(3,(flight.departureid));
            statement.setInt(4,(flight.arrivalid));
            statement.setString(5,flight.departuretime);
            statement.setInt(6,flight.economprice);
            statement.setInt(7,flight.businessprice);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Flight> FlightData(){
        ArrayList<Flight> flights = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM flights");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int aircraft_id = rs.getInt("aircraft_id");
                int departure_city_id = rs.getInt("departure_city_id");
                int arrival_city_id = rs.getInt("arrival_city_id");
                String departure_time = rs.getString("departure_time");
                int econom_place_capacity = rs.getInt("econom_place_price");
                int business_place_price = rs.getInt("business_place_price");
                flights.add(new Flight(id, aircraft_id, departure_city_id, arrival_city_id,departure_time,econom_place_capacity,business_place_price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }
    public void DeleteAircrafts(Aircraft aircraft){

        try {
            PreparedStatement statement=connection.prepareStatement("DELETE FROM aircrafts where id = ?");
            statement.setInt(1,aircraft.id);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteCities(City cities){

        try {
            PreparedStatement statement=connection.prepareStatement("DELETE FROM cities where id = ?");
            statement.setInt(1,cities.id);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteFlights(Flight flight){

        try {
            PreparedStatement statement=connection.prepareStatement("DELETE FROM flights where id = ?");
            statement.setInt(1,flight.id);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

