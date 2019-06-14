package question3;

import question1.*;
import java.util.*;

public class Memento {
     // Note : Un usage du patron Memento, 
     //        d’un premier visiteur pour la sauvegarde et 
     //        d’un second pour la restitution du composite, 
     //        représentent une solution possible. 
     private HashMap<Cotisant,Integer> state;
     
     public Memento(Cotisant c) {
       
       state = c.accepter(new VisiteurSauvegarde());
     }

     public void setState(Cotisant c) {
       c.accepter(new VisiteurRestitution(state));
     }
    
    }