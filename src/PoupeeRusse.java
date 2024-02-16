import java.util.ArrayList;

public class PoupeeRusse extends Poupee{

    private String color;

    public PoupeeRusse(int size) {
        super(size);
    }
    public PoupeeRusse(){};

    @Override
    public void ouvrir(Poupee p) {
           p.setOpened(true);
    }

    @Override
    public void fermer(Poupee p) {
        p.setOpened(false);
    }

    @Override
    public boolean placerDans(Poupee p) {
        if(this.getSize()>=p.getSize())
        {
            System.out.println("impossible de placer la poupee de la taille "+this.getSize()+" dans la poupee de la taille "+p.getSize());
            return false;
        }
        else if(p.getContient()!=null){
            System.out.println("Cette poupe contient une autre poupe");
            return false;
        }
        else {
            ouvrir(p);
            p.setContient(this);
            fermer(p);
            System.out.println("La poupee avec la taille "+this.getSize()+" a été placee avec succées dans la poupee de la taille "+p.getSize());
        }
        return false;
    }

    @Override
    public boolean sortirDe(Poupee p) {
        if(this.getSize()!=p.getContient().getSize())
        {
            System.out.println("la poupee de la taille "+p.getSize()+" ne contient pas la poupee de la taille "+this.getSize());
            return false;
        }
        else {
            ouvrir(p);
            p.setContient(null);
            fermer(p);
            System.out.println("La poupee avec la taille "+this.getSize()+" a été sortir avec succées de la poupee de la taille "+p.getSize());
        }
        return false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void createPoupees(int number,ArrayList<PoupeeRusse> Poupees){
        int size,year;
        String color;
        for (int i=0;i<number;i++)
        {
            System.out.println("Poupee "+(i+1)+" :");
            System.out.print("\tEntrer la taille de la poupee "+(i+1)+" :");size=Main.scanner.nextInt();
            for(PoupeeRusse poupee :Poupees){
                while(poupee.getSize()==size)
                {
                    System.out.println("\tIl y a une autre poupee avec cette taille !! Ressayer avec une autre taille ");
                    System.out.print("\tEntrer la taille de la poupee "+(i+1)+" :");size=Main.scanner.nextInt();
                }
            }
            System.out.print("\tEntrer l' année de fabrication de la poupee "+(i+1)+" :");year=Main.scanner.nextInt();
            System.out.print("\tEntrer la couleur de la poupee "+(i+1)+" :");color=Main.scanner.next();
            PoupeeRusse poupee = new PoupeeRusse(size);
            poupee.setFabricationYear(year);
            poupee.setColor(color);
            Poupees.add(poupee);
        }
        System.out.println("Les poupées sont créé avec succées");
    }
    public PoupeeRusse searchPoupee(int size,ArrayList<PoupeeRusse> Poupees)
    {
        for(PoupeeRusse poupee :Poupees){
            if(poupee.getSize()==size)
            {
                return poupee;
            }
        }
        return null;
    }
    public void afficherPoupeerRusse(ArrayList<PoupeeRusse> Poupees)
    {
        int i=0;
        for(PoupeeRusse poupee :Poupees){
            System.out.println("Poupée : "+(i+1));
            System.out.println("\tTaille : "+poupee.getSize());
            System.out.println("\tAnnée de fabrication : "+poupee.getFabricationYear());
            System.out.println("\tColor : "+poupee.getColor());
            i++;
        }
    }
    public void showCollection(ArrayList<PoupeeRusse> Poupees){
        for(PoupeeRusse poupee :Poupees){
            if(poupee.getContient()!=null){
                System.out.println("\tPoupée de la taille "+poupee.getSize()+" contient la poupée de la taille "+poupee.getContient().getSize());
            }
        }
    }

}
