package src;
public class Personnage {
    private final Carte carte;//la carte sur laquelle se trouve le personnage
    private int posX;//position en x du personnage
    private int posY;//position en y du personnage

    // Constructeur
    public Personnage(Carte carte, int x, int y) {
        this.carte = carte;
        setInitialPos(x, y);
    }

    //Méthode qui permet de placer le personnage sur la carte
    private void setInitialPos(int x, int y) {
        //on vérifie que la position est valide c'est à dire que les coordonnées sont dans la carte et que la case n'est pas du bois impénétrable
        if(estValide(x, y)) {
            posX = x;
            posY = y;
            carte.getTableau()[y][x] = 'X';//on place le personnage sur la carte
            System.out.println("Position du personnage : (" + posX + "," + posY + ")");//on affiche la position du personnage
            carte.afficherCarte();//on affiche la carte

        }
        else {
            System.out.println("Position (" + x + "," + y + ") invalide car hors de la carte ou sur une case occupée par du bois impénétrable");
        }
    }

    //Méthode qui permet de déplacer le personnage sur la carte en fonction des directions
    public void deplacer(String directions)
    {
        //on parcourt la chaine de caractères directions
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);//on récupère la direction à l'indice i

            //on initialise les nouvelles coordonnées par les anciennes
            int newPosX = posX;//
            int newPosY = posY;

            //on modifie les nouvelles coordonnées en fonction de la direction
            switch (direction) {
                case 'N' -> newPosY--;
                case 'S' -> newPosY++;
                case 'E' -> newPosX++;
                case 'O' -> newPosX--;
            }
            //on vérifie que les nouvelles coordonnées sont valides
            if(estValide(newPosX, newPosY)) {
                //on garde en mémoire les anciennes coordonnées
                int oldPosX = posX;
                int oldPosY = posY;

                carte.getTableau()[posY][posX] = 'O';//on remplace la case où se trouve le personnage par un O pour indiquer son ancienne position

                //on met à jour les coordonnées du personnage
                posX = newPosX;
                posY = newPosY;

                carte.getTableau()[posY][posX] = 'X';//on place le personnage sur la carte

                //on sépare les affichages pour plus de clarté
                System.out.println();
                System.out.println();

                //on affiche le déplacement : direction et nouvelles coordonnées
                System.out.println("deplacement " + direction+ " en (" + posX + "," + posY + ")");

                carte.afficherCarte();//on affiche la carte

                carte.getTableau()[oldPosY][oldPosX] = ' ';//on remplace la case où se trouvait le personnage par un espace après l'avoir affichée
            }
            else {
                System.out.println("Déplacement impossible car la position (" + newPosX + "," + newPosY + ") est invalide");
            }


        }

    }
    //Méthode qui permet de vérifier si les coordonnées x et y sont valides
    //C'est à dire si elles sont dans la carte et si la case n'est pas du bois
    public boolean estValide(int x, int y) {
        boolean valide = true;//on initialise la variable à true
        if(x < 0 || x >= carte.getxMax() || y < 0 || y >= carte.getyMax()) {//on vérifie que les coordonnées sont dans la carte
            valide = false;
        }
        else if(carte.getTableau()[y][x] == 'B') {//on vérifie que la case n'est pas du bois impénétrable
            valide = false;
        }
        return valide;
    }
}


