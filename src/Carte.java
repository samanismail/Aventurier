package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Carte {
    private char[][] tableau; //un tableau de caractères à deux dimensions
    private int xMax;//nombre de lignes maximal
    private int yMax; //nombre de colonnes maximal

    // Constructeur
    public Carte(String fichier) {
        try {
            chargerCarte(fichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Carte chargée avec succès");
    }

    //getters
    public char[][] getTableau() {return tableau;}
    public int getxMax() {return xMax;}
    public int getyMax() {return yMax;}

    //Méthode qui permet de charger la carte à partir d'un fichier
    public void chargerCarte(String fichier) throws IOException {

        Path of = Path.of(fichier);//on crée un objet Path à partir du nom du fichier
        BufferedReader br = Files.newBufferedReader(of, StandardCharsets.UTF_8);//on ouvre le fichier de la carte
        String ligne;//variable qui va contenir les lignes du fichier

        //initialisation des variables
        xMax = 0;
        yMax = 0;

        //on lit le fichier ligne par ligne pour déterminer le nombre de lignes et de colonnes
        while ((ligne = br.readLine()) != null) {
            xMax++;
            yMax = ligne.length();
        }

        br.close();//on ferme le fichier

        tableau = new char[xMax][yMax];//on crée le tableau de caractères à deux dimensions de la bonne taille

        br = Files.newBufferedReader(of, StandardCharsets.UTF_8);//on rouvre le fichier

        //on lit le fichier ligne par ligne pour remplir le tableau de caractères
        int i = 0;//indice de ligne
        while ((ligne = br.readLine()) != null) {
            for (int j = 0; j < yMax; j++) {
                tableau[i][j] = ligne.charAt(j);//on remplit le tableau de caractères avec les caractères du fichier
            }
            i++;
        }

        br.close();//on referme le fichier

    }
    //Méthode qui permet d'afficher la carte
    public void afficherCarte() {
        for (int i = 0; i <xMax; i++) {
            for (int j = 0; j < yMax; j++) {
                System.out.print(tableau[i][j]);//on affiche le caractère à la position i,j
            }
            System.out.println();//on passe à la ligne suivante
        }
    }


}
