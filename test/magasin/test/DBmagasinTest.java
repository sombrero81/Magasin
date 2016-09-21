/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magasin.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import magasin.entity.Categorie;
import magasin.entity.Produit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class DBmagasinTest {
    
    //@Test
    public void testlisteprodcategorie(){
        
        EntityManager em =Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        //52 est un type Long
        Categorie cat = em.find(Categorie.class, 52L);
        for (Produit p:cat.getProduits()){
            
            System.out.println(p);
        }
            
    }
    
    
    @Test
    public void test() {
        EntityManager em =Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        //demarrer une transaction
        em.getTransaction().begin();
        //persister en bases des données
        Categorie c1=new Categorie();
        c1.setNomCategorie("Basket");
        em.persist(c1);
        
        Categorie c2=new Categorie();
        c2.setNomCategorie("lunettes de soleil");
        em.persist(c2);
        
        Produit rayban=new Produit();
        rayban.setCategorie(c2);
        em.persist(rayban);
        
        em.getTransaction().commit();
    }
    
}
