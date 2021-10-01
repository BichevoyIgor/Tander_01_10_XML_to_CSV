package com.github;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Article> articles = new XMLReader().readXML("output.xml");

        CSVWriter writer = new CSVWriter(new FileWriter("test.csv"), ',',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);

        for (Article article : articles) {
            String[] art = {String.valueOf(article.getId_art()),
                    article.getName(),
                    article.getCode(),
                    article.getUserName(),
                    article.getGuid()};
            writer.writeNext(art);
        }
        writer.close();
    }
}
