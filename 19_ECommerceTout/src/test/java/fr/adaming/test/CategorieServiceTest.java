package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class CategorieServiceTest {
	// Nécessaire pour faire tourner les tests : catégorie avec un id égal à 1, changer dans les attributs si nécessaire
	
	@Autowired
	private ICategorieService categorieService;
	
	// Tests de getCategorieById
	//@Test
	public void testGetCategorieById(){
		assertEquals(1,categorieService.getCategorieById(1).getId());
	}
	
	//@Test
	public void testGetCategorieById1(){
		assertEquals("Chat",categorieService.getCategorieById(1).getNomCategorie());
	}
	
	//@Test
	public void testGetCategorieById2(){
		assertEquals("Un mignon félin",categorieService.getCategorieById(1).getDescription());
	}
	
	
	// Tests de addCategorie
	
	//@Test
	public void testAddCategorie() {
		assertEquals("Chien", categorieService.getCategorieById(6).getNomCategorie());
	}
	
	//@Test
	public void testAddCategorie1() {
		assertEquals("Le meilleur ami de l'homme", categorieService.getCategorieById(6).getDescription());
	}
	
//	@Test
//	@Transactional
//	@Rollback(true)
	public void testAddCategorie2() {
		Categorie categorie = new Categorie("Chien", "Le meilleur ami de l'homme");
		int taille = categorieService.getAllCategories().size();
		
		categorieService.addCategorie(categorie);
		
		assertEquals(taille+1, categorieService.getAllCategories().size());
	}
	
	
	// Test de getAllCategories
	
	//@Test
	public void testGetAllCategories() {
		
		int resultatAttendu = 4;
		
		assertEquals(resultatAttendu, categorieService.getAllCategories().size());
		
	}
	
	
	// Tests de deleteCategorie
//	@Test
//	@Transactional
//	@Rollback(true)
	public void testDeleteCategorie() {
		
		int taille = categorieService.getAllCategories().size();
		
		Categorie cat = new Categorie();
		cat.setId(2);
		
		categorieService.deleteCategorie(cat);
		
		assertEquals(taille-1, categorieService.getAllCategories().size());
		
	}
	
	

}
