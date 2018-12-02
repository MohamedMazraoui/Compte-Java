/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SiMo
 */
public class CompteService extends AbstractFacade<Compte> {

    public CompteService() {
        super(Compte.class);
    }

    public Compte ouvrirCompte(String rib, double solde) {

        Compte c1 = new Compte();

        c1.setRib(rib);
        c1.setSolde(solde);
        c1.setOuvert(true);
        if (solde > 0 && solde <= 2000) {
            c1.setClasse('c');
        }
        if (solde > 2000 && solde <= 5000) {
            c1.setClasse('b');
        }
        if (solde > 5000) {
            c1.setClasse('a');
        }
        create(c1);
        return c1;

    }

    public int fermerCompte(String rib) {

        Compte c1 = find(rib);
        if (rib == null) {
            return -3;
        } else if (c1.isOuvert() == false) {
            return -1;
        } else if (c1.getSolde() != 0) {
            return -2;
        } else {
            c1.setOuvert(false);
            edit(c1);
            return 1;
        }
    }

    public int debiter(Compte c, double montant) {

        if (c.isOuvert() == false) {
            return -1;
        } else {
            double nvsolde = c.getSolde() + montant;
            c.setSolde(nvsolde);
            edit(c);
            return 1;
        }
    }

    public int debiter1(String rib, double montant) {
        Compte c = find(rib);
        if (c.isOuvert() == false) {
            return -1;
        } else if (c.getSolde() < montant) {
            return -2;
        } else {
            double nvsolde = c.getSolde() + montant;
            c.setSolde(nvsolde);
            edit(c);
            return 1;
        }
    }

    public int crediter(Compte c, double montant) {

        if (c.isOuvert() == false) {
            return -1;
        } else if (c.getSolde() < montant) {
            return -2;
        } else {
            double nvsolde = c.getSolde() - montant;
            c.setSolde(nvsolde);
            edit(c);
            return 1;
        }

    }

    public int transfer(Compte c1, Compte c2, double montant) {
        //List<Compte> cs = findAll();
        if (c1.isOuvert() == false && c2.isOuvert() == false) {
            return -1;
        } else if (c1.getSolde() < montant) {
            return -2;
        } else {
            double solde1 = c1.getSolde() - montant;
            double solde2 = c2.getSolde() + montant;
            c1.setSolde(solde1);
            c2.setSolde(solde2);
            edit(c1);
            edit(c2);
            return 1;
        }
    }

    public int fermerCompte() {
        int compterur = 0;
        List<Compte> cs = findAll();
        for (int i = 0; i < cs.size(); i++) {
            Compte c = cs.get(i);
            if (c.getSolde() == 0 && c.isOuvert()) {
                c.setOuvert(false);
                edit(c);
                compterur++;
            }
        }
        return compterur;
    }

    public List<Compte> findBySolde(double soldeMin) {
        List<Compte> cs = findAll();
        List<Compte> res = new ArrayList();
        for (int i = 0; i < cs.size(); i++) {
            Compte c = cs.get(i);
            if (c.getSolde() >= soldeMin) {
                res.add(c);
            }
        }
        return res;

    }

    public int findByRIb(String rib) {
        List<Compte> cs = findAll();
        for (int i = 0; i < cs.size(); i++) {
            Compte c = cs.get(i);
            if (c.getRib().equals(rib)) {
                return 1;
            }
        }
        return -1;
    }

    public int findByClasse(char classe) {
        List<Compte> cs = findAll();
        for (int i = 0; i < cs.size(); i++) {
            Compte c = cs.get(i);
            if (c.getClasse() == classe) {
                return 1;
            }
        }
        return -1;
    }

    public int findIndexByRIb(String rib) {
        List<Compte> cs = findAll();
        for (int i = 0; i < cs.size(); i++) {
            Compte c = cs.get(i);
            if (c.getRib().equals(rib)) {
                return i;
            }
        }
        return -1;
    }

    public int deleteByRib(String rib) {
        List<Compte> cs = findAll();
        for (int i = 0; i < cs.size(); i++) {
            Compte c = cs.get(i);
            if (c.getRib().equals(rib)) {
                cs.remove(c);
            }
        }
        return -1;
    }
}
