package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Jeu {
    public static void main (String[] args) throws IOException {

        Carte carte = new Carte("Cartes/carte1.txt");//creation de la carte à partir d'un fichier texte

        BufferedReader reader = Files.newBufferedReader(Path.of("tests/test1.txt"), StandardCharsets.UTF_8);//ouverture du fichier test

        String line = reader.readLine();//lecture de la première ligne du fichier test

        int persoPosX = Integer.parseInt(line.split(",")[0]);//récupération de x
        int persoPosY = Integer.parseInt(line.split(",")[1]);//récupération de y

        Personnage personnage = new Personnage(carte, persoPosX, persoPosY);//création du personnage

        String directions = reader.readLine();//lecture de la deuxième ligne du fichier test pour récupérer les directions

        personnage.deplacer(directions);//déplacement du personnage en fonction des directions

        reader.close();//fermeture du fichier test
    }

}
