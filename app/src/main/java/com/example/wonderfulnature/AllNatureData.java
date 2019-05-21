package com.example.wonderfulnature;

import java.util.ArrayList;

public class AllNatureData {
    public static String [][] data = new String[][] {
            {"Angel Falls, Venezuela", "The world's highest waterfall—the 3,212-foot cascades of Angel Falls", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/SaltoAngel4.jpg/330px-SaltoAngel4.jpg"},
            {"Antartica", "Antarctica is nearly twice the size of Australia", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Adelie_Penguins_on_iceberg.jpg/330px-Adelie_Penguins_on_iceberg.jpg"},
            {"Antelope Canyon, Arizona", "The narrow, undulating spaces between rock formations", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/USA_Antelope-Canyon.jpg/330px-USA_Antelope-Canyon.jpg"},
            {"Atacama Desert, Chile", "Years of erosion have left behind jagged peaks","https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Snow_Comes_to_the_Atacama_Desert.jpg/330px-Snow_Comes_to_the_Atacama_Desert.jpg"},
            {"Arashiyama Bamboo Grove, Japan", "Japanese bamboo garden", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Bamboo_forest_arashiyama.jpg/330px-Bamboo_forest_arashiyama.jpg"},
            {"Avenue of the Baobabs, Madagascar", "Separated from continental Africa by 250 miles of water", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Adansonia_grandidieri_Pat_Hooper.jpg/426px-Adansonia_grandidieri_Pat_Hooper.jpg"},
            {"The Azores, Portugal", "The verdant valleys, steep ocean-side cliffs", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/A%C3%A7ores_2010-07-19_%285047589237%29.jpg/375px-A%C3%A7ores_2010-07-19_%285047589237%29.jpg"},
            {"Banff National Park, Canada", "Banff National Park overwhelms with views of the Canadian Rockies and regular cast of wildlife.", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Moraine_Lake_17092005.jpg/426px-Moraine_Lake_17092005.jpg"},
            {"Boracay, Philippines", "With its gentle coastlines and transporting sunsets", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Boracay_Island%2C_Philippines_-_panoramio.jpg/375px-Boracay_Island%2C_Philippines_-_panoramio.jpg"},
            {"Boulders Beach, South Africa", "Located on the False Bay Coastline, about 17 miles south of Table Mountain", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Ping%C3%BCinos_de_El_Cabo_%28Spheniscus_demersus%29%2C_Playa_de_Boulders%2C_Simon%27s_Town%2C_Sud%C3%A1frica%2C_2018-07-23_PAN_35-38.jpg/384px-Ping%C3%BCinos_de_El_Cabo_%28Spheniscus_demersus%29%2C_Playa_de_Boulders%2C_Simon%27s_Town%2C_Sud%C3%A1frica%2C_2018-07-23_PAN_35-38.jpg"}
    };
    public static ArrayList<Nature> getDataNature() {
        Nature nature = null;
        ArrayList<Nature> list = new ArrayList<>();
        for (String[] natureData: data) {
            nature = new Nature();
            nature.setThe_title(natureData[0]);
            nature.setShort_description(natureData[1]);
            nature.setPhoto(natureData[2]);

            list.add(nature);
        }
        return list;
    }
}
