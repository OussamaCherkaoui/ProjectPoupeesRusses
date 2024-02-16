import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    PoupeeRusse poupee = new PoupeeRusse();
    ArrayList<PoupeeRusse> Poupees = new ArrayList<>();
    int i=0;

    public void menuJeu()
    {
        int choix;
        System.out.println("------------- QUELLE EST L ETAPE QUE VOULLEZ-VOUS FAIRE -----------------");
        System.out.println("\t1-Placer une poupée dans une poupée");
        System.out.println("\t2-Sortir une poupée d' une poupée");
        System.out.println("\t3-Afficher les poupées de ma collection");
        System.out.println("\t4-Stoper le jeu et revenir vers Menu principal");
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("CHOISISSEZ :");choix=scanner.nextInt();
        choiceMenujeu(choix);
    }
    public void choiceMenujeu(int choix){
        int sizePoupe1,sizePoupe2;
        PoupeeRusse poupe1,poupe2;
        switch (choix)
        {
            case 1 :
                System.out.print("Taille du poupee que vouller-vous placé :");sizePoupe1=scanner.nextInt();
                poupe1=poupee.searchPoupee(sizePoupe1,Poupees);
                while (poupe1==null)
                {
                    System.out.println("Poupee Indiponible !!");
                    System.out.print("Taille du poupee que vouller-vous placé :");sizePoupe1=scanner.nextInt();
                    poupe1=poupee.searchPoupee(sizePoupe1,Poupees);
                }

                System.out.print("Taille de la poupee qui va contient la poupee :");sizePoupe2=scanner.nextInt();
                poupe2=poupee.searchPoupee(sizePoupe2,Poupees);
                while (poupe2==null)
                {
                    System.out.println("Poupee Indiponible !!");
                    System.out.print("Taille de la poupee qui va contient la poupee :");sizePoupe2=scanner.nextInt();
                    poupe2=poupee.searchPoupee(sizePoupe2,Poupees);
                }
                if(!poupe1.placerDans(poupe2));
                {
                    menuJeu();
                }
                menuJeu();
                break;
            case 2 :
                System.out.print("Taille du poupee que vouller-vous sortir :");sizePoupe1=scanner.nextInt();
                poupe1=poupee.searchPoupee(sizePoupe1,Poupees);
                while (poupe1==null)
                {
                    System.out.println("Poupee Indiponible !!");
                    System.out.print("Taille du poupee que vouller-vous sortir :");sizePoupe1=scanner.nextInt();
                    poupe1=poupee.searchPoupee(sizePoupe1,Poupees);
                }

                System.out.print("Taille de la poupee qui contient la poupee :");sizePoupe2=scanner.nextInt();
                poupe2=poupee.searchPoupee(sizePoupe2,Poupees);
                while (poupe2==null)
                {
                    System.out.println("Poupee Indiponible !!");
                    System.out.print("Taille de la poupee qui contient la poupee :");sizePoupe2=scanner.nextInt();
                    poupe2=poupee.searchPoupee(sizePoupe2,Poupees);
                }
                if(!poupe1.sortirDe(poupe2)){
                    menuJeu();
                }
                menuJeu();
                break;
            case 3 :
                System.out.println("------------- Collection -----------------");
                poupee.showCollection(Poupees);
                break;
            case 4 :
                Poupees = new ArrayList<>();
                showMenu();
                break;
            default:
                System.out.println("CHOIX INVALID !!");
                menuJeu();
                break;
        }
    }


    public void showMenu(){
        int nombrePoupee,choix;
        System.out.println("--------------------BIENVENUE SUR LE JEU POUPEE RUSSE---------------");
        System.out.println("\t1-Commencer le jeu");
        System.out.println("\t2-Ajouter des Poupees");
        System.out.println("\t3-Afficher poupee disponible");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("CHOISISSEZ : ");choix=scanner.nextInt();
        switch (choix){
            case 1:
                int size;
                System.out.println("Ok Vous allez commencez le jeu maintenant ...");
                menuJeu();
                break;
            case 2:
                do {
                    System.out.print("Combien de Poupée voulez vous créer ( Min : 2 poupée et Max: 5 poupee ):");nombrePoupee=scanner.nextInt();
                }while ( nombrePoupee>5 || nombrePoupee<=1 );

                poupee.createPoupees(nombrePoupee,Poupees);
                showMenu();
                break;
            case 3:
                poupee.afficherPoupeerRusse(Poupees);
                showMenu();
                break;
            default:
                System.out.println("CHOIX INVALID !! RESSAYER..");
                showMenu();
                break;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

}