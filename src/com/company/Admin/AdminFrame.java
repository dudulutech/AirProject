package com.company.Admin;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class AdminFrame extends JFrame {

    MainMenu mainMenu;
    AddPanel addPanel;
    EditPanel editPanel;
    Aircrafts aircrafts;
    Cities cities;
    Flights flights;
    DeletePanel deletePanel;
    Aircraftsdelete aircraftsdelete;
    Citiesdelete citiesdelete;
    Flightsdelete flightsdelete;
    ObjectOutputStream ous;
    EditAircraftParameter editAircraftParameter;
    EditAircraftString editAircraftString;
    EditAircraftInt editAircraftInt;
    EditCitiesParameter editCitiesParameter;
    EditCitiesInt editCitiesInt;
    EditCitiesString editCitiesString;
    EditFlightsParameter editFlightsParameter;
    EditFligtsInt editFligtsInt;
    EditFligtsString editFligtsString;
    EditFlightAircraftID editFlightAircraftID;
    EditFlightsArrivalCityID editFlightsArrivalCityID;
    EditFlightsDepartureCItyID editFlightsDepartureCItyID;
    Socket socket;

    public AdminFrame(Socket socket) {
        try {
            this.socket = socket;
            ous = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ADMIN");
        setSize(500, 500);
        setLayout(null);

        mainMenu = new MainMenu(this);
        mainMenu.setVisible(true);
        add(mainMenu);

        addPanel = new AddPanel(this);
        addPanel.setVisible(false);
        add(addPanel);

        aircrafts = new Aircrafts(this);
        aircrafts.setVisible(false);
        add(aircrafts);

        cities = new Cities(this);
        cities.setVisible(false);
        add(cities);

        flights = new Flights(this);
        flights.setVisible(false);
        add(flights);

        editPanel = new EditPanel(this);
        editPanel.setVisible(false);
        add(editPanel);

        deletePanel = new DeletePanel(this);
        deletePanel.setVisible(false);
        add(deletePanel);

        aircraftsdelete = new Aircraftsdelete(this);
        aircraftsdelete.setVisible(false);
        add(aircraftsdelete);

        citiesdelete = new Citiesdelete(this);
        citiesdelete.setVisible(false);
        add(citiesdelete);

        flightsdelete = new Flightsdelete(this);
        flightsdelete.setVisible(false);
        add(flightsdelete);

        editAircraftParameter=new EditAircraftParameter(this);
        editAircraftParameter.setVisible(false);
        add(editAircraftParameter);

        editAircraftString=new EditAircraftString(this);
        editAircraftString.setVisible(false);
        add(editAircraftString);

        editAircraftInt=new EditAircraftInt(this);
        editAircraftInt.setVisible(false);
        add(editAircraftInt);

        editCitiesInt=new EditCitiesInt(this);
        editCitiesInt.setVisible(false);
        add(editCitiesInt);

        editCitiesParameter=new EditCitiesParameter(this);
        editCitiesParameter.setVisible(false);
        add(editCitiesParameter);

        editCitiesString=new EditCitiesString(this);
        editCitiesString.setVisible(false);
        add(editCitiesString);

        editFlightsParameter = new EditFlightsParameter(this);
        editFlightsParameter.setVisible(false);
        add(editFlightsParameter);

        editFligtsInt=new EditFligtsInt(this);
        editFligtsInt.setVisible(false);
        add(editFligtsInt);

        editFligtsString=new EditFligtsString(this);
        editFligtsString.setVisible(false);
        add(editFligtsString);

        editFlightAircraftID=new EditFlightAircraftID(this);
        editFlightAircraftID.setVisible(false);
        add(editFlightAircraftID);

        editFlightsArrivalCityID=new EditFlightsArrivalCityID(this);
        editFlightsArrivalCityID.setVisible(false);
        add(editFlightsArrivalCityID);

        editFlightsDepartureCItyID=new EditFlightsDepartureCItyID(this);
        editFlightsDepartureCItyID.setVisible(false);
        add(editFlightsDepartureCItyID);
    }



    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public AddPanel getAddPanel() {
        return addPanel;
    }

    public EditPanel getEditPanel() {
        return editPanel;
    }

    public Aircrafts getAircrafts() {
        return aircrafts;
    }

    public Flights getFlights() {
        return flights;
    }


    public EditAircraftParameter getEditAircraftParameter() {
        return editAircraftParameter;
    }

    public EditAircraftInt getEditAircraftInt() {
        return editAircraftInt;
    }

    public EditAircraftString getEditAircraftString() {
        return editAircraftString;
    }

    public Cities getCities() {
        return cities;

    }

    public EditFlightAircraftID getEditFlightAircraftID() {
        return editFlightAircraftID;
    }

    public EditFlightsArrivalCityID getEditFlightsArrivalCityID() {
        return editFlightsArrivalCityID;
    }

    public EditFlightsDepartureCItyID getEditFlightsDepartureCItyID() {
        return editFlightsDepartureCItyID;
    }

    public EditFlightsParameter getEditFlightsParameter() {
        return editFlightsParameter;
    }
    public EditFligtsInt getEditFligtsInt() {
        return editFligtsInt;
    }

    public EditFligtsString getEditFligtsString() {
        return editFligtsString;
    }
    public EditCitiesParameter getEditCitiesParameter() {
        return editCitiesParameter;
    }

    public EditCitiesInt getEditCitiesInt() {
        return editCitiesInt;
    }

    public EditCitiesString getEditCitiesString() {
        return editCitiesString;
    }

    public DeletePanel getDeletePanel() {
        return deletePanel;
    }

    public Aircraftsdelete getAircraftsdelete() {
        return aircraftsdelete;
    }

    public Citiesdelete getCitiesdelete() {
        return citiesdelete;
    }

    public Flightsdelete getFlightsdelete() {
        return flightsdelete;
    }



    public void DeleteAircraft(Aircraft aircraft) {
        try {
            AircraftPackage ap = new AircraftPackage("DELETE", aircraft);
            ous.writeObject(ap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendAircraft(Aircraft aircraft) throws IOException {
        AircraftPackage ap = new AircraftPackage("ADD", aircraft);
        ous.writeObject(ap);
    }

    public void deleteCities(City cities) {
        CitiesPackage cp = new CitiesPackage("DELETE", cities);
        try {
            ous.writeObject(cp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendCities(City cities) throws IOException {
        CitiesPackage cp = new CitiesPackage("ADD", cities);
        ous.writeObject(cp);
    }

    public void sendFlight(Flight flight) throws IOException {
        try {
            FlightsPackage fp = new FlightsPackage("ADD", flight);
            ous.writeObject(fp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteFlight(Flight flight) {
        try {
            FlightsPackage fp = new FlightsPackage("DELETE", flight);
            ous.writeObject(fp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public ArrayList<Aircraft> sendList(String string) {
            ArrayList<Aircraft> aircrafts = null;
            try {
                ous.writeObject(string);
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                aircrafts = (ArrayList<Aircraft>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return aircrafts;
        }

        public ArrayList<City> sendListC(String string) {
            ArrayList<City> cities = null;
            try {
                ous.writeObject(string);
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                cities = (ArrayList<City>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cities;
        }

        public void EditAircraftInt(String parameter, Aircraft airCraft, int id) {
            try {
                EditAircraftPackage aep = new EditAircraftPackage(parameter, airCraft, id);
                ous.writeObject(aep);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void EditAircraftString(String parameter, Aircraft airCraft, String string) {
            try {
                EditAircraftPackage aep = new EditAircraftPackage(parameter, airCraft, string);
                ous.writeObject(aep);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void EditCitiesInt(String parameter, City city, int id) {
            try {
                EditCitiesPackage ep =new EditCitiesPackage(parameter,city,id);
                ous.writeObject(ep);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void EditCitiesString(String parameter, City city, String string) {
            try {
                EditCitiesPackage ep = new EditCitiesPackage(parameter,city,string);
                ous.writeObject(ep);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            public void FlightEditInt(String parameter,Flight flight, int id){
                try {
                    EditFlightsPackage fep = new EditFlightsPackage(parameter,flight,id);
                    ous.writeObject(fep);
                } catch (IOException e) {
                    e.printStackTrace();
                }
      }
      public void FlightEditString(String parameter,Flight flight,String string){

          try {EditFlightsPackage fep = new EditFlightsPackage(parameter,flight,string);
              ous.writeObject(fep);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      public ArrayList<Flight> sendListF(String string){
        ArrayList<Flight> aircrafts = null;
        try{
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            aircrafts = (ArrayList<Flight>) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return aircrafts;
}

    }

