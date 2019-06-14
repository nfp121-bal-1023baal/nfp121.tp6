package question2;


import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;
import question1.Cotisant;

public class DebitMaximal implements Visiteur<Integer>{

  public Integer visite(Contributeur c)
  {
    return c.solde();
  }
  
  public Integer visite(GroupeDeContributeurs g)
  {
     if (g.getChildren().size() == 0) {
            return 0;
        }
        int res = ((Cotisant)g.getChildren().get(0)).solde();
        for (int i = 1; i < g.getChildren().size(); ++i) {
            int temp = ((Cotisant)g.getChildren().get(i)).solde();
            if (temp >= res) continue;
            res = temp;
        }
        
        return res;
  
    }
}