package com.guy.class22b_and_8;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<Event> generateData() {
        ArrayList<Event> events = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            events.add(generateEvent(i));
        }

        return events;
    }

    private static Event generateEvent(int index) {
        String[] names = new String[]{
                "Keren Wedding",
                "Rom Bar mitsva",
                "Eli Brit",
                "Avi j",
                "Party!"
        };
        Event event = new Event();
        event.setId("E00" + index);
        event.setName(names[index]);


        for (int i = 0; i < 3; i++) {
            Table table = new Table().setNumber(i + 1);

            for (int j = 0; j < 4; j++) {
                table.getGuests().put("G000" + (j+1), new Guest()
                        .setId("G000" + (j+1))
                        .setName("Bob" + i + "-" + j)
                        .setCar(new Car()
                                .setLicense("" + (1111 * j + i))
                                .setColor("Red")
                                .setType(Car.TYPE.SEDAN)
                        )
                );
            }

            event.getTables().put("T" + table.getNumber(), table);
        }

        return event;
    }
}
