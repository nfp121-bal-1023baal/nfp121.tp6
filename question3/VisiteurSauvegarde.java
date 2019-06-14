package question3;


import java.util.HashMap;
import question1.*;

public class VisiteurSauvegarde implements question1.Visiteur<HashMap<Cotisant, Integer>>
{
    public HashMap<Cotisant, Integer> visite(Contributeur c)
    {         
        HashMap<Cotisant, Integer> map = new HashMap<Cotisant, Integer>();                             
        Integer solde = new Integer(c.solde());                             
        map.put(c, solde); return map; 
    } 

    public HashMap<Cotisant, Integer> visite(GroupeDeContributeurs g) 
    {                            
        HashMap<Cotisant, Integer> map = new HashMap<Cotisant, Integer>(); 
        for(Cotisant c: g.getChildren()){                             
            HashMap<Cotisant, Integer> m = c.accepter(this);                             
            map.putAll(m); 
        } 
        return map; 
    } 
}
