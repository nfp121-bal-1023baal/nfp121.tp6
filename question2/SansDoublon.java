package question2;

import question1.*;
import java.util.*;



public class SansDoublon implements Visiteur<Boolean>{
    
    
    
    
  public Boolean visite(Contributeur c){
      return c.solde()>= 0;
  }
  
  public Boolean visite(GroupeDeContributeurs g){
    boolean res = false;
    if(g.nombreDeCotisants()>0)
     {  
         
         List<Cotisant> diffCon =sansDoublon(g);
         
        for(Cotisant c : diffCon)
        { 
            if(c.accepter(this))
            { res= true;} 
        } 
        
     }
        return res;
  }
  
  public List<Cotisant> sansDoublon(Cotisant g)
  {
       List<Cotisant> diffCon = new ArrayList<Cotisant>();
         
             
       if(g instanceof Contributeur )
       {
           Contributeur con = (Contributeur)g;
           
                for(Cotisant c : diffCon)
                {
                    if(c.nom().equals(con.nom())) break;
                    else  
                         {diffCon.add(con);}
                }
          
       }
       else if(g instanceof GroupeDeContributeurs)
       {
           GroupeDeContributeurs gc = (GroupeDeContributeurs) g;
           Iterator<Cotisant> it = gc.iterator();
           while(it.hasNext())
           {
             
               Cotisant t = it.next();
              
              if(diffCon.contains(t)) break;
                for(Cotisant c : diffCon)
                {
                    if(c.nom().equals(gc.nom())) break;
                    else  
                         {sansDoublon(gc);}
                }
           }
       }
    
        return diffCon;
    }
}