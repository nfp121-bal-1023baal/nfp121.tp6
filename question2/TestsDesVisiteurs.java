package question2;

import java.util.*;
import question1.*;

public class TestsDesVisiteurs extends junit.framework.TestCase{

    public void testACompleter(){
        Contributeur c = new Contributeur("c",100);
        GroupeDeContributeurs g = new GroupeDeContributeurs("g");
        g.ajouter(c);
        
        CompositeValide visitor1= new CompositeValide();
        SansDoublon visitor2= new SansDoublon();
        DebitMaximal visitor3= new DebitMaximal();
        
        visitor1.visite(g);
        visitor2.visite(g);
        visitor3.visite(g);
        
        visitor1.visite(c);
       visitor2.visite(c);
        visitor3.visite(c);
        
        
//        fail(" cette méthode de tests, est à compléter, appels des trois visiteurs....");
    }



    public void testCompositeValide(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

            g1.ajouter(new Contributeur("c",100));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));

        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testTroisContributeursUnGroupe(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
            assertEquals(" Revoyez DébitMaximal !!!", new Integer(100), g.accepter(new DebitMaximal()));
            GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
            g.ajouter(g1);
            assertFalse(" Ce composite n'est pas valide, revoyez CompositeValide !!!", g1.accepter(new CompositeValide()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }

    public void testUnContributeurUnGroupeAvecLeMemeNom(){
        try{
            GroupeDeContributeurs g = new GroupeDeContributeurs("g_a");
            g.ajouter(new Contributeur("g_a",100));
            g.ajouter(new Contributeur("g_b",200));
            g.ajouter(new Contributeur("g_c",300));
            g.ajouter(new Contributeur("g_d",80));
            assertTrue(" Ce composite est valide, revoyez CompositeValide !!!", g.accepter(new CompositeValide()));
            assertFalse(" Ce composite a au moins un doublon, revoyez SansDoublon !!!", g.accepter(new SansDoublon()));
        }catch(Exception e){
            fail("exception inattendue !!! " + e.getMessage());
        }
    }
}

